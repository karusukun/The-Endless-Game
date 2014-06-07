/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.gdx.EndlessGame.GameplayScreen;
import static com.gdx.EndlessGame.Main.MANAGER;
import java.util.Random;
import logic.genetics.WeaponLogic;

/**
 *
 * @author Nicolas
 */
public class Weapon extends GameElement {
    private int _laneRange;
    private Color _color;
    private int _beamThickness;
    private Polygon _shootingShape;
    private long _binaryIdentifier;
    private Rectangle _bBox;
    private Array<Texture> _images;
    private int _indexImgs;
    private float _transTime = 0;
    
    
    
    public Weapon(Color pColor, long pGen)
    {
        _images = new Array<Texture>();
        _images.add(new Texture(("Power-ups/bolt_silver.png")));
        _images.add(new Texture(("Power-ups/bolt_bronze.png")));
        _images.add(new Texture(("Power-ups/bolt_gold.png")));
        _region = new TextureRegion(_images.get(0), 0, 0, _images.get(0).getWidth(), _images.get(0).getHeight());
        setSize(50, 50);
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(MathUtils.random(80, GameplayScreen.getScene().getWidth() - 80), GameplayScreen.getScene().getHeight() - 150 );
        _bBox = new Rectangle(getX(),getY(), getWidth(), getHeight());
        _indexImgs = 0;
        
        this._binaryIdentifier = pGen;
        this._color = pColor;
        _laneRange = 0;
        _beamThickness = 0;
        _shootingShape = null;
    }
    
    public Weapon(int pLaneRange, Color pColor, int pBeamThickness, Polygon pShape){
        
        _images = new Array<Texture>();
        _images.add(new Texture(("Power-ups/bolt_silver.png")));
        _images.add(new Texture(("Power-ups/bolt_bronze.png")));
        _images.add(new Texture(("Power-ups/bolt_gold.png")));
        _region = new TextureRegion(_images.get(0), 0, 0, _images.get(0).getWidth(), _images.get(0).getHeight());
        setSize(50, 50);
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(MathUtils.random(80, GameplayScreen.getScene().getWidth() - 80), GameplayScreen.getScene().getHeight() - 150 );
        _bBox = new Rectangle(getX(),getY(), getWidth(), getHeight());
        _indexImgs = 0;
        
        _laneRange = pLaneRange;
        _color = pColor;
        _beamThickness = pBeamThickness;
        _shootingShape = pShape;
        _binaryIdentifier = Long.MIN_VALUE;
    }
    
    public Weapon(){
        
        _images = new Array<Texture>();
        _images.add(new Texture(("Power-ups/bolt_silver.png")));
        _images.add(new Texture(("Power-ups/bolt_bronze.png")));
        _images.add(new Texture(("Power-ups/bolt_gold.png")));
        _region = new TextureRegion(_images.get(0), 0, 0, _images.get(0).getWidth(), _images.get(0).getHeight());
        setSize(40, 40);
        setBounds(0, 0, getWidth(), getHeight());
        setPosition(MathUtils.random(80, GameplayScreen.getScene().getWidth() - 80), GameplayScreen.getScene().getHeight() - 150 );
        _bBox = new Rectangle(getX(),getY(), getWidth(), getHeight());
        _indexImgs = 0;
    }
    
    public static Weapon randomWeapon(){
        Random random = new Random();
        long binary = Math.abs(random.nextLong());
        
        Weapon weapon = WeaponLogic.longToWeapon(binary);
        return weapon;
    }
    
    
    @Override
    public void act(float pDelta) {
        try{
            _indexImgs++;
            _transTime += pDelta;
            if(_indexImgs > _images.size -1)
            {    
                _indexImgs = 0;
            }
            if(_transTime > 0.5f)
            {
                _region = new TextureRegion(_images.get(_indexImgs), 0, 0, _images.get(_indexImgs).getWidth(), _images.get(_indexImgs).getHeight());
                _transTime = 0;
            }
            
            _bBox.x = getX();
            _bBox.y = getY();
            _bBox.height = getHeight();
            _bBox.width = getWidth();

            

        }catch(Exception e){
            System.out.println(e.toString() + " weapon act" );
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
            System.out.println(e.toString()+" weapon draw");
        }
                
    }
    
    

    public int getLaneRange() {
        return _laneRange;
    }

    public void setLaneRange(int _laneRange) {
        this._laneRange = _laneRange;
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color _color) {
        this._color = _color;
    }

    public int getBeamThickness() {
        return _beamThickness;
    }
    
    public Rectangle getbBox() {
        return _bBox;
    }

    public void setBeamThickness(int _beamThickness) {
        this._beamThickness = _beamThickness;
    }

    public Polygon getShootingShape() {
        return _shootingShape;
    }

    public void setShootingShape(Polygon _ShootingShape) {
        this._shootingShape = _ShootingShape;
    }

    public Long getBinaryIdentifier() {
        return _binaryIdentifier;
    }

    public void setBinaryIdentifier(Long _binaryIdentifier) {
        this._binaryIdentifier = _binaryIdentifier;
    }
    
    
}

    