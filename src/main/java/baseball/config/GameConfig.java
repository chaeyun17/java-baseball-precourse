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

	public int getMinNumber() {
		return minNumber;
	}

	public int getDigit() {
		return digit;
	}

	public String getCommandReplay() {
		return commandReplay;
	}

	public String getCommandExit() {
		return commandExit;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}

	public void setDigit(int digit) {
		this.digit = digit;
	}

	public void setCommandReplay(String commandReplay) {
		this.commandReplay = commandReplay;
	}

	public void setCommandExit(String commandExit) {
		this.commandExit = commandExit;
	}
}
