package ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

import dominio.Archivo;
import dominio.DniInvalidoException;
import dominio.Persona;
import dominio.Utils;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Archivo file = new Archivo("c:prueba.txt");
		boolean fueCreado = file.CrearArchivo();
		if(fueCreado)
		{
			file.EscribirLineas("Esta es una linea de prueba");
			file.LeerLineas();
		}*/
		
		//********************** PUNTO A ********************** 
		
		String dni = "1SF23";
		
		try {
			if(Utils.verificarDniInvalido(dni) == false) {
				throw new DniInvalidoException();
			}
		}
		 catch (DniInvalidoException e) {
				e.printStackTrace();
		}
		
		
		//********************** PUNTO B ********************** 
		
		String rutaPersonas = "src/files/Personas.txt";
		Archivo objArchivo = new Archivo(rutaPersonas);
		TreeSet<Persona> listaOrdenada = new TreeSet<Persona>();
		
		if(objArchivo.Existe()) {
			ArrayList<Persona> listaOriginal = objArchivo.LeerLineas();
			listaOrdenada = Utils.TransformarListaPersonas(listaOriginal);
			
			System.out.println("---------------------------Lista Desordenada------------------------------");
			for(Persona obj : listaOriginal) {
				System.out.println(obj.toString());
			}
			System.out.println("---------------------------Lista Ordenada------------------------------");
			for(Persona obj : listaOrdenada) {
				System.out.println(obj.toString());
			}
		}
		else {
			System.out.println("No existe el archivo " + rutaPersonas);
		}
		
		//********************** PUNTO C ********************** 
		String rutaResultado = "src/files/Resultado.txt";
		Archivo FileResult = new Archivo(rutaResultado);
		
		if(FileResult.Existe()) {
			FileResult.EliminarArchivo();
		}
		FileResult.CrearArchivo();
		
		Utils.PasarListaPersonasTxt(listaOrdenada,"src/files/Resultado.txt");
		
	}

}


