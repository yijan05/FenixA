package Controlador;
import org.example.Facultad;
import org.example.Asistencia;
import org.example.Asignatura;
import org.example.Estudiante;

import java.util.ArrayList;

public class ElControlador {
    private String nombreFacultad = "Ingeniería de Sistemas y Computación";

    private Facultad facultad = null;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Estudiante> estudiantes;

    // Constructor del controlador
    public ElControlador() {
        facultad = new Facultad();
        this.asistencias = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }


    // Método para consultar una asistencia por la hora de inicio
    public Asistencia consultarAsistenciaPorHoraInicio(String horaInicio) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getHoraInicio().equalsIgnoreCase(horaInicio)) {
                return asistencia;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Métodos para estudiantes

    // Método para registrar un nuevo estudiante
    public void registrarEstudiante(String tipo, String documento, String nombre, String apellido, String programa, String semestre) {
        Estudiante estudiante = new Estudiante(tipo, documento, nombre, apellido, programa, semestre);
        estudiantes.add(estudiante);
    }

    // Método para consultar un estudiante por tipo de documento y documento
    public Estudiante consultarEstudiante(String tipo, String documento) {
        for (Estudiante e : estudiantes) {
            if (e.getTipoDocumento().equalsIgnoreCase(tipo) && e.getDocumentoIdentidad().equalsIgnoreCase(documento)) {
                return e;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Método para modificar la información de un estudiante
    public void modificarEstudiante(String tipo, String documento, String nuevoNombre, String nuevoApellido, String nuevoTipo) {
        Estudiante e = consultarEstudiante(tipo, documento);
        if (e != null) {
            e.setNombre(nuevoNombre);
            e.setApellido(nuevoApellido);
            e.setTipoDocumento(nuevoTipo);
        }
    }

    // Método para eliminar un estudiante
    public void eliminarEstudiante(String tipo, String documento) {
        Estudiante e = consultarEstudiante(tipo, documento);
        if (e != null) {
            estudiantes.remove(e);
        }
    }

    // Método para obtener todos los estudiantes
    public ArrayList<Estudiante> obtenerEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    // Métodos para asistencias

    // Método para agregar una nueva asistencia
    public void agregarAsistencia(String fecha, String horaInicio, String horaFinal) {
        Asistencia nuevaAsistencia = new Asistencia(fecha, horaInicio, horaFinal);
        asistencias.add(nuevaAsistencia);
    }

    // Método para consultar una asistencia específica
    public Asistencia consultarAsistencia(String fecha, String horaInicio, String horaFinal) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getFecha().equalsIgnoreCase(fecha) &&
                    asistencia.getHoraInicio().equalsIgnoreCase(horaInicio) &&
                    asistencia.getHoraFinal().equalsIgnoreCase(horaFinal)) {
                return asistencia;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Método para modificar una asistencia existente
    public void modificarAsistencia(String fecha, String horaInicio, String horaFinal, String nuevaFecha, String nuevaHoraInicio, String nuevaHoraFinal) {
        Asistencia asistencia = consultarAsistencia(fecha, horaInicio, horaFinal);
        if (asistencia != null) {
            asistencia.setFecha(nuevaFecha);
            asistencia.setHoraInicio(nuevaHoraInicio);
            asistencia.setHoraFinal(nuevaHoraFinal);
        }
    }

    // Método para eliminar una asistencia
    public void eliminarAsistencia(String fecha, String horaInicio, String horaFinal) {
        Asistencia asistencia = consultarAsistencia(fecha, horaInicio, horaFinal);
        if (asistencia != null) {
            asistencias.remove(asistencia);
        }
    }

    // Método para registrar la asistencia de un estudiante
    public void registrarAsistenciaEstudiante(String fecha, String horaInicio, String horaFinal, String codigoEstudiante, String estado) {
        Asistencia asistencia = consultarAsistencia(fecha, horaInicio, horaFinal);
        if (asistencia != null) {
            asistencia.adicionarAsistencia(codigoEstudiante, estado);
        }
    }

    // Método para listar todas las asistencias
    public ArrayList<Asistencia> listarAsistencias() {
        return new ArrayList<>(asistencias);
    }

    // Métodos para asignaturas

    // Método para agregar una asignatura
    public void agregarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        facultad.agregarAsignatura(codigo, grupo, semestre, nombre, creditos);
    }

    // Método para consultar una asignatura
    public String consultarAsignatura(String codigo, String grupo, String semestre) {
        return facultad.consultarAsignatura(codigo, grupo, semestre);
    }

    // Método para modificar una asignatura
    public void modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        facultad.modificarAsignatura(codigo, grupo, semestre, nombre, creditos);
    }

    // Método para eliminar una asignatura
    public void eliminarAsignatura(String codigo, String grupo, String semestre) {
        facultad.eliminarAsignatura(codigo, grupo, semestre);
    }

    // Método para obtener todas las asignaturas
    public ArrayList<Asignatura> getAsignaturas() {
        return facultad.getAsignaturas();
    }

    // Métodos para la facultad

    // Método para crear una facultad
    public void CrearFacultad(String nombre) {
        facultad.setNombre(nombre);
    }

    // Método para modificar el nombre de la facultad
    public void modificarNombreFacultad(String nombre) {
        facultad.setNombre(nombre);
    }

    // Método para consultar el nombre de la facultad
    public String consultarNombreFacultad() {
        return facultad.getNombre();
    }
}
