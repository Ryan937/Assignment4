package q2;

import javax.swing.JFrame;

/**
 * <p>This class has the frame to draw an equilateral triangle using a rubber 
 * banding technique.</p>
 * @author Ryan Sungjoo Cha
 * @version 1.0
 */
public class DrawTriangle extends JFrame {
    
    /**
     * <p>Unique version of this panel.</p>
     */
    private static final long serialVersionUID = -4851157907519514875L;
    
    /**
     * <p>The initial size of the panel.</p>
     */
    private static final int INITIAL_SIZE = 400;

    /**
     * <p>Constructor for creating and displaying the application frmae.</p>
     */
    public DrawTriangle() {
        super("Ryan Sungjoo Cha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawTrianglePanel());
        setSize(INITIAL_SIZE, INITIAL_SIZE); 
        setVisible(true);
    }

    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * @param args 
     *          Unused
     */
    public static void main(String[] args) {
        new DrawTriangle();
    }

};
