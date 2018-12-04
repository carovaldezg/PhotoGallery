package com.example.caro.photogaleryapp.common.mvp;

import com.google.gson.annotations.SerializedName;

public class PhotoModel {

    @SerializedName("albumId")
    private Integer mAlbumId;
    @SerializedName("id")
    private Integer mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl;

    public PhotoModel(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this.mAlbumId = albumId;
        this.mId = id;
        this.mTitle = title;
        this.mUrl = url;
        this.mThumbnailUrl = thumbnailUrl;
    }

    public Integer getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(Integer albumId) {
        this.mAlbumId = albumId;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.mThumbnailUrl = thumbnailUrl;
    }

}
