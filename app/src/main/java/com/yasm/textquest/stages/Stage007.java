package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage007 extends Stage {

    public Stage007() {
        super(false,
                4,
                "Я снова за сегодня ничего не сделал.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage008();
    }
}
