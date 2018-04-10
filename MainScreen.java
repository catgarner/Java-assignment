import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MainScreen extends JFrame implements ActionListener
{
	private JLabel heading;
	private JPanel Hbackground;
	
	private JLabel whatToSearch;
	private JTextField searchWord;
	private JPanel search;
	
	private JLabel whereToSearch;
	private JFileChooser fc;
	private ArrayList<String> choosenFiles;
	private JTextField typeChoose;;
	private JButton browse;
	private JButton addToList;
	private JButton show;
	private JPanel choose;
	
	private JTextArea area;
	
	private JButton endSearch;
	private JPanel finalSearch;
	
	
	
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
		
		searchWord = new JTextField(" Enter your word and press return ");
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
		
		typeChoose = new JTextField("     Enter file or ...   ");
		choose.add(typeChoose);
		typeChoose.addActionListener(this);
		
		browse = new JButton("Browse");
		choose.add(browse);
		browse.addActionListener(this);
		
		addToList = new JButton("Add to list");
		choose.add(addToList);
		addToList.addActionListener(this);
		
		show = new JButton("Show");
		choose.add(show);
		show.addActionListener(this);
		
		area = new JTextArea("");
		add(area);
		
		//Final search
		finalSearch = new JPanel();
		add(finalSearch);
		finalSearch.setPreferredSize(new Dimension(500,40));
		
		endSearch = new JButton("Search for key word in selected files");
		finalSearch.add(endSearch);
		endSearch.addActionListener(this);
		
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
		
		choosenFiles = new ArrayList<String>();
		if(arg0.getSource()== browse)
		{
			Component frame = null;
			fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
			fc.setFileFilter(filter);
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnV = fc.showOpenDialog(frame);
			
			
			if(returnV == JFileChooser.APPROVE_OPTION)
			{
				File selected = fc.getSelectedFile();
				typeChoose.setText(selected.getName());
			}
			
			
		}
		
		if(arg0.getSource()== addToList)
		{
			String file = typeChoose.getText();
			choosenFiles.add(file);
			JOptionPane.showMessageDialog(this, file + " has been added");
		}
		
		
		if(arg0.getSource()== show)
		{
			for (String element: choosenFiles)
			{	
				area.append(element.toString());
			}
		}
		
		/*if(arg0.getSource()== endSearch)
		{
			FileSearch myReader = new FileSearch();
			myReader.openFile(choosenFiles);
			String line = myReader.scanFile();
			label1.setText(line);
			
			String filename = "names.txt";
			myReader.openFile(filename);
			myReader.writeText(firstName, surName);
		}*/
	
		
	}
	
}
