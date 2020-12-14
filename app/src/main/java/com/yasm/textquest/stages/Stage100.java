package com.yasm.textquest.stages;
import com.yasm.textquest.Stage;

public class Stage100 extends Stage {

    public Stage100() {
        super(true,
                1,
                "«Какому ключевому слову соответствует уровень доступа, когда члены класса доступны " +
                        "внутри пакета и в наследниках?», — Что? Ненавижу ООП!", // Это не всерьрёз)
                "public",
                "default",
                "protected");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage102();
        super.nextStage2 = new Stage102();
        super.nextStage3 = new Stage101();
    }
}
