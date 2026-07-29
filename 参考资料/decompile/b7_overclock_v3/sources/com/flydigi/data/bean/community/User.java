package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class User implements Parcelable {

    @k
    public static final Parcelable.Creator<User> CREATOR = new Creator();

    @SerializedName("avatar")
    @l
    private final String avatar;

    @SerializedName("to_username")
    @l
    private final String toUserName;

    @SerializedName("username")
    @l
    private final String username;

    public static final class Creator implements Parcelable.Creator<User> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final User createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new User(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final User[] newArray(int i10) {
            return new User[i10];
        }
    }

    public User() {
        this(null, null, null, 7, null);
    }

    public User(@l String str, @l String str2, @l String str3) {
        this.avatar = str;
        this.username = str2;
        this.toUserName = str3;
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = user.avatar;
        }
        if ((i10 & 2) != 0) {
            str2 = user.username;
        }
        if ((i10 & 4) != 0) {
            str3 = user.toUserName;
        }
        return user.copy(str, str2, str3);
    }

    @l
    public final String component1() {
        return this.avatar;
    }

    @l
    public final String component2() {
        return this.username;
    }

    @l
    public final String component3() {
        return this.toUserName;
    }

    @k
    public final User copy(@l String str, @l String str2, @l String str3) {
        return new User(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return f0.g(this.avatar, user.avatar) && f0.g(this.username, user.username) && f0.g(this.toUserName, user.toUserName);
    }

    @l
    public final String getAvatar() {
        return this.avatar;
    }

    @l
    public final String getToUserName() {
        return this.toUserName;
    }

    @l
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.username;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.toUserName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @k
    public String toString() {
        return "User(avatar=" + this.avatar + ", username=" + this.username + ", toUserName=" + this.toUserName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(this.avatar);
        out.writeString(this.username);
        out.writeString(this.toUserName);
    }

    public /* synthetic */ User(String str, String str2, String str3, int i10, u uVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
