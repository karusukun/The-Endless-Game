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
 * @author Carlos
 */
public class Bullet extends GameElement{
    
      private TextureRegion _region;
    
    public Bullet(Texture pImage) {
        
        _region = new TextureRegion(pImage,0, 0, pImage.getWidth(), pImage.getWidth());
        setSize(pImage.getWidth(), pImage.getHeight());
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(MathUtils.random(0, GameplayScreen.getScene().getWidth()), GameplayScreen.getScene().getHeight());
    }

    @Override
    public void act(float delta) {
           
        float newPos = getY() - 200 * delta;
        if(newPos < 0)
            this.remove();
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
