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
public final class ReasonBean implements Parcelable {

    @k
    public static final Parcelable.Creator<ReasonBean> CREATOR = new Creator();

    @SerializedName("reason")
    @l
    private final String reason;

    @SerializedName("reason_id")
    private final int reasonId;

    public static final class Creator implements Parcelable.Creator<ReasonBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ReasonBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new ReasonBean(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ReasonBean[] newArray(int i10) {
            return new ReasonBean[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReasonBean() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public ReasonBean(int i10, @l String str) {
        this.reasonId = i10;
        this.reason = str;
    }

    public static /* synthetic */ ReasonBean copy$default(ReasonBean reasonBean, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = reasonBean.reasonId;
        }
        if ((i11 & 2) != 0) {
            str = reasonBean.reason;
        }
        return reasonBean.copy(i10, str);
    }

    public final int component1() {
        return this.reasonId;
    }

    @l
    public final String component2() {
        return this.reason;
    }

    @k
    public final ReasonBean copy(int i10, @l String str) {
        return new ReasonBean(i10, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReasonBean)) {
            return false;
        }
        ReasonBean reasonBean = (ReasonBean) obj;
        return this.reasonId == reasonBean.reasonId && f0.g(this.reason, reasonBean.reason);
    }

    @l
    public final String getReason() {
        return this.reason;
    }

    public final int getReasonId() {
        return this.reasonId;
    }

    public int hashCode() {
        int i10 = this.reasonId * 31;
        String str = this.reason;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @k
    public String toString() {
        return "ReasonBean(reasonId=" + this.reasonId + ", reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.reasonId);
        out.writeString(this.reason);
    }

    public /* synthetic */ ReasonBean(int i10, String str, int i11, u uVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str);
    }
}
