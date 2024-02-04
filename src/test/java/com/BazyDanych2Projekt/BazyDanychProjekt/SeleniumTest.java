package com.BazyDanych2Projekt.BazyDanychProjekt;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

@TestMethodOrder(MethodOrderer.MethodName.class)
@Tag("Selenium")
public class SeleniumTest {
    public static EdgeOptions edgeOptions;
    public static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        webDriver = new EdgeDriver(edgeOptions);
        webDriver.get("http://localhost:4000/seller/");
    }

    @Test
    @Order(1)
    void addProduct() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id=\"underwearID\"]")).sendKeys("1");
        webDriver.findElement(By.xpath("//*[@id=\"modelID\"]")).sendKeys("2");
        webDriver.findElement(By.xpath("//*[@id=\"size\"]")).sendKeys("XXL");
        webDriver.findElement(By.xpath("//*[@id=\"color\"]")).sendKeys("Pink");
        webDriver.findElement(By.xpath("//*[@id=\"sku\"]")).sendKeys("SKU1234567890");
        webDriver.findElement(By.xpath("//*[@id=\"ean\"]")).sendKeys("10987654321");
        webDriver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys("9");
        webDriver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys("24.99");

        webDriver.findElement(By.xpath("//*[@id=\"addBtn\"]")).click();

        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@id=\"underwearID\"]")).sendKeys("2");
        webDriver.findElement(By.xpath("//*[@id=\"modelID\"]")).sendKeys("2");
        webDriver.findElement(By.xpath("//*[@id=\"size\"]")).sendKeys("S");
        webDriver.findElement(By.xpath("//*[@id=\"color\"]")).sendKeys("Black");
        webDriver.findElement(By.xpath("//*[@id=\"sku\"]")).sendKeys("SKU112233446543");
        webDriver.findElement(By.xpath("//*[@id=\"ean\"]")).sendKeys("53426675853");
        webDriver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys("20");
        webDriver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys("89.99");

        webDriver.findElement(By.xpath("//*[@id=\"addBtn\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/button[1]")).click();

        WebElement productID = webDriver.findElement(By.xpath("//*[@id=\"underwearResultsContainer\"]/table/tbody/tr[3]/td[1]"));

        String actualID = productID.getText();
        String expectedID = "2";

        Assert.assertEquals(expectedID, actualID);

        WebElement productSKU = webDriver.findElement(By.xpath("//*[@id=\"underwearResultsContainer\"]/table/tbody/tr[4]/td[5]"));

        String actualSKU = productSKU.getText();
        String expectedSKU = "331246731";

        Assert.assertEquals(expectedSKU, actualSKU);
    }

    @Test
    @Order(2)
    void deleteProducts() {
        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/input")).sendKeys("2");
        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/button[2]")).click();

        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/input")).sendKeys("1");
        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/button[2]")).click();

        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/button[1]")).click();
    }

    @Test
    @Order(3)
    void changeState() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/button[1]")).click();

        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//*[@id=\"orderResultsContainer\"]/table/tbody/tr[6]/td[6]/form/select")).click();

        Thread.sleep(500);

        webDriver.findElement(By.xpath("//*[@id=\"orderResultsContainer\"]/table/tbody/tr[1]/td[6]/form/select/option[3]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"searchForm\"]/button[1]")).click();
    }

    @Test
    @Order(4)
    void switchMode() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/h2[1]/a")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/a[2]/h1")).click();

        WebElement productID = webDriver.findElement(By.xpath("//*[@id=\"underwearResultsContainer\"]/table/tbody/tr[2]/td[1]"));

        String actualID = productID.getText();
        String expectedID = "7";

        Assert.assertEquals(expectedID, actualID);

        WebElement productEAN = webDriver.findElement(By.xpath("//*[@id=\"underwearResultsContainer\"]/table/tbody/tr[2]/td[6]"));

        String actualEAN = productEAN.getText();
        String expectedEAN = "8765434567";

        Assert.assertEquals(expectedEAN, actualEAN);
    }
}
