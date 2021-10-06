package baseball.controller;

import baseball.config.GameConfig;
import baseball.model.GameModel;
import baseball.model.Score;
import baseball.view.GameView;

public class GameController {

	public final String replayCommand;
	public final String exitCommand;
	private final GameView gameView;
	private final GameModel gameModel;

	public GameController(GameView gameView, GameModel gameModel, GameConfig gameConfig) {
		this.gameModel = gameModel;
		this.gameView = gameView;
		this.replayCommand = gameConfig.getCommandReplay();
		this.exitCommand = gameConfig.getCommandExit();
	}

	public void start() {
		boolean isPlay = true;
		while (isPlay) {
			boolean isWinRound = playRound();
			isPlay = askReplay(isWinRound);
		}
		gameView.printEndGame();
	}

	private boolean askReplay(boolean isWinRound) {
		if (!isWinRound) {
			return false;
		}
		gameView.printWin();
		return isReplayGame();
	}

	private boolean isReplayGame() {
		String playerInput = gameView.getResumeInput();
		if (playerInput.equals(replayCommand)) {
			return true;
		}
		if (playerInput.equals(exitCommand)) {
			return false;
		}
		gameView.printInputError();
		return false;
	}

	private boolean playRound() {
		char[] answerCharAry = gameModel.generateAnswer();
		boolean isWin = false;
		while (!isWin) {
			isWin = playTurn(answerCharAry);
		}
		return true;
	}

	private boolean playTurn(char[] answer) {
		String playerInput = gameView.getInput();
		if (!gameModel.isValidInput(playerInput)) {
			gameView.printInputError();
			return false;
		}
		Score score = gameModel.calculateScore(answer, playerInput);
		gameView.printScore(toDto(score));
		return gameModel.isWin(score);
	}

	private ScoreDto toDto(Score score) {
		return new ScoreDto(score.getStrikeCnt(), score.getBallCnt());
	}
}
