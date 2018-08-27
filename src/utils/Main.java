package utils;

public class Main {

	public static void main(String[] args) {
		String[] result = DesglosarApellidos.desglosarApellidos("Saez de Asteasu Martinez de Marin");
		for (String apellido: result) {
			System.out.println(apellido);
		}
	}

}
