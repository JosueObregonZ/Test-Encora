# TEST ENCORA

## Descripción

Este repositorio contiene el proyecto **TEST ENCORA**, que se centra en el [Realizar la creacion y el logueo de la nueva cuenta generada e iniciar sesion con la nueva cuenta generada]. El proyecto utiliza una arquitectura de pruebas automatizadas con componentes clave.

## Componentes Utilizados

### Page

Los archivos en esta sección contienen las **Page Objects**, que representan las páginas de la aplicación web. La idea detrás del patrón de diseño Page Object es separar el código de las pruebas de la lógica de la interfaz de usuario para mejorar la mantenibilidad y la reutilización.

### Runner

Los archivos en esta sección se encargan de **ejecutar** las pruebas. Estos scripts configuran y lanzan el entorno de pruebas, especificando qué pruebas deben correr y cómo deben ejecutarse.

### StepDefinition

Los archivos en esta sección definen los **pasos** específicos que se ejecutan en las pruebas. Cada paso corresponde a una acción o una verificación en la prueba automatizada, y está vinculado a un escenario definido en los archivos de **feature**.

### Utility

Los archivos en esta sección contienen **funciones de utilidad** que se utilizan en todo el proyecto para realizar tareas comunes que no están directamente relacionadas con la lógica de las pruebas, pero que son necesarias para su ejecución, como operaciones de archivo o manipulaciones de datos.

### Driver

Los archivos en esta sección configuran y gestionan el **driver** del navegador. Aquí se establecen las capacidades del navegador, se configuran las opciones y se manejan las instancias del navegador durante la ejecución de las pruebas.

### Feature

Los archivos en esta sección definen los **escenarios** de prueba en formato Gherkin. Estos archivos describen el comportamiento esperado de la aplicación desde la perspectiva del usuario final en lenguaje natural, facilitando la comprensión y la colaboración en el desarrollo de pruebas.

## Estructura del Proyecto

Este proyecto requiere las siguientes herramientas instaladas y configuradas:

- **Java 11**: [Descargar e instalar](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Maven**: [Descargar e instalar](https://maven.apache.org/install.html)
- **Selenium**: Incluido a través de Maven.
- **Cucumber**: Incluido a través de Maven.
- **WebDriverManager**: Incluido a través de Maven.

## Configuracion de JUnit para ejecutar tags

Para utilizar mejor los tags, podrá ejecutar los tags dirigiendose al lado superior derecha desglosando (Current File), dando click en edit confi configurations y prodcede a:
Configurar seleccionando el java 11 y la clase: com.pb.web.runner.TestRunner

# 1ra clase 'HomeStep' - Página de Inicio para Pruebas de Selenium

Proporciona métodos para inicializar el navegador, abrir la página de inicio de Parabank y realizar acciones relacionadas con la página de inicio, como hacer clic en el botón "About Us". Utiliza Selenium WebDriver para la automatización de pruebas web.

## Requisitos

- Java 11 o superior
- Selenium WebDriver
- WebDriverManager
- ChromeDriver

## Configuración


--------------------------


## 2da Clase `LogInStep`

La clase `LogInStep` proporciona métodos para manejar el proceso de inicio de sesión en la aplicación web. Utiliza Selenium WebDriver para interactuar con los elementos de la página de inicio de sesión, incluyendo los campos de nombre de usuario y contraseña, y el botón de inicio de sesión.

### Funcionalidad

Esta clase permite:
- Introducir un nombre de usuario y una contraseña en los campos correspondientes.
- Hacer clic en el botón de inicio de sesión.
- Verificar que el usuario haya iniciado sesión correctamente.

### Métodos

#### `public static void validoInicioSesionCuenta(DataTable datos)`

Inicia sesión con las credenciales proporcionadas en el `DataTable`.

- **Descripción**: Este método extrae el nombre de usuario y la contraseña del `DataTable`, los introduce en los campos correspondientes y luego envía las credenciales.
- **Parámetros**:
  - `datos`: Un `DataTable` que contiene las credenciales de inicio de sesión bajo las claves "username" y "password".
- **Excepciones**:
  - Lanza una `IllegalArgumentException` si el `DataTable` es nulo.
  - Lanza una `RuntimeException` si ocurre algún error al interactuar con los campos o el botón.

#### `public static void ingresarUserName(String firstName)`

Introduce el nombre de usuario en el campo de entrada correspondiente.

- **Descripción**: Localiza el campo de nombre de usuario mediante su XPath, lo limpia y luego introduce el nombre de usuario.
- **Parámetros**:
  - `firstName`: El nombre de usuario que se debe introducir.
- **Excepciones**:
  - Lanza una `NoSuchElementException` si el campo no se encuentra.
  - Lanza una `TimeoutException` si el tiempo de espera para encontrar el campo se agota.

#### `public static void ingresarPassword(String lastname)`

Introduce la contraseña en el campo de entrada correspondiente.

- **Descripción**: Localiza el campo de contraseña mediante su XPath, lo limpia y luego introduce la contraseña.
- **Parámetros**:
  - `lastname`: La contraseña que se debe introducir.
- **Excepciones**:
  - Lanza una `NoSuchElementException` si el campo no se encuentra.
  - Lanza una `TimeoutException` si el tiempo de espera para encontrar el campo se agota.

#### `public static void clicBtnLogIn()`

Hace clic en el botón de inicio de sesión.

- **Descripción**: Localiza el botón de inicio de sesión mediante su XPath, espera a que sea clickeable, y luego hace clic en él.
- **Excepciones**:
  - Lanza una `RuntimeException` si el `WebDriver` no está inicializado o si ocurre un error al intentar hacer clic en el botón.

#### `public static void usuarioLoggedIN()`

Verifica que el usuario ha iniciado sesión correctamente.

- **Descripción**: Espera a que un mensaje de confirmación de inicio de sesión aparezca en la página. Si se encuentra el mensaje, imprime una confirmación en la consola.
- **Excepciones**:
  - Lanza una `RuntimeException` si ocurre un error al verificar el estado del inicio de sesión.

### Detalles del Código

- **XPath para Nombre de Usuario**: `//*[@id='loginPanel']/form/div[1]/input`
- **XPath para Contraseña**: `//*[@id='loginPanel']/form/div[2]/input`
- **XPath para Botón de Inicio de Sesión**: `//*[@id='loginPanel']/form/div[3]/input`
- **XPath para Mensaje de Confirmación de Inicio de Sesión**: `//*[@id='leftPanel']/p/b`
- **Tiempo de Espera Adicional**: `10` segundos

### Ejemplo de Uso

Aquí tienes un ejemplo básico de cómo utilizar la clase `LogInStep`:


--------------------------


## 3ra Clase `LogOutStep`

La clase `LogOutStep` maneja el proceso de cierre de sesión en la aplicación web. Utiliza Selenium WebDriver para interactuar con el botón de cierre de sesión y realizar la acción correspondiente. A continuación se describe la funcionalidad y el uso de la clase `LogOutStep`.

### Funcionalidad

La clase `LogOutStep` proporciona un método para hacer clic en el botón de cierre de sesión de la aplicación, lo que permite al usuario cerrar su sesión activa.

### Métodos

#### `public static void clickBtnCerrarSesion()`

Hace clic en el botón de cierre de sesión para cerrar la sesión del usuario.

- **Descripción**: Este método localiza el botón de cierre de sesión mediante su XPath, espera a que sea clickeable, y luego hace clic en él.
- **Excepciones**:
  - Lanza una `RuntimeException` si el `WebDriver` no está inicializado.
  - Lanza una `RuntimeException` con un mensaje descriptivo si ocurre algún error durante la operación de clic.

### Detalles del Código

- **XPath del Botón de Cierre de Sesión**: `//*[@id='leftPanel']/ul/li[8]/a`

  Este XPath se utiliza para localizar el botón de cierre de sesión en la interfaz de usuario.

- **Tiempo de Espera Adicional**: `10` segundos

  Después de esperar a que el botón sea clickeable, se espera un tiempo adicional opcional para asegurar que la operación de clic se complete correctamente.

### Manejo de Excepciones

- **`RuntimeException`**: Se lanza si el `WebDriver` no está inicializado o si ocurre un error al intentar hacer clic en el botón de cierre de sesión. La excepción incluye una traza de pila para facilitar la depuración.


--------------------------


## 4ta Clase `RegistrationStep`

La clase `RegistrationStep` está diseñada para manejar las operaciones relacionadas con el registro de usuarios en la aplicación web. Utiliza Selenium WebDriver para interactuar con los elementos del formulario de registro y realizar diversas acciones. A continuación se describe la funcionalidad y el uso de cada método en esta clase.

### Funcionalidad

- **Inicialización del WebDriver**

  La clase `RegistrationStep` utiliza una instancia estática de `WebDriver` para interactuar con la aplicación. Asegúrate de inicializar el `WebDriver` antes de invocar cualquier método de esta clase.

### Métodos

#### `public RegistrationStep(WebDriver driver)`

Constructor que inicializa la clase con una instancia de `WebDriver`.

- **Parámetros**:
  - `driver`: Instancia de `WebDriver` que se usará para las interacciones con la web.

#### `public static void clickBtnRegister()`

Hace clic en el botón de registro en la página principal.

- **Excepciones**: Lanza una `RuntimeException` si ocurre algún error al intentar hacer clic en el botón de registro.

#### `public static void RegistrarUsuario(DataTable datos)`

Rellena el formulario de registro con los datos proporcionados en el `DataTable`.

- **Parámetros**:
  - `datos`: `DataTable` que contiene los datos del formulario (nombre, apellido, dirección, etc.).
- **Excepciones**: Lanza `IllegalArgumentException` si `datos` es nulo. Lanza `RuntimeException` si ocurre un error durante el registro.

#### `public static void ingresarFirstName(String firstName)`

Ingresa el primer nombre en el campo correspondiente del formulario.

- **Parámetros**:
  - `firstName`: Primer nombre del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarLastName(String lastName)`

Ingresa el apellido en el campo correspondiente del formulario.

- **Parámetros**:
  - `lastName`: Apellido del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarAddres(String address)`

Ingresa la dirección en el campo correspondiente del formulario.

- **Parámetros**:
  - `address`: Dirección del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarCity(String city)`

Ingresa la ciudad en el campo correspondiente del formulario.

- **Parámetros**:
  - `city`: Ciudad del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarState(String state)`

Ingresa el estado en el campo correspondiente del formulario.

- **Parámetros**:
  - `state`: Estado del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarZipcode(String zipcode)`

Ingresa el código postal en el campo correspondiente del formulario.

- **Parámetros**:
  - `zipcode`: Código postal del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarSSN(String ssn)`

Ingresa el número de seguro social en el campo correspondiente del formulario.

- **Parámetros**:
  - `ssn`: Número de seguro social del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarPhone(String phone)`

Ingresa el número de teléfono en el campo correspondiente del formulario.

- **Parámetros**:
  - `phone`: Número de teléfono del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarUserName(String username)`

Ingresa el nombre de usuario en el campo correspondiente del formulario.

- **Parámetros**:
  - `username`: Nombre de usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarPassword(String password)`

Ingresa la contraseña en el campo correspondiente del formulario.

- **Parámetros**:
  - `password`: Contraseña del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `public static void ingresarConfirm(String confirmPassword)`

Ingresa la confirmación de contraseña en el campo correspondiente del formulario.

- **Parámetros**:
  - `confirmPassword`: Confirmación de la contraseña del usuario.
- **Excepciones**: Maneja `NoSuchElementException` y `TimeoutException` si ocurre un error al localizar o interactuar con el campo.

#### `private static String getValueFromDataTable(DataTable datos, String key)`

Obtiene el valor asociado a una clave específica del `DataTable`.

- **Parámetros**:
  - `datos`: `DataTable` que contiene los datos del formulario.
  - `key`: Clave del valor que se desea obtener.
- **Retorna**: El valor asociado a la clave.

#### `public static void clicBtnRegistrarUsuario()`

Hace clic en el botón de registrar usuario para enviar el formulario.

- **Excepciones**: Lanza una `RuntimeException` si ocurre algún error al intentar hacer clic en el botón de registrar usuario.

#### `public static void despliegueMensajeExitoso()`

Verifica que se haya desplegado el mensaje de éxito en el registro.

- **Excepciones**: Lanza una `RuntimeException` si ocurre algún error al verificar el mensaje de éxito.

### Excepciones Manejas

- `NoSuchElementException`: Se lanza si un elemento no se encuentra en la página.
- `TimeoutException`: Se lanza si la espera para encontrar un elemento expira.
- `RuntimeException`: Se lanza para errores generales en los métodos de la clase.
