package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.AppFrame;

public class AddPlayerController implements ActionListener {
	private GameEngine engine;
	private Player player;
	private AppFrame frame;
	private JTextField playerName = new JTextField();
	private JTextField initialPoints = new JTextField();
	private int idCount = 1;

	public AddPlayerController(GameEngine gameEngine, AppFrame frame) {
		this.frame = frame;
		this.engine = gameEngine;

	}
	/*
	 * ALGORITHM
	 * 	BEGIN
	 * 		SHOW JOPTION FRAME WITH 2 TEXT INPUTS.
	 * 			IF INPUTS ARE NOT EMPTY AND ARE NOT NULL 
	 * 				CALL ADDPLAYERTOENGINE METHOD
	 * END
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] message = {"Enter Player name", playerName, "Enter inital Points",
				initialPoints };
		int option = JOptionPane.showConfirmDialog(null, message, "Add Player", JOptionPane.OK_CANCEL_OPTION);
		if (!PlayerIsNull()) {
			if (option == JOptionPane.OK_OPTION) {
				addPlayerToEngine(player);
				if (option == JOptionPane.CANCEL_OPTION) {
					
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Player not added.");
		}
	}

	private boolean PlayerIsNull() {
		return playerName.getText().isEmpty() || playerName.getText() == null || initialPoints.getText().isEmpty()
				|| initialPoints.getText() == null;
	}
	/*
	 * ALGORITHM
	 * 	BEGIN
	 * 		GET PLAYERNAME INPUT CONVERT TO STRING
	 * 		GET PLAYER POINTS INPUT CONVERT TO STRING
	 * 			CREATE NEW PLAYER USING NEW PLAYER, PARSE STRING VALUES INTO PARAMATERS
	 * 		USE THE ENGINE TO ADD PLAYER
	 * 		REFRESH THE TOOLBAR'S COMBOBOX
	 * 		REFRESH THE SUMMARYPANELS INFOMATION
	 * 		RESET PLAYERNAME INPUT AND POINTS INPUT TO NULL
	 * END 	
	 */
	private void addPlayerToEngine(Player player) {
		String strPlayerName = playerName.getText();
		String strInitialPoints = initialPoints.getText();
		player = new SimplePlayer(String.valueOf(idCount++), strPlayerName, Integer.valueOf(strInitialPoints).intValue());		
		engine.addPlayer(player);
		frame.getToolBar().comboBoxUpdate(engine.getAllPlayers());
		frame.getSummaryPanel().SummaryPanelUpdate(engine.getAllPlayers());	
		playerName.setText(null);
		initialPoints.setText(null);
	}
}
