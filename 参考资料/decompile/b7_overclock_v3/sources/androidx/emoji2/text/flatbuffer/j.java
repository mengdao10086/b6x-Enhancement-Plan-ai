package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5474h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5475i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5476j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5477k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5478l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5479m = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5480n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5481o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5482p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5483q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ boolean f5484r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f5485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f5486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Integer> f5487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Integer> f5488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Comparator<b> f5491g;

    public class a implements Comparator<b> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            byte b10;
            byte b11;
            int i10 = bVar.f5498e;
            int i11 = bVar2.f5498e;
            do {
                b10 = j.this.f5485a.get(i10);
                b11 = j.this.f5485a.get(i11);
                if (b10 == 0) {
                    return b10 - b11;
                }
                i10++;
                i11++;
            } while (b10 == b11);
            return b10 - b11;
        }
    }

    public j(int i10) {
        this(new androidx.emoji2.text.flatbuffer.a(i10), 1);
    }

    public static int E(long j10) {
        if (j10 <= FlexBuffers.i.a((byte) -1)) {
            return 0;
        }
        if (j10 <= FlexBuffers.i.c((short) -1)) {
            return 1;
        }
        return j10 <= FlexBuffers.i.b(-1) ? 2 : 3;
    }

    public final void A(String str, long j10) {
        this.f5486b.add(b.w(u(str), j10));
    }

    public void B(BigInteger bigInteger) {
        A(null, bigInteger.longValue());
    }

    public int C() {
        return this.f5486b.size();
    }

    public int D() {
        return this.f5486b.size();
    }

    public final void F(b bVar, int i10) {
        int i11 = bVar.f5494a;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            if (i11 == 3) {
                H(bVar.f5496c, i10);
                return;
            } else if (i11 != 26) {
                J(bVar.f5497d, i10);
                return;
            }
        }
        I(bVar.f5497d, i10);
    }

    public final b G(int i10, byte[] bArr, int i11, boolean z10) {
        int iE = E(bArr.length);
        I(bArr.length, b(iE));
        int iM = this.f5485a.m();
        this.f5485a.o(bArr, 0, bArr.length);
        if (z10) {
            this.f5485a.p((byte) 0);
        }
        return b.f(i10, iM, i11, iE);
    }

    public final void H(double d10, int i10) {
        if (i10 == 4) {
            this.f5485a.putFloat((float) d10);
        } else if (i10 == 8) {
            this.f5485a.putDouble(d10);
        }
    }

    public final void I(long j10, int i10) {
        if (i10 == 1) {
            this.f5485a.p((byte) j10);
            return;
        }
        if (i10 == 2) {
            this.f5485a.putShort((short) j10);
        } else if (i10 == 4) {
            this.f5485a.putInt((int) j10);
        } else {
            if (i10 != 8) {
                return;
            }
            this.f5485a.putLong(j10);
        }
    }

    public final void J(long j10, int i10) {
        I((int) (((long) this.f5485a.m()) - j10), i10);
    }

    public final b K(int i10, String str) {
        return G(i10, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public final int b(int i10) {
        int i11 = 1 << i10;
        int iQ = b.q(this.f5485a.m(), i11);
        while (true) {
            int i12 = iQ - 1;
            if (iQ == 0) {
                return i11;
            }
            this.f5485a.p((byte) 0);
            iQ = i12;
        }
    }

    public final b c(int i10, int i11) {
        long j10 = i11;
        int iMax = Math.max(0, E(j10));
        int i12 = i10;
        while (i12 < this.f5486b.size()) {
            i12++;
            iMax = Math.max(iMax, b.i(4, 0, this.f5486b.get(i12).f5498e, this.f5485a.m(), i12));
        }
        int iB = b(iMax);
        I(j10, iB);
        int iM = this.f5485a.m();
        while (i10 < this.f5486b.size()) {
            int i13 = this.f5486b.get(i10).f5498e;
            J(this.f5486b.get(i10).f5498e, iB);
            i10++;
        }
        return new b(-1, FlexBuffers.q(4, 0), iMax, iM);
    }

    public final b d(int i10, int i11, int i12, boolean z10, boolean z11, b bVar) {
        int i13;
        int iQ;
        int i14 = i12;
        long j10 = i14;
        int iMax = Math.max(0, E(j10));
        if (bVar != null) {
            iMax = Math.max(iMax, bVar.h(this.f5485a.m(), 0));
            i13 = 3;
        } else {
            i13 = 1;
        }
        int i15 = 4;
        int iMax2 = iMax;
        for (int i16 = i11; i16 < this.f5486b.size(); i16++) {
            iMax2 = Math.max(iMax2, this.f5486b.get(i16).h(this.f5485a.m(), i16 + i13));
            if (z10 && i16 == i11) {
                i15 = this.f5486b.get(i16).f5494a;
                if (!FlexBuffers.l(i15)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i17 = i11;
        int iB = b(iMax2);
        if (bVar != null) {
            J(bVar.f5497d, iB);
            I(1 << bVar.f5495b, iB);
        }
        if (!z11) {
            I(j10, iB);
        }
        int iM = this.f5485a.m();
        for (int i18 = i17; i18 < this.f5486b.size(); i18++) {
            F(this.f5486b.get(i18), iB);
        }
        if (!z10) {
            while (i17 < this.f5486b.size()) {
                this.f5485a.p(this.f5486b.get(i17).s(iMax2));
                i17++;
            }
        }
        if (bVar != null) {
            iQ = 9;
        } else if (z10) {
            if (!z11) {
                i14 = 0;
            }
            iQ = FlexBuffers.q(i15, i14);
        } else {
            iQ = 10;
        }
        return new b(i10, iQ, iMax2, iM);
    }

    public int e(String str, int i10) {
        int iU = u(str);
        ArrayList<b> arrayList = this.f5486b;
        Collections.sort(arrayList.subList(i10, arrayList.size()), this.f5491g);
        b bVarD = d(iU, i10, this.f5486b.size() - i10, false, false, c(i10, this.f5486b.size() - i10));
        while (this.f5486b.size() > i10) {
            this.f5486b.remove(r0.size() - 1);
        }
        this.f5486b.add(bVarD);
        return (int) bVarD.f5497d;
    }

    public int f(String str, int i10, boolean z10, boolean z11) {
        b bVarD = d(u(str), i10, this.f5486b.size() - i10, z10, z11, null);
        while (this.f5486b.size() > i10) {
            this.f5486b.remove(r10.size() - 1);
        }
        this.f5486b.add(bVarD);
        return (int) bVarD.f5497d;
    }

    public ByteBuffer g() {
        int iB = b(this.f5486b.get(0).h(this.f5485a.m(), 0));
        F(this.f5486b.get(0), iB);
        this.f5485a.p(this.f5486b.get(0).r());
        this.f5485a.p((byte) iB);
        this.f5490f = true;
        return ByteBuffer.wrap(this.f5485a.g(), 0, this.f5485a.m());
    }

    public q h() {
        return this.f5485a;
    }

    public int i(String str, byte[] bArr) {
        b bVarG = G(u(str), bArr, 25, false);
        this.f5486b.add(bVarG);
        return (int) bVarG.f5497d;
    }

    public int j(byte[] bArr) {
        return i(null, bArr);
    }

    public void k(String str, boolean z10) {
        this.f5486b.add(b.g(u(str), z10));
    }

    public void l(boolean z10) {
        k(null, z10);
    }

    public void m(double d10) {
        o(null, d10);
    }

    public void n(float f10) {
        p(null, f10);
    }

    public void o(String str, double d10) {
        this.f5486b.add(b.k(u(str), d10));
    }

    public void p(String str, float f10) {
        this.f5486b.add(b.j(u(str), f10));
    }

    public void q(int i10) {
        s(null, i10);
    }

    public void r(long j10) {
        t(null, j10);
    }

    public void s(String str, int i10) {
        t(str, i10);
    }

    public void t(String str, long j10) {
        int iU = u(str);
        if (-128 <= j10 && j10 <= 127) {
            this.f5486b.add(b.o(iU, (int) j10));
            return;
        }
        if (-32768 <= j10 && j10 <= 32767) {
            this.f5486b.add(b.l(iU, (int) j10));
        } else if (-2147483648L > j10 || j10 > 2147483647L) {
            this.f5486b.add(b.n(iU, j10));
        } else {
            this.f5486b.add(b.m(iU, (int) j10));
        }
    }

    public final int u(String str) {
        if (str == null) {
            return -1;
        }
        int iM = this.f5485a.m();
        if ((this.f5489e & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f5485a.o(bytes, 0, bytes.length);
            this.f5485a.p((byte) 0);
            this.f5487c.put(str, Integer.valueOf(iM));
            return iM;
        }
        Integer num = this.f5487c.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f5485a.o(bytes2, 0, bytes2.length);
        this.f5485a.p((byte) 0);
        this.f5487c.put(str, Integer.valueOf(iM));
        return iM;
    }

    public int v(String str) {
        return w(null, str);
    }

    public int w(String str, String str2) {
        long j10;
        int iU = u(str);
        if ((this.f5489e & 2) != 0) {
            Integer num = this.f5488d.get(str2);
            if (num != null) {
                this.f5486b.add(b.f(iU, num.intValue(), 5, E(str2.length())));
                return num.intValue();
            }
            b bVarK = K(iU, str2);
            this.f5488d.put(str2, Integer.valueOf((int) bVarK.f5497d));
            this.f5486b.add(bVarK);
            j10 = bVarK.f5497d;
        } else {
            b bVarK2 = K(iU, str2);
            this.f5486b.add(bVarK2);
            j10 = bVarK2.f5497d;
        }
        return (int) j10;
    }

    public void x(int i10) {
        z(null, i10);
    }

    public void y(long j10) {
        z(null, j10);
    }

    public final void z(String str, long j10) {
        int iU = u(str);
        int iE = E(j10);
        this.f5486b.add(iE == 0 ? b.x(iU, (int) j10) : iE == 1 ? b.u(iU, (int) j10) : iE == 2 ? b.v(iU, (int) j10) : b.w(iU, j10));
    }

    public j() {
        this(256);
    }

    @Deprecated
    public j(ByteBuffer byteBuffer, int i10) {
        this(new androidx.emoji2.text.flatbuffer.a(byteBuffer.array()), i10);
    }

    public j(q qVar, int i10) {
        this.f5486b = new ArrayList<>();
        this.f5487c = new HashMap<>();
        this.f5488d = new HashMap<>();
        this.f5490f = false;
        this.f5491g = new a();
        this.f5485a = qVar;
        this.f5489e = i10;
    }

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ boolean f5493f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f5496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5498e;

        public b(int i10, int i11, int i12, long j10) {
            this.f5498e = i10;
            this.f5494a = i11;
            this.f5495b = i12;
            this.f5497d = j10;
            this.f5496c = Double.MIN_VALUE;
        }

        public static b f(int i10, int i11, int i12, int i13) {
            return new b(i10, i12, i13, i11);
        }

        public static b g(int i10, boolean z10) {
            return new b(i10, 26, 0, z10 ? 1L : 0L);
        }

        public static int i(int i10, int i11, long j10, int i12, int i13) {
            if (FlexBuffers.j(i10)) {
                return i11;
            }
            for (int i14 = 1; i14 <= 32; i14 *= 2) {
                int iE = j.E((int) (((long) ((q(i12, i14) + i12) + (i13 * i14))) - j10));
                if ((1 << iE) == i14) {
                    return iE;
                }
            }
            return 3;
        }

        public static b j(int i10, float f10) {
            return new b(i10, 3, 2, f10);
        }

        public static b k(int i10, double d10) {
            return new b(i10, 3, 3, d10);
        }

        public static b l(int i10, int i11) {
            return new b(i10, 1, 1, i11);
        }

        public static b m(int i10, int i11) {
            return new b(i10, 1, 2, i11);
        }

        public static b n(int i10, long j10) {
            return new b(i10, 1, 3, j10);
        }

        public static b o(int i10, int i11) {
            return new b(i10, 1, 0, i11);
        }

        public static byte p(int i10, int i11) {
            return (byte) (i10 | (i11 << 2));
        }

        public static int q(int i10, int i11) {
            return ((~i10) + 1) & (i11 - 1);
        }

        public static b u(int i10, int i11) {
            return new b(i10, 2, 1, i11);
        }

        public static b v(int i10, int i11) {
            return new b(i10, 2, 2, i11);
        }

        public static b w(int i10, long j10) {
            return new b(i10, 2, 3, j10);
        }

        public static b x(int i10, int i11) {
            return new b(i10, 2, 0, i11);
        }

        public final int h(int i10, int i11) {
            return i(this.f5494a, this.f5495b, this.f5497d, i10, i11);
        }

        public final byte r() {
            return s(0);
        }

        public final byte s(int i10) {
            return p(t(i10), this.f5494a);
        }

        public final int t(int i10) {
            return FlexBuffers.j(this.f5494a) ? Math.max(this.f5495b, i10) : this.f5495b;
        }

        public b(int i10, int i11, int i12, double d10) {
            this.f5498e = i10;
            this.f5494a = i11;
            this.f5495b = i12;
            this.f5496c = d10;
            this.f5497d = Long.MIN_VALUE;
        }
    }

    public j(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
