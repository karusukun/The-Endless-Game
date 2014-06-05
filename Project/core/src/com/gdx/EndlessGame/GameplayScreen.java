/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame;

import Libraries.Asteroid;
import Libraries.PlayerVehicle;
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
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.EndlessGame.InputHandler.ShipKeyboardInput;
import com.gdx.EndlessGame.InputHandler.ShipTouchInput;
import com.gdx.EndlessGame.UIElements.ShootingPad;
import logic.AsteroidSpawner;
import logic.VirtualControler;

/**
 *
 * @author Carlos
 */
public class GameplayScreen extends Pantalla{

    
    private static Stage _stage;
    private static PlayerVehicle _player;
    private VirtualControler _controler;
    private InputProcessor _keyboardInput, _touchInput;
    private InputMultiplexer _multiplexer;
    
    //Asserts
    private BackgroundAnimation _background;
    private Music _gamePlayMusic;
    private float duracion;
    private static ShootingPad _fireButton;
    private AsteroidSpawner _asteroidSpawn;
            
    public GameplayScreen(Main pGame) {
        super(pGame);
    }

    @Override
    public void show() {
        //Seteando el stage
        duracion = 0;
        
        _stage = new Stage();
        _stage.getViewport().setCamera(_game.camera);
        //Seteando el jugador
        _player = new PlayerVehicle();
        
        //Seteando los actores y los assets
        _fireButton = new ShootingPad();
        _background = new BackgroundAnimation();
        _background.setPosition(0, _stage.getHeight());
    
        _asteroidSpawn = new AsteroidSpawner(_stage);
        
        _gamePlayMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/GameplayM.mp3"));
        _gamePlayMusic.setLooping(true);
        _gamePlayMusic.play();        
        //Agregando actores al stage
        _stage.addActor(_player);
        _stage.addActor(_fireButton);
        _stage.addActor(_background);
        
        //Seteando controladores para la entrada del usuario
        _controler = new VirtualControler();
        _keyboardInput = new ShipKeyboardInput(_controler);
        _touchInput = new ShipTouchInput(_controler);
        _multiplexer = new InputMultiplexer();
        
        //agregando los diferentes tipos de entradas definidas
        _multiplexer.addProcessor(_touchInput);
        _multiplexer.addProcessor(_keyboardInput);
        _multiplexer.addProcessor(_stage);
        Gdx.input.setInputProcessor(_multiplexer);
        
        
       
    }

    @Override
    public void render(float f) {
        
        duracion += f;
        _asteroidSpawn.setContadorSpawning(_asteroidSpawn.getContadorSpawning()+ f);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        Gdx.gl20.glClearColor(1f, 1f, 1f, 0.5f);
        
        TextureRegion frame = _background._background.getKeyFrame(duracion, true);
        _game.batch.begin();
        _game.batch.draw(frame, 0, 0);
        _game.batch.end();
    
        if(_asteroidSpawn.getContadorSpawning() > 4f)
        {
            _asteroidSpawn.SpawnAsteroid();
            _asteroidSpawn.setContadorSpawning(0);
        }
        
        _stage.act(Gdx.graphics.getDeltaTime());
        _stage.draw();
        ProcesarEntrada();
    }

    @Override
    public void dispose() {
       _gamePlayMusic.dispose();
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
            _controler.setIsPressed(false);
            
        }
        
         if(_controler.isDownMovement())
         {
             _player.MoveDown();
             
         }   
        if(_controler.isUpMovement())
        {
            _player.MoveUp();
            
        }
            
        if(_controler.isLeftMovement())
        {
            _player.MoveLeft();
            
        }
        if(_controler.isRightMovement())
        {
            _player.MoveRight();
            
        }if (_controler.isFireGun())
        {
                        
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
