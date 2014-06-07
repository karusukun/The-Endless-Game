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
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;
import logic.VirtualControler;

/**
 *
 * @author Carlos
 */
public class ShootingPad extends Actor {
    
    private TextureRegion _button;
    private boolean _touched;
    private VirtualControler _controler;
    
    public ShootingPad(VirtualControler pControler)
    {
        _controler = pControler;
        _button = new TextureRegion(Main.MANAGER.get("btnShooting.png", Texture.class),0,0,64,64);
        setPosition(GameplayScreen.getScene().getWidth() - 70, GameplayScreen.getScene().getHeight() / 2);
        setSize(64,64);
        _touched = false;
        
        addListener(new InputListener() {
            
             public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) 
             {
                 _touched = true;
                 return false;            
             }
         });
    }

    public boolean isTouched() {
        return _touched;
    }

    public void setTouched(boolean pTouched) {
        this._touched = pTouched;
    }
    

    @Override
    public void draw(Batch pBatch, float pParentAlpha) {
        try{
        pBatch.draw(_button, getX(), getY());
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    
    
}
