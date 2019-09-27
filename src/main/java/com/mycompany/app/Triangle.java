package com.mycompany.app;

public class Triangle
{
    private double small;
    private double medium;
    private double big;

    public Triangle(double side1, double side2, double side3) throws IllegalArgumentException
    {
        if((side1<=0||side2<=0)||side3<=0)
        {
            throw new IllegalArgumentException("One of the sides cannot be negative.");
        }

        big = side1 >= side2 && side1 >= side3 ? side1 : side2 >= side1 && side2 >= side3 ? side2 : side3;
        small = side1 <= side2 && side1 <= side3 ? side1 : side2 <= side1 && side2 <= side3 ? side2 : side3;
        medium = side1 != big && side1 != small ? side1 : side2 != big && side2 != small ? side2 : side3;

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

    public void showType(){
        if(isAcuteTriangle()){
            if(isEquilateralTriangle())
                System.out.println("This is an equilateral triangle");
            else if(isIsoscelesTriangle())
                System.out.println("This is an acute isosceles triangle");
            else
                System.out.println("This is an acute scalene triangle");
        }
        else if(isObtuseTriangle()){
            if(isIsoscelesTriangle())
                System.out.println("This is an obtuse isosceles triangle");
            else
                System.out.println("This is an obtuse scalene triangle");
        }
        else if(isRightTriangle()){
            if(isIsoscelesTriangle())
                System.out.println("This is a right isosceles triangle");
            else
                System.out.println("This is a right scalene triangle");
        }
        else
            System.out.println("No triangle is formed with the given sides");
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
