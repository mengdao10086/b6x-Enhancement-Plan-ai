package zo;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.crypto.m0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f59195i = 65535;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f59196j = 32;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f59197k = 4294967296L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f59198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f59199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f59200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f59201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f59204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f59205h;

    public c() {
        this(65535);
    }

    public c(int i10) {
        this(i10, null, null, null);
    }

    public c(int i10, byte[] bArr) {
        this(i10, bArr, null, null);
    }

    public c(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f59200c = null;
        this.f59201d = new byte[32];
        this.f59202e = 32;
        this.f59203f = 0;
        this.f59204g = 0L;
        if (i10 < 1 || i10 > 65535) {
            throw new IllegalArgumentException("BLAKE2xs digest length must be between 1 and 2^16-1");
        }
        this.f59198a = i10;
        this.f59205h = a();
        this.f59199b = new b(32, bArr, bArr2, bArr3, this.f59205h);
    }

    public c(c cVar) {
        this.f59200c = null;
        this.f59201d = new byte[32];
        this.f59202e = 32;
        this.f59203f = 0;
        this.f59204g = 0L;
        this.f59198a = cVar.f59198a;
        this.f59199b = new b(cVar.f59199b);
        this.f59200c = org.bouncycastle.util.a.p(cVar.f59200c);
        this.f59201d = org.bouncycastle.util.a.p(cVar.f59201d);
        this.f59202e = cVar.f59202e;
        this.f59203f = cVar.f59203f;
        this.f59204g = cVar.f59204g;
        this.f59205h = cVar.f59205h;
    }

    public final long a() {
        return ((long) this.f59198a) * 4294967296L;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "BLAKE2xs";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        return f(bArr, i10, bArr.length);
    }

    public final int d() {
        int i10 = this.f59198a;
        if (i10 == 65535) {
            return 32;
        }
        return Math.min(32, i10 - this.f59203f);
    }

    @Override // org.bouncycastle.crypto.m0
    public int e(byte[] bArr, int i10, int i11) {
        if (this.f59200c == null) {
            byte[] bArr2 = new byte[this.f59199b.h()];
            this.f59200c = bArr2;
            this.f59199b.c(bArr2, 0);
        }
        int i12 = this.f59198a;
        if (i12 != 65535) {
            if (this.f59203f + i11 > i12) {
                throw new IllegalArgumentException("Output length is above the digest length");
            }
        } else if ((this.f59204g << 5) >= i()) {
            throw new IllegalArgumentException("Maximum length is 2^32 blocks of 32 bytes");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            if (this.f59202e >= 32) {
                b bVar = new b(d(), 32, this.f59205h);
                byte[] bArr3 = this.f59200c;
                bVar.update(bArr3, 0, bArr3.length);
                org.bouncycastle.util.a.d0(this.f59201d, (byte) 0);
                bVar.c(this.f59201d, 0);
                this.f59202e = 0;
                this.f59205h++;
                this.f59204g++;
            }
            byte[] bArr4 = this.f59201d;
            int i14 = this.f59202e;
            bArr[i13] = bArr4[i14];
            this.f59202e = i14 + 1;
            this.f59203f++;
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.m0
    public int f(byte[] bArr, int i10, int i11) {
        int iE = e(bArr, i10, i11);
        reset();
        return iE;
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f59199b.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59198a;
    }

    public long i() {
        return 137438953472L;
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59199b.reset();
        this.f59200c = null;
        this.f59202e = 32;
        this.f59203f = 0;
        this.f59204g = 0L;
        this.f59205h = a();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        this.f59199b.update(b10);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        this.f59199b.update(bArr, i10, i11);
    }
}
