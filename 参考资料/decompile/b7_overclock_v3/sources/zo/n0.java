package zo;

import cp.l1;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import np.j2;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class n0 implements org.bouncycastle.util.m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f59356j = 256;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f59357k = 512;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f59358l = 1024;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f59359m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f59360n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f59361o = 48;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f59362p = 63;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Hashtable f59363q = new Hashtable();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f59364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f59365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f59366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f59367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f59368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b[] f59369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b[] f59370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f59371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f59372i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f59373a;

        public a(long j10) {
            byte[] bArr = new byte[32];
            this.f59373a = bArr;
            bArr[0] = 83;
            bArr[1] = 72;
            bArr[2] = 65;
            bArr[3] = 51;
            bArr[4] = 1;
            bArr[5] = 0;
            l1.o(j10, bArr, 8);
        }

        public byte[] a() {
            return this.f59373a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f59374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f59375b;

        public b(int i10, byte[] bArr) {
            this.f59374a = i10;
            this.f59375b = bArr;
        }

        public int a() {
            return this.f59374a;
        }

        public byte[] b() {
            return this.f59375b;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f59376a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f59377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long[] f59379d;

        public c(int i10) {
            byte[] bArr = new byte[i10];
            this.f59377b = bArr;
            this.f59379d = new long[bArr.length / 8];
        }

        public void a(long[] jArr) {
            int i10 = this.f59378c;
            while (true) {
                byte[] bArr = this.f59377b;
                if (i10 >= bArr.length) {
                    this.f59376a.h(true);
                    b(jArr);
                    return;
                } else {
                    bArr[i10] = 0;
                    i10++;
                }
            }
        }

        public final void b(long[] jArr) {
            long[] jArr2;
            n0 n0Var = n0.this;
            n0Var.f59364a.j(true, n0Var.f59366c, this.f59376a.c());
            int i10 = 0;
            while (true) {
                jArr2 = this.f59379d;
                if (i10 >= jArr2.length) {
                    break;
                }
                jArr2[i10] = l1.i(this.f59377b, i10 * 8);
                i10++;
            }
            n0.this.f59364a.k(jArr2, jArr);
            for (int i11 = 0; i11 < jArr.length; i11++) {
                jArr[i11] = jArr[i11] ^ this.f59379d[i11];
            }
        }

        public void c(int i10) {
            this.f59376a.f();
            this.f59376a.j(i10);
            this.f59378c = 0;
        }

        public void d(c cVar) {
            this.f59377b = org.bouncycastle.util.a.q(cVar.f59377b, this.f59377b);
            this.f59378c = cVar.f59378c;
            this.f59379d = org.bouncycastle.util.a.u(cVar.f59379d, this.f59379d);
            this.f59376a.g(cVar.f59376a);
        }

        public void e(byte[] bArr, int i10, int i11, long[] jArr) {
            int i12 = 0;
            while (i11 > i12) {
                if (this.f59378c == this.f59377b.length) {
                    b(jArr);
                    this.f59376a.i(false);
                    this.f59378c = 0;
                }
                int iMin = Math.min(i11 - i12, this.f59377b.length - this.f59378c);
                System.arraycopy(bArr, i10 + i12, this.f59377b, this.f59378c, iMin);
                i12 += iMin;
                this.f59378c += iMin;
                this.f59376a.a(iMin);
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f59381c = 9223372034707292160L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f59382d = Long.MIN_VALUE;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f59383e = 4611686018427387904L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long[] f59384a = new long[2];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f59385b;

        public d() {
            f();
        }

        public void a(int i10) {
            if (!this.f59385b) {
                long[] jArr = this.f59384a;
                long j10 = jArr[0] + ((long) i10);
                jArr[0] = j10;
                if (j10 > f59381c) {
                    this.f59385b = true;
                    return;
                }
                return;
            }
            long[] jArr2 = new long[3];
            long[] jArr3 = this.f59384a;
            jArr2[0] = jArr3[0] & 4294967295L;
            jArr2[1] = (jArr3[0] >>> 32) & 4294967295L;
            jArr2[2] = jArr3[1] & 4294967295L;
            long j11 = i10;
            for (int i11 = 0; i11 < 3; i11++) {
                long j12 = j11 + jArr2[i11];
                jArr2[i11] = j12;
                j11 = j12 >>> 32;
            }
            long[] jArr4 = this.f59384a;
            jArr4[0] = ((jArr2[1] & 4294967295L) << 32) | (jArr2[0] & 4294967295L);
            jArr4[1] = (jArr2[2] & 4294967295L) | (jArr4[1] & (-4294967296L));
        }

        public int b() {
            return (int) ((this.f59384a[1] >>> 56) & 63);
        }

        public long[] c() {
            return this.f59384a;
        }

        public boolean d() {
            return (this.f59384a[1] & Long.MIN_VALUE) != 0;
        }

        public boolean e() {
            return (this.f59384a[1] & 4611686018427387904L) != 0;
        }

        public void f() {
            long[] jArr = this.f59384a;
            jArr[0] = 0;
            jArr[1] = 0;
            this.f59385b = false;
            i(true);
        }

        public void g(d dVar) {
            this.f59384a = org.bouncycastle.util.a.u(dVar.f59384a, this.f59384a);
            this.f59385b = dVar.f59385b;
        }

        public void h(boolean z10) {
            if (z10) {
                long[] jArr = this.f59384a;
                jArr[1] = jArr[1] | Long.MIN_VALUE;
            } else {
                long[] jArr2 = this.f59384a;
                jArr2[1] = jArr2[1] & Long.MAX_VALUE;
            }
        }

        public void i(boolean z10) {
            if (z10) {
                long[] jArr = this.f59384a;
                jArr[1] = jArr[1] | 4611686018427387904L;
            } else {
                long[] jArr2 = this.f59384a;
                jArr2[1] = jArr2[1] & (-4611686018427387905L);
            }
        }

        public void j(int i10) {
            long[] jArr = this.f59384a;
            jArr[1] = (jArr[1] & (-274877906944L)) | ((((long) i10) & 63) << 56);
        }

        public String toString() {
            return b() + " first: " + e() + ", final: " + d();
        }
    }

    static {
        m(256, 128, new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L});
        m(256, 160, new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L});
        m(256, 224, new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L});
        m(256, 256, new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L});
        m(512, 128, new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L});
        m(512, 160, new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L});
        m(512, 224, new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L});
        m(512, 384, new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L});
        m(512, 512, new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L});
    }

    public n0(int i10, int i11) {
        this.f59372i = new byte[1];
        if (i11 % 8 != 0) {
            throw new IllegalArgumentException("Output size must be a multiple of 8 bits. :" + i11);
        }
        this.f59365b = i11 / 8;
        l1 l1Var = new l1(i10);
        this.f59364a = l1Var;
        this.f59371h = new c(l1Var.c());
    }

    public n0(n0 n0Var) {
        this(n0Var.g() * 8, n0Var.h() * 8);
        c(n0Var);
    }

    public static b[] b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null) {
            return null;
        }
        if (bVarArr2 == null || bVarArr2.length != bVarArr.length) {
            bVarArr2 = new b[bVarArr.length];
        }
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr2.length);
        return bVarArr2;
    }

    public static void m(int i10, int i11, long[] jArr) {
        f59363q.put(v(i10 / 8, i11 / 8), jArr);
    }

    public static void p(b[] bVarArr) {
        if (bVarArr == null) {
            return;
        }
        for (int i10 = 1; i10 < bVarArr.length; i10++) {
            b bVar = bVarArr[i10];
            int i11 = i10;
            while (i11 > 0) {
                int i12 = i11 - 1;
                if (bVar.a() < bVarArr[i12].a()) {
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
            }
            bVarArr[i11] = bVar;
        }
    }

    public static Integer v(int i10, int i11) {
        return org.bouncycastle.util.j.g(i10 | (i11 << 16));
    }

    public final void a() {
        if (this.f59371h == null) {
            throw new IllegalArgumentException("Skein engine is not initialised.");
        }
    }

    public final void c(n0 n0Var) {
        this.f59371h.d(n0Var.f59371h);
        this.f59366c = org.bouncycastle.util.a.u(n0Var.f59366c, this.f59366c);
        this.f59367d = org.bouncycastle.util.a.u(n0Var.f59367d, this.f59367d);
        this.f59368e = org.bouncycastle.util.a.q(n0Var.f59368e, this.f59368e);
        this.f59369f = b(n0Var.f59369f, this.f59369f);
        this.f59370g = b(n0Var.f59370g, this.f59370g);
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new n0(this);
    }

    public final void e() {
        long[] jArr = (long[]) f59363q.get(v(g(), h()));
        int i10 = 0;
        if (this.f59368e != null || jArr == null) {
            this.f59366c = new long[g() / 8];
            byte[] bArr = this.f59368e;
            if (bArr != null) {
                q(0, bArr);
            }
            q(4, new a(this.f59365b * 8).a());
        } else {
            this.f59366c = org.bouncycastle.util.a.t(jArr);
        }
        if (this.f59369f != null) {
            while (true) {
                b[] bVarArr = this.f59369f;
                if (i10 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i10];
                q(bVar.a(), bVar.b());
                i10++;
            }
        }
        this.f59367d = org.bouncycastle.util.a.t(this.f59366c);
    }

    public int f(byte[] bArr, int i10) {
        a();
        if (bArr.length < this.f59365b + i10) {
            throw new OutputLengthException("Output buffer is too short to hold output");
        }
        r();
        if (this.f59370g != null) {
            int i11 = 0;
            while (true) {
                b[] bVarArr = this.f59370g;
                if (i11 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i11];
                q(bVar.a(), bVar.b());
                i11++;
            }
        }
        int iG = g();
        int i12 = ((this.f59365b + iG) - 1) / iG;
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * iG;
            n(i13, bArr, i10 + i14, Math.min(iG, this.f59365b - i14));
        }
        o();
        return this.f59365b;
    }

    public int g() {
        return this.f59364a.c();
    }

    public int h() {
        return this.f59365b;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        n0 n0Var = (n0) mVar;
        if (g() != n0Var.g() || this.f59365b != n0Var.f59365b) {
            throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
        }
        c(n0Var);
    }

    public void k(j2 j2Var) {
        this.f59366c = null;
        this.f59368e = null;
        this.f59369f = null;
        this.f59370g = null;
        if (j2Var != null) {
            if (j2Var.b().length < 16) {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
            l(j2Var.e());
        }
        e();
        s(48);
    }

    public final void l(Hashtable hashtable) {
        Enumeration enumerationKeys = hashtable.keys();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        while (enumerationKeys.hasMoreElements()) {
            Integer num = (Integer) enumerationKeys.nextElement();
            byte[] bArr = (byte[]) hashtable.get(num);
            if (num.intValue() == 0) {
                this.f59368e = bArr;
            } else if (num.intValue() < 48) {
                vector.addElement(new b(num.intValue(), bArr));
            } else {
                vector2.addElement(new b(num.intValue(), bArr));
            }
        }
        b[] bVarArr = new b[vector.size()];
        this.f59369f = bVarArr;
        vector.copyInto(bVarArr);
        p(this.f59369f);
        b[] bVarArr2 = new b[vector2.size()];
        this.f59370g = bVarArr2;
        vector2.copyInto(bVarArr2);
        p(this.f59370g);
    }

    public final void n(long j10, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[8];
        l1.o(j10, bArr2, 0);
        long[] jArr = new long[this.f59366c.length];
        s(63);
        this.f59371h.e(bArr2, 0, 8, jArr);
        this.f59371h.a(jArr);
        int i12 = ((i11 + 8) - 1) / 8;
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 8;
            int iMin = Math.min(8, i11 - i14);
            if (iMin == 8) {
                l1.o(jArr[i13], bArr, i14 + i10);
            } else {
                l1.o(jArr[i13], bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i14 + i10, iMin);
            }
        }
    }

    public void o() {
        long[] jArr = this.f59367d;
        long[] jArr2 = this.f59366c;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        s(48);
    }

    public final void q(int i10, byte[] bArr) {
        s(i10);
        this.f59371h.e(bArr, 0, bArr.length, this.f59366c);
        r();
    }

    public final void r() {
        this.f59371h.a(this.f59366c);
    }

    public final void s(int i10) {
        this.f59371h.c(i10);
    }

    public void t(byte b10) {
        byte[] bArr = this.f59372i;
        bArr[0] = b10;
        u(bArr, 0, 1);
    }

    public void u(byte[] bArr, int i10, int i11) {
        a();
        this.f59371h.e(bArr, i10, i11, this.f59366c);
    }
}
