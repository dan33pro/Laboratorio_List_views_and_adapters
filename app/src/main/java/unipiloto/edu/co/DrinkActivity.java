package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkId = (int) getIntent().getExtras().get(EXTRA_DRINKID);
        Drink bebida = Drink.bebidas[drinkId];

        TextView name = findViewById(R.id.name);
        name.setText(bebida.getName());

        TextView description = findViewById(R.id.description);
        description.setText(bebida.getDescription());

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(bebida.getImageResourceId());
        photo.setContentDescription(bebida.getName());
    }
}