/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt181;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khanh-pc
 */
public class Thread2 extends Thread {

    Data data;

    public Thread2(Data data) {
        this.data = data;

    }

    @Override
    public void run() {
        while (true) {

            synchronized (data) {

                data.notifyAll();
                try {
                    data.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }
                int charAscii = (int) data.getData();
                System.out.println((char) (charAscii - 32));
                try {
                    this.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

}
