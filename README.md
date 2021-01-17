Это мини-проект — текстовый квест, является одним из домашних заданий на курсе Samsung IT Academy по мобильной разработке под Android. 

![Задание](https://i.ibb.co/VVPNSrZ/Screenshot-58.png)

Текстовый квест занял первое место среди студентов группы, как минимум благодаря завершенности игры и готовности к выгрузке Google Play. Но у других студентов тоже было очень много классных работ, намного более проработанных и интересныъ.

Квест максимально просто улучшать и масштабировать благодаря хорошей архитектуре. 


Класс Stage содержит ссылки на следующие стейджи, айди заднего фона и текст. Если нам попадается вопрос, то данных для ввода больше: нужно добавить больше вариантов развития событий и подписей к кнопкам.

Пример создания стейджей:

Текстовый стейдж
```
 public Stage001() {
        super(false,
                0, // Айди фона: Комната игрока
                "Этот день уже подходит к концу, а я опять за сегодня ничего не сделал.");
    }

    @Override
    public void SetNext() {
        super.nextStage1 = new Stage002();
    }
```


Стейдж с вопросом и вариантами действий
```
 public Stage100() {
        super(true,
                1, Айди фона: Монитор с сайтом курса
                "«Какому ключевому слову соответствует уровень доступа, когда члены класса доступны " +
                        "внутри пакета и в наследниках?», — Чёрт, ненавижу ООП!", // Это не всерьрёз)
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
```


Чтобы создать новый стейдж, нужно унаследоваться от родительского класса Stage и задать значения (пример был выше)
```
 public Stage(boolean isQuestion, int BackgroundId, String MainText) {
        // Для Stage с isQuestion = false (т.е. для текста)
        this.isQuestion = isQuestion;
        this.BackgroundId = BackgroundId;
        this.MainText = MainText;
    }

    public Stage(boolean isQuestion, int BackgroundId, String MainText,
                 String Bt1Text, String Bt2Text, String Bt3Text) {
        // Для Stage с isQuestion = true (т.е. вопроса)
        this.isQuestion = isQuestion;
        this.BackgroundId = BackgroundId;
        this.MainText = MainText;
        this.Bt1Text = Bt1Text;
        this.Bt2Text = Bt2Text;
        this.Bt3Text = Bt3Text;
    }

    public void ButtonClicked(int btId, Context context) {
        GameActivity activity = (GameActivity) context;
        SetNext();
        if (nextStage1 == null) {
            activity.MainMenu();
            return;
        }
        if (isQuestion) {
            if (btId == 1) activity.GoNextStage(nextStage1);
            if (btId == 2) activity.GoNextStage(nextStage2);
            if (btId == 3) activity.GoNextStage(nextStage3);
        } else {
            activity.GoNextStage(nextStage1);
        }
    }
```
