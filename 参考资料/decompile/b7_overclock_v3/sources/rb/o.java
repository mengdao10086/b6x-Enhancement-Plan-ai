package rb;

import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;
import java.util.Arrays;
import java.util.Collections;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements m {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f48178l = "H263Reader";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48179m = 176;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48180n = 178;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48181o = 179;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f48182p = 181;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48183q = 182;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48184r = 31;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48185s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float[] f48186t = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f48187u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final k0 f48188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final hd.c0 f48189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f48190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f48191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final u f48192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f48193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f48194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f48195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public hb.d0 f48196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f48197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f48198k;

    public static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f48199f = {0, 0, 1};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f48200g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f48201h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f48202i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f48203j = 3;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f48204k = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f48205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f48206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f48207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f48208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f48209e;

        public a(int i10) {
            this.f48209e = new byte[i10];
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f48205a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f48209e;
                int length = bArr2.length;
                int i13 = this.f48207c;
                if (length < i13 + i12) {
                    this.f48209e = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy(bArr, i10, this.f48209e, this.f48207c, i12);
                this.f48207c += i12;
            }
        }

        public boolean b(int i10, int i11) {
            int i12 = this.f48206b;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            if (i12 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i10 == 179 || i10 == 181) {
                                this.f48207c -= i11;
                                this.f48205a = false;
                                return true;
                            }
                        } else if ((i10 & 240) != 32) {
                            hd.t.n(o.f48178l, "Unexpected start code value");
                            c();
                        } else {
                            this.f48208d = this.f48207c;
                            this.f48206b = 4;
                        }
                    } else if (i10 > 31) {
                        hd.t.n(o.f48178l, "Unexpected start code value");
                        c();
                    } else {
                        this.f48206b = 3;
                    }
                } else if (i10 != 181) {
                    hd.t.n(o.f48178l, "Unexpected start code value");
                    c();
                } else {
                    this.f48206b = 2;
                }
            } else if (i10 == 176) {
                this.f48206b = 1;
                this.f48205a = true;
            }
            byte[] bArr = f48199f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f48205a = false;
            this.f48207c = 0;
            this.f48206b = 0;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f48210i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f48211j = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hb.d0 f48212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f48213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f48214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f48215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f48216e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f48217f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f48218g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f48219h;

        public b(hb.d0 d0Var) {
            this.f48212a = d0Var;
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f48214c) {
                int i12 = this.f48217f;
                int i13 = (i10 + 1) - i12;
                if (i13 >= i11) {
                    this.f48217f = i12 + (i11 - i10);
                } else {
                    this.f48215d = ((bArr[i13] & i1.a.f31667o7) >> 6) == 0;
                    this.f48214c = false;
                }
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
        public void b(long j10, int i10, boolean z10) {
            if (this.f48216e == 182 && z10 && this.f48213b) {
                this.f48212a.a(this.f48219h, this.f48215d ? 1 : 0, (int) (j10 - this.f48218g), i10, null);
            }
            if (this.f48216e != 179) {
                this.f48218g = j10;
            }
        }

        public void c(int i10, long j10) {
            this.f48216e = i10;
            this.f48215d = false;
            this.f48213b = i10 == 182 || i10 == 179;
            this.f48214c = i10 == 182;
            this.f48217f = 0;
            this.f48219h = j10;
        }

        public void d() {
            this.f48213b = false;
            this.f48214c = false;
            this.f48215d = false;
            this.f48216e = -1;
        }
    }

    public o() {
        this(null);
    }

    public static Format b(a aVar, int i10, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f48209e, aVar.f48207c);
        hd.b0 b0Var = new hd.b0(bArrCopyOf);
        b0Var.t(i10);
        b0Var.t(4);
        b0Var.r();
        b0Var.s(8);
        if (b0Var.g()) {
            b0Var.s(4);
            b0Var.s(3);
        }
        int iH = b0Var.h(4);
        float f10 = 1.0f;
        if (iH == 15) {
            int iH2 = b0Var.h(8);
            int iH3 = b0Var.h(8);
            if (iH3 == 0) {
                hd.t.n(f48178l, "Invalid aspect ratio");
            } else {
                f10 = iH2 / iH3;
            }
        } else {
            float[] fArr = f48186t;
            if (iH < fArr.length) {
                f10 = fArr[iH];
            } else {
                hd.t.n(f48178l, "Invalid aspect ratio");
            }
        }
        if (b0Var.g()) {
            b0Var.s(2);
            b0Var.s(1);
            if (b0Var.g()) {
                b0Var.s(15);
                b0Var.r();
                b0Var.s(15);
                b0Var.r();
                b0Var.s(15);
                b0Var.r();
                b0Var.s(3);
                b0Var.s(11);
                b0Var.r();
                b0Var.s(15);
                b0Var.r();
            }
        }
        if (b0Var.h(2) != 0) {
            hd.t.n(f48178l, "Unhandled video object layer shape");
        }
        b0Var.r();
        int iH4 = b0Var.h(16);
        b0Var.r();
        if (b0Var.g()) {
            if (iH4 == 0) {
                hd.t.n(f48178l, "Invalid vop_increment_time_resolution");
            } else {
                int i11 = 0;
                for (int i12 = iH4 - 1; i12 > 0; i12 >>= 1) {
                    i11++;
                }
                b0Var.s(i11);
            }
        }
        b0Var.r();
        int iH5 = b0Var.h(13);
        b0Var.r();
        int iH6 = b0Var.h(13);
        b0Var.r();
        b0Var.r();
        return new Format.b().S(str).e0(hd.w.f31202p).j0(iH5).Q(iH6).a0(f10).T(Collections.singletonList(bArrCopyOf)).E();
    }

    @Override // rb.m
    public void a() {
        hd.y.a(this.f48190c);
        this.f48191d.c();
        b bVar = this.f48193f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f48192e;
        if (uVar != null) {
            uVar.d();
        }
        this.f48194g = 0L;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        hd.a.k(this.f48193f);
        hd.a.k(this.f48196i);
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f48194g += (long) c0Var.a();
        this.f48196i.d(c0Var, c0Var.a());
        while (true) {
            int iC = hd.y.c(bArrD, iE, iF, this.f48190c);
            if (iC == iF) {
                break;
            }
            int i10 = iC + 3;
            int i11 = c0Var.d()[i10] & 255;
            int i12 = iC - iE;
            int i13 = 0;
            if (!this.f48197j) {
                if (i12 > 0) {
                    this.f48191d.a(bArrD, iE, iC);
                }
                if (this.f48191d.b(i11, i12 < 0 ? -i12 : 0)) {
                    hb.d0 d0Var = this.f48196i;
                    a aVar = this.f48191d;
                    d0Var.f(b(aVar, aVar.f48208d, (String) hd.a.g(this.f48195h)));
                    this.f48197j = true;
                }
            }
            this.f48193f.a(bArrD, iE, iC);
            u uVar = this.f48192e;
            if (uVar != null) {
                if (i12 > 0) {
                    uVar.a(bArrD, iE, iC);
                } else {
                    i13 = -i12;
                }
                if (this.f48192e.b(i13)) {
                    u uVar2 = this.f48192e;
                    ((hd.c0) u0.k(this.f48189b)).Q(this.f48192e.f48369d, hd.y.k(uVar2.f48369d, uVar2.f48370e));
                    ((k0) u0.k(this.f48188a)).a(this.f48198k, this.f48189b);
                }
                if (i11 == 178 && c0Var.d()[iC + 2] == 1) {
                    this.f48192e.e(i11);
                }
            }
            int i14 = iF - iC;
            this.f48193f.b(this.f48194g - ((long) i14), i14, this.f48197j);
            this.f48193f.c(i11, this.f48198k);
            iE = i10;
        }
        if (!this.f48197j) {
            this.f48191d.a(bArrD, iE, iF);
        }
        this.f48193f.a(bArrD, iE, iF);
        u uVar3 = this.f48192e;
        if (uVar3 != null) {
            uVar3.a(bArrD, iE, iF);
        }
    }

    @Override // rb.m
    public void d() {
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        this.f48195h = eVar.b();
        hb.d0 d0VarD = mVar.d(eVar.c(), 2);
        this.f48196i = d0VarD;
        this.f48193f = new b(d0VarD);
        k0 k0Var = this.f48188a;
        if (k0Var != null) {
            k0Var.b(mVar, eVar);
        }
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48198k = j10;
    }

    public o(@p0 k0 k0Var) {
        this.f48188a = k0Var;
        this.f48190c = new boolean[4];
        this.f48191d = new a(128);
        if (k0Var != null) {
            this.f48192e = new u(178, 128);
            this.f48189b = new hd.c0();
        } else {
            this.f48192e = null;
            this.f48189b = null;
        }
    }
}
