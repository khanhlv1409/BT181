/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt181;

/**
 *
 * @author khanh-pc
 */
public class BT181 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Data data = new Data();
        Thread1 thread1 = new Thread1(data);
        Thread2 thread2 = new Thread2(data);
        thread1.start();
        thread2.start();
        long start = System.currentTimeMillis();
    }

}
