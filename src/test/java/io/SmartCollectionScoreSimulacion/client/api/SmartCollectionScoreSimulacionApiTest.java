package io.SmartCollectionScoreSimulacion.client.api;

import io.SmartCollectionScoreSimulacion.client.ApiClient;
import io.SmartCollectionScoreSimulacion.client.ApiException;
import io.SmartCollectionScoreSimulacion.client.ApiResponse;
import io.SmartCollectionScoreSimulacion.client.model.CatalogoFronteraDeImpago;
import io.SmartCollectionScoreSimulacion.client.model.CatalogoPeriodosVencidos;
import io.SmartCollectionScoreSimulacion.client.model.CatalogoTipoContrato;
import io.SmartCollectionScoreSimulacion.client.model.CatalogoTipoCuenta;
import io.SmartCollectionScoreSimulacion.client.model.CatalogoTipoFrecuencia;
import io.SmartCollectionScoreSimulacion.client.model.CatalogoVentanaTiempo;

import io.SmartCollectionScoreSimulacion.client.model.Peticion;
import io.SmartCollectionScoreSimulacion.client.model.Respuesta;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartCollectionScoreSimulacionApiTest {
    private final SmartCollectionScoreSimulacionApi api = new SmartCollectionScoreSimulacionApi();
    
    private Logger logger = LoggerFactory.getLogger(SmartCollectionScoreSimulacionApi.class.getName());
	private ApiClient apiClient = null;
	private String xApiKey = null;
    
    @Before()
    public void setUp() {
        this.xApiKey = "your_api_key";
        this.apiClient = api.getApiClient();
        this.apiClient.setBasePath("the_url");

        
    }
    
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
    
}
