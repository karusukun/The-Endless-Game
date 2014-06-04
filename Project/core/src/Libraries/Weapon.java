/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;

/**
 *
 * @author Carlos
 */
class Weapon {
        
    public Weapon(Color pColor, byte pGen)
    {
        this._geneticRepresentation = pGen;
        this._color = pColor;
        _laneRange = 0;
        _beamThickness = 0;
        _shootingShape = null;
    }

    public int getLaneRange() {
        return _laneRange;
    }

    public Color getColor() {
        return _color;
    }

    public int getBeamThickness() {
        return _beamThickness;
    }

    public Polygon getShootingShape() {
        return _shootingShape;
    }

    public byte getGeneticRepresentation() {
        return _geneticRepresentation;
    }    

    public void setLaneRange(int _laneRange) {
        this._laneRange = _laneRange;
    }

    public void setColor(Color _color) {
        this._color = _color;
    }

    public void setBeamThickness(int _beamThickness) {
        this._beamThickness = _beamThickness;
    }

    public void setShootingShape(Polygon _shootingShape) {
        this._shootingShape = _shootingShape;
    }

    public void setGeneticRepresentation(byte _geneticRepresentation) {
        this._geneticRepresentation = _geneticRepresentation;
    }
    
    private int _laneRange;
    private Color _color;
    private int _beamThickness;
    private Polygon _shootingShape;
    private byte _geneticRepresentation;
    
}
