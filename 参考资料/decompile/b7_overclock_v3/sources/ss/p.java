package ss;

/* JADX INFO: loaded from: classes6.dex */
public class p extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f50500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f50501d;

    public p(o oVar, j jVar, f fVar) {
        super(true, oVar);
        this.f50500c = jVar;
        this.f50501d = fVar;
    }

    public p(o oVar, byte[] bArr) {
        super(true, oVar);
        int i10 = oVar.a().f50451b;
        int i11 = i10 * 4;
        if (bArr.length != i11) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i12 = i10 * 2;
        this.f50500c = new j(org.bouncycastle.util.a.W(bArr, 0, i10), org.bouncycastle.util.a.W(bArr, i10, i12));
        int i13 = i10 * 3;
        this.f50501d = new f(org.bouncycastle.util.a.W(bArr, i12, i13), org.bouncycastle.util.a.W(bArr, i13, i11));
    }

    public byte[] e() {
        return org.bouncycastle.util.a.p(this.f50500c.f50449b);
    }

    public byte[] f() {
        f fVar = this.f50501d;
        return org.bouncycastle.util.a.B(fVar.f50439a, fVar.f50440b);
    }

    public byte[] g() {
        return org.bouncycastle.util.a.p(this.f50501d.f50439a);
    }

    public byte[] getEncoded() {
        j jVar = this.f50500c;
        byte[] bArr = jVar.f50448a;
        byte[] bArr2 = jVar.f50449b;
        f fVar = this.f50501d;
        return org.bouncycastle.util.a.D(bArr, bArr2, fVar.f50439a, fVar.f50440b);
    }

    public byte[] h() {
        return org.bouncycastle.util.a.p(this.f50500c.f50448a);
    }
}
