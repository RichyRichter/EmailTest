import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;


public class EmailPage {
    public WebDriver driver;
    public String text = "Добрый день\n" +
            "\n" +
            "Простейший автотест готов\n" +
            "\n" +
            "Сидоров Вадим";


    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'UserID-Avatar_plus')]")
    private WebElement userMenu;


    @FindBy(xpath = "//*[contains(@class, 'Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__comp" +
            "ose--pTDsx qa-LeftColumn-ComposeButton ComposeButton-m__root--fP-o9')]")
    private WebElement writeBtn;


    public void enterMail() {
        userMenu.click();
        driver.get("https://mail.yandex.ru/");
        writeBtn.click();
        driver.findElement(By.className("composeYabbles")).sendKeys(ConfProperties.getProperty("email"));
        driver.findElement(By.className("cke_wysiwyg_div")).sendKeys(text);
        driver.findElement(By.cssSelector("button.Button2.Button2_pin_circle-circle.Button2_view_default." +
                "Button2_size_l")).click();

    }

    public void entryMenu() {
        userMenu.click();
    }
}