package drawpaneltest;

import java.awt.Graphics; 
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
   // draws an X from the corners of the panel
   public void paintComponent(Graphics g)
   {
      // call paintComponent to ensure the panel displays correctly
      super.paintComponent(g);
      
      int width = getWidth(); // total width   
      int height = getHeight(); // total height

      // draw a line from the upper-left to the lower-right
      g.drawLine(1, 1, width, height);
      
      // draw a line from the lower-left to the upper-right
      g.drawLine(1, height, width, 1);
   } 
} // end class DrawPanel