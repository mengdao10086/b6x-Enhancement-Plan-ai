package ip;

import java.util.Hashtable;
import np.n1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class k implements a0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f35520h = 54;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f35521i = 92;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Hashtable f35522j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f35523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.util.m f35526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.util.m f35527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f35528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f35529g;

    static {
        Hashtable hashtable = new Hashtable();
        f35522j = hashtable;
        hashtable.put("GOST3411", org.bouncycastle.util.j.g(32));
        f35522j.put("MD2", org.bouncycastle.util.j.g(16));
        f35522j.put("MD4", org.bouncycastle.util.j.g(64));
        f35522j.put("MD5", org.bouncycastle.util.j.g(64));
        f35522j.put("RIPEMD128", org.bouncycastle.util.j.g(64));
        f35522j.put("RIPEMD160", org.bouncycastle.util.j.g(64));
        f35522j.put(et.e.f27137f, org.bouncycastle.util.j.g(64));
        f35522j.put(et.e.f27138g, org.bouncycastle.util.j.g(64));
        f35522j.put("SHA-256", org.bouncycastle.util.j.g(64));
        f35522j.put(et.e.f27140i, org.bouncycastle.util.j.g(128));
        f35522j.put("SHA-512", org.bouncycastle.util.j.g(128));
        f35522j.put("Tiger", org.bouncycastle.util.j.g(64));
        f35522j.put("Whirlpool", org.bouncycastle.util.j.g(64));
    }

    public k(org.bouncycastle.crypto.s sVar) {
        this(sVar, e(sVar));
    }

    public k(org.bouncycastle.crypto.s sVar, int i10) {
        this.f35523a = sVar;
        int iH = sVar.h();
        this.f35524b = iH;
        this.f35525c = i10;
        this.f35528f = new byte[i10];
        this.f35529g = new byte[i10 + iH];
    }

    public static int e(org.bouncycastle.crypto.s sVar) {
        if (sVar instanceof org.bouncycastle.crypto.v) {
            return ((org.bouncycastle.crypto.v) sVar).g();
        }
        Integer num = (Integer) f35522j.get(sVar.b());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + sVar.b());
    }

    public static void g(byte[] bArr, int i10, byte b10) {
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) (bArr[i11] ^ b10);
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        byte[] bArr;
        this.f35523a.reset();
        byte[] bArrA = ((n1) kVar).a();
        int length = bArrA.length;
        if (length > this.f35525c) {
            this.f35523a.update(bArrA, 0, length);
            this.f35523a.c(this.f35528f, 0);
            length = this.f35524b;
        } else {
            System.arraycopy(bArrA, 0, this.f35528f, 0, length);
        }
        while (true) {
            bArr = this.f35528f;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.f35529g, 0, this.f35525c);
        g(this.f35528f, this.f35525c, (byte) 54);
        g(this.f35529g, this.f35525c, (byte) 92);
        org.bouncycastle.crypto.s sVar = this.f35523a;
        if (sVar instanceof org.bouncycastle.util.m) {
            org.bouncycastle.util.m mVarD = ((org.bouncycastle.util.m) sVar).d();
            this.f35527e = mVarD;
            ((org.bouncycastle.crypto.s) mVarD).update(this.f35529g, 0, this.f35525c);
        }
        org.bouncycastle.crypto.s sVar2 = this.f35523a;
        byte[] bArr2 = this.f35528f;
        sVar2.update(bArr2, 0, bArr2.length);
        org.bouncycastle.crypto.s sVar3 = this.f35523a;
        if (sVar3 instanceof org.bouncycastle.util.m) {
            this.f35526d = ((org.bouncycastle.util.m) sVar3).d();
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35523a.b() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        this.f35523a.c(this.f35529g, this.f35525c);
        org.bouncycastle.util.m mVar = this.f35527e;
        if (mVar != null) {
            ((org.bouncycastle.util.m) this.f35523a).i(mVar);
            org.bouncycastle.crypto.s sVar = this.f35523a;
            sVar.update(this.f35529g, this.f35525c, sVar.h());
        } else {
            org.bouncycastle.crypto.s sVar2 = this.f35523a;
            byte[] bArr2 = this.f35529g;
            sVar2.update(bArr2, 0, bArr2.length);
        }
        int iC = this.f35523a.c(bArr, i10);
        int i11 = this.f35525c;
        while (true) {
            byte[] bArr3 = this.f35529g;
            if (i11 >= bArr3.length) {
                break;
            }
            bArr3[i11] = 0;
            i11++;
        }
        org.bouncycastle.util.m mVar2 = this.f35526d;
        if (mVar2 != null) {
            ((org.bouncycastle.util.m) this.f35523a).i(mVar2);
        } else {
            org.bouncycastle.crypto.s sVar3 = this.f35523a;
            byte[] bArr4 = this.f35528f;
            sVar3.update(bArr4, 0, bArr4.length);
        }
        return iC;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35524b;
    }

    public org.bouncycastle.crypto.s f() {
        return this.f35523a;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35523a.reset();
        org.bouncycastle.crypto.s sVar = this.f35523a;
        byte[] bArr = this.f35528f;
        sVar.update(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        this.f35523a.update(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        this.f35523a.update(bArr, i10, i11);
    }
}
