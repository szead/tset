package starter.pricecomponents.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:tset.price.component")
public class PriceComponentPage extends PageObject {

    public static Target BASE_COMPONENT_EDIT_ICON = Target.the("COMPONENT EDIT ICON")
        .locatedBy("//span[@id='base-edit-icon']");
    public static Target BASE_PRICE_CHECK = Target.the("BASE PRICE CHECK")
        .locatedBy("//div[@id='BasePrice']//i[contains(@class,'fa-check')]");

    public static Target BASE_PRICE = Target.the("BASE PRICE")
        .locatedBy("//div[@id='BasePrice']");
    public static Target BASE_PRICE_VALUE = Target.the("BASE PRICE")
        .locatedBy("//div[@id='BasePrice']/div[3]/div");

    public static Target BASE_PRICE_INPUT = Target.the("BASE PRICE INPUT")
        .locatedBy("//input[@id='base-value-input']");

    public static Target TOTAL_VALUE = Target.the("TOTAL VALUE")
        .locatedBy("//div[text()=' Total: ']/span");

    public static Target EDITED_LABEL_INPUT = Target.the("EDITED LABEL INPUT")
        .locatedBy("//input[contains(@id,'label-input') and not(contains(@id,'ghost'))]");

    public static Target EDITED_CHECK_ICON = Target.the("EDITED CHECK ICON")
        .locatedBy("//span[contains(@id,'check-icon') and not(contains(@style,'display: none'))]");

    public static Target NEW_LABEL_TITLE_INPUT = Target.the("NEW LABEL TITLE INPUT")
        .locatedBy("//input[@id='ghost-label-input']");

    public static Target NEW_VALUE_TITLE_INPUT = Target.the("NEW VALUE TITLE INPUT")
        .locatedBy("//input[@id='ghost-value-input']");

    public static Target NEW_VALUE_CHECK_ICON = Target.the("NEW VALUE CHECK ICON")
        .locatedBy("//span[@id='ghost-check-icon']//i[contains(@class,'fa-check')]");

    public static Target LABEL_TITLE = Target.the("LABEL TITLE")
        .locatedBy("//ul/div[{0}]/div[2]/span");

    public static Target LABEL_TITLE_BY_NAME = Target.the("LABEL TITLE NAME")
        .locatedBy("//span[text()='{0}']");

    public static Target DELETE_ICON_BY_NAME = Target.the("DELETE ICON BY NAME")
        .locatedBy("//span[text()='{0}']/parent::div/following-sibling::div//i[contains(@class,'fa-trash-alt')]");

    public static Target EDIT_ICON_BY_NAME = Target.the("EDIT ICON BY NAME")
        .locatedBy("//span[text()='{0}']/parent::div/preceding-sibling::div//i[contains(@class,'fa-pencil-alt')]");


    public static Target PRICE_VALUE = Target.the("PRICE VALUE")
        .locatedBy("//ul/div[{0}]/div[3]/div");

    public static Target LABEL_TO_SHORT_MESSAGE = Target.the("LABEL TO SHORT MESSAGE")
        .locatedBy("//p[text()=' This label is too short! ']");


}
