package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.l;
import androidx.customview.view.AbsSavedState;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final l<String, Bundle> f20766c;

    public class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        @p0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState createFromParcel(@n0 Parcel parcel) {
            return new ExtendableSavedState(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState[] newArray(int i10) {
            return new ExtendableSavedState[i10];
        }
    }

    public /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    @n0
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f20766c + zc.a.f58317e;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        int size = this.f20766c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = this.f20766c.k(i11);
            bundleArr[i11] = this.f20766c.o(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f20766c = new l<>();
    }

    public ExtendableSavedState(@n0 Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i10 = parcel.readInt();
        String[] strArr = new String[i10];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i10];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f20766c = new l<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f20766c.put(strArr[i11], bundleArr[i11]);
        }
    }
}
