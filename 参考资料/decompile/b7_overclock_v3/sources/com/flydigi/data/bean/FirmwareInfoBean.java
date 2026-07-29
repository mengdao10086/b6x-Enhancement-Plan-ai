package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public class FirmwareInfoBean implements Parcelable {
    public static final Parcelable.Creator<FirmwareInfoBean> CREATOR = new Parcelable.Creator<FirmwareInfoBean>() { // from class: com.flydigi.data.bean.FirmwareInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirmwareInfoBean createFromParcel(Parcel in2) {
            return new FirmwareInfoBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirmwareInfoBean[] newArray(int size) {
            return new FirmwareInfoBean[size];
        }
    };
    public String date;
    public String desc;
    public File file;

    @SerializedName("is_push")
    public int isPush;
    public String title;
    public String type;
    public String url;
    public String version;

    public FirmwareInfoBean(Parcel in2) {
        this.version = in2.readString();
        this.type = in2.readString();
        this.title = in2.readString();
        this.date = in2.readString();
        this.desc = in2.readString();
        this.url = in2.readString();
        this.isPush = in2.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FirmwareInfoBean{version='" + this.version + "', type='" + this.type + "', title='" + this.title + "', date='" + this.date + "', desc='" + this.desc + "', url='" + this.url + "', file=" + this.file + ", isPush=" + this.isPush + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.version);
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.desc);
        dest.writeString(this.url);
        dest.writeInt(this.isPush);
    }
}
