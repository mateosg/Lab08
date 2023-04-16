package fp.departamento;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import fp.utiles.Checkers;

public record Profesor(String nombre, LocalDate fechaIngreso, Set<Asignatura> asigsCursosAnt,
		Set<Asignatura> asigsPrimCuatr, Set<Asignatura> asigsSegCuatr, Double credTeoPrimCuatr, Double credTeoSegCuatr,
		Double credLabPrimCuatr, Double credLabSegCuatr, Double capacidad, Set<Asignatura> asigsCoordinadas)
		implements Comparable<Profesor> {
	public Profesor {
//R1
		Checkers.check("Fecha de ingreso incorrecta", fechaIngreso.isBefore(LocalDate.now()));
//R2
		Checkers.check("Créditos asignados incorrectos",
				credTeoPrimCuatr + credTeoSegCuatr + credLabPrimCuatr + credLabSegCuatr >= 0);
//R3
		Checkers.check("Capacidad docente no válida", capacidad > 0);
	}

	public Double getCreditosAsignados() {
		return credTeoPrimCuatr + credTeoSegCuatr + credLabPrimCuatr + credLabSegCuatr;
	}

	public Double getCreditosTeoricos() {
		return credTeoPrimCuatr() + credTeoSegCuatr();
	}

	public Integer getExperiencia() {
		Period res = Period.between(LocalDate.now(), fechaIngreso);
		return res.getYears();
	}

	public Boolean esOcioso() {
		return getCreditosAsignados() < (capacidad / 2.0);
	}

	public Boolean esCoordinador() {
		return !asigsCoordinadas().isEmpty();
	}

	public Set<Asignatura> asignaturasImpartidas() {
		Set<Asignatura> res = new HashSet<>(asigsPrimCuatr());
		res.addAll(asigsSegCuatr());
		return res;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Profesor))
			return false;
		Profesor other = (Profesor) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int compareTo(Profesor p) {
		return nombre().compareTo(p.nombre());
	}
}
