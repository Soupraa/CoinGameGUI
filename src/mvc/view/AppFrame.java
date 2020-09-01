package mvc.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;

public class AppFrame extends JFrame {
	private GameEngine engine;
	private ToolBar toolbar;
	private MenuBar menuBar;
	private SummaryPanel summaryPanel;
	private CoinPanel coinPanel;

	public AppFrame() {
		engine = new GameEngineImpl();
		engine.addGameEngineCallback(new GameEngineCallbackImpl());
		engine.addGameEngineCallback(new GameEngineCallbackGUI(this));

		menuBar = new MenuBar(engine, this);
		toolbar = new ToolBar(engine, this);
		summaryPanel = new SummaryPanel();
		coinPanel = new CoinPanel(this);

		JPanel top = new JPanel();
		top.updateUI();
		top.setLayout(new BorderLayout());
		setJMenuBar(menuBar);
		top.add(toolbar, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);

		JPanel middle = new JPanel();
		middle.updateUI();
		middle.setLayout(new BorderLayout());
		middle.add(coinPanel, BorderLayout.CENTER);
		middle.add(summaryPanel, BorderLayout.WEST);
		middle.add(new StatusBar(toolbar, coinPanel), BorderLayout.SOUTH);
		add(middle, BorderLayout.CENTER);
	}
	//gets Toolbar component
	public ToolBar getToolBar() {
		return toolbar;
	}
	//gets Summary Panel Component
	public SummaryPanel getSummaryPanel() {
		return summaryPanel;
	}
	//gets the player in the toolbar currently (not-working).
	public Player getSelectedPlayer() {
		return engine.getPlayer(toolbar.getSelectedPlayer());
	}
	//gets the coin panel.
	public CoinPanel getCoinPanel() {
		return coinPanel;
	}
}
