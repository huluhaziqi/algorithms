package com.huluhaziqi.algorithms.test;

import java.util.Scanner;

import static java.lang.Math.cos;
import static java.lang.StrictMath.atan2;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.sqrt;

public class Pig {


    static double c(double x, double y, double r) {
        return sqrt(x * x + y * y) - r;
    }

    static double u(double x, double y, double t) {
        return x * cos(t) + y * sin(t);
    }

    static double v(double x, double y, double t) {
        return y * cos(t) - x * sin(t);
    }

    static double fa(double x, double y) {
        return Math.min(c(x, y, 0.5), c(x * 0.47 + 0.15, y + 0.25, 0.3));
    }

    static double no(double x, double y) {
        return c(x * 1.2 + 0.97, y + 0.25, 0.2);
    }

    static double nh(double x, double y) {
        return Math.min(c(x + 0.9, y + 0.25, 0.03), c(x + 0.75, y + 0.25, 0.03));
    }

    static double ea(double x, double y) {
        return Math.min(c(x * 1.7 + 0.3, y + 0.7, 0.15), c(u(x, y, 0.25) * 1.7, v(x, y, 0.25) + 0.65, 0.15));
    }

    static double ey(double x, double y) {
        return Math.min(c(x + 0.4, y + 0.35, 0.1), c(x + 0.15, y + 0.35, 0.1));
    }

   static double pu(double x, double y) {
        return Math.min(c(x + 0.38, y + 0.33, 0.03), c(x + 0.13, y + 0.33, 0.03));
    }

    static double fr(double x, double y) {
        return c(x * 1.1 - 0.3, y + 0.1, 0.15);
    }

    static double mo(double x, double y) {
        return Math.max(c(x + 0.15, y - 0.05, 0.2), -c(x + 0.15, y, 0.25));
    }

    static double o(double x, double y,double i)
    {
        double r = f(x, y);
        return Math.abs(r) < 0.02 ? (atan2(f(x, y + 1e-3) - r, f(x + 1e-3, y) - r) + 0.3) * 1.273 + 6.5 : r < 0 ? i : 0;
    }

    static double s(double x, double y,double i)

    {
        return f(x, y) < 0 ? i : 0;
    }

    static double f(double x, double y) {
        return o(x, y, 1) > 0 ? Math.max(o(x, y, 1), s(x, y, 12)) : Math.max(o(x, y, 1), Math.max(o(x, y, 11), Math.max(o(x, y, 1), Math.max(o(x, y, 1), Math.max(s(x, y, 13), s(x, y, 12))))));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.next());
        for (double y = -1, s =  1; y < 0.6; y += 0.05 / s)
            for (double x = -1; x < 0.6; x += 0.025 / s)
                System.out.print(" .|/=\\|/=\\| @!".charAt((int) f(u(x, y, 0.3), v(x, y, 0.3))));
    }


}
