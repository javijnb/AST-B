/**
 * IMCSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package imc;

import imc.GetImcResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.net.URI;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.*;

import java.nio.charset.Charset;


/**
 *  IMCSkeleton java skeleton for the axisService
 */
public class IMCSkeleton {
    /**
     * Auto generated method signature
     *
     * @param getImc
     * @return getImcResponse
     */
    public imc.GetImcResponse getImc(imc.GetImc getImc) throws IOException {
        float peso = getImc.getPeso();
        float altura = getImc.getAltura();
        String nombre = getImc.getNombre();
        String fecha = getImc.getFecha();

        float IMC = 0;

        //Futura respuesta a devolver:
        GetImcResponse respuesta = new GetImcResponse();


        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=" + peso + "&height=" + altura))
                .header("x-rapidapi-key","8e04c5d4a9msh324be977985c36ap131e95jsn34e1b08224d0")
                .header("x-rapidapi-host","body-mass-index-bmi-calculator.p.rapidapi.com")
                .method("GET",HttpRequest.BodyPublishers.noBody()).build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request,HttpResponse.BodyHandlers.ofString());

            String textoJSON = response.body();
            //System.out.println(textoJSON);

            String IMCtext = textoJSON.substring(textoJSON.indexOf(':') + 1, textoJSON.indexOf(','));
            IMC = Float.parseFloat(IMCtext);

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Llamar aquí al servicio de noticias
        // Mandar nombre como Titulo
        // Mandar fecha como Descripcion
        // Mandar IMC como URL

        respuesta.set_return(IMC);
        return respuesta;
    }
}

