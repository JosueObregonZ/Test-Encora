package com.pb.web.page;

import com.pb.web.stepdefinition.RegistrationStepDefinition;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class RegistrationStep {

    // El WebDriver que se utilizará para las operaciones en la página
    public static WebDriver driver;
    public static WebDriverWait wait;

    // XPaths para los elementos de la página de registro
    public static final String BTN_REGISTER_XPATH = "//*[@id='loginPanel']/p[2]/a";
    private static final int ADDITIONAL_WAIT_SECONDS = 10;
    public static final String BTN_REGISTRO_USUARIO_XPATH = "//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input";
    public static final String MSG_TEXT_XPATH = "//*[@id='rightPanel']/p";

    // XPaths para los campos del formulario de registro
    public static final String FIRST_NAME_XPATH = "//*[@id='customer.firstName']";
    public static final String LAST_NAME_XPATH = "//*[@id='customer.lastName']";
    public static final String ADDRESS_XPATH = "//*[@id='customer.address.street']";
    public static final String CITY_XPATH = "//*[@id='customer.address.city']";
    public static final String STATE_XPATH = "//*[@id='customer.address.state']";
    public static final String ZIPCODE_XPATH = "//*[@id='customer.address.zipCode']";
    public static final String PHONE_XPATH = "//*[@id='customer.phoneNumber']";
    public static final String SSN_XPATH = "//*[@id='customer.ssn']";
    public static final String USERNAME_XPATH = "//*[@id='customer.username']";
    public static final String PASSWORD_XPATH = "//*[@id='customer.password']";
    public static final String CONFIRM_XPATH = "//*[@id='repeatedPassword']";

    // Constructor que inicializa el WebDriver
    public RegistrationStep(WebDriver driver) {
        this.driver = driver;
    }

    // Metodo para hacer clic en el botón de registro
    public static void clickBtnRegister() {
        WebDriver driver = HomeStep.driver;
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Ensure that HomeStep.initDriver() has been called.");
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Esperar hasta que el botón sea clickeable
            WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_REGISTER_XPATH)));

            // Esperar un tiempo adicional explícito antes de hacer clic
            wait.until(new AdditionalTimeCondition(ADDITIONAL_WAIT_SECONDS));

            // Hacer clic en el botón de registro
            btnRegister.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to click the 'Register' button.", e);
        }
    }

    // Condición personalizada para esperar un tiempo adicional en segundos
    static class AdditionalTimeCondition implements org.openqa.selenium.support.ui.ExpectedCondition<Boolean> {
        private final long endTime;

        public AdditionalTimeCondition(int additionalWaitSeconds) {
            this.endTime = System.currentTimeMillis() + (additionalWaitSeconds * 300);
        }

        @Override
        public Boolean apply(WebDriver driver) {
            // Comprobar si el tiempo adicional en segundos ha pasado
            return System.currentTimeMillis() >= endTime;
        }
    }

    // Metodo para registrar un usuario utilizando datos de DataTable
    public static void RegistrarUsuario(DataTable datos) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            if (datos == null) {
                throw new IllegalArgumentException("El DataTable proporcionado es nulo.");
            }

            String firstName = getValueFromDataTable(datos, "firstname");
            ingresarFirstName(firstName);

            String lastName = getValueFromDataTable(datos, "lastname");
            ingresarlastName(lastName);

            String addres = getValueFromDataTable(datos, "addres");
            ingresaraddres(addres);

            String city = getValueFromDataTable(datos, "city");
            ingresarcity(city);

            String state = getValueFromDataTable(datos, "state");
            ingresarstate(state);

            String zipcode = getValueFromDataTable(datos, "zipcode");
            ingresarzipcode(zipcode);

            String phone = getValueFromDataTable(datos, "phone");
            ingresarphone(phone);

            String ssn = getValueFromDataTable(datos, "ssn");
            ingresarssn(ssn);

            String username = getValueFromDataTable(datos, "username");
            ingresarusername(username);

            String password = getValueFromDataTable(datos, "password");
            ingresarpassword(password);

            String confirmpassword = getValueFromDataTable(datos, "confirm");
            ingresarconfirmpassword(confirmpassword);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al registrar el usuario:");
            e.printStackTrace();
        }
    }

    public static void ingresarFirstName(String firstName) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_NAME_XPATH)));

            // Limpia el campo si ya tiene algún valor
            firstNameElement.clear();

            // Ingresa el valor en el campo
            firstNameElement.sendKeys(firstName);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarlastName(String lastname) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement lastnameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LAST_NAME_XPATH)));

            // Limpia el campo si ya tiene algún valor
            lastnameElement.clear();

            // Ingresa el valor en el campo
            lastnameElement.sendKeys(lastname);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresaraddres(String addres) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement addresElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDRESS_XPATH)));

            // Limpia el campo si ya tiene algún valor
            addresElement.clear();

            // Ingresa el valor en el campo
            addresElement.sendKeys(addres);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarcity(String city) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement cityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CITY_XPATH)));

            // Limpia el campo si ya tiene algún valor
            cityElement.clear();

            // Ingresa el valor en el campo
            cityElement.sendKeys(city);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarstate(String state) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement stateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(STATE_XPATH)));

            // Limpia el campo si ya tiene algún valor
            stateElement.clear();

            // Ingresa el valor en el campo
            stateElement.sendKeys(state);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }




    public static void ingresarzipcode(String zipcode) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement zipcodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ZIPCODE_XPATH)));

            // Limpia el campo si ya tiene algún valor
            zipcodeElement.clear();

            // Ingresa el valor en el campo
            zipcodeElement.sendKeys(zipcode);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarphone(String phone) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_XPATH)));

            // Limpia el campo si ya tiene algún valor
            phoneElement.clear();

            // Ingresa el valor en el campo
            phoneElement.sendKeys(phone);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarssn(String ssn) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement ssnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SSN_XPATH)));

            // Limpia el campo si ya tiene algún valor
            ssnElement.clear();

            // Ingresa el valor en el campo
            ssnElement.sendKeys(ssn);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarusername(String username) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USERNAME_XPATH)));

            // Limpia el campo si ya tiene algún valor
            usernameElement.clear();

            // Ingresa el valor en el campo
            usernameElement.sendKeys(username);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarpassword(String password) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_XPATH)));

            // Limpia el campo si ya tiene algún valor
            passwordElement.clear();

            // Ingresa el valor en el campo
            passwordElement.sendKeys(password);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }

    public static void ingresarconfirmpassword(String coonfirmpassword) {
        try {
            WebDriver driver = HomeStep.driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Obtén el WebElement del campo de nombre
            WebElement confirmpasswordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM_XPATH)));

            // Limpia el campo si ya tiene algún valor
            confirmpasswordElement.clear();

            // Ingresa el valor en el campo
            confirmpasswordElement.sendKeys(coonfirmpassword);
        } catch (NoSuchElementException e) {
            System.out.println("El campo de nombre no se encontró: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("El tiempo de espera para encontrar el campo de nombre se agotó: " + e.getMessage());
        }
    }


    private static String getValueFromDataTable(DataTable datos, String key) {
        return datos.asMaps(String.class, String.class).get(0).get(key);
    }

    // Metodo para hacer clic en el botón de registrar usuario
    public static void clicBtnRegistrarUsuario() {
        WebDriver driver = HomeStep.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement btnRegistrarUsuario = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_REGISTRO_USUARIO_XPATH)));
            wait.until(new AdditionalTimeCondition(ADDITIONAL_WAIT_SECONDS));
            btnRegistrarUsuario.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Fallo en hacer clic en el botón de Registrar Usuario", e);
        }
    }

    // Metodo para verificar el mensaje de éxito
    public static void despliegueMensajeExitoso() {
        WebDriver driver = HomeStep.driver;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Wait for the visibility of the element
            WebElement msgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MSG_TEXT_XPATH)));
            // Optionally, you can add more checks or operations here if needed

            // Print success message
            System.out.println("El elemento con el XPath '" + MSG_TEXT_XPATH + "' ha sido localizado exitosamente.");
        } catch (TimeoutException e) {
            // Handle timeout specifically
            System.err.println("Timeout: No se pudo localizar el elemento con el XPath '" + MSG_TEXT_XPATH + "' en el tiempo esperado.");
            throw new RuntimeException("Fallo al verificar el mensaje de éxito", e);
        } catch (NoSuchElementException e) {
            // Handle no such element specifically
            System.err.println("NoSuchElementException: El elemento con el XPath '" + MSG_TEXT_XPATH + "' no existe.");
            throw new RuntimeException("Fallo al verificar el mensaje de éxito", e);
        } catch (Exception e) {
            // General exception handler
            e.printStackTrace();
            throw new RuntimeException("Fallo al verificar el mensaje de éxito", e);
        }
    }
}
