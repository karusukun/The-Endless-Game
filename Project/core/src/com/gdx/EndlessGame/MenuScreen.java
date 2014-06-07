/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame;

import Libraries.Button;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 *
 * @author Carlos
 */
public class MenuScreen extends Pantalla {

    private Button _buttonPlay,_buttonExit;
    private Stage _scene;
    
    public MenuScreen(Main pGame,Stage pScene) {
        super(pGame);
        _scene = pScene;
    }

    @Override
    public void show() {
        
        _buttonPlay = new Button(_scene, 1);
        _buttonExit = new Button(_scene, 2);
        
        _scene.addActor(_buttonPlay);
        _scene.addActor(_buttonExit);
        
         Main.mixer.PlayMenuMusic(true);
          Gdx.input.setInputProcessor(_scene);
    }

    @Override
    public void dispose() {
        
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

    @Override
    public void render(float f) {
        
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        Gdx.gl20.glClearColor(0f, 0f, 0f, 0.5f);
        
        _game.batch.begin();
        
        
        
        _game.batch.end();
        
        _scene.act();
        _scene.draw();
        if(_buttonPlay.isTouched())
        {
            
            _game.setScreen(_game._gameplayScreen);
            _game.getPlayer().GenerateFirstWeapon();
            Main.mixer.StopMenuMusic(false);
        }
        if(_buttonExit.isTouched())
            Gdx.app.exit();
        
    }
    
    
    
    
    
}
