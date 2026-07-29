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
public final class CFGVibrateList implements Parcelable {

    @k
    public static final Parcelable.Creator<CFGVibrateList> CREATOR = new Creator();

    @k
    private final ArrayList<CFGVibrateBean> configs;

    public static final class Creator implements Parcelable.Creator<CFGVibrateList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CFGVibrateList createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList.add(CFGVibrateBean.CREATOR.createFromParcel(parcel));
            }
            return new CFGVibrateList(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CFGVibrateList[] newArray(int i10) {
            return new CFGVibrateList[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CFGVibrateList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CFGVibrateList(@k ArrayList<CFGVibrateBean> configs) {
        f0.p(configs, "configs");
        this.configs = configs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CFGVibrateList copy$default(CFGVibrateList cFGVibrateList, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = cFGVibrateList.configs;
        }
        return cFGVibrateList.copy(arrayList);
    }

    @k
    public final ArrayList<CFGVibrateBean> component1() {
        return this.configs;
    }

    @k
    public final CFGVibrateList copy(@k ArrayList<CFGVibrateBean> configs) {
        f0.p(configs, "configs");
        return new CFGVibrateList(configs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CFGVibrateList) && f0.g(this.configs, ((CFGVibrateList) obj).configs);
    }

    @k
    public final ArrayList<CFGVibrateBean> getConfigs() {
        return this.configs;
    }

    public int hashCode() {
        return this.configs.hashCode();
    }

    @k
    public String toString() {
        return "CFGVibrateList(configs=" + this.configs + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        ArrayList<CFGVibrateBean> arrayList = this.configs;
        out.writeInt(arrayList.size());
        Iterator<CFGVibrateBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
    }

    public /* synthetic */ CFGVibrateList(ArrayList arrayList, int i10, u uVar) {
        this((i10 & 1) != 0 ? new ArrayList(1) : arrayList);
    }
}
