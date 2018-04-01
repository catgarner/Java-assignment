import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MainScreen extends JFrame implements ActionListener, MouseListener
{
	private JLabel heading;
	private JPanel Hbackground;
	
	private JLabel whatToSearch;
	private JTextField searchWord;
	private JPanel search;
	
	private JLabel whereToSearch;
	private JTextField chooseText;
	//private JButton browse_files;
	private JFileChooser fc;
	private JPanel choose;
	
	
	ArrayList<String> fileList = new ArrayList<String>();
	
	public MainScreen(String title)
	{
		super(title);
		setSize(500,300);
		setLayout(new FlowLayout());
		
		//Heading
		Hbackground = new JPanel();//Panel for header
		add(Hbackground);
		Hbackground.setBackground(Color.BLACK);
		Hbackground.setPreferredSize(new Dimension(500,30));
		
		heading = new JLabel("My Search Engine");
		Hbackground.add(heading);
		heading.setForeground(Color.WHITE);
		//End heading
		
		
		//Search for a word
		search = new JPanel();//Panel for searching for a word
		add(search);
		search.setPreferredSize(new Dimension(500,40));
		
		whatToSearch = new JLabel("Select word:   ");
		search.add(whatToSearch);
		whatToSearch.setForeground(Color.BLUE);
		
		searchWord = new JTextField("Enter your word and press return");
		search.add(searchWord);
		searchWord.addActionListener(this);
		//End Search for a word
		
		//Choose the texts to search
		choose = new JPanel();//Panel for the texts to search
		add(choose);
		choose.setPreferredSize(new Dimension(500,40));
		
		whereToSearch = new JLabel("Select files:   ");
		choose.add(whereToSearch);
		whereToSearch.setForeground(Color.BLUE);
		
		chooseText = new JTextField("Choose file or files ");
		choose.add(chooseText);
		chooseText.addMouseListener(this);
		
		//browse_files = new JButton("   Browse   ");
		//browse_files.addActionListener(this);
		//choose.add(browse_files);
		//End choose the texts to search
		
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		//Get search word
		String word = searchWord.getText();
		if(arg0.getSource()== searchWord)
		{
			JOptionPane.showMessageDialog(this, "You choose to search for the word: " + word);
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		//Search all files
		if(arg0.getSource()== chooseText)
		{
			Component frame = null;
			fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("DOCX & PDF files", "docx", "pdf");
			fc.setFileFilter(filter);
			fc.setMultiSelectionEnabled(true);
			fc.showOpenDialog(frame);
			File[] choosenFiles = fc.getSelectedFiles();
			JOptionPane.showMessageDialog(this, choosenFiles);
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
	
}
