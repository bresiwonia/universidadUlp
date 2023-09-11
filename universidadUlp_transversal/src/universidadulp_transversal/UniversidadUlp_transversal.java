/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_transversal;

import AccesoADatos.ConexionDate;

/**
 *
 * @author viper
 */
public class UniversidadUlp_transversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ConexionDate cc = new ConexionDate("universidadulp");
       cc.conectar();
       
    }
    
}
