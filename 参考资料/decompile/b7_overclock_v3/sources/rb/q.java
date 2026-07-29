package rb;

import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f48279o = "H265Reader";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f48280p = 9;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48281q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48282r = 21;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48283s = 32;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f48284t = 33;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f48285u = 34;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f48286v = 35;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f48287w = 39;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f48288x = 40;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f48289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f48290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public hb.d0 f48291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f48292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f48293e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f48300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f48301m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f48294f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f48295g = new u(32, 128);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f48296h = new u(33, 128);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f48297i = new u(34, 128);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f48298j = new u(39, 128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f48299k = new u(40, 128);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final hd.c0 f48302n = new hd.c0();

    public static final class a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f48303n = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hb.d0 f48304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f48305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f48306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f48307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f48308e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f48309f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f48310g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f48311h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f48312i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f48313j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f48314k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f48315l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f48316m;

        public a(hb.d0 d0Var) {
            this.f48304a = d0Var;
        }

        public static boolean b(int i10) {
            return (32 <= i10 && i10 <= 35) || i10 == 39;
        }

        public static boolean c(int i10) {
            return i10 < 32 || i10 == 40;
        }

        public void a(long j10, int i10, boolean z10) {
            if (this.f48313j && this.f48310g) {
                this.f48316m = this.f48306c;
                this.f48313j = false;
            } else if (this.f48311h || this.f48310g) {
                if (z10 && this.f48312i) {
                    d(i10 + ((int) (j10 - this.f48305b)));
                }
                this.f48314k = this.f48305b;
                this.f48315l = this.f48308e;
                this.f48316m = this.f48306c;
                this.f48312i = true;
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void d(int i10) {
            boolean z10 = this.f48316m;
            this.f48304a.a(this.f48315l, z10 ? 1 : 0, (int) (this.f48305b - this.f48314k), i10, null);
        }

        public void e(byte[] bArr, int i10, int i11) {
            if (this.f48309f) {
                int i12 = this.f48307d;
                int i13 = (i10 + 2) - i12;
                if (i13 >= i11) {
                    this.f48307d = i12 + (i11 - i10);
                } else {
                    this.f48310g = (bArr[i13] & 128) != 0;
                    this.f48309f = false;
                }
            }
        }

        public void f() {
            this.f48309f = false;
            this.f48310g = false;
            this.f48311h = false;
            this.f48312i = false;
            this.f48313j = false;
        }

        public void g(long j10, int i10, int i11, long j11, boolean z10) {
            this.f48310g = false;
            this.f48311h = false;
            this.f48308e = j11;
            this.f48307d = 0;
            this.f48305b = j10;
            if (!c(i11)) {
                if (this.f48312i && !this.f48313j) {
                    if (z10) {
                        d(i10);
                    }
                    this.f48312i = false;
                }
                if (b(i11)) {
                    this.f48311h = !this.f48313j;
                    this.f48313j = true;
                }
            }
            boolean z11 = i11 >= 16 && i11 <= 21;
            this.f48306c = z11;
            this.f48309f = z11 || i11 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.f48289a = d0Var;
    }

    public static Format i(@p0 String str, u uVar, u uVar2, u uVar3) {
        int i10 = uVar.f48370e;
        byte[] bArr = new byte[uVar2.f48370e + i10 + uVar3.f48370e];
        System.arraycopy(uVar.f48369d, 0, bArr, 0, i10);
        System.arraycopy(uVar2.f48369d, 0, bArr, uVar.f48370e, uVar2.f48370e);
        System.arraycopy(uVar3.f48369d, 0, bArr, uVar.f48370e + uVar2.f48370e, uVar3.f48370e);
        hd.d0 d0Var = new hd.d0(uVar2.f48369d, 0, uVar2.f48370e);
        d0Var.l(44);
        int iE = d0Var.e(3);
        d0Var.k();
        d0Var.l(88);
        d0Var.l(8);
        int i11 = 0;
        for (int i12 = 0; i12 < iE; i12++) {
            if (d0Var.d()) {
                i11 += 89;
            }
            if (d0Var.d()) {
                i11 += 8;
            }
        }
        d0Var.l(i11);
        if (iE > 0) {
            d0Var.l((8 - iE) * 2);
        }
        d0Var.h();
        int iH = d0Var.h();
        if (iH == 3) {
            d0Var.k();
        }
        int iH2 = d0Var.h();
        int iH3 = d0Var.h();
        if (d0Var.d()) {
            int iH4 = d0Var.h();
            int iH5 = d0Var.h();
            int iH6 = d0Var.h();
            int iH7 = d0Var.h();
            iH2 -= ((iH == 1 || iH == 2) ? 2 : 1) * (iH4 + iH5);
            iH3 -= (iH == 1 ? 2 : 1) * (iH6 + iH7);
        }
        d0Var.h();
        d0Var.h();
        int iH8 = d0Var.h();
        for (int i13 = d0Var.d() ? 0 : iE; i13 <= iE; i13++) {
            d0Var.h();
            d0Var.h();
            d0Var.h();
        }
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        if (d0Var.d() && d0Var.d()) {
            j(d0Var);
        }
        d0Var.l(2);
        if (d0Var.d()) {
            d0Var.l(8);
            d0Var.h();
            d0Var.h();
            d0Var.k();
        }
        k(d0Var);
        if (d0Var.d()) {
            for (int i14 = 0; i14 < d0Var.h(); i14++) {
                d0Var.l(iH8 + 4 + 1);
            }
        }
        d0Var.l(2);
        float f10 = 1.0f;
        if (d0Var.d()) {
            if (d0Var.d()) {
                int iE2 = d0Var.e(8);
                if (iE2 == 255) {
                    int iE3 = d0Var.e(16);
                    int iE4 = d0Var.e(16);
                    if (iE3 != 0 && iE4 != 0) {
                        f10 = iE3 / iE4;
                    }
                } else {
                    float[] fArr = hd.y.f31233d;
                    if (iE2 < fArr.length) {
                        f10 = fArr[iE2];
                    } else {
                        hd.t.n(f48279o, "Unexpected aspect_ratio_idc value: " + iE2);
                    }
                }
            }
            if (d0Var.d()) {
                d0Var.k();
            }
            if (d0Var.d()) {
                d0Var.l(4);
                if (d0Var.d()) {
                    d0Var.l(24);
                }
            }
            if (d0Var.d()) {
                d0Var.h();
                d0Var.h();
            }
            d0Var.k();
            if (d0Var.d()) {
                iH3 *= 2;
            }
        }
        d0Var.i(uVar2.f48369d, 0, uVar2.f48370e);
        d0Var.l(24);
        return new Format.b().S(str).e0(hd.w.f31192k).I(hd.d.c(d0Var)).j0(iH2).Q(iH3).a0(f10).T(Collections.singletonList(bArr)).E();
    }

    public static void j(hd.d0 d0Var) {
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = 0;
            while (i11 < 6) {
                int i12 = 1;
                if (d0Var.d()) {
                    int iMin = Math.min(64, 1 << ((i10 << 1) + 4));
                    if (i10 > 1) {
                        d0Var.g();
                    }
                    for (int i13 = 0; i13 < iMin; i13++) {
                        d0Var.g();
                    }
                } else {
                    d0Var.h();
                }
                if (i10 == 3) {
                    i12 = 3;
                }
                i11 += i12;
            }
        }
    }

    public static void k(hd.d0 d0Var) {
        int iH = d0Var.h();
        boolean zD = false;
        int i10 = 0;
        for (int i11 = 0; i11 < iH; i11++) {
            if (i11 != 0) {
                zD = d0Var.d();
            }
            if (zD) {
                d0Var.k();
                d0Var.h();
                for (int i12 = 0; i12 <= i10; i12++) {
                    if (d0Var.d()) {
                        d0Var.k();
                    }
                }
            } else {
                int iH2 = d0Var.h();
                int iH3 = d0Var.h();
                int i13 = iH2 + iH3;
                for (int i14 = 0; i14 < iH2; i14++) {
                    d0Var.h();
                    d0Var.k();
                }
                for (int i15 = 0; i15 < iH3; i15++) {
                    d0Var.h();
                    d0Var.k();
                }
                i10 = i13;
            }
        }
    }

    @Override // rb.m
    public void a() {
        this.f48300l = 0L;
        hd.y.a(this.f48294f);
        this.f48295g.d();
        this.f48296h.d();
        this.f48297i.d();
        this.f48298j.d();
        this.f48299k.d();
        a aVar = this.f48292d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @EnsuresNonNull({"output", "sampleReader"})
    public final void b() {
        hd.a.k(this.f48291c);
        u0.k(this.f48292d);
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        b();
        while (c0Var.a() > 0) {
            int iE = c0Var.e();
            int iF = c0Var.f();
            byte[] bArrD = c0Var.d();
            this.f48300l += (long) c0Var.a();
            this.f48291c.d(c0Var, c0Var.a());
            while (iE < iF) {
                int iC = hd.y.c(bArrD, iE, iF, this.f48294f);
                if (iC == iF) {
                    h(bArrD, iE, iF);
                    return;
                }
                int iE2 = hd.y.e(bArrD, iC);
                int i10 = iC - iE;
                if (i10 > 0) {
                    h(bArrD, iE, iC);
                }
                int i11 = iF - iC;
                long j10 = this.f48300l - ((long) i11);
                g(j10, i11, i10 < 0 ? -i10 : 0, this.f48301m);
                l(j10, i11, iE2, this.f48301m);
                iE = iC + 3;
            }
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f48290b = eVar.b();
        hb.d0 d0VarD = mVar.d(eVar.c(), 2);
        this.f48291c = d0VarD;
        this.f48292d = new a(d0VarD);
        this.f48289a.b(mVar, eVar);
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48301m = j10;
    }

    @RequiresNonNull({"output", "sampleReader"})
    public final void g(long j10, int i10, int i11, long j11) {
        this.f48292d.a(j10, i10, this.f48293e);
        if (!this.f48293e) {
            this.f48295g.b(i11);
            this.f48296h.b(i11);
            this.f48297i.b(i11);
            if (this.f48295g.c() && this.f48296h.c() && this.f48297i.c()) {
                this.f48291c.f(i(this.f48290b, this.f48295g, this.f48296h, this.f48297i));
                this.f48293e = true;
            }
        }
        if (this.f48298j.b(i11)) {
            u uVar = this.f48298j;
            this.f48302n.Q(this.f48298j.f48369d, hd.y.k(uVar.f48369d, uVar.f48370e));
            this.f48302n.T(5);
            this.f48289a.a(j11, this.f48302n);
        }
        if (this.f48299k.b(i11)) {
            u uVar2 = this.f48299k;
            this.f48302n.Q(this.f48299k.f48369d, hd.y.k(uVar2.f48369d, uVar2.f48370e));
            this.f48302n.T(5);
            this.f48289a.a(j11, this.f48302n);
        }
    }

    @RequiresNonNull({"sampleReader"})
    public final void h(byte[] bArr, int i10, int i11) {
        this.f48292d.e(bArr, i10, i11);
        if (!this.f48293e) {
            this.f48295g.a(bArr, i10, i11);
            this.f48296h.a(bArr, i10, i11);
            this.f48297i.a(bArr, i10, i11);
        }
        this.f48298j.a(bArr, i10, i11);
        this.f48299k.a(bArr, i10, i11);
    }

    @RequiresNonNull({"sampleReader"})
    public final void l(long j10, int i10, int i11, long j11) {
        this.f48292d.g(j10, i10, i11, j11, this.f48293e);
        if (!this.f48293e) {
            this.f48295g.e(i11);
            this.f48296h.e(i11);
            this.f48297i.e(i11);
        }
        this.f48298j.e(i11);
        this.f48299k.e(i11);
    }
}
