package com.gdx.EndlessGame;

import Libraries.Node;
import Libraries.Player;
import com.badlogic.gdx.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gdx.EndlessGame.UIElements.SoundMixer;
import logic.GraphAlgorithms;



public class Main extends Game {
	
    public static SpriteBatch batch;
        public static OrthographicCamera camera;
        private int _gameHeight;
        private int _gameWidth;
        private Stage _scene;
        public static AssetManager MANAGER;
        public static SoundMixer mixer;
        private Node _graph;
       
        private Player _player;
        
        
        //Declaracion de las diferentes screens
        public Pantalla _loadingScreen, _menuScreen, _gameplayScreen, _gameOverScreen;
        
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                mixer = new SoundMixer();
                _scene = new Stage();
                _gameHeight = Gdx.graphics.getHeight();
                _gameWidth = Gdx.graphics.getWidth();
                camera = new OrthographicCamera(_gameWidth, _gameHeight);
                camera.translate(_gameWidth /2, _gameHeight/2);
                camera.update();
                _scene.getViewport().setCamera(camera);
                
                //Grafo
                _graph = GraphAlgorithms.getInstance().getInitialNode();
                
                //Creacion de las pantallas
                _loadingScreen = new LoadingScreen(this);
                _menuScreen = new MenuScreen(this, _scene);
                _player = new Player();
                _gameplayScreen = new GameplayScreen(this, _player, _graph);
                _gameOverScreen = new GameOverScreen(this);
                
                MANAGER = new AssetManager();                   
                LoadAssets();
                
                
                //Setting first screen
                setScreen(_loadingScreen);
                
	}

    public int getGameHeight() {
        return _gameHeight;
    }

    public int getGameWidth() {
        return _gameWidth;
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void dispose() {
        
        MANAGER.dispose();
        batch.dispose();
    } 

    public Player getPlayer() {
        return _player;
    }
    
    

public void LoadAssets()
{
    //loading basic assets.
    
    MANAGER.load("loading.png", Texture.class);
    MANAGER.load("playerShip2_blue.png", Texture.class);
    MANAGER.load("ufoBlue.png", Texture.class);
    MANAGER.load("ufoGreen.png", Texture.class);
    MANAGER.load("ufoYellow.png", Texture.class);
    MANAGER.load("btnShooting.png", Texture.class);
    MANAGER.load("arrow.png", Texture.class);
    MANAGER.load("Power-ups/bolt_silver.png",Texture.class);
    MANAGER.load("Power-ups/bolt_bronze.png",Texture.class);
    MANAGER.load("Power-ups/bolt_gold.png",Texture.class);
    MANAGER.load("sign.png", Texture.class);
    MANAGER.load("gameover.png",Texture.class);
    MANAGER.load("quit.png",Texture.class);
    MANAGER.load("start.png",Texture.class);
    
    //loading misc
    MANAGER.load("Meteors/meteorBrown_big1.png", Texture.class);
    MANAGER.load("Meteors/meteorBrown_big3.png", Texture.class);
    MANAGER.load("Meteors/meteorBrown_big4.png", Texture.class);
    MANAGER.load("Meteors/meteorBrown_med1.png", Texture.class);
    MANAGER.load("Meteors/meteorBrown_small1.png", Texture.class);
    MANAGER.load("Meteors/meteorBrown_tiny1.png", Texture.class);
    
    //loading enemyshots
    MANAGER.load("Lasers/laserRed01.png",Texture.class);
    MANAGER.load("Lasers/laserRed02.png",Texture.class);
    MANAGER.load("Lasers/laserRed03.png",Texture.class);
    MANAGER.load("Lasers/laserRed04.png",Texture.class);
    MANAGER.load("Lasers/laserRed05.png",Texture.class);
    MANAGER.load("Lasers/laserRed06.png",Texture.class);
    MANAGER.load("Lasers/laserRed07.png",Texture.class);
    MANAGER.load("Lasers/laserRed08.png",Texture.class);
    MANAGER.load("Lasers/laserRed09.png",Texture.class);
    MANAGER.load("Lasers/laserRed10.png",Texture.class);
    MANAGER.load("Lasers/laserRed11.png",Texture.class);
    MANAGER.load("Lasers/laserRed12.png",Texture.class);
    MANAGER.load("Lasers/laserRed13.png",Texture.class);
    MANAGER.load("Lasers/laserRed14.png",Texture.class);
    MANAGER.load("Lasers/laserRed15.png",Texture.class);
    MANAGER.load("Lasers/laserRed16.png",Texture.class);
    
    //loading Enemies
    MANAGER.load("Enemies/enemyBlack1.png", Texture.class);
    MANAGER.load("Enemies/enemyBlack2.png", Texture.class);
    MANAGER.load("Enemies/enemyBlack3.png", Texture.class);
    MANAGER.load("Enemies/enemyBlack4.png", Texture.class);
    MANAGER.load("Enemies/enemyBlack5.png", Texture.class);

    //loading GuiElements
    MANAGER.load("UI/playerLife2_blue.png",Texture.class);
    
    MANAGER.load("UI/numeral0.png",Texture.class);
    MANAGER.load("UI/numeral1.png",Texture.class);
    MANAGER.load("UI/numeral2.png",Texture.class);
    MANAGER.load("UI/numeral3.png",Texture.class);
    MANAGER.load("UI/numeral4.png",Texture.class);
    MANAGER.load("UI/numeral5.png",Texture.class);
    MANAGER.load("UI/numeral6.png",Texture.class);
    MANAGER.load("UI/numeral7.png",Texture.class);
    MANAGER.load("UI/numeral8.png",Texture.class);
    MANAGER.load("UI/numeral9.png",Texture.class);

    //loading MUSIC
    
    MANAGER.load("Music/GameplayM.mp3",Music.class);
    MANAGER.load("Music/Gooey.mp3",Music.class);
    MANAGER.load("Music/Heavy Ending.mp3",Music.class);
    MANAGER.load("Music/Jail Break.mp3",Music.class);
    MANAGER.load("Music/LSD.mp3",Music.class);
    MANAGER.load("Music/PMS.mp3",Music.class);
    MANAGER.load("Music/Rusty Spoons.mp3",Music.class);
    MANAGER.load("Music/Space.mp3",Music.class);
    
    //loading Sound
    
    MANAGER.load("sounds/sfx_laser1.ogg",Sound.class);
    MANAGER.load("sounds/sfx_laser2.ogg",Sound.class);
    MANAGER.load("sounds/sfx_lose.ogg",Sound.class);
    MANAGER.load("sounds/sfx_shieldDown.ogg",Sound.class);
    MANAGER.load("sounds/sfx_shieldUp.ogg",Sound.class);
    MANAGER.load("sounds/sfx_twoTone.ogg",Sound.class);
    MANAGER.load("sounds/sfx_zap.ogg",Sound.class);

    //loading Background
    MANAGER.load("Backgrounds/black.png",Texture.class);
    MANAGER.load("Backgrounds/blue.png",Texture.class);
    MANAGER.load("Backgrounds/darkPurple.png",Texture.class);
    MANAGER.load("Backgrounds/purple.png",Texture.class);
}   
        
}
