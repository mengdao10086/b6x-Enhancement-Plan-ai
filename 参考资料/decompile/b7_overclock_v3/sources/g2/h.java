package g2;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f28958a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f28959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f28960c;

    public static void a(@n0 ImageView imageView, @p0 Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix != null) {
            c(imageView, matrix);
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            imageView.invalidate();
        }
    }

    public static void b() {
        if (f28960c) {
            return;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
            f28959b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        f28960c = true;
    }

    @SuppressLint({"NewApi"})
    @v0(21)
    public static void c(@n0 ImageView imageView, @p0 Matrix matrix) {
        if (f28958a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f28958a = false;
            }
        }
    }
}
