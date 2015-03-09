package OptCredit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

public class DrawGraphics {

    BouncingBox box1;

    public DrawGraphics() {
        box1 = new BouncingBox(10, 10, Color.RED);
        box1.setMovementVector(10, 10);

    }

    public void draw(Graphics g) {

        g.setColor(new Color(178, 223, 224));
        g.fillRect(0, 0, 400, 400);

        g.setColor(Color.black);
        box1.draw(g);
    
        

    }
   
}

   

