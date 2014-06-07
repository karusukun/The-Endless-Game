/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.InputHandler;

import com.badlogic.gdx.InputAdapter;
import com.gdx.EndlessGame.GameplayScreen;
import logic.VirtualControler;

/**
 *
 * @author Carlos
 */
public class ShipTouchInput extends InputAdapter {
    
    private VirtualControler controler;

    public ShipTouchInput(VirtualControler controler) {
        this.controler = controler;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        
        if(GameplayScreen.getPlayer().isTouched())
        {
            controler.setIsPressed(true);
            controler.setNewX(screenX);
            controler.setNewY(screenY);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
         controler.setFireGun(true);
         return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        controler.setFireGun(false);
        return true;
    }
    
    
}
