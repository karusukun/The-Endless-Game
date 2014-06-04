/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.math.Rectangle;
/**
 *
 * @author Carlos
 */
public class LoadingScreen extends Pantalla{

    private Texture _loadingIMGText;
    private Sprite  _loadingIMGSpr;
    Rectangle bucket;
    
    public LoadingScreen(Main pGame)
    {
         super(pGame);   
    }

    @Override
    public void show() 
    {
                      
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
    public void render(float f) 
    {
        Gdx.gl.glClearColor( 1f, 1f, 1f, 0.5f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
                
        _game.batch.begin();
        
        if(_game.MANAGER.isLoaded("loading.png"))
        {
            TextureRegion region = new TextureRegion(_game.MANAGER.get("loading.png",Texture.class), 0, 0,_game.getGameWidth(), _game.getGameHeight());
            _loadingIMGSpr = new Sprite(region);
            _loadingIMGSpr.setPosition(0,0);
            _loadingIMGSpr.draw(_game.batch);
        }
        if(_game.MANAGER.update())
        {
            this._game.setScreen(_game._menuScreen);
        }
        _game.batch.end();
    }
    
    
    
    
}
