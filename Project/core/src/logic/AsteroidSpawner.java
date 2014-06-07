/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import Libraries.Asteroid;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.gdx.EndlessGame.Main;
import static com.gdx.EndlessGame.Main.MANAGER;

/**
 *
 * @author Carlos
 */
public class AsteroidSpawner {
    
    private float _contadorSpawning;
    private Array<Texture> _asteroidImgs;
    private Stage _scene;
    
    public AsteroidSpawner(Stage pScene)
    {
       _asteroidImgs = new Array<Texture>();
       _contadorSpawning = 0;
       
       //Setting the assetImages to the Array
       _asteroidImgs.add(MANAGER.get("Meteors/meteorBrown_big1.png", Texture.class));
       _asteroidImgs.add(MANAGER.get("Meteors/meteorBrown_big3.png", Texture.class));
       _asteroidImgs.add(MANAGER.get("Meteors/meteorBrown_big4.png", Texture.class));
       _asteroidImgs.add(MANAGER.get("Meteors/meteorBrown_med1.png", Texture.class));
       _asteroidImgs.add(MANAGER.get("Meteors/meteorBrown_small1.png", Texture.class));
       _asteroidImgs.add(MANAGER.get("Meteors/meteorBrown_tiny1.png", Texture.class));
       _scene = pScene;
    }
    
    public void SpawnAsteroid ()
    {
        try{
            _scene.addActor(new Asteroid(_asteroidImgs.get(MathUtils.random(0,_asteroidImgs.size - 1))));
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public float getContadorSpawning() {
        return _contadorSpawning;
    }

    public void setContadorSpawning(float _contadorSpawning) {
        this._contadorSpawning = _contadorSpawning;
    }
    
    
    
}
