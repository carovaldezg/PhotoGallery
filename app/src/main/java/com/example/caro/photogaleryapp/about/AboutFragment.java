package com.example.caro.photogaleryapp.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.caro.photogaleryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AboutFragment extends Fragment {

    @BindView(R.id.fragment_about_github_image_button)
    ImageView mGithubLogo;
    @BindView(R.id.fragment_about_linkedin_image_button)
    ImageView mLinkedinLogo;
    @BindView(R.id.fragment_about_medium_image_button)
    ImageView mMediumLogo;
    @BindView(R.id.fragment_about_playstore_image_button)
    ImageView mPlaystoreLogo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.fragment_about_github_image_button)
    public void openGithub() {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);

            i.setData(Uri.parse(getString(R.string.github_url)));
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(getContext(), getString(R.string.error_no_browser_found), Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.fragment_about_linkedin_image_button)
    public void openLinkedin() {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);

            i.setData(Uri.parse(getString(R.string.linkedin_url)));
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(getContext(), getString(R.string.error_no_browser_found), Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.fragment_about_medium_image_button)
    public void openMedium() {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);

            i.setData(Uri.parse(getString(R.string.medium_url)));
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(getContext(), getString(R.string.error_no_browser_found), Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.fragment_about_playstore_image_button)
    public void openPlaystore() {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);

            i.setData(Uri.parse(getString(R.string.playstore_url)));
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(getContext(), getString(R.string.error_no_browser_found), Toast.LENGTH_LONG).show();
        }
    }


}
