package unipiloto.edu.co;

public class Drink {
    //Atributos
    private String name;
    private String description;
    private int imageResourceId;

    // declarar un arrreglo de las bebidas
    public static final Drink[] bebidas = {
            new Drink("Latte", "Una taza de cafe expreso con leche al vapor",R.drawable.latte) ,
            new Drink("Cappuccino", "Espresso, leche caliente y una espuma de leche al vapor",R.drawable.cappuccino) ,
            new Drink("Filter", "Cafe elaborado con granos de la más alta calidad tostados y elaborados en fresco",R.drawable.filter)
    };

//COnstructor con los atributos

    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }


//Metodos get y set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return
                name;
    }
}
