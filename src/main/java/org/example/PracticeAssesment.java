package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class PracticeAssesment {

    private ChromeDriver driver;

    ///*
    //Practice assessment 1:
    //Goto https://rahulshettyacademy.com/loginpagePractise/ and login with username: rahulshettyacademy and Password: learning
    //Verify if you are logged in
    //Add any product to cart
    //Verify if product is added to cart
    //Goto Checkout page
    //Increase quantity by 4
    //Verify the price
    //Checkout and purchase
    //
    @Before
    public void setUp() {
        // Ustawienia sterownika Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testPage() {
        //Otwórz stronę
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Zaloguj się//

        //Znajdź element Login rahulshettyacademy
        WebElement loginField = driver.findElement(By.xpath("//input[@id='username']"));
        loginField.sendKeys("rahulshettyacademy");
        //Znajdź element Hasło learning
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("learning");
        //Klikij przycisk zaloguj
        WebElement logginButton = driver.findElement(By.xpath("//input[@name='signin']"));
        logginButton.click();

        //Dodaj produkt
        WebElement addButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        addButton.click();

        WebElement checkOutOption = driver.findElement(By.cssSelector("#navbarResponsive > ul > li > a"));
        String expectedCountOfItems = "1";
        String actualCartCount = checkOutOption.getText();

        System.out.println("Aktualna liczba produktów w koszyku po dodaniu produktu: " + actualCartCount);

        if (actualCartCount.contains(expectedCountOfItems)) {
            System.out.println("Prawidłowa liczba produktów dodana do koszyka");
        } else {
            throw new IllegalStateException("Nieprawidłowa liczba produktów w koszyku");
        }
    }
}
