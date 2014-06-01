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
public class GeneticOperator {
    
    private static final int PORCENTAJE_MUTACION = 10;
    
    
    public static long mutateGenetics(long son){
        Random random = new Random();
        if (  Math.abs(random.nextInt() %100) < PORCENTAJE_MUTACION  ){
            
            int power = Math.abs(random.nextInt() %63);
            long bitToChange = 1L;
            bitToChange = bitToChange << power;
            son = son ^ bitToChange;
        }
        return son;
    }
    
    
    public static long crossGenetics(long dad, long mom){
        // 1) Generar el punto variable del cruce (rango entre 1 y 64
        // 2) Borrar las partes de los genes que no se van a considerar por el punto de cruce
        // 3) Sumar los dos genes y retornarlos
        Random random = new Random();
        int puntoCruce = Math.abs((random.nextInt()%64)+1);
        //System.out.println("Papa inicial: "+Long.toBinaryString(dad));
        //System.out.println("Mama inicial: "+Long.toBinaryString(mom));
        //System.out.println("Punto cruce: "+Integer.toString(puntoCruce));
        dad = dad >>> (64-puntoCruce);
        dad = dad <<  (64-puntoCruce);
        
        mom = mom << puntoCruce;
        mom = mom >>> puntoCruce;
        
        long Son = dad | mom;
        //System.out.println(" ");
        //System.out.println("Papa Final: "+Long.toBinaryString(dad));
        //System.out.println("Mama Final: "+Long.toBinaryString(mom));
        //System.out.println("Hijo Final: "+Long.toBinaryString(Son));
        return Son;
        
        
    }
    
    
}
