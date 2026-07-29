package pp;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f46970h = 32768;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f46971i = 8388608;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f46972j = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f46973k = 262144;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f46974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f46975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f46976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f46977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f46978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f46979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f46980g = 1;

    public l(org.bouncycastle.crypto.f fVar, byte[] bArr, d dVar) {
        this.f46974a = fVar;
        this.f46975b = dVar;
        byte[] bArr2 = new byte[fVar.c()];
        this.f46976c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f46977d = new byte[fVar.c()];
        this.f46978e = new byte[fVar.c()];
    }

    public static boolean d(byte[] bArr, int i10) {
        return bArr != null && bArr.length > i10;
    }

    public int a(byte[] bArr, boolean z10) {
        if (this.f46978e.length == 8) {
            if (this.f46980g > 32768) {
                return -1;
            }
            if (d(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else {
            if (this.f46980g > f46971i) {
                return -1;
            }
            if (d(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z10 || this.f46979f == null) {
            byte[] bArrA = this.f46975b.a();
            this.f46979f = bArrA;
            if (bArrA.length != this.f46974a.c()) {
                throw new IllegalStateException("Insufficient entropy returned");
            }
        }
        int length = bArr.length / this.f46978e.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f46974a.d(this.f46976c, 0, this.f46977d, 0);
            e(this.f46978e, this.f46977d, this.f46979f);
            e(this.f46979f, this.f46978e, this.f46977d);
            byte[] bArr2 = this.f46978e;
            System.arraycopy(bArr2, 0, bArr, bArr2.length * i10, bArr2.length);
            c(this.f46976c);
        }
        int length2 = bArr.length - (this.f46978e.length * length);
        if (length2 > 0) {
            this.f46974a.d(this.f46976c, 0, this.f46977d, 0);
            e(this.f46978e, this.f46977d, this.f46979f);
            e(this.f46979f, this.f46978e, this.f46977d);
            byte[] bArr3 = this.f46978e;
            System.arraycopy(bArr3, 0, bArr, length * bArr3.length, length2);
            c(this.f46976c);
        }
        this.f46980g++;
        return bArr.length;
    }

    public d b() {
        return this.f46975b;
    }

    public final void c(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b10 = (byte) (bArr[length] + 1);
            bArr[length] = b10;
            if (b10 != 0) {
                return;
            }
        }
    }

    public final void e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = (byte) (bArr2[i10] ^ bArr3[i10]);
        }
        this.f46974a.d(bArr, 0, bArr, 0);
    }

    public void f() {
        byte[] bArrA = this.f46975b.a();
        this.f46979f = bArrA;
        if (bArrA.length != this.f46974a.c()) {
            throw new IllegalStateException("Insufficient entropy returned");
        }
        this.f46980g = 1L;
    }
}
