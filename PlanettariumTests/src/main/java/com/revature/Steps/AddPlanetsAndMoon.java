package com.revature.Steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddPlanetsAndMoon {
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        if(TestRunner.loginPage == null){
            TestRunner.setup();
        }
        TestRunner.loginPage.goToLoginPage();
        TestRunner.loginPage.setUserName("Batman");
        TestRunner.loginPage.setPassword("Iamthenight1939");
        TestRunner.loginPage.login();
    }

    @Then("the user enters a valid planet name {string}")
    public void the_user_enters_a_valid_planet_name(String name) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetName(name);
    }

    @Then("the user enters a valid planet image {string}")
    public void the_user_enters_a_valid_planet_image(String img) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetImg(img);
    }

    @Then("the user clicks the add planet button")
    public void the_user_clicks_the_add_planet_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the planet table is updated planet {string}")
    public void the_planet_table_is_updated_planet(String name) {
        // Write code here that turns the phrase above into concrete actions
        boolean isPresent = false;
        List<WebElement> tableRows = TestRunner.homePage.getTableRows();
        int rowCount = TestRunner.homePage.getNumberOfCelestialRows();
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//table[@id='celestialTable']"), name // Adjust locator for your specific table
        ));;
        for(int i = 1; i < tableRows.size(); i++){
            List<WebElement> column = tableRows.get(i).findElements(By.tagName("td"));
            if(column.get(2).getText().equals(name) && column.get(0).getText().equals("planet")){
                isPresent = true;
            }
        }
        Assert.assertTrue(isPresent);
    }

    @Then("the planet table is updated moon {string}")
    public void the_planet_table_is_updated_moon(String name) {
        // Write code here that turns the phrase above into concrete actions
        boolean isPresent = false;
        List<WebElement> tableRows = TestRunner.homePage.getTableRows();
        int rowCount = TestRunner.homePage.getNumberOfCelestialRows();
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//table[@id='celestialTable']"), name // Adjust locator for your specific table
        ));;
        for(int i = 1; i < tableRows.size(); i++){
            List<WebElement> column = tableRows.get(i).findElements(By.tagName("td"));
            if(column.get(2).getText().equals(name) && column.get(0).getText().equals("moon")){
                isPresent = true;
            }
        }
        Assert.assertTrue(isPresent);
    }

    @Then("the user enters a valid moon name {string}")
    public void the_user_enters_a_valid_moon_name(String name) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterMoonName(name);
    }

    @Then("the moon has a valid owner planet {string}")
    public void the_moon_has_a_valid_owner_planet(String id) {
        // Write code here that turns the phrase above into concrete actions
        boolean isValid = false;
        List<WebElement> tableRows = TestRunner.homePage.getTableRows();
        int rowCount = TestRunner.homePage.getNumberOfCelestialRows();
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//table[@id='celestialTable']"), id // Adjust locator for your specific table
        ));;
        for(int i = 1; i < tableRows.size(); i++){
            List<WebElement> column = tableRows.get(i).findElements(By.tagName("td"));
            if(column.get(3).getText().equals(id)){
                isValid = true;
            }
        }
        Assert.assertTrue(isValid);
    }

    @Then("the user enters a valid moon image {string}")
    public void the_user_enters_a_valid_moon_image(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterMoonImg(string);
    }

    @Then("the user clicks the add moon button")
    public void the_user_clicks_the_add_moon_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the user enters an invalid moon name {string}")
    public void the_user_enters_an_invalid_moon_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterMoonName(string);
    }

    @Then("the user enters an invalid name planet {string}")
    public void the_user_enters_an_invalid_name_planet(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetName(string);
    }

    @Then("the user add the owner planet id {string}")
    public void the_user_add_the_owner_planet_id(String id) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterMoonOrbitedPlanet(id);
    }

    @Then("the user enters a planet image {string}")
    public void the_user_enters_a_planet_image(String path) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetImg(path);
    }

    @Then("the browser gives the alert {string}")
    public void the_browser_gives_the_alert(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        String alertText = TestRunner.driver.switchTo().alert().getText();
        TestRunner.driver.switchTo().alert().accept();
        Assert.assertEquals(string, alertText);
    }

    @Then("the user add the planets image {string}")
    public void the_user_add_the_planets_image(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetImg(string);
    }

    @Then("the user enters the owner planet id {string}")
    public void the_user_enter_the_owner_planet_id(String id){
        TestRunner.homePage.enterMoonOrbitedPlanet(id);
    }
}
