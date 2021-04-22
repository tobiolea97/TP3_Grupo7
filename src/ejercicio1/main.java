package ejercicio1;

import dominio.Archivo;

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
	}

}
