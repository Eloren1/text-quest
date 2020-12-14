package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage101 extends Stage {

    public Stage101() {
        super(false,
                1,
                "Это было легко! Осталось сделать всего лишь 99 заданий за два дня.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage103();
    }
}
