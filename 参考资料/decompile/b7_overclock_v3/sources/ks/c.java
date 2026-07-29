package ks;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class c implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f39113u = "1.3.6.1.4.1.8301.3.1.3.3";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ls.a f39114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f39115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[][] f39116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[][] f39117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[][] f39118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f39119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f39120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f39121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f39122o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f39123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f39124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f39125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f39126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f39127t;

    public c(a aVar) {
        this.f39119l = aVar;
        s sVar = aVar.get();
        this.f39115h = sVar;
        this.f39120m = sVar.h();
        this.f39114g = new ls.a(this.f39115h);
    }

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        g(yVar);
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        return c();
    }

    public final org.bouncycastle.crypto.c c() {
        int i10;
        int i11;
        if (!this.f39122o) {
            h();
        }
        int i12 = this.f39121n;
        byte[][][] bArr = new byte[i12][][];
        byte[][][] bArr2 = new byte[i12 - 1][][];
        n[][] nVarArr = new n[i12][];
        n[][] nVarArr2 = new n[i12 - 1][];
        Vector[] vectorArr = new Vector[i12];
        Vector[] vectorArr2 = new Vector[i12 - 1];
        Vector[][] vectorArr3 = new Vector[i12][];
        int i13 = 1;
        Vector[][] vectorArr4 = new Vector[i12 - 1][];
        int i14 = 0;
        while (true) {
            i10 = this.f39121n;
            if (i14 >= i10) {
                break;
            }
            Vector[][] vectorArr5 = vectorArr4;
            bArr[i14] = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39124q[i14], this.f39120m);
            int[] iArr = this.f39124q;
            nVarArr[i14] = new n[iArr[i14] - this.f39126s[i14]];
            if (i14 > 0) {
                int i15 = i14 - 1;
                bArr2[i15] = (byte[][]) Array.newInstance((Class<?>) byte.class, iArr[i14], this.f39120m);
                nVarArr2[i15] = new n[this.f39124q[i14] - this.f39126s[i14]];
            }
            vectorArr[i14] = new Vector();
            if (i14 > 0) {
                vectorArr2[i14 - 1] = new Vector();
            }
            i14++;
            vectorArr4 = vectorArr5;
        }
        Vector[][] vectorArr6 = vectorArr4;
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) byte.class, i10, this.f39120m);
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39121n - 1, this.f39120m);
        byte[][] bArr5 = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39121n, this.f39120m);
        int i16 = 0;
        while (true) {
            i11 = this.f39121n;
            if (i16 >= i11) {
                break;
            }
            System.arraycopy(this.f39116i[i16], 0, bArr5[i16], 0, this.f39120m);
            i16++;
            i13 = 1;
        }
        int[] iArr2 = new int[2];
        iArr2[i13] = this.f39120m;
        iArr2[0] = i11 - i13;
        this.f39118k = (byte[][]) Array.newInstance((Class<?>) byte.class, iArr2);
        int i17 = this.f39121n - i13;
        while (i17 >= 0) {
            i iVarD = i17 == this.f39121n - i13 ? d(null, vectorArr[i17], bArr5[i17], i17) : d(bArr3[i17 + 1], vectorArr[i17], bArr5[i17], i17);
            for (int i18 = 0; i18 < this.f39124q[i17]; i18++) {
                System.arraycopy(iVarD.a()[i18], 0, bArr[i17][i18], 0, this.f39120m);
            }
            vectorArr3[i17] = iVarD.b();
            nVarArr[i17] = iVarD.g();
            System.arraycopy(iVarD.c(), 0, bArr3[i17], 0, this.f39120m);
            i17--;
            i13 = 1;
        }
        int i19 = this.f39121n - 2;
        while (i19 >= 0) {
            int i20 = i19 + 1;
            i iVarE = e(vectorArr2[i19], bArr5[i20], i20);
            int i21 = 0;
            while (i21 < this.f39124q[i20]) {
                System.arraycopy(iVarE.a()[i21], 0, bArr2[i19][i21], 0, this.f39120m);
                i21++;
                vectorArr3 = vectorArr3;
            }
            vectorArr6[i19] = iVarE.b();
            nVarArr2[i19] = iVarE.g();
            System.arraycopy(iVarE.c(), 0, bArr4[i19], 0, this.f39120m);
            System.arraycopy(bArr5[i20], 0, this.f39117j[i19], 0, this.f39120m);
            i19--;
            vectorArr3 = vectorArr3;
        }
        return new org.bouncycastle.crypto.c((np.c) new h(bArr3[0], this.f39123p), (np.c) new g(this.f39116i, this.f39117j, bArr, bArr2, nVarArr, nVarArr2, vectorArr, vectorArr2, vectorArr3, vectorArr6, bArr4, this.f39118k, this.f39123p, this.f39119l));
    }

    public final i d(byte[] bArr, Vector vector, byte[] bArr2, int i10) {
        byte[] bArrA;
        int i11 = this.f39120m;
        byte[] bArr3 = new byte[i11];
        byte[] bArr4 = new byte[i11];
        byte[] bArrC = this.f39114g.c(bArr2);
        i iVar = new i(this.f39124q[i10], this.f39126s[i10], this.f39119l);
        iVar.h(vector);
        if (i10 == this.f39121n - 1) {
            bArrA = new ls.d(bArrC, this.f39119l.get(), this.f39125r[i10]).c();
        } else {
            this.f39118k[i10] = new ls.d(bArrC, this.f39119l.get(), this.f39125r[i10]).d(bArr);
            bArrA = new ls.c(this.f39119l.get(), this.f39125r[i10]).a(bArr, this.f39118k[i10]);
        }
        iVar.j(bArrA);
        int i12 = 3;
        int i13 = 0;
        int i14 = 1;
        while (true) {
            int[] iArr = this.f39124q;
            if (i14 >= (1 << iArr[i10])) {
                break;
            }
            if (i14 == i12 && i13 < iArr[i10] - this.f39126s[i10]) {
                iVar.i(bArr2, i13);
                i12 *= 2;
                i13++;
            }
            iVar.j(new ls.d(this.f39114g.c(bArr2), this.f39119l.get(), this.f39125r[i10]).c());
            i14++;
        }
        if (iVar.l()) {
            return iVar;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    public final i e(Vector vector, byte[] bArr, int i10) {
        byte[] bArr2 = new byte[this.f39121n];
        i iVar = new i(this.f39124q[i10], this.f39126s[i10], this.f39119l);
        iVar.h(vector);
        int i11 = 0;
        int i12 = 0;
        int i13 = 3;
        while (true) {
            int[] iArr = this.f39124q;
            if (i11 >= (1 << iArr[i10])) {
                break;
            }
            if (i11 == i13 && i12 < iArr[i10] - this.f39126s[i10]) {
                iVar.i(bArr, i12);
                i13 *= 2;
                i12++;
            }
            iVar.j(new ls.d(this.f39114g.c(bArr), this.f39119l.get(), this.f39125r[i10]).c());
            i11++;
        }
        if (iVar.l()) {
            return iVar;
        }
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    public void f(int i10, SecureRandom secureRandom) {
        b bVar;
        if (i10 <= 10) {
            bVar = new b(secureRandom, new f(1, new int[]{10}, new int[]{3}, new int[]{2}));
        } else {
            bVar = i10 <= 20 ? new b(secureRandom, new f(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2})) : new b(secureRandom, new f(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
        }
        g(bVar);
    }

    public void g(y yVar) {
        b bVar = (b) yVar;
        this.f39127t = bVar;
        f fVar = new f(bVar.c().c(), this.f39127t.c().a(), this.f39127t.c().d(), this.f39127t.c().b());
        this.f39123p = fVar;
        this.f39121n = fVar.c();
        this.f39124q = this.f39123p.a();
        this.f39125r = this.f39123p.d();
        this.f39126s = this.f39123p.b();
        this.f39116i = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39121n, this.f39120m);
        this.f39117j = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39121n - 1, this.f39120m);
        SecureRandom secureRandomA = yVar.a();
        for (int i10 = 0; i10 < this.f39121n; i10++) {
            secureRandomA.nextBytes(this.f39116i[i10]);
            this.f39114g.c(this.f39116i[i10]);
        }
        this.f39122o = true;
    }

    public final void h() {
        g(new b(null, new f(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }
}
