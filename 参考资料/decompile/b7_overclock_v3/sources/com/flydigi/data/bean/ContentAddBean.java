package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes7.dex */
public class ContentAddBean implements Parcelable {
    public static final Parcelable.Creator<ContentAddBean> CREATOR = new Parcelable.Creator<ContentAddBean>() { // from class: com.flydigi.data.bean.ContentAddBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentAddBean createFromParcel(Parcel source) {
            return new ContentAddBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentAddBean[] newArray(int size) {
            return new ContentAddBean[size];
        }
    };
    public int height;

    @Expose(deserialize = false, serialize = false)
    public String path;
    public String url;

    @Expose(deserialize = false, serialize = false)
    public boolean video;
    public String videoCover;
    public int width;

    public ContentAddBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVideoCover() {
        return this.videoCover;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isVideo() {
        return this.video;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public void setVideoCover(String videoCover) {
        this.videoCover = videoCover;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String toString() {
        return "ContentAddBean{video=" + this.video + ", path='" + this.path + "', videoCover='" + this.videoCover + "', url='" + this.url + "', width=" + this.width + ", height=" + this.height + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.video ? (byte) 1 : (byte) 0);
        parcel.writeString(this.path);
        parcel.writeString(this.videoCover);
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public ContentAddBean(Parcel in2) {
        this.video = in2.readByte() != 0;
        this.path = in2.readString();
        this.videoCover = in2.readString();
        this.url = in2.readString();
        this.width = in2.readInt();
        this.height = in2.readInt();
    }
}
