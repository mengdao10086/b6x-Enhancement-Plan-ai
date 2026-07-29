package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class UnreadMessageBean implements Parcelable {
    public static final Parcelable.Creator<UnreadMessageBean> CREATOR = new Parcelable.Creator<UnreadMessageBean>() { // from class: com.flydigi.data.bean.UnreadMessageBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnreadMessageBean createFromParcel(Parcel source) {
            return new UnreadMessageBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnreadMessageBean[] newArray(int size) {
            return new UnreadMessageBean[size];
        }
    };

    @SerializedName("comment_num")
    private int commentNum;

    @SerializedName("article_num")
    private int likeNum;
    private int total;

    public UnreadMessageBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public int getLikeNum() {
        return this.likeNum;
    }

    public int getTotal() {
        return this.total;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String toString() {
        return "UnreadMessageBean{total=" + this.total + ", commentNum=" + this.commentNum + ", likeNum=" + this.likeNum + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeInt(this.commentNum);
        dest.writeInt(this.likeNum);
    }

    public UnreadMessageBean(Parcel in2) {
        this.total = in2.readInt();
        this.commentNum = in2.readInt();
        this.likeNum = in2.readInt();
    }
}
