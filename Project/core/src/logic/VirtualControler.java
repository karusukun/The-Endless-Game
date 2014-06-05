/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author Carlos
 */
public class VirtualControler {
    
    private boolean _leftMovement;
    private boolean _rightMovement;
    private boolean _upMovement;
    private boolean _downMovement;
    private boolean _fireGun;
    private boolean _isPressed;
    
    private float _newX;
    private float _newY;

    public boolean isLeftMovement() {
        return _leftMovement;
    }

    public boolean isRightMovement() {
        return _rightMovement;
    }

    public boolean isIsPressed() {
        return _isPressed;
    }

    public void setLeftMovement(boolean _leftMovement) {
        this._leftMovement = _leftMovement;
    }

    public void setRightMovement(boolean _rightMovement) {
        this._rightMovement = _rightMovement;
    }

    public void setIsPressed(boolean _isPressed) {
        this._isPressed = _isPressed;
    }

    public boolean isUpMovement() {
        return _upMovement;
    }

    public boolean isDownMovement() {
        return _downMovement;
    }

    public boolean isFireGun() {
        return _fireGun;
    }

    public void setUpMovement(boolean _upMovement) {
        this._upMovement = _upMovement;
    }

    public void setDownMovement(boolean _downMovement) {
        this._downMovement = _downMovement;
    }

    public void setFireGun(boolean _fireGun) {
        this._fireGun = _fireGun;
    }

    public float getNewX() {
        return _newX;
    }

    public float getNewY() {
        return _newY;
    }

    public void setNewX(float _newX) {
        this._newX = _newX;
    }

    public void setNewY(float _newY) {
        this._newY = _newY;
    }
    
    
    
    
    
}
