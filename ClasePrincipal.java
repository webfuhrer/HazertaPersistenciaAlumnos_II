/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazerta.alumnospersistencia2;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        ArrayList<Alumno> lista_alumnos=AccesoFichero.devolverAlumnos();
        int opcion=EntradaSalida.mostrarMenu();
        while(opcion!=EntradaSalida.SALIR)
        {
                switch(opcion)
                {
                    case EntradaSalida.INSERTAR:
                        Alumno a=EntradaSalida.pedirAlumno();
                        lista_alumnos.add(a);
                        break;
                    case EntradaSalida.LISTAR:
                        EntradaSalida.listar(lista_alumnos);
                        break;
                    case EntradaSalida.BUSCAR:
                        String nombre_buscado=EntradaSalida.pedirNombreBuscado();
                        Alumno alumno_buscado=buscarAlumnosPorNombre(lista_alumnos, nombre_buscado);
                        EntradaSalida.mostrarAlumno(alumno_buscado);
                        break;
                    case EntradaSalida.GRABAR:
                        AccesoFichero.grabarAlumnos(lista_alumnos);
                        break;
                }
           opcion=EntradaSalida.mostrarMenu();
        }
    }

    private static Alumno buscarAlumnosPorNombre(ArrayList<Alumno> lista_alumnos, String nombre_buscado) {
        int i=0; 
        for( i=0;i<lista_alumnos.size(); i++ )
        {
            Alumno a=lista_alumnos.get(i);
            String nombre_alumno=a.getNombre();
            if(nombre_alumno.equalsIgnoreCase(nombre_buscado))
            {
                return a;
            }
        }
       return null; 
    }
}
