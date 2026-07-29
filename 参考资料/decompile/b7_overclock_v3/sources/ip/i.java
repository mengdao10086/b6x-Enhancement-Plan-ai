package ip;

import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class i implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jp.n f35509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35510b;

    public i(jp.n nVar) {
        this.f35509a = nVar;
        this.f35510b = 128;
    }

    public i(jp.n nVar, int i10) {
        this.f35509a = nVar;
        this.f35510b = i10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof v1)) {
            throw new IllegalArgumentException("GMAC requires ParametersWithIV");
        }
        v1 v1Var = (v1) kVar;
        byte[] bArrA = v1Var.a();
        this.f35509a.a(true, new np.a((n1) v1Var.b(), this.f35510b, bArrA));
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35509a.f().b() + "-GMAC";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        try {
            return this.f35509a.c(bArr, i10);
        } catch (InvalidCipherTextException e10) {
            throw new IllegalStateException(e10.toString());
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35510b / 8;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35509a.reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        this.f35509a.j(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        this.f35509a.k(bArr, i10, i11);
    }
}
