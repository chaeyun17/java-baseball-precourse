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
			builder.append("낫싱");
			return builder.toString();
		}
		if(strikeCnt != 0){
			builder.append(strikeCnt);
			builder.append("스트라이크");
		}
		if(ballCnt != 0){
			builder.append(ballCnt);
			builder.append("볼");
		}
		return builder.toString();
	}
}
