/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import Libraries.EnemyVehicle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import static com.gdx.EndlessGame.Main.MANAGER;

/**
 *
 * @author Carlos
 */
public class EnemySpawner 
{
    private float _timingSpawning;
    private float _remainingSpawns;
    private Array<Texture> _enemyImgs;
    private Stage _scene;
   
    public EnemySpawner(Stage pScene)
    {
        _timingSpawning = 0;
        _remainingSpawns = 0;
        
        _enemyImgs = new Array<Texture>();
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack1.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack2.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack3.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack4.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack5.png", Texture.class));
        
        _scene = pScene;
    }
    
    public void SpawnEnemy()
    {
        if(_remainingSpawns > 0)
        {
            int enemyX = (int) (((MathUtils.random(40,85) % 3) +1) * 130);
            _scene.addActor(new EnemyVehicle(_enemyImgs.get(MathUtils.random(0,_enemyImgs.size - 1 ) ),enemyX ));
            _remainingSpawns -=1;
        }
    }

    public float getTimingSpawning() {
        return _timingSpawning;
    }

    public float getRemainingSpawns() {
        return _remainingSpawns;
    }

    public void setTimingSpawning(float _timingSpawning) {
        this._timingSpawning = _timingSpawning;
    }

    public void setRemainingSpawns(float _remainingSpawns) {
        this._remainingSpawns = _remainingSpawns;
    }
    
    
    
    
}
