package com.example.testtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();

        wd.manage().window().maximize();
        wd.navigate().to("https://yandex.ru/");

    }

    protected void filterItem(Item item1) throws InterruptedException {
        click(By.cssSelector("[href*='catalog--" + item1.getItemType() +"']"));

        type(By.id("glpricefrom"), item1.getPriceFrom());
        type(By.id("glpriceto"), item1.getPriceTo());


        delay(1000);
        click(By.xpath("//span[text()='" + item1.getItem() + "']"));
        //click(By.cssSelector(".LhMupC0dLR"));
    }

    protected void selectComputers() {
        click(By.cssSelector("[href*='kompiuternaia-tekhnika']"));
    }

    protected void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void delay(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
    }

    protected void switchToNextWindow() {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();

   /*     wd.findElement(locator).sendKeys(Keys.CONTROL + "a");
        wd.findElement(locator).sendKeys(Keys.DELETE);
*/
        if(text != null){
            wd.findElement(locator).sendKeys(text);
        }
    }
}
