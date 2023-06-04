package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.navigation.NavigateTo;
import starter.pricecomponents.task.ChangePriceComponentValue;
import starter.pricecomponents.task.CreateNewPriceComponent;
import starter.pricecomponents.task.RemovePriceComponent;
import starter.pricecomponents.ui.PriceComponentPage;

public class PricesOfComponentsStepDefinitions {

    @Given("{actor} has seen the price components")
    public void tsetHasSeenTheBasePriceValue(Actor actor) {
        actor.attemptsTo(NavigateTo.theTsetPriceComponentPage());
    }

    @Then("{actor} should see the base price with value {string}")
    public void sheShouldSeeTheBasepriceWithValue(Actor actor, String basePrice) {
        actor.attemptsTo(
            Ensure.that(
                PriceComponentPage.BASE_PRICE_VALUE).text().isEqualTo(basePrice));
    }

    @When("{actor} changes the value of the Baseprice to {string}")
    public void sheChangesTheValueOfTheBasepriceTo(Actor actor, String newBasePrice) {
        actor.attemptsTo(
            ChangePriceComponentValue.ofTheBasePriceTo(newBasePrice));
    }

    @And("{actor} should see the sum of all components is {string}")
    public void theSumOfAllComponentsShouldBe(Actor actor, String allComponentsSum) {
        actor.attemptsTo(
            Ensure.that(
                PriceComponentPage.TOTAL_VALUE).text().isEqualTo(allComponentsSum));
        System.out.println("The sum of all components is " + allComponentsSum);
    }

    @When("{actor} adds all price components from Testdata")
    public void sheAddsAllPriceComponentsFromTestdata(Actor actor, DataTable priceComponents) {

        List<Map<String, String>> priceComponentRows = priceComponents.asMaps(String.class, String.class);

        priceComponentRows.forEach(
            priceComponentRow -> actor.attemptsTo(
                CreateNewPriceComponent.withTheFollowingData(
                    priceComponentRow.get("LabelTitle"),
                    priceComponentRow.get("PriceValue")
                )
            )
        );
        actor.remember("priceComponentRows", priceComponentRows);
    }

    @Then("{actor} should see all data has been added correctly")
    public void sheShouldSeeAllDataHasBeenAdded(Actor actor, DataTable expectedPriceComponents) {
        List<Map<String, String>> expectedPriceComponentsRows =
            expectedPriceComponents.asMaps(String.class, String.class);

        IntStream.range(2, expectedPriceComponentsRows.size() + 2).forEach(
            rowIndex -> actor.attemptsTo(
                Ensure.that(PriceComponentPage.LABEL_TITLE.of(String.valueOf(rowIndex))).text()
                    .isEqualTo(expectedPriceComponentsRows.get(rowIndex - 2).get("LabelTitle")),
                Ensure.that(PriceComponentPage.PRICE_VALUE.of(String.valueOf(rowIndex))).text()
                    .isEqualTo(expectedPriceComponentsRows.get(rowIndex - 2).get("PriceValue"))
            )
        );
    }

    @And("{actor} removes the price component of Internal surcharge")
    public void sheRemovesThePriceComponentOfInternalSurcharge(Actor actor) {
        actor.attemptsTo(
            RemovePriceComponent.ofTheLabelTitle("Internal surcharge")
        );
    }

    @And("{actor} edits the price component of Storage surcharge with {string}")
    public void sheEditsThePriceComponentOfStorageSurchargeWith(Actor actor, String newStorageSurcharge) {
        actor.attemptsTo(
            ChangePriceComponentValue.withoutCheckOfTheLabelTitleTo("Storage surcharge", newStorageSurcharge)
        );
    }

    @Then("{actor} should see label contains at least 2 characters error message")
    public void sheShouldSeeLabelContainsAtLeastCharactersErrorMessage(Actor actor) {
        actor.attemptsTo(
            Ensure.that(PriceComponentPage.LABEL_TO_SHORT_MESSAGE).isDisplayed()
        );
    }
}




