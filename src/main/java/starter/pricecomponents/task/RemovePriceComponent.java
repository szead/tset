package starter.pricecomponents.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import starter.pricecomponents.ui.PriceComponentPage;

public class RemovePriceComponent {


    public static Performable ofTheLabelTitle(String internalSurcharge) {
        return Task.where("{0} removes the price component with label title " + internalSurcharge,
            actor -> actor.attemptsTo(
                MoveMouse.to(PriceComponentPage.LABEL_TITLE_BY_NAME.of(internalSurcharge)),
                Click.on(PriceComponentPage.DELETE_ICON_BY_NAME.of(internalSurcharge))
            ));
    }
}
