package com.pb.web.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import static com.pb.web.page.RegistrationStep.*;


public class RegistrationStepDefinition {

    @And("doy click en el boton Register")
    public void clickBotonRegister() {
        clickBtnRegister();
    }

    @And("llena los campos del formulario con información aleatoria")
    public void llenoLosCamposDelFormulatioConInformacionAleatoria(DataTable datos) {
        RegistrarUsuario(datos);
    }

    @And("doy click en el botón registraar usuario")
    public void clickBotonRegistrar() {
        clicBtnRegistrarUsuario();
    }

    @And ("valida que se despliega el mensaje de éxito")
    public void despliegueMensajeExito() {
        despliegueMensajeExitoso();
    }

}
