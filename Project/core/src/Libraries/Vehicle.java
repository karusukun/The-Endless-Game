/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Carlos
 */
public abstract class Vehicle extends GameElement {
    
    protected float _speed;
    protected Weapon _actualWeapon;
    protected int _remainingShots;
    

    public float getSpeed() {
        return _speed;
    }

    public Weapon getActualWeapon() {
        return _actualWeapon;
    }

    public int getRemainingShots() {
        return _remainingShots;
    }

    public void setSpeed(float _speed) {
        this._speed = _speed;
    }

    public void setActualWeapon(Weapon _actualWeapon) {
        this._actualWeapon = _actualWeapon;
    }

    public void setRemainingShots(int _remainingShots) {
        this._remainingShots = _remainingShots;
    }
    
    
    
}
