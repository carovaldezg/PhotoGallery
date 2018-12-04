package com.example.caro.photogaleryapp.Home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.caro.photogaleryapp.R;
import com.example.caro.photogaleryapp.common.PhotoService;
import com.example.caro.photogaleryapp.common.RetrofitInstance;
import com.example.caro.photogaleryapp.common.mvp.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private final HomeView mViewInstance;

    public HomePresenter(HomeView mainActivity) {
        mViewInstance = mainActivity;
    }


    public void onGetImageGalleryFromServer() {
        PhotoService service = RetrofitInstance.getRetrofitInstance().create(PhotoService.class);
        Call<List<PhotoModel>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                mViewInstance.render(new HomeView.showImageGallery(response));
            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {
                mViewInstance.render(new HomeView.ShowErrorState());
            }
        });
    }

}
