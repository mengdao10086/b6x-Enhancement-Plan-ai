package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class BannerBean implements Parcelable {
    public static final Parcelable.Creator<BannerBean> CREATOR = new Parcelable.Creator<BannerBean>() { // from class: com.flydigi.data.bean.BannerBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BannerBean createFromParcel(Parcel source) {
            return new BannerBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BannerBean[] newArray(int size) {
            return new BannerBean[size];
        }
    };

    @SerializedName("data")
    private String data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private int f14323id;

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    public BannerBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getData() {
        return this.data;
    }

    public int getId() {
        return this.f14323id;
    }

    public String getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(int id2) {
        this.f14323id = id2;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "BannerBean{id=" + this.f14323id + ", title='" + this.title + "', image='" + this.image + "', type='" + this.type + "', data='" + this.data + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f14323id);
        dest.writeString(this.title);
        dest.writeString(this.image);
        dest.writeString(this.type);
        dest.writeString(this.data);
    }

    public BannerBean(Parcel in2) {
        this.f14323id = in2.readInt();
        this.title = in2.readString();
        this.image = in2.readString();
        this.type = in2.readString();
        this.data = in2.readString();
    }
}
