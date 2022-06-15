/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTLCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author khaia
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    JFrame frame = new JFrame("Test");
    frame.setSize(300, 300);
    JLabel label = new JLabel("This is text!!!");
    frame.add(label);
    frame.setVisible(true);

    final int labelWidth = 300;
    final AtomicInteger labelPadding = new AtomicInteger();
    Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setBorder(new EmptyBorder(0, labelPadding.getAndIncrement() % labelWidth, 0, 0));
        }

            });
    timer.start();
        }
    
}
