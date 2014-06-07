/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 *
 * @author Karusu
 */
public class GameOverScreen extends Pantalla {

   private Texture _gameOverIMGText;
    private Sprite  _gameOverSpr;
    private Stage scene;
    private Main _game;
    
    public GameOverScreen (Main pGame)
    {
         super(pGame);  
         scene = new Stage();
         scene.getViewport().setCamera(_game.camera);
    }

    @Override
    public void show() 
    {   
        Main.mixer.PlayGameOverM(true);
                      
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
    public void render(float pF) 
    {
        Gdx.gl.glClearColor( 1f, 1f, 1f, 0.5f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
                
        
        scene.act(Gdx.graphics.getDeltaTime());
        scene.draw();
        
            Texture tempText = _game.MANAGER.get("gameover.png",Texture.class);
            TextureRegion region = new TextureRegion(tempText, 0, 0,tempText.getWidth(),tempText.getHeight());
            _gameOverSpr = new Sprite(region);
            _gameOverSpr.setSize(scene.getWidth(), scene.getHeight());
            _gameOverSpr.setPosition(0,0);
            scene.getBatch().begin();
            _gameOverSpr.draw(scene.getBatch());
            scene.getBatch().end();
        
    }
        
        
}
    
    
    

