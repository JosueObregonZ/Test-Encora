package com.pb.web.stepdefinition;

import io.cucumber.java.en.And;

import static com.pb.web.page.LogOutSep.clickBtnCerrarSesion;

public class LogOutStepDefinition {

    @And ("doy click en el boton de cerrar sesion")
    public void clickBotonCerrarSesion() {
        clickBtnCerrarSesion();
    }

}