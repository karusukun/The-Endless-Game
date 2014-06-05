/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.UIElements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;

/**
 *
 * @author Carlos
 */
public class ShootingPad extends Actor {
    
    private TextureRegion button;
    
    public ShootingPad()
    {
        
        button = new TextureRegion(Main.MANAGER.get("btnShooting.png", Texture.class),0,0,64,64);
        setPosition(GameplayScreen.getScene().getWidth() - 70, GameplayScreen.getScene().getHeight() / 2);
        setSize(64,64);
        
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        
        batch.draw(button, getX(), getY());
    }
    
    
    
}
