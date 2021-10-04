package baseball.model;

import nextstep.utils.Randoms;

public class GameModel {

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
