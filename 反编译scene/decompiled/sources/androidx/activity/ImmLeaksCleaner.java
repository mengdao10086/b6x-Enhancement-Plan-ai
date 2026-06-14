package androidx.activity;

import a.hn;
import a.in;
import a.kn;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ImmLeaksCleaner implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f8134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f3953a;
    public static Field b;
    public static Field c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f3954a;

    public ImmLeaksCleaner(Activity activity) {
        this.f3954a = activity;
    }

    public static void h() {
        try {
            f8134a = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            c = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f3953a = declaredField3;
            declaredField3.setAccessible(true);
            f8134a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        if (aVar != hn.a.ON_DESTROY) {
            return;
        }
        if (f8134a == 0) {
            h();
        }
        if (f8134a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f3954a.getSystemService("input_method");
            try {
                Object obj = f3953a.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) b.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                c.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
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
