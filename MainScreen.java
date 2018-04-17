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
import java.util.List;
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
	//Heading
	private JLabel heading;
	private JPanel Hbackground;
	//End heading
	
	//Search word
	private JLabel whatToSearch;
	private JTextField searchWord;
	private ArrayList<String> words;
	private JPanel search;
	//End search word
	
	//Line split
	private JPanel split;
	//End line split
	
	//Choose Files
	private JLabel whereToSearch;
	private JFileChooser fc;
	private ArrayList<String> choosenFiles;
	private JTextField typeChoose;;
	private JButton browse;
	private JButton addToList;
	private JPanel choose;
	//End choose Files
	
	//Show and delete files
	private JTextArea area;
	private JButton clear;
	private JTextField delete;
	private JPanel list;
	//End show and delete files
	
	//Line split
	private JPanel split2;
	//End line split
	
	//Search
	private JButton endSearch;
	private JPanel finalSearch;
	//End search
	
	//Extra features 
	private JLabel extra;
	private JPanel extraPanel;
	//End extra features
	
	//Suffixes
	private JLabel whatToAdd;
	private JTextField suffix;
	private JButton addSuffix;
	private ArrayList<String> listOfSuffixes;
	private JTextArea suffixArea;
	private JPanel suffixes;
	//End suffixes
	
	//Line split
	private JPanel split3;
	//End line split
	
	//Previous words
	private String wildWord = "blank";
	private ArrayList<String> previousWords;
	private JButton viewPrevious;
	private JButton deletePrevious;
	//End previous words
	
	public MainScreen(String title)
	{
		super(title);
		setSize(500,600);
		setLayout(new FlowLayout());
		
		//**Heading**
		//Panel for heading
		Hbackground = new JPanel();
		add(Hbackground);
		Hbackground.setBackground(Color.BLUE);//Setting the background colour
		Hbackground.setPreferredSize(new Dimension(500,50));//Setting the size
		
		//Label for heading
		heading = new JLabel("My Search Engine");
		Hbackground.add(heading);
		heading.setForeground(Color.WHITE);//Setting the writing colour
		heading.setFont(new Font("Times New Roman", Font.BOLD, 30));//Setting the font type, and size
		//**End heading**
		
		//**Search word**
		//Panel for search word
		search = new JPanel();
		add(search);
		search.setPreferredSize(new Dimension(500,50));
		
		//Label for search word
		whatToSearch = new JLabel("Search word:   ");
		search.add(whatToSearch);
		whatToSearch.setForeground(Color.BLUE);
		
		//Text field to get the users search word
		searchWord = new JTextField(" Enter your word and press return ");
		search.add(searchWord);
		searchWord.addActionListener(this);
		
		//An array list for wild card words
		words = new ArrayList<String>();
		//**End Search for a word**
		
		//**Line split**
		split = new JPanel();
		add(split);
		split.setBackground(Color.BLACK);
		split.setPreferredSize(new Dimension(500,2));
		//**End line split**
		
		//**Choose files**
		//Panel for choose files
		choose = new JPanel();
		add(choose);
		choose.setPreferredSize(new Dimension(500,40));
		
		//Label for choose files
		whereToSearch = new JLabel("Select files:   ");
		choose.add(whereToSearch);
		whereToSearch.setForeground(Color.BLUE);
		
		//Text file to get the users input
		typeChoose = new JTextField("       Enter file or ...     ");
		choose.add(typeChoose);
		typeChoose.addActionListener(this);
		
		//Button to allow the user to use a file chooser
		browse = new JButton(" Browse ");
		choose.add(browse);
		browse.addActionListener(this);
		
		//Button to allow the user to add their chosen file to an array
		addToList = new JButton(" Add to list ");
		choose.add(addToList);
		addToList.addActionListener(this);
		//**Choose files**
		
		//**Show and delete files**
		//Panel for showing the files chosen
		list = new JPanel();
		add(list);
		list.setPreferredSize(new Dimension(500,90));
		
		//Text area to display the chosen files
		area = new JTextArea("Chosen files are: ");
		list.add(area);
		
		//Text field to get the users input
		delete = new JTextField("  Enter a file to remove  ");
		list.add(delete);
		
		//Button to remove the chosen file from the array list
		clear = new JButton("Remove file");
		list.add(clear);
		clear.addActionListener(this);
		//**End show and delete files**
		
		//**Line split**
		split2 = new JPanel();
		add(split2);
		split2.setBackground(Color.BLACK);
		split2.setPreferredSize(new Dimension(500,2));
		//**End line split**
		
		//**Search**
		//Panel for search
		finalSearch = new JPanel();
		add(finalSearch);
		finalSearch.setPreferredSize(new Dimension(500,70));
		
		//Button to allow the user to search for the word in the chosen files
		endSearch = new JButton("Search for key word in selected files");
		finalSearch.add(endSearch);
		endSearch.addActionListener(this);
		//**End search**
		
		//**Extra features**
		//Panel for extra features
		extraPanel = new JPanel();
		add(extraPanel);
		extraPanel.setBackground(Color.BLACK);
		extraPanel.setPreferredSize(new Dimension(500,30));
		
		//Label for extra features
		extra = new JLabel("Extra Features");
		extraPanel.add(extra);
		extra.setForeground(Color.WHITE);
		//**End extra features**
		
		//**Suffixes**
		//Panel for suffixes
		suffixes = new JPanel();
		add(suffixes);
		suffixes.setPreferredSize(new Dimension(500,40));
		
		//Label for suffixes
		whatToAdd = new JLabel("Add suffixes:   ");
		suffixes.add(whatToAdd);
		whatToAdd.setForeground(Color.BLUE);
		
		//Text field to get the users input
		suffix = new JTextField(" Enter a suffix ");
		suffixes.add(suffix);
		suffix.addActionListener(this);
		
		//Button to add the user input to the array list
		addSuffix = new JButton("Add to list");
		suffixes.add(addSuffix);
		addSuffix.addActionListener(this);
		
		//Text area to display the chosen suffixes
		suffixArea = new JTextArea("Chosen suffixes are: \ning \ned \ner");
		add(suffixArea);
		//**End Suffixes**
		
		//**Line split**
		split3 = new JPanel();
		add(split3);
		split3.setBackground(Color.BLACK);
		split3.setPreferredSize(new Dimension(500,2));
		//**End Line split**
		
		//**Previous words**
		//Button to view the previous words
		viewPrevious = new JButton("View previous search words");
		add(viewPrevious);
		viewPrevious.addActionListener(this);
		
		//Button to delete the previous words
		deletePrevious = new JButton("Delete previous search words");
		add(deletePrevious);
		deletePrevious.addActionListener(this);
		//**End previous words**
		
		setVisible(true);
		
		//Instantiating the array lists
		choosenFiles = new ArrayList<String>();
		listOfSuffixes = new ArrayList<String>();
		previousWords = new ArrayList<String>();
		
	}

	public void actionPerformed(ActionEvent arg0) 
	{		
		/*
		 *  When a word is entered into the search word text field the word is taken in as a string 
		 * and a message is show on the screen displaying the word that was entered.
		 */
		String word = searchWord.getText();
		if(arg0.getSource()== searchWord)
		{
			JOptionPane.showMessageDialog(this, "You choose to search for the word: " + word);
		}
		
		
		/*
		 * When the browse button is pressed, a file chooser is popped up and it allows the user to choose
		 * a file. The name of this file is then gotten and displayed in the text field.
		 */
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
		
		
		/*
		 * When the add to list button is pressed, the name of the file is gotten from the text field
		 * and saved as a string. This is then put into an array list. A message is then displayed on 
		 * the screen saying the file was added to the list. The contents of the array list is then 
		 * displayed in the text area.
		 */
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
		
		/*
		 * When the user enters a file in the text field that they want to remove from the array list 
		 * and the remove button is clicked the filename is taken and stored as a string. The program
		 * then loops through the chosen files array list and deletes the filename the the user choose.
		 * The remaining filenames in the array list are printed out in the text area.
		 */
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
		
		/*
		 * When the search button is pressed the search word that the user has entered is put into the
		 * previous words array list. The search word is also put into another sting variable. The 
		 * words array list is then cleared. If the search word contains a * at the end of it, meaning
		 * it was a wild card word the * is removed from the end of the word. The words array list is 
		 * then populated with the word and the word with all the suffixes added on to it. A message is 
		 * then displayed showing all of the words in the words array list. If the search word does not 
		 * contain a * then the word is added to the word array list.
		 * 
		 * The chosen files array list and the words array list are sent to the file search class. The 
		 * open file method is called and a return value of a hash map with file and integer variables.
		 * The strongest match method is called and the match hash map and the wild card variable are 
		 * sent to it.
		 */
		if(arg0.getSource()== endSearch)
		{
			previousWords.add(word);
			wildWord = word;
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
				
				JOptionPane.showMessageDialog(this, "Searching for the words: " + words);
			}
			else
			{
				words.add(word);
			}
			
			FileSearch myReader = new FileSearch(choosenFiles, words);
			HashMap<File, Integer> match = myReader.openFile(choosenFiles, words);
			strongestMatch strongest = new strongestMatch();
			strongest.strongestMatch(match, wildWord);
		
		}
		
		/*
		 * When the add suffix button is pressed the text that is written in the text field is saved into 
		 * a string variable. This is then added into the list of suffixes array list. A message is then
		 * displayed saying that the suffix has been added to the list. The list of suffixes is then 
		 * printed in the text area.
		 */
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
		
		/*
		 * When the view previous button is pressed, if the previous words array list is empty then a 
		 * message is displayed saying that the array list is empty. If the array list is not empty
		 * then a message is displayed showing all of the previously searched words.
		 */
		if(arg0.getSource()== viewPrevious)
		{
			if(previousWords.size() == 0)
			{
				JOptionPane.showMessageDialog(this, "There has been no pevious searches");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Pevious words searched are:\n" + previousWords);
			}
			
		}
		
		
		/*
		 * When the delete previous button is pressed the previous words array list is cleared.
		 */
		if(arg0.getSource()== deletePrevious)
		{
			previousWords.clear();
		}
	
		
	}
	
}
