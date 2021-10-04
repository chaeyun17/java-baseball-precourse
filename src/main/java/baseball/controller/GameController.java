package baseball.controller;

import baseball.model.GameModel;
import baseball.model.Score;
import baseball.view.GameView;

public class GameController {

	private final GameView gameView;
	private final GameModel gameModel;

	public GameController(GameView gameView, GameModel gameModel){
		this.gameModel = gameModel;
		this.gameView = gameView;
	}

	public void start(){
		boolean isPlay = true;
		while (isPlay){
			playRound();
		}
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
		System.out.println(playerInput);
		Score score = gameModel.calculateScore(answer, playerInput);
		gameView.printScore(toDto(score));
		return true;
	}

	private ScoreDto toDto(Score score){
		return new ScoreDto(score.getStrikeCnt(), score.getBallCnt());
	}
}
