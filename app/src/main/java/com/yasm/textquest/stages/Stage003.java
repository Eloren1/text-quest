package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage003 extends Stage {

    public Stage003() {
        super(true,
                0,
                "Что поделать этим вечером?",
                "Пойти поиграть в компьютер",
                "Начать выполнять задания второго модуля",
                "Пойти поесть на кухню");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage004();
        super.nextStage2 = new Stage100();
        super.nextStage3 = new Stage010();
    }
}
