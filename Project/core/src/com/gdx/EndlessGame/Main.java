package com.gdx.EndlessGame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;



public class Main extends Game {
	public SpriteBatch batch;
        public OrthographicCamera camera;
        private int _gameHeight;
        private int _gameWidth;
        public static AssetManager MANAGER;
        
        //Declaracion de las diferentes screens
        public Pantalla _loadingScreen, _menuScreen, _gameplayScreen;
        
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                _gameHeight = Gdx.graphics.getHeight();
                _gameWidth = Gdx.graphics.getWidth();
                camera = new OrthographicCamera(_gameWidth, _gameHeight);
                camera.translate(_gameWidth /2, _gameHeight/2);
                camera.update();
                
                
                MANAGER = new AssetManager();                   
                LoadAssets();
                
                //Creacion de las pantallas
                _loadingScreen = new LoadingScreen(this);
                _menuScreen = new MenuScreen(this);
                _gameplayScreen = new GameplayScreen(this);
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

public void LoadAssets()
{
    //loading basic assets.
    
    MANAGER.load("loading.png", Texture.class);
    MANAGER.load("playerShip2_blue.png", Texture.class);
    MANAGER.load("ufoBlue.png", Texture.class);
    MANAGER.load("ufoGreen.png", Texture.class);
    MANAGER.load("ufoYellow.png", Texture.class);
    MANAGER.load("btnShooting.png", Texture.class);
    
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
