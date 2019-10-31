
---------- Forwarded message ---------
De: Roberto Agirre <robaguirre@gmail.com>
Date: mié., 19 sept. 2018 7:28
Subject: Re: baja
To: Roberto Agirre <robaguirre@gmail.com>


package utils;

import java.util.ArrayList;
import java.util.List;

public class DesglosarApellidos {
	public static String[] desglosarApellidos(String apellidos) {
		String[] arregloNombre = apellidos.split(" ");
		List<String> fullName = new ArrayList<String>();
		String palabrasReservadas = "da, de, del, la, las, los, san, santa";
		String auxPalabra = "";
		for (int i = 0; i < arregloNombre.length; i++) {
			String elemento = arregloNombre[i];
			String apellidosAux = elemento.toLowerCase();
			// Cuando la palabra existe dentro de nuestro array, la funcion
			// "indexOf" nos arrojara un numero diferente de -1.
			if (palabrasReservadas.indexOf(apellidosAux) != -1) {
				auxPalabra += elemento + " ";
			} else {
				fullName.add(auxPalabra + elemento);
				auxPalabra = "";
			}
		}
		// Si la lista es mayor de dos hay que reorganizar apellidos
		if (fullName.size() > 2) {
			List<String> fullNameCompuesto = new ArrayList<String>();
			switch (fullName.size()) {
			// En caso de ser 3 hay un apellido compuesto
			case 3:
				// El apellido compuesto es el primero
				if (fullName.get(1).split(" ").length > 1) {
					fullNameCompuesto.add(fullName.get(0) + " " + fullName.get(1));
					fullNameCompuesto.add(fullName.get(2));
				} else {
					fullNameCompuesto.add(fullName.get(0));
					fullNameCompuesto.add(fullName.get(1) + " " + fullName.get(2));
				}
				break;
			// En caso de ser 4 los dos apellidos son compuestos
			case 4:
				fullNameCompuesto.add(fullName.get(0) + " " + fullName.get(1));
				fullNameCompuesto.add(fullName.get(2) + " " + fullName.get(3));
				break;
			default:
				break;
			}
			fullName = fullNameCompuesto;
		}

		String[] listaAux = new String[fullName.size()];
		return fullName.toArray(listaAux);
	}
}
