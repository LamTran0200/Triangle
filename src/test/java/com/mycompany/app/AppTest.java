package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    double side1 = 8;
    double side2 = 5;
    double side3 = 5;

    Triangle triangle = new Triangle(side1, side2, side3);

    @Test
    public void isTriangle() {
        assertEquals(true, triangle.isTriangle());
    }

    @Test
    public void isAcuteTriangle() {
        assertEquals(false, triangle.isAcuteTriangle());
    }

    @Test
    public void isObtuseTriangle() {
        assertEquals(true ,triangle.isObtuseTriangle());
    }

    @Test
    public void isRightTriangle() {
        assertEquals(false, triangle.isRightTriangle());
    }

    @Test
    public void isIsoscelesTriangle(){
        assertEquals(true, triangle.isIsoscelesTriangle());
    }

    @Test
    public void isEquilateralTriangle(){
        assertEquals(false, triangle.isEquilateralTriangle());
    }
}
