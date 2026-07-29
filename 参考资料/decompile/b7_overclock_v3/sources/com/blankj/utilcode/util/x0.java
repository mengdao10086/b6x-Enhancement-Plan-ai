package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {
    public x0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int a() {
        WindowManager windowManager = (WindowManager) j1.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) j1.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int d() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    public static int e() {
        WindowManager windowManager = (WindowManager) j1.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int f(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static int g() {
        WindowManager windowManager = (WindowManager) j1.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static int h() {
        try {
            return Settings.System.getInt(j1.a().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e10) {
            e10.printStackTrace();
            return f.f11760c;
        }
    }

    public static boolean i(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean j() {
        return j1.a().getResources().getConfiguration().orientation == 2;
    }

    public static boolean k() {
        return j1.a().getResources().getConfiguration().orientation == 1;
    }

    public static boolean l() {
        KeyguardManager keyguardManager = (KeyguardManager) j1.a().getSystemService("keyguard");
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static Bitmap m(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return n(activity, false);
    }

    public static Bitmap n(@g.n0 Activity activity, boolean z10) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Bitmap bitmapF1 = l1.f1(activity.getWindow().getDecorView());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (!z10) {
            return Bitmap.createBitmap(bitmapF1, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        int iE0 = l1.e0();
        return Bitmap.createBitmap(bitmapF1, 0, iE0, displayMetrics.widthPixels, displayMetrics.heightPixels - iE0);
    }

    public static void o(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.getWindow().addFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void p(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.setRequestedOrientation(0);
    }

    public static void q(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.getWindow().clearFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void r(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.setRequestedOrientation(1);
    }

    @g.y0("android.permission.WRITE_SETTINGS")
    public static void s(int i10) {
        Settings.System.putInt(j1.a().getContentResolver(), "screen_off_timeout", i10);
    }

    public static void t(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        boolean zI = i(activity);
        Window window = activity.getWindow();
        if (zI) {
            window.clearFlags(1024);
        } else {
            window.addFlags(1024);
        }
    }
}
