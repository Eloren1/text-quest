package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage004 extends Stage {

    public Stage004() {
        super(false,
                5,
                "Ладно, все мои проблемы подождут. Пойду поиграю.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage005();
    }
}
