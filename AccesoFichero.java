/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazerta.alumnospersistencia2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccesoFichero {
    private static String ruta_fichero="D:\\alumnos.csv";
    private static String separador=",";
    private static String salto="\n";
    static ArrayList<Alumno> devolverAlumnos()
    {ArrayList<Alumno> lista=new ArrayList<Alumno>();
        
        
        try {
            
            FileReader lector=new FileReader(ruta_fichero);
            BufferedReader br=new BufferedReader(lector);
            //leer linea
            String linea=br.readLine();
            while(linea!=null)
            {
                String[] datos=linea.split(separador);
                String nombre=datos[0];
                String apellido=datos[1];
                String edad=datos[2];
                Alumno a=new Alumno(nombre, apellido, Integer.parseInt(edad));
                lista.add(a);
                linea=br.readLine();
            }
                
            //construir objeto alumno
            //meter el obejto alumo en un arraylist
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    static void grabarAlumnos(ArrayList<Alumno> lista_alumnos) {
        try {
            FileWriter escritor=new FileWriter(ruta_fichero, false);
            String linea="";
            for (Alumno alumno : lista_alumnos) {
                linea+=alumno.getNombre()+separador+alumno.getApellido()+separador+
                        alumno.getEdad()+salto;
            }
            escritor.write(linea);
            escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
