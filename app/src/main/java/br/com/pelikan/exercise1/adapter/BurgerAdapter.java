package br.com.pelikan.exercise1.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.pelikan.exercise1.R;
import br.com.pelikan.exercise1.model.Burger;
import br.com.pelikan.exercise1.ui.DetailsActivity;

public class BurgerAdapter extends RecyclerView.Adapter<BurgerAdapter.BurgerViewHolder> {

    private final Context context;
    private final List<Burger> burgerList;

    public BurgerAdapter(Context context, List<Burger> burgerList) {
        this.context = context;
        this.burgerList = burgerList;
    }

    @NonNull
    @Override
    public BurgerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_burger_item, parent, false);
        return new BurgerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgerViewHolder holder, int position) {
        Burger current = burgerList.get(position);
        holder.bindView(current);
    }

    @Override
    public int getItemCount() {
        return burgerList.size();
    }

    class BurgerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        BurgerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        void bindView(Burger burger) {
            ((TextView)itemView.findViewById(R.id.nameTextView)).setText(burger.getName());
            Picasso.get().load(burger.getImage()).into((ImageView) itemView.findViewById(R.id.thumbImageView));
            if(itemView.getTag() == null) {
                itemView.setTag(burger);
            }
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra(DetailsActivity.TARGET_BURGER, ((Burger)view.getTag()));
            context.startActivity(intent);
        }
    }
}
