package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theTsetPriceComponentPage() {
        return Task.where("{0} opens the tset price component page",
                Open.browserOn().the(PriceComponentTestPage.class));
    }
}
