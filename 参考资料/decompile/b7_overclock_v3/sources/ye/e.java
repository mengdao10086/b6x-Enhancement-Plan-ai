package ye;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f57325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final short f57326d;

    public e(g gVar, int i10, int i11) {
        super(gVar);
        this.f57325c = (short) i10;
        this.f57326d = (short) i11;
    }

    @Override // ye.g
    public void c(af.a aVar, byte[] bArr) {
        aVar.c(this.f57325c, this.f57326d);
    }

    public String toString() {
        short s10 = this.f57325c;
        short s11 = this.f57326d;
        return '<' + Integer.toBinaryString((s10 & ((1 << s11) - 1)) | (1 << s11) | (1 << this.f57326d)).substring(1) + '>';
    }
}
