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
import java.net.URL;
import java.net.URLConnection;
import java.net.http.*;

import java.nio.charset.Charset;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;


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
    static OMFactory omFactory2 = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace2 = omFactory2.createOMNamespace("http://Noticia", "ns2");

    public imc.GetImcResponse getImc(imc.GetImc getImc) throws IOException {
        float peso = getImc.getPeso();
        float altura = getImc.getAltura();
        String nombre = getImc.getNombre();
        String fecha = getImc.getFecha();

        float IMC = 0;
        String IMCtext ="";

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

            IMCtext = textoJSON.substring(textoJSON.indexOf(':') + 1, textoJSON.indexOf(','));
            IMC = Float.parseFloat(IMCtext);

            
        } catch (Exception e) {
            e.printStackTrace();
        }


        // LLAMADA A NOTICIA

        ServiceClient Cliente2 = null;

			try {
				Cliente2 = new ServiceClient();
			} catch (AxisFault e) {
				System.out.println("AXIS2_FAULT: Error instanciando el cliente" + e.toString());
				System.exit(0);
            }
			
			Options options2 = new Options();
			options2.setTo(new EndpointReference("http://localhost:8080/axis2/services/Noticia"));
			options2.setAction("urn:setTitular");
			Cliente2.setOptions(options2);



        //SetTitular: Nombre del paciente
        
			try{
				OMElement metodo2 = omFactory2.createOMElement("setTitular", omNameSpace2);
				OMElement parametro2 = omFactory2.createOMElement("titular", omNameSpace2);
				parametro2.setText(nombre);
				metodo2.addChild(parametro2);
				Cliente2.sendRobust(metodo2);
			}catch(Exception e){
				e.toString();
				System.exit(0);
			}

        //SetDescripcion: Fecha de nacimiento

        options2.setAction("urn:setDescripcion");
        Cliente2.setOptions(options2);

			try{
				OMElement metodo4 = omFactory2.createOMElement("setDescripcion", omNameSpace2);
				OMElement parametro4 = omFactory2.createOMElement("descripcion", omNameSpace2);
				parametro4.setText(fecha);
				metodo4.addChild(parametro4);
				Cliente2.sendRobust(metodo4);
			}catch(Exception e){
				e.toString();
				System.exit(0);
			}

        //SetURL:  IMC obtenido

        options2.setAction("urn:setUrl");
        Cliente2.setOptions(options2);

			try{
				OMElement metodo6 = omFactory2.createOMElement("setUrl", omNameSpace2);
				OMElement parametro6 = omFactory2.createOMElement("url", omNameSpace2);
				parametro6.setText(IMCtext);
				metodo6.addChild(parametro6);
				Cliente2.sendRobust(metodo6);
			}catch(Exception e){
				e.toString();
				System.exit(0);
			}

        respuesta.set_return(IMC);
        return respuesta;
    }
}

