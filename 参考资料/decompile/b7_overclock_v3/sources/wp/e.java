package wp;

import gm.f0;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Hashtable;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Hashtable f54785b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wp.b f54786a = new wp.a();

    public class a implements vp.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f54787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f54788b;

        public a(y yVar, b bVar) {
            this.f54787a = yVar;
            this.f54788b = bVar;
        }

        @Override // vp.b
        public y a() {
            return this.f54787a;
        }

        @Override // vp.b
        public OutputStream b() {
            return this.f54788b;
        }

        @Override // vp.b
        public byte[] getSignature() {
            try {
                byte[] bArrA = this.f54788b.a();
                return this.f54787a.Q(sm.g.f49917r) ? e.f(bArrA) : bArrA;
            } catch (SignatureException e10) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e10.getMessage(), e10);
            }
        }
    }

    public class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Signature f54790a;

        public b(Signature signature) {
            this.f54790a = signature;
        }

        public byte[] a() throws SignatureException {
            return this.f54790a.sign();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            try {
                this.f54790a.update((byte) i10);
            } catch (SignatureException e10) {
                throw new OperatorStreamException("exception in content signer: " + e10.getMessage(), e10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            try {
                this.f54790a.update(bArr);
            } catch (SignatureException e10) {
                throw new OperatorStreamException("exception in content signer: " + e10.getMessage(), e10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            try {
                this.f54790a.update(bArr, i10, i11);
            } catch (SignatureException e10) {
                throw new OperatorStreamException("exception in content signer: " + e10.getMessage(), e10);
            }
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        f54785b = hashtable;
        hashtable.put("SHA1withRSA", sm.g.f49911l);
        hashtable.put("SHA256withRSA", sm.g.f49912m);
        hashtable.put("SHA1withRSAandMGF1", sm.g.f49913n);
        hashtable.put("SHA256withRSAandMGF1", sm.g.f49914o);
        hashtable.put("SHA512withRSA", sm.g.f49915p);
        hashtable.put("SHA512withRSAandMGF1", sm.g.f49916q);
        hashtable.put("SHA1withECDSA", sm.g.f49918s);
        hashtable.put("SHA224withECDSA", sm.g.f49919t);
        hashtable.put("SHA256withECDSA", sm.g.f49920u);
        hashtable.put("SHA384withECDSA", sm.g.f49921v);
        hashtable.put("SHA512withECDSA", sm.g.f49922w);
    }

    public static void d(byte[] bArr, byte[] bArr2, int i10) {
        int length = bArr.length;
        int i11 = 0;
        if (bArr[0] == 0) {
            length--;
            i11 = 1;
        }
        System.arraycopy(bArr, i11, bArr2, i10, length);
    }

    public static int e(int i10, int i11) {
        return i10 > i11 ? i10 : i11;
    }

    public static byte[] f(byte[] bArr) {
        f0 f0VarJ = f0.J(bArr);
        BigInteger bigIntegerK = t.I(f0VarJ.K(0)).K();
        BigInteger bigIntegerK2 = t.I(f0VarJ.K(1)).K();
        byte[] byteArray = bigIntegerK.toByteArray();
        byte[] byteArray2 = bigIntegerK2.toByteArray();
        int i10 = i(byteArray);
        int i11 = i(byteArray2);
        int iE = e(i10, i11);
        int i12 = iE * 2;
        byte[] bArr2 = new byte[i12];
        Arrays.fill(bArr2, (byte) 0);
        d(byteArray, bArr2, iE - i10);
        d(byteArray2, bArr2, i12 - i11);
        return bArr2;
    }

    public static int i(byte[] bArr) {
        int length = bArr.length;
        return bArr[0] == 0 ? length - 1 : length;
    }

    public vp.b b(y yVar, PrivateKey privateKey) throws OperatorCreationException {
        try {
            Signature signatureB = this.f54786a.b(yVar);
            signatureB.initSign(privateKey);
            return new a(yVar, new b(signatureB));
        } catch (InvalidKeyException e10) {
            throw new OperatorCreationException("invalid key: " + e10.getMessage(), e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new OperatorCreationException("unable to find algorithm: " + e11.getMessage(), e11);
        } catch (NoSuchProviderException e12) {
            throw new OperatorCreationException("unable to find provider: " + e12.getMessage(), e12);
        }
    }

    public vp.b c(String str, PrivateKey privateKey) throws OperatorCreationException {
        return b((y) f54785b.get(str), privateKey);
    }

    public e g(String str) {
        this.f54786a = new f(str);
        return this;
    }

    public e h(Provider provider) {
        this.f54786a = new g(provider);
        return this;
    }
}
