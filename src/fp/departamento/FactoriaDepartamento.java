package fp.departamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaDepartamento {
	public static Departamento leerDepartamento(String nombreFichero) {
		Departamento res = null;
		try {
			Stream<Profesor> stProf = Files.readAllLines(Paths.get(nombreFichero)).stream()
					.map(FactoriaDepartamento::parsearProfesor);
			res = new Departamento(stProf);
		} catch (IOException ioe) {
			System.err.println("Error leyendo fichero");
		}
		return res;
	}

	public static Profesor parsearProfesor(String cad) {
		Checkers.checkNoNull(cad);
		String trozos[] = cad.split(",");
		Checkers.check("Formato no válido <" + cad + ">", trozos.length == 11);
		String nombre = trozos[0].trim();
		LocalDate fechaIngreso = parseaFecha(trozos[1].trim());
		Set<Asignatura> asigCursosAnts = parseaConjAsig(trozos[2].trim());
		Set<Asignatura> asigPrimCuat = parseaConjAsig(trozos[3].trim());
		Set<Asignatura> asigSegCuat = parseaConjAsig(trozos[4].trim());
		Double credTeoPrimCuat = Double.parseDouble(trozos[5].trim());
		Double credTeoSegCuat = Double.parseDouble(trozos[6].trim());
		Double credLabPrimCuat = Double.parseDouble(trozos[7].trim());
		Double credLabSegCuat = Double.parseDouble(trozos[8].trim());
		Double capacidad = Double.parseDouble(trozos[9].trim());
		Set<Asignatura> asigCoord = parseaConjAsig(trozos[10].trim());
		Profesor prof= new Profesor(nombre, fechaIngreso, asigCursosAnts, asigPrimCuat, asigSegCuat, credTeoPrimCuat,
				credTeoSegCuat, credLabPrimCuat, credLabSegCuat, capacidad, asigCoord);
			
		return prof;
	}

	private static Set<Asignatura> parseaConjAsig(String cadConjAsig) {
		String limpia = cadConjAsig.replace("{", "").replace("}", "").trim();
		Set<Asignatura> res = new HashSet<Asignatura>();
		String[] trozos = limpia.split(";");
		for (int i = 0; i < trozos.length; i++) {
			if (!trozos[i].trim().isEmpty()) {
				Asignatura a = Asignatura.valueOf(trozos[i].trim());
				res.add(a);
			}
		}
		return res;
	}

	private static LocalDate parseaFecha(String cadFecha) {
		return LocalDate.parse(cadFecha, DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
}
