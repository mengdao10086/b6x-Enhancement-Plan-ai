package wp;

import gm.i;
import gm.j2;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wp.b f54779a = new wp.a();

    public class a implements vp.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f54780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f54781b;

        public a(y yVar, b bVar) {
            this.f54780a = yVar;
            this.f54781b = bVar;
        }

        @Override // vp.a
        public y a() {
            return this.f54780a;
        }

        @Override // vp.a
        public OutputStream b() {
            return this.f54781b;
        }

        @Override // vp.a
        public boolean verify(byte[] bArr) {
            try {
                if (!this.f54780a.Q(sm.g.f49917r)) {
                    return this.f54781b.a(bArr);
                }
                try {
                    return this.f54781b.a(d.c(bArr));
                } catch (Exception unused) {
                    return false;
                }
            } catch (SignatureException e10) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e10.getMessage(), e10);
            }
        }
    }

    public class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Signature f54783a;

        public b(Signature signature) {
            this.f54783a = signature;
        }

        public boolean a(byte[] bArr) throws SignatureException {
            return this.f54783a.verify(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            try {
                this.f54783a.update((byte) i10);
            } catch (SignatureException e10) {
                throw new OperatorStreamException("exception in content signer: " + e10.getMessage(), e10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            try {
                this.f54783a.update(bArr);
            } catch (SignatureException e10) {
                throw new OperatorStreamException("exception in content signer: " + e10.getMessage(), e10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            try {
                this.f54783a.update(bArr, i10, i11);
            } catch (SignatureException e10) {
                throw new OperatorStreamException("exception in content signer: " + e10.getMessage(), e10);
            }
        }
    }

    public static byte[] c(byte[] bArr) throws IOException {
        int length = bArr.length / 2;
        byte[] bArr2 = new byte[length];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        System.arraycopy(bArr, length, bArr3, 0, length);
        i iVar = new i();
        iVar.a(new t(new BigInteger(1, bArr2)));
        iVar.a(new t(new BigInteger(1, bArr3)));
        return new j2(iVar).getEncoded();
    }

    public vp.a b(y yVar, PublicKey publicKey) throws OperatorCreationException {
        try {
            Signature signatureB = this.f54779a.b(yVar);
            signatureB.initVerify(publicKey);
            return new a(yVar, new b(signatureB));
        } catch (InvalidKeyException e10) {
            throw new OperatorCreationException("invalid key: " + e10.getMessage(), e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new OperatorCreationException("unable to find algorithm: " + e11.getMessage(), e11);
        } catch (NoSuchProviderException e12) {
            throw new OperatorCreationException("unable to find provider: " + e12.getMessage(), e12);
        }
    }

    public d d(String str) {
        this.f54779a = new f(str);
        return this;
    }

    public d e(Provider provider) {
        this.f54779a = new g(provider);
        return this;
    }
}
