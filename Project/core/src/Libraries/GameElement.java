/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author Carlos
 */
public abstract class GameElement extends Actor{

    
    
    public TextureRegion getSprite() {
        return _region;
    }

    public ElementType getType() {
        return _type;
    }

    public void setSprite(TextureRegion _textRegion) {
        this._region = _textRegion;
    }

    public void setType(ElementType _type) {
        this._type = _type;
    }
    
    
    
    protected TextureRegion _region;
    protected ElementType _type;
    
}
