/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;
import logic.VirtualControler;

/**
 *
 * @author Carlos
 */
public class Button extends Actor{
    
    private TextureRegion _button;
    private boolean _touched;
    private int _type;
    
    public Button(Stage scene, int type)
    {
        Texture tempText;
        int posX,posY;
        posX = posY = 0;
        switch(type)
        {
            case 0:
                tempText = Main.MANAGER.get("gameover.png", Texture.class);
                
                break;
            case 1:
                tempText = Main.MANAGER.get("start.png", Texture.class);
                posX = scene.getViewport().getViewportWidth()/ 2 - 100;
                System.out.println(scene.getViewport().getViewportHeight());
                posY = scene.getViewport().getViewportHeight() - 200;
                break;
            case 2:
                tempText = Main.MANAGER.get("quit.png", Texture.class);
                posX = scene.getViewport().getViewportWidth() / 2 - 100;
                posY = scene.getViewport().getViewportHeight() - 400;
                break;
            default:
                tempText = null;
        }
        
        
        _button = new TextureRegion(tempText,0,0,tempText.getWidth(),tempText.getHeight());
        
        setPosition(posX, posY);
        setSize(tempText.getWidth(),tempText.getHeight());
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
