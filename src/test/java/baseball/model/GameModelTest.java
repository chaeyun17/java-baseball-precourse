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
}