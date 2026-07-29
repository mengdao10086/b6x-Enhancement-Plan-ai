package m0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import j0.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40516b = "TypefaceCompatBaseImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40517c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, f.d> f40518a = new ConcurrentHashMap<>();

    public class a implements d<h.c> {
        public a() {
        }

        @Override // m0.c0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(h.c cVar) {
            return cVar.e();
        }

        @Override // m0.c0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(h.c cVar) {
            return cVar.f();
        }
    }

    public class b implements d<f.e> {
        public b() {
        }

        @Override // m0.c0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(f.e eVar) {
            return eVar.e();
        }

        @Override // m0.c0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(f.e eVar) {
            return eVar.f();
        }
    }

    public class c implements d<f.e> {
        public c() {
        }

        @Override // m0.c0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(f.e eVar) {
            return eVar.e();
        }

        @Override // m0.c0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(f.e eVar) {
            return eVar.f();
        }
    }

    public interface d<T> {
        int a(T t10);

        boolean b(T t10);
    }

    public static <T> T j(T[] tArr, int i10, d<T> dVar) {
        return (T) k(tArr, (i10 & 1) == 0 ? 400 : 700, (i10 & 2) != 0, dVar);
    }

    public static <T> T k(T[] tArr, int i10, boolean z10, d<T> dVar) {
        T t10 = null;
        int i11 = Integer.MAX_VALUE;
        for (T t11 : tArr) {
            int iAbs = (Math.abs(dVar.a(t11) - i10) * 2) + (dVar.b(t11) == z10 ? 0 : 1);
            if (t10 == null || i11 > iAbs) {
                t10 = t11;
                i11 = iAbs;
            }
        }
        return t10;
    }

    public static long n(@p0 Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return 0L;
        }
    }

    public final void a(Typeface typeface, f.d dVar) {
        long jN = n(typeface);
        if (jN != 0) {
            this.f40518a.put(Long.valueOf(jN), dVar);
        }
    }

    @p0
    public Typeface b(Context context, f.d dVar, Resources resources, int i10) {
        f.e eVarH = h(dVar, i10);
        if (eVarH == null) {
            return null;
        }
        Typeface typefaceH = w.h(context, resources, eVarH.b(), eVarH.a(), 0, i10);
        a(typefaceH, dVar);
        return typefaceH;
    }

    @p0
    public Typeface c(Context context, f.d dVar, Resources resources, int i10, boolean z10) {
        f.e eVarI = i(dVar, i10, z10);
        if (eVarI == null) {
            return null;
        }
        Typeface typefaceH = w.h(context, resources, eVarI.b(), eVarI.a(), 0, 0);
        a(typefaceH, dVar);
        return typefaceH;
    }

    @p0
    public Typeface d(Context context, @p0 CancellationSignal cancellationSignal, @n0 h.c[] cVarArr, int i10) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (cVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(l(cVarArr, i10).d());
        } catch (IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Typeface typefaceE = e(context, inputStreamOpenInputStream);
            d0.a(inputStreamOpenInputStream);
            return typefaceE;
        } catch (IOException unused2) {
            d0.a(inputStreamOpenInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStreamOpenInputStream;
            d0.a(inputStream);
            throw th;
        }
    }

    public Typeface e(Context context, InputStream inputStream) {
        File fileE = d0.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (d0.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    @p0
    public Typeface f(Context context, Resources resources, int i10, String str, int i11) {
        File fileE = d0.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (d0.c(fileE, resources, i10)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    @n0
    public Typeface g(@n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        Typeface typefaceA;
        try {
            typefaceA = e0.a(this, context, typeface, i10, z10);
        } catch (RuntimeException unused) {
            typefaceA = null;
        }
        return typefaceA == null ? typeface : typefaceA;
    }

    public final f.e h(f.d dVar, int i10) {
        return (f.e) j(dVar.a(), i10, new b());
    }

    public final f.e i(f.d dVar, int i10, boolean z10) {
        return (f.e) k(dVar.a(), i10, z10, new c());
    }

    public h.c l(h.c[] cVarArr, int i10) {
        return (h.c) j(cVarArr, i10, new a());
    }

    @p0
    public f.d m(Typeface typeface) {
        long jN = n(typeface);
        if (jN == 0) {
            return null;
        }
        return this.f40518a.get(Long.valueOf(jN));
    }
}
