package rb;

import com.google.android.exoplayer2.Format;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f48317g = "Id3Reader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.c0 f48318a = new hd.c0(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hb.d0 f48319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f48321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f48322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f48323f;

    @Override // rb.m
    public void a() {
        this.f48320c = false;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        hd.a.k(this.f48319b);
        if (this.f48320c) {
            int iA = c0Var.a();
            int i10 = this.f48323f;
            if (i10 < 10) {
                int iMin = Math.min(iA, 10 - i10);
                System.arraycopy(c0Var.d(), c0Var.e(), this.f48318a.d(), this.f48323f, iMin);
                if (this.f48323f + iMin == 10) {
                    this.f48318a.S(0);
                    if (73 != this.f48318a.G() || 68 != this.f48318a.G() || 51 != this.f48318a.G()) {
                        hd.t.n(f48317g, "Discarding invalid ID3 tag");
                        this.f48320c = false;
                        return;
                    } else {
                        this.f48318a.T(3);
                        this.f48322e = this.f48318a.F() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f48322e - this.f48323f);
            this.f48319b.d(c0Var, iMin2);
            this.f48323f += iMin2;
        }
    }

    @Override // rb.m
    public void d() {
        int i10;
        hd.a.k(this.f48319b);
        if (this.f48320c && (i10 = this.f48322e) != 0 && this.f48323f == i10) {
            this.f48319b.a(this.f48321d, 1, i10, 0, null);
            this.f48320c = false;
        }
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        eVar.a();
        hb.d0 d0VarD = mVar.d(eVar.c(), 5);
        this.f48319b = d0VarD;
        d0VarD.f(new Format.b().S(eVar.b()).e0(hd.w.f31193k0).E());
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.f48320c = true;
        this.f48321d = j10;
        this.f48322e = 0;
        this.f48323f = 0;
    }
}
