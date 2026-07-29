package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class UserBehavior implements Parcelable {

    @k
    public static final Parcelable.Creator<UserBehavior> CREATOR = new Creator();

    @SerializedName("action")
    @k
    private final String action;

    @SerializedName("app_info")
    @k
    private final String appInfo;

    @SerializedName("gamepad_address")
    @k
    private final String gamepadAddress;

    @SerializedName("gamepad_info")
    @k
    private final String gamepadInfo;

    @SerializedName("phone_address")
    @k
    private final String phoneAddress;

    @SerializedName("phone_info")
    @k
    private final String phoneInfo;

    @SerializedName("timestamp")
    private final long timestamp;

    public static final class Creator implements Parcelable.Creator<UserBehavior> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final UserBehavior createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new UserBehavior(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final UserBehavior[] newArray(int i10) {
            return new UserBehavior[i10];
        }
    }

    public UserBehavior(@k String appInfo, @k String phoneAddress, @k String phoneInfo, @k String gamepadAddress, @k String gamepadInfo, @k String action, long j10) {
        f0.p(appInfo, "appInfo");
        f0.p(phoneAddress, "phoneAddress");
        f0.p(phoneInfo, "phoneInfo");
        f0.p(gamepadAddress, "gamepadAddress");
        f0.p(gamepadInfo, "gamepadInfo");
        f0.p(action, "action");
        this.appInfo = appInfo;
        this.phoneAddress = phoneAddress;
        this.phoneInfo = phoneInfo;
        this.gamepadAddress = gamepadAddress;
        this.gamepadInfo = gamepadInfo;
        this.action = action;
        this.timestamp = j10;
    }

    @k
    public final String component1() {
        return this.appInfo;
    }

    @k
    public final String component2() {
        return this.phoneAddress;
    }

    @k
    public final String component3() {
        return this.phoneInfo;
    }

    @k
    public final String component4() {
        return this.gamepadAddress;
    }

    @k
    public final String component5() {
        return this.gamepadInfo;
    }

    @k
    public final String component6() {
        return this.action;
    }

    public final long component7() {
        return this.timestamp;
    }

    @k
    public final UserBehavior copy(@k String appInfo, @k String phoneAddress, @k String phoneInfo, @k String gamepadAddress, @k String gamepadInfo, @k String action, long j10) {
        f0.p(appInfo, "appInfo");
        f0.p(phoneAddress, "phoneAddress");
        f0.p(phoneInfo, "phoneInfo");
        f0.p(gamepadAddress, "gamepadAddress");
        f0.p(gamepadInfo, "gamepadInfo");
        f0.p(action, "action");
        return new UserBehavior(appInfo, phoneAddress, phoneInfo, gamepadAddress, gamepadInfo, action, j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserBehavior)) {
            return false;
        }
        UserBehavior userBehavior = (UserBehavior) obj;
        return f0.g(this.appInfo, userBehavior.appInfo) && f0.g(this.phoneAddress, userBehavior.phoneAddress) && f0.g(this.phoneInfo, userBehavior.phoneInfo) && f0.g(this.gamepadAddress, userBehavior.gamepadAddress) && f0.g(this.gamepadInfo, userBehavior.gamepadInfo) && f0.g(this.action, userBehavior.action) && this.timestamp == userBehavior.timestamp;
    }

    @k
    public final String getAction() {
        return this.action;
    }

    @k
    public final String getAppInfo() {
        return this.appInfo;
    }

    @k
    public final String getGamepadAddress() {
        return this.gamepadAddress;
    }

    @k
    public final String getGamepadInfo() {
        return this.gamepadInfo;
    }

    @k
    public final String getPhoneAddress() {
        return this.phoneAddress;
    }

    @k
    public final String getPhoneInfo() {
        return this.phoneInfo;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((this.appInfo.hashCode() * 31) + this.phoneAddress.hashCode()) * 31) + this.phoneInfo.hashCode()) * 31) + this.gamepadAddress.hashCode()) * 31) + this.gamepadInfo.hashCode()) * 31) + this.action.hashCode()) * 31) + a.a(this.timestamp);
    }

    @k
    public String toString() {
        return "UserBehavior(appInfo=" + this.appInfo + ", phoneAddress=" + this.phoneAddress + ", phoneInfo=" + this.phoneInfo + ", gamepadAddress=" + this.gamepadAddress + ", gamepadInfo=" + this.gamepadInfo + ", action=" + this.action + ", timestamp=" + this.timestamp + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(this.appInfo);
        out.writeString(this.phoneAddress);
        out.writeString(this.phoneInfo);
        out.writeString(this.gamepadAddress);
        out.writeString(this.gamepadInfo);
        out.writeString(this.action);
        out.writeLong(this.timestamp);
    }
}
