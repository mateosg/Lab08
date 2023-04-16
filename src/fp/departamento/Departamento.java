package fp.departamento;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Departamento {
	private Set<Profesor> profesores;

	public Departamento() {
		profesores = new HashSet<Profesor>();
	}

	public Departamento(Stream<Profesor> profesores) {
		this.profesores = profesores.collect(Collectors.toSet());
	}

	public Set<Profesor> getProfesores() {
		return new HashSet<Profesor>(profesores);
	}

	public int hashCode() {
		return Objects.hash(profesores);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(profesores, other.profesores);
	}

	public String toString() {
		return "Departamento [profesores=" + profesores + "]";
	}

	public void añadirProfesor(Profesor p) {
		profesores.add(p);
	}

	public void eliminaProfesor(String nombre) {
		Profesor pb = null;
		for (Profesor p : profesores) {
			if (p.nombre().equals(nombre)) {
				pb = p;
				break;
			}
		}
		if (pb != null) {
			profesores.remove(pb);
		}
	}
	/************************************ Tratamientos secuenciales ********************************************/
	public Map<Asignatura,List<Profesor>> profesoresPorAsignatura(){
		/*
		 * Relacionar cada asignatura con los profesores que la imparten. Para ello:
		 * 1.- Use flatMap para extraer un único stream con las asignaturas de todos los profesores
		 * 2.- A partir del paso 1, cree un stream de pares asignatura-profesor así: 
		 * 			.map(asig -> new SimpleEntry<>(asig,prof)))
		 * 3.- Agrupe por asignatura, siendo cada valor una lista con los profesores (piense en cómo obtener
		 * 		la clave y los profesores a partir de cada par de tipo SimpleEntry del paso 2)
		 * 
		 */
		
	 
	  return null;
	
	}
	
	public Set<Profesor> profesoresQueSoloImpartenAsignaturasQueCoordinan(){
	/*
	 *	Determinar el conjunto de profesores que 
		sólo imparten clases en las asignaturas que coordinan
	 */
		return null;
	 }
	
	public Boolean departamentoResponsable() { 
	/*
	 * Decidir si el departamento es responsable. Un departamento es 
		responsable si todo profesor que coordina asignatura/s tiene una experiencia mínima de 5 años 
		e imparte tal/es asignatura/s en el curso actual (primer o segundo cuatrimestre)
	 */
		return null;
		
	}
	public List<String> ordenarProfesoresPorNumeroCreditosTeoricos(){
	
	/*
	 * Ordenar de forma decreciente los nombres de los 
	profesores que dan teoría por el número de créditos teóricos asignados en el curso actual.
	 */
		return null;
	}
	
	public Integer añoIncorporacionMasCoordinadores() { 
	/*
	 *Obtener el año en el que se incorporaron más profesores que 
		actualmente son coordinadores. Si no se puede calcular se eleva NoSuchElementException
	 */
		
		return null;
	}
}
