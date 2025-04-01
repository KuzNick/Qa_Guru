package PageObgect;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TextBox {
    public static final SelenideElement fullNameInput = $("#userName");
    public static final SelenideElement emailInput = $("#userEmail");
    public static final SelenideElement currentAddressInput = $("#currentAddress");
    public static final SelenideElement permanentAddressNameInput = $("#permanentAddress");
    public static final SelenideElement submitButton = $("#submit");
    public static final SelenideElement fullNameInputCheck = $("#name");
    public static final SelenideElement emailInputCheck = $("#email");
    public static final SelenideElement currentAddressInputCheck = $("#output #currentAddress");
    public static final SelenideElement permanentAddressNameInputCheck = $("#output #permanentAddress");

    public void fillFullNameInput(String fullName){
        fullNameInput.shouldBe(visible).setValue(fullName);
    }

    public void fillEmailInput(String email){
        emailInput.shouldBe(visible).setValue(email);
    }

    public void fillCurrentAddress(String currentAddress){
        currentAddressInput.shouldBe(visible).setValue(currentAddress);
    }

    public void fillPermanentAddressNameInput(String permanentAddressName){
        permanentAddressNameInput.shouldBe(visible).setValue(permanentAddressName);
    }

    public void ClickSubmitButton(){
        submitButton.shouldBe(visible).click();
    }

    public void fillFullNameInputCheck(String fullName){
        fullNameInputCheck.shouldBe(visible).shouldHave(text(fullName));
    }

    public void fillEmailInputCheck(String email){
        emailInputCheck.shouldBe(visible).shouldHave(text(email));
    }

    public void fillCurrentAddressCheck(String currentAddress){
        currentAddressInputCheck.shouldBe(visible).shouldHave(text(currentAddress));
    }

    public void fillPermanentAddressNameInputCheck(String permanentAddressName){
        permanentAddressNameInputCheck.shouldBe(visible).shouldHave(text(permanentAddressName));
    }
}
