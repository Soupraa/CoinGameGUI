package mvc.view;

import javax.swing.SwingUtilities;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	private AppFrame frame;

	public GameEngineCallbackGUI(AppFrame frame) {
		this.frame = frame;

	}

	@Override
	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.getCoinPanel().coinOneflip(coin, player);
				frame.getCoinPanel().coinTwoflip(coin, player);
			}
		});

	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.getCoinPanel().SpinCoinOneFlip(coin);
				frame.getCoinPanel().SpinCoinTwoFlip(coin);
			}
		});

	}
	@Override
	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
		//frame.getSummaryPanel().SummaryPanelUpdate(engine.getAllPlayers());
	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

}
