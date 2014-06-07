/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.UIElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;

/**
 *
 * @author Karusu
 */
public class SignAnimation  extends Actor {
    
     private float _duration = 1.0f;
     private TextureRegion _region;
     
     
     public SignAnimation(boolean Visited, int Score, String numeroInter)
     {
         _duration = 0;
         Texture tempText = Main.MANAGER.get("sign.png", Texture.class);
         _region = new TextureRegion(tempText,0,0,tempText.getWidth(),tempText.getHeight());
         setPosition(0, 0);
        
     }

    @Override
    public void act(float delta) {
        _duration -= delta;
            if(_duration < 0)
                this.remove();
    }
     
     

    @Override
    public void draw(Batch pBatch, float pParentAlpha) {
        try
        {
            Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
            pBatch.setColor(1.0f, 1.0f, 1.0f, _duration); 
            
            
            pBatch.draw(_region,getX(),getY(),getOriginX(),
                      getOriginY(),getWidth(),getHeight(),
                      getScaleX(),getScaleY(),getRotation());
            System.out.println("en teoria dibuje :/");
            
            Gdx.gl.glClearColor( 1f, 1f, 1f, 0.5f );
        
                
        }
        catch(Exception e){
            
            System.out.println(e.toString());
        }
    }
    
}
