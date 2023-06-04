package starter.pricecomponents.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.pricecomponents.ui.PriceComponentPage;

public class CreateNewPriceComponent {
    public static Performable withTheFollowingData(String labelTitle, String priceValue) {
        return Task.where(
            "{0} adds a new price component with label title " + labelTitle + " and price value " + priceValue,
            actor -> actor.attemptsTo(
                Clear.field(PriceComponentPage.NEW_LABEL_TITLE_INPUT),
                Enter.theValue(labelTitle).into(PriceComponentPage.NEW_LABEL_TITLE_INPUT),
                Enter.theValue(priceValue).into(PriceComponentPage.NEW_VALUE_TITLE_INPUT),
                Click.on(PriceComponentPage.NEW_VALUE_CHECK_ICON)
            ));
    }
}
