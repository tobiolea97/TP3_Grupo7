package dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Utils {

	public static TreeSet<Persona> TransformarListaPersonas (ArrayList<Persona>  l1) {
		
		TreeSet<Persona> l2 = new TreeSet<Persona>();
			
		for(Persona obj : l1) {
			if(verificarDniInvalido(obj.getDni())==true) {
				l2.add(obj);
			}
		}

		return l2;
	}
	
	public static boolean verificarDniInvalido(String cadena)
	{
		boolean esValido = true;
		if (!cadena.matches("[0-9]*")) {
		
			esValido = false;
		}
		 
	
		 return esValido;
	}
	
	public static boolean PasarListaPersonasTxt(TreeSet<Persona> lista, String RutaTXT) {
		boolean Resultado = true;
		
		try {
			Iterator<Persona> it = lista.iterator();
			Archivo FileDest = new Archivo(RutaTXT);
					
			while(it.hasNext()) {
				Persona p=(Persona) it.next();
				String lineaDatos = p.getNombre() + "-" + p.getApellido() + "-" + p.getDni();
				FileDest.EscribirLineas(lineaDatos);
				
			}
		}
		catch(Exception ex) {
			//System.out.println(ex.getMessage());
			Resultado = false;
		}

		
		return Resultado;
	}
	


}

