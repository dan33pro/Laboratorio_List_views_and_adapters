package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };
        ListView list = findViewById(R.id.list_options);
        list.setOnItemClickListener(itemListener);
    }
}