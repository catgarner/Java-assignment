import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	
	private JPanel split;
	
	private JLabel whereToSearch;
	private JFileChooser fc;
	private ArrayList<String> choosenFiles;
	private JTextField typeChoose;;
	private JButton browse;
	private JButton addToList;
	private JPanel choose;
	
	private JTextArea area;
	private JButton clear;
	private JTextField delete;
	private JPanel list;
	
	private JPanel split2;
	
	private JButton endSearch;
	private JPanel finalSearch;
	
	private JLabel extra;
	private JPanel extraPanel;
	
	private JLabel whatToAdd;
	private JTextField suffix;
	private JButton addSuffix;
	private ArrayList<String> listOfSuffixes;
	private JTextArea suffixArea;
	private JPanel suffixes;
	
	
	public MainScreen(String title)
	{
		super(title);
		setSize(500,600);
		setLayout(new FlowLayout());
		
		//Heading
		Hbackground = new JPanel();//Panel for header
		add(Hbackground);
		Hbackground.setBackground(Color.BLUE);
		Hbackground.setPreferredSize(new Dimension(500,50));
		
		heading = new JLabel("My Search Engine");
		Hbackground.add(heading);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		//End heading
		
		//Search for a word
		search = new JPanel();//Panel for searching for a word
		add(search);
		search.setPreferredSize(new Dimension(500,50));
		
		whatToSearch = new JLabel("Search word:   ");
		search.add(whatToSearch);
		whatToSearch.setForeground(Color.BLUE);
		
		searchWord = new JTextField(" Enter your word and press return ");
		search.add(searchWord);
		searchWord.addActionListener(this);
		
		words = new ArrayList<String>();
		//End Search for a word
		
		split = new JPanel();//Panel for header
		add(split);
		split.setBackground(Color.BLACK);
		split.setPreferredSize(new Dimension(500,2));
		
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
		list.setPreferredSize(new Dimension(500,90));
		
		area = new JTextArea("Chosen files are: ");
		list.add(area);
		
		delete = new JTextField("  Enter a file to remove  ");
		list.add(delete);
		
		clear = new JButton("Remove file");
		list.add(clear);
		clear.addActionListener(this);
		
		split2 = new JPanel();
		add(split2);
		split2.setBackground(Color.BLACK);
		split2.setPreferredSize(new Dimension(500,2));
		
		//Final search
		finalSearch = new JPanel();
		add(finalSearch);
		finalSearch.setPreferredSize(new Dimension(500,70));
		
		endSearch = new JButton("Search for key word in selected files");
		finalSearch.add(endSearch);
		endSearch.addActionListener(this);
		
		//Heading
		extraPanel = new JPanel();//Panel for header
		add(extraPanel);
		extraPanel.setBackground(Color.BLACK);
		extraPanel.setPreferredSize(new Dimension(500,30));
		
		extra = new JLabel("Extra Features");
		extraPanel.add(extra);
		extra.setForeground(Color.WHITE);
		//End heading
		
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
			String removeFile = delete.getText();
			for(int i = 0; i < choosenFiles.size(); i++)
			{
				if(removeFile.contains(choosenFiles.get(i)))
				{
					choosenFiles.remove(choosenFiles.get(i));
				}
			}
			area.setText("Chosen files are: ");
			for (String element: choosenFiles)
			{	
				area.append("\n" + element);
			}
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
			HashMap<File, Integer> match = myReader.openFile(choosenFiles, words);
			strongestMatch strongest = new strongestMatch();
			HashMap<File, Integer> strongMatch = strongest.strongestMatch(match);
			
		}
	
		
	}
	
}
