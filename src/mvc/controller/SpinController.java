package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.interfaces.GameEngine;
import mvc.view.AppFrame;

public class SpinController implements ActionListener {
	private GameEngine engine;
	private AppFrame frame;
//	boolean isPlayerSpinning = false;
//	boolean isSpinnerSpinning = false;

	public SpinController(GameEngine engine, AppFrame frame) {
		this.frame = frame;
		this.engine = engine;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (frame.getToolBar().getSelectedPlayer() != null) {
			spinPlayer();
		}
	}

	public void spinPlayer() {
		new Thread() {
			@Override
			public void run() {
				System.out.println("Player is Spinning.");
				engine.spinPlayer(frame.getToolBar().getSelectedIndex(), 100, 1000, 100, 50, 500, 50);
				System.out.println("Spinner is Spinning.");
				spinSpinner();
			}
		}.start();
	}

	public void spinSpinner() {
		engine.spinSpinner(100, 1000, 200, 50, 500, 25);
		System.out.println("Spins complete.");
//		frame.getSummaryPanel().SummaryPanelUpdate(engine.getAllPlayers());
	}
}
