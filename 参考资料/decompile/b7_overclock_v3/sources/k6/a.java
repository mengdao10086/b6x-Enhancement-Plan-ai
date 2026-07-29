package k6;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends gg.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f36993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f36994i;

    public a(int i10) {
        super(i10);
        this.f36993h = false;
        this.f36994i = 10;
    }

    public hg.a C(int i10) {
        return n() == 0 ? new hg.b(10, i10) : new hg.c(10, i10, false);
    }

    public hg.a D(int i10, byte[] bArr) {
        return n() == 0 ? new hg.b(10, i10, bArr) : new hg.c(10, i10, bArr, false);
    }
}
