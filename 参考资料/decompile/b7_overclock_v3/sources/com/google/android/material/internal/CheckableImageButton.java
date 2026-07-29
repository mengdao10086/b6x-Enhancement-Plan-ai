package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends androidx.appcompat.widget.n implements Checkable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f20307g = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20310f;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20311c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void b(@n0 Parcel parcel) {
            this.f20311c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f20311c ? 1 : 0);
        }

        public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel);
        }
    }

    public class a extends androidx.core.view.a {
        public a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, @n0 AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.Z0(CheckableImageButton.this.a());
            dVar.a1(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f20309e;
    }

    public boolean b() {
        return this.f20310f;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f20308d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (!this.f20308d) {
            return super.onCreateDrawableState(i10);
        }
        int[] iArr = f20307g;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i10 + iArr.length), iArr);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f20311c);
    }

    @Override // android.view.View
    @n0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20311c = this.f20308d;
        return savedState;
    }

    public void setCheckable(boolean z10) {
        if (this.f20309e != z10) {
            this.f20309e = z10;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (!this.f20309e || this.f20308d == z10) {
            return;
        }
        this.f20308d = z10;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z10) {
        this.f20310f = z10;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (this.f20310f) {
            super.setPressed(z10);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f20308d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20309e = true;
        this.f20310f = true;
        u0.B1(this, new a());
    }
}
