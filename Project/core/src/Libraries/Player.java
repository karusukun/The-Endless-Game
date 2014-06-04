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
    
    int _lifes;
    long _points;
    String _name = "";
    PlayerVehicle _vehicle;
    static Player _instance;
}
