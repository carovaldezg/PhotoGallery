package com.example.caro.photogaleryapp.common.mvp.view;

import android.support.annotation.NonNull;

public interface BaseView {

    interface State {}

    void render(@NonNull State state);

}
