package mvc.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;


import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.controller.BetPlaceController;
import mvc.controller.SpinController;

public class ToolBar extends JToolBar implements ActionListener {
	private JButton spinButton = new JButton();
	private JButton placeBet = new JButton();
	private JComboBox<String> comboBox = new JComboBox<>();
	private	ArrayList<String> playerIDs = new ArrayList<String>();
	private GameEngine engine;
	private AppFrame frame;
	private Collection<Player> players;


	public static final String PLAYERNAME = "player";
	private String lastSelectedPlayer;
	
	public static final String SPINACTION = "spin";
	private String Spinning;

	public ToolBar(GameEngine engine, AppFrame frame) {	
		this.frame = frame;
		this.engine = engine;
		
		/*
		 * SET TEXT OF SPIN BUTTON AND ADDED ACTION LISTENER TO BUTTON
		 */
		spinButton.setText("Spin");
		SpinController spinPlayer = new SpinController(engine, frame);				
		spinButton.addActionListener(spinPlayer);
		spinButton.setPreferredSize(new Dimension(70, 30));
		
		
		//PlaceBet button.
		placeBet.setText("Place Bet");
		placeBet.setPreferredSize(new Dimension(70, 30));
		
		BetPlaceController playerPlaceBet = new BetPlaceController(engine, frame);
		placeBet.addActionListener(playerPlaceBet);
//		placeBet.addActionListener(this);

		add(spinButton);
		add(placeBet);
		add(comboBox);
	}
	//updates comboBox in toolbar.
	public void comboBoxUpdate(Collection<Player> players) {
		comboBox.removeAllItems();
		comboBox.updateUI();
		if (players != null && players.size() > 0) {
			for (Player i : players) {
				comboBox.addItem(i.getPlayerName());				
				playerIDs.add(i.getPlayerId());				
				comboBox.updateUI();
				comboBox.addActionListener(this);	
			}									
		}		
	}	
	//Getter for getting the current player name displayed in the Toolbar.
	public String getSelectedPlayer() {
		return (String) comboBox.getSelectedItem();
	}
	/*
	 * ALGORITHM 
	 * 	BEGIN
	 * 		LOOP THROUGH COLLECTION OF PLAYERS
	 * 			IF A PLAYER NAME IS EQUAL TO THE PLAYER NAME DISPLAYED IN THE COMBOBOX
	 * 				RETURN PLAYER.
	 * 			ELSE
	 * 				RETURN NULL
	 * END
	 */
	public Player getSelectedIndex() {
		for(Player i: engine.getAllPlayers()) {
			if(i.getPlayerName().equals(comboBox.getSelectedItem())) {
				return i;
			}		
		}
		return null;
		
	}
	//fires a change to the status bar when a player is selected in the Tool bar or the Spin button is pressed.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			if (engine.getAllPlayers() != null) {
				firePropertyChange(PLAYERNAME, lastSelectedPlayer, getSelectedPlayer());
				lastSelectedPlayer = getSelectedPlayer();
			}
		}
	}
}

