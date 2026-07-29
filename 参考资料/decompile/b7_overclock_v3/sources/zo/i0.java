package zo;

import org.bouncycastle.util.MemoableResetException;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends r {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f59322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f59323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f59324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f59325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f59326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f59327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f59328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f59329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f59330y;

    public i0(int i10) {
        if (i10 >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        }
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        }
        if (i10 == 384) {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
        int i11 = i10 / 8;
        this.f59322q = i11;
        C(i11 * 8);
        reset();
    }

    public i0(i0 i0Var) {
        super(i0Var);
        this.f59322q = i0Var.f59322q;
        i(i0Var);
    }

    public i0(byte[] bArr) {
        this(B(bArr));
        y(bArr);
    }

    public static void A(long j10, byte[] bArr, int i10, int i11) {
        if (i11 > 0) {
            z((int) (j10 >>> 32), bArr, i10, i11);
            if (i11 > 4) {
                z((int) (j10 & 4294967295L), bArr, i10 + 4, i11 - 4);
            }
        }
    }

    public static int B(byte[] bArr) {
        return org.bouncycastle.util.o.a(bArr, bArr.length - 4);
    }

    public static void z(int i10, byte[] bArr, int i11, int i12) {
        int iMin = Math.min(4, i12);
        while (true) {
            iMin--;
            if (iMin < 0) {
                return;
            } else {
                bArr[i11 + iMin] = (byte) (i10 >>> ((3 - iMin) * 8));
            }
        }
    }

    public final void C(int i10) {
        this.f59467e = -3482333909917012819L;
        this.f59468f = 2216346199247487646L;
        this.f59469g = -7364697282686394994L;
        this.f59470h = 65953792586715988L;
        this.f59471i = -816286391624063116L;
        this.f59472j = 4512832404995164602L;
        this.f59473k = -5033199132376557362L;
        this.f59474l = -124578254951840548L;
        update((byte) 83);
        update((byte) 72);
        update((byte) 65);
        update(rc.a.f48413e0);
        update((byte) 53);
        update((byte) 49);
        update((byte) 50);
        update((byte) 47);
        if (i10 <= 100) {
            if (i10 > 10) {
            }
            update((byte) (i10 + 48));
            s();
            this.f59323r = this.f59467e;
            this.f59324s = this.f59468f;
            this.f59325t = this.f59469g;
            this.f59326u = this.f59470h;
            this.f59327v = this.f59471i;
            this.f59328w = this.f59472j;
            this.f59329x = this.f59473k;
            this.f59330y = this.f59474l;
        }
        update((byte) ((i10 / 100) + 48));
        i10 %= 100;
        update((byte) ((i10 / 10) + 48));
        i10 %= 10;
        update((byte) (i10 + 48));
        s();
        this.f59323r = this.f59467e;
        this.f59324s = this.f59468f;
        this.f59325t = this.f59469g;
        this.f59326u = this.f59470h;
        this.f59327v = this.f59471i;
        this.f59328w = this.f59472j;
        this.f59329x = this.f59473k;
        this.f59330y = this.f59474l;
    }

    @Override // zo.g
    public byte[] a() {
        int iT = t();
        byte[] bArr = new byte[iT + 4];
        u(bArr);
        org.bouncycastle.util.o.h(this.f59322q * 8, bArr, iT);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "SHA-512/" + Integer.toString(this.f59322q * 8);
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        s();
        A(this.f59467e, bArr, i10, this.f59322q);
        A(this.f59468f, bArr, i10 + 8, this.f59322q - 8);
        A(this.f59469g, bArr, i10 + 16, this.f59322q - 16);
        A(this.f59470h, bArr, i10 + 24, this.f59322q - 24);
        A(this.f59471i, bArr, i10 + 32, this.f59322q - 32);
        A(this.f59472j, bArr, i10 + 40, this.f59322q - 40);
        A(this.f59473k, bArr, i10 + 48, this.f59322q - 48);
        A(this.f59474l, bArr, i10 + 56, this.f59322q - 56);
        reset();
        return this.f59322q;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new i0(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59322q;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        i0 i0Var = (i0) mVar;
        if (this.f59322q != i0Var.f59322q) {
            throw new MemoableResetException("digestLength inappropriate in other");
        }
        super.r(i0Var);
        this.f59323r = i0Var.f59323r;
        this.f59324s = i0Var.f59324s;
        this.f59325t = i0Var.f59325t;
        this.f59326u = i0Var.f59326u;
        this.f59327v = i0Var.f59327v;
        this.f59328w = i0Var.f59328w;
        this.f59329x = i0Var.f59329x;
        this.f59330y = i0Var.f59330y;
    }

    @Override // zo.r, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59467e = this.f59323r;
        this.f59468f = this.f59324s;
        this.f59469g = this.f59325t;
        this.f59470h = this.f59326u;
        this.f59471i = this.f59327v;
        this.f59472j = this.f59328w;
        this.f59473k = this.f59329x;
        this.f59474l = this.f59330y;
    }
}
