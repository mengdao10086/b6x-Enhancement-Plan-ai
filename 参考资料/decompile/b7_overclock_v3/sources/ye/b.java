package ye;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57307d;

    public b(g gVar, int i10, int i11) {
        super(gVar);
        this.f57306c = i10;
        this.f57307d = i11;
    }

    @Override // ye.g
    public void c(af.a aVar, byte[] bArr) {
        int i10 = this.f57307d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 == 0 || (i11 == 31 && i10 <= 62)) {
                aVar.c(31, 5);
                if (i10 > 62) {
                    aVar.c(i10 - 31, 16);
                } else if (i11 == 0) {
                    aVar.c(Math.min(i10, 31), 5);
                } else {
                    aVar.c(i10 - 31, 5);
                }
            }
            aVar.c(bArr[this.f57306c + i11], 8);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f57306c);
        sb2.append("::");
        sb2.append((this.f57306c + this.f57307d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}
