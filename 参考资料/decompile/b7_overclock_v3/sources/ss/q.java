package ss;

/* JADX INFO: loaded from: classes6.dex */
public class q extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f50502c;

    public q(o oVar, f fVar) {
        super(false, oVar);
        this.f50502c = fVar;
    }

    public q(o oVar, byte[] bArr) {
        super(false, oVar);
        int i10 = oVar.a().f50451b;
        int i11 = i10 * 2;
        if (bArr.length != i11) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.f50502c = new f(org.bouncycastle.util.a.W(bArr, 0, i10), org.bouncycastle.util.a.W(bArr, i10, i11));
    }

    public byte[] e() {
        return org.bouncycastle.util.a.p(this.f50502c.f50440b);
    }

    public byte[] f() {
        return org.bouncycastle.util.a.p(this.f50502c.f50439a);
    }

    public byte[] getEncoded() {
        f fVar = this.f50502c;
        return org.bouncycastle.util.a.B(fVar.f50439a, fVar.f50440b);
    }
}
