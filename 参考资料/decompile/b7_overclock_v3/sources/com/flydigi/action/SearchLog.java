package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SearchLog extends LogAction {
    public static final Parcelable.Creator<SearchLog> CREATOR = new a();
    private String keyword;
    private String refer;
    private int step;

    public class a implements Parcelable.Creator<SearchLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SearchLog createFromParcel(Parcel source) {
            return new SearchLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchLog[] newArray(int size) {
            return new SearchLog[size];
        }
    }

    public SearchLog() {
    }

    public void B0(final String keyword) {
        this.keyword = keyword;
    }

    public void D0(String refer) {
        this.refer = refer;
    }

    public void E0(int step) {
        this.step = step;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.keyword);
        dest.writeInt(this.step);
        dest.writeString(this.refer);
    }

    public SearchLog(Parcel in2) {
        super(in2);
        this.keyword = in2.readString();
        this.step = in2.readInt();
        this.refer = in2.readString();
    }
}
