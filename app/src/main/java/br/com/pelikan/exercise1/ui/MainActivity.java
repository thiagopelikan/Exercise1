package br.com.pelikan.exercise1.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import br.com.pelikan.exercise1.R;
import br.com.pelikan.exercise1.adapter.BurgerAdapter;
import br.com.pelikan.exercise1.model.Burger;
import br.com.pelikan.exercise1.utils.RawUtils;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = RawUtils.inputStreamToString(getResources().openRawResource(R.raw.ventburgers));

        TypeToken<ArrayList<Burger>> token = new TypeToken<ArrayList<Burger>>() {};
        List<Burger> burgerList = new Gson().fromJson(json, token.getType());

        recyclerView = findViewById(R.id.recyclerView);
        BurgerAdapter adapter = new BurgerAdapter(this, burgerList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
