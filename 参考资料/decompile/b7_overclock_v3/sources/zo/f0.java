package zo;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends r {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f59288q = 48;

    public f0() {
    }

    public f0(f0 f0Var) {
        super(f0Var);
    }

    public f0(byte[] bArr) {
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
        return et.e.f27140i;
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
        reset();
        return 48;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new f0(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 48;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        super.r((f0) mVar);
    }

    @Override // zo.r, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59467e = -3766243637369397544L;
        this.f59468f = 7105036623409894663L;
        this.f59469g = -7973340178411365097L;
        this.f59470h = 1526699215303891257L;
        this.f59471i = 7436329637833083697L;
        this.f59472j = -8163818279084223215L;
        this.f59473k = -2662702644619276377L;
        this.f59474l = 5167115440072839076L;
    }
}
