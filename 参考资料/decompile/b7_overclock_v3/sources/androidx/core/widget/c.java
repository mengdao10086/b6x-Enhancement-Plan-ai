package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5235a = "CheckedTextViewCompat";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f5236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f5237b;

        @p0
        public static Drawable a(@n0 CheckedTextView checkedTextView) {
            if (!f5237b) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    f5236a = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f5237b = true;
            }
            Field field = f5236a;
            if (field != null) {
                try {
                    return (Drawable) field.get(checkedTextView);
                } catch (IllegalAccessException unused2) {
                    f5236a = null;
                }
            }
            return null;
        }
    }

    @v0(16)
    public static class b {
        @p0
        public static Drawable a(@n0 CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.c$c, reason: collision with other inner class name */
    @v0(21)
    public static class C0047c {
        @p0
        public static ColorStateList a(@n0 CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        @p0
        public static PorterDuff.Mode b(@n0 CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }

        public static void c(@n0 CheckedTextView checkedTextView, @p0 ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        public static void d(@n0 CheckedTextView checkedTextView, @p0 PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    @p0
    public static Drawable a(@n0 CheckedTextView checkedTextView) {
        return b.a(checkedTextView);
    }

    @p0
    public static ColorStateList b(@n0 CheckedTextView checkedTextView) {
        return C0047c.a(checkedTextView);
    }

    @p0
    public static PorterDuff.Mode c(@n0 CheckedTextView checkedTextView) {
        return C0047c.b(checkedTextView);
    }

    public static void d(@n0 CheckedTextView checkedTextView, @p0 ColorStateList colorStateList) {
        C0047c.c(checkedTextView, colorStateList);
    }

    public static void e(@n0 CheckedTextView checkedTextView, @p0 PorterDuff.Mode mode) {
        C0047c.d(checkedTextView, mode);
    }
}
