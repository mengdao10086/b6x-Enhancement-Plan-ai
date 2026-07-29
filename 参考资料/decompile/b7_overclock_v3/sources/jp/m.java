package jp;

import np.n1;
import np.v1;
import np.w1;
import np.x1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class m extends j0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f36658f = {105, 0, 114, 34, 100, i1.a.f31723v7, 4, 35, -115, 58, -37, -106, 70, -23, 42, -60, 24, -2, -84, -108, 0, -19, 7, 18, i1.a.f31667o7, -122, -36, i1.a.f31683q7, -17, 76, -87, rc.a.f48411c0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f36659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n1 f36660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f36661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f36662e;

    public m(org.bouncycastle.crypto.f fVar) {
        super(fVar);
        this.f36661d = 0L;
        this.f36659b = new e(fVar, fVar.c() * 8);
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        this.f36661d = 0L;
        this.f36659b.a(z10, kVar);
        this.f36662e = z10;
        if (kVar instanceof v1) {
            kVar = ((v1) kVar).b();
        }
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        if (kVar instanceof x1) {
            kVar = ((x1) kVar).a();
        }
        this.f36660c = (n1) kVar;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        String strB = this.f36659b.b();
        return strB.substring(0, strB.indexOf(47)) + "/G" + strB.substring(strB.indexOf(47) + 1);
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36659b.c();
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36659b.c(), bArr2, i11);
        return this.f36659b.c();
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) {
        long j10 = this.f36661d;
        if (j10 > 0 && j10 % 1024 == 0) {
            org.bouncycastle.crypto.f fVarI = this.f36659b.i();
            fVarI.a(false, this.f36660c);
            byte[] bArr = new byte[32];
            byte[] bArr2 = f36658f;
            fVarI.d(bArr2, 0, bArr, 0);
            fVarI.d(bArr2, 8, bArr, 8);
            fVarI.d(bArr2, 16, bArr, 16);
            fVarI.d(bArr2, 24, bArr, 24);
            n1 n1Var = new n1(bArr);
            this.f36660c = n1Var;
            fVarI.a(true, n1Var);
            byte[] bArrN = this.f36659b.n();
            fVarI.d(bArrN, 0, bArrN, 0);
            this.f36659b.a(this.f36662e, new v1(this.f36660c, bArrN));
        }
        this.f36661d++;
        return this.f36659b.h(b10);
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        this.f36661d = 0L;
        this.f36659b.reset();
    }
}
