package dominio;

public class DniInvalidoException extends Exception  {

	public DniInvalidoException() {}
	
	
	@Override
	public String getMessage() {
		
		
		return "Dni invalido";
	}

	
	
	
	
}
