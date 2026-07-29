package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class HotSearchKeyword implements Parcelable, Serializable {
    public static final Parcelable.Creator<HotSearchKeyword> CREATOR = new Parcelable.Creator<HotSearchKeyword>() { // from class: com.flydigi.data.bean.HotSearchKeyword.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HotSearchKeyword createFromParcel(Parcel source) {
            return new HotSearchKeyword(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HotSearchKeyword[] newArray(int size) {
            return new HotSearchKeyword[size];
        }
    };

    @SerializedName("list")
    private List<String> keywordList;

    public HotSearchKeyword() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.keywordList);
    }

    public HotSearchKeyword(Parcel in2) {
        this.keywordList = in2.createStringArrayList();
    }
}
