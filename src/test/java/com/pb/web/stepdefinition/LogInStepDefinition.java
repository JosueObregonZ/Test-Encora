package com.pb.web.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import static com.pb.web.page.LogInStep.*;

public class LogInStepDefinition {

    @Then("valido el inicio de sesión con la cuenta creada")
    public void validoInicioSesionCuentaCreada(DataTable datos){
        validoInicioSesionCuenta(datos);
        clicBtnLogIn();
        usuarioLoggedIN();
    }
}
