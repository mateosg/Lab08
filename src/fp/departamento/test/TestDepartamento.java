package fp.departamento.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.departamento.*;

public class TestDepartamento {

	public static void main(String[] args) {

		Departamento departamento = FactoriaDepartamento.leerDepartamento("data/profesores.csv");
		Map<Asignatura, List<Profesor>> profesoresPorAsignatura = departamento.profesoresPorAsignatura();
		Set<Profesor> profesoresQueSoloImpartenAsignaturasQueCoordinan = departamento
				.profesoresQueSoloImpartenAsignaturasQueCoordinan();
		Boolean departamentoResponsable = departamento.departamentoResponsable();
		List<String> ordenarProfesoresPorNumeroCreditosTeoricos = departamento
				.ordenarProfesoresPorNumeroCreditosTeoricos();
		Integer añoIncorporacionMasCoordinadores = departamento.añoIncorporacionMasCoordinadores();

		// Imprime los resultados de los métodos para verificar que funcionan
		// correctamente
		System.out.println("Profesores por asignatura: ");
		printMap(profesoresPorAsignatura);
		System.out.println("\nProfesores que solo imparten asignaturas que coordinan: "
				+ profesoresQueSoloImpartenAsignaturasQueCoordinan.stream().map(Profesor::nombre).toList());
		System.out.println("\n¿Es el departamento responsable? " + departamentoResponsable);
		System.out.println(
				"\nProfesores ordenados por número de créditos teóricos: " + ordenarProfesoresPorNumeroCreditosTeoricos);
		System.out.println("\nAño de incorporación con más coordinadores: " + añoIncorporacionMasCoordinadores);
	}
	public static <K, V> void printMap(Map<K, V> map) {
	    for (Map.Entry<K, V> entry : map.entrySet()) {
	        System.out.println(entry.getKey() + " -> " + entry.getValue());
	    }
	}
}
