/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 *
 * @author Carlos
 */
public class MenuScreen extends Pantalla {

    public MenuScreen(Main pGame) {
        super(pGame);
    }

    @Override
    public void show() {
        
         Main.mixer.PlayGamePMusic(true);
         _game.setScreen(_game._gameplayScreen);
         _game.getPlayer().GenerateFirstWeapon();
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
        
       
    }
    
    
    
    
    
}
