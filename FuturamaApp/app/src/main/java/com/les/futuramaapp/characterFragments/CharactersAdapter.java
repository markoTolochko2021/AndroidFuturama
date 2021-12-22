package com.les.futuramaapp.characterFragments;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.les.futuramaapp.R;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    private String[] names;
    private int[] imageIds;
    private Listener listener;

    interface Listener{
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public CharactersAdapter(String[] names, int[] imageIds) {
        this.names = names;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    @Override
    public CharactersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv =
                (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_layout,
                                parent,
                                false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.image_character);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);

        TextView textView = (TextView) cardView.findViewById(R.id.text_character);
        textView.setText(names[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onClick(position);
                }
            }
        });


    }
}
