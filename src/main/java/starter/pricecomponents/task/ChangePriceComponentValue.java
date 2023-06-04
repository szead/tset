package starter.pricecomponents.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.HoverOverElement;
import starter.pricecomponents.ui.PriceComponentPage;

public class ChangePriceComponentValue {

    public static Performable ofTheBasePriceTo(String newBasePrice) {
        return Task.where("{0} changes the value of the Baseprice to " + newBasePrice,
            actor -> actor.attemptsTo(
                HoverOverElement.over(PriceComponentPage.BASE_PRICE),
                Click.on(PriceComponentPage.BASE_COMPONENT_EDIT_ICON),
                Enter.theValue(newBasePrice).into(PriceComponentPage.BASE_PRICE_INPUT),
                Click.on(PriceComponentPage.BASE_PRICE_CHECK)
            ));

    }

    public static Performable withoutCheckOfTheLabelTitleTo(String labelTitle, String newLabelTitle) {
        return Task.where("{0} changes the value of the label title " + labelTitle + " to " + newLabelTitle,
            actor -> actor.attemptsTo(
                HoverOverElement.over(PriceComponentPage.LABEL_TITLE_BY_NAME.of(labelTitle)),
                Click.on(PriceComponentPage.EDIT_ICON_BY_NAME.of(labelTitle)),
                Enter.theValue(newLabelTitle).into(PriceComponentPage.EDITED_LABEL_INPUT)
            ));

    }

    public static Performable ofTheLabelTitleTo(String labelTitle, String newLabelTitle) {
        return Task.where("{0} changes the value of the label title " + labelTitle + " to " + newLabelTitle,
            actor -> actor.attemptsTo(
                HoverOverElement.over(PriceComponentPage.LABEL_TITLE_BY_NAME.of(labelTitle)),
                Click.on(PriceComponentPage.EDIT_ICON_BY_NAME.of(labelTitle)),
                Enter.theValue(newLabelTitle).into(PriceComponentPage.EDITED_LABEL_INPUT),
                Click.on(PriceComponentPage.EDITED_CHECK_ICON)
            ));

    }
}
