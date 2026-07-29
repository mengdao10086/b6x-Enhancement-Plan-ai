package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class bo extends bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23373a = -65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23374b = -2147418112;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ca f23375h = new ca();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23379f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f23380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f23381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f23382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f23383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f23384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f23385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f23386o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte[] f23387p;

    public static class a implements bx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23390c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.bx
        public bv a(cj cjVar) {
            bo boVar = new bo(cjVar, this.f23388a, this.f23389b);
            int i10 = this.f23390c;
            if (i10 != 0) {
                boVar.c(i10);
            }
            return boVar;
        }

        public a(boolean z10, boolean z11) {
            this(z10, z11, 0);
        }

        public a(boolean z10, boolean z11, int i10) {
            this.f23388a = z10;
            this.f23389b = z11;
            this.f23390c = i10;
        }
    }

    public bo(cj cjVar) {
        this(cjVar, false, true);
    }

    @Override // com.umeng.analytics.pro.bv
    public ByteBuffer A() throws bc {
        int iW = w();
        d(iW);
        if (this.f23436g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f23436g.f(), this.f23436g.g(), iW);
            this.f23436g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.f23436g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bt btVar) throws bc {
        if (this.f23377d) {
            a((-2147418112) | btVar.f23430b);
            a(btVar.f23429a);
            a(btVar.f23431c);
        } else {
            a(btVar.f23429a);
            a(btVar.f23430b);
            a(btVar.f23431c);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ca caVar) {
    }

    public String b(int i10) throws bc {
        try {
            d(i10);
            byte[] bArr = new byte[i10];
            this.f23436g.d(bArr, 0, i10);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void c() {
    }

    public void c(int i10) {
        this.f23378e = i10;
        this.f23379f = true;
    }

    @Override // com.umeng.analytics.pro.bv
    public void d() throws bc {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bt h() throws bc {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) == -2147418112) {
                return new bt(z(), (byte) (iW & 255), w());
            }
            throw new bw(4, "Bad version in readMessageBegin");
        }
        if (this.f23376c) {
            throw new bw(4, "Missing version in readMessageBegin, old client?");
        }
        return new bt(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bv
    public ca j() {
        return f23375h;
    }

    @Override // com.umeng.analytics.pro.bv
    public void k() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bq l() throws bc {
        byte bU = u();
        return new bq("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.bv
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bs n() throws bc {
        return new bs(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bv
    public br p() throws bc {
        return new br(u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bz r() throws bc {
        return new bz(u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bv
    public boolean t() throws bc {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.bv
    public byte u() throws bc {
        if (this.f23436g.h() < 1) {
            a(this.f23384m, 0, 1);
            return this.f23384m[0];
        }
        byte b10 = this.f23436g.f()[this.f23436g.g()];
        this.f23436g.a(1);
        return b10;
    }

    @Override // com.umeng.analytics.pro.bv
    public short v() throws bc {
        byte[] bArrF = this.f23385n;
        int iG = 0;
        if (this.f23436g.h() >= 2) {
            bArrF = this.f23436g.f();
            iG = this.f23436g.g();
            this.f23436g.a(2);
        } else {
            a(this.f23385n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & 255) | ((bArrF[iG] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.bv
    public int w() throws bc {
        byte[] bArrF = this.f23386o;
        int iG = 0;
        if (this.f23436g.h() >= 4) {
            bArrF = this.f23436g.f();
            iG = this.f23436g.g();
            this.f23436g.a(4);
        } else {
            a(this.f23386o, 0, 4);
        }
        return (bArrF[iG + 3] & 255) | ((bArrF[iG] & 255) << 24) | ((bArrF[iG + 1] & 255) << 16) | ((bArrF[iG + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.bv
    public long x() throws bc {
        byte[] bArrF = this.f23387p;
        int iG = 0;
        if (this.f23436g.h() >= 8) {
            bArrF = this.f23436g.f();
            iG = this.f23436g.g();
            this.f23436g.a(8);
        } else {
            a(this.f23387p, 0, 8);
        }
        return ((long) (bArrF[iG + 7] & 255)) | (((long) (bArrF[iG] & 255)) << 56) | (((long) (bArrF[iG + 1] & 255)) << 48) | (((long) (bArrF[iG + 2] & 255)) << 40) | (((long) (bArrF[iG + 3] & 255)) << 32) | (((long) (bArrF[iG + 4] & 255)) << 24) | (((long) (bArrF[iG + 5] & 255)) << 16) | (((long) (bArrF[iG + 6] & 255)) << 8);
    }

    @Override // com.umeng.analytics.pro.bv
    public double y() throws bc {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.bv
    public String z() throws bc {
        int iW = w();
        if (this.f23436g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.f23436g.f(), this.f23436g.g(), iW, "UTF-8");
            this.f23436g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public bo(cj cjVar, boolean z10, boolean z11) {
        super(cjVar);
        this.f23379f = false;
        this.f23380i = new byte[1];
        this.f23381j = new byte[2];
        this.f23382k = new byte[4];
        this.f23383l = new byte[8];
        this.f23384m = new byte[1];
        this.f23385n = new byte[2];
        this.f23386o = new byte[4];
        this.f23387p = new byte[8];
        this.f23376c = z10;
        this.f23377d = z11;
    }

    public void d(int i10) throws bc {
        if (i10 < 0) {
            throw new bw("Negative length: " + i10);
        }
        if (this.f23379f) {
            int i11 = this.f23378e - i10;
            this.f23378e = i11;
            if (i11 >= 0) {
                return;
            }
            throw new bw("Message length exceeded: " + i10);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bq bqVar) throws bc {
        a(bqVar.f23422b);
        a(bqVar.f23423c);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bs bsVar) throws bc {
        a(bsVar.f23426a);
        a(bsVar.f23427b);
        a(bsVar.f23428c);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(br brVar) throws bc {
        a(brVar.f23424a);
        a(brVar.f23425b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bz bzVar) throws bc {
        a(bzVar.f23446a);
        a(bzVar.f23447b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(boolean z10) throws bc {
        a(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(byte b10) throws bc {
        byte[] bArr = this.f23380i;
        bArr[0] = b10;
        this.f23436g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(short s10) throws bc {
        byte[] bArr = this.f23381j;
        bArr[0] = (byte) ((s10 >> 8) & 255);
        bArr[1] = (byte) (s10 & 255);
        this.f23436g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(int i10) throws bc {
        byte[] bArr = this.f23382k;
        bArr[0] = (byte) ((i10 >> 24) & 255);
        bArr[1] = (byte) ((i10 >> 16) & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
        bArr[3] = (byte) (i10 & 255);
        this.f23436g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(long j10) throws bc {
        byte[] bArr = this.f23383l;
        bArr[0] = (byte) ((j10 >> 56) & 255);
        bArr[1] = (byte) ((j10 >> 48) & 255);
        bArr[2] = (byte) ((j10 >> 40) & 255);
        bArr[3] = (byte) ((j10 >> 32) & 255);
        bArr[4] = (byte) ((j10 >> 24) & 255);
        bArr[5] = (byte) ((j10 >> 16) & 255);
        bArr[6] = (byte) ((j10 >> 8) & 255);
        bArr[7] = (byte) (j10 & 255);
        this.f23436g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(double d10) throws bc {
        a(Double.doubleToLongBits(d10));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(String str) throws bc {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f23436g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ByteBuffer byteBuffer) throws bc {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.f23436g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    private int a(byte[] bArr, int i10, int i11) throws bc {
        d(i11);
        return this.f23436g.d(bArr, i10, i11);
    }
}
