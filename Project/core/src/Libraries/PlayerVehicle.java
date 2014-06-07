/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;

/**
 *
 * @author Carlos
 */
public class PlayerVehicle extends Vehicle 
{
    private boolean _touched;
    private Rectangle _bBox;
    
    public PlayerVehicle()
    {
       _touched = false; 
       this._type = ElementType.PLAYER_VEHICLE;
       this._region = new TextureRegion( Main.MANAGER.get("playerShip2_blue.png", Texture.class), 112,75);
       setPosition(380 , 50);
       setSize(50, 50);
       setBounds(0, 0, getWidth(), getHeight());
       setTouchable(Touchable.enabled);
    
       _bBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
       
         addListener(new InputListener() {
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) 
            {
                setTouched(false);
            }

          
             public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) 
             {
                setTouched(true);
                return true;            
             }
         });
       
    }

    @Override
    public void act(float delta) 
    {
        
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
    
    
    
    public void MoveUp()
    {
        float newPos = (this.getY() + 10f);// * Gdx.graphics.getDeltaTime();
        if( newPos + getHeight() >= GameplayScreen.getScene().getHeight())
        {
            setY(getY());
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
        }
        else{
            setY(newPos);
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
        }
            
    }
    
    public void MoveDown()
    {
        float newPos = (this.getY() - 10f);// * Gdx.graphics.getDeltaTime();
        
        if( newPos <= 0 )
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
    }
    
    public void MoveLeft()
    {
         float newPos = (this.getX() - 10f); //* Gdx.graphics.getDeltaTime();
        
        if( newPos <= 0 )
        {
            setX(getX());
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
        }
        else
        {
            setX(newPos);
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
        }
    }
    
    public void MoveRight()
    {
         float newPos = (this.getX() + 10f);// * Gdx.graphics.getDeltaTime();
        
        if( newPos + getWidth() >= GameplayScreen.getScene().getWidth() )
        {
            setX(getX());
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
        }
        else
        {
            setX(newPos);
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
        }
    }

    public boolean isTouched() {
        return _touched;
    }

    public void setTouched(boolean _touched) {
        this._touched = _touched;
    }

    public Rectangle getbBox() {
        return _bBox;
    }
    
    
    
    

}
