package baseball;

import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new GameView(), new GameModel());
        gameController.start();
    }
}
