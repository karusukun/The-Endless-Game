/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.UIElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.EndlessGame.GameplayScreen;
import com.gdx.EndlessGame.Main;

/**
 *
 * @author Karusu
 */
public class SignAnimation  extends Actor {
    
     private float _duration = 1.0f;
     private TextureRegion _region;
     private boolean _draw;
     private Color _FontColor;
     private BitmapFont _font;
     private String _display;
     
     public SignAnimation( boolean Visited, int Score, String numeroInter)
     {
         
         _draw = true;
         if(Visited)
             _FontColor = Color.GREEN;
         else
             _FontColor = Color.YELLOW;
         Texture tempText = Main.MANAGER.get("sign.png", Texture.class);
         _display = "Score: "+Score+ " Inter "+ numeroInter; 
         _font = new BitmapFont();
         _font.setColor(_FontColor);
         _font.setScale(0.6f);
         _region = new TextureRegion(tempText,0,0,tempText.getWidth(),tempText.getHeight());
         setPosition(0, 0);
        
     }

    @Override
    public void act(float delta) {
        _duration -= delta;
            if(_duration < 0)
            {    
                this.remove();
                this._draw = false;
            }
    }
     
     

    @Override
    public void draw(Batch pBatch, float pParentAlpha) {
        try
        {
            
            pBatch.draw(_region,getX(),getY(),getOriginX(),
                      getOriginY(),getWidth(),getHeight(),
                      getScaleX(),getScaleY(),getRotation());
            System.out.println("post draw");
                
        }
        catch(Exception e){
            
            System.out.println(e.toString());
        }
    }

    public float getDuration() {
        return _duration;
    }

    public TextureRegion getRegion() {
        return _region;
    }

    public void setDuration(float _duration) {
        this._duration = _duration;
    }

    public void setRegion(TextureRegion _region) {
        this._region = _region;
    }

    public boolean isDraw() {
        return _draw;
    }

    public void setDraw(boolean _draw) {
        this._draw = _draw;
    }

    public Color getFontColor() {
        return _FontColor;
    }

    public BitmapFont getFont() {
        return _font;
    }

    public String getDisplay() {
        return _display;
    }

    public void setFontColor(Color _FontColor) {
        this._FontColor = _FontColor;
    }

    public void setFont(BitmapFont _font) {
        this._font = _font;
    }

    public void setDisplay(String _display) {
        this._display = _display;
    }
    
    
    
    
    
}
