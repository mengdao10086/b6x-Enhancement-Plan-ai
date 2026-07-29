package ip;

import np.n1;
import np.v1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class l implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.f f35533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public mp.a f35534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n1 f35536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n1 f35537h;

    public l(org.bouncycastle.crypto.f fVar) {
        this(fVar, fVar.c() * 8, null);
    }

    public l(org.bouncycastle.crypto.f fVar, int i10) {
        this(fVar, i10, null);
    }

    public l(org.bouncycastle.crypto.f fVar, int i10, mp.a aVar) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (!(fVar instanceof cp.s)) {
            throw new IllegalArgumentException("cipher must be instance of DESEngine");
        }
        this.f35533d = new jp.c(fVar);
        this.f35534e = aVar;
        this.f35535f = i10 / 8;
        this.f35530a = new byte[fVar.c()];
        this.f35531b = new byte[fVar.c()];
        this.f35532c = 0;
    }

    public l(org.bouncycastle.crypto.f fVar, mp.a aVar) {
        this(fVar, fVar.c() * 8, aVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        n1 n1Var;
        reset();
        boolean z10 = kVar instanceof n1;
        if (!z10 && !(kVar instanceof v1)) {
            throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
        }
        byte[] bArrA = (z10 ? (n1) kVar : (n1) ((v1) kVar).b()).a();
        if (bArrA.length == 16) {
            n1Var = new n1(bArrA, 0, 8);
            this.f35536g = new n1(bArrA, 8, 8);
            this.f35537h = n1Var;
        } else {
            if (bArrA.length != 24) {
                throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
            }
            n1Var = new n1(bArrA, 0, 8);
            this.f35536g = new n1(bArrA, 8, 8);
            this.f35537h = new n1(bArrA, 16, 8);
        }
        if (kVar instanceof v1) {
            this.f35533d.a(true, new v1(n1Var, ((v1) kVar).a()));
        } else {
            this.f35533d.a(true, n1Var);
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "ISO9797Alg3";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        int iC = this.f35533d.c();
        if (this.f35534e == null) {
            while (true) {
                int i11 = this.f35532c;
                if (i11 >= iC) {
                    break;
                }
                this.f35531b[i11] = 0;
                this.f35532c = i11 + 1;
            }
        } else {
            if (this.f35532c == iC) {
                this.f35533d.d(this.f35531b, 0, this.f35530a, 0);
                this.f35532c = 0;
            }
            this.f35534e.b(this.f35531b, this.f35532c);
        }
        this.f35533d.d(this.f35531b, 0, this.f35530a, 0);
        cp.s sVar = new cp.s();
        sVar.a(false, this.f35536g);
        byte[] bArr2 = this.f35530a;
        sVar.d(bArr2, 0, bArr2, 0);
        sVar.a(true, this.f35537h);
        byte[] bArr3 = this.f35530a;
        sVar.d(bArr3, 0, bArr3, 0);
        System.arraycopy(this.f35530a, 0, bArr, i10, this.f35535f);
        reset();
        return this.f35535f;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35535f;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35531b;
            if (i10 >= bArr.length) {
                this.f35532c = 0;
                this.f35533d.reset();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        int i10 = this.f35532c;
        byte[] bArr = this.f35531b;
        if (i10 == bArr.length) {
            this.f35533d.d(bArr, 0, this.f35530a, 0);
            this.f35532c = 0;
        }
        byte[] bArr2 = this.f35531b;
        int i11 = this.f35532c;
        this.f35532c = i11 + 1;
        bArr2[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iC = this.f35533d.c();
        int i12 = this.f35532c;
        int i13 = iC - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f35531b, i12, i13);
            this.f35533d.d(this.f35531b, 0, this.f35530a, 0);
            this.f35532c = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iC) {
                this.f35533d.d(bArr, i10, this.f35530a, 0);
                i11 -= iC;
                i10 += iC;
            }
        }
        System.arraycopy(bArr, i10, this.f35531b, this.f35532c, i11);
        this.f35532c += i11;
    }
}
