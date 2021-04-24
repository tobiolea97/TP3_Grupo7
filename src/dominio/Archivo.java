package dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
	private String ruta;
	
	public Archivo(String ruta) {
		super();
		this.ruta = ruta;
	}

	public boolean Existe()
	{
		File archivo = new File(ruta); 
		return archivo.exists();
	}
	
	public boolean CrearArchivo()
	{
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	
	public void EliminarArchivo() {
		File archivo = new File(ruta); 
		archivo.delete();
	}

	public void EscribirCaractaresIndividuales(String frase) 
	{
		try {
			FileWriter fw = new FileWriter(ruta, true);
			for (int i = 0; i < frase.length(); i++)
			{
				fw.write(frase.charAt(i));
			}		
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void LeerCaracteresIndividuales()
	{
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			int c = entrada.read();
			while (c != -1) 
			{
				char letra = (char) c;
				System.out.println(letra);
				c = entrada.read();
			}
			entrada.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void EscribirLineas(String frase) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Persona> LeerLineas() {
		ArrayList<Persona> lista = new ArrayList<Persona>();
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";

			while (linea != null) {
				if(linea != "") {
					
					Persona objPersona = new Persona();
					objPersona.setNombre(linea.split("-")[0]);
					objPersona.setApellido(linea.split("-")[1]);
					objPersona.setDni(linea.split("-")[2]);
					
					lista.add(objPersona);
				}
				//System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
		catch(Exception e){
			System.out.println("Excepcion no contemplada");
		}
		
		return lista;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
