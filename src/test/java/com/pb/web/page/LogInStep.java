package com.pb.web.page;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LogInStep {
    // WebDriver utilizado para interactuar con el navegador
    public static WebDriver driver;

    // XPaths para los elementos de la página de inicio de sesión
    private static final String USER_NAME_XPATH = "//*[@id='loginPanel']/form/div[1]/input";
    private static final String PASSWORD_XPATH = "//*[@id='loginPanel']/form/div[2]/input";
    public static final String BTN_LOGIN_XPATH = "//*[@id='loginPanel']/form/div[3]/input";
    public static final String MSG_TEXT_USER_CREATED_EXIT_XPATH = "//*[@id='leftPanel']/p/b";
    private static final int ADDITIONAL_WAIT_SECONDS = 10;

    // Constructor que inicializa el WebDriver
    public LogInStep(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Inicia sesión utilizando las credenciales proporcionadas en el DataTable.
     * @param datos DataTable que contiene las credenciales de inicio de sesión.
     */
    public static void validoInicioSesionCuenta(DataTable datos){
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Verificar que el DataTable no sea nulo
            if (datos == null) {
                throw new IllegalArgumentException("El DataTable proporcionado es nulo.");
            }

            // Extraer el nombre de usuario y la contraseña del DataTable
            String username = getValueFromDataTable(datos, "username");
            ingresarUserName(username);

            String password = getValueFromDataTable(datos, "password");
            ingresarPassword(password);


        } catch (Exception e) {
            // Imprimir la traza de la pila para depuración
            System.out.println("Ocurrió un error al loggear el usuario:");
            e.printStackTrace();
        }
    }

    private static String getValueFromDataTable(DataTable datos, String key) {
        return datos.asMaps(String.class, String.class).get(0).get(key);
    }


    public static void ingresarUserName(String username) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_NAME_XPATH)));
            usernameElement.clear();
            usernameElement.sendKeys(username);
        } catch (NoSuchElementException e) {
            // Mensaje de error si el campo de nombre de usuario no se encuentra
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            // Mensaje de error si el tiempo de espera para encontrar el campo se agota
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }


    public static void ingresarPassword(String password) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_XPATH)));
            passwordElement.clear();
            passwordElement.sendKeys(password);
        } catch (NoSuchElementException e) {
            // Mensaje de error si el campo de contraseña no se encuentra
            System.out.println("El campo de contraseña no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            // Mensaje de error si el tiempo de espera para encontrar el campo se agota
            System.out.println("El tiempo de espera para encontrar el campo de contraseña se agotó: " + e.getMessage());
        }
    }

    public static void clicBtnLogIn(){
        WebDriver driver = HomeStep.driver;

        // Verificar que el WebDriver esté inicializado
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Ensure that HomeStep.initDriver() has been called.");
        }

        try {
            // Configurar WebDriverWait para esperar hasta que el botón sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement btnLogIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_LOGIN_XPATH)));

            // Esperar tiempo adicional si es necesario (opcional)
            wait.until(new RegistrationStep.AdditionalTimeCondition(ADDITIONAL_WAIT_SECONDS));

            // Intentar hacer clic en el botón de inicio de sesión
            btnLogIn.click();
        } catch (Exception e) {
            // Imprimir la traza de la pila para depuración
            e.printStackTrace();
            // Lanzar una RuntimeException con un mensaje descriptivo
            throw new RuntimeException("Fallo al intentar hacer click en el boton de Log In", e);
        }
    }

    public static void usuarioLoggedIN(){
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement mensajeUsuarioLogueado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MSG_TEXT_USER_CREATED_EXIT_XPATH)));

            // Esperar tiempo adicional si es necesario (opcional)
            wait.until(new RegistrationStep.AdditionalTimeCondition(ADDITIONAL_WAIT_SECONDS));

            // Confirmar que el usuario ha iniciado sesión exitosamente
            System.out.println("El usuario se loggeo de manera exitosa");
        } catch (Exception e) {
            // Imprimir la traza de la pila para depuración
            e.printStackTrace();
            // Lanzar una RuntimeException con un mensaje descriptivo
            throw new RuntimeException("Fallo al loguearse", e);
        }
    }
}
