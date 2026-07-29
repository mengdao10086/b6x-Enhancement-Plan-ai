package pp;

/* JADX INFO: loaded from: classes5.dex */
public class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f46943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f46944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f46945c;

    public h(g gVar, int i10) {
        if (gVar == null) {
            throw new IllegalArgumentException("generator cannot be null");
        }
        if (i10 < 2) {
            throw new IllegalArgumentException("windowSize must be at least 2");
        }
        this.f46943a = gVar;
        this.f46944b = new byte[i10];
    }

    @Override // pp.g
    public void a(byte[] bArr, int i10, int i11) {
        e(bArr, i10, i11);
    }

    @Override // pp.g
    public void b(long j10) {
        synchronized (this) {
            this.f46945c = 0;
            this.f46943a.b(j10);
        }
    }

    @Override // pp.g
    public void c(byte[] bArr) {
        synchronized (this) {
            this.f46945c = 0;
            this.f46943a.c(bArr);
        }
    }

    @Override // pp.g
    public void d(byte[] bArr) {
        e(bArr, 0, bArr.length);
    }

    public final void e(byte[] bArr, int i10, int i11) {
        synchronized (this) {
            for (int i12 = 0; i12 < i11; i12++) {
                if (this.f46945c < 1) {
                    g gVar = this.f46943a;
                    byte[] bArr2 = this.f46944b;
                    gVar.a(bArr2, 0, bArr2.length);
                    this.f46945c = this.f46944b.length;
                }
                byte[] bArr3 = this.f46944b;
                int i13 = this.f46945c - 1;
                this.f46945c = i13;
                bArr[i12 + i10] = bArr3[i13];
            }
        }
    }
}
