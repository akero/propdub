package com.acme.propdub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Integer> images;
    private List<String> titles;
    private List<String> subtitles;

    public MyAdapter(List<Integer> images, List<String> titles, List<String> subtitles) {
        this.images = images;
        this.titles = titles;
        this.subtitles = subtitles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_discrete, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int actualPosition = position % images.size();
        holder.image.setImageResource(images.get(actualPosition));
        holder.title.setText(titles.get(actualPosition));
        holder.subtitle.setText(subtitles.get(actualPosition));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        TextView title;
        TextView subtitle;

        ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }

        void bind(@DrawableRes int resId) {
            image.setImageResource(resId);
        }
    }
}
