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
    private Rectangle _bBox;
    private boolean _shooting;
    private int _remainingShots;
    
    private static final int POS_MODIFIER = 125;
    
    public EnemyVehicle(Texture pTexture, int pX)
    {
        this._type = ElementType.ENEMY_VEHICLE;    
        _life = _remainingShots = 1;
        _shooting = false;
        
        _region = new TextureRegion(pTexture,0,0,pTexture.getWidth(), pTexture.getHeight());
        setSize(50, 50);
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(pX , GameplayScreen.getScene().getHeight());
        _bBox = new Rectangle(getX(),getY(), getWidth(), getHeight());
        
                  
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
    public void act(float pDelta) {
        try{
        float newPos = getY() - POS_MODIFIER * pDelta;                    
        setY(newPos);
        _bBox.x = getX();
        _bBox.y = getY();
        _bBox.height = getHeight();
        _bBox.width = getWidth();
        
        int playerX = (int)(GameplayScreen.getPlayer().getX() + GameplayScreen.getPlayer().getWidth()/2);
        int MyPosLeft = (int) getX();
        int MyposRight = (int) (getX()+ getWidth());
        
        if(playerX >= MyPosLeft && playerX <= MyposRight && _remainingShots > 0 ) 
        {
            _shooting = true;
            _remainingShots -=1;
        }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
        
    
    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        try{
         //To change body of generated methods, choose Tools | Templates.
        batch.draw(_region,getX(),getY(),getOriginX(),
                getOriginY(),getWidth(),getHeight(),
                getScaleX(),getScaleY(),getRotation());
        }catch(Exception e){
            System.out.println(e.toString());
        }
                
    }

    public Rectangle getbBox() {
        return _bBox;
    }

    public int getLife() {
        return _life;
    }

    public void setLife(int _life) {
        this._life = _life;
    }

    public boolean isShooting() {
        return _shooting;
    }

    public void setShooting(boolean _shooting) {
        this._shooting = _shooting;
    }
    
    
    
    
    
    
}
