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

    public void setLeftMovement(boolean pLeftMovement) {
        this._leftMovement = pLeftMovement;
    }

    public void setRightMovement(boolean pRightMovement) {
        this._rightMovement = pRightMovement;
    }

    public void setIsPressed(boolean pIsPressed) {
        this._isPressed = pIsPressed;
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

    public void setUpMovement(boolean pUpMovement) {
        this._upMovement = pUpMovement;
    }

    public void setDownMovement(boolean pDownMovement) {
        this._downMovement = pDownMovement;
    }

    public void setFireGun(boolean pFireGun) {
        this._fireGun = pFireGun;
    }

    public float getNewX() {
        return _newX;
    }

    public float getNewY() {
        return _newY;
    }

    public void setNewX(float pNewX) {
        this._newX = pNewX;
    }

    public void setNewY(float pNewY) {
        this._newY = pNewY;
    }
    
    
    
    
    
}
