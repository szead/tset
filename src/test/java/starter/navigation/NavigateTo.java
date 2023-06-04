package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.pricecomponents.ui.PriceComponentPage;

public class NavigateTo {
    public static Performable theTsetPriceComponentPage() {
        return Task.where("{0} opens the tset price component page",
                Open.browserOn().the(PriceComponentPage.class));
    }
}
