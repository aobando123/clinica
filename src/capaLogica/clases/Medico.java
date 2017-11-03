package capaLogica.clases;

public class Medico {
    private int codigo;
    private String nombreCompleto;
    private String email;
    private String especialidad;
    private int telefono;
    private int cedula;

    public Medico() {
    }

    /**
     * Constructor que inicializa el medico con informacion ya llena
     * @param codigo
     * @param nombreCompleto
     * @param email
     * @param especialidad
     * @param telefono
     * @param cedula
     */
    public Medico(int codigo, String nombreCompleto, String email, String especialidad, int telefono, int cedula) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * imprime el medico con los datos de este
     * @return datos del medico
     */
    @Override
    public String toString() {
        return "Medico:" +
                "codigo =" + codigo +
                ", nombreCompleto ='" + nombreCompleto + '\'' +
                ", email ='" + email + '\'' +
                ", especialidad ='" + especialidad + '\'' +
                ", telefono =" + telefono +
                ", cedula =" + cedula +
                '}';
    }
}
