package com.mycompany.ej7;

import java.util.ArrayList;
import java.util.List;


abstract class Documento {
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;

    public Documento(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
}


class Libro extends Documento {
    protected String editorial;

    public Libro(String titulo, String autor, int anioPublicacion, String editorial) {
        super(titulo, autor, anioPublicacion);
        this.editorial = editorial;
    }

    public String getEditorial() { return editorial; }
}

class Revista extends Libro {
    protected int volumen;
    protected int numero;
    protected String mesSalida;

    public Revista(String titulo, String autor, int anioPublicacion, String editorial, 
                   int volumen, int numero, String mesSalida) {
        super(titulo, autor, anioPublicacion, editorial);
        this.volumen = volumen;
        this.numero = numero;
        this.mesSalida = mesSalida;
    }
}


class DocumentoCD extends Documento {
    private String formatoCD;
    private String tipoLicencia;

    public DocumentoCD(String titulo, String autor, int anioPublicacion, 
                       String formatoCD, String tipoLicencia) {
        super(titulo, autor, anioPublicacion);
        this.formatoCD = formatoCD;
        this.tipoLicencia = tipoLicencia;
    }
}


class RevistaInvestigacion extends Revista {
    String campoInvestigacion;

    public RevistaInvestigacion(String titulo, String autor, int anioPublicacion, String editorial, 
                                int volumen, int numero, String mesSalida, String campoInvestigacion) {
        super(titulo, autor, anioPublicacion, editorial, volumen, numero, mesSalida);
        this.campoInvestigacion = campoInvestigacion;
    }
}


class Biblioteca {
    private String nombre;
    private List<Documento> documentos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.documentos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public List<Documento> getDocumentos() { return documentos; }

    public void agregarDocumento(Documento doc) {
        this.documentos.add(doc);
    }

    
    public int contarDocumentosTotales() {
        return documentos.size();
    }

    public int contarRevistas() {
        int contador = 0;
        for (Documento doc : documentos) {
            
            if (doc instanceof Revista) {
                contador++;
            }
        }
        return contador;
    }

    public int contarLibrosExclusivos() {
        int contador = 0;
        for (Documento doc : documentos) {
            
            if (doc.getClass() == Libro.class) {
                contador++;
            }
        }
        return contador;
    }

   
    public Biblioteca realizarCopiaSeguridad(String nuevoNombre) {
        Biblioteca copia = new Biblioteca(nuevoNombre);
        for (Documento doc : this.documentos) {
            
            if (doc instanceof RevistaInvestigacion) {
                RevistaInvestigacion ri = (RevistaInvestigacion) doc;
                copia.agregarDocumento(new RevistaInvestigacion(ri.getTitulo(), ri.getAutor(), 
                    ri.getAnioPublicacion(), ri.getEditorial(), ri.volumen, ri.numero, ri.mesSalida, ri.campoInvestigacion));
            } else if (doc instanceof Revista) {
                Revista r = (Revista) doc;
                copia.agregarDocumento(new Revista(r.getTitulo(), r.getAutor(), 
                    r.getAnioPublicacion(), r.getEditorial(), r.volumen, r.numero, r.mesSalida));
            } else if (doc instanceof Libro) {
                Libro l = (Libro) doc;
                copia.agregarDocumento(new Libro(l.getTitulo(), l.getAutor(), l.getAnioPublicacion(), l.getEditorial()));
            } else if (doc instanceof DocumentoCD) {
                DocumentoCD cd = (DocumentoCD) doc;
                copia.agregarDocumento(new DocumentoCD(cd.getTitulo(), cd.getAutor(), cd.getAnioPublicacion(), "ISO", "OpenSource"));
            }
        }
        return copia;
    }
}

public class Ej7 {

    public static void main(String[] args) {
        // b. Instanciar 2 bibliotecas
        Biblioteca b1 = new Biblioteca("Biblioteca Central");
        Biblioteca b2 = new Biblioteca("Biblioteca Norte");

        
        b1.agregarDocumento(new Libro("Soledad", "G. García Márquez", 1967, "Editorial Sudamericana"));
        b1.agregarDocumento(new Revista("National Geograpic", "Varios", 2023, "RBA", 10, 5, "Mayo"));
        b1.agregarDocumento(new RevistaInvestigacion("Software", "ACM", 2024, "IEEE", 12, 2, "Junio", "IA"));

        
        b2.agregarDocumento(new Libro("Don Quijote", "Miguel de Cervantes", 1605, "Francisco de Robles"));
        b2.agregarDocumento(new Libro("1984", "George", 1949, "Secker & Warburg"));
        b2.agregarDocumento(new Revista("Science", "Varios", 2022, "AAAS", 4, 1, "Enero"));
        b2.agregarDocumento(new DocumentoCD("Linux Ubuntu", "Canonical", 2023, "ISO", "GPL"));

        
        compararBibliotecas(b1, b2);

        trasladarDocumentos(b1, b2);
        System.out.println("Biblioteca 1 ahora tiene: " + b1.contarDocumentosTotales() + " documentos (" + b1.contarRevistas() + " revistas).");
        System.out.println("Biblioteca 2 ahora tiene: " + b2.contarDocumentosTotales() + " documentos (" + b2.contarLibrosExclusivos() + " libros).");

        
        Biblioteca b1Copia = b1.realizarCopiaSeguridad("Biblioteca Central - Backup");
        Biblioteca b2Copia = b2.realizarCopiaSeguridad("Biblioteca Norte - Backup");
        System.out.println("Copia B1 creada exitosamente con " + b1Copia.contarDocumentosTotales() + " documentos.");
        System.out.println("Copia B2 creada exitosamente con " + b2Copia.contarDocumentosTotales() + " documentos.");
    }


    public static void compararBibliotecas(Biblioteca b1, Biblioteca b2) {
        
        if (b1.contarDocumentosTotales() > b2.contarDocumentosTotales()) {
            System.out.println("La biblioteca con MÁS DOCUMENTOS es: " + b1.getNombre());
        } else if (b2.contarDocumentosTotales() > b1.contarDocumentosTotales()) {
            System.out.println("La biblioteca con MÁS DOCUMENTOS es: " + b2.getNombre());
        } else {
            System.out.println("Ambas bibliotecas tienen la misma cantidad total de documentos.");
        }

        
        if (b1.contarRevistas() > b2.contarRevistas()) {
            System.out.println("La biblioteca con MÁS REVISTAS es: " + b1.getNombre());
        } else if (b2.contarRevistas() > b1.contarRevistas()) {
            System.out.println("La biblioteca con MÁS REVISTAS es: " + b2.getNombre());
        } else {
            System.out.println("Ambas bibliotecas tienen la misma cantidad de revistas.");
        }
    }

    
    public static void trasladarDocumentos(Biblioteca b1, Biblioteca b2) {
        List<Documento> todos = new ArrayList<>();
        todos.addAll(b1.getDocumentos());
        todos.addAll(b2.getDocumentos());

        
        b1.getDocumentos().clear();
        b2.getDocumentos().clear();

        for (Documento doc : todos) {
            if (doc instanceof Revista) {
                b1.agregarDocumento(doc); 
            } else if (doc.getClass() == Libro.class) {
                b2.agregarDocumento(doc); 
            } else {
               
                b1.agregarDocumento(doc);
            }
        }
    }
}