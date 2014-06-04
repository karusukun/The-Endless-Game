/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Carlos
 */
public class Sign extends GameElement{
    
    private Color _color;
    private Texture _publicity;
    
    public Sign(Color pColor,Texture pPublicity, Sprite pSprite)
    {
        
        this._color = pColor;
        this._publicity = pPublicity;
        this._sprite = pSprite;
        this._type = ElementType.SIGN;
       
    }

    public Color getColor() {
        return _color;
    }

    public Texture getPublicity() {
        return _publicity;
    }

    public void setColor(Color _color) {
        this._color = _color;
    }

    public void setPublicity(Texture _publicity) {
        this._publicity = _publicity;
    }
    
    
    
}
