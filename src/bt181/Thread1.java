/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt181;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khanh-pc
 */
public class Thread1 extends Thread {

    Data data;

    public Thread1(Data data) {
        this.data = data;
    }

    @Override
    public void run() {

        try {
            this.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random rd = new Random();
        String str = "abcdefghijklmnopqwzsxvtr";
        while (true) {

            synchronized (data) {

                char c = str.charAt(rd.nextInt(23));
                System.out.println(c);
                data.setData(c);
                data.notifyAll();
                try {
                    data.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    this.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }
}
