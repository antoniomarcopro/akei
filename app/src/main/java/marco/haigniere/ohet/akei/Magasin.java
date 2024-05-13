package marco.haigniere.ohet.akei;

public class Magasin {
    private long idM;
    private String nom;
    private int numRue;
    private String nomRue;
    private String nomVille;
    private String numTel;

    public Magasin(long idM, String nom, int numRue, String nomRue, String nomVille, String numTel) {
        this.idM = idM;
        this.nom = nom;
        this.numRue = numRue;
        this.nomRue = nomRue;
        this.nomVille = nomVille;
        this.numTel = numTel;
    }

    public Magasin(String nom, int numRue, String nomRue, String nomVille, String numTel) {
        this.idM = -1;
        this.nom = nom;
        this.numRue = numRue;
        this.nomRue = nomRue;
        this.nomVille = nomVille;
        this.numTel = numTel;
    }

    public long getIdM() {
        return idM;
    }

    public void setIdM(long idM) {
        this.idM = idM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
