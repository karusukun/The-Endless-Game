/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.gdx.EndlessGame.GameplayScreen;

/**
 *
 * @author Carlos
 */
public class Asteroid extends GameElement{

    private TextureRegion _region;
    
    public Asteroid(Texture pImage) {
        
        _region = new TextureRegion(pImage,0, 0, pImage.getWidth(), pImage.getWidth());
        setSize(pImage.getWidth(), pImage.getHeight());
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(MathUtils.random(0, GameplayScreen.getScene().getWidth()), GameplayScreen.getScene().getHeight());
    }

    @Override
    public void act(float pDelta) {
        try{
            float newPos = getY() - 200 * pDelta;
            if(newPos < 0)
                this.remove();
            setY(newPos);
            toBack();

            rotateBy(0.3f);
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
    public void draw(Batch pBatch, float pParentAlpha) 
    {
        try{
            //To change body of generated methods, choose Tools | Templates.
            pBatch.draw(_region,getX(),getY(),getOriginX(),
                       getOriginY(),getWidth(),getHeight(),
                       getScaleX(),getScaleY(),getRotation());
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    
    
    
    
}
