package zq;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import np.n1;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class n0 {

    public static class a extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59612a = n0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59612a;
            sb2.append(str);
            sb2.append("$TLS10");
            aVar.h("SecretKeyFactory.TLS10KDF", sb2.toString());
            aVar.h("SecretKeyFactory.TLS11KDF", str + "$TLS11");
            aVar.h("SecretKeyFactory.TLS12WITHSHA256KDF", str + "$TLS12withSHA256");
            aVar.h("SecretKeyFactory.TLS12WITHSHA384KDF", str + "$TLS12withSHA384");
            aVar.h("SecretKeyFactory.TLS12WITHSHA512KDF", str + "$TLS12withSHA512");
        }
    }

    public static final class b extends h {
        public b() {
            super("TLS10KDF");
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof cr.v) {
                return new SecretKeySpec(n0.a((cr.v) keySpec), this.f8862a);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class c extends h {
        public c() {
            super("TLS11KDF");
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof cr.v) {
                return new SecretKeySpec(n0.a((cr.v) keySpec), this.f8862a);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class d extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final org.bouncycastle.crypto.a0 f59613c;

        public d(String str, org.bouncycastle.crypto.a0 a0Var) {
            super(str);
            this.f59613c = a0Var;
        }

        public final byte[] a(cr.v vVar, org.bouncycastle.crypto.a0 a0Var) {
            byte[] bArrB = org.bouncycastle.util.a.B(Strings.i(vVar.a()), vVar.d());
            byte[] bArrC = vVar.c();
            byte[] bArr = new byte[vVar.b()];
            n0.d(a0Var, bArrC, bArrB, bArr);
            return bArr;
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof cr.v) {
                return new SecretKeySpec(a((cr.v) keySpec, this.f59613c), this.f8862a);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class e extends d {
        public e() {
            super("TLS12withSHA256KDF", new ip.k(new zo.e0()));
        }
    }

    public static final class f extends d {
        public f() {
            super("TLS12withSHA384KDF", new ip.k(new zo.f0()));
        }
    }

    public static final class g extends d {
        public g() {
            super("TLS12withSHA512KDF", new ip.k(new zo.h0()));
        }
    }

    public static class h extends ar.d {
        public h(String str) {
            super(str, null);
        }
    }

    public static byte[] a(cr.v vVar) {
        ip.k kVar = new ip.k(org.bouncycastle.crypto.util.f.b());
        ip.k kVar2 = new ip.k(org.bouncycastle.crypto.util.f.c());
        byte[] bArrB = org.bouncycastle.util.a.B(Strings.i(vVar.a()), vVar.d());
        byte[] bArrC = vVar.c();
        int length = (bArrC.length + 1) / 2;
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArrC, 0, bArr, 0, length);
        System.arraycopy(bArrC, bArrC.length - length, bArr2, 0, length);
        int iB = vVar.b();
        byte[] bArr3 = new byte[iB];
        byte[] bArr4 = new byte[iB];
        d(kVar, bArr, bArrB, bArr3);
        d(kVar2, bArr2, bArrB, bArr4);
        for (int i10 = 0; i10 < iB; i10++) {
            bArr3[i10] = (byte) (bArr3[i10] ^ bArr4[i10]);
        }
        return bArr3;
    }

    public static void d(org.bouncycastle.crypto.a0 a0Var, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        a0Var.a(new n1(bArr));
        int iD = a0Var.d();
        int length = ((bArr3.length + iD) - 1) / iD;
        int iD2 = a0Var.d();
        byte[] bArr4 = new byte[iD2];
        byte[] bArr5 = new byte[a0Var.d()];
        byte[] bArr6 = bArr2;
        int i10 = 0;
        while (i10 < length) {
            a0Var.update(bArr6, 0, bArr6.length);
            a0Var.c(bArr4, 0);
            a0Var.update(bArr4, 0, iD2);
            a0Var.update(bArr2, 0, bArr2.length);
            a0Var.c(bArr5, 0);
            int i11 = iD * i10;
            System.arraycopy(bArr5, 0, bArr3, i11, Math.min(iD, bArr3.length - i11));
            i10++;
            bArr6 = bArr4;
        }
    }
}
