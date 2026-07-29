package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
public final class FloatWindowSizeBean implements Parcelable {

    @k
    public static final Parcelable.Creator<FloatWindowSizeBean> CREATOR = new Creator();
    private int floatWindowHeight;

    @k
    private int[] floatWindowStartPosition;
    private int floatWindowWidth;

    public static final class Creator implements Parcelable.Creator<FloatWindowSizeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final FloatWindowSizeBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new FloatWindowSizeBean(parcel.readInt(), parcel.readInt(), parcel.createIntArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final FloatWindowSizeBean[] newArray(int i10) {
            return new FloatWindowSizeBean[i10];
        }
    }

    public FloatWindowSizeBean(int i10, int i11, @k int[] floatWindowStartPosition) {
        f0.p(floatWindowStartPosition, "floatWindowStartPosition");
        this.floatWindowWidth = i10;
        this.floatWindowHeight = i11;
        this.floatWindowStartPosition = floatWindowStartPosition;
    }

    public static /* synthetic */ FloatWindowSizeBean copy$default(FloatWindowSizeBean floatWindowSizeBean, int i10, int i11, int[] iArr, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = floatWindowSizeBean.floatWindowWidth;
        }
        if ((i12 & 2) != 0) {
            i11 = floatWindowSizeBean.floatWindowHeight;
        }
        if ((i12 & 4) != 0) {
            iArr = floatWindowSizeBean.floatWindowStartPosition;
        }
        return floatWindowSizeBean.copy(i10, i11, iArr);
    }

    public final int component1() {
        return this.floatWindowWidth;
    }

    public final int component2() {
        return this.floatWindowHeight;
    }

    @k
    public final int[] component3() {
        return this.floatWindowStartPosition;
    }

    @k
    public final FloatWindowSizeBean copy(int i10, int i11, @k int[] floatWindowStartPosition) {
        f0.p(floatWindowStartPosition, "floatWindowStartPosition");
        return new FloatWindowSizeBean(i10, i11, floatWindowStartPosition);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatWindowSizeBean)) {
            return false;
        }
        FloatWindowSizeBean floatWindowSizeBean = (FloatWindowSizeBean) obj;
        return this.floatWindowWidth == floatWindowSizeBean.floatWindowWidth && this.floatWindowHeight == floatWindowSizeBean.floatWindowHeight && f0.g(this.floatWindowStartPosition, floatWindowSizeBean.floatWindowStartPosition);
    }

    public final int getFloatWindowHeight() {
        return this.floatWindowHeight;
    }

    @k
    public final int[] getFloatWindowStartPosition() {
        return this.floatWindowStartPosition;
    }

    public final int getFloatWindowWidth() {
        return this.floatWindowWidth;
    }

    public int hashCode() {
        return (((this.floatWindowWidth * 31) + this.floatWindowHeight) * 31) + Arrays.hashCode(this.floatWindowStartPosition);
    }

    public final void setFloatWindowHeight(int i10) {
        this.floatWindowHeight = i10;
    }

    public final void setFloatWindowStartPosition(@k int[] iArr) {
        f0.p(iArr, "<set-?>");
        this.floatWindowStartPosition = iArr;
    }

    public final void setFloatWindowWidth(int i10) {
        this.floatWindowWidth = i10;
    }

    @k
    public String toString() {
        return "FloatWindowSizeBean(floatWindowWidth=" + this.floatWindowWidth + ", floatWindowHeight=" + this.floatWindowHeight + ", floatWindowStartPosition=" + Arrays.toString(this.floatWindowStartPosition) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.floatWindowWidth);
        out.writeInt(this.floatWindowHeight);
        out.writeIntArray(this.floatWindowStartPosition);
    }
}
