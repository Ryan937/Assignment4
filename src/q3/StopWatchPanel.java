package q3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <p>This class has the panel and the action listeners for StopWatch.java 
 * to use.</p>
 * @author Ryan Sungjoo Cha
 * @version 1.0
 *
 */
public class StopWatchPanel extends JPanel {
    
    /**
     * <p>Unique version of this panel.</p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * <p>Initial timer delay.</p>
     */
    private static final int DELAY = 100;
    
    /**
     * <p>Delay for the timer.</p>
     */
    private int delay = DELAY;
    
    /**
     * <p>Second in the watch.</p>
     */
    private int second;
    
    /**
     * <p>Tenth of a second in the watch.</p>
     */
    private int tenthsecond;
    
    /**
     * <p>Start button for the watch.</p>
     */
    private JButton start;
    
    /**
     * <p>Stop button for the watch.</p>
     */
    private JButton stop;
    
    /**
     * <p>Reset button for the watch.</p>
     */
    private JButton reset;
    
    /**
     * <p>Timer for the watch to use.</p>
     */
    private Timer timer;
    
    /**
     * <p>Shows the timer.</p>
     */
    private JLabel watch;
    
    /**
     * <p>Has the watch label.</p>
     */
    private JPanel watchPanel;
    
    /**
     * <p>Has the buttons.</p>
     */
    private JPanel buttonPanel;
    
    /**
     * <p>Button listener.</p>
     */
    private ActionListener buttons = new ButtonListener();
    
    /**
     * <p>Constructor to set up for the mouse events.</p>
     */
    public StopWatchPanel() {
        
        start = new JButton("Start");
        stop = new JButton("Stop");
        reset = new JButton("Reset");
        
        setLayout(new BorderLayout());
        setBackground(Color.white);
        watchPanel = new JPanel();
        watch = new JLabel("0:0", JLabel.CENTER);
        watchPanel.add(watch);
        
        add(watchPanel, BorderLayout.NORTH);
        buttonPanel = new JPanel();
        
        start.addActionListener(buttons);
        stop.addActionListener(buttons);
        reset.addActionListener(buttons);
        
        buttonPanel.add(start);
        buttonPanel.add(stop);
        buttonPanel.add(reset);
        
        add(buttonPanel, BorderLayout.CENTER);
        timer = new Timer(delay, new TimerListener());  
        
    }
    /**
     * <p>The action listener for the buttons of the watch.</p>
     *
     */
    private class TimerListener implements ActionListener {
        
        /**
         * <p>Changes stopwatch display depending on timer.</p>
         * @param event
         *          timer event
         */
        public void actionPerformed(ActionEvent event) {
            final int tenthsec = 9;
            
            if (tenthsecond < tenthsec) {
                tenthsecond++;
            } else if (tenthsecond == tenthsec) {
                second++;
                tenthsecond = 0;
            }
            watch.setText("" + second + ":" + tenthsecond);
        }
    }
    
    /**
     * <p>The action listener for the buttons of the watch.</p>
     *
     */
    private class ButtonListener implements ActionListener {
        
        /**
         * <p>Listener for the button's actions.</p>
         * @param event
         *          Shows that button is being pushed
         */
        public void actionPerformed(ActionEvent event) {
            
            
            
            if (event.getSource() == start) {
                timer.start();
            }
            if (event.getSource() == stop) {
                timer.stop();
            }
            if (event.getSource() == reset) {
                    timer.stop();
                    second = 0;
                    tenthsecond = 0;
                    watch.setText("0:0");
            }
            watch.setText("" + second + ":" + tenthsecond);
        }
    }
    
}
