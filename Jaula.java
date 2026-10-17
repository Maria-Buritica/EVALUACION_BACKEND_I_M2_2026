public class Jaula {
    private int numero;
    private String tamano;
    private String zona;
    private Paciente ocupante;

    public Jaula(int numero, String tamano, String zona) {
        setNumero(numero);
        setTamano(tamano);
        setZona(zona);
    }

    public int getNumero() {
        return numero;
    }
    public String getTamano() {
        return tamano;
    }
    public String getZona() {
        return zona;
    }
    public Paciente getOcupante() {
        return ocupante;
    }
    public boolean estaLibre() {
        return ocupante == null;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Numero invalido");
        }
        this.numero = numero;
    }

    public void setTamano(String tamano) {
        if (!"S".equals(tamano) && !"M".equals(tamano) && !"L".equals(tamano)) {
            throw new IllegalArgumentException("Tamano invalido");
        }
        this.tamano = tamano;
    }

    public void setZona(String zona) {
        if (!"A".equals(zona) && !"B".equals(zona)) {
            throw new IllegalArgumentException("Zona invalida");
        }
        this.zona = zona;
    }

    public void setOcupante(Paciente ocupante) {
        if (ocupante != null && this.ocupante != null && this.ocupante != ocupante) {
            throw new IllegalArgumentException("Jaula ocupada");
        }
        if (ocupante != null && ocupante.getJaula() != null
                && ocupante.getJaula() != this) {
            throw new IllegalArgumentException("Paciente ya alojado");
        }
        this.ocupante = ocupante;
    }
}
