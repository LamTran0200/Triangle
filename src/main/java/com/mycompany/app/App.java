package com.mycompany.app;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Logger logger = Logger.getLogger(App.class.getName());
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
                FileOutputStream(java.io.FileDescriptor.out), StandardCharsets.US_ASCII), 512);

        try{
            Triangle tri = new Triangle(9, 7, 3);
            out.write("Small side: "+Double.toString(tri.getSmall()) + "\n");
            out.write("Medium side: "+Double.toString(tri.getMedium()) + "\n");
            out.write("Big side: "+Double.toString(tri.getBig()) + "\n");
            out.flush();
            tri.showType();
        }catch(IllegalArgumentException iae){
            logger.log(Level.SEVERE, iae.getMessage());
        }finally{
            out.close();
        }
    }
}
