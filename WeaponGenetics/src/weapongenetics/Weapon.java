/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weapongenetics;

import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author Nicolas
 */
public class Weapon {
    private int _laneRange;
    private Color _color;
    private int _beamThickness;
    private Polygon _ShootingShape;
    
    private Long _binaryIdentifier;
    
    
    public Weapon(int pLaneRange, Color pColor, int pBeamThickness, Polygon pShape){
        _laneRange = pLaneRange;
        _color = pColor;
        _beamThickness = pBeamThickness;
        _ShootingShape = pShape;
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
        return _ShootingShape;
    }

    public void setShootingShape(Polygon _ShootingShape) {
        this._ShootingShape = _ShootingShape;
    }

    public Long getBinaryIdentifier() {
        return _binaryIdentifier;
    }

    public void setBinaryIdentifier(Long _binaryIdentifier) {
        this._binaryIdentifier = _binaryIdentifier;
    }
    
    
}
