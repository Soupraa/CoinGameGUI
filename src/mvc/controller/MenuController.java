package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MenuController implements ActionListener {
	private GameEngine engine;	
		
	public MenuController(GameEngine gameEngine) {
		this.engine = gameEngine;		
	}
//	public void addPlayer() {
//		JOptionPane.showConfirmDialog(null, message, "Add Player", JOptionPane.OK_CANCEL_OPTION);	
//	}
	//Returns true if field is empty
	private boolean isPlayerFieldNull() 
	{
		return playerId.getText().isEmpty() && playerId.getText() == null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JTextField playerId = new JTextField();
		JTextField playerName = new JTextField();
		JTextField initialPoints = new JTextField();
		Object[] message = {
			    "Enter Player ID", playerId,
			    "Enter Player name", playerName,
			    "Enter inital Points", initialPoints
			};	
		JOptionPane.showConfirmDialog(null, message, "Add Player", JOptionPane.OK_CANCEL_OPTION);
		//Display the dialog box
		//addPlayer();
		/*
		 * Algorithm:
		 * Check values
		 * If not null
		 * 	create a new player
		 * 		add the player to game engine.
		 */
		if(!isPlayerFieldNull()) 
		{
			System.out.println(playerId.getText());
			System.out.println(initialPoints.getText());
		Player player = new SimplePlayer(strPlayerId, strPlayerName, Integer.valueOf(strInitialPoints).intValue());
			engine.addPlayer(player);
		}
		
	}
			
}

