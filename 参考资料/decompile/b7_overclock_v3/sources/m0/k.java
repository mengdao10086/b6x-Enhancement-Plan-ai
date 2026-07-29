package m0;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import g.n0;
import g.p0;
import g.v0;
import m0.d;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40563a = "\udfffd";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40564b = "m";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<androidx.core.util.k<Rect, Rect>> f40565c = new ThreadLocal<>();

    @v0(23)
    public static class a {
        @g.u
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    @v0(29)
    public static class b {
        @g.u
        public static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(@n0 Paint paint, @n0 String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText(f40563a);
        float fMeasureText2 = paint.measureText(f40564b);
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i10 = 0;
            while (i10 < length) {
                int iCharCount = Character.charCount(str.codePointAt(i10)) + i10;
                fMeasureText4 += paint.measureText(str, i10, iCharCount);
                i10 = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        androidx.core.util.k<Rect, Rect> kVarB = b();
        paint.getTextBounds(f40563a, 0, 2, kVarB.f4741a);
        paint.getTextBounds(str, 0, length, kVarB.f4742b);
        return !kVarB.f4741a.equals(kVarB.f4742b);
    }

    public static androidx.core.util.k<Rect, Rect> b() {
        ThreadLocal<androidx.core.util.k<Rect, Rect>> threadLocal = f40565c;
        androidx.core.util.k<Rect, Rect> kVar = threadLocal.get();
        if (kVar == null) {
            androidx.core.util.k<Rect, Rect> kVar2 = new androidx.core.util.k<>(new Rect(), new Rect());
            threadLocal.set(kVar2);
            return kVar2;
        }
        kVar.f4741a.setEmpty();
        kVar.f4742b.setEmpty();
        return kVar;
    }

    public static boolean c(@n0 Paint paint, @p0 BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(paint, blendModeCompat != null ? d.b.a(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode modeA = d.a(blendModeCompat);
        paint.setXfermode(modeA != null ? new PorterDuffXfermode(modeA) : null);
        return modeA != null;
    }
}
