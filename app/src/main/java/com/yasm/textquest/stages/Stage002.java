package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage002 extends Stage {

    public Stage002() {
        super(false,
                0,
                "Нужно перестать лениться и сделать хоть что-нибудь.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage003();
    }
}
