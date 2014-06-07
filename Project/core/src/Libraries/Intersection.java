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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.EndlessGame.GameplayScreen;

/**
 *
 * @author Karusu
 */
public class Intersection extends Actor {
    
     private TextureRegion _region;
     private Rectangle _bBox;
    
    public Intersection(Texture pImage, int pX, int pWidth) {
        
        _region = new TextureRegion(pImage,0, 0, pImage.getWidth(), pImage.getWidth());        
        setBounds(0, 0, getWidth(), pWidth);
        setSize(pWidth, pImage.getHeight());
        setPosition(pX, GameplayScreen.getScene().getHeight());
        _bBox = new Rectangle(getX(), getY(), pWidth, getHeight());
    }

    @Override
    public void act(float pDelta) {
        try{
            float newPos = getY() - 120 * pDelta;
            if(newPos < GameplayScreen.getScene().getHeight() - getHeight())
            {
                setY(getY());
                _bBox.x = getX();
                _bBox.y = getY();
                _bBox.height = getHeight();
                _bBox.width = getWidth();
            }    
            else
            {
                setY(newPos);
                _bBox.x = getX();
                _bBox.y = getY();
                _bBox.height = getHeight();
                _bBox.width = getWidth();
            }
            toBack();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
       
    }

    @Override
    public Actor hit(float pX, float pY, boolean pTouchable) {
        try{
            return super.hit(pX, pY, pTouchable); //To change body of generated methods, choose Tools | Templates.
        }catch(Exception e){
            System.out.println(e.toString());
            return new Actor();
            // Tal vez deberia retornar null
        }
    }
        
    
    @Override
    public void draw(Batch pBatch, float parentAlpha) 
    {
         //To change body of generated methods, choose Tools | Templates.
        pBatch.draw(_region,getX(),getY(),getOriginX(),
                getOriginY(),getWidth(),getHeight(),
                getScaleX(),getScaleY(),getRotation());
               
    }

    public Rectangle getbBox() {
        return _bBox;
    }
    
    
    
    
    
}
