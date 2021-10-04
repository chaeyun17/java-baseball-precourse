package baseball.controller;

import baseball.model.GameModel;
import baseball.model.Score;
import baseball.view.GameView;

public class GameController {

	private final GameView gameView;
	private final GameModel gameModel;

	public static final String COMMAND_STR_REPLAY = "1";
	public static final String COMMAND_STR_EXIT = "2";

	public GameController(GameView gameView, GameModel gameModel){
		this.gameModel = gameModel;
		this.gameView = gameView;
	}

	public void start(){
		boolean isPlay = true;
		while (isPlay){
			boolean isWinRound = playRound();
			if(isWinRound){
				gameView.printWin();
				isPlay = isReplayGame();
			}
		}
		gameView.printEndGame();
	}

	private boolean isReplayGame(){
		String playerInput = gameView.getResumeInput();
		if (playerInput.equals(COMMAND_STR_REPLAY)){
			return true;
		}
		if(playerInput.equals(COMMAND_STR_EXIT)){
			return false;
		}
		gameView.printInputError();
		return false;
	}

	private boolean playRound(){
		char[] answerCharAry = gameModel.generateAnswer();
		boolean isWin = false;
		while (!isWin){
			isWin = playTurn(answerCharAry);
		}
		return true;
	}

	private boolean playTurn(char[] answer){
		String playerInput = gameView.getInput();
		if(!gameModel.isValidInput(playerInput)){
			gameView.printInputError();
			return false;
		}
		Score score = gameModel.calculateScore(answer, playerInput);
		gameView.printScore(toDto(score));
		return gameModel.isWin(score);
	}

	private ScoreDto toDto(Score score){
		return new ScoreDto(score.getStrikeCnt(), score.getBallCnt());
	}
}
