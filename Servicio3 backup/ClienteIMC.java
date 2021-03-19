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

	static OMFactory omFactory = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace = omFactory.createOMNamespace("http://IMC", "nameService1");

	public static void main(String args[]) {

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
		options.setAction("urn:getIMC");
		Cliente.setOptions(options);

		System.out.println("¡Bienvenido al servicio de cálculo de IMC (Índice de Masa Corporal)");

		while (true) {

			System.out.println("\t1. Obtener un parte médico detallado con sus datos personales e IMC");
			System.out.println("\t0. Salir de la aplicación");

			int operacion = Integer.parseInt(getOperationRequested(0));

			switch (operacion) {

				case 1: {
					OMElement metodo = omFactory.createOMElement("getIMC", omNameSpace);
					OMElement peso = omFactory.createOMElement("args0", omNameSpace);
					OMElement altura = omFactory.createOMElement("args1", omNameSpace);
					String nombreusuario;
					String fechanacim;

					OMElement respuestaConversor = null;

					peso.setText(getOperationRequested(1));
					metodo.addChild(peso);

					altura.setText(getOperationRequested(2));
					metodo.addChild(altura);

					nombreusuario = getOperationRequested(3);
					fechanacim    = getOperationRequested(4);

					String IMCobtenido = "";

					try {
						respuestaConversor = Cliente.sendReceive(metodo);
						IMCobtenido = respuestaConversor.getFirstElement().getText();
					} catch (AxisFault e) {
						System.out.println(
								"Error al solicitar una respuesta a su consulta. Causa: " + e.toString() + "\n");
						break;
					}

					System.out.println("\nIMC obtenido: " + IMCobtenido + "\n");


					//Llamar aquí a servicio noticia para crear la noticia:
					// Descripción: Nombre del paciente
					// Titular: 	Fecha de nacimiento
					// URL: 		IMC obtenido













					break;
				}

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
				System.out.print("Introduzca el número de la opción que desea\n\n");
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
				System.out.println("\nIntroduzca su nombre y apellidos:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}

			case 4: {
				System.out.println("\nIntroduzca su fecha de nacimiento:\n\t-> ");
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