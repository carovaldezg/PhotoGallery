package com.example.caro.photogaleryapp.Home;

import com.example.caro.photogaleryapp.common.mvp.PhotoModel;
import com.example.caro.photogaleryapp.common.mvp.view.BaseView;

import java.util.List;

import retrofit2.Response;

public interface HomeView extends BaseView {

     class showImageGallery implements State {

        List<PhotoModel> imageGallery;

        public showImageGallery(Response<List<PhotoModel>> imageGallery) {
            this.imageGallery = imageGallery.body();
        }

    }

     class ShowErrorState implements State {

        public ShowErrorState() {}

    }

}
