package mvc.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.controller.SpinController;


public class ToolBar extends JToolBar{
	private JButton spinButton = new JButton();
	private GameEngine engine = new GameEngineImpl();
	public ToolBar() {
		spinButton.setText("Spin");
		spinButton.setBorder(BorderFactory.createRaisedBevelBorder());
		spinButton.addMouseListener(new SpinController());
		add(spinButton);
		String player = engine.getAllPlayers().toString();
		JComboBox<String> cb = new JComboBox();
		add(cb);	

	}

}
