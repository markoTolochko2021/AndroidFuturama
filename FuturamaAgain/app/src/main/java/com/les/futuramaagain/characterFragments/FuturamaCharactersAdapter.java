package com.les.futuramaagain.characterFragments;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.les.futuramaagain.R;

import java.util.ArrayList;

public class FuturamaCharactersAdapter extends RecyclerView.Adapter<FuturamaCharactersAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private final ArrayList<String> names;
    private final ArrayList<Integer> imagesIds;
    private Listener listener;

    interface Listener{
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public FuturamaCharactersAdapter(ArrayList<String> names, ArrayList<Integer> imagesIds) {
        this.names = names;
        this.imagesIds = imagesIds;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getImagesIds() {
        return imagesIds;
    }

    @NonNull
    @Override
    public FuturamaCharactersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_view_layout,
                        parent,
                        false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.image_character);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imagesIds.get(position));
        imageView.setImageDrawable(drawable);

        TextView textView = (TextView) cardView.findViewById(R.id.text_character);
        textView.setText(names.get(position));

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
