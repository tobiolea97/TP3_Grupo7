package ejercicio1;

import dominio.Archivo;
import dominio.DniInvalidoException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivo file = new Archivo("c:prueba.txt");
		boolean fueCreado = file.CrearArchivo();
		if(fueCreado)
		{
			file.EscribirLineas("Esta es una linea de prueba");
			file.LeerLineas();
		}
		
		
		
		
		
		/// bloque para ejecutar verificarDniInvalido
		String cadena ="123123123";
	
		  try {
			verificarDniInvalido(cadena);
		} catch (DniInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/// Fin
	
	}
	///funcion verificarDniInvalido
	
	public static int verificarDniInvalido(String cadena) throws DniInvalidoException 
	{
		
		if (!cadena.matches("[0-9]*")) {
		
			throw new DniInvalidoException();
		}
		 
	
		 return 0;
	}

}
