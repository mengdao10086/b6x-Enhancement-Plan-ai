package m0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.RestrictTo;
import g.i1;
import g.n0;
import g.p0;
import j0.f;
import j0.i;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f40578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.collection.j<String, Typeface> f40579b;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a extends h.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public i.g f40580j;

        public a(@p0 i.g gVar) {
            this.f40580j = gVar;
        }

        @Override // v0.h.d
        public void a(int i10) {
            i.g gVar = this.f40580j;
            if (gVar != null) {
                gVar.f(i10);
            }
        }

        @Override // v0.h.d
        public void b(@n0 Typeface typeface) {
            i.g gVar = this.f40580j;
            if (gVar != null) {
                gVar.g(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f40578a = new b0();
        } else if (i10 >= 28) {
            f40578a = new a0();
        } else if (i10 >= 26) {
            f40578a = new z();
        } else if (i10 < 24 || !y.q()) {
            f40578a = new x();
        } else {
            f40578a = new y();
        }
        f40579b = new androidx.collection.j<>(16);
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void a() {
        f40579b.d();
    }

    @n0
    public static Typeface b(@n0 Context context, @p0 Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @n0
    public static Typeface c(@n0 Context context, @p0 Typeface typeface, @g.f0(from = 1, to = 1000) int i10, boolean z10) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        androidx.core.util.o.g(i10, 1, 1000, "weight");
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return f40578a.g(context, typeface, i10, z10);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface d(@n0 Context context, @p0 CancellationSignal cancellationSignal, @n0 h.c[] cVarArr, int i10) {
        return f40578a.d(context, cancellationSignal, cVarArr, i10);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface e(@n0 Context context, @n0 f.b bVar, @n0 Resources resources, int i10, int i11, @p0 i.g gVar, @p0 Handler handler, boolean z10) {
        return f(context, bVar, resources, i10, null, 0, i11, gVar, handler, z10);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface f(@n0 Context context, @n0 f.b bVar, @n0 Resources resources, int i10, @p0 String str, int i11, int i12, @p0 i.g gVar, @p0 Handler handler, boolean z10) {
        Typeface typefaceB;
        if (bVar instanceof f.C0405f) {
            f.C0405f c0405f = (f.C0405f) bVar;
            Typeface typefaceM = m(c0405f.c());
            if (typefaceM != null) {
                if (gVar != null) {
                    gVar.d(typefaceM, handler);
                }
                return typefaceM;
            }
            typefaceB = v0.h.f(context, c0405f.b(), i12, !z10 ? gVar != null : c0405f.a() != 0, z10 ? c0405f.d() : -1, i.g.e(handler), new a(gVar));
        } else {
            typefaceB = f40578a.b(context, (f.d) bVar, resources, i12);
            if (gVar != null) {
                if (typefaceB != null) {
                    gVar.d(typefaceB, handler);
                } else {
                    gVar.c(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f40579b.j(i(resources, i10, str, i11, i12), typefaceB);
        }
        return typefaceB;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface g(@n0 Context context, @n0 Resources resources, int i10, String str, int i11) {
        return h(context, resources, i10, str, 0, i11);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface h(@n0 Context context, @n0 Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceF = f40578a.f(context, resources, i10, str, i12);
        if (typefaceF != null) {
            f40579b.j(i(resources, i10, str, i11, i12), typefaceF);
        }
        return typefaceF;
    }

    public static String i(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface j(@n0 Resources resources, int i10, int i11) {
        return k(resources, i10, null, 0, i11);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface k(@n0 Resources resources, int i10, @p0 String str, int i11, int i12) {
        return f40579b.f(i(resources, i10, str, i11, i12));
    }

    @p0
    public static Typeface l(Context context, Typeface typeface, int i10) {
        c0 c0Var = f40578a;
        f.d dVarM = c0Var.m(typeface);
        if (dVarM == null) {
            return null;
        }
        return c0Var.b(context, dVarM, context.getResources(), i10);
    }

    public static Typeface m(@p0 String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
