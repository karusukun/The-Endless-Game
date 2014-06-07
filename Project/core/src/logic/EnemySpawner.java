/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import Libraries.EnemyVehicle;
import Libraries.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.gdx.EndlessGame.GameplayScreen;
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
    private Array<EnemyVehicle> _enemies;
   
    public EnemySpawner(Stage pScene, Array<EnemyVehicle> pEnemies)
    {
        _timingSpawning = 0;
        _remainingSpawns = 3;
        
        _enemies = pEnemies;
        
        _enemyImgs = new Array<Texture>();
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack1.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack2.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack3.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack4.png", Texture.class));
        _enemyImgs.add(MANAGER.get("Enemies/enemyBlack5.png", Texture.class));
        
        _scene = pScene;
        _enemies = pEnemies;
    }
    
    public void SpawnEnemy()
    {
        if(_remainingSpawns > 0)
        {
            int offset = 25;
            int enemyX = (int) (((MathUtils.random(40,85) % 5) +1) * (GameplayScreen.getScene().getWidth()/5)) - offset*5;
            //enemyX -= enemyX/2;
            
            EnemyVehicle tempActor = new EnemyVehicle(_enemyImgs.get(MathUtils.random(0,_enemyImgs.size - 1 ) ),enemyX );
            _scene.addActor(tempActor);
            _enemies.add(tempActor);
            tempActor.getbBox().x = tempActor.getX();
            tempActor.getbBox().y = tempActor.getY();
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
