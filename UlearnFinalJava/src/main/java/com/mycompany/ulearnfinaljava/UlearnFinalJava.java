
package com.mycompany.ulearnfinaljava;

import java.io.File;


public class UlearnFinalJava {

    public static void main(String[] args) 
    {
        File fl = new File("NetBeansProjects/UlearnFinalJava/src/main/resources/NewData.bd");
        if(!(fl.exists()))
        {
            BDCreator b = new BDCreator();
            Frame();
        }
        else
        {
            Frame();
        }
    }
    
    
    public static void Frame()
    {
        Program fr = new Program();
        fr.setVisible(true);
    }
}
