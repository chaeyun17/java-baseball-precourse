package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameModelTest {

	GameModel gameModel;

	@BeforeEach
	public void setup(){
		gameModel = new GameModel();
	}

	@Test
	void generateAnswerTest() {
		for(int i=0; i<100; i++){
			generateAnswerTest_ShouldGenerateAnswer();
		}
	}

	private void generateAnswerTest_ShouldGenerateAnswer(){
		// when
		char[] actual = gameModel.generateAnswer();

		// then
		assertThat(actual).hasSize(3);
		assertThat(actual).doesNotHaveDuplicates();
	}

	@Test
	void calculateScoreTest() {
		calculateScoreTest_ShouldCalculateScore("123", "123", 3, 0);
		calculateScoreTest_ShouldCalculateScore("123", "321", 1, 2);
		calculateScoreTest_ShouldCalculateScore("123", "456", 0, 0);
		calculateScoreTest_ShouldCalculateScore("123", "345", 0, 1);
		calculateScoreTest_ShouldCalculateScore("123", "145", 1, 0);
	}

	private void calculateScoreTest_ShouldCalculateScore(String answerStr, String input, int strikeCnt, int ballCnt){
		// given
		char[] answer = answerStr.toCharArray();

		// when
		Score score = gameModel.calculateScore(answer, input);

		// then
		assertThat(score.getStrikeCnt()).isEqualTo(strikeCnt);
		assertThat(score.getBallCnt()).isEqualTo(ballCnt);
	}
}