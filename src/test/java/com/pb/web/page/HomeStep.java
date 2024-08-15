package com.pb.web.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeStep {

    // Instancia del WebDriver para controlar el navegador
    public static WebDriver driver;

    /**
     * Inicializa el WebDriver, maximiza la ventana del navegador y abre la página de inicio.
     */
    public static void pagina_Inicio() {
        // Configura el WebDriver para usar Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximiza la ventana del navegador
        driver.manage().window().maximize();
        // Navega a la URL especificada
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    // XPath del botón "About Us"
    private static final String BTN_ABOUT_US_XPATH = "//*[@id='headerPanel']/ul[1]/li[2]/a";
    private static final int ADDITIONAL_WAIT_SECONDS = 10; // Tiempo adicional en segundos

    /**
     * Hace clic en el botón "About Us" después de asegurarse de que sea clickeable.
     */
    public static void click_Btn_About_Us() {
        WebDriver driver = HomeStep.driver;

        // Verificar que el WebDriver esté inicializado
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Ensure that HomeStep.pagina_Inicio() has been called.");
        }

        try {
            // Configurar WebDriverWait para esperar hasta que el botón sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnAboutUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_ABOUT_US_XPATH)));

            // Esperar un tiempo adicional explícito antes de hacer clic
            wait.until(new HomeStep.AdditionalTimeCondition(ADDITIONAL_WAIT_SECONDS));

            // Hacer clic en el botón "About Us"
            btnAboutUs.click();
        } catch (Exception e) {
            // Imprimir la traza de la pila para depuración
            e.printStackTrace();
            // Lanzar una RuntimeException con un mensaje descriptivo
            throw new RuntimeException("Fallo en intentar hacer click en el boton de About Us", e);
        }
    }

    // Condición personalizada para esperar un tiempo adicional en segundos
    static class AdditionalTimeCondition implements org.openqa.selenium.support.ui.ExpectedCondition<Boolean> {
        private final long endTime;

        /**
         * Inicializa la condición con un tiempo adicional en segundos.
         * @param additionalWaitSeconds Tiempo adicional a esperar en segundos.
         */
        public AdditionalTimeCondition(int additionalWaitSeconds) {
            this.endTime = System.currentTimeMillis() + (additionalWaitSeconds * 1000);
        }

        @Override
        public Boolean apply(WebDriver driver) {
            // Comprobar si el tiempo adicional ha pasado
            return System.currentTimeMillis() >= endTime;
        }
    }
}
