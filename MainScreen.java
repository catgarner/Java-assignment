import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class MainScreen extends JFrame implements ActionListener
{
	private JLabel heading;
	private JPanel Hbackground;
	private JTextField searchWord;
	private JButton clickSearch;
	private JPanel search;
	private JTextField chooseText;
	private JButton clickChoose;
	private JPanel choose;
	
	
	public MainScreen(String title)
	{
		super(title);
		setSize(500,300);
		setLayout(new FlowLayout());
		
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
		
		searchWord = new JTextField("Enter search word here");
		search.add(searchWord);
		
		clickSearch = new JButton("Search");
		clickSearch.addActionListener(this);
		search.add(clickSearch);
		
		choose = new JPanel();
		add(choose);
		choose.setPreferredSize(new Dimension(500,40));
		
		chooseText = new JTextField("Enter the text you would like to search");
		choose.add(chooseText);
		
		clickChoose = new JButton("Search");
		clickChoose.addActionListener(this);
		choose.add(clickChoose);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		String text1 = searchWord.getText();
		
		if(arg0.getSource()== clickSearch)
		{
			
			
		}
	}
	
}
