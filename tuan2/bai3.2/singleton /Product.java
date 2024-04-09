public class Product {
    int id, idCat;
    String tittle;
    float price;

    public Product() {
    }

    public Product(int id, int idCat, String tittle, float price) {
        this.id = id;
        this.idCat = idCat;
        this.tittle = tittle;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public float getPrice() {
        return price;
    }

    
}
