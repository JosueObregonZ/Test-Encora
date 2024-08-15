##POSTULANTE: Josue Obregon
##GDAP:GDAP-#QA01
##TAG: @CrearUsuario
##FECH.MOD: 09/08/2024

@PARABANK
Feature: Registro de nuevo usuario


  @PRUEBA
  Scenario: Realizar la creacion y el logueo de la nueva cuenta generada
    Given el usuario ingresa la pagina
    When doy click en el boton de About Us
    And doy click en el boton Register
    And llena los campos del formulario con información aleatoria

      | firstname  | lastname       | addres               | city      | state     | zipcode  | phone     | ssn      | username    | password      | confirm       |
      | Josue      | Obregon Zapata |  Av.Roca y Bolona 251 | Lima      |  Peru     | 15046    | 950178729 | 76589753 | JosueQA    | Parabank      | Parabank      |

    And doy click en el botón registraar usuario
    And valida que se despliega el mensaje de éxito
    And doy click en el boton de cerrar sesion
    Then valido el inicio de sesión con la cuenta creada

    | username    | password       |
    | JosueQA    | Parabank        |


  @PRUEBA02
  Scenario: Iniciar sesion con la nueva cuenta generada
    Given el usuario ingresa la pagina
    Then valido el inicio de sesión con la cuenta creada
    | username    | password            |
    | JosueQA     | Parabank            |
