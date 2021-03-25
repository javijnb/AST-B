import java.util.Scanner;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;




public class ClienteIMC {

	//Parametros constantes para el servicio IMC
	static OMFactory omFactory = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace = omFactory.createOMNamespace("http://IMC", "ns1");

	//Parametros constantes para el servicio Noticia
	static OMFactory omFactory2 = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace2 = omFactory2.createOMNamespace("http://Noticia", "ns2");

	public static void main(String args[]) {

		//----------------------------------------------------------------
		//CODIGO IMC
		ServiceClient Cliente = null;

		try {
			Cliente = new ServiceClient();
		} catch (AxisFault e) {
			System.out.println("Error al crear el cliente: " + e.toString());
			System.out.println("Saliendo de la aplicación");
			System.exit(0);
		}

		Options options = new Options();
		options.setTo(new EndpointReference("http://localhost:8080/axis2/services/IMC"));
		options.setAction("urn:getImc");
		Cliente.setOptions(options);

		System.out.println("¡Bienvenido al servicio de cálculo de IMC (Índice de Masa Corporal)");

		while (true) {

			System.out.println("\t1. Obtener un parte médico detallado con sus datos personales e IMC");
			System.out.println("\t0. Salir de la aplicación");

			int operacion = Integer.parseInt(getOperationRequested(0));

			switch (operacion) {

				case 1: {
					OMElement metodo = omFactory.createOMElement("getImc", omNameSpace);
					OMElement peso = omFactory.createOMElement("peso", omNameSpace);
					OMElement altura = omFactory.createOMElement("altura", omNameSpace);
					OMElement nombreusuario = omFactory.createOMElement("nombre", omNameSpace);
					OMElement fechanacim = omFactory.createOMElement("fecha", omNameSpace);

					OMElement respuestaConversor = null;

					peso.setText(getOperationRequested(1));
					metodo.addChild(peso);

					altura.setText(getOperationRequested(2));
					metodo.addChild(altura);

					nombreusuario.setText(getOperationRequested(3));
					metodo.addChild(nombreusuario);

					fechanacim.setText(getOperationRequested(4));
					metodo.addChild(fechanacim);

					String IMCobtenido = "";

					try {
						respuestaConversor = Cliente.sendReceive(metodo);
						IMCobtenido = respuestaConversor.getFirstElement().getText();
					} catch (AxisFault e) {
						System.out.println(
								"Error al solicitar una respuesta a su consulta. Causa: " + e.toString() + "\n");
						break;
					}

					System.out.println("\n\nINFORMACIÓN OBTENIDA A PARTIR DEL SERVICIO IMC:");
					System.out.println("*****************************************************************");
					System.out.println("Nombre del paciente: "+nombreusuario.getText());
					System.out.println("Fecha de nacimiento: "+fechanacim.getText());
					System.out.println("IMC obtenido: " + IMCobtenido);
					System.out.println("*****************************************************************\n\n");


					//Llamar aquí a servicio noticia para crear la noticia:
					// Descripción: Nombre del paciente
					// Titular: 	Fecha de nacimiento
					// URL: 		IMC obtenido


					//----------------------------------------------------------------
					//CODIGO NOTICIA
					ServiceClient Cliente2 = null;

					try {
						Cliente2 = new ServiceClient();
					} catch (AxisFault e) {
						System.out.println("AXIS2_FAULT: Error instanciando el cliente" + e.toString());
						System.exit(0);
					}

					Options options2 = new Options();
					options2.setTo(new EndpointReference("http://localhost:8080/axis2/services/Noticia"));
					options2.setAction("urn:Cliente");
					Cliente2.setOptions(options2);

					System.out.println("\n\nINFORMACIÓN OBTENIDA A PARTIR DEL SERVICIO NOTICIA:");
					System.out.println("*****************************************************************");

					//SetTitular: Nombre del paciente
					try{
						OMElement metodo2 = omFactory2.createOMElement("setTitular", omNameSpace2);
						OMElement parametro2 = omFactory2.createOMElement("titular", omNameSpace2);
						parametro2.setText(nombreusuario.getText());
						metodo2.addChild(parametro2);
						Cliente2.sendRobust(metodo2);
					}catch(Exception e){
						e.toString();
						System.exit(0);
					}

					//Sacamos por pantalla el titular:
					try{
					OMElement metodo3 = omFactory2.createOMElement("getTitular", omNameSpace2);
					OMElement respuestaTitular = null;
					respuestaTitular = Cliente2.sendReceive(metodo3);
					//System.out.println("Titular: " + respuestaTitular.getFirstElement().getText());
					System.out.println("Nombre del paciente (titular): "+respuestaTitular.getFirstElement().getText());
					}catch(Exception e){
						e.toString();
						System.exit(0);
					}

					//SetDescripcion: Fecha de nacimiento
					try{
						OMElement metodo4 = omFactory2.createOMElement("setDescripcion", omNameSpace2);
						OMElement parametro4 = omFactory2.createOMElement("descripcion", omNameSpace2);
						parametro4.setText(fechanacim.getText());
						metodo4.addChild(parametro4);
						Cliente2.sendRobust(metodo4);
					}catch(Exception e){
						e.toString();
						System.exit(0);
					}

					//Sacamos por pantalla la descripción:
					try{
						OMElement metodo5 = omFactory2.createOMElement("getDescripcion", omNameSpace2);
						OMElement respuestaDescripcion = null;
						respuestaDescripcion = Cliente2.sendReceive(metodo5);
						//System.out.println("Descripción: "+respuestaDescripcion.getFirstElement().getText());
						System.out.println("Fecha de nacimiento (descripcion): "+respuestaDescripcion.getFirstElement().getText());
					}catch(Exception e){
							e.toString();
							System.exit(0);
					}

					//SetURL:  IMC obtenido
					try{
						OMElement metodo6 = omFactory2.createOMElement("setUrl", omNameSpace2);
						OMElement parametro6 = omFactory2.createOMElement("url", omNameSpace2);
						parametro6.setText(IMCobtenido);
						metodo6.addChild(parametro6);
						Cliente2.sendRobust(metodo6);
					}catch(Exception e){
						e.toString();
						System.exit(0);
					}

					//Sacamos por pantalla la URL:
					try{
						OMElement metodo7 = omFactory2.createOMElement("getUrl", omNameSpace2);
						OMElement respuestaUrl = null;
						respuestaUrl = Cliente2.sendReceive(metodo7);
						//System.out.println("URL: "+respuestaUrl.getFirstElement().getText());
						System.out.println("IMC obtenido (URL): " + respuestaUrl.getFirstElement().getText());
					}catch(Exception e){
							e.toString();
							System.exit(0);
					}
					System.out.println("*****************************************************************\n\n");

					break;
				}//llave del case 1

				case 0: {
					System.out.println("Ha seleccionado SALIR. Cerrando aplicación...\n");
					System.exit(0);
				}

				default: {
					System.out.println(
							"Por favor introduzca 1 para calcular su IMC ó 0 para salir de la aplicación\n\n");
					break;
				}

			}
		}
	}






	@SuppressWarnings("resource")
	public static String getOperationRequested(int operationCode) {

		switch (operationCode) {

			case 0: {
				System.out.print("\tIntroduzca el número de la opción que desea\n\n");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}

			case 1: {
				System.out.print("\nIntroduzca su peso en Kg (p.e 75.00):\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}

			case 2: {
				System.out.print("\nIntroduzca su altura en metros (p.e 1.78):\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}

			case 3: {
				System.out.print("\nIntroduzca su nombre y apellidos:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}

			case 4: {
				System.out.print("\nIntroduzca su fecha de nacimiento:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}

			default: {
				System.out.println("No ha introducido una opción válida\n");
				return null;
			}
		}
	}
}