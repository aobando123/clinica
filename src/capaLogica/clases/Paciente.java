package capaLogica.clases;

public class Paciente {
    private int cedula;
    private  String nombreCompleto;
    private String direccion;
    private String email;
    private int telefono;

    public Paciente() {
    }

    /**
     * Contructor que genera a un paciente con informacion ya lista
     * @param cedula
     * @param nombreCompleto
     * @param direccion
     * @param email
     * @param telefono
     */
    
    public Paciente(int cedula, String nombreCompleto, String direccion, String email, int telefono) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * imprime el paciente con los datos de el
     * @return datos del paciente
     */
    @Override
    public String toString() {
        return "Paciente:" +
                "cedula =" + cedula +
                ", nombreCompleto ='" + nombreCompleto + '\'' +
                ", direccion ='" + direccion + '\'' +
                ", email ='" + email + '\'' +
                ", telefono =" + telefono +
                '}';
    }
}
