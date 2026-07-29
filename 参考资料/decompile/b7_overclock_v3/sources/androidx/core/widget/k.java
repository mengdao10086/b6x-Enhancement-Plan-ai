package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    @v0(21)
    public static class a {
        @g.u
        public static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @g.u
        public static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        @g.u
        public static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        @g.u
        public static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    @p0
    public static ColorStateList a(@n0 ImageView imageView) {
        return a.a(imageView);
    }

    @p0
    public static PorterDuff.Mode b(@n0 ImageView imageView) {
        return a.b(imageView);
    }

    public static void c(@n0 ImageView imageView, @p0 ColorStateList colorStateList) {
        Drawable drawable;
        int i10 = Build.VERSION.SDK_INT;
        a.c(imageView, colorStateList);
        if (i10 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static void d(@n0 ImageView imageView, @p0 PorterDuff.Mode mode) {
        Drawable drawable;
        int i10 = Build.VERSION.SDK_INT;
        a.d(imageView, mode);
        if (i10 != 21 || (drawable = imageView.getDrawable()) == null || a.a(imageView) == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }
}
