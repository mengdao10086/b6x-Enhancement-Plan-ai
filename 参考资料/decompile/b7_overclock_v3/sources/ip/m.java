package ip;

import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class m implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jp.t f35538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35539b;

    public m(jp.t tVar) {
        this.f35538a = tVar;
        this.f35539b = tVar.f().c() * 8;
    }

    public m(jp.t tVar, int i10) {
        this.f35538a = tVar;
        this.f35539b = i10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof v1)) {
            throw new IllegalArgumentException("KGMAC requires ParametersWithIV");
        }
        v1 v1Var = (v1) kVar;
        byte[] bArrA = v1Var.a();
        this.f35538a.a(true, new np.a((n1) v1Var.b(), this.f35539b, bArrA));
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35538a.f().b() + "-KGMAC";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        try {
            return this.f35538a.c(bArr, i10);
        } catch (InvalidCipherTextException e10) {
            throw new IllegalStateException(e10.toString());
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35539b / 8;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35538a.reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        this.f35538a.j(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        this.f35538a.k(bArr, i10, i11);
    }
}
