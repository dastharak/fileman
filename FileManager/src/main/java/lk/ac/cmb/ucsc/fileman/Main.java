/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ac.cmb.ucsc.fileman;

import com.github.filemanager.FileManager;

/**
 *
 * @author UCSC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        //TODO read ini file to find the configuration file
        fm.main(args);
    }
    
}
