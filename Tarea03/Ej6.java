package com.mycompany.ej6;

class Animal {
    protected int edad;
    protected double peso;
    protected String especie;

    public Animal(int edad, double peso, String especie) {
        this.edad = edad;
        this.peso = peso;
        this.especie = especie;
    }

    public String respirar() {
        return "Esta tomando oxígeno";
    }

    public String mover() {
        return "Se está desplazando";
    }
}

class Terrestre extends Animal {
    private String pelaje;
    private String salud;

    public Terrestre(int edad, double peso, String especie, String pelaje, String salud) {
        super(edad, peso, especie);
        this.salud = salud;
        this.pelaje = pelaje;
    }

    
    public String correr() {
        return "Está corriendo";
    }

    
    public String saltar() {
        return "Está saltando";
    }

    @Override
    public String toString() {
        return "Terrestre{especie=" + especie + ", edad=" + edad + ", peso=" + peso + 
               ", pelaje=" + pelaje + ", salud=" + salud + '}';
    }

    @Override
    public String respirar() {
        
        return super.respirar() + " absorbiendo aire desde la superficie mediante sus pulmones.";
    }

    @Override
    public String mover() {
        return super.mover() + " caminando/corriendo con sus patas sobre el suelo.";
    }
}

class Aereo extends Animal {
    private int nplumas;
    private double talas;

    public Aereo(int edad, double peso, String especie, int nplumas, double talas) {
        super(edad, peso, especie);
        this.nplumas = nplumas;
        this.talas = talas;
    }

    
    public String volar() {
        return "Está volando";
    }

    
    public String planear() {
        return "Está planeando";
    }

    @Override
    public String toString() {
        return "Aereo{especie=" + especie + ", edad=" + edad + ", peso=" + peso + 
               ", nplumas=" + nplumas + ", talas=" + talas + '}';
    }

    @Override
    public String respirar() {
        return super.respirar() + " mediante un sistema especial de sacos aéreos en el aire.";
    }

    @Override
    public String mover() {
        return super.mover() + " batiendo sus alas por el cielo.";
    }
}

class Acuatico extends Animal {
    private String colescama;
    private int naletas;

    public Acuatico(int edad, double peso, String especie, String colescama, int naletas) {
        super(edad, peso, especie);
        this.naletas = naletas;
        this.colescama = colescama;
    }

    
    public String nadar() {
        return "Está nadando";
    }

    
    public String comer() {
        return "Está comiendo";
    }

    @Override
    public String toString() {
        return "Acuatico{especie=" + especie + ", edad=" + edad + ", peso=" + peso + 
               ", colescama=" + colescama + ", naletas=" + naletas + '}';
    }

    @Override
    public String respirar() {
        return super.respirar() + " filtrando el oxígeno del agua mediante sus branquias.";
    }

    @Override
    public String mover() {
        return super.mover() + " nadando a lo largo del mar con sus aletas.";
    }
}

public class Ej6 {
    public static void main(String[] args) {
        Terrestre perro1 = new Terrestre(8, 12.5, "Perro", "Blanco", "Buena");
        Acuatico pez1 = new Acuatico(2, 2.4, "Calamar", "Rojo", 4);
        Aereo aguila1 = new Aereo(18, 33.5, "Águila", 200, 45.9);

        
        
        System.out.println(perro1.toString());
        System.out.println(pez1.toString());
        System.out.println(aguila1.toString());

        
        
        System.out.println("Perro: " + perro1.respirar());
        System.out.println("Calamar: " + pez1.respirar());
        System.out.println("Águila: " + aguila1.respirar());

        
        System.out.println("Perro: " + perro1.mover());
        System.out.println("Calamar: " + pez1.mover());
        System.out.println("Águila: " + aguila1.mover());
    }
}