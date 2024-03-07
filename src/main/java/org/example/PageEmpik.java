package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PageEmpik {

    public WebDriver driver;

    @Before
    public void setUp() {
        // Ustawienia sterownika Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSectionHomePage() {
        //Otwórz stronę
        driver.get("https://www.empik.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Zaakceptuj polityke prywatnosci
        WebElement button = driver.findElement(By.xpath("//button[@data-ta='cookie-btn-accept-all']"));
        button.click();

        // Znajdź element paska wyszukiwania
        WebElement searchHomepage = driver.findElement(By.xpath("//input[@placeholder='Wpisz czego szukasz']"));
        searchHomepage.sendKeys("Marka osobista w IT");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and @class='css-1m7bysf-root-l']"));
        searchButton.click();

            // Otwórz pierwszy wyszukany element
        WebElement firstSearchElement = driver.findElement(By.xpath("//div[@class='search-list-item-hover']"));
            //Sprawdź, czy jakikolwiek element jest dostępny
        assertTrue(firstSearchElement.isDisplayed());

        driver.quit();
}}
