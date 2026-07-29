package ip;

import android.support.v4.media.session.MediaSessionCompat;
import no.nordicsemi.android.dfu.DfuBaseService;
import np.n1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class e implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public org.bouncycastle.crypto.f f35489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f35491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f35492i;

    public e(org.bouncycastle.crypto.f fVar) {
        this(fVar, fVar.c() * 8);
    }

    public e(org.bouncycastle.crypto.f fVar, int i10) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (i10 > fVar.c() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (fVar.c() * 8));
        }
        this.f35489f = new jp.c(fVar);
        this.f35490g = i10 / 8;
        this.f35484a = f(fVar.c());
        this.f35486c = new byte[fVar.c()];
        this.f35487d = new byte[fVar.c()];
        this.f35485b = new byte[fVar.c()];
        this.f35488e = 0;
    }

    public static byte[] f(int i10) {
        int i11 = i10 * 8;
        int i12 = 135;
        switch (i11) {
            case 64:
            case MediaSessionCompat.M /* 320 */:
                i12 = 27;
                break;
            case 128:
            case 192:
                break;
            case 160:
                i12 = 45;
                break;
            case 224:
                i12 = 777;
                break;
            case 256:
                i12 = 1061;
                break;
            case 384:
                i12 = DfuBaseService.ERROR_CRC_ERROR;
                break;
            case 448:
                i12 = 2129;
                break;
            case 512:
                i12 = 293;
                break;
            case 768:
                i12 = 655377;
                break;
            case 1024:
                i12 = 524355;
                break;
            case 2048:
                i12 = 548865;
                break;
            default:
                throw new IllegalArgumentException("Unknown block size for CMAC: " + i11);
        }
        return org.bouncycastle.util.o.k(i12);
    }

    public static int g(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            int i11 = bArr[length] & 255;
            bArr2[length] = (byte) (i10 | (i11 << 1));
            i10 = (i11 >>> 7) & 1;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        h(kVar);
        this.f35489f.a(true, kVar);
        byte[] bArr = this.f35485b;
        byte[] bArr2 = new byte[bArr.length];
        this.f35489f.d(bArr, 0, bArr2, 0);
        byte[] bArrE = e(bArr2);
        this.f35491h = bArrE;
        this.f35492i = e(bArrE);
        reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35489f.b();
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        byte[] bArr2;
        if (this.f35488e == this.f35489f.c()) {
            bArr2 = this.f35491h;
        } else {
            new mp.c().b(this.f35487d, this.f35488e);
            bArr2 = this.f35492i;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr3 = this.f35486c;
            if (i11 >= bArr3.length) {
                this.f35489f.d(this.f35487d, 0, bArr3, 0);
                System.arraycopy(this.f35486c, 0, bArr, i10, this.f35490g);
                reset();
                return this.f35490g;
            }
            byte[] bArr4 = this.f35487d;
            bArr4[i11] = (byte) (bArr4[i11] ^ bArr2[i11]);
            i11++;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35490g;
    }

    public final byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i10 = (-g(bArr, bArr2)) & 255;
        int length = bArr.length - 3;
        byte b10 = bArr2[length];
        byte[] bArr3 = this.f35484a;
        bArr2[length] = (byte) (b10 ^ (bArr3[1] & i10));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & i10) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((i10 & bArr3[3]) ^ bArr2[length3]);
        return bArr2;
    }

    public void h(org.bouncycastle.crypto.k kVar) {
        if (kVar != null && !(kVar instanceof n1)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35487d;
            if (i10 >= bArr.length) {
                this.f35488e = 0;
                this.f35489f.reset();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        int i10 = this.f35488e;
        byte[] bArr = this.f35487d;
        if (i10 == bArr.length) {
            this.f35489f.d(bArr, 0, this.f35486c, 0);
            this.f35488e = 0;
        }
        byte[] bArr2 = this.f35487d;
        int i11 = this.f35488e;
        this.f35488e = i11 + 1;
        bArr2[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iC = this.f35489f.c();
        int i12 = this.f35488e;
        int i13 = iC - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f35487d, i12, i13);
            this.f35489f.d(this.f35487d, 0, this.f35486c, 0);
            this.f35488e = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iC) {
                this.f35489f.d(bArr, i10, this.f35486c, 0);
                i11 -= iC;
                i10 += iC;
            }
        }
        System.arraycopy(bArr, i10, this.f35487d, this.f35488e, i11);
        this.f35488e += i11;
    }
}
