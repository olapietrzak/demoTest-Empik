package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageTui {

        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver(); // Utwórz nowy egzemplarz ChromeDrivera
            driver.get("https://www.tui.pl/"); // Otwórz stronę TUI.pl
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //Zaakceptuje politykę
            // Znajdź element przycisku "Akceptuję"
            WebElement acceptButton = driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));

            // Kliknięcie w przycisk "Akceptuję"
            acceptButton.click();

            // Wybierz opcje: w menu Typ Wyjazdu
            WebElement typetripOption = driver.findElement(By.xpath("//button[@class='dropdown-field dropdown-field--trip-type dropdown-field--default']"));
            typetripOption.click();

            // wybierz opcje: narty
            WebElement skiCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Narty']"));
            skiCheckbox.click();
            driver.manage().timeouts().implicitlyWait(159, TimeUnit.SECONDS);

            //Wyszukaj parametry
            WebElement searchButton = driver.findElement(By.xpath("(//span[normalize-space()='Szukaj'])[1]"));
            searchButton.click();

            driver.quit(); // Zamknij przeglądarkę
        }
    }