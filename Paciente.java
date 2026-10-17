public class Paciente {
    // Margen para errores de redondeo de double (ej.: 0.7 * 3 = 2.0999999999999996).
    private static final double TOLERANCIA = 0.000001;

    private String nombre;
    private double peso;
    private int edad;
    private String estado;
    private final double factorDosis;
    private final double pesoMaximo;
    private double dosisAcumulada;
    private Jaula jaula;

    public Paciente(String nombre, double peso, int edad, double factorDosis, double pesoMaximo) {
        if (!Double.isFinite(factorDosis) || factorDosis <= 0
                || !Double.isFinite(pesoMaximo) || pesoMaximo <= 0) {
            throw new IllegalArgumentException("Limites invalidos");
        }
        this.factorDosis = factorDosis;
        this.pesoMaximo = pesoMaximo;
        setNombre(nombre);
        setPeso(peso);
        setEdad(edad);
        setEstado("INGRESADO");
    }

    public String getNombre() {
        return nombre;
    }
    public double getPeso() {
        return peso;
    }
    public int getEdad() {
        return edad;
    }
    public String getEstado() {
        return estado;
    }
    public double getFactorDosis() {
        return factorDosis;
    }
    public double getDosisAcumulada() {
        return dosisAcumulada;
    }
    public Jaula getJaula() {
        return jaula;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre invalido");
        }
        this.nombre = nombre.trim();
    }

    public void setPeso(double peso) {
        if (!Double.isFinite(peso) || peso <= 0 || peso > getPesoMaximo()
                || dosisAcumulada > 3 * peso * factorDosis + TOLERANCIA) {
            throw new IllegalArgumentException("Peso invalido");
        }
        this.peso = peso;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 30) {
            throw new IllegalArgumentException("Edad invalida");
        }
        this.edad = edad;
    }

    public void setEstado(String estado) {
        if (!"INGRESADO".equals(estado) && !"CUARENTENA".equals(estado)
                && !"EN_TRATAMIENTO".equals(estado)) {
            throw new IllegalArgumentException("Estado invalido");
        }
        this.estado = estado;
    }

    public void setDosisAcumulada(double dosisAcumulada) {
        if (!Double.isFinite(dosisAcumulada) || dosisAcumulada < 0
                || dosisAcumulada > 3 * getDosisMaxima() + TOLERANCIA) {
            throw new IllegalArgumentException("Acumulado invalido");
        }
        this.dosisAcumulada = dosisAcumulada;
    }

    // Hospital mantiene los dos enlaces: paciente -> jaula y jaula -> paciente.
    public void setJaula(Jaula jaula) {
        if (jaula != null && jaula.getOcupante() != null
                && jaula.getOcupante() != this) {
            throw new IllegalArgumentException("Jaula ocupada");
        }
        this.jaula = jaula;
    }

    public double getDosisMaxima() {
        return peso * factorDosis;
    }

    public boolean excedeDosisMaxima(double mg) {
        return mg > getDosisMaxima() + TOLERANCIA;
    }

    public boolean superaTopeAcumulado(double mg) {
        return dosisAcumulada + mg > 3 * getDosisMaxima() + TOLERANCIA;
    }

    public String getTamanoNecesario() {
        if (peso < 5) {
            return "S";
        }
        if (peso <= 25) {
            return "M";
        }
        return "L";
    }

    protected double getPesoMaximo() {
        return pesoMaximo;
    }

    public String getTipo() {
        return "Paciente";
    }

    public String getZonaNecesaria() {
        return "A";
    }
}
