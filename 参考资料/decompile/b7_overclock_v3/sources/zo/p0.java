package zo;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class p0 implements org.bouncycastle.crypto.m0, org.bouncycastle.crypto.s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f59425e = Strings.i("TupleHash");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f59426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f59427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f59428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f59429d;

    public p0(int i10, byte[] bArr) {
        this(i10, bArr, i10 * 2);
    }

    public p0(int i10, byte[] bArr, int i11) {
        this.f59426a = new e(i10, f59425e, bArr);
        this.f59427b = i10;
        this.f59428c = (i11 + 7) / 8;
        reset();
    }

    public p0(p0 p0Var) {
        e eVar = new e(p0Var.f59426a);
        this.f59426a = eVar;
        int i10 = eVar.f59435e;
        this.f59427b = i10;
        this.f59428c = (i10 * 2) / 8;
        this.f59429d = p0Var.f59429d;
    }

    public final void a(int i10) {
        byte[] bArrD = r0.d(((long) i10) * 8);
        this.f59426a.update(bArrD, 0, bArrD.length);
        this.f59429d = false;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "TupleHash" + this.f59426a.b().substring(6);
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        if (this.f59429d) {
            a(h());
        }
        int iF = this.f59426a.f(bArr, i10, h());
        reset();
        return iF;
    }

    @Override // org.bouncycastle.crypto.m0
    public int e(byte[] bArr, int i10, int i11) {
        if (this.f59429d) {
            a(0);
        }
        return this.f59426a.e(bArr, i10, i11);
    }

    @Override // org.bouncycastle.crypto.m0
    public int f(byte[] bArr, int i10, int i11) {
        if (this.f59429d) {
            a(h());
        }
        int iF = this.f59426a.f(bArr, i10, i11);
        reset();
        return iF;
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f59426a.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59428c;
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59426a.reset();
        this.f59429d = true;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) throws IllegalStateException {
        byte[] bArrA = r0.a(b10);
        this.f59426a.update(bArrA, 0, bArrA.length);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        byte[] bArrB = r0.b(bArr, i10, i11);
        this.f59426a.update(bArrB, 0, bArrB.length);
    }
}
