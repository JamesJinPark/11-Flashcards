/**
 * 
 */
package flashCards;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author James Park
 */
public class StudyGui extends JFrame {
	
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton loadFileButton = new JButton("Load File...");
	JButton nextButton = new JButton("Next");
	JButton guessButton = new JButton("Guess Response");
	JButton revealResponseButton = new JButton("Reveal Response");
	
	JTextField guessTextField = new JTextField(20);
	JLabel stimulusLabel = new JLabel("Questions");
	JLabel responseLabel = new JLabel("");
	
	String choices[] = {
			"Load", 
			"Save", 
			"Quit"};
	JComboBox dropDownMenu = new JComboBox(choices);
	final StudyList studyList = new StudyList();
	
	public StudyGui() {
		super("Flash Cards");
		setSize(800,500);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stimulusLabel.setFont(new Font("Serif", Font.BOLD, 24));
		responseLabel.setFont(new Font("Serif", Font.BOLD, 24));
		
		
		final StudyGui that = this;

		//create components to add to JPanel
		loadFileButton.addMouseListener(new MouseListener() {
	
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				try {
					studyList.load(that);
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
					
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		guessButton.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {	
			System.out.println("click");
				String guess = guessTextField.getText();
				if (guess != null){
					Item currentItem = studyList.get();
					if (currentItem != null){
						if (currentItem.getResponse().equals(guess)) {
							System.out.println("correct");
							//correct
							stimulusLabel.setForeground(Color.green);
						} else {
							System.out.println("incorrect");
							stimulusLabel.setForeground(Color.red);
						}	
					}
				}
			}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		});
		
		
		nextButton.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {	
				loadNextItem();
				System.out.println(studyList.remaining() + " items remaining");
		}
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
				
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		});
		
		revealResponseButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {	
				Item currentItem = studyList.get();
				responseLabel.setText(currentItem.getResponse());
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
					
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		}
		);
		
		
		mainPanel.add(loadFileButton);
		mainPanel.add(stimulusLabel);
		
		mainPanel.add(guessTextField);
		mainPanel.add(guessButton);
		mainPanel.add(revealResponseButton);
		mainPanel.add(nextButton);
		mainPanel.add(responseLabel);
		
		mainPanel.add(dropDownMenu);
		
//		topPanel.setLayout(new GridLayout(0, 10, 1, 0));
//		topPanel.add(loadFileButton);
		//create panels
		add(topPanel);
		add(mainPanel); 
		//add(bottomPanel);
	}
	
	public void studyListLoaded(){
		System.out.println("Study List Loaded");
		loadNextItem();
	}
	
	private void loadNextItem(){
		if (studyList.hasNext()){
			Item nextItem = studyList.next();
			guessTextField.setText(null);
			stimulusLabel.setText(nextItem.getStimulus());
			stimulusLabel.setForeground(Color.black);
			responseLabel.setText(null);
		}
	}
	
    /**
     * @param args
     */
    public static void main(String[] args) {
        	new StudyGui();
    }  
}
