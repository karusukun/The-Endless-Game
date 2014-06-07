/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
    
    
    
    public Weapon(Color pColor, long pGen)
    {
        this._binaryIdentifier = pGen;
        this._color = pColor;
        _laneRange = 0;
        _beamThickness = 0;
        _shootingShape = null;
    }
    
    public Weapon(int pLaneRange, Color pColor, int pBeamThickness, Polygon pShape){
        _laneRange = pLaneRange;
        _color = pColor;
        _beamThickness = pBeamThickness;
        _shootingShape = pShape;
        _binaryIdentifier = Long.MIN_VALUE;
    }
    
    public Weapon(){
        
    }
    
    public static Weapon randomWeapon(){
        Random random = new Random();
        long binary = Math.abs(random.nextLong());
        
        Weapon weapon = WeaponLogic.longToWeapon(binary);
        return weapon;
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

    