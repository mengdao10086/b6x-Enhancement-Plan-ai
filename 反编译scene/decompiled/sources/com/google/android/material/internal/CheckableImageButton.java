package com.google.android.material.internal;

import a.ak;
import a.eh;
import a.ni;
import a.ox;
import a.rf;
import a.t;
import a.y5;
import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CheckableImageButton extends y5 implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8312a = {R.attr.state_checked};
    public boolean b;
    public boolean c;
    public boolean d;

    public class a extends rf {
        public a() {
        }

        @Override // a.rf
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            super.g(view, niVar);
            niVar.Y(CheckableImageButton.this.a());
            niVar.Z(CheckableImageButton.this.isChecked());
        }
    }

    public static class b extends ak {
        public static final Parcelable.Creator<b> CREATOR = new ox();
        public boolean b;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            r(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        public final void r(Parcel parcel) {
            this.b = parcel.readInt() == 1;
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        this.d = true;
        eh.k0(this, new a());
    }

    public boolean a() {
        return this.c;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.b ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + f8312a.length), f8312a) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.q());
        setChecked(bVar.b);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.b = this.b;
        return bVar;
    }

    public void setCheckable(boolean z) {
        if (this.c != z) {
            this.c = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.c || this.b == z) {
            return;
        }
        this.b = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.d = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.d) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.b);
    }
}
