package curveflattern;



import javax.swing.JFrame;
import javax.swing.JSlider;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.Hashtable;

public class fancySliderNumber {

	/**
	 * Returns the value that the user selects on the slider to decrease their slope
	 * by.
	 * 
	 * @return
	 */
	

	    public static void main(final String args[]) {
	        Runnable runner = new Runnable() {
	            public void run() {
	                JFrame frame = new JFrame("Sample Sliders");
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                ChangeListener listener = new SliderChangeListener();

	                JSlider js4 = new JSlider(1,5);
	                Hashtable<Integer, JComponent> table = new Hashtable<Integer, JComponent>();
	                table.put(1, new JLabel("1"));
	                table.put(2, new JLabel("2"));
	                table.put(3, new JLabel("3"));
	                table.put(4, new JLabel("4"));
	                table.put(5, new JLabel("5"));
	                js4.setLabelTable(table);
	                js4.setPaintLabels(true);
	                js4.addChangeListener(listener);
	                frame.add(js4, BorderLayout.CENTER);
	                frame.setSize(400, 300);
	                frame.setVisible(true);
	            }
	        };
	        
	        EventQueue.invokeLater(runner);
	    }

	    public static class SliderChangeListener implements ChangeListener {
	        public void stateChanged(ChangeEvent changeEvent) {
	            Object source = changeEvent.getSource();
	            JSlider theJSlider = (JSlider)source;
	            if (!theJSlider.getValueIsAdjusting()) {
	            	int sliderNumber = theJSlider.getValue();	           
	            }
	            	
	        }
			public int getSliderNumber() {
				return getSliderNumber();
			}
	
	
	    }

	


}
