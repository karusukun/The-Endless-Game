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
        _life = 0;
        this._region = new TextureRegion(pTexture,pTexture.getWidth(), pTexture.getHeight());
        setPosition(x , GameplayScreen.getScene().getHeight());
        setSize(70, 50);
        setBounds(0, 0, getWidth(), getHeight());
                  
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void act(float delta) {
        
        float newPos = getY() - 40 * delta;
        if(newPos < 0)
            this.remove();
        if(this._life <= 0)
            this.remove();
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
