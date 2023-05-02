package com.acme.propdub;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter1 extends RecyclerView.Adapter<ImageAdapter1.ViewHolder> {
    private final int[] imageIds;
    private final LayoutInflater inflater;
    private final int screenWidth;

    public ImageAdapter1(Context context, int[] imageIds) {
        this.imageIds = imageIds;
        this.inflater = LayoutInflater.from(context);

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= null;
        try {
            view = inflater.inflate(R.layout.image_item1, parent, false);
        } catch (Exception e) {
            Log.d("tag6", e.toString());
        }
            return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       try {
           int imageId = imageIds[position];
           Bitmap originalBitmap = BitmapFactory.decodeResource(inflater.getContext().getResources(), imageId);

           float aspectRatio = (float) originalBitmap.getWidth() / (float) originalBitmap.getHeight();
           int newHeight = (int) (screenWidth / aspectRatio);

           Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, screenWidth, newHeight, true);
           holder.imageView.setImageBitmap(scaledBitmap);

           // Set ImageView layout parameters
           /* ViewGroup.LayoutParams layoutParams = holder.imageView.getLayoutParams();
           layoutParams.width = screenWidth;
           layoutParams.height = newHeight;
           holder.imageView.setLayoutParams(layoutParams);
       */
       }

       catch(Exception e){
           Log.d("tag6",e.toString());
       }
    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView12);
        }
    }
}
