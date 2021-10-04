package baseball.view;

import nextstep.utils.Console;

public class GameView {

	public String getInput(){
		System.out.println("숫자를 입력해주세요: ");
		return Console.readLine();
	}

}
