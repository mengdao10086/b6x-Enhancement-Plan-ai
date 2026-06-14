package a;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ij0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyguardManager f6419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager f1374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer[] f1375a;

    public ij0(Context context) {
        f92.d(context, "context");
        this.f1373a = context;
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
        }
        this.f6419a = (KeyguardManager) systemService;
        Object systemService2 = this.f1373a.getSystemService("window");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.f1374a = (WindowManager) systemService2;
        this.f1375a = s42.i(new int[]{1, 3, 4, 6});
    }

    public final Display a() {
        Context context = this.f1373a;
        if (!(context instanceof Activity) || Build.VERSION.SDK_INT <= 29) {
            Display defaultDisplay = this.f1374a.getDefaultDisplay();
            f92.c(defaultDisplay, "windowManager.defaultDisplay");
            return defaultDisplay;
        }
        Display display = context.getDisplay();
        if (display != null) {
            return display;
        }
        Display defaultDisplay2 = this.f1374a.getDefaultDisplay();
        f92.c(defaultDisplay2, "windowManager.defaultDisplay");
        return defaultDisplay2;
    }

    public final boolean b() {
        if (!c() || this.f6419a.isDeviceLocked()) {
            return true;
        }
        try {
            return this.f6419a.isKeyguardLocked();
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean c() {
        return !u42.k(this.f1375a, Integer.valueOf(a().getState()));
    }
}
