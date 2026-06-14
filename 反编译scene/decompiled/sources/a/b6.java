package a;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b6 extends PopupWindow {
    public static final boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5677a;

    static {
        b = Build.VERSION.SDK_INT < 21;
    }

    public b6(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    public final void a(Context context, AttributeSet attributeSet, int i, int i2) {
        o8 o8VarV = o8.v(context, attributeSet, c0.PopupWindow, i, i2);
        if (o8VarV.s(c0.PopupWindow_overlapAnchor)) {
            b(o8VarV.a(c0.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(o8VarV.g(c0.PopupWindow_android_popupBackground));
        o8VarV.w();
    }

    public final void b(boolean z) {
        if (b) {
            this.f5677a = z;
        } else {
            mj.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (b && this.f5677a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (b && this.f5677a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (b && this.f5677a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}
