package com.mycompany.app;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.*;

public class Triangle
{
    private double small;
    private double medium;
    private double big;

    public Triangle(double side1, double side2, double side3)
    {
        if((side1<=0||side2<=0)||side3<=0)
        {
            throw new IllegalArgumentException("One of the sides cannot be negative.");
        }

        double tempBig = side2 >= side1 && side2 >= side3 ? side2 : side3;
        double tempSmall = side2 <= side1 && side2 <= side3 ? side2 : side3;
        double tempMedium = side2 != big && side2 != small ? side2 : side3;

        big = side1 >= side2 && side1 >= side3 ? side1 : tempBig;
        small = side1 <= side2 && side1 <= side3 ? side1 : tempSmall;
        medium = side1 != big && side1 != small ? side1 : tempMedium;

        if(side1==side2 && side3<side1)
        {
            medium = big;
        }
        else if(side1==side2 && side3>side1)
        {
            medium = small;
        }
    }

    public boolean isTriangle(){
        return small+medium>big;
    }

    public boolean isAcuteTriangle(){
        return (Math.pow(small,2)+Math.pow(medium,2)>Math.pow(big,2)) && isTriangle();
    }

    public boolean isObtuseTriangle(){
        return (Math.pow(small,2)+Math.pow(medium,2)<Math.pow(big,2)) && isTriangle();
    }

    public boolean isRightTriangle(){
        return (Math.pow(small,2)+Math.pow(medium,2)==Math.pow(big,2)) && isTriangle();
    }

    public boolean isIsoscelesTriangle(){
        return (small==medium) || (medium==big);
    }

    public boolean isEquilateralTriangle(){
        return (small==medium) && (medium==big);
    }

    public void showType() throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
                FileOutputStream(java.io.FileDescriptor.out), StandardCharsets.US_ASCII), 512);

        try{
            if(isAcuteTriangle()){
                if(isEquilateralTriangle())
                    out.write("This is an equilateral triangle\n");
                else if(isIsoscelesTriangle())
                    out.write("This is an acute isosceles triangle\n");
                else
                    out.write("This is an acute scalene triangle\n");
            }
            else if(isObtuseTriangle()){
                if(isIsoscelesTriangle())
                    out.write("This is an obtuse isosceles triangle\n");
                else
                    out.write("This is an obtuse scalene triangle\n");
            }
            else if(isRightTriangle()){
                if(isIsoscelesTriangle())
                    out.write("This is a right isosceles triangle\n");
                else
                    out.write("This is a right scalene triangle\n");
            }
            else
                out.write("No triangle is formed with the given sides\n");

            out.flush();
        }finally {
            out.close();
        }
    }

    public double getBig(){
        return big;
    }
    public double getMedium(){
        return medium;
    }
    public double getSmall(){
        return small;
    }
}
