package baseball.model;

import baseball.config.GameConfig;
import nextstep.utils.Randoms;

public class GameModel {

	private final int maxNumber;
	private final int minNumber;
	private final int digit;

	public GameModel(GameConfig gameConfig) {
		this.maxNumber = gameConfig.getMaxNumber();
		this.minNumber = gameConfig.getMinNumber();
		this.digit = gameConfig.getDigit();
	}

	public Score calculateScore(char[] answerCharAry, String playerInput) {
		char[] inputAry = playerInput.toCharArray();
		int strikeCnt = 0;
		int ballCnt = 0;

		for (int i = 0; i < answerCharAry.length; i++) {
			strikeCnt += isStrike(inputAry[i], answerCharAry[i]);
			ballCnt += isBall(inputAry[i], answerCharAry[i], answerCharAry);
		}
		return new Score(strikeCnt, ballCnt);
	}

	public char[] generateAnswer() {
		char[] answerAry = new char[digit];
		for (int i = 0; i < digit; i++) {
			answerAry[i] = generateRandomNumberChar(answerAry);
		}
		return answerAry;
	}

	public boolean isWin(Score score) {
		return score.getStrikeCnt() == digit;
	}

	public boolean isValidInput(String input) {
		if (input.length() != 3) {
			return false;
		}
		if (!isNumberFormat(input)) {
			return false;
		}
		return isRangeNumbers(input);
	}

	private char generateRandomNumberChar(char[] answerAry) {
		char randomNumChar;
		do {
			int number = Randoms.pickNumberInRange(maxNumber, minNumber);
			randomNumChar = Character.forDigit(number, 10);
		} while (isContainChar(randomNumChar, answerAry));
		return randomNumChar;
	}

	private boolean isNumberFormat(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean isRangeNumbers(String input) {
		int equalCnt = 0;
		for (char c : input.toCharArray()) {
			equalCnt += isRangeNumber(1, 9, c);
		}
		return equalCnt == input.toCharArray().length;
	}

	private int isRangeNumber(int startNum, int endNum, char numberChar) {
		int num = Character.getNumericValue(numberChar);
		int equalCnt = 0;
		for (int i = startNum; i <= endNum; i++) {
			equalCnt += isEqual(num, i);
		}
		if (equalCnt > 0) {
			return 1;
		}
		return 0;
	}

	private int isStrike(char input, char answer) {
		if (input == answer) {
			return 1;
		}
		return 0;
	}

	private int isBall(char input, char answer, char[] answerAry) {
		if (input == answer) {
			return 0;
		}
		if (!isContainChar(input, answerAry)) {
			return 0;
		}
		return 1;
	}

	private boolean isContainChar(char target, char[] array) {
		int equalCnt = 0;
		for (char c : array) {
			equalCnt += isEqual(target, c);
		}
		return equalCnt > 0;
	}

	private int isEqual(char a, char b) {
		if (a == b) {
			return 1;
		}
		return 0;
	}

	private int isEqual(int num, int i) {
		if (num == i) {
			return 1;
		}
		return 0;
	}

}
