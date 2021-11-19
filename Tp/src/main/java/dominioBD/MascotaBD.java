package dominioBD;

import Business.*;
import utils.BDUtils;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Table(name = "mascota_bd")
@Entity
public class MascotaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long masc_id;

    private String masc_nombre;
    private String masc_apodo;
    private int masc_edad;
    private String masc_sexo;
    private String masc_especie;
    private String masc_descripcion;
    private Boolean masc_tieneChapita;


    @ManyToOne
    @JoinColumn(name = "orga_id")
    private OrganizacionBD masc_organizacion;

    @ManyToOne
    @JoinColumn(name = "pers_id")
    private DuenioBD masc_duenio;

    @OneToMany (mappedBy = "carMasMas_mascota")
    private List<CarMasXMas> carMasXMas;

    @OneToMany(mappedBy = "fani_masc")
    private List<FotoAnimales> fotoAnimales;

    @OneToMany(mappedBy = "pregOrg_mascota")
    private List<PregOrgXmascota>pregOrgXmascotas;

    @OneToMany(mappedBy = "caorXmas_mascota")
    private List<CaracOrgXmascota>caracOrgXmascotas;

    @OneToMany(mappedBy = "resc_mascota")
    private List<RescateBD> masc_rescate;

    public Mascota transformar() {
        Long id = this.getMasc_id();
        String nombre = this.getMasc_nombre();
        String apodo = this.getMasc_apodo();
        Integer edad = this.getMasc_edad();
        String sexo = this.getMasc_sexo();
        Especie especie = Especie.valueOf(this.getMasc_especie().toUpperCase(Locale.ROOT));
        String descripcion = this.getMasc_descripcion();
        Boolean tieneChapita = this.getMasc_tieneChapita();
        List<Foto> fotos = BDUtils.dameFotosMasc(id);
        Duenio duenio = masc_duenio.transformar();
        HashMap<String, String> caracteristicas = BDUtils.dameHashCaracteristicasMasc(id);
        return new Mascota(id,fotos,especie,nombre,apodo,edad,sexo,descripcion,tieneChapita,caracteristicas,duenio);

    }



    public Long getMasc_id() {
        return masc_id;
    }

    public void setMasc_id(Long masc_id) {
        this.masc_id = masc_id;
    }

    public String getMasc_nombre() {
        return masc_nombre;
    }

    public void setMasc_nombre(String masc_nombre) {
        this.masc_nombre = masc_nombre;
    }

    public String getMasc_apodo() {
        return masc_apodo;
    }

    public void setMasc_apodo(String masc_apodo) {
        this.masc_apodo = masc_apodo;
    }

    public int getMasc_edad() {
        return masc_edad;
    }

    public void setMasc_edad(int masc_edad) {
        this.masc_edad = masc_edad;
    }

    public String getMasc_sexo() {
        return masc_sexo;
    }

    public void setMasc_sexo(String masc_sexo) {
        this.masc_sexo = masc_sexo;
    }

    public String getMasc_especie() {
        return masc_especie;
    }

    public void setMasc_especie(String masc_especie) {
        this.masc_especie = masc_especie;
    }

    public String getMasc_descripcion() {
        return masc_descripcion;
    }

    public void setMasc_descripcion(String masc_descripcion) {
        this.masc_descripcion = masc_descripcion;
    }

    public Boolean getMasc_tieneChapita() {
        return masc_tieneChapita;
    }

    public void setMasc_tieneChapita(Boolean masc_tieneChapita) {
        this.masc_tieneChapita = masc_tieneChapita;
    }

    public OrganizacionBD getMasc_organizacion() {
        return masc_organizacion;
    }

    public void setMasc_organizacion(OrganizacionBD masc_organizacion) {
        this.masc_organizacion = masc_organizacion;
    }

    public DuenioBD getMasc_duenio() {
        return masc_duenio;
    }

    public void setMasc_duenio(DuenioBD masc_duenio) {
        this.masc_duenio = masc_duenio;
    }

    public List<CarMasXMas> getCarMasXMas() {
        return carMasXMas;
    }

    public void setCarMasXMas(List<CarMasXMas> carMasXMas) {
        this.carMasXMas = carMasXMas;
    }

    public List<FotoAnimales> getFotoAnimales() {
        return fotoAnimales;
    }

    public void setFotoAnimales(List<FotoAnimales> fotoAnimales) {
        this.fotoAnimales = fotoAnimales;
    }

    public List<PregOrgXmascota> getPregOrgXmascotas() {
        return pregOrgXmascotas;
    }

    public void setPregOrgXmascotas(List<PregOrgXmascota> pregOrgXmascotas) {
        this.pregOrgXmascotas = pregOrgXmascotas;
    }

    public List<CaracOrgXmascota> getCaracOrgXmascotas() {
        return caracOrgXmascotas;
    }

    public void setCaracOrgXmascotas(List<CaracOrgXmascota> caracOrgXmascotas) {
        this.caracOrgXmascotas = caracOrgXmascotas;
    }

    public List<RescateBD> getMasc_rescate() {
        return masc_rescate;
    }

    public void setMasc_rescate(List<RescateBD> masc_rescate) {
        this.masc_rescate = masc_rescate;
    }
}