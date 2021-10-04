package baseball.view;

import baseball.controller.ScoreDto;
import nextstep.utils.Console;

public class GameView {

	public String getInput(){
		System.out.println("숫자를 입력해주세요: ");
		return Console.readLine();
	}

	public void printScore(ScoreDto score) {
		System.out.println(getScoreStatusMsg(score));
	}

	private String getScoreStatusMsg(ScoreDto score){
		StringBuilder builder = new StringBuilder();
		int strikeCnt = score.getStrikeCnt();
		int ballCnt = score.getBallCnt();
		if(strikeCnt == 0 && ballCnt == 0){
			builder.append("낫싱 ");
			return builder.toString();
		}
		if(strikeCnt != 0){
			builder.append(strikeCnt);
			builder.append("스트라이크 ");
		}
		if(ballCnt != 0){
			builder.append(ballCnt);
			builder.append("볼 ");
		}
		return builder.toString();
	}

	public void printWin(){
		String msg = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
		System.out.println(msg);
	}

	public String getResumeInput() {
		String msg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		System.out.println(msg);
		return Console.readLine();
	}

	public void printEndGame() {
		System.out.println("게임이 종료되었습니다.");
	}

	public void printInputError() {
		System.out.println("[ERROR] 잘못된 입력값입니다.");
	}
}
