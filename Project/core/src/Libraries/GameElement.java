/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author Carlos
 */
public abstract class GameElement extends Actor{

    
    
    public Sprite getSprite() {
        return _sprite;
    }

    public ElementType getType() {
        return _type;
    }

    public void setSprite(Sprite _sprite) {
        this._sprite = _sprite;
    }

    public void setType(ElementType _type) {
        this._type = _type;
    }
    
    
    
    protected Sprite _sprite;
    protected ElementType _type;
    
}
