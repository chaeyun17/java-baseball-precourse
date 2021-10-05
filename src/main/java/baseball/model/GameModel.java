package baseball.model;

import baseball.config.GameConfig;
import nextstep.utils.Randoms;

public class GameModel {

	private final int maxNumber;
	private final int minNumber;
	private final int digit;

	public GameModel(GameConfig gameConfig){
		this.maxNumber = gameConfig.getMaxNumber();
		this.minNumber = gameConfig.getMinNumber();
		this.digit = gameConfig.getDigit();
	}

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
		char[] answerAry = new char[digit];
		for(int i = 0; i<digit; i++){
			char randomNumChar;
			do{
				int number =  Randoms.pickNumberInRange(maxNumber, minNumber);
				randomNumChar = Character.forDigit(number, 10);
			}while(isContainChar(randomNumChar, answerAry));
			answerAry[i] = randomNumChar;
		}
		return answerAry;
	}

	public boolean isWin(Score score){
		return score.getStrikeCnt() == digit;
	}

	public boolean isValidInput(String input){
		if(input.length() != 3){
			return false;
		}
		if(!isNumberFormat(input)){
			return false;
		}
		return isRangeNumbers(input);
	}

	private boolean isNumberFormat(String str){
		try{
			Integer.parseInt(str);
		}catch (NumberFormatException e){
			return false;
		}
		return true;
	}

	private boolean isRangeNumbers(String input){
		for(char c : input.toCharArray()){
			if(!isRangeNumber(1, 9, c)){
				return false;
			}
		}
		return true;
	}

	private boolean isRangeNumber(int startNum, int endNum, char numberChar){
		int num = Character.getNumericValue(numberChar);
		for(int i=startNum; i<=endNum; i++){
			if(num == i){
				return true;
			}
		}
		return false;
	}

	private boolean isContainChar(char target, char[] array){
		for (char c : array) {
			if (target == c) {
				return true;
			}
		}
		return false;
	}

}
