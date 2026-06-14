package a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class d10 extends ak {
    public static final Parcelable.Creator<d10> CREATOR = new c10();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia<String, Bundle> f5847a;

    public d10(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f5847a = new ia<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f5847a.put(strArr[i2], bundleArr[i2]);
        }
    }

    public /* synthetic */ d10(Parcel parcel, ClassLoader classLoader, c10 c10Var) {
        this(parcel, classLoader);
    }

    public d10(Parcelable parcelable) {
        super(parcelable);
        this.f5847a = new ia<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f5847a + "}";
    }

    @Override // a.ak, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f5847a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f5847a.i(i2);
            bundleArr[i2] = this.f5847a.m(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
