package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage001 extends Stage {

    public Stage001() {
        super(false,
                0,
                "Этот день уже подходит к концу, а я опять за сегодня ничего не сделал.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage002();
    }
}
