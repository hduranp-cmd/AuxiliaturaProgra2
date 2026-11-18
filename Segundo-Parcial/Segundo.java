package com.mycompany.segundo;

class Anuncio {

    protected int num;
    protected double precio;

    public Anuncio(int num, double precio) {
        this.num = num;
        this.precio = precio;
    }

    public Anuncio() {
        this.num = 0;
        this.precio = 1500.0; 
    }

    public double getPrecio() {
        return this.precio;
    }
}

class Artista {

    protected String nombre;
    protected int ci;
    protected int aniosexp;

    public Artista(String nombre, int ci, int aniosexp) {
        this.nombre = nombre;
        this.ci = ci;
        this.aniosexp = aniosexp;
    }

    public int getanio() {
        return this.aniosexp;
    }

    public String getNombre() {
        return this.nombre;
    }
}

class Obra {

    protected String titulo;
    protected String material;

    protected Artista a1;
    protected Artista a2;

    protected Anuncio b;

    public Obra(String titulo, String material, String nom1, int ci1, int exp1, String nom2, int ci2, int exp2) {
        this.titulo = titulo;
        this.material = material;

        this.a1 = new Artista(nom1, ci1, exp1);
        this.a2 = new Artista(nom2, ci2, exp2);
        this.b = null;
    }

    public void agregaAnuncio(Anuncio anuncio) {
        this.b = anuncio;
    }

    public Artista getmay() {
        if (a1.getanio() > a2.getanio()) {
            return a1;
        } else {
            return a2;
        }
    }

    
    public double getPrecioAnuncio() {
        if (this.b != null) {
            return this.b.getPrecio();
        }
        return 0.0;
    }
}

class Pintura extends Obra {

    protected String genero;

    public Pintura(String genero, String titulo, String material, String nom1, int ci1, int exp1, String nom2, int ci2, int exp2) {
        super(titulo, material, nom1, ci1, exp1, nom2, ci2, exp2);
        this.genero = genero;
    }

    
    public void mostrarMayorExp(Pintura otra) {
        Artista mejor1 = this.getmay();
        Artista mejor2 = otra.getmay();

        if (mejor1.getanio() >= mejor2.getanio()) {
            System.out.println("Artista con más experiencia: " + mejor1.getNombre());
        } else {
            System.out.println("Artista con más experiencia: " + mejor2.getNombre());
        }
    }

    
    public double calcularTotalVenta(Pintura otra) {
        return this.getPrecioAnuncio() + otra.getPrecioAnuncio();
    }
}

public class Segundo {

    public static void main(String[] args) {
        
        Pintura a = new Pintura("gotico", "Mono", "oleo", "nom1", 1260, 50, "Lopez", 3453, 60);
        Anuncio b1 = new Anuncio(1, 2500.0);
        a.agregaAnuncio(b1);

        Pintura b2 = new Pintura("gotico", "Mono 2", "oleo", "nom1", 1260, 50, "Mujia", 3453, 75);

        
        a.mostrarMayorExp(b2);

        
        Anuncio an2 = new Anuncio(2, 3200.0);
        b2.agregaAnuncio(an2);

        double total = a.calcularTotalVenta(b2);
        System.out.println("Monto total de venta de ambas pinturas: " + total);
    }
}