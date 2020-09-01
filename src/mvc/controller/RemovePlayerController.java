package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.AppFrame;

public class RemovePlayerController implements ActionListener {
	private GameEngine engine;

	private AppFrame frame;
	private JComboBox<String> comboBox = new JComboBox<>();

	public RemovePlayerController(GameEngine engine, AppFrame frame) {
		this.frame = frame;
		this.engine = engine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] message = { "Select player to remove", comboBox };
		comboBox.removeAllItems();
		for (Player i : engine.getAllPlayers()) {
			comboBox.addItem(i.getPlayerId());
		}
		int option = JOptionPane.showConfirmDialog(null, message, "Remove Player", JOptionPane.OK_CANCEL_OPTION);
		String playerID = (String) comboBox.getSelectedItem();
		if (option == JOptionPane.OK_OPTION) {
			engine.removePlayer(engine.getPlayer(playerID));
			if (option == JOptionPane.CANCEL_OPTION) {
				/* nothing happens */
			}
			frame.getSummaryPanel().SummaryPanelUpdate(engine.getAllPlayers());
			frame.getToolBar().comboBoxUpdate(engine.getAllPlayers());
		}
	}
}
