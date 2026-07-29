package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
public final class CFGVibrateItem implements Parcelable {

    @k
    public static final Parcelable.Creator<CFGVibrateItem> CREATOR = new Creator();
    private int keyId;

    @l
    private Integer period;

    @l
    private Integer position;

    @l
    private Integer strong;

    @l
    private Integer triggerType;

    public static final class Creator implements Parcelable.Creator<CFGVibrateItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CFGVibrateItem createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new CFGVibrateItem(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CFGVibrateItem[] newArray(int i10) {
            return new CFGVibrateItem[i10];
        }
    }

    public CFGVibrateItem() {
        this(0, null, null, null, null, 31, null);
    }

    public CFGVibrateItem(int i10, @l Integer num, @l Integer num2, @l Integer num3, @l Integer num4) {
        this.keyId = i10;
        this.triggerType = num;
        this.strong = num2;
        this.period = num3;
        this.position = num4;
    }

    public static /* synthetic */ CFGVibrateItem copy$default(CFGVibrateItem cFGVibrateItem, int i10, Integer num, Integer num2, Integer num3, Integer num4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = cFGVibrateItem.keyId;
        }
        if ((i11 & 2) != 0) {
            num = cFGVibrateItem.triggerType;
        }
        Integer num5 = num;
        if ((i11 & 4) != 0) {
            num2 = cFGVibrateItem.strong;
        }
        Integer num6 = num2;
        if ((i11 & 8) != 0) {
            num3 = cFGVibrateItem.period;
        }
        Integer num7 = num3;
        if ((i11 & 16) != 0) {
            num4 = cFGVibrateItem.position;
        }
        return cFGVibrateItem.copy(i10, num5, num6, num7, num4);
    }

    public final int component1() {
        return this.keyId;
    }

    @l
    public final Integer component2() {
        return this.triggerType;
    }

    @l
    public final Integer component3() {
        return this.strong;
    }

    @l
    public final Integer component4() {
        return this.period;
    }

    @l
    public final Integer component5() {
        return this.position;
    }

    @k
    public final CFGVibrateItem copy(int i10, @l Integer num, @l Integer num2, @l Integer num3, @l Integer num4) {
        return new CFGVibrateItem(i10, num, num2, num3, num4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CFGVibrateItem)) {
            return false;
        }
        CFGVibrateItem cFGVibrateItem = (CFGVibrateItem) obj;
        return this.keyId == cFGVibrateItem.keyId && f0.g(this.triggerType, cFGVibrateItem.triggerType) && f0.g(this.strong, cFGVibrateItem.strong) && f0.g(this.period, cFGVibrateItem.period) && f0.g(this.position, cFGVibrateItem.position);
    }

    public final int getKeyId() {
        return this.keyId;
    }

    @l
    public final Integer getPeriod() {
        return this.period;
    }

    @l
    public final Integer getPosition() {
        return this.position;
    }

    @l
    public final Integer getStrong() {
        return this.strong;
    }

    @l
    public final Integer getTriggerType() {
        return this.triggerType;
    }

    public int hashCode() {
        int i10 = this.keyId * 31;
        Integer num = this.triggerType;
        int iHashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.strong;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.period;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.position;
        return iHashCode3 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setKeyId(int i10) {
        this.keyId = i10;
    }

    public final void setPeriod(@l Integer num) {
        this.period = num;
    }

    public final void setPosition(@l Integer num) {
        this.position = num;
    }

    public final void setStrong(@l Integer num) {
        this.strong = num;
    }

    public final void setTriggerType(@l Integer num) {
        this.triggerType = num;
    }

    @k
    public String toString() {
        return "CFGVibrateItem(keyId=" + this.keyId + ", triggerType=" + this.triggerType + ", strong=" + this.strong + ", period=" + this.period + ", position=" + this.position + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.keyId);
        Integer num = this.triggerType;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.strong;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.period;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.position;
        if (num4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num4.intValue());
        }
    }

    public /* synthetic */ CFGVibrateItem(int i10, Integer num, Integer num2, Integer num3, Integer num4, int i11, u uVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? 0 : num, (i11 & 4) != 0 ? 0 : num2, (i11 & 8) != 0 ? 0 : num3, (i11 & 16) != 0 ? 0 : num4);
    }
}
