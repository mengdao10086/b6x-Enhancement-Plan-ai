package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class AuthBean implements Parcelable {

    @k
    public static final Parcelable.Creator<AuthBean> CREATOR = new Creator();

    @SerializedName("allow")
    private final boolean allow;

    public static final class Creator implements Parcelable.Creator<AuthBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final AuthBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new AuthBean(parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final AuthBean[] newArray(int i10) {
            return new AuthBean[i10];
        }
    }

    public AuthBean(boolean z10) {
        this.allow = z10;
    }

    public static /* synthetic */ AuthBean copy$default(AuthBean authBean, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = authBean.allow;
        }
        return authBean.copy(z10);
    }

    public final boolean component1() {
        return this.allow;
    }

    @k
    public final AuthBean copy(boolean z10) {
        return new AuthBean(z10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AuthBean) && this.allow == ((AuthBean) obj).allow;
    }

    public final boolean getAllow() {
        return this.allow;
    }

    public int hashCode() {
        boolean z10 = this.allow;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @k
    public String toString() {
        return "AuthBean(allow=" + this.allow + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.allow ? 1 : 0);
    }
}
