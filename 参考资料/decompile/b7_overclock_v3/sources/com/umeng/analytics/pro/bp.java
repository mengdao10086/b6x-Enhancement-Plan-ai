package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class bp extends bv {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ca f23391d = new ca("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bq f23392e = new bq("", (byte) 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f23393f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte f23394h = -126;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte f23395i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte f23396j = 31;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte f23397k = -32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f23398l = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f23399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f23400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f23401c;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private au f23402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private short f23403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private bq f23404o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Boolean f23405p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f23406q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private byte[] f23407r;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f23409a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final byte f23410b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final byte f23411c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final byte f23412d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte f23413e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte f23414f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final byte f23415g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final byte f23416h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final byte f23417i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final byte f23418j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final byte f23419k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final byte f23420l = 12;

        private b() {
        }
    }

    public bp(cj cjVar, long j10) {
        super(cjVar);
        this.f23402m = new au(15);
        this.f23403n = (short) 0;
        this.f23404o = null;
        this.f23405p = null;
        this.f23399a = new byte[5];
        this.f23400b = new byte[10];
        this.f23407r = new byte[1];
        this.f23401c = new byte[1];
        this.f23406q = j10;
    }

    private int E() throws bc {
        int i10 = 0;
        if (this.f23436g.h() >= 5) {
            byte[] bArrF = this.f23436g.f();
            int iG = this.f23436g.g();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                byte b10 = bArrF[iG + i10];
                i11 |= (b10 & 127) << i12;
                if ((b10 & 128) != 128) {
                    this.f23436g.a(i10 + 1);
                    return i11;
                }
                i12 += 7;
                i10++;
            }
        } else {
            int i13 = 0;
            while (true) {
                byte bU = u();
                i10 |= (bU & 127) << i13;
                if ((bU & 128) != 128) {
                    return i10;
                }
                i13 += 7;
            }
        }
    }

    private long F() throws bc {
        int i10 = 0;
        long j10 = 0;
        if (this.f23436g.h() >= 10) {
            byte[] bArrF = this.f23436g.f();
            int iG = this.f23436g.g();
            long j11 = 0;
            int i11 = 0;
            while (true) {
                byte b10 = bArrF[iG + i10];
                j11 |= ((long) (b10 & 127)) << i11;
                if ((b10 & 128) != 128) {
                    this.f23436g.a(i10 + 1);
                    return j11;
                }
                i11 += 7;
                i10++;
            }
        } else {
            while (true) {
                byte bU = u();
                j10 |= ((long) (bU & 127)) << i10;
                if ((bU & 128) != 128) {
                    return j10;
                }
                i10 += 7;
            }
        }
    }

    private int c(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    private long c(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private boolean c(byte b10) {
        int i10 = b10 & 15;
        return i10 == 1 || i10 == 2;
    }

    private long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    private byte[] e(int i10) throws bc {
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        this.f23436g.d(bArr, 0, i10);
        return bArr;
    }

    private void f(int i10) throws bw {
        if (i10 < 0) {
            throw new bw("Negative length: " + i10);
        }
        long j10 = this.f23406q;
        if (j10 == -1 || i10 <= j10) {
            return;
        }
        throw new bw("Length exceeded max allowed: " + i10);
    }

    private int g(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bv
    public ByteBuffer A() throws bc {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.f23436g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bv
    public void B() {
        this.f23402m.c();
        this.f23403n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bv
    public void a() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bt btVar) throws bc {
        b(f23394h);
        d(((btVar.f23430b << 5) & (-32)) | 1);
        b(btVar.f23431c);
        a(btVar.f23429a);
    }

    @Override // com.umeng.analytics.pro.bv
    public void b() throws bc {
        this.f23403n = this.f23402m.a();
    }

    @Override // com.umeng.analytics.pro.bv
    public void c() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void d() throws bc {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void e() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void f() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void g() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public bt h() throws bc {
        byte bU = u();
        if (bU != -126) {
            throw new bw("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b10 = (byte) (bU2 & 31);
        if (b10 == 1) {
            return new bt(z(), (byte) ((bU2 >> 5) & 3), E());
        }
        throw new bw("Expected version 1 but got " + ((int) b10));
    }

    @Override // com.umeng.analytics.pro.bv
    public void i() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public ca j() throws bc {
        this.f23402m.a(this.f23403n);
        this.f23403n = (short) 0;
        return f23391d;
    }

    @Override // com.umeng.analytics.pro.bv
    public void k() throws bc {
        this.f23403n = this.f23402m.a();
    }

    @Override // com.umeng.analytics.pro.bv
    public bq l() throws bc {
        byte bU = u();
        if (bU == 0) {
            return f23392e;
        }
        short s10 = (short) ((bU & 240) >> 4);
        byte b10 = (byte) (bU & 15);
        bq bqVar = new bq("", d(b10), s10 == 0 ? v() : (short) (this.f23403n + s10));
        if (c(bU)) {
            this.f23405p = b10 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f23403n = bqVar.f23423c;
        return bqVar;
    }

    @Override // com.umeng.analytics.pro.bv
    public void m() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public bs n() throws bc {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new bs(d((byte) (bU >> 4)), d((byte) (bU & 15)), iE);
    }

    @Override // com.umeng.analytics.pro.bv
    public void o() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public br p() throws bc {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new br(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.bv
    public void q() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public bz r() throws bc {
        return new bz(p());
    }

    @Override // com.umeng.analytics.pro.bv
    public void s() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public boolean t() throws bc {
        Boolean bool = this.f23405p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.f23405p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.bv
    public byte u() throws bc {
        if (this.f23436g.h() <= 0) {
            this.f23436g.d(this.f23401c, 0, 1);
            return this.f23401c[0];
        }
        byte b10 = this.f23436g.f()[this.f23436g.g()];
        this.f23436g.a(1);
        return b10;
    }

    @Override // com.umeng.analytics.pro.bv
    public short v() throws bc {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bv
    public int w() throws bc {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bv
    public long x() throws bc {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bv
    public double y() throws bc {
        byte[] bArr = new byte[8];
        this.f23436g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bv
    public String z() throws bc {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.f23436g.h() < iE) {
                return new String(e(iE), "UTF-8");
            }
            String str = new String(this.f23436g.f(), this.f23436g.g(), iE, "UTF-8");
            this.f23436g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bc("UTF-8 not supported!");
        }
    }

    public static class a implements bx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f23408a;

        public a() {
            this.f23408a = -1L;
        }

        @Override // com.umeng.analytics.pro.bx
        public bv a(cj cjVar) {
            return new bp(cjVar, this.f23408a);
        }

        public a(int i10) {
            this.f23408a = i10;
        }
    }

    private void b(int i10) throws bc {
        int i11 = 0;
        while ((i10 & (-128)) != 0) {
            this.f23399a[i11] = (byte) ((i10 & 127) | 128);
            i10 >>>= 7;
            i11++;
        }
        byte[] bArr = this.f23399a;
        bArr[i11] = (byte) i10;
        this.f23436g.b(bArr, 0, i11 + 1);
    }

    private void d(int i10) throws bc {
        b((byte) i10);
    }

    private byte d(byte b10) throws bw {
        byte b11 = (byte) (b10 & 15);
        switch (b11) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new bw("don't know what type: " + ((int) b11));
        }
    }

    private byte e(byte b10) {
        return f23393f[b10];
    }

    private void b(long j10) throws bc {
        int i10 = 0;
        while (((-128) & j10) != 0) {
            this.f23400b[i10] = (byte) ((127 & j10) | 128);
            j10 >>>= 7;
            i10++;
        }
        byte[] bArr = this.f23400b;
        bArr[i10] = (byte) j10;
        this.f23436g.b(bArr, 0, i10 + 1);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ca caVar) throws bc {
        this.f23402m.a(this.f23403n);
        this.f23403n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bq bqVar) throws bc {
        if (bqVar.f23422b == 2) {
            this.f23404o = bqVar;
        } else {
            a(bqVar, (byte) -1);
        }
    }

    private void b(byte b10) throws bc {
        byte[] bArr = this.f23407r;
        bArr[0] = b10;
        this.f23436g.b(bArr);
    }

    private void a(bq bqVar, byte b10) throws bc {
        if (b10 == -1) {
            b10 = e(bqVar.f23422b);
        }
        short s10 = bqVar.f23423c;
        short s11 = this.f23403n;
        if (s10 > s11 && s10 - s11 <= 15) {
            d(b10 | ((s10 - s11) << 4));
        } else {
            b(b10);
            a(bqVar.f23423c);
        }
        this.f23403n = bqVar.f23423c;
    }

    public bp(cj cjVar) {
        this(cjVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bs bsVar) throws bc {
        int i10 = bsVar.f23428c;
        if (i10 == 0) {
            d(0);
            return;
        }
        b(i10);
        d(e(bsVar.f23427b) | (e(bsVar.f23426a) << 4));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(br brVar) throws bc {
        a(brVar.f23424a, brVar.f23425b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bz bzVar) throws bc {
        a(bzVar.f23446a, bzVar.f23447b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(boolean z10) throws bc {
        bq bqVar = this.f23404o;
        if (bqVar != null) {
            a(bqVar, z10 ? (byte) 1 : (byte) 2);
            this.f23404o = null;
        } else {
            b(z10 ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(byte b10) throws bc {
        b(b10);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(short s10) throws bc {
        b(c((int) s10));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(int i10) throws bc {
        b(c(i10));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(long j10) throws bc {
        b(c(j10));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(double d10) throws bc {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d10), bArr, 0);
        this.f23436g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(String str) throws bc {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bc("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ByteBuffer byteBuffer) throws bc {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i10, int i11) throws bc {
        b(i11);
        this.f23436g.b(bArr, i10, i11);
    }

    public void a(byte b10, int i10) throws bc {
        if (i10 <= 14) {
            d(e(b10) | (i10 << 4));
        } else {
            d(e(b10) | 240);
            b(i10);
        }
    }

    private void a(long j10, byte[] bArr, int i10) {
        bArr[i10 + 0] = (byte) (j10 & 255);
        bArr[i10 + 1] = (byte) ((j10 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((j10 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((j10 >> 24) & 255);
        bArr[i10 + 4] = (byte) ((j10 >> 32) & 255);
        bArr[i10 + 5] = (byte) ((j10 >> 40) & 255);
        bArr[i10 + 6] = (byte) ((j10 >> 48) & 255);
        bArr[i10 + 7] = (byte) ((j10 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
