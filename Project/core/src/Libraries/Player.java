/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Color;

/**
 *
 * @author Carlos
 */
public class Player {
    
    private Player()
    {
        this._lifes = 3;
        this._points = 0;
        this._vehicle = new PlayerVehicle();
        _vehicle.setSpeed(5);
        _vehicle.setRemainingShots(2);
        _vehicle.setActualWeapon(new Weapon(Color.BLACK, (byte)50));
    }
    
    public synchronized static Player getInstance()
    {
        if(_instance == null  )
        {
            _instance = new Player();
        }
        return _instance;
    }

    public int getLifes() {
        return _lifes;
    }

    public long getPoints() {
        return _points;
    }

    public String getName() {
        return _name;
    }

    public PlayerVehicle getVehicle() {
        return _vehicle;
    }

    public void setLifes(int _lifes) {
        this._lifes = _lifes;
    }

    public void setPoints(long _points) {
        this._points = _points;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setVehicle(PlayerVehicle _vehicle) {
        this._vehicle = _vehicle;
    }

    public static void setInstance(Player _instance) {
        Player._instance = _instance;
    }
    
    
    
    int _lifes;
    long _points;
    String _name = "";
    PlayerVehicle _vehicle;
    static Player _instance;
}
