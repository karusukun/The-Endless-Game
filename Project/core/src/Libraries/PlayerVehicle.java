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
import logic.VirtualControler;

/**
 *
 * @author Carlos
 */
public class PlayerVehicle extends Vehicle 
{
    private boolean _touched, _dragged;
    private Rectangle _bBox;
    private VirtualControler _controler;
    public boolean _touchdown;
    
    public PlayerVehicle(VirtualControler pControler)
    {
       _touched = false; 
       _dragged = false;
       _controler = pControler;
       this._type = ElementType.PLAYER_VEHICLE;
       this._region = new TextureRegion( Main.MANAGER.get("playerShip2_blue.png", Texture.class), 112,75);
       System.out.println(GameplayScreen.getScene().getViewport().getViewportWidth()/2);
       setSize(50, 50);
       setBounds(0, 0, getWidth(), getHeight());
       setPosition(GameplayScreen.getScene().getViewport().getViewportWidth()/2 ,30);
       setTouchable(Touchable.enabled);
       _remainingShots = 2;
    
       _bBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
       
         addListener(new InputListener() {
            
             
             
             
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) 
            {
                System.out.println("entro a up");
                setTouched(false);
            }
     
         });
         
          addListener(new InputListener() {
              
          
             public boolean touchDown(InputEvent event, float x, float y, int pPointer, int bButton) 
             {
                 System.out.println("entro a down");
                _touchdown = true;// se deja?
                _touched = true;
                //setTouched(true);
                return false;            
             }
          
          });
          addListener(new InputListener() {
              public boolean touchDragged(int pScreenX, int pScreenY, int pPointer) {
                try{
                if(isTouched() && GameplayScreen.getFireButton().isTouched() == false)
                {
                    System.out.println("entro a dragged");
                    setDragged(true);
                    _controler.setNewX(pScreenX);
                    _controler.setNewY(pScreenY);
                }
                return false;
                }catch(Exception e){
                    System.out.println(e.toString());
                    return false;
                }
            }
          });
       
    }

    @Override
    public void act(float delta) 
    {
        
    }
    
    

    @Override
    public Actor hit(float pX, float pY, boolean pTouchable) {
        try{
            return super.hit(pX, pY, pTouchable); //To change body of generated methods, choose Tools | Templates.
        }catch(Exception e){
            System.out.println(e.toString());
            return null; //new Actor();
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
    
    
    
    public void MoveUp()
    {
        try{
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
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void MoveDown()
    {
        try{
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
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void MoveLeft()
    {
        try{
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
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void MoveRight()
    {
        try{
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
        }catch(Exception e){
            System.out.println(e.toString());
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

    public boolean isDragged() {
        return _dragged;
    }

    public void setDragged(boolean _dragged) {
        this._dragged = _dragged;
    }

    
    
    
    
    

}
