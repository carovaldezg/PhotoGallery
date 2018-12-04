package com.example.caro.photogaleryapp.common;

import com.example.caro.photogaleryapp.common.mvp.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoService {

    @GET("/photos")
    Call<List<PhotoModel>> getAllPhotos();

}
