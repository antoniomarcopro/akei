package marco.haigniere.ohet.akei;

public class Employe {

    private long idE;
    private String nomE;
    private String prenomE;
    private String mailE;
    private int age;

    private long idM;

    private long idPi;

    public long getIdE() {
        return idE;
    }

    public void setIdE(long idE) {
        this.idE = idE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getMailE() {
        return mailE;
    }

    public void setMailE(String mailE) {
        this.mailE = mailE;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getIdM() {
        return idM;
    }

    public void setIdM(long idM) {
        this.idM = idM;
    }

    public long getIdPi() {
        return idPi;
    }

    public void setIdPi(long idPi) {
        this.idPi = idPi;
    }

    public Employe(long idE, String nomE, String prenomE, String mailE, int age, long idM, long idPi) {
        this.idE = idE;
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.mailE = mailE;
        this.age = age;
        this.idM = idM;
        this.idPi = idPi;
    }

    public Employe(String nomE, String prenomE, String mailE, int age, long idM, long idPi) {
        this.idE = -1;
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.mailE = mailE;
        this.age = age;
        this.idM = idM;
        this.idPi = idPi;
    }


}
