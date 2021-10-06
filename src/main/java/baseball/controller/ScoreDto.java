package baseball.controller;

public class ScoreDto {

	private int strikeCnt;
	private int ballCnt;

	public ScoreDto() {
	}

	public ScoreDto(int strikeCnt, int ballCnt) {
		this.strikeCnt = strikeCnt;
		this.ballCnt = ballCnt;
	}

	public int getStrikeCnt() {
		return strikeCnt;
	}

	public void setStrikeCnt(int strikeCnt) {
		this.strikeCnt = strikeCnt;
	}

	public int getBallCnt() {
		return ballCnt;
	}

	public void setBallCnt(int ballCnt) {
		this.ballCnt = ballCnt;
	}
}
