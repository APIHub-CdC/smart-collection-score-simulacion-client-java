# smart-collection-score-simulacion-client-java [![GitHub Packages](https://img.shields.io/badge/Maven&nbsp;package-Last&nbsp;version-lemon)](https://github.com/orgs/APIHub-CdC/packages?repo_name=fintechscore-simulacion-client-java) 

<br/><img src='https://github.com/APIHub-CdC/imagenes-cdc/blob/master/circulo_de_credito-apihub.png' height='37' width='160'/><br/>

## Requisitos

1. Java >= 1.7
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***src/test/java/io/SmartCollectionScoreSimulacion/test/SmartCollectionScoreSimulacionApiTest.java***

Es importante contar con el setUp() que se encargará de inicializar la petición. Por tanto, se debe modificar la URL (**the_url**); y la API KEY (**your_api_key**), como se muestra en el siguiente fragmento de código:

```java
@Before()
public void setUp() {
    this.xApiKey = "your_api_key";
    this.apiClient = api.getApiClient();
    this.apiClient.setBasePath("the_url");
}
```

La petición se deberá modificar el siguiente fragmento de código con los datos correspondientes:

> **NOTA:** Para más ejemplos de simulación, consulte la colección de Postman.

```java

    @Test
    public void getReporteTest() throws ApiException {
        
        Peticion body = new Peticion();
        
        Integer estatusOK = 200;
        Integer estatusNoContent = 204;
        
        try {
        	
        	body.setFolioOtorgante("folioOtorgante");
            body.setNumeroCuenta("numeroCuenta");
            body.setTipoContrato(CatalogoTipoContrato.TC);
            body.setTipoCuenta(CatalogoTipoCuenta.R);
            body.setTipoFrecuencia(CatalogoTipoFrecuencia.M);
            body.setVentanaDeTiempo(CatalogoVentanaTiempo._1M);
            body.setFronteraDeImpago(CatalogoFronteraDeImpago.NUMBER_30);
            body.setPeriodosVencidos(CatalogoPeriodosVencidos._1);
            body.setSaldoVencido("saldoVencido");
            body.setSaldoActual("saldoActual");
            
            ApiResponse<?>  response = api.getReporteWithHttpInfo(xApiKey, body);
            
        	Assert.assertTrue(estatusOK.equals(response.getStatusCode()));
            
            if(estatusOK.equals(response.getStatusCode())) {
                Respuesta responseOK = (Respuesta) response.getData();
                logger.info(responseOK.toString());
            }

        } catch (ApiException e) {
            if(!estatusNoContent.equals(e.getCode())) {
                logger.info(e.getResponseBody());
            }
            Assert.assertTrue(estatusOK.equals(e.getCode()));           
        }
    }
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```

---
[CONDICIONES DE USO, REPRODUCCIÓN Y DISTRIBUCIÓN](https://github.com/APIHub-CdC/licencias-cdc)

[1]: https://getcomposer.org/doc/00-intro.md#installation-linux-unix-macos
