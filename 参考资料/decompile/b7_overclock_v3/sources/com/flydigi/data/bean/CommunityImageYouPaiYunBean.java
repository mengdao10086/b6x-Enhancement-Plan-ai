package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class CommunityImageYouPaiYunBean {
    private int code;
    private int file_size;

    @SerializedName("image-frames")
    private int imageframes;

    @SerializedName("image-height")
    private int imageheight;

    @SerializedName("image-type")
    private String imagetype;

    @SerializedName("image-width")
    private int imagewidth;
    private String message;
    private String mimetype;
    private int time;
    private String url;

    public int getCode() {
        return this.code;
    }

    public int getFile_size() {
        return this.file_size;
    }

    public int getImageframes() {
        return this.imageframes;
    }

    public int getImageheight() {
        return this.imageheight;
    }

    public String getImagetype() {
        return this.imagetype;
    }

    public int getImagewidth() {
        return this.imagewidth;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public int getTime() {
        return this.time;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public void setImageframes(int imageframes) {
        this.imageframes = imageframes;
    }

    public void setImageheight(int imageheight) {
        this.imageheight = imageheight;
    }

    public void setImagetype(String imagetype) {
        this.imagetype = imagetype;
    }

    public void setImagewidth(int imagewidth) {
        this.imagewidth = imagewidth;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
