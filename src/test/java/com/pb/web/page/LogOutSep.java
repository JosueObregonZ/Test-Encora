package com.pb.web.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LogOutSep {

    private static final String BTN_LOG_OUT_XPATH = "//*[@id='leftPanel']/ul/li[8]/a";
    private static final int ADDITIONAL_WAIT_SECONDS = 10;

    public static void clickBtnCerrarSesion() {
        WebDriver driver = HomeStep.driver;

        // Verificar que el WebDriver esté inicializado
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Ensure that HomeStep.initDriver() has been called.");
        }

        try {
            // Configurar WebDriverWait para esperar hasta que el botón sea clickeable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnLogOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BTN_LOG_OUT_XPATH)));

            // Esperar tiempo adicional si es necesario (opcional)
            wait.until(new HomeStep.AdditionalTimeCondition(ADDITIONAL_WAIT_SECONDS));

            // Intentar hacer clic en el botón de cierre de sesión
            btnLogOut.click();
        } catch (Exception e) {
            // Imprimir la traza de la pila para depuración
            e.printStackTrace();

            // Lanzar una RuntimeException con un mensaje descriptivo
            throw new RuntimeException("Fallo en hacer click en el boton de Log Out", e);
        }
    }
}
