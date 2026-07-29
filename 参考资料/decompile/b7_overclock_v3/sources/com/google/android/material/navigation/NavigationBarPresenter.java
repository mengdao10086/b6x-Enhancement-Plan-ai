package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import com.google.android.material.internal.ParcelableSparseArray;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f20507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f20508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20509c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20510d;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public ParcelableSparseArray f20512b;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            parcel.writeInt(this.f20511a);
            parcel.writeParcelable(this.f20512b, 0);
        }

        public SavedState(@n0 Parcel parcel) {
            this.f20511a = parcel.readInt();
            this.f20512b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void a(int i10) {
        this.f20510d = i10;
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(@p0 e eVar, boolean z10) {
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        if (this.f20509c) {
            return;
        }
        if (z10) {
            this.f20508b.c();
        } else {
            this.f20508b.s();
        }
    }

    public void d(@n0 c cVar) {
        this.f20508b = cVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(@p0 e eVar, @p0 h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(@p0 e eVar, @p0 h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.f20510d;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(@p0 j.a aVar) {
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(@n0 Context context, @n0 e eVar) {
        this.f20507a = eVar;
        this.f20508b.e(eVar);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(@n0 Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f20508b.r(savedState.f20511a);
            this.f20508b.p(com.google.android.material.badge.b.g(this.f20508b.getContext(), savedState.f20512b));
        }
    }

    public void k(boolean z10) {
        this.f20509c = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(@p0 m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    @p0
    public k m(@p0 ViewGroup viewGroup) {
        return this.f20508b;
    }

    @Override // androidx.appcompat.view.menu.j
    @n0
    public Parcelable n() {
        SavedState savedState = new SavedState();
        savedState.f20511a = this.f20508b.getSelectedItemId();
        savedState.f20512b = com.google.android.material.badge.b.h(this.f20508b.getBadgeDrawables());
        return savedState;
    }
}
