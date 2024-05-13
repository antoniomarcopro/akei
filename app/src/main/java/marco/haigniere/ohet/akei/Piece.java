package marco.haigniere.ohet.akei;

public class Piece {

    private long idPi;
    private String description;
    private String nom;

    public Piece(long idPi, String description, String nom) {
        this.idPi = idPi;
        this.description = description;
        this.nom = nom;
    }
    public Piece(String description, String nom) {
        this.idPi = -1;
        this.description = description;
        this.nom = nom;
    }

    public long getIdPi() {
        return idPi;
    }

    public void setIdPi(long idPi) {
        this.idPi = idPi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "idPi=" + idPi +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
