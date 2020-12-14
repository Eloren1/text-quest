package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage102 extends Stage {

    public Stage102() {
        super(false,
                1,
                "Ответ неправильный. Надо попробовать ещё раз.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage100();
    }
}
