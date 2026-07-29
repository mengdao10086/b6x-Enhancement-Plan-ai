package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.flydigi.data.bean.StrategyBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StrategyBean createFromParcel(Parcel in2) {
            return new StrategyBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StrategyBean[] newArray(int size) {
            return new StrategyBean[size];
        }
    };

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f14341id;
    private String title;

    public StrategyBean(Parcel in2) {
        this.f14341id = in2.readInt();
        this.title = in2.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.f14341id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(int id2) {
        this.f14341id = id2;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f14341id);
        dest.writeString(this.title);
    }

    public StrategyBean() {
    }
}
