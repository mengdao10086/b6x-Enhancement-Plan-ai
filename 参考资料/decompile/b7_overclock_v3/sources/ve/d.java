package ve;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f53127c;

    public d(e eVar) {
        super(eVar.e(), eVar.b());
        this.f53127c = eVar;
    }

    @Override // ve.e
    public e a(int i10, int i11, int i12, int i13) {
        return new d(this.f53127c.a(i10, i11, i12, i13));
    }

    @Override // ve.e
    public byte[] c() {
        byte[] bArrC = this.f53127c.c();
        int iE = e() * b();
        byte[] bArr = new byte[iE];
        for (int i10 = 0; i10 < iE; i10++) {
            bArr[i10] = (byte) (255 - (bArrC[i10] & 255));
        }
        return bArr;
    }

    @Override // ve.e
    public byte[] d(int i10, byte[] bArr) {
        byte[] bArrD = this.f53127c.d(i10, bArr);
        int iE = e();
        for (int i11 = 0; i11 < iE; i11++) {
            bArrD[i11] = (byte) (255 - (bArrD[i11] & 255));
        }
        return bArrD;
    }

    @Override // ve.e
    public e f() {
        return this.f53127c;
    }

    @Override // ve.e
    public boolean g() {
        return this.f53127c.g();
    }

    @Override // ve.e
    public boolean h() {
        return this.f53127c.h();
    }

    @Override // ve.e
    public e i() {
        return new d(this.f53127c.i());
    }

    @Override // ve.e
    public e j() {
        return new d(this.f53127c.j());
    }
}
