package marco.haigniere.ohet.akei;

public class Vehicule {
    private long idV;
    private double longueur;
    private double largeur;
    private double hauteur;
    private String plaque;
    private String carburant;
    private int nbrKm;
    private double volumeCoffre;
    private String typeVehicule;
    private String marque;
    private String modele;
    private boolean etat;
    private long idM;

    public Vehicule(long idV, double longueur, double largeur, double hauteur, String plaque, String carburant, int nbrKm, double volumeCoffre, String typeVehicule, String marque, String modele, boolean etat, long idM) {
        this.idV = idV;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.plaque = plaque;
        this.carburant = carburant;
        this.nbrKm = nbrKm;
        this.volumeCoffre = volumeCoffre;
        this.typeVehicule = typeVehicule;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
        this.idM = idM;
    }

    public Vehicule(long longueur, long largeur, long hauteur, String plaque, String carburant, int nbrKm, double volumeCoffre, String typeVehicule, String marque, String modele, boolean etat, long idM) {
        this.idV = -1;
        this.longueur       = longueur;
        this.largeur        = largeur;
        this.hauteur        = hauteur;
        this.plaque         = plaque;
        this.carburant      = carburant;
        this.nbrKm          = nbrKm;
        this.volumeCoffre   = volumeCoffre;
        this.typeVehicule   = typeVehicule;
        this.marque         = marque;
        this.modele         = modele;
        this.etat           = etat;
        this.idM            = idM;
    }

    public long getIdV() {
        return idV;
    }

    public void setIdV(long idV) {
        this.idV = idV;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public int getNbrKm() {
        return nbrKm;
    }

    public void setNbrKm(int nbrKm) {
        this.nbrKm = nbrKm;
    }

    public double getVolumeCoffre() {
        return volumeCoffre;
    }

    public void setVolumeCoffre(double volumeCoffre) {
        this.volumeCoffre = volumeCoffre;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public long getIdM() {
        return idM;
    }

    public void setIdM(long idM) {
        this.idM = idM;
    }
}
