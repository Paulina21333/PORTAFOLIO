
package controllers;

public class modelou2 {
    public String funcionpolinominal(){
    return "int (x^n) = (x^n+1)/n+1";
    }
    public String integrallogaritmo(){
    return "int (1/x) = ln(x)";
    }
    public String trigonometricas(){
    return "int (sin x) = -cos(x)";
    }
    public String sustitucion(){
    return "int (f(u) du)";
    }
    public String porpartes(){
    return "int ( u dv) = uv - v* int(vdu)";
    }
}
