/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame;

import Libraries.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.EndlessGame.*;
import com.gdx.EndlessGame.InputHandler.*;
import com.gdx.EndlessGame.UIElements.*;
import logic.*;
import logic.genetics.WeaponLogic;

/**
 *
 * @author Carlos
 */
public class GameplayScreen extends Pantalla{

    private Player _user;
    private static Stage _stage;
    private static PlayerVehicle _player;
    private VirtualControler _controler;
    private InputProcessor _keyboardInput, _touchInput;
    private InputMultiplexer _multiplexer;
    private boolean spawnAsteroids = true;
    private boolean spawnEnemies = true;
    private boolean spawnInter = true;
    private boolean gameOver = false;
    private boolean nextStage = false;
    
    //Asserts
    private BackgroundAnimation _background;
    private float duracion;
    private static ShootingPad _fireButton;
    private AsteroidSpawner _asteroidSpawn;
    private EnemySpawner _enemySpawner;
    private IntersectionSpawner _interSpawner;
    private SignAnimation _sign;
    
    //Elements of the game management
    private  Array<EnemyVehicle> _enemies;
    private  Array<Intersection> _intersections;
    private Array<Bullet> _bullets;
    private Array<Weapon> _weapons;
    private Node _graph;
    
    public GameplayScreen(Main pGame, Player pPlayer, Node pGraph) {
        super(pGame);
        //Seteando el stage
        duracion = 0;
        
        _stage = new Stage();
        _stage.getViewport().setCamera(_game.camera);
        _graph = pGraph;
        _user = pPlayer;
        
        
    }

    @Override
    public void show() {
        
        //Seteando el jugador
        _player = new PlayerVehicle();
        //setting Game managements
        _enemies = new Array<EnemyVehicle>();
        _bullets = new Array<Bullet>();
        _intersections = new Array<Intersection>();
        _weapons = new Array<Weapon>();
        
        //Seteando los actores y los assets
        _fireButton = new ShootingPad(_controler);
        _background = new BackgroundAnimation();
        _background.setPosition(0, _stage.getHeight());
        _sign = new SignAnimation(GraphAlgorithms.getInstance().wasNodeVisited(_graph),(int)_user.getPoints(), 
                String.valueOf(_graph.getLevel())+ String.valueOf( _graph.getSeed()));
    
        _asteroidSpawn = new AsteroidSpawner(_stage);
        _enemySpawner = new EnemySpawner(_stage,_enemies);
        
        GraphAlgorithms.getInstance().generateIntersections(_graph);
        
        System.out.println(_graph.getNodesList().size());
        _interSpawner = new IntersectionSpawner(_stage, _graph.getNodesList().size(),GraphAlgorithms.getInstance().getRecommendedPath(_graph),_intersections, _weapons);
            
        //Agregando actores al stage
        _stage.addActor(_player);
        _player.getbBox().x = _player.getX();
        _player.getbBox().y = _player.getY();
        _stage.addActor(_fireButton);
        _stage.addActor(_background);
        _stage.addActor(_sign);
        
        //Seteando controladores para la entrada del usuario
        _controler = new VirtualControler();
        _keyboardInput = new ShipKeyboardInput(_controler);
        _touchInput = new ShipTouchInput(_controler);
        _multiplexer = new InputMultiplexer();
        
        //agregando los diferentes tipos de entradas definidas
        
        _multiplexer.addProcessor(_stage);
        _multiplexer.addProcessor(_touchInput);
        _multiplexer.addProcessor(_keyboardInput);
        
        Gdx.input.setInputProcessor(_multiplexer);
        
        
       
    }

    @Override
    public void render(float f) {
        
        //setear valores importantes
        duracion += f;
        _asteroidSpawn.setContadorSpawning(_asteroidSpawn.getContadorSpawning()+ f);
        _enemySpawner.setTimingSpawning(_enemySpawner.getTimingSpawning() + f);
        _interSpawner.setSpawningTime(_interSpawner.getSpawningTime() + f);
       
        
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        Gdx.gl20.glClearColor(1f, 1f, 1f, 0.5f);
        
        //dibujar background
        TextureRegion frame = _background._background.getKeyFrame(duracion, true);
        _game.batch.begin();
        _game.batch.draw(frame, 0, 0);
        _game.batch.end();
    
        
        if(spawnAsteroids && _asteroidSpawn.getContadorSpawning() > 0.5f)
        {
            _asteroidSpawn.SpawnAsteroid();
            _asteroidSpawn.setContadorSpawning(0);
        }
        
        if(spawnEnemies && _enemySpawner.getTimingSpawning() > 1.5f)
        {
            _enemySpawner.SpawnEnemy();
            _enemySpawner.setTimingSpawning(0);
        }
        if(spawnInter && _interSpawner.getSpawningTime() > 5.0f)
        {
            _interSpawner.SpawnIntersections();
            this.spawnAsteroids = false;
            this.spawnEnemies = false;
            this.spawnInter = false;
        }
        
        _stage.act(Gdx.graphics.getDeltaTime());
        checkLists();
        checkColitions();
        if(gameOver)
        {
            this._game.setScreen(_game._gameOverScreen);
            this.dispose();
        }
        if(nextStage)
        {
            this._game.setScreen(new GameplayScreen(_game, _user, _graph));
        }
        
        _stage.draw();
        ProcesarEntrada();
    }

    @Override
    public void dispose() {
       _stage.dispose();
       _fireButton.remove();
       _background.remove();
       _player.remove();
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void hide() {
       
    }

    @Override
    public void resize(int i, int i1) {
    }
    
    public void ProcesarEntrada()
    {
         if(_controler.isIsPressed() && _player.isTouched())
        {
            _player.setX( _controler.getNewX() - _player.getWidth() / 2);
            _player.setY( (Gdx.graphics.getHeight() - _controler.getNewY()) - _player.getHeight() / 2 );
            _player.getbBox().x = _player.getX();
            _player.getbBox().y = _player.getY();
            _player.getbBox().height = _player.getHeight();
            _player.getbBox().width = _player.getWidth();
            _controler.setIsPressed(false);
            
        }
        if(_controler.isDownMovement()){_player.MoveDown(); }   
        if(_controler.isUpMovement()){_player.MoveUp();}
        if(_controler.isLeftMovement()){_player.MoveLeft();}
        if(_controler.isRightMovement()){_player.MoveRight();}
        if (_controler.isFireGun() || _fireButton.isTouched())
        {
             Bullet bullet = new Bullet(1, (int)_player.getX()+20,(int)_player.getY() + (int)_player.getHeight() + 30, _user.getWeapon().getBeamThickness());
             _bullets.add(bullet);
             _stage.addActor(bullet);
             bullet.getbBox().x = bullet.getX();
             bullet.getbBox().y = bullet.getY();
             _controler.setFireGun(false);
             _fireButton.setTouched(false);
             Main.mixer.PlaySfxLaser();
        }
         
      
    }
    private void checkLists() 
    {
        for(int position = 0; position < _enemies.size ; position++ )
        {
            if(_enemies.get(position).getY() < 0){
                
                _enemies.get(position).remove();
                _enemies.removeIndex(position);
                
            }
            else if(_enemies.get(position).getLife() <= 0){
                
                _enemies.get(position).remove();
                _enemies.removeIndex(position);
                
            }
        }
  
        Bullet bullet;
        for(int position = 0; position < _bullets.size; position++)
        {
            bullet = _bullets.get(position);
            if(bullet.getY() < 0 || bullet.getY() > _stage.getViewport().getViewportHeight())
            {
                bullet.remove();
                _bullets.removeIndex(position);
            }
                
        }    
            
    }
    
    private void checkColitions()
    {
        EnemyVehicle enemy;
        Bullet bullet;
        
                for(int position = 0; position < _weapons.size; position++)
        {
            if(_weapons.get(position).getbBox().overlaps(_player.getbBox()))
            {
                Weapon newWeapon = WeaponLogic.getInstance().newWeapon(_user.getWeapon());
                _user.setWeapon(newWeapon);
                _weapons.get(position).remove();
                _weapons.removeIndex(position);
            }
        }

        
        for(int position = 0; position < _enemies.size; position++)
        {
            enemy = _enemies.get(position);
            if(enemy.isShooting())
                {
                    enemy.setShooting(false);
                    Bullet EnemyBullet = new Bullet(-1, (int)enemy.getX()+20,(int)enemy.getY() - (int)(enemy.getHeight()) - 30, 0);
                    _bullets.add(EnemyBullet);
                    _stage.addActor(EnemyBullet);
                    EnemyBullet.getbBox().x = EnemyBullet.getX();
                    EnemyBullet.getbBox().y = EnemyBullet.getY();
                    Main.mixer.PlaySfxLaser();
                    
                }
            
            if(enemy.getbBox().overlaps(_player.getbBox()))
            {
                
                
                _user.setLifes(_user.getLifes() - 1);
                _enemies.removeIndex(position);
                enemy.remove();
               
                if(_user.getLifes() <= 0)
                    gameOver = true;
            }
            else 
            {
                //colisiones con balas u otros elementos
                
                for(int bulletPos = 0; bulletPos < _bullets.size; bulletPos++)
                {
                    bullet = _bullets.get(bulletPos);
                    if(enemy.getbBox().overlaps(bullet.getbBox()))
                    {
                        enemy.setLife(enemy.getLife() - 1);
                        _bullets.removeIndex(bulletPos);
                        bullet.remove();
                    }
                }
            }
        }
        Intersection inter;
        for(int position = 0; position < _intersections.size; position++)
        {
            if(GraphAlgorithms.getInstance().wasNodeVisited(_graph))
                _user.setPoints(_user.getPoints() + 1);
            else
                _user.setPoints(_user.getPoints() + 3);
            
            inter = _intersections.get(position);
            if(inter.getbBox().overlaps(_player.getbBox())){
                nextStage = true;
                if(_graph.getNodesList().isEmpty())
                    GraphAlgorithms.getInstance().generateIntersections(_graph);
                _graph = _graph.getNodesList().get(position);
                System.out.println(_graph.getSeed());
                Main.mixer.PlaySfxNextStage();
            }
        }
        
        for(int position = 0; position < _bullets.size;position++)
        {
            bullet = _bullets.get(position);
            if(bullet.getbBox().overlaps(_player.getbBox()))
            {
                _user.setLifes(_user.getLifes() - 1);
                if(_user.getLifes() <= 0)
                    gameOver = true;
                _bullets.removeIndex(position);
                bullet.remove();
            }
        }
    
    }
    
    public static Stage getScene()
      { 
          return _stage;
      }

    public static PlayerVehicle getPlayer() {
        return _player;
    }

    public static ShootingPad getFireButton() {
        return _fireButton;
    }


    
    
    
        
}
