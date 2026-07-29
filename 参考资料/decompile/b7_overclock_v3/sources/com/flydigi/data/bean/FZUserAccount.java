package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.d1;

/* JADX INFO: loaded from: classes7.dex */
public class FZUserAccount implements Parcelable {
    public static final Parcelable.Creator<FZUserAccount> CREATOR = new Parcelable.Creator<FZUserAccount>() { // from class: com.flydigi.data.bean.FZUserAccount.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FZUserAccount createFromParcel(Parcel in2) {
            return new FZUserAccount(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FZUserAccount[] newArray(int size) {
            return new FZUserAccount[size];
        }
    };
    public String avatar;
    public String email;
    public String groupid;
    public String phone;
    public String regdate;
    public String sign;
    public String token;
    public String uid;
    public String username;

    public FZUserAccount(Parcel in2) {
        this.uid = in2.readString();
        this.username = in2.readString();
        this.sign = in2.readString();
        this.regdate = in2.readString();
        this.avatar = in2.readString();
        this.token = in2.readString();
        this.phone = in2.readString();
        this.email = in2.readString();
        this.groupid = in2.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        return (d1.g(this.uid) || d1.g(this.token)) ? false : true;
    }

    public String toString() {
        return "FZUserAccount{uid='" + this.uid + "', username='" + this.username + "', sign='" + this.sign + "', regdate='" + this.regdate + "', avatar='" + this.avatar + "', token='" + this.token + "', phone='" + this.phone + "', email='" + this.email + "', groupid='" + this.groupid + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.username);
        dest.writeString(this.sign);
        dest.writeString(this.regdate);
        dest.writeString(this.avatar);
        dest.writeString(this.token);
        dest.writeString(this.phone);
        dest.writeString(this.email);
        dest.writeString(this.groupid);
    }

    public FZUserAccount() {
    }
}
