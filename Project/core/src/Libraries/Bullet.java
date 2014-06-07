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
import com.badlogic.gdx.utils.Array;
import com.gdx.EndlessGame.GameplayScreen;
import static com.gdx.EndlessGame.Main.MANAGER;

/**
 *
 * @author Carlos
 */
public class Bullet extends GameElement{
    
    private TextureRegion _region;
    private int _direction, _indexText;
    private Rectangle _bBox;
    private Array<Texture> _textures;
    private Texture _actualText;
    private int _beamWidth;
    
    public Bullet(int pDirection, int pX, int pY, int pThickness)
    {
        _textures = new Array<Texture>();
        _indexText = 0;
        
        _textures.add(MANAGER.get("Lasers/laserRed01.png", Texture.class));
        _textures.add(MANAGER.get("Lasers/laserRed02.png", Texture.class));
        _textures.add(MANAGER.get("Lasers/laserRed03.png", Texture.class));
        _textures.add(MANAGER.get("Lasers/laserRed04.png", Texture.class));
        _textures.add(MANAGER.get("Lasers/laserRed05.png", Texture.class));
        _textures.add(MANAGER.get("Lasers/laserRed06.png", Texture.class));
        _textures.add(MANAGER.get("Lasers/laserRed07.png", Texture.class));
        
        _actualText = _textures.get(0);
        _beamWidth = (pThickness + 1)*15;
        
        _direction = pDirection;
        _region = new TextureRegion(_actualText,0, 0, _actualText.getWidth(), _beamWidth);
        setSize(_actualText.getWidth(), _actualText.getHeight());
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(pX, pY);
        _bBox = new Rectangle(getX(),getY(), getWidth(), getHeight());
        
    }

    @Override
    public void act(float pDelta) {
        try{
            _indexText++;
            if(_indexText > _textures.size-1)
                _indexText = 0;

            float newPos = getY() + (550* _direction) * pDelta;
            setY(newPos);
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();
            toBack();
            _actualText = _textures.get(_indexText);
            _region = new TextureRegion(_actualText,0, 0, _actualText.getWidth(), _beamWidth);
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
    
    public Rectangle getbBox() {
        return _bBox;
    }
    
    
    
}
