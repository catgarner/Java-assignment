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
	private JTextField searchword;
	private JButton clicksearch;
	
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
		
		searchword = new JTextField("Enter search word here");
		add(searchword);
		
		clicksearch = new JButton("Search");
		add(clicksearch);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		
	}
	
}
