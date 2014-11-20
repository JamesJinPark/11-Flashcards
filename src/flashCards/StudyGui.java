/**
 * 
 */
package flashCards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author James Park
 */
public class StudyGui extends JFrame {
	
	private static final int CENTER = 0;
	JPanel J1 = new JPanel(new BorderLayout());
	JPanel J2 = new JPanel(new BorderLayout());
	JPanel J3 = new JPanel(new BorderLayout());
	JPanel J4 = new JPanel(new BorderLayout());
	JPanel J5 = new JPanel(new BorderLayout());
	JPanel J6 = new JPanel(new BorderLayout());
	JPanel mainPanel = new JPanel(new BorderLayout());

	JButton loadFileButton = new JButton("Load File");
	JButton saveFileButton = new JButton("Save File");
	JButton quitButton = new JButton("Quit");
	JButton nextButton = new JButton("Next");
	JButton guessButton = new JButton("Answer");
	JButton revealResponseButton = new JButton("Reveal");
	
	JTextField guessTextField = new JTextField(20);
	JLabel stimulusLabel = new JLabel("");
	JLabel responseLabel = new JLabel("");
	JLabel youTypedLabel = new JLabel("");
	JLabel emptyLabel = new JLabel("");
	JLabel emptyLabel2 = new JLabel("");
	
	final StudyList studyList = new StudyList();
	
	public StudyGui() {
		super("FlashCards");
		setSize(500,350);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		stimulusLabel.setFont(new Font("Serif", Font.BOLD, 20));
		responseLabel.setFont(new Font("Serif", Font.BOLD, 16));
		final StudyGui that = this;
		
		loadFileButton.setPreferredSize(new Dimension(100, 33)); 
		J1.add(loadFileButton, BorderLayout.NORTH);
		saveFileButton.setPreferredSize(new Dimension(100, 33));
		J1.add(saveFileButton, BorderLayout.CENTER);	
		quitButton.setPreferredSize(new Dimension(100, 33));
		J1.add(quitButton, BorderLayout.SOUTH);
		J1.setPreferredSize(new Dimension(100,100));
		
		emptyLabel.setPreferredSize(new Dimension(300, 100));
		J2.setPreferredSize(new Dimension(400,100));
		J2.add(J1, BorderLayout.WEST);
		J2.add(emptyLabel, BorderLayout.EAST);
		
		stimulusLabel.setPreferredSize(new Dimension(400, 50));
		guessTextField.setPreferredSize(new Dimension(400, 50));
		stimulusLabel.setHorizontalAlignment(CENTER);
		guessTextField.setHorizontalAlignment(CENTER);
		J3.add(stimulusLabel, BorderLayout.NORTH);
		J3.add(guessTextField, BorderLayout.SOUTH);
		J3.setPreferredSize(new Dimension(400, 100));
		
		guessButton.setPreferredSize(new Dimension(100, 40));
		revealResponseButton.setPreferredSize(new Dimension(100, 40));
		nextButton.setPreferredSize(new Dimension(100, 40));
		J4.setPreferredSize(new Dimension(100, 120));
		J4.add(guessButton, BorderLayout.NORTH);
		J4.add(nextButton, BorderLayout.SOUTH);
		J4.add(revealResponseButton, BorderLayout.CENTER);
		
		responseLabel.setPreferredSize(new Dimension(200, 60));
		youTypedLabel.setPreferredSize(new Dimension(200, 60));
		responseLabel.setHorizontalAlignment(CENTER);
		youTypedLabel.setHorizontalAlignment(CENTER);
		J5.setPreferredSize(new Dimension(200,120));
		J5.add(responseLabel, BorderLayout.NORTH);
		J5.add(youTypedLabel, BorderLayout.SOUTH);
		
		emptyLabel2.setPreferredSize(new Dimension(100,120));
		J6.setPreferredSize(new Dimension (300,120));
		J6.add(J5, BorderLayout.CENTER);
		J6.add(J4, BorderLayout.EAST);
		J6.add(emptyLabel2, BorderLayout.WEST);
		
		mainPanel.setPreferredSize(new Dimension(500,350));
		mainPanel.add(J2,  BorderLayout.NORTH);
		mainPanel.add(J3,  BorderLayout.CENTER);
		mainPanel.add(J6,  BorderLayout.SOUTH);
		
		add(mainPanel); 
	
		
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
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			
		});
	
		quitButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				System.exit(0);
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
					
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			
		});
		saveFileButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				try {
					studyList.save(that);
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
					
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			
		});
	
		guessButton.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {	
			System.out.println("click");
				String guess = guessTextField.getText().trim();
				if (guess != null){
					int timesCorrect = 0;
					Item currentItem = studyList.get();
					if (currentItem != null){
						if (currentItem.getResponse().equals(guess)) {
							timesCorrect += 1;
							System.out.println("correct");
							//correct
							stimulusLabel.setForeground(Color.green);
							youTypedLabel.setText("Correct!  You typed " + "\"" + guess + "\"");
						} else {
							//incorrect
							System.out.println("incorrect");
							stimulusLabel.setForeground(Color.red);
							youTypedLabel.setText("Wrong... You typed " + "\"" + guess + "\"");
						}	
					currentItem.setTimesCorrect(timesCorrect);	
					}
				}
			}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		});
		
		
		nextButton.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
				loadNextItem();
		}
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
				
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}
		});
		
		revealResponseButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (studyList.hasNext()){
					Item currentItem = studyList.get();
					responseLabel.setText(currentItem.getResponse());
			}
			}
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
					
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
			}
		}
		);	
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
			youTypedLabel.setText("");
		}
		else{ 
			studyList.swap();
			youTypedLabel.setText("Great job! You finished the set!");
		}
	}
	
    /**
     * @param args
     */
    public static void main(String[] args) {
        	new StudyGui();
    }  
}