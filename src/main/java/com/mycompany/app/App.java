package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Triangle tri = new Triangle(8, 5, 5);
            System.out.println(tri.getSmall());
            System.out.println(tri.getMedium());
            System.out.println(tri.getBig());
            tri.showType();
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
