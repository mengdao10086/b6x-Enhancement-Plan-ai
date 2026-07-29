package pp;

import cp.t;
import java.security.SecureRandom;
import org.bouncycastle.crypto.a0;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecureRandom f46946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f46947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f46948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f46950e;

    public static class a implements pp.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final org.bouncycastle.crypto.f f46951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f46953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f46954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f46955e;

        public a(org.bouncycastle.crypto.f fVar, int i10, byte[] bArr, byte[] bArr2, int i11) {
            this.f46951a = fVar;
            this.f46952b = i10;
            this.f46953c = bArr;
            this.f46954d = bArr2;
            this.f46955e = i11;
        }

        @Override // pp.b
        public qp.f a(d dVar) {
            return new qp.a(this.f46951a, this.f46952b, this.f46955e, dVar, this.f46954d, this.f46953c);
        }

        @Override // pp.b
        public String getAlgorithm() {
            if (this.f46951a instanceof t) {
                return "CTR-DRBG-3KEY-TDES";
            }
            return "CTR-DRBG-" + this.f46951a.b() + this.f46952b;
        }
    }

    public static class b implements pp.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0 f46956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f46957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f46958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46959d;

        public b(a0 a0Var, byte[] bArr, byte[] bArr2, int i10) {
            this.f46956a = a0Var;
            this.f46957b = bArr;
            this.f46958c = bArr2;
            this.f46959d = i10;
        }

        @Override // pp.b
        public qp.f a(d dVar) {
            return new qp.d(this.f46956a, this.f46959d, dVar, this.f46958c, this.f46957b);
        }

        @Override // pp.b
        public String getAlgorithm() {
            StringBuilder sb2;
            String strB;
            if (this.f46956a instanceof ip.k) {
                sb2 = new StringBuilder();
                sb2.append("HMAC-DRBG-");
                strB = i.e(((ip.k) this.f46956a).f());
            } else {
                sb2 = new StringBuilder();
                sb2.append("HMAC-DRBG-");
                strB = this.f46956a.b();
            }
            sb2.append(strB);
            return sb2.toString();
        }
    }

    public static class c implements pp.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f46960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f46961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f46962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46963d;

        public c(s sVar, byte[] bArr, byte[] bArr2, int i10) {
            this.f46960a = sVar;
            this.f46961b = bArr;
            this.f46962c = bArr2;
            this.f46963d = i10;
        }

        @Override // pp.b
        public qp.f a(d dVar) {
            return new qp.e(this.f46960a, this.f46963d, dVar, this.f46962c, this.f46961b);
        }

        @Override // pp.b
        public String getAlgorithm() {
            return "HASH-DRBG-" + i.e(this.f46960a);
        }
    }

    public i() {
        this(n.f(), false);
    }

    public i(SecureRandom secureRandom, boolean z10) {
        this.f46949d = 256;
        this.f46950e = 256;
        this.f46946a = secureRandom;
        this.f46947b = new pp.a(secureRandom, z10);
    }

    public i(e eVar) {
        this.f46949d = 256;
        this.f46950e = 256;
        this.f46946a = null;
        this.f46947b = eVar;
    }

    public static String e(s sVar) {
        String strB = sVar.b();
        int iIndexOf = strB.indexOf(45);
        if (iIndexOf <= 0 || strB.startsWith("SHA3")) {
            return strB;
        }
        return strB.substring(0, iIndexOf) + strB.substring(iIndexOf + 1);
    }

    public SP800SecureRandom b(org.bouncycastle.crypto.f fVar, int i10, byte[] bArr, boolean z10) {
        return new SP800SecureRandom(this.f46946a, this.f46947b.get(this.f46950e), new a(fVar, i10, bArr, this.f46948c, this.f46949d), z10);
    }

    public SP800SecureRandom c(a0 a0Var, byte[] bArr, boolean z10) {
        return new SP800SecureRandom(this.f46946a, this.f46947b.get(this.f46950e), new b(a0Var, bArr, this.f46948c, this.f46949d), z10);
    }

    public SP800SecureRandom d(s sVar, byte[] bArr, boolean z10) {
        return new SP800SecureRandom(this.f46946a, this.f46947b.get(this.f46950e), new c(sVar, bArr, this.f46948c, this.f46949d), z10);
    }

    public i f(int i10) {
        this.f46950e = i10;
        return this;
    }

    public i g(byte[] bArr) {
        this.f46948c = org.bouncycastle.util.a.p(bArr);
        return this;
    }

    public i h(int i10) {
        this.f46949d = i10;
        return this;
    }
}
