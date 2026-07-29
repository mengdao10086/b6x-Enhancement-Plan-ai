package zo;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends r {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f59309q = 64;

    public h0() {
    }

    public h0(h0 h0Var) {
        super(h0Var);
    }

    public h0(byte[] bArr) {
        y(bArr);
    }

    @Override // zo.g
    public byte[] a() {
        byte[] bArr = new byte[t()];
        super.u(bArr);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "SHA-512";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        s();
        org.bouncycastle.util.o.z(this.f59467e, bArr, i10);
        org.bouncycastle.util.o.z(this.f59468f, bArr, i10 + 8);
        org.bouncycastle.util.o.z(this.f59469g, bArr, i10 + 16);
        org.bouncycastle.util.o.z(this.f59470h, bArr, i10 + 24);
        org.bouncycastle.util.o.z(this.f59471i, bArr, i10 + 32);
        org.bouncycastle.util.o.z(this.f59472j, bArr, i10 + 40);
        org.bouncycastle.util.o.z(this.f59473k, bArr, i10 + 48);
        org.bouncycastle.util.o.z(this.f59474l, bArr, i10 + 56);
        reset();
        return 64;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new h0(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 64;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        r((h0) mVar);
    }

    @Override // zo.r, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59467e = 7640891576956012808L;
        this.f59468f = -4942790177534073029L;
        this.f59469g = 4354685564936845355L;
        this.f59470h = -6534734903238641935L;
        this.f59471i = 5840696475078001361L;
        this.f59472j = -7276294671716946913L;
        this.f59473k = 2270897969802886507L;
        this.f59474l = 6620516959819538809L;
    }
}
