package com.example.caro.photogaleryapp.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caro.photogaleryapp.R;
import com.example.caro.photogaleryapp.common.PhotoService;
import com.example.caro.photogaleryapp.common.RetrofitInstance;
import com.example.caro.photogaleryapp.common.mvp.PhotoModel;
import com.example.caro.photogaleryapp.common.mvp.view.BaseView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeTabFragment extends Fragment implements HomeView {

    @BindView(R.id.fragment_home_recicler_view)
    RecyclerView recyclerView;
    private PhotoAdapter adapter;
    @BindView(R.id.texto)
    TextView mTextTest;
    HomePresenter mHomePresenter;

    public HomeTabFragment() {
        mHomePresenter = new HomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,rootView);
        mHomePresenter.onGetImageGalleryFromServer();
        return rootView;
    }

    private void generateDataList(List<PhotoModel> photoList) {
        adapter = new PhotoAdapter(getContext(),photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void render(@NonNull State state) {
        if (state instanceof showImageGallery) {
            renderShowImageGallery((showImageGallery) state);
        } else if (state instanceof ShowErrorState) {
            renderShowErrorState((ShowErrorState) state);
        }
    }

    private void renderShowErrorState(ShowErrorState state) {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error),
                Toast.LENGTH_SHORT).show();
    }

    private void renderShowImageGallery(showImageGallery state) {
        adapter = new PhotoAdapter(getContext(), state.imageGallery);
        generateDataList(state.imageGallery);
    }

}
