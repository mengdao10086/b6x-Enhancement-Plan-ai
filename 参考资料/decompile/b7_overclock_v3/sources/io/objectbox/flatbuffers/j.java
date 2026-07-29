package io.objectbox.flatbuffers;

import io.objectbox.flatbuffers.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f32734h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f32735i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f32736j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f32737k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f32738l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f32739m = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f32740n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f32741o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f32742p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f32743q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ boolean f32744r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f32745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f32746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Integer> f32747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Integer> f32748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f32749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f32750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Comparator<b> f32751g;

    public class a implements Comparator<b> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            byte b10;
            byte b11;
            int i10 = bVar.f32758e;
            int i11 = bVar2.f32758e;
            do {
                b10 = j.this.f32745a.get(i10);
                b11 = j.this.f32745a.get(i11);
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
        this(new io.objectbox.flatbuffers.a(i10), 1);
    }

    public static int F(long j10) {
        if (j10 <= FlexBuffers.i.a((byte) -1)) {
            return 0;
        }
        if (j10 <= FlexBuffers.i.c((short) -1)) {
            return 1;
        }
        return j10 <= FlexBuffers.i.b(-1) ? 2 : 3;
    }

    public final void A(String str, long j10) {
        int iV = v(str);
        int iF = F(j10);
        this.f32746b.add(iF == 0 ? b.x(iV, (int) j10) : iF == 1 ? b.u(iV, (int) j10) : iF == 2 ? b.v(iV, (int) j10) : b.w(iV, j10));
    }

    public final void B(String str, long j10) {
        this.f32746b.add(b.w(v(str), j10));
    }

    public void C(BigInteger bigInteger) {
        B(null, bigInteger.longValue());
    }

    public int D() {
        return this.f32746b.size();
    }

    public int E() {
        return this.f32746b.size();
    }

    public final void G(b bVar, int i10) {
        int i11 = bVar.f32754a;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            if (i11 == 3) {
                I(bVar.f32756c, i10);
                return;
            } else if (i11 != 26) {
                K(bVar.f32757d, i10);
                return;
            }
        }
        J(bVar.f32757d, i10);
    }

    public final b H(int i10, byte[] bArr, int i11, boolean z10) {
        int iF = F(bArr.length);
        J(bArr.length, b(iF));
        int iM = this.f32745a.m();
        this.f32745a.o(bArr, 0, bArr.length);
        if (z10) {
            this.f32745a.p((byte) 0);
        }
        return b.f(i10, iM, i11, iF);
    }

    public final void I(double d10, int i10) {
        if (i10 == 4) {
            this.f32745a.putFloat((float) d10);
        } else if (i10 == 8) {
            this.f32745a.putDouble(d10);
        }
    }

    public final void J(long j10, int i10) {
        if (i10 == 1) {
            this.f32745a.p((byte) j10);
            return;
        }
        if (i10 == 2) {
            this.f32745a.putShort((short) j10);
        } else if (i10 == 4) {
            this.f32745a.putInt((int) j10);
        } else {
            if (i10 != 8) {
                return;
            }
            this.f32745a.putLong(j10);
        }
    }

    public final void K(long j10, int i10) {
        J((int) (((long) this.f32745a.m()) - j10), i10);
    }

    public final b L(int i10, String str) {
        return H(i10, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public final int b(int i10) {
        int i11 = 1 << i10;
        int iQ = b.q(this.f32745a.m(), i11);
        while (true) {
            int i12 = iQ - 1;
            if (iQ == 0) {
                return i11;
            }
            this.f32745a.p((byte) 0);
            iQ = i12;
        }
    }

    public void c() {
        this.f32745a.clear();
        this.f32746b.clear();
        this.f32747c.clear();
        this.f32748d.clear();
        this.f32750f = false;
    }

    public final b d(int i10, int i11) {
        long j10 = i11;
        int iMax = Math.max(0, F(j10));
        int i12 = i10;
        while (i12 < this.f32746b.size()) {
            i12++;
            iMax = Math.max(iMax, b.i(4, 0, this.f32746b.get(i12).f32758e, this.f32745a.m(), i12));
        }
        int iB = b(iMax);
        J(j10, iB);
        int iM = this.f32745a.m();
        while (i10 < this.f32746b.size()) {
            int i13 = this.f32746b.get(i10).f32758e;
            K(this.f32746b.get(i10).f32758e, iB);
            i10++;
        }
        return new b(-1, FlexBuffers.q(4, 0), iMax, iM);
    }

    public final b e(int i10, int i11, int i12, boolean z10, boolean z11, b bVar) {
        int i13;
        int iQ;
        int i14 = i12;
        long j10 = i14;
        int iMax = Math.max(0, F(j10));
        if (bVar != null) {
            iMax = Math.max(iMax, bVar.h(this.f32745a.m(), 0));
            i13 = 3;
        } else {
            i13 = 1;
        }
        int i15 = 4;
        int iMax2 = iMax;
        for (int i16 = i11; i16 < this.f32746b.size(); i16++) {
            iMax2 = Math.max(iMax2, this.f32746b.get(i16).h(this.f32745a.m(), i16 + i13));
            if (z10 && i16 == i11) {
                i15 = this.f32746b.get(i16).f32754a;
                if (!FlexBuffers.l(i15)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i17 = i11;
        int iB = b(iMax2);
        if (bVar != null) {
            K(bVar.f32757d, iB);
            J(1 << bVar.f32755b, iB);
        }
        if (!z11) {
            J(j10, iB);
        }
        int iM = this.f32745a.m();
        for (int i18 = i17; i18 < this.f32746b.size(); i18++) {
            G(this.f32746b.get(i18), iB);
        }
        if (!z10) {
            while (i17 < this.f32746b.size()) {
                this.f32745a.p(this.f32746b.get(i17).s(iMax2));
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

    public int f(String str, int i10) {
        int iV = v(str);
        ArrayList<b> arrayList = this.f32746b;
        Collections.sort(arrayList.subList(i10, arrayList.size()), this.f32751g);
        b bVarE = e(iV, i10, this.f32746b.size() - i10, false, false, d(i10, this.f32746b.size() - i10));
        while (this.f32746b.size() > i10) {
            this.f32746b.remove(r0.size() - 1);
        }
        this.f32746b.add(bVarE);
        return (int) bVarE.f32757d;
    }

    public int g(String str, int i10, boolean z10, boolean z11) {
        b bVarE = e(v(str), i10, this.f32746b.size() - i10, z10, z11, null);
        while (this.f32746b.size() > i10) {
            this.f32746b.remove(r10.size() - 1);
        }
        this.f32746b.add(bVarE);
        return (int) bVarE.f32757d;
    }

    public ByteBuffer h() {
        int iB = b(this.f32746b.get(0).h(this.f32745a.m(), 0));
        G(this.f32746b.get(0), iB);
        this.f32745a.p(this.f32746b.get(0).r());
        this.f32745a.p((byte) iB);
        this.f32750f = true;
        return ByteBuffer.wrap(this.f32745a.g(), 0, this.f32745a.m());
    }

    public o i() {
        return this.f32745a;
    }

    public int j(String str, byte[] bArr) {
        b bVarH = H(v(str), bArr, 25, false);
        this.f32746b.add(bVarH);
        return (int) bVarH.f32757d;
    }

    public int k(byte[] bArr) {
        return j(null, bArr);
    }

    public void l(String str, boolean z10) {
        this.f32746b.add(b.g(v(str), z10));
    }

    public void m(boolean z10) {
        l(null, z10);
    }

    public void n(double d10) {
        p(null, d10);
    }

    public void o(float f10) {
        q(null, f10);
    }

    public void p(String str, double d10) {
        this.f32746b.add(b.k(v(str), d10));
    }

    public void q(String str, float f10) {
        this.f32746b.add(b.j(v(str), f10));
    }

    public void r(int i10) {
        t(null, i10);
    }

    public void s(long j10) {
        u(null, j10);
    }

    public void t(String str, int i10) {
        u(str, i10);
    }

    public void u(String str, long j10) {
        int iV = v(str);
        if (-128 <= j10 && j10 <= 127) {
            this.f32746b.add(b.o(iV, (int) j10));
            return;
        }
        if (-32768 <= j10 && j10 <= 32767) {
            this.f32746b.add(b.l(iV, (int) j10));
        } else if (-2147483648L > j10 || j10 > 2147483647L) {
            this.f32746b.add(b.n(iV, j10));
        } else {
            this.f32746b.add(b.m(iV, (int) j10));
        }
    }

    public final int v(String str) {
        if (str == null) {
            return -1;
        }
        int iM = this.f32745a.m();
        if ((this.f32749e & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f32745a.o(bytes, 0, bytes.length);
            this.f32745a.p((byte) 0);
            this.f32747c.put(str, Integer.valueOf(iM));
            return iM;
        }
        Integer num = this.f32747c.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f32745a.o(bytes2, 0, bytes2.length);
        this.f32745a.p((byte) 0);
        this.f32747c.put(str, Integer.valueOf(iM));
        return iM;
    }

    public int w(String str) {
        return x(null, str);
    }

    public int x(String str, String str2) {
        long j10;
        int iV = v(str);
        if ((this.f32749e & 2) != 0) {
            Integer num = this.f32748d.get(str2);
            if (num != null) {
                this.f32746b.add(b.f(iV, num.intValue(), 5, F(str2.length())));
                return num.intValue();
            }
            b bVarL = L(iV, str2);
            this.f32748d.put(str2, Integer.valueOf((int) bVarL.f32757d));
            this.f32746b.add(bVarL);
            j10 = bVarL.f32757d;
        } else {
            b bVarL2 = L(iV, str2);
            this.f32746b.add(bVarL2);
            j10 = bVarL2.f32757d;
        }
        return (int) j10;
    }

    public void y(int i10) {
        A(null, i10);
    }

    public void z(long j10) {
        A(null, j10);
    }

    public j() {
        this(256);
    }

    @Deprecated
    public j(ByteBuffer byteBuffer, int i10) {
        this(new io.objectbox.flatbuffers.a(byteBuffer.array()), i10);
    }

    public j(o oVar, int i10) {
        this.f32746b = new ArrayList<>();
        this.f32747c = new HashMap<>();
        this.f32748d = new HashMap<>();
        this.f32750f = false;
        this.f32751g = new a();
        this.f32745a = oVar;
        this.f32749e = i10;
    }

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ boolean f32753f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f32756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f32757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32758e;

        public b(int i10, int i11, int i12, long j10) {
            this.f32758e = i10;
            this.f32754a = i11;
            this.f32755b = i12;
            this.f32757d = j10;
            this.f32756c = Double.MIN_VALUE;
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
                int iF = j.F((int) (((long) ((q(i12, i14) + i12) + (i13 * i14))) - j10));
                if ((1 << iF) == i14) {
                    return iF;
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
            return i(this.f32754a, this.f32755b, this.f32757d, i10, i11);
        }

        public final byte r() {
            return s(0);
        }

        public final byte s(int i10) {
            return p(t(i10), this.f32754a);
        }

        public final int t(int i10) {
            return FlexBuffers.j(this.f32754a) ? Math.max(this.f32755b, i10) : this.f32755b;
        }

        public b(int i10, int i11, int i12, double d10) {
            this.f32758e = i10;
            this.f32754a = i11;
            this.f32755b = i12;
            this.f32756c = d10;
            this.f32757d = Long.MIN_VALUE;
        }
    }

    public j(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
