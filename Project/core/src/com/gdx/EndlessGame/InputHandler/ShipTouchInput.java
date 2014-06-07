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
    
    private VirtualControler _controler;

    public ShipTouchInput(VirtualControler pControler) {
        this._controler = pControler;
    }

    //@Override
    
    public boolean touchDragged(int pScreenX, int pScreenY, int pPointer) {
        try{
        if(GameplayScreen.getPlayer().isTouched() && GameplayScreen.getPlayer()._touchdown && GameplayScreen.getFireButton().isTouched() == false)
        {
            GameplayScreen.getPlayer().setDragged(true);
            _controler.setIsPressed(true);
            _controler.setNewX(pScreenX);
            _controler.setNewY(pScreenY);
        }
        return false;
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    @Override
    public boolean touchUp(int pScreenX, int pScreenY, int pPointer, int pButton) {
        try{
            
            
            if(GameplayScreen.getPlayer()._touchdown)
            {
                GameplayScreen.getPlayer().setTouched(false);
                return true;
            }
            else
                return false;
        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean touchDown(int pScreenX, int pScreenY, int pPointer, int pButton) {
        try{
            System.out.println("entre touchdown de Controler");
           if(GameplayScreen.getPlayer()._touchdown)
            {
                GameplayScreen.getPlayer().setTouched(true);
                return true;
            }
            else
                return false;
         }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    
}
