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
    
    private static final int NUMBER_OF_LIVES  = 0;
    
    public Player()
    {
        this._lifes = NUMBER_OF_LIVES;
        this._points = 0;
        
    }
    
    public void GenerateFirstWeapon()
    {
        _weapon = Weapon.randomWeapon();
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

    public void setLifes(int _lifes) {
        this._lifes = _lifes;
    }
    
    

    public void setPoints(long _points) {
        this._points = _points;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public static void setInstance(Player _instance) {
        Player._instance = _instance;
    }

    public Weapon getWeapon() {
        return _weapon;
    }

    public void setWeapon(Weapon _weapon) {
        this._weapon = _weapon;
    }  
    
    private Weapon _weapon;
    private int _lifes;
    private long _points;
    private String _name = "";
    private static Player _instance;
}
