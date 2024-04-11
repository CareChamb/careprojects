/*
  Programmer:    Caroline Chamberlain
  Date:     04/07/2024
  Purpose:  This program plays the game tic-tak-toe
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeSwing 
					extends JFrame
					implements ActionListener
{
	//Initiate variables
	private JButton jbtnTicTacToe1 = new JButton(), jbtnTicTacToe2 = new JButton(), jbtnTicTacToe3 = new JButton(),
					jbtnTicTacToe4 = new JButton(), jbtnTicTacToe5 = new JButton(), jbtnTicTacToe6 = new JButton(),
					jbtnTicTacToe7 = new JButton(), jbtnTicTacToe8 = new JButton(), jbtnTicTacToe9 = new JButton(),
					jbtnExit = new JButton("Exit"),
					jbtnReset = new JButton("Reset");
	
	private JLabel lblPlayerX = new JLabel("Player X"),
				   lblPlayerO= new JLabel("Player O");
	
	private JTextField jftPlayerX = new JTextField(20),
					   jftPlayerO= new JTextField(20);
	
	private String sCurrentPlayer = ("X");
	
	//Build Constructor 
	public TicTacToeSwing(String sTitle) {
		super(sTitle);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initiate Main panel
		JPanel jpnlMain = new JPanel(new BorderLayout());
		
		//Initiate Top panel
		JPanel jpnlTop = new JPanel(new GridLayout(1,4));
		
		//Add player labels and text boxes and set color
		jpnlTop.add(lblPlayerX);
		jpnlTop.add(jftPlayerX);
		
		jpnlTop.add(lblPlayerO);
		jpnlTop.add(jftPlayerO);
		
		lblPlayerX.setForeground(Color.red);
		jftPlayerX.setForeground(Color.red);
		
		lblPlayerO.setForeground(Color.green);
		jftPlayerO.setForeground(Color.green);
		
		//Initiate center panel
		JPanel jpnlCenter = new JPanel(new GridLayout(3,3));
		
		//Add game buttons and set color
		jpnlCenter.add(jbtnTicTacToe1);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe1.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe2);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe2.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe3);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe3.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe4);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe4.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe5);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe5.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe6);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe6.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe7);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe7.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe8);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe8.addActionListener(this);
		
		jpnlCenter.add(jbtnTicTacToe9);
		jbtnTicTacToe1.setForeground(Color.black);
		jbtnTicTacToe9.addActionListener(this);
		
		//Initiate bottom panel
		JPanel jpnlBottom = new JPanel(new GridLayout(1,2));
		
		//Add reset button
		jpnlBottom.add(jbtnReset);
		jbtnReset.addActionListener(new resetButton());
		
		//Add exit button
		jpnlBottom.add(jbtnExit);
		jbtnExit.addActionListener(new exitButton());
	
		//Add border panels to main panel
		jpnlMain.add(jpnlTop,	 BorderLayout.NORTH);
		jpnlMain.add(jpnlCenter, BorderLayout.CENTER);
		jpnlMain.add(jpnlBottom, BorderLayout.SOUTH);
		
		//Initiate Container
		Container ca = getContentPane();
	    ca.setBackground(Color.lightGray);
	    ca.add(jpnlMain);
	    setVisible(true);
	    setResizable(false);
	    setLocationRelativeTo(null);
		
	}
	
	//Initiate exit button action handler 
	class exitButton implements ActionListener
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
	    System.exit(0);
	  }
    }
	
	//Initiate reset button action handler 
	class resetButton implements ActionListener
    {
      public void actionPerformed(java.awt.event.ActionEvent e)
      {
    	  //Call clear buttons method 
    	  clearButtons();
    	  sCurrentPlayer = ("X");
	  }
    }
	
	//Initiate tic-tac-toe button action handler 
	public void actionPerformed(ActionEvent e) 
	{
	
		String sActionCommand = e.getActionCommand();
		
		JButton jbtnPressed = (JButton) e.getSource();
		
		//If button not pressed yet set to current player and check for winner
		if (sActionCommand == "") 
		{
			if (sCurrentPlayer == "X" )
			{
				jbtnPressed.setText("X");
				jbtnPressed.setForeground(Color.red);
				sCurrentPlayer = ("O");
			}
			else
			{
				jbtnPressed.setText("O");
				jbtnPressed.setForeground(Color.green);
				sCurrentPlayer = ("X");
			}
			
			if (jbtnTicTacToe1.getText() == "X" && jbtnTicTacToe2.getText() == "X" && jbtnTicTacToe3.getText() == "X" ||
				jbtnTicTacToe1.getText() == "X" && jbtnTicTacToe4.getText() == "X" && jbtnTicTacToe7.getText() == "X" ||
				jbtnTicTacToe1.getText() == "X" && jbtnTicTacToe5.getText() == "X" && jbtnTicTacToe9.getText() == "X" ||
				jbtnTicTacToe4.getText() == "X" && jbtnTicTacToe5.getText() == "X" && jbtnTicTacToe6.getText() == "X" ||
				jbtnTicTacToe7.getText() == "X" && jbtnTicTacToe8.getText() == "X" && jbtnTicTacToe9.getText() == "X" ||
				jbtnTicTacToe7.getText() == "X" && jbtnTicTacToe5.getText() == "X" && jbtnTicTacToe3.getText() == "X" ||
				jbtnTicTacToe2.getText() == "X" && jbtnTicTacToe5.getText() == "X" && jbtnTicTacToe8.getText() == "X" ||
				jbtnTicTacToe3.getText() == "X" && jbtnTicTacToe6.getText() == "X" && jbtnTicTacToe9.getText() == "X") 
			{
				sCurrentPlayer = ("X");
				JOptionPane.showMessageDialog(null,
						"Player X Wins!",
						"Tic-Tac-Toe Winner!",
						JOptionPane.INFORMATION_MESSAGE);
				clearButtons();
			}
			
			else if (jbtnTicTacToe1.getText() == "O" && jbtnTicTacToe2.getText() == "O" && jbtnTicTacToe3.getText() == "O" ||
					 jbtnTicTacToe1.getText() == "O" && jbtnTicTacToe4.getText() == "O" && jbtnTicTacToe7.getText() == "O" ||
					 jbtnTicTacToe1.getText() == "O" && jbtnTicTacToe5.getText() == "O" && jbtnTicTacToe9.getText() == "O" ||
					 jbtnTicTacToe4.getText() == "O" && jbtnTicTacToe5.getText() == "O" && jbtnTicTacToe6.getText() == "O" ||
					 jbtnTicTacToe7.getText() == "O" && jbtnTicTacToe8.getText() == "O" && jbtnTicTacToe9.getText() == "O" ||
					 jbtnTicTacToe7.getText() == "O" && jbtnTicTacToe5.getText() == "O" && jbtnTicTacToe3.getText() == "O" ||
					 jbtnTicTacToe2.getText() == "O" && jbtnTicTacToe5.getText() == "O" && jbtnTicTacToe8.getText() == "O" ||
					 jbtnTicTacToe3.getText() == "O" && jbtnTicTacToe6.getText() == "O" && jbtnTicTacToe9.getText() == "O") 
			{
				sCurrentPlayer = ("X");
				JOptionPane.showMessageDialog(null,
						"Player O Wins!",
						"Tic-Tac-Toe Winner!",
						JOptionPane.INFORMATION_MESSAGE);
				clearButtons();
			}
		
			
			else if (!jbtnTicTacToe1.getText().isEmpty()&&!jbtnTicTacToe2.getText().isEmpty()&&!jbtnTicTacToe3.getText().isEmpty()&&
					 !jbtnTicTacToe4.getText().isEmpty()&&!jbtnTicTacToe5.getText().isEmpty()&&!jbtnTicTacToe6.getText().isEmpty()&&
					 !jbtnTicTacToe7.getText().isEmpty()&&!jbtnTicTacToe8.getText().isEmpty()&&!jbtnTicTacToe9.getText().isEmpty())
			{
				
				JOptionPane.showMessageDialog(null,
						"It's a draw.\nPlay again?",
						"Tic-Tac-Toe Draw",
						JOptionPane.INFORMATION_MESSAGE);
				clearButtons();
			}
		}
	}
	
	//Initiate clear button method
	public void clearButtons() 
	{
	  jbtnTicTacToe1.setText("");
	  jbtnTicTacToe1.setForeground(Color.black);
  	  jbtnTicTacToe2.setText("");
  	  jbtnTicTacToe2.setForeground(Color.black);
  	  jbtnTicTacToe3.setText("");
  	  jbtnTicTacToe3.setForeground(Color.black);
  	  jbtnTicTacToe4.setText("");
  	  jbtnTicTacToe4.setForeground(Color.black);
  	  jbtnTicTacToe5.setText("");
  	  jbtnTicTacToe5.setForeground(Color.black);
  	  jbtnTicTacToe6.setText("");
  	  jbtnTicTacToe1.setForeground(Color.black);
  	  jbtnTicTacToe7.setText("");
  	  jbtnTicTacToe7.setForeground(Color.black);
  	  jbtnTicTacToe8.setText("");
  	  jbtnTicTacToe8.setForeground(Color.black);
  	  jbtnTicTacToe9.setText("");
  	  jbtnTicTacToe9.setForeground(Color.black);
	}
	
	//Main
	public static void main(String[] args) 
	{
		
		TicTacToeSwing winTicTacToeSwing = new TicTacToeSwing("Tic-Tac-Toe");
	}

}
