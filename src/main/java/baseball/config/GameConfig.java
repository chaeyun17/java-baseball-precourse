package baseball.config;

public class GameConfig {

	private int maxNumber = 1;
	private int minNumber = 9;
	private int digit = 3;
	private String commandReplay = "1";
	private String commandExit = "2";

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public int getMinNumber() {
		return minNumber;
	}

	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}

	public int getDigit() {
		return digit;
	}

	public void setDigit(int digit) {
		this.digit = digit;
	}

	public String getCommandReplay() {
		return commandReplay;
	}

	public void setCommandReplay(String commandReplay) {
		this.commandReplay = commandReplay;
	}

	public String getCommandExit() {
		return commandExit;
	}

	public void setCommandExit(String commandExit) {
		this.commandExit = commandExit;
	}
}
