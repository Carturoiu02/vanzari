public class Produs {
    private String produs;
    private String marca;
    private String model;
    private String versiune;
    private int pret;


    public Produs(String produs, String marca, String model, String versiune, int pret) {
        this.produs = produs;
        this.marca = marca;
        this.model = model;
        this.versiune = versiune;
        this.pret = pret;

    }


    public String getProdus() {return produs;}

    public void setProdus(String produs) {
        this.produs = produs;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel (String model) {this.model = model;}

    public String getVersiune() {
        return versiune;
    }

    public void setVersiune (String versiune) {this.versiune = versiune;}

    public int getPret() {
        return pret;
    }

    public void setPret (int pret) {this.pret = pret;}

}



