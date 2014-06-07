/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import Libraries.Arrow;
import Libraries.Asteroid;
import Libraries.Intersection;
import Libraries.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
    private Texture _arrowText;
    private Stage _scene;
    private float _spawningTime;
    private int _intersecNumber;
    private Array<Intersection> _intersections;
    private int _recommendedPath;
       private Array<Weapon> _weapons;
       private static final int OFFSET = 25; //Margen para que salga centrado
    

    public IntersectionSpawner(Stage pScene, int pIntersecNumber, int recommendedPath, Array<Intersection> pIntersections, Array<Weapon> pWeapons)

    
    
    {
       _intersections = pIntersections;
       _weapons = pWeapons;
        
       _recommendedPath = recommendedPath;
       _IntersecImgs = new Array<Texture>();
       _spawningTime = 0;
       _intersecNumber = pIntersecNumber; 
       //Setting the assetImages to the Array
       _IntersecImgs.add(MANAGER.get("ufoBlue.png", Texture.class));
       _IntersecImgs.add(MANAGER.get("ufoGreen.png", Texture.class));
       _IntersecImgs.add(MANAGER.get("ufoYellow.png", Texture.class));
       _arrowText = MANAGER.get("arrow.png", Texture.class);
       _scene = pScene;
    }
    
    public void SpawnIntersections()
    {

        try{
            int offset = OFFSET;
            int interWidth = (GameplayScreen.getScene().getViewport().getViewportWidth()/_intersecNumber) - offset;
            int interX = GameplayScreen.getScene().getViewport().getViewportWidth() - interWidth*_intersecNumber - (offset*_intersecNumber);
            int actualX = interX;
            Intersection tempActor;
            if(_recommendedPath != -1)
                GenerateArrow(interX, interWidth, _recommendedPath);

            switch(_intersecNumber)
            {

                case 1:
                   tempActor = new Intersection(_IntersecImgs.get(0), actualX+(offset*_intersecNumber)/2, interWidth);
                   _scene.addActor(tempActor);
                   _intersections.add(tempActor);
                   tempActor.getbBox().x = tempActor.getX();
                   tempActor.getbBox().y = tempActor.getY();
                   break;

                case 2:

                    tempActor = new Intersection(_IntersecImgs.get(0), actualX+(offset*_intersecNumber)/2, interWidth);
                    _scene.addActor(tempActor);
                    _intersections.add(tempActor);
                    tempActor.getbBox().x = tempActor.getX();
                    tempActor.getbBox().y = tempActor.getY();
                    actualX +=  interX + interWidth;

                    tempActor = new Intersection(_IntersecImgs.get(1), actualX+(offset*_intersecNumber)/2, interWidth);
                    _scene.addActor(tempActor);
                    _intersections.add(tempActor);
                    tempActor.getbBox().x = tempActor.getX();
                    tempActor.getbBox().y = tempActor.getY();

                    break;
                case 3:

                    tempActor = new Intersection(_IntersecImgs.get(0), actualX+(offset*_intersecNumber)/2, interWidth);
                    _scene.addActor(tempActor);
                    _intersections.add(tempActor);
                    tempActor.getbBox().x = tempActor.getX();
                    tempActor.getbBox().y = tempActor.getY();
                    actualX +=  interX + interWidth; 

                    tempActor = new Intersection(_IntersecImgs.get(1), actualX+(offset*_intersecNumber)/2, interWidth);
                    _scene.addActor(tempActor);
                    _intersections.add(tempActor);
                    tempActor.getbBox().x = tempActor.getX();
                    tempActor.getbBox().y = tempActor.getY();
                    actualX +=  interX + interWidth;

                    tempActor = new Intersection(_IntersecImgs.get(2), actualX+(offset*_intersecNumber)/2, interWidth);
                    _scene.addActor(tempActor);
                    _intersections.add(tempActor);
                    tempActor.getbBox().x = tempActor.getX();
                    tempActor.getbBox().y = tempActor.getY();
                    break;
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public float getSpawningTime() {
        return _spawningTime;
    }

    public void setSpawningTime(float pSpawningTime) {
        this._spawningTime = pSpawningTime;
    }


    private void GenerateWeaponPack()
    {
        Weapon weaponPack = Weapon.randomWeapon();
        _weapons.add(weaponPack);
        _scene.addActor(weaponPack);
        weaponPack.getbBox().x = weaponPack.getX();
        weaponPack.getbBox().y = weaponPack.getY();
        
    }
    

    private void GenerateArrow(int pInterX, int pInterWidth,int pRecommendedPath )
    {
        try{
            int offset = pInterWidth /2;
            if(pRecommendedPath != 0)
                pInterX += pInterX*(pRecommendedPath +1);
            Arrow tmpArrow = new Arrow(_arrowText, pInterX + offset  , GameplayScreen.getScene().getViewport().getViewportHeight() - 180  );
            _scene.addActor(tmpArrow);
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }
    
    
}
