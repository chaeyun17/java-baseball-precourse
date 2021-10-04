package baseball.view;

import nextstep.utils.Console;

public class GameView {

	public String getInput(){
		System.out.println("[입력] 세자리 숫자(양의 정수)를 입력해주세요: ");
		return Console.readLine();
	}

}
