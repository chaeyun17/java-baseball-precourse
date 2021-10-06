package baseball;

import baseball.config.GameConfig;
import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.view.GameView;

public class Application {
	public static void main(String[] args) {
		GameConfig gameConfig = new GameConfig();
		GameView gameView = new GameView(gameConfig);
		GameModel gameModel = new GameModel(gameConfig);
		GameController gameController = new GameController(gameView, gameModel, gameConfig);
		gameController.start();
	}
}
