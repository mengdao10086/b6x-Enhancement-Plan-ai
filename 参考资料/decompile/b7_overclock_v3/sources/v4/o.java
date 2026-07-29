package v4;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import g.n0;
import g.p0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f52696a = 31;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f52697b = 17;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f52698c = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f52699d = new char[64];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public static volatile Handler f52700e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52701a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f52701a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52701a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52701a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52701a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52701a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!t()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!u()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(@p0 Object obj, @p0 Object obj2) {
        return obj == null ? obj2 == null : obj instanceof h4.l ? ((h4.l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean d(@p0 Object obj, @p0 Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @n0
    public static String e(@n0 byte[] bArr, @n0 char[] cArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            char[] cArr2 = f52698c;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
        }
        return new String(cArr);
    }

    @n0
    public static <T> Queue<T> f(int i10) {
        return new ArrayDeque(i10);
    }

    public static int g(int i10, int i11, @p0 Bitmap.Config config) {
        return i10 * i11 * i(config);
    }

    @TargetApi(19)
    public static int h(@n0 Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int i(@p0 Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i10 = a.f52701a[config.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 || i10 == 3) {
            return 2;
        }
        return i10 != 4 ? 4 : 8;
    }

    @Deprecated
    public static int j(@n0 Bitmap bitmap) {
        return h(bitmap);
    }

    @n0
    public static <T> List<T> k(@n0 Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t10 : collection) {
            if (t10 != null) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static Handler l() {
        if (f52700e == null) {
            synchronized (o.class) {
                if (f52700e == null) {
                    f52700e = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f52700e;
    }

    public static int m(float f10) {
        return n(f10, 17);
    }

    public static int n(float f10, int i10) {
        return p(Float.floatToIntBits(f10), i10);
    }

    public static int o(int i10) {
        return p(i10, 17);
    }

    public static int p(int i10, int i11) {
        return (i11 * 31) + i10;
    }

    public static int q(@p0 Object obj, int i10) {
        return p(obj == null ? 0 : obj.hashCode(), i10);
    }

    public static int r(boolean z10) {
        return s(z10, 17);
    }

    public static int s(boolean z10, int i10) {
        return p(z10 ? 1 : 0, i10);
    }

    public static boolean t() {
        return !u();
    }

    public static boolean u() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean v(int i10) {
        return i10 > 0 || i10 == Integer.MIN_VALUE;
    }

    public static boolean w(int i10, int i11) {
        return v(i10) && v(i11);
    }

    public static void x(Runnable runnable) {
        l().post(runnable);
    }

    public static void y(Runnable runnable) {
        l().removeCallbacks(runnable);
    }

    @n0
    public static String z(@n0 byte[] bArr) {
        String strE;
        char[] cArr = f52699d;
        synchronized (cArr) {
            strE = e(bArr, cArr);
        }
        return strE;
    }
}
