/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weapongenetics;

import java.util.Random;

/**
 *
 * @author Nicolas
 */
public class WeaponGenetics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        long dad = 0xF0F0F0F0F0F0F0FL;
        long mom = 0xAAAAAAAAAAAAAAAL;
        
        
        Long son = GeneticOperator.crossGenetics(dad, mom);
        
        
        /*
        final long mask = 0x00000000FFFFFFFFL;
        final long val = Long.MAX_VALUE;
        final long masked = val & mask;
        System.out.println(Long.toBinaryString(masked));
        */
        
    }
    
}
