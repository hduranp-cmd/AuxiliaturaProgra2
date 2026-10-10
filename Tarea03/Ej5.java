package com.mycompany.ej5;

abstract class Figura {
    protected String color;
    public Figura(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    protected abstract double obtenerArea();
}

class cuadrado extends Figura {
    
    private int lado;

    public cuadrado(String color, int lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    protected double obtenerArea() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "cuadrado{" + "lado=" + lado + '}';
    }

    
}

class triangulo extends Figura {

    private int lado1;
    private int lado2;
    private int lado3;

    public triangulo(String color, int lado1, int lado2, int lado3) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    protected double obtenerArea() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public String toString() {
        return "triangulo{" + "lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + '}';
    }

    
}

class redondo extends Figura {

    private int radio;

    public redondo(String color, int radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    protected double obtenerArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public String toString() {
        return "redondo{" + "radio=" + radio + '}';
    }
}

public class Ej5 {

    public static void main(String[] args) {
        // Inciso c: Instanciar 2 objetos de cada subclase
        cuadrado cu1 = new cuadrado("verde", 4);
        cuadrado cu2 = new cuadrado("amarillo", 12);

        redondo red1 = new redondo("azul", 5);
        redondo red2 = new redondo("amarillo", 2);

        triangulo tri1 = new triangulo("celeste", 4, 3, 2);
        triangulo tri2 = new triangulo("rojo", 6, 8, 10);

        // Mostrar objetos creados
        System.out.println(cu1.toString() + " | Color: " + cu1.getColor() + " | Área: " + cu1.obtenerArea());
        System.out.println(cu2.toString() + " | Color: " + cu2.getColor() + " | Área: " + cu2.obtenerArea());

        System.out.println(red1.toString() + " | Color: " + red1.getColor() + " | Área: " + red1.obtenerArea());
        System.out.println(red2.toString() + " | Color: " + red2.getColor() + " | Área: " + red2.obtenerArea());

        System.out.println(tri1.toString() + " | Color: " + tri1.getColor() + " | Área: " + tri1.obtenerArea());
        System.out.println(tri2.toString() + " | Color: " + tri2.getColor() + " | Área: " + tri2.obtenerArea());

        System.out.println("\n--- INCISO D ---");
        // Llamada al método para comparar un Cuadrado y un Triángulo
        mostrarColorMayorArea(cu1, tri1);
    }

    public static void mostrarColorMayorArea(Figura f1, Figura f2) {
        if (f1.obtenerArea() > f2.obtenerArea()) {
            System.out.println("La figura con mayor área es de color: " + f1.getColor());
        } else if (f2.obtenerArea() > f1.obtenerArea()) {
            System.out.println("La figura con mayor área es de color: " + f2.getColor());
        } else {
            System.out.println("Ambas figuras tienen la misma área. Colores: "
                    + f1.getColor() + " y " + f2.getColor());
        }
    }
}