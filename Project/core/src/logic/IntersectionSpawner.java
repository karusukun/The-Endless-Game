/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import Libraries.Asteroid;
import Libraries.Intersection;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.gdx.EndlessGame.GameplayScreen;
import static com.gdx.EndlessGame.Main.MANAGER;

/**
 *
 * @author Karusu
 */
public class IntersectionSpawner {
    
    
    private Array<Texture> _IntersecImgs;
    private Stage _scene;
    private float _spawningTime;
    private int _intersecNumber;
    
    public IntersectionSpawner(Stage pScene, int pIntersecNumber)
    {
       _IntersecImgs = new Array<Texture>();
       _spawningTime = 0;
       _intersecNumber = pIntersecNumber; 
       //Setting the assetImages to the Array
       _IntersecImgs.add(MANAGER.get("ufoBlue.png", Texture.class));
       _IntersecImgs.add(MANAGER.get("ufoGreen.png", Texture.class));
       _IntersecImgs.add(MANAGER.get("ufoYellow.png", Texture.class));
       _scene = pScene;
    }
    
    public void SpawnIntersections()
    {
        //
        //_scene.addActor(new Asteroid(_asteroidImgs.get(MathUtils.random(0,_asteroidImgs.size - 1))));
        int offset = 25;
        int interWidth = (GameplayScreen.getScene().getViewport().getViewportWidth()/_intersecNumber) - offset;
        int interX = GameplayScreen.getScene().getViewport().getViewportWidth() - interWidth*_intersecNumber - (offset*_intersecNumber);
        int actualX = interX;
        switch(_intersecNumber)
        {
            
            case 1:
                
               _scene.addActor(new Intersection(_IntersecImgs.get(0), actualX+(offset*_intersecNumber)/2, interWidth));
               break;
                
            case 2:
                _scene.addActor(new Intersection(_IntersecImgs.get(0), actualX+(offset*_intersecNumber)/2, interWidth));
                actualX +=  interX + interWidth; 
                _scene.addActor(new Intersection(_IntersecImgs.get(1), actualX+(offset*_intersecNumber)/2, interWidth));
                
                break;
            case 3:
                _scene.addActor(new Intersection(_IntersecImgs.get(0), actualX+(offset*_intersecNumber)/2, interWidth));
                actualX +=  interX + interWidth; 
                _scene.addActor(new Intersection(_IntersecImgs.get(1), actualX+(offset*_intersecNumber)/2, interWidth));
                actualX +=  interX + interWidth; 
                _scene.addActor(new Intersection(_IntersecImgs.get(2), actualX+(offset*_intersecNumber)/2, interWidth));
                break;
        }
    }

    public float getSpawningTime() {
        return _spawningTime;
    }

    public void setSpawningTime(float _spawningTime) {
        this._spawningTime = _spawningTime;
    }

    
    
}
