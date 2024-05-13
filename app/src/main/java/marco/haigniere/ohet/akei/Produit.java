package marco.haigniere.ohet.akei;

public class Produit {

    private long idPr;

    private String nomP;
    private String descTechnique;
    private double prix;
    private int largeur;
    private int longueur;
    private int hauteur;
    private int poids;
    private long idPi;

    public Produit(long idPr, String nomP, String descTechnique, double prix, int largeur, int longueur, int hauteur, int poids, long idPi) {
        this.nomP = nomP;
        this.idPr = idPr;
        this.descTechnique = descTechnique;
        this.prix = prix;
        this.largeur = largeur;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.poids = poids;
        this.idPi = idPi;
    }

    public Produit(String nomP, String descTechnique, double prix, int largeur, int longueur, int hauteur, int poids, long idPi) {
        this.nomP = nomP;
        this.idPr = -1;
        this.descTechnique = descTechnique;
        this.prix = prix;
        this.largeur = largeur;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.poids = poids;
        this.idPi = idPi;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public long getIdPr() {
        return idPr;
    }

    public void setIdPr(long idPr) {
        this.idPr = idPr;
    }

    public String getDescTechnique() {
        return descTechnique;
    }

    public void setDescTechnique(String descTechnique) {
        this.descTechnique = descTechnique;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public long getIdPi() {
        return idPi;
    }

    public void setIdPi(long idPi) {
        this.idPi = idPi;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idPr=" + idPr +
                ", nom du produit='" + nomP + '\'' +
                ", descTechnique='" + descTechnique + '\'' +
                ", prix=" + prix +
                ", largeur=" + largeur +
                ", longueur=" + longueur +
                ", hauteur=" + hauteur +
                ", poids=" + poids +
                ", idPi=" + idPi +
                '}';
    }
}
