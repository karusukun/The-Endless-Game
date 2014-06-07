/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.genetics;

import Libraries.Weapon;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nicolas
 */
public class WeaponLogic {
   private static WeaponLogic _instance = null;
   ArrayList <Weapon> _LastWeapons;
   
   protected WeaponLogic() {
       _LastWeapons = new ArrayList();
       _LastWeapons.add(Weapon.randomWeapon());
   }
   
   public static WeaponLogic getInstance() {
      if(_instance == null) {
         _instance = new WeaponLogic();
      }
      return _instance;
   }
   
   public Weapon newWeapon(Weapon pLastWeapon){ //Se llama esta funcion unicamente cuando agarra una nueva arma,
                                                //Aqui e agrega una nueva arma a la lista y luego de la lista se escoge
                                                //el padre con el cual cruar el arma actual.
       try{
            addWeaponToList();
            Weapon dadWeapon = GeneticFitness.selectDad(_LastWeapons);
            long sonGenetics = GeneticOperator.crossGenetics(dadWeapon.getBinaryIdentifier(), pLastWeapon.getBinaryIdentifier());
            Weapon sonWeapon = longToWeapon(sonGenetics);

            return sonWeapon;
       }catch(Exception e){
            System.out.println(e.toString());
            return new Weapon(Color.PINK, Math.abs( new Random().nextLong()) );
        }
   }
   
   private void addWeaponToList(){
       try{
            if(this._LastWeapons.size() >= 20){
                this._LastWeapons.remove(0); //Elimina el arma mas vieja, la primera en haber ingresado.
            }
            this._LastWeapons.add(Weapon.randomWeapon());
       }catch(Exception e){
            System.out.println(e.toString());
       }
   }
   
   public static int power(int base, int exp){
        try{
            int result = 1;
            for(int rounds=0; rounds<exp; rounds++){
                result = result*base;
            }

            if(exp == 0)
                return 1;
            return result;
        }catch(Exception e){
            System.out.println(e.toString());
            return 0;
        }
   }
   
   
   public static int number(long binary, int size){
       try{
            int number = 0;
            for(int index = 0; index < size; index++){
                if(binary%2 == 1)
                    number = number + power(2,index);
                binary = binary >>> 1;
            }
            return number;
       }catch(Exception e){
            System.out.println(e.toString());
            return (new Random().nextInt())% size;
        }
   }
   
   
   public static Weapon longToWeapon(long binary){
       try{
            long copy = binary;

            int rango = number(binary, 2);
            binary = binary >>> 2;
            int vertices = number(binary,2);
            binary = binary >>> 2;
            int x1 = number(binary,3);
            binary = binary >>> 3;
            int y1 = number(binary,3);
            binary = binary >>> 3;
            int x2 = number(binary,3);
            binary = binary >>> 3;
            int y2 = number(binary,3);
            binary = binary >>> 3;
            int x3 = number(binary,3);
            binary = binary >>> 3;
            int y3 = number(binary,3);
            binary = binary >>> 3;
            int x4 = number(binary,3);
            binary = binary >>> 3;
            int y4 = number(binary,3);
            binary = binary >>> 3;
            int x5 = number(binary,3);
            binary = binary >>> 3;
            int y5 = number(binary,3);
            binary = binary >>> 3;
            int ancho = number(binary,4);
            binary = binary >>> 4;
            int numColor = number(binary,24);

            Polygon polygon = new Polygon();
            Color color = new Color(numColor);

            Weapon weapon = new Weapon();
            weapon.setLaneRange(rango);
            weapon.setShootingShape(null);
            weapon.setBeamThickness(ancho);
            weapon.setColor(color);
            weapon.setBinaryIdentifier(copy);

            return weapon;   
        }catch(Exception e){
            System.out.println(e.toString());
            return new Weapon(Color.PINK, Math.abs( new Random().nextLong()) );
        }
   }

    public ArrayList<Weapon> getLastWeaponsArray() {
        return _LastWeapons;
    }

    public void setLastWeaponsArray(ArrayList<Weapon> _LastWeapons) {
        this._LastWeapons = _LastWeapons;
    }
   
   
   
   
   
}
