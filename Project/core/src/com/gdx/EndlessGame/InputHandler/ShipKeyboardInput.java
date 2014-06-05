/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.InputHandler;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import logic.VirtualControler;

/**
 *
 * @author Carlos
 */
public class ShipKeyboardInput extends InputAdapter{

        private VirtualControler controler;

    public ShipKeyboardInput(VirtualControler controler) {
        this.controler = controler;
    }

    @Override
    public boolean keyUp(int keycode) {
        
        switch(keycode)
        {
            case Input.Keys.LEFT:
              
                controler.setLeftMovement(false);
                return true;
            case Input.Keys.RIGHT:
                
                controler.setRightMovement(false);
                return true;
            case Input.Keys.UP:
                
                    controler.setUpMovement(false);
                return true;
            case Input.Keys.DOWN:
                
                    controler.setDownMovement(false);
                return true;
            case Input.Keys.SPACE:
                controler.setFireGun(false);
                return true;
            default:
                return false;
                    
                
        }
        
    }
    
    

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode)
        {
            case Input.Keys.LEFT:
                if(!controler.isRightMovement())
                    controler.setLeftMovement(true);
                return true;
            case Input.Keys.RIGHT:
                if(!controler.isLeftMovement())
                    controler.setRightMovement(true);
                return true;
            case Input.Keys.UP:
                if(!controler.isDownMovement())
                    controler.setUpMovement(true);
                return true;
            case Input.Keys.DOWN:
                if(!controler.isUpMovement())
                    controler.setDownMovement(true);
                return true;
            case Input.Keys.SPACE:
                controler.setFireGun(true);
                return true;
            default:
                return false;
                    
                
        }
    
    }
            
}
