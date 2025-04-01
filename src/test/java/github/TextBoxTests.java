package github;

import PageObgect.TextBox;
import org.junit.jupiter.api.Test;
import uiConfig.Base;
import uiConfig.Credentials;

import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests extends Base {

    @Test
    void checkTestBox() {
        open("https://demoqa.com/text-box");
        TextBox textBox = new TextBox();
        textBox.fillFullNameInput(Credentials.FULL_NAME_INPUT);
        textBox.fillEmailInput(Credentials.EMAIL_INPUT);
        textBox.fillCurrentAddress(Credentials.CURRENT_ADDRESS_INPUT);
        textBox.fillPermanentAddressNameInput(Credentials.PERMANENT_ADDRESS_NAME_INPUT);
        textBox.ClickSubmitButton();
        textBox.fillFullNameInputCheck(Credentials.FULL_NAME_INPUT);
        textBox.fillEmailInputCheck(Credentials.EMAIL_INPUT);
        textBox.fillCurrentAddressCheck(Credentials.CURRENT_ADDRESS_INPUT);
        textBox.fillPermanentAddressNameInputCheck(Credentials.PERMANENT_ADDRESS_NAME_INPUT);
        //sleep(50_000);
    }
}
