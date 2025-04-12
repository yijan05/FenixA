package org.example;
import Controlador.ElControlador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElControlador control = new ElControlador();

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar nombre de la facultad");
            System.out.println("2. Modificar nombre de la facultad");
            System.out.println("3. Registrar estudiante en la facultad");
            System.out.println("4. Consultar estudiante en la facultad");
            System.out.println("5. Modificar estudiante en la facultad");
            System.out.println("6. Agregar asignatura");
            System.out.println("7. Consultar asignatura");
            System.out.println("8. Modificar asignatura");
            System.out.println("9. Crear lista de asistencia vacía");
            System.out.println("10. Registrar asistencia de estudiante");
            System.out.println("11. Modificar asistencia");
            System.out.println("12. Listar asistencias");
            System.out.println("13. Salir");
            System.out.print("Opción: ");

            int op = sc.nextInt();
            sc.nextLine(); // Limpieza de buffer

            if (op == 1) {
                String nombre = "Ingeniería";  // Se asigna el nombre correcto de la facultad
                if (nombre == null || nombre.trim().isEmpty()) {
                    System.out.println("No hay una facultad registrada.");
                } else {
                    System.out.println("Nombre actual de la facultad: " + nombre);
                }

        } else if (op == 2) {
                System.out.print("Nuevo nombre de la facultad: ");
                String nuevoNombre = sc.nextLine();
                control.modificarNombreFacultad(nuevoNombre);
                System.out.println("Nombre actualizado exitosamente.");
            } else if (op == 3) {
                System.out.print("Tipo de documento: ");
                String tipo = sc.nextLine();
                System.out.print("Número de documento: ");
                String doc = sc.nextLine();
                System.out.print("Nombres: ");
                String nom = sc.nextLine();
                System.out.print("Apellidos: ");
                String ape = sc.nextLine();
                System.out.print("Programa: ");
                String programa = sc.nextLine();
                System.out.print("Semestre: ");
                String semestre = sc.nextLine();

                // Verifica si ya existe antes de registrar
                if (control.consultarEstudiante(tipo, doc) == null) {
                    control.registrarEstudiante(tipo, doc, nom, ape, programa, semestre);
                    System.out.println("Estudiante registrado con éxito.");
                } else {
                    System.out.println("El estudiante ya se encuentra registrado.");
                }
            } else if (op == 4) {
                System.out.print("Tipo de documento: ");
                String tipo = sc.nextLine();
                System.out.print("Número de documento: ");
                String doc = sc.nextLine();

                Estudiante est = control.consultarEstudiante(tipo, doc);
                if (est != null) {
                    System.out.println("Estudiante encontrado: " + est);
                } else {
                    System.out.println("Estudiante no encontrado.");
                }
            } else if (op == 5) {
                System.out.print("Tipo de documento: ");
                String tipo = sc.nextLine();
                System.out.print("Número de documento: ");
                String doc = sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                System.out.print("Nuevo apellido: ");
                String nuevoApellido = sc.nextLine();
                System.out.print("Nuevo tipo de documento: ");
                String nuevoTipo = sc.nextLine();

                if (control.consultarEstudiante(tipo, doc) != null) {
                    control.modificarEstudiante(tipo, doc, nuevoNombre, nuevoApellido, nuevoTipo);
                    System.out.println("Estudiante modificado correctamente.");
                } else {
                    System.out.println("No se encontró el estudiante para modificar.");
                }
            } else if (op == 6) {
                System.out.print("Código de la asignatura: ");
                String codigo = sc.nextLine();
                System.out.print("Grupo: ");
                String grupo = sc.nextLine();
                System.out.print("Semestre: ");
                String semestre = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Créditos: ");
                int creditos = sc.nextInt();
                sc.nextLine();

                control.agregarAsignatura(codigo, grupo, semestre, nombre, creditos);
                System.out.println("Asignatura registrada.");
            } else if (op == 7) {
                System.out.print("Código: ");
                String codigo = sc.nextLine();
                System.out.print("Grupo: ");
                String grupo = sc.nextLine();
                System.out.print("Semestre: ");
                String semestre = sc.nextLine();

                String resultado = control.consultarAsignatura(codigo, grupo, semestre);
                System.out.println(resultado);
            } else if (op == 8) {
                System.out.print("Código: ");
                String codigo = sc.nextLine();
                System.out.print("Grupo: ");
                String grupo = sc.nextLine();
                System.out.print("Semestre: ");
                String semestre = sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                System.out.print("Nuevos créditos: ");
                int nuevosCreditos = sc.nextInt();
                sc.nextLine();

                control.modificarAsignatura(codigo, grupo, semestre, nuevoNombre, nuevosCreditos);
                System.out.println("Asignatura modificada.");
            } else if (op == 9) {
                System.out.print("Fecha (dd/mm/aaaa): ");
                String fecha = sc.nextLine();
                System.out.print("Hora inicio: ");
                String horaInicio = sc.nextLine();
                System.out.print("Hora final: ");
                String horaFinal = sc.nextLine();

                control.agregarAsistencia(fecha, horaInicio, horaFinal);
                System.out.println("Lista de asistencia creada correctamente.");
            } else if (op == 10) {
                System.out.print("Fecha (dd/mm/aaaa): ");
                String fecha = sc.nextLine();
                System.out.print("Hora inicio: ");
                String horaInicio = sc.nextLine();
                System.out.print("Hora final: ");
                String horaFinal = sc.nextLine();
                System.out.print("Documento del estudiante: ");
                String documento = sc.nextLine();
                System.out.print("Estado (0=a tiempo, 1=tarde, 2=no asistió): ");
                String estado = sc.nextLine();

                control.registrarAsistenciaEstudiante(fecha, horaInicio, horaFinal, documento, estado);
                System.out.println("Asistencia registrada.");
            } else if (op == 11) {
                System.out.print("Fecha actual: ");
                String fecha = sc.nextLine();
                System.out.print("Hora inicio actual: ");
                String horaInicio = sc.nextLine();
                System.out.print("Hora final actual: ");
                String horaFinal = sc.nextLine();

                System.out.print("Nueva fecha: ");
                String nuevaFecha = sc.nextLine();
                System.out.print("Nueva hora inicio: ");
                String nuevaHoraInicio = sc.nextLine();
                System.out.print("Nueva hora final: ");
                String nuevaHoraFinal = sc.nextLine();

                if (control.consultarAsistencia(fecha, horaInicio, horaFinal) != null) {
                    control.modificarAsistencia(fecha, horaInicio, horaFinal, nuevaFecha, nuevaHoraInicio, nuevaHoraFinal);
                    System.out.println("Asistencia modificada correctamente.");
                } else {
                    System.out.println("No se encontró la asistencia.");
                }
            } else if (op == 12) {
                var asistencias = control.listarAsistencias();
                if (asistencias.isEmpty()) {
                    System.out.println("No hay asistencias registradas.");
                } else {
                    for (Asistencia a : asistencias) {
                        System.out.println("\nAsistencia: " + a.getFecha() + " | " + a.getHoraInicio() + " - " + a.getHoraFinal());
                        for (String info : a.obtenerResumenAsistencia()) {
                            System.out.println("  - " + info);
                        }
                    }
                }
            } else if (op == 13) {
                System.out.println("Saliendo del sistema...");
                return;
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
