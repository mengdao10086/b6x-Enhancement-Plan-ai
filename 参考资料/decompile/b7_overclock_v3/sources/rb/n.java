package rb;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;
import java.util.Arrays;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements m {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48151q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48152r = 179;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48153s = 181;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f48154t = 184;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f48155u = 178;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final double[] f48156v = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hb.d0 f48158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final k0 f48159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final hd.c0 f48160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final u f48161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f48162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f48163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f48164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f48165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f48166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f48167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f48168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f48169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f48170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f48171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f48172p;

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte[] f48173e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f48174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f48175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f48176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f48177d;

        public a(int i10) {
            this.f48177d = new byte[i10];
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f48174a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f48177d;
                int length = bArr2.length;
                int i13 = this.f48175b;
                if (length < i13 + i12) {
                    this.f48177d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy(bArr, i10, this.f48177d, this.f48175b, i12);
                this.f48175b += i12;
            }
        }

        public boolean b(int i10, int i11) {
            if (this.f48174a) {
                int i12 = this.f48175b - i11;
                this.f48175b = i12;
                if (this.f48176c != 0 || i10 != 181) {
                    this.f48174a = false;
                    return true;
                }
                this.f48176c = i12;
            } else if (i10 == 179) {
                this.f48174a = true;
            }
            byte[] bArr = f48173e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f48174a = false;
            this.f48175b = 0;
            this.f48176c = 0;
        }
    }

    public n() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> b(rb.n.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f48177d
            int r1 = r8.f48175b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3d
            r7 = 3
            if (r6 == r7) goto L37
            if (r6 == r1) goto L31
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L31:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L42
        L37:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L42
        L3d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L42:
            float r6 = (float) r6
            float r1 = r1 / r6
        L44:
            com.google.android.exoplayer2.Format$b r6 = new com.google.android.exoplayer2.Format$b
            r6.<init>()
            com.google.android.exoplayer2.Format$b r9 = r6.S(r9)
            java.lang.String r6 = "video/mpeg2"
            com.google.android.exoplayer2.Format$b r9 = r9.e0(r6)
            com.google.android.exoplayer2.Format$b r9 = r9.j0(r2)
            com.google.android.exoplayer2.Format$b r9 = r9.Q(r4)
            com.google.android.exoplayer2.Format$b r9 = r9.a0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.google.android.exoplayer2.Format$b r9 = r9.T(r1)
            com.google.android.exoplayer2.Format r9 = r9.E()
            r1 = 0
            r4 = r0[r5]
            r4 = r4 & 15
            int r4 = r4 + (-1)
            if (r4 < 0) goto L9d
            double[] r5 = rb.n.f48156v
            int r6 = r5.length
            if (r4 >= r6) goto L9d
            r1 = r5[r4]
            int r8 = r8.f48176c
            int r8 = r8 + 9
            r4 = r0[r8]
            r4 = r4 & 96
            int r3 = r4 >> 5
            r8 = r0[r8]
            r8 = r8 & 31
            if (r3 == r8) goto L96
            double r3 = (double) r3
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L96:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r1 = (long) r3
        L9d:
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.n.b(rb.n$a, java.lang.String):android.util.Pair");
    }

    @Override // rb.m
    public void a() {
        hd.y.a(this.f48162f);
        this.f48163g.c();
        u uVar = this.f48161e;
        if (uVar != null) {
            uVar.d();
        }
        this.f48164h = 0L;
        this.f48165i = false;
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
    @Override // rb.m
    public void c(hd.c0 c0Var) {
        int i10;
        hd.a.k(this.f48158b);
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f48164h += (long) c0Var.a();
        this.f48158b.d(c0Var, c0Var.a());
        while (true) {
            int iC = hd.y.c(bArrD, iE, iF, this.f48162f);
            if (iC == iF) {
                break;
            }
            int i11 = iC + 3;
            int i12 = c0Var.d()[i11] & 255;
            int i13 = iC - iE;
            if (!this.f48166j) {
                if (i13 > 0) {
                    this.f48163g.a(bArrD, iE, iC);
                }
                if (this.f48163g.b(i12, i13 < 0 ? -i13 : 0)) {
                    Pair<Format, Long> pairB = b(this.f48163g, (String) hd.a.g(this.f48157a));
                    this.f48158b.f((Format) pairB.first);
                    this.f48167k = ((Long) pairB.second).longValue();
                    this.f48166j = true;
                }
            }
            u uVar = this.f48161e;
            if (uVar != null) {
                if (i13 > 0) {
                    uVar.a(bArrD, iE, iC);
                    i10 = 0;
                } else {
                    i10 = -i13;
                }
                if (this.f48161e.b(i10)) {
                    u uVar2 = this.f48161e;
                    ((hd.c0) u0.k(this.f48160d)).Q(this.f48161e.f48369d, hd.y.k(uVar2.f48369d, uVar2.f48370e));
                    ((k0) u0.k(this.f48159c)).a(this.f48170n, this.f48160d);
                }
                if (i12 == 178 && c0Var.d()[iC + 2] == 1) {
                    this.f48161e.e(i12);
                }
            }
            if (i12 == 0 || i12 == 179) {
                int i14 = iF - iC;
                if (this.f48165i && this.f48172p && this.f48166j) {
                    this.f48158b.a(this.f48170n, this.f48171o ? 1 : 0, ((int) (this.f48164h - this.f48169m)) - i14, i14, null);
                }
                boolean z10 = this.f48165i;
                if (!z10 || this.f48172p) {
                    this.f48169m = this.f48164h - ((long) i14);
                    long j10 = this.f48168l;
                    if (j10 == ya.g.f56663b) {
                        j10 = z10 ? this.f48170n + this.f48167k : 0L;
                    }
                    this.f48170n = j10;
                    this.f48171o = false;
                    this.f48168l = ya.g.f56663b;
                    this.f48165i = true;
                }
                this.f48172p = i12 == 0;
            } else if (i12 == 184) {
                this.f48171o = true;
            }
            iE = i11;
        }
        if (!this.f48166j) {
            this.f48163g.a(bArrD, iE, iF);
        }
        u uVar3 = this.f48161e;
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
        this.f48157a = eVar.b();
        this.f48158b = mVar.d(eVar.c(), 2);
        k0 k0Var = this.f48159c;
        if (k0Var != null) {
            k0Var.b(mVar, eVar);
        }
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        this.f48168l = j10;
    }

    public n(@p0 k0 k0Var) {
        this.f48159c = k0Var;
        this.f48162f = new boolean[4];
        this.f48163g = new a(128);
        if (k0Var != null) {
            this.f48161e = new u(178, 128);
            this.f48160d = new hd.c0();
        } else {
            this.f48161e = null;
            this.f48160d = null;
        }
    }
}
