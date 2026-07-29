package com.flydigi.game.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.flydigi.data.bean.a;
import hk.e;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class DeviceSpaceBean implements Parcelable {

    @k
    public static final Parcelable.Creator<DeviceSpaceBean> CREATOR = new Creator();

    @e
    public final long total;

    @e
    public final long usable;

    public static final class Creator implements Parcelable.Creator<DeviceSpaceBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final DeviceSpaceBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new DeviceSpaceBean(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final DeviceSpaceBean[] newArray(int i10) {
            return new DeviceSpaceBean[i10];
        }
    }

    public DeviceSpaceBean() {
        this(0L, 0L, 3, null);
    }

    public DeviceSpaceBean(long j10, long j11) {
        this.total = j10;
        this.usable = j11;
    }

    public static /* synthetic */ DeviceSpaceBean copy$default(DeviceSpaceBean deviceSpaceBean, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = deviceSpaceBean.total;
        }
        if ((i10 & 2) != 0) {
            j11 = deviceSpaceBean.usable;
        }
        return deviceSpaceBean.copy(j10, j11);
    }

    public final long component1() {
        return this.total;
    }

    public final long component2() {
        return this.usable;
    }

    @k
    public final DeviceSpaceBean copy(long j10, long j11) {
        return new DeviceSpaceBean(j10, j11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceSpaceBean)) {
            return false;
        }
        DeviceSpaceBean deviceSpaceBean = (DeviceSpaceBean) obj;
        return this.total == deviceSpaceBean.total && this.usable == deviceSpaceBean.usable;
    }

    public int hashCode() {
        return (a.a(this.total) * 31) + a.a(this.usable);
    }

    @k
    public String toString() {
        return "DeviceSpaceBean(total=" + this.total + ", usable=" + this.usable + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeLong(this.total);
        out.writeLong(this.usable);
    }

    public /* synthetic */ DeviceSpaceBean(long j10, long j11, int i10, u uVar) {
        this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? 0L : j11);
    }
}
