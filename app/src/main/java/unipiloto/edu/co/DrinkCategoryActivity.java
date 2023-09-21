package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ArrayAdapter<Drink> adapatadorLista = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.bebidas);
        ListView listaBebidas = (ListView) findViewById(R.id.list_drinks);
        listaBebidas.setAdapter(adapatadorLista);
    }
}