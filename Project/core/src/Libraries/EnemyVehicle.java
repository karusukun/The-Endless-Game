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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;

/**
 *
 * @author Carlos
 */
public class EnemyVehicle extends Vehicle {
    
    private int _life;
    
    public EnemyVehicle(Texture pTexture, int x)
    {
        this._type = ElementType.ENEMY_VEHICLE;    
        _life = 3;
        _region = new TextureRegion(pTexture,0,0,pTexture.getWidth(), pTexture.getHeight());
        setSize(50, 50);
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(x , GameplayScreen.getScene().getHeight());
        //setPosition(MathUtils.random(0, GameplayScreen.getScene().getWidth()), GameplayScreen.getScene().getHeight());
        
                  
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void act(float delta) {
        
        float newPos = getY() - 150 * delta;
        if(newPos < 0)
            this.remove();
        if(this._life <= 0)
            this.remove();
        
        setY(newPos);
        
        
       
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
