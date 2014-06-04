/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gdx.EndlessGame.Main;

/**
 *
 * @author Carlos
 */
public class PlayerVehicle extends Vehicle 
{
    public PlayerVehicle()
    {
       this._type = ElementType.PLAYER_VEHICLE;
       this._sprite = new Sprite( Main.MANAGER.get("playerShip2_blue.png", Texture.class) );
       this._sprite.setSize(133, 96);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
         //To change body of generated methods, choose Tools | Templates.
        batch.draw(_sprite,getX(),getY(),getOriginX(),
                getOriginY(),getWidth(),getHeight(),
                getScaleX(),getScaleY(),getRotation());
        
        
    }
    
    
}
