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
 * @author Karusu
 */
public class GameOverScreen extends Pantalla {

    private float _time;
    
    public GameOverScreen(Main pGame) {
        super(pGame);
        _time = 0;
    }
    
     @Override
    public void show() {
        super.show(); //To change body of generated methods, choose Tools | Templates.
    
    }
    
        @Override
    public void render(float f) {
        
        Gdx.gl.glClearColor( 1f, 1f, 1f, 0.5f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        
        
        
    }

    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        super.resume(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        super.pause(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        super.hide(); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void resize(int i, int i1) {
        super.resize(i, i1); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
}
