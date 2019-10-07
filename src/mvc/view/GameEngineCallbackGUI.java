package mvc.view;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	@Override
	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
		player.getPlayerName();
		coin.getNumber();
		coin.getFace().toString();
		
	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

}
