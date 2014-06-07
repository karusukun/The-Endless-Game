/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.genetics;
import Libraries.Weapon;
import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.graphics.Color;

/**
 *
 * @author Nicolas
 */
public class GeneticFitness {
    
    private static final int PICK_CHANCES = 3;
    
    public static Weapon selectDad(ArrayList<Weapon> candidates){
        try{
            if(candidates.isEmpty()){


                Random random = new Random();
                Weapon weapon = candidates.get(Math.abs( (random.nextInt()) ) % (candidates.size()));        
                int position;
                for(int chances=0; chances<PICK_CHANCES; chances++){
                    position = Math.abs(  (random.nextInt())  ) % (candidates.size());
                    if(weapon.getLaneRange() < candidates.get(position).getLaneRange())
                        weapon = candidates.get(position);
                }
                return weapon;


            }
            System.out.println("Lista vacia, se evito divicion por 0 y se retorno nueva arma");
            return Weapon.randomWeapon(); //Esto en teoria nunca va a pasar. Pero en tal caso esta protegido.
            
        }catch(Exception e){
            System.out.println(e.toString());
            return new Weapon(Color.PINK, Math.abs( new Random().nextLong()) );
        }
    }
    
}
