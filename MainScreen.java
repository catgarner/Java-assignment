import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MainScreen extends JFrame implements ActionListener
{
	private JLabel heading;
	private JPanel Hbackground;
	private JTextField searchWord;
	private JButton clickSearch;
	private JPanel search;
	private JTextField chooseText;
	private JButton clickChoose;
	private JButton search_files;
	private JFileChooser fc;
	private JButton showAll;
	private JPanel choose;
	private JTextArea area;
	
	ArrayList<String> fileList = new ArrayList<String>();
	
	public MainScreen(String title)
	{
		super(title);
		setSize(500,300);
		setLayout(new FlowLayout());
		
		//Heading
		Hbackground = new JPanel();
		add(Hbackground);
		Hbackground.setBackground(Color.BLACK);
		Hbackground.setPreferredSize(new Dimension(500,30));
		
		heading = new JLabel("My Search Engine");
		Hbackground.add(heading);
		heading.setForeground(Color.WHITE);
		
		search = new JPanel();
		add(search);
		search.setPreferredSize(new Dimension(500,40));
		
		
		//Search for a word
		searchWord = new JTextField("Enter search word here");
		search.add(searchWord);
		
		clickSearch = new JButton("Search");
		clickSearch.addActionListener(this);
		search.add(clickSearch);
		
		choose = new JPanel();
		add(choose);
		choose.setPreferredSize(new Dimension(500,40));
		
		
		//Choose the text to search
		chooseText = new JTextField("Enter the file you would like to search");
		choose.add(chooseText);
		
		search_files = new JButton("Search Files");
		search_files.addActionListener(this);
		choose.add(search_files);
		
		clickChoose = new JButton("Select");
		clickChoose.addActionListener(this);
		choose.add(clickChoose);
		
		showAll = new JButton("Show all");
		showAll.addActionListener(this);
		choose.add(showAll);
		
		area = new JTextArea(" ");
		add(area);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		//Search for filename
		if(arg0.getSource()== search_files)
		{
			fc = new JFileChooser();
			int returnValue = fc.showOpenDialog(null);
			if(returnValue == JFileChooser.APPROVE_OPTION)
			{
				File choosenFile = fc.getSelectedFile();
				chooseText.setText(choosenFile.getName());
			}
		}
		
		//Open file if search is selected
		if(arg0.getSource()== clickChoose)
		{
			String file = chooseText.getText();
			fileList.add(file);
			JOptionPane.showMessageDialog(this, file + " was added"); 
			
			System.out.println(file);
		}
		
		if(arg0.getSource()==showAll)
		{
			for (String element: fileList)
			{
				area.append(element.toString());
			}
		}
	}
	
}
