package com.blankj.utilcode.util;

import android.content.ContentResolver;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public g() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int a() {
        try {
            return Settings.System.getInt(j1.a().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int b(Window window) {
        float f10 = window.getAttributes().screenBrightness;
        return f10 < 0.0f ? a() : (int) (f10 * 255.0f);
    }

    public static boolean c() {
        try {
            return Settings.System.getInt(j1.a().getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean d(boolean z10) {
        return Settings.System.putInt(j1.a().getContentResolver(), "screen_brightness_mode", z10 ? 1 : 0);
    }

    public static boolean e(@g.f0(from = 0, to = or.a.f44396a) int i10) {
        ContentResolver contentResolver = j1.a().getContentResolver();
        boolean zPutInt = Settings.System.putInt(contentResolver, "screen_brightness", i10);
        contentResolver.notifyChange(Settings.System.getUriFor("screen_brightness"), null);
        return zPutInt;
    }

    public static void f(@g.n0 Window window, @g.f0(from = 0, to = or.a.f44396a) int i10) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = i10 / 255.0f;
        window.setAttributes(attributes);
    }
}
