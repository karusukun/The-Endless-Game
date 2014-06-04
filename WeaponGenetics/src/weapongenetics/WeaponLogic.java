/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weapongenetics;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class WeaponLogic {
   private static WeaponLogic instance = null;
   ArrayList <Weapon> _LastWeapons;
   
   protected WeaponLogic() {
       _LastWeapons = new ArrayList();
       _LastWeapons.add(Weapon.randomWeapon());
   }
   
   public static WeaponLogic getInstance() {
      if(instance == null) {
         instance = new WeaponLogic();
      }
      return instance;
   }
   
   public Weapon newWeapon(Weapon pLastWeapon){ //Se llama esta funcion unicamente cuando agarra una nueva arma,
                                                //Aqui e agrega una nueva arma a la lista y luego de la lista se escoge
                                                //el padre con el cual cruar el arma actual.
       addWeaponToList();
       Weapon dadWeapon = GeneticFitness.selectDad(_LastWeapons);
       long sonGenetics = GeneticOperator.crossGenetics(dadWeapon.getBinaryIdentifier(), pLastWeapon.getBinaryIdentifier());
       Weapon sonWeapon = longToWeapon(sonGenetics);
       
       return sonWeapon;
   }
   
   private void addWeaponToList(){
       if(this._LastWeapons.size() >= 20){
           this._LastWeapons.remove(0); //Elimina el arma mas vieja, la primera en haber ingresado.
       }
       this._LastWeapons.add(Weapon.randomWeapon());
   }
   
   public static int power(int base, int exp){
       int result = 1;
       
       for(int rounds=0; rounds<exp; rounds++){
           result = result*base;
       }
       
       if(exp == 0)
           return 1;
       
       return result;
   }
   
   
   public static int number(long binary, int size){
       int number = 0;
       for(int index = 0; index < size; index++){
           if(binary%2 == 1)
               number = number + power(2,index);
           binary = binary >>> 1;
       }
       return number;
   }
   
   
   public static Weapon longToWeapon(long binary){
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
       polygon.addPoint(x1, y1);
       polygon.addPoint(x2, y2);
       polygon.addPoint(x3, y3);
       if(vertices == 4)
           polygon.addPoint(x4, y4);
       if(vertices == 5){
           polygon.addPoint(x4, y4);
           polygon.addPoint(x5, y5);
       }
       
       Color color = new Color(numColor);
       
       Weapon weapon = new Weapon();
       weapon.setLaneRange(rango);
       weapon.setShootingShape(polygon);
       weapon.setBeamThickness(ancho);
       weapon.setColor(color);
       weapon.setBinaryIdentifier(copy);
       
       return weapon;
       
   }

    public ArrayList<Weapon> getLastWeaponsArray() {
        return _LastWeapons;
    }

    public void setLastWeaponsArray(ArrayList<Weapon> _LastWeapons) {
        this._LastWeapons = _LastWeapons;
    }
   
   
   
   
   
}
