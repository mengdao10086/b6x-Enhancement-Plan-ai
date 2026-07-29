package rb;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableList;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements i0.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f48117c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f48118d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f48119e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f48120f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f48121g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f48122h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f48123i = 64;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f48124j = 134;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Format> f48126b;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public j() {
        this(0);
    }

    @Override // rb.i0.c
    public SparseArray<i0> a() {
        return new SparseArray<>();
    }

    @Override // rb.i0.c
    @p0
    public i0 b(int i10, i0.b bVar) {
        if (i10 == 2) {
            return new w(new n(d(bVar)));
        }
        if (i10 == 3 || i10 == 4) {
            return new w(new t(bVar.f48108b));
        }
        if (i10 == 21) {
            return new w(new r());
        }
        if (i10 == 27) {
            if (f(4)) {
                return null;
            }
            return new w(new p(c(bVar), f(1), f(8)));
        }
        if (i10 == 36) {
            return new w(new q(c(bVar)));
        }
        if (i10 == 89) {
            return new w(new l(bVar.f48109c));
        }
        if (i10 != 138) {
            if (i10 == 172) {
                return new w(new f(bVar.f48108b));
            }
            if (i10 == 257) {
                return new c0(new v(hd.w.B0));
            }
            if (i10 != 129) {
                if (i10 != 130) {
                    if (i10 == 134) {
                        if (f(16)) {
                            return null;
                        }
                        return new c0(new v(hd.w.f31215v0));
                    }
                    if (i10 != 135) {
                        switch (i10) {
                            case 15:
                                if (f(2)) {
                                    return null;
                                }
                                return new w(new i(false, bVar.f48108b));
                            case 16:
                                return new w(new o(d(bVar)));
                            case 17:
                                if (f(2)) {
                                    return null;
                                }
                                return new w(new s(bVar.f48108b));
                            default:
                                return null;
                        }
                    }
                } else if (!f(64)) {
                    return null;
                }
            }
            return new w(new c(bVar.f48108b));
        }
        return new w(new k(bVar.f48108b));
    }

    public final d0 c(i0.b bVar) {
        return new d0(e(bVar));
    }

    public final k0 d(i0.b bVar) {
        return new k0(e(bVar));
    }

    public final List<Format> e(i0.b bVar) {
        String str;
        int i10;
        if (f(32)) {
            return this.f48126b;
        }
        hd.c0 c0Var = new hd.c0(bVar.f48110d);
        List<Format> arrayList = this.f48126b;
        while (c0Var.a() > 0) {
            int iG = c0Var.G();
            int iE = c0Var.e() + c0Var.G();
            if (iG == 134) {
                arrayList = new ArrayList<>();
                int iG2 = c0Var.G() & 31;
                for (int i11 = 0; i11 < iG2; i11++) {
                    String strD = c0Var.D(3);
                    int iG3 = c0Var.G();
                    boolean z10 = (iG3 & 128) != 0;
                    if (z10) {
                        i10 = iG3 & 63;
                        str = hd.w.f31197m0;
                    } else {
                        str = hd.w.f31195l0;
                        i10 = 1;
                    }
                    byte bG = (byte) c0Var.G();
                    c0Var.T(1);
                    List<byte[]> listB = null;
                    if (z10) {
                        listB = hd.d.b((bG & 64) != 0);
                    }
                    arrayList.add(new Format.b().e0(str).V(strD).F(i10).T(listB).E());
                }
            }
            c0Var.S(iE);
        }
        return arrayList;
    }

    public final boolean f(int i10) {
        return (i10 & this.f48125a) != 0;
    }

    public j(int i10) {
        this(i10, ImmutableList.of());
    }

    public j(int i10, List<Format> list) {
        this.f48125a = i10;
        this.f48126b = list;
    }
}
