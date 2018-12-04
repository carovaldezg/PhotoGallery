package com.example.caro.photogaleryapp.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caro.photogaleryapp.R;
import com.example.caro.photogaleryapp.common.mvp.PhotoModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<PhotoModel> dataList;
    private Context context;

    public PhotoAdapter(Context context, List<PhotoModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.mPhotoTitle.setText(dataList.get(position).getTitle());

       Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView mPhotoTitle;
        ImageView mImage;

        PhotoViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mPhotoTitle = mView.findViewById(R.id.photo_item_title_text_view);
            mImage = mView.findViewById(R.id.photo_item_image_text_view);
        }

    }

}
