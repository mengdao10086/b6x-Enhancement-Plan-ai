package a;

import android.content.Context;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w7 extends t7 implements u7 {
    public static Method d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u7 f7762a;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                d = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public w7(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            ((t7) this).f2987a.setEnterTransition((Transition) obj);
        }
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            ((t7) this).f2987a.setExitTransition((Transition) obj);
        }
    }

    public void T(u7 u7Var) {
        this.f7762a = u7Var;
    }

    public void U(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            ((t7) this).f2987a.setTouchModal(z);
            return;
        }
        Method method = d;
        if (method != null) {
            try {
                method.invoke(((t7) this).f2987a, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // a.u7
    public void h(i4 i4Var, MenuItem menuItem) {
        u7 u7Var = this.f7762a;
        if (u7Var != null) {
            u7Var.h(i4Var, menuItem);
        }
    }

    @Override // a.u7
    public void m(i4 i4Var, MenuItem menuItem) {
        u7 u7Var = this.f7762a;
        if (u7Var != null) {
            u7Var.m(i4Var, menuItem);
        }
    }

    @Override // a.t7
    public h7 s(Context context, boolean z) {
        v7 v7Var = new v7(context, z);
        v7Var.setHoverListener(this);
        return v7Var;
    }
}
