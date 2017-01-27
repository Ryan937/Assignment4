package q3;

import javax.swing.JFrame;

/**
 * <p>This is where you put your description about what this class does. You
 * don't have to write an essay but you should describe exactly what it does.
 * Describing it will help you to understand the programming problem better.</p>
 *
 * @author Ryan Sungjoo Cha
 * @version 1.0
 */
public class StopWatch extends JFrame {
        
        /**
        * <p>Unique version of this panel.</p>
        */
        private static final long serialVersionUID = 1L;

        /**
         * <p>Width for the stop watch.</p>
         */
        private static final int INITIAL_WIDTH = 250;
        
        /**
         * <p>Height for the stop watch.</p>
         */
        private static final int INITIAL_HEIGHT = 150;
        
        /**
         * <p>Constructor to create the frame of the watch.</p>
         */
        public StopWatch() {
            super("Ryan Sungjoo Cha");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setContentPane(new StopWatchPanel());
            setSize(INITIAL_WIDTH, INITIAL_HEIGHT); 
            setVisible(true);
        } 
        
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        new StopWatch();
        System.out.println("Question three was called and ran sucessfully.");
    }
}

