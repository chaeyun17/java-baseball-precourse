package baseball.model;

import nextstep.utils.Randoms;

public class GameModel {

	public Score calculateScore(char[] answerCharAry, String playerInput){
		char[] inputAry = playerInput.toCharArray();
		int strikeCnt = 0;
		int ballCnt = 0;

		for(int i=0; i<answerCharAry.length; i++){
			if(inputAry[i] == answerCharAry[i]){
				strikeCnt++;
				continue;
			}
			if(isContainChar(inputAry[i], answerCharAry)){
				ballCnt++;
			}
		}

		return new Score(strikeCnt, ballCnt);
	}

	public char[] generateAnswer() {
		char[] answerAry = new char[3];
		for(int i=0; i<3; i++){
			char randomNumChar;
			do{
				int number =  Randoms.pickNumberInRange(1, 9);
				randomNumChar = Character.forDigit(number, 10);
			}while(isContainChar(randomNumChar, answerAry));
			answerAry[i] = randomNumChar;
		}
		return answerAry;
	}

	public boolean isContainChar(char target, char[] array){
		for (char c : array) {
			if (target == c) {
				return true;
			}
		}
		return false;
	}

}
