/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.EndlessGame.GameplayScreen;

/**
 *
 * @author Karusu
 */
public class Intersection extends Actor {
    
     private TextureRegion _region;
    
    public Intersection(Texture pImage, int x, int Width) {
        
        _region = new TextureRegion(pImage,0, 0, pImage.getWidth(), pImage.getWidth());        
        setBounds(0, 0, getWidth(), Width);
        setSize(Width, pImage.getHeight());
        setPosition(x, GameplayScreen.getScene().getHeight());
    }

    @Override
    public void act(float delta) {
        
        float newPos = getY() - 120 * delta;
        if(newPos < 480 - getHeight())
            setY(getY());
        else
            setY(newPos);
        toBack();
        
       
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
         //To change body of generated methods, choose Tools | Templates.
        batch.draw(_region,getX(),getY(),getOriginX(),
                getOriginY(),getWidth(),getHeight(),
                getScaleX(),getScaleY(),getRotation());
               
    }
    
    
    
    
    
}