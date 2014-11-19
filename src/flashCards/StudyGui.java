/**
 * 
 */
package flashCards;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author James Park
 */
public class StudyGui extends JFrame {
	
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton b = new JButton("Hello");
	JTextField t = new JTextField("YO YO YO", 20);
	JTextArea ta = new JTextArea("How\n are\n you?", 5, 20);
	JLabel l = new JLabel("Dudeeee what up!");
	String choices[] = {
			"Load", 
			"Save", 
			"Quit"};
	JComboBox menu = new JComboBox(choices);
	
	public StudyGui(){
		super("Flash Cards");
		setSize(800,500);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create components to add to JPanel
		mainPanel.add(b);
		mainPanel.add(t);
		mainPanel.add(ta);
		mainPanel.add(l);
		
		topPanel.setLayout(new GridLayout(0, 10, 1, 0));
		topPanel.add(menu);
		
		//create panels
		//add(topPanel);
		add(mainPanel); 
		//add(bottomPanel);
	}
	
	
	
    /**
     * @param args
     */
    public static void main(String[] args) {
        	new StudyGui();
    }  
}
