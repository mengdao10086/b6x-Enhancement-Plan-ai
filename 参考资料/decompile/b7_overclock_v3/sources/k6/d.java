package k6;

/* JADX INFO: loaded from: classes7.dex */
public class d extends k6.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f37011l = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f37012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f37013k;

    public interface a {
        boolean a(byte[] bArr);

        void b();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f37014a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final byte f37015b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final byte f37016c = 2;
    }

    public d(a aVar, int i10) {
        super(i10);
        this.f37012j = "FindMeGaiaManager";
        this.f37013k = aVar;
    }

    public void E(byte b10) {
        l(D(gg.b.f29423c1, new byte[]{b10}));
    }

    @Override // gg.c
    public void o(hg.a aVar) {
    }

    @Override // gg.c
    public boolean p(hg.a aVar) {
        return false;
    }

    @Override // gg.c
    public void r(hg.a aVar) {
    }

    @Override // gg.c
    public void t(hg.a aVar) {
    }

    @Override // gg.c
    public void u(hg.a aVar) {
        if (aVar.e() == 555) {
            this.f37013k.b();
        }
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37013k.a(bArr);
    }
}
