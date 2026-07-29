package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import g.k0;
import g.n0;
import g.v0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
final class ImmLeaksCleaner implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1327b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f1328c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f1329d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f1330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f1331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f1332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Field f1333h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f1334a;

    public ImmLeaksCleaner(Activity activity) {
        this.f1334a = activity;
    }

    @k0
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void h() {
        try {
            f1330e = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f1332g = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f1333h = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f1331f = declaredField3;
            declaredField3.setAccessible(true);
            f1330e = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.v
    public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f1330e == 0) {
            h();
        }
        if (f1330e == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1334a.getSystemService("input_method");
            try {
                Object obj = f1331f.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f1332g.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f1333h.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
