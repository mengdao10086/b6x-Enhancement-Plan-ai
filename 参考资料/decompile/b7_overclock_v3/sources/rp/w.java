package rp;

import cp.x0;
import gm.d2;
import java.io.IOException;
import java.util.Hashtable;
import np.w1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.e0;
import zn.z1;

/* JADX INFO: loaded from: classes5.dex */
public class w implements e0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Hashtable f49101k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.b f49102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zn.b f49103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f49104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f49105j;

    static {
        Hashtable hashtable = new Hashtable();
        f49101k = hashtable;
        hashtable.put("RIPEMD128", tn.b.f51361c);
        hashtable.put("RIPEMD160", tn.b.f51360b);
        hashtable.put("RIPEMD256", tn.b.f51362d);
        hashtable.put(et.e.f27137f, z1.f59121o7);
        hashtable.put(et.e.f27138g, kn.d.f37598f);
        hashtable.put("SHA-256", kn.d.f37592c);
        hashtable.put(et.e.f27140i, kn.d.f37594d);
        hashtable.put("SHA-512", kn.d.f37596e);
        hashtable.put("SHA-512/224", kn.d.f37600g);
        hashtable.put(rs.h.f49168c, kn.d.f37602h);
        hashtable.put("SHA3-224", kn.d.f37604i);
        hashtable.put("SHA3-256", kn.d.f37606j);
        hashtable.put("SHA3-384", kn.d.f37608k);
        hashtable.put("SHA3-512", kn.d.f37610l);
        hashtable.put("MD2", pn.s.f46797d4);
        hashtable.put("MD4", pn.s.f46800e4);
        hashtable.put("MD5", pn.s.f46803f4);
    }

    public w(org.bouncycastle.crypto.s sVar) {
        this(sVar, (gm.y) f49101k.get(sVar.b()));
    }

    public w(org.bouncycastle.crypto.s sVar, gm.y yVar) {
        this.f49102g = new bp.c(new x0());
        this.f49104i = sVar;
        this.f49103h = yVar != null ? new zn.b(yVar, d2.f29657b) : null;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49105j = z10;
        np.c cVar = kVar instanceof w1 ? (np.c) ((w1) kVar).a() : (np.c) kVar;
        if (z10 && !cVar.c()) {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!z10 && cVar.c()) {
            throw new IllegalArgumentException("verification requires public key");
        }
        reset();
        this.f49102g.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        byte[] bArrC;
        byte[] bArrG;
        if (this.f49105j) {
            throw new IllegalStateException("RSADigestSigner not initialised for verification");
        }
        int iH = this.f49104i.h();
        byte[] bArr2 = new byte[iH];
        this.f49104i.c(bArr2, 0);
        try {
            bArrC = this.f49102g.c(bArr, 0, bArr.length);
            bArrG = g(bArr2);
        } catch (Exception unused) {
        }
        if (bArrC.length == bArrG.length) {
            return org.bouncycastle.util.a.I(bArrC, bArrG);
        }
        if (bArrC.length != bArrG.length - 2) {
            org.bouncycastle.util.a.I(bArrG, bArrG);
            return false;
        }
        int length = (bArrC.length - iH) - 2;
        int length2 = (bArrG.length - iH) - 2;
        bArrG[1] = (byte) (bArrG[1] - 2);
        bArrG[3] = (byte) (bArrG[3] - 2);
        int i10 = 0;
        for (int i11 = 0; i11 < iH; i11++) {
            i10 |= bArrC[length + i11] ^ bArrG[length2 + i11];
        }
        for (int i12 = 0; i12 < length; i12++) {
            i10 |= bArrC[i12] ^ bArrG[i12];
        }
        return i10 == 0;
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws DataLengthException, CryptoException {
        if (!this.f49105j) {
            throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[this.f49104i.h()];
        this.f49104i.c(bArr, 0);
        try {
            byte[] bArrG = g(bArr);
            return this.f49102g.c(bArrG, 0, bArrG.length);
        } catch (IOException e10) {
            throw new CryptoException("unable to encode signature: " + e10.getMessage(), e10);
        }
    }

    public final byte[] g(byte[] bArr) throws IOException {
        zn.b bVar = this.f49103h;
        if (bVar != null) {
            return new zn.t(bVar, bArr).v(gm.j.f29713a);
        }
        try {
            zn.t.A(bArr);
            return bArr;
        } catch (IllegalArgumentException e10) {
            throw new IOException("malformed DigestInfo for NONEwithRSA hash: " + e10.getMessage());
        }
    }

    public String h() {
        return this.f49104i.b() + "withRSA";
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49104i.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49104i.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49104i.update(bArr, i10, i11);
    }
}
