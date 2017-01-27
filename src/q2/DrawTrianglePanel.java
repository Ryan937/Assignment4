package q2;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * <p>This class holds the methods to create the triangle and the 
 * mouse listener.</p>
 * @author Ryan Sungjoo Cha
 * @version 1.0
 */
public class DrawTrianglePanel extends JPanel implements MouseListener,
        MouseMotionListener {

    /**
     * <p>Unique version of this panel.</p>
     */
    private static final long serialVersionUID = -2145259065262323618L;
    
    /**
     * <p>The angle to get 3 points of the triangle.</p>
     */
    private static final int ANGLE = 120;
    
    /**
     * <p>Center point of the triangle.</p>
     */
    private Point point1;
    
    /**
     * <p>The initial corner of the triangle set by dragging the mouse.</p>
     */
    private Point point2;

    /**
     * <p>Constructor to set up the panel and listen for mouse events.</p>
     */
    public DrawTrianglePanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.black);
    }

    /**
     * <p>Draws the triangle with initial position of the mouse pressed and
     * the final position of the mouse.</p>
     * @param g 
     *      Graphics component to draw on
     *      
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // DRAWING CODE HERE
        
        double cos = Math.cos(Math.toRadians(ANGLE));
        double sin = Math.sin(Math.toRadians(ANGLE));
        double cos1 = Math.cos(Math.toRadians(-ANGLE));
        double sin1 = Math.sin(Math.toRadians(-ANGLE));
        
        g.setColor(Color.yellow);
        if (point1 != null && point2 != null) {
            
            Point point3 = new Point((point1.x + (int) ((point2.x - point1.x) 
                    * cos)) - (int) ((point2.y - point1.y) * sin), 
                (point1.y + (int) ((point2.x - point1.x) * sin)) 
                    + (int) ((point2.y - point1.y) * cos));
            Point point4 = new Point((point1.x + (int) ((point2.x - point1.x) 
                    * cos1)) - (int) ((point2.y - point1.y) * sin1), 
                (point1.y + (int) ((point2.x - point1.x) * sin1)) 
                    + (int) ((point2.y - point1.y) * cos1));
            
            g.drawLine(point2.x, point2.y, point3.x, point3.y);
            g.drawLine(point2.x, point2.y, point4.x, point4.y);
            g.drawLine(point3.x, point3.y, point4.x, point4.y);     
        }
        
        System.out.println("Paint called");
    }

    /**
     * <p>Gets the initial position of the mouse being pressed.</p>
     * @param e 
     *      Position of the mouse pressed
     */
    public void mousePressed(MouseEvent e) {
        point1 = e.getPoint();
        System.out.println("Mouse pressed called");
    }

    /**
     * <p>Gets the final position of the mouse when released.</p>
     * @param e 
     *      Position of the mouse released
     */
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released called");
    }

    /**
     * <p>Gets the position while the mouse is still pressed.</p>
     * @param e
     *      Position of the mouse dragged
     */
    public void mouseDragged(MouseEvent e) {
        point2 = e.getPoint();
        repaint();
        System.out.println("Mouse dragged called");
    }

    /** {@inheritDoc} */
    public void mouseEntered(MouseEvent e) {
    }

    /** {@inheritDoc} */
    public void mouseExited(MouseEvent e) {
    }

    /** {@inheritDoc} */
    public void mouseClicked(MouseEvent e) {
    }

    /** {@inheritDoc} */
    public void mouseMoved(MouseEvent e) {
    }

}