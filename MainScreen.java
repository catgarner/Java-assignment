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
	private ArrayList<String> words;
	private JPanel search;
	
	private JLabel whereToSearch;
	private JFileChooser fc;
	private ArrayList<String> choosenFiles;
	private JTextField typeChoose;;
	private JButton browse;
	private JButton addToList;
	private JPanel choose;
	
	private JTextArea area;
	private JButton clear;
	private JPanel list;
	
	private JButton endSearch;
	private JPanel finalSearch;
	
	private JLabel whatToAdd;
	private JTextField suffix;
	private JButton addSuffix;
	private ArrayList<String> listOfSuffixes;
	private JTextArea suffixArea;
	private JPanel suffixes;
	
	
	public MainScreen(String title)
	{
		super(title);
		setSize(500,500);
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
		
		words = new ArrayList<String>();
		//End Search for a word
		
		//Choose the texts to search
		choose = new JPanel();//Panel for the texts to search
		add(choose);
		choose.setPreferredSize(new Dimension(500,40));
		
		whereToSearch = new JLabel("Select files:   ");
		choose.add(whereToSearch);
		whereToSearch.setForeground(Color.BLUE);
		
		typeChoose = new JTextField("       Enter file or ...     ");
		choose.add(typeChoose);
		typeChoose.addActionListener(this);
		
		browse = new JButton(" Browse ");
		choose.add(browse);
		browse.addActionListener(this);
		
		addToList = new JButton(" Add to list ");
		choose.add(addToList);
		addToList.addActionListener(this);
		
		list = new JPanel();
		add(list);
		list.setPreferredSize(new Dimension(500,40));
		
		area = new JTextArea("Chosen files are: ");
		list.add(area);
		
		clear = new JButton("Clear selected files");
		list.add(clear);
		clear.addActionListener(this);
		
		//Final search
		finalSearch = new JPanel();
		add(finalSearch);
		finalSearch.setPreferredSize(new Dimension(500,50));
		
		endSearch = new JButton("Search for key word in selected files");
		finalSearch.add(endSearch);
		endSearch.addActionListener(this);
		
		//Adding suffixes to the search
		suffixes = new JPanel();
		add(suffixes);
		suffixes.setPreferredSize(new Dimension(500,40));
		
		whatToAdd = new JLabel("Add suffixes:   ");
		suffixes.add(whatToAdd);
		whatToAdd.setForeground(Color.BLUE);
		
		suffix = new JTextField(" Enter a suffix ");
		suffixes.add(suffix);
		suffix.addActionListener(this);
		
		addSuffix = new JButton("Add to list");
		suffixes.add(addSuffix);
		addSuffix.addActionListener(this);
		
		suffixArea = new JTextArea("Chosen suffixes are: \ning \ned \ner");
		add(suffixArea);
		
		setVisible(true);
		
		choosenFiles = new ArrayList<String>();
		listOfSuffixes = new ArrayList<String>();
	}

	public void actionPerformed(ActionEvent arg0) 
	{

		if(arg0.getSource()== addSuffix)
		{
			String newSuffix = suffix.getText();
			listOfSuffixes.add(newSuffix);
			JOptionPane.showMessageDialog(this, newSuffix + " has been added");
			suffixArea.setText("Chosen suffixes are: \ning \ned \ner");
			for (String element: listOfSuffixes)
			{	
				suffixArea.append("\n" + element);
			}
			
		}
		
		//Get search word
		String word = searchWord.getText();
		if(arg0.getSource()== searchWord)
		{
			JOptionPane.showMessageDialog(this, "You choose to search for the word: " + word);
		}
		
		
		//Get files
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
		
		
		//Add chosen file to array 
		if(arg0.getSource()== addToList)
		{
			String filename = typeChoose.getText();
			choosenFiles.add(filename);
			JOptionPane.showMessageDialog(this, filename + " has been added");
			area.setText("Chosen files are: ");
			for (String element: choosenFiles)
			{	
				area.append("\n" + element);
			}
			
		}
		
		if(arg0.getSource()== clear)
		{
			choosenFiles.clear();
			area.setText("Chosen files are: ");
		}
		
		if(arg0.getSource()== endSearch)
		{
			words.clear();
			if(word.endsWith("*"))
			{
				word = word.replace("*", "");
				words.add(word);
				words.add(word + "ing");
				words.add(word + "er");
				words.add(word + "ed");
				for(int i = 0; i < listOfSuffixes.size(); i++)
				{
					words.add(word + listOfSuffixes.get(i));
				}
				
				System.out.println(words);
			}
			else
			{
				words.add(word);
			}
			FileSearch myReader = new FileSearch(choosenFiles, words);
			myReader.openFile(choosenFiles, words);
		}
	
		
	}
	
}
