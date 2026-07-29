package z9;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58015a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f58015a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void a(float f10, float f11, float f12) {
        if (f10 >= f11) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f11 >= f12) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static int b(int i10) {
        return (i10 & 65280) >> 8;
    }

    public static boolean c(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    public static boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (a.f58015a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
