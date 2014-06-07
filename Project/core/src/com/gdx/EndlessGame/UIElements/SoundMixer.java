/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdx.EndlessGame.UIElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 *
 * @author Karusu
 */
public class SoundMixer {
    
    private Sound _laser, _hit, _nextStage;
    private Music _gamePlayMusic, _Gooey, _HeavyEnd, _JailBreak, _LSD,_PMS,_RustySpoons,_Space;
    
    
    public SoundMixer()
    {
        //loading music
        _gamePlayMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/GameplayM.mp3"));
        _Gooey = Gdx.audio.newMusic(Gdx.files.internal("Music/Gooey.mp3"));
        _HeavyEnd = Gdx.audio.newMusic(Gdx.files.internal("Music/Heavy Ending.mp3"));
        _JailBreak = Gdx.audio.newMusic(Gdx.files.internal("Music/Jail Break.mp3"));
        _LSD = Gdx.audio.newMusic(Gdx.files.internal("Music/LSD.mp3"));
        _PMS = Gdx.audio.newMusic(Gdx.files.internal("Music/PMS.mp3"));
        _RustySpoons = Gdx.audio.newMusic(Gdx.files.internal("Music/Rusty Spoons.mp3"));
        _Space = Gdx.audio.newMusic(Gdx.files.internal("Music/Space.mp3"));
        
        //loading sounds
        _laser = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_laser1.ogg"));
        _hit = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_lose.ogg"));
        _nextStage = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_zap.ogg"));
        
          
    }
    
    public void PlayGamePMusic(boolean pIsLooping)
    {
        try{
        _gamePlayMusic.setLooping(pIsLooping);
        _gamePlayMusic.play();  
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void PlayGameOverM(boolean pIsLooping)
    {
        try{
        _Space.setLooping(pIsLooping);
        _Space.play();  
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void PlayMenuMusic(boolean pIsLooping)
    {
        try{
        _PMS.setLooping(pIsLooping);
        _PMS.play();  
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void StopMenuMusic(boolean pIsLooping)
    {
        _PMS.stop();
    }
    
    public void StopGameOverM(boolean pIsLooping)
    {
        this._Space.stop();
    }
    
    public void StopGamePMusic()
    {
        _gamePlayMusic.stop();
    }
    
    public void PlaySfxLaser()
    {
        _laser.play();
    }
    public void PlaySfxHit()
    {
        _hit.play();
    }
    
    public void PlaySfxNextStage()
    {
        _nextStage.play();
    }
}
