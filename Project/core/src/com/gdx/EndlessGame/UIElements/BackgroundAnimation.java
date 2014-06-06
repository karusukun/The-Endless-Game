/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.UIElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;
import static com.gdx.EndlessGame.Main.MANAGER;

/**
 *
 * @author Carlos
 */
public class BackgroundAnimation  extends Actor {
    
     public Animation _background;
     private float _duration;
     private TextureRegion[] _frames;
     
     
     public BackgroundAnimation()
     {
         
         _duration = 0;
         _frames = new TextureRegion[2];
         _frames[0] = new TextureRegion(Main.MANAGER.get("Backgrounds/black.png",Texture.class),0,0,800,480);
         _frames[1] = new TextureRegion(Main.MANAGER.get("Backgrounds/blue.png",Texture.class),0,0,800,480);
         _frames[0].setRegionWidth(GameplayScreen.getScene().getViewport().getViewportWidth());
         _frames[0].setRegionHeight(GameplayScreen.getScene().getViewport().getViewportHeight());
         _frames[1].setRegionWidth(GameplayScreen.getScene().getViewport().getViewportWidth());
         _frames[1].setRegionHeight(GameplayScreen.getScene().getViewport().getViewportHeight());
             
         _background = new Animation(1f,_frames);
         
     }

    @Override
    public void draw(Batch batch, float parentAlpha) {
            
        _duration += Gdx.graphics.getDeltaTime();
        TextureRegion frame = _background.getKeyFrame(_duration, true);
        batch.draw(frame, getX(), getY());
        
    }
    
     
}
