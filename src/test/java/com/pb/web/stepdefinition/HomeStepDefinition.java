package com.pb.web.stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.pb.web.page.HomeStep.*;


public class HomeStepDefinition {

    @Given("el usuario ingresa la pagina")
    public void ingreso_Pagina_Inicio() {
        pagina_Inicio();
    }

    @When("doy click en el boton de About Us")
    public void doyclickBtnAboutUs(){
        click_Btn_About_Us();
    }
}
