package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class AdvertiseBean implements Parcelable {
    public static final Parcelable.Creator<AdvertiseBean> CREATOR = new Parcelable.Creator<AdvertiseBean>() { // from class: com.flydigi.data.bean.AdvertiseBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseBean createFromParcel(Parcel source) {
            return new AdvertiseBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdvertiseBean[] newArray(int size) {
            return new AdvertiseBean[size];
        }
    };

    @SerializedName("id")
    private long advertiseId;

    @SerializedName("data")
    private String data;

    @SerializedName("has_logo")
    private int hasLogo;

    @SerializedName("local_path")
    private String localPath;

    @SerializedName("type")
    private int type;

    @SerializedName("url")
    private String url;

    public AdvertiseBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(final Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        AdvertiseBean advertiseBean = (AdvertiseBean) o10;
        return this.type == advertiseBean.type && this.hasLogo == advertiseBean.hasLogo && Objects.equals(this.url, advertiseBean.url) && Objects.equals(this.data, advertiseBean.data);
    }

    public long getAdvertiseId() {
        return this.advertiseId;
    }

    public String getData() {
        return this.data;
    }

    public int getHasLogo() {
        return this.hasLogo;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Objects.hash(this.url, Integer.valueOf(this.type), this.data, Integer.valueOf(this.hasLogo));
    }

    public boolean isValid() {
        return (d1.g(this.url) || d1.g(this.localPath) || !b0.h0(this.localPath)) ? false : true;
    }

    public void setAdvertiseId(final long advertiseId) {
        this.advertiseId = advertiseId;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public void setHasLogo(final int hasLogo) {
        this.hasLogo = hasLogo;
    }

    public void setLocalPath(final String localPath) {
        this.localPath = localPath;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String toString() {
        return "AdvertiseBean{advertiseId=" + this.advertiseId + ", url='" + this.url + "', type=" + this.type + ", data='" + this.data + "', hasLogo=" + this.hasLogo + ", localPath='" + this.localPath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.advertiseId);
        dest.writeString(this.url);
        dest.writeInt(this.type);
        dest.writeString(this.data);
        dest.writeInt(this.hasLogo);
        dest.writeString(this.localPath);
    }

    public AdvertiseBean(Parcel in2) {
        this.advertiseId = in2.readLong();
        this.url = in2.readString();
        this.type = in2.readInt();
        this.data = in2.readString();
        this.hasLogo = in2.readInt();
        this.localPath = in2.readString();
    }
}
