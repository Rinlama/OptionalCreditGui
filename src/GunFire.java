
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sun.audio.*;

public class GunFire extends JFrame {
    int bulletX=155;
    int bulletY=300;
  Timer tm ;
    private int turnup=7;
     int turndown=7;
    JButton fireButton;
    JButton Refill;
    AudioStream as;
    GunFire() {
        
        try {
            setLayout(new BorderLayout());
            
            Panel flow = new Panel(new FlowLayout());
            flow.add(new Button("hello"));
            
            
            
            
            tm = new Timer(100 ,new TimeListener());
            
            
            add(new draw(), BorderLayout.CENTER);
            
            fireButton= new JButton("FIRE");
            Refill= new JButton("REFILL");
            fireButton.addActionListener(new TimeListener());
            Refill.addActionListener(new TimeListener());
            
            
            
            add(new buttonPanel(),BorderLayout.SOUTH);
            
            InputStream in = null;
            
            in = new FileInputStream("fire.wav");
            as = new AudioStream(in);
        } catch (IOException ex) {
            Logger.getLogger(GunFire.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
    }

    public static void main(String[] args) {
        JFrame jmove = new GunFire();
        jmove.setTitle("Gun Fire");
        jmove.setSize(400, 400);
        jmove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jmove.setLocationRelativeTo(jmove);
        jmove.setVisible(true);
      
  


    }

   class buttonPanel extends JPanel{

        public buttonPanel() {
            add(fireButton);
            add(Refill);
            
        }
       
    }
    
    class draw extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw background
            g.setColor(new Color(178,223,224));
            g.fillRect(0,0,400, 400);
            //draw image    
            //draw paddle
            g.setColor(Color.DARK_GRAY);
            g.fillRect(150, 250, 50, 100);
         //   g.fillRect(100, 250, 100, 300);
            //draw the ball
            g.setColor(Color.black);
            g.fillOval(bulletX, bulletY, 30, 30);
          
            

        }

    }

  

   class TimeListener implements ActionListener {
       
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("FIRE")) {
                AudioPlayer.player.start(as);
                tm.start();
                bulletY=0;
                repaint();
                tm.stop();
               
                
            }if(e.getActionCommand().equals("REFILL")) {
                tm.start();
                bulletY=-100;
                repaint();
                tm.stop();
                AudioPlayer.player.stop(as);
               
            }
           
        }
    }
   
  


}
