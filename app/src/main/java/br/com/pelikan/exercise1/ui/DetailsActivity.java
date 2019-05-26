package br.com.pelikan.exercise1.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import br.com.pelikan.exercise1.R;
import br.com.pelikan.exercise1.model.Burger;

public class DetailsActivity extends AppCompatActivity {

    public static final String TARGET_BURGER = "target_burger";

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        injectExtras();

        if(burger == null){
            finish();
        }

        Picasso.get().load(burger.getImage()).into(((ImageView)findViewById(R.id.burgerImageView)));
        ((TextView)findViewById(R.id.priceTextView)).setText(burger.getPrice());
    }

    private void injectExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(TARGET_BURGER)) {
                this.burger = extras.getParcelable(TARGET_BURGER);
            }
        }
    }
}