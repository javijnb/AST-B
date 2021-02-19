import java.util.Scanner;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

// sendReceive(OMElement metodo) - para los getters del servicio
// sendRobust (OMElement metodo) - para los setters del servicio


public class ClienteNoticias {
	
	static OMFactory omFactory = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace = omFactory.createOMNamespace("http://Noticia", "nameService1");

	public static void main (String args[]){
				
		ServiceClient Cliente = null;
		
		try {
			Cliente = new ServiceClient();
		} catch (AxisFault e) {
			System.out.println("AXIS2_FAULT: Error instanciando el cliente" + e.toString());
			System.exit(0);
		}
		
		Options options = new Options();
		
		options.setTo(new EndpointReference("http://localhost:8080/axis2/services/Noticia"));
		options.setAction("urn:Cliente");
		Cliente.setOptions(options);
		
		System.out.println("\t A continuacion se presenta el menu:");	
		
		while(true){	
            System.out.println("\n\n\t-----OPCIONES-----");
			System.out.println("\t1. Cambiar titular");
			System.out.println("\t2. Obtener titular");
			System.out.println("\t3. Cambiar descripcion");
			System.out.println("\t4. Obtener descripcion");
			System.out.println("\t5. Cambiar URL");
			System.out.println("\t6. Obtener URL");
			System.out.println("\t0. Salir del servicio");
						
			int operacion = Integer.parseInt(getOperationRequested(0));
			
			switch (operacion){
			



				case 1: {
					OMElement metodo = omFactory.createOMElement("setTitular", omNameSpace);
					OMElement parametro = omFactory.createOMElement("titular", omNameSpace);
					
					parametro.setText(getOperationRequested(1));
					metodo.addChild(parametro);
					
					try {
						Cliente.sendRobust(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema durante la operacion 1: " + e.toString());
						break;
					}
					
					System.out.println("\n\t Operacion 1 finalizada.");
					break;
				}
				
                


				case 2: {
					OMElement metodo = omFactory.createOMElement("getTitular", omNameSpace);
					OMElement respuestaTitular = null;
					
					try {
						respuestaTitular = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema durante la operacion 2: " + e.toString());
						break;
					}
					
					System.out.println("\nTitular: " + respuestaTitular.getFirstElement().getText());
					break;
				}
					



				case 3: {
					OMElement metodo = omFactory.createOMElement("setDescripcion", omNameSpace);
					OMElement parametro = omFactory.createOMElement("descripcion", omNameSpace);
					
					parametro.setText(getOperationRequested(3));
					metodo.addChild(parametro);
					
					try {
						Cliente.sendRobust(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema durante la operacion 3: " + e.toString());
						break;
					};
					
					System.out.println("\nFin de ejecucion de la operacion 3");
					break;
				}
					



				case 4: {
					OMElement metodo = omFactory.createOMElement("getDescripcion", omNameSpace);
					OMElement respuestaDescripcion = null;
					
					try {
						respuestaDescripcion = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema durante la operacion 4: " + e.toString());
						break;
					}

					System.out.println("\nDescripcion: " + respuestaDescripcion.getFirstElement().getText());
					break;
				}
					



				case 5: {
					OMElement metodo = omFactory.createOMElement("setUrl", omNameSpace);
					OMElement parametro = omFactory.createOMElement("url", omNameSpace);
					
					parametro.setText(getOperationRequested(5));
					metodo.addChild(parametro);
					
					try {
						Cliente.sendRobust(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema durante la operacion 5: " + e.toString());
						break;
					}
					
					System.out.println("\nFin de la operacion 5.");
					break;
				}
					




				case 6: {
					OMElement metodo = omFactory.createOMElement("getUrl", omNameSpace);
					OMElement respuestaURL = null;
					
					try {
						respuestaURL = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema durante la operacion 6: " + e.toString());
						break;
					}
					
					
					System.out.println("\nURL: " + respuestaURL.getFirstElement().getText());
					break;
				}
					
				case 0: {
					System.out.println("\nHa seleccionado SALIR del cliente. Cerrando aplicación...");
					System.exit(0);
				}
				
				default: {
					System.out.println("\n\t\tHa introducido una opción no válida, por favor introduzca un numero comprendido entre 0 y 6 inclusive\n\n");				
					break;
				}
					
			}
		}
	}
	
	
	/**
	 * M�todo utilizado para obtener qu� operacion desea realizar el usuario. Dicha operaci�n se realizar� a trav�s de la terminal.
	 * @param operationCode C�digo de operaci�n; con �l indicaremos al m�todo qu� tiene que obtener de la terminal
	 * @return Devuelve un entero con la opci�n requerida.
	 */
	@SuppressWarnings("resource")
	public static String getOperationRequested(int operationCode){
		
		switch (operationCode){
		
			case 0: {
				System.out.print("\nPor favor, introduzca una de las opciones: ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			case 1: {
				System.out.print("\nPor favor, introduzca el titular de la noticia:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			case 3: {
				System.out.print("\nPor favor, introduzca la descripción de la noticia:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
		
			case 5: {
				System.out.print("\nPor favor, introduzca la URL de la noticia:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			default: {
				return null;
			}
		}
	}
} 
