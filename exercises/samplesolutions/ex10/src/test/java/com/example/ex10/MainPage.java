package com.example.ex10;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement searchTextbox = $(By.name("q"));
    private SelenideElement searchButton = $(By.xpath("//*[@id=\"mntl-search-form--open_1-0\"]/form/div/button"));
    private SelenideElement mealsLink =  $(By.xpath("//*[@id=\"mntl-header-nav_1-0\"]/div[1]/ul/li[2]/a"));
    private SelenideElement lunchLink =  $(By.xpath("//*[@id=\"mntl-header-nav_1-0\"]/div[1]/ul/li[2]/ul/li[2]/a"));

    public void search(String query) {
        //searchIcon.click();
        searchTextbox.click();
        searchTextbox.sendKeys(query);
        searchButton.click();
    }
    public void openLunch() {
        mealsLink.hover();
        lunchLink.click();
    }



}
