package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
public final class CFGVibrateBean implements Parcelable {

    @k
    public static final Parcelable.Creator<CFGVibrateBean> CREATOR = new Creator();
    private int configId;

    @k
    private String configName;
    private boolean enable;

    @k
    private final ArrayList<CFGVibrateItem> keys;

    public static final class Creator implements Parcelable.Creator<CFGVibrateBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CFGVibrateBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            String string = parcel.readString();
            boolean z10 = parcel.readInt() != 0;
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 != i11; i12++) {
                arrayList.add(CFGVibrateItem.CREATOR.createFromParcel(parcel));
            }
            return new CFGVibrateBean(i10, string, z10, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CFGVibrateBean[] newArray(int i10) {
            return new CFGVibrateBean[i10];
        }
    }

    public CFGVibrateBean(int i10, @k String configName, boolean z10, @k ArrayList<CFGVibrateItem> keys) {
        f0.p(configName, "configName");
        f0.p(keys, "keys");
        this.configId = i10;
        this.configName = configName;
        this.enable = z10;
        this.keys = keys;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CFGVibrateBean copy$default(CFGVibrateBean cFGVibrateBean, int i10, String str, boolean z10, ArrayList arrayList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = cFGVibrateBean.configId;
        }
        if ((i11 & 2) != 0) {
            str = cFGVibrateBean.configName;
        }
        if ((i11 & 4) != 0) {
            z10 = cFGVibrateBean.enable;
        }
        if ((i11 & 8) != 0) {
            arrayList = cFGVibrateBean.keys;
        }
        return cFGVibrateBean.copy(i10, str, z10, arrayList);
    }

    public final int component1() {
        return this.configId;
    }

    @k
    public final String component2() {
        return this.configName;
    }

    public final boolean component3() {
        return this.enable;
    }

    @k
    public final ArrayList<CFGVibrateItem> component4() {
        return this.keys;
    }

    @k
    public final CFGVibrateBean copy(int i10, @k String configName, boolean z10, @k ArrayList<CFGVibrateItem> keys) {
        f0.p(configName, "configName");
        f0.p(keys, "keys");
        return new CFGVibrateBean(i10, configName, z10, keys);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CFGVibrateBean)) {
            return false;
        }
        CFGVibrateBean cFGVibrateBean = (CFGVibrateBean) obj;
        return this.configId == cFGVibrateBean.configId && f0.g(this.configName, cFGVibrateBean.configName) && this.enable == cFGVibrateBean.enable && f0.g(this.keys, cFGVibrateBean.keys);
    }

    public final int getConfigId() {
        return this.configId;
    }

    @k
    public final String getConfigName() {
        return this.configName;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    @k
    public final ArrayList<CFGVibrateItem> getKeys() {
        return this.keys;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.configId * 31) + this.configName.hashCode()) * 31;
        boolean z10 = this.enable;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return ((iHashCode + r12) * 31) + this.keys.hashCode();
    }

    public final void setConfigId(int i10) {
        this.configId = i10;
    }

    public final void setConfigName(@k String str) {
        f0.p(str, "<set-?>");
        this.configName = str;
    }

    public final void setEnable(boolean z10) {
        this.enable = z10;
    }

    @k
    public String toString() {
        return "CFGVibrateBean(configId=" + this.configId + ", configName=" + this.configName + ", enable=" + this.enable + ", keys=" + this.keys + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.configId);
        out.writeString(this.configName);
        out.writeInt(this.enable ? 1 : 0);
        ArrayList<CFGVibrateItem> arrayList = this.keys;
        out.writeInt(arrayList.size());
        Iterator<CFGVibrateItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
    }

    public /* synthetic */ CFGVibrateBean(int i10, String str, boolean z10, ArrayList arrayList, int i11, u uVar) {
        this((i11 & 1) != 0 ? 0 : i10, str, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? new ArrayList(3) : arrayList);
    }
}
