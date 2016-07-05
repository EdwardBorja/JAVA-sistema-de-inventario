/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.File;

/**
 *
 * @author edward
 */
public class Archivos {
    public static void carpeta(){
        File Sistema = new File("c:\\SistemaTemsa");
        File Respaldo = new File("c:\\SistemaTemsa\\Respaldo");
        File Image = new File("c:\\SistemaTemsa\\Unidades");
        File Image2 = new File("c:\\SistemaTemsa\\Conductores");
        
       if(Sistema.exists()){
        }if(!Sistema.exists()){
            Sistema.mkdir();
            Respaldo.mkdir();
            Image.mkdir();
            Image2.mkdir();
        }
    }
}


