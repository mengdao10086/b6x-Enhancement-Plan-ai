package a;

import android.view.ViewConfiguration;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f5566a = -1.0f;

    public void b(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        j();
        f();
        e();
        d();
        h();
        c();
        i();
        g();
    }

    public final void c() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getLongPressTimeout", new y22(this));
    }

    public final void d() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getMaximumFlingVelocity", new s22(this));
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getScaledMinimumFlingVelocity", new t22(this));
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getScaledMaximumFlingVelocity", new u22(this));
    }

    public final void e() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getScaledOverflingDistance", new x22(this));
    }

    public final void f() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getScaledOverscrollDistance", new w22(this));
    }

    public final void g() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getScaledTouchSlop", new q22(this));
    }

    public final void h() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getScrollFriction", new v22(this));
    }

    public final void i() {
        XposedBridge.hookAllMethods(ViewConfiguration.class, "getTapTimeout", new z22(this));
    }

    public final void j() {
        XposedBridge.hookAllConstructors(ViewConfiguration.class, new r22(this));
    }

    public final boolean k() {
        return true;
    }
}
