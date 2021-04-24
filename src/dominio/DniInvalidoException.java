package dominio;

public class DniInvalidoException extends Exception  {

	public DniInvalidoException() {}
	
	
	@Override
	public String getMessage() {
		
		
		return "El Dni Ingresado no debe contener letras. (SOLO NUMEROS)";
	}

	
	
	
	
}
