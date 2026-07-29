package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5238a = "CompoundButtonCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f5239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5240c;

    @v0(21)
    public static class a {
        @g.u
        public static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        @g.u
        public static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        @g.u
        public static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @g.u
        public static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    @v0(23)
    public static class b {
        @g.u
        public static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    @p0
    public static Drawable a(@n0 CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(compoundButton);
        }
        if (!f5240c) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f5239b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f5240c = true;
        }
        Field field = f5239b;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                f5239b = null;
            }
        }
        return null;
    }

    @p0
    public static ColorStateList b(@n0 CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    @p0
    public static PorterDuff.Mode c(@n0 CompoundButton compoundButton) {
        return a.b(compoundButton);
    }

    public static void d(@n0 CompoundButton compoundButton, @p0 ColorStateList colorStateList) {
        a.c(compoundButton, colorStateList);
    }

    public static void e(@n0 CompoundButton compoundButton, @p0 PorterDuff.Mode mode) {
        a.d(compoundButton, mode);
    }
}
