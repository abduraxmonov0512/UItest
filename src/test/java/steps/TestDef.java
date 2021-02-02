package steps;

import helpers.Test;
import io.cucumber.java.ru.Когда;

public class TestDef {
    Test test = new Test();
    @Когда("переход на модератор")
    public void переходНаМодератор() {
        test.openModerator();
    }
}
