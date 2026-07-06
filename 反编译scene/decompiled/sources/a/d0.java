package a;

import a.k3;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class d0 {

    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5842a;

        public a(int i, int i2) {
            super(i, i2);
            this.f5842a = 0;
            this.f5842a = 8388627;
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f5842a = 0;
            this.f5842a = aVar.f5842a;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5842a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.ActionBarLayout);
            this.f5842a = typedArrayObtainStyledAttributes.getInt(c0.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5842a = 0;
        }
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    public void n() {
    }

    public abstract boolean o(int i, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(boolean z);

    public abstract void u(boolean z);

    public abstract void v(CharSequence charSequence);

    public k3 w(k3.a aVar) {
        return null;
    }
}
