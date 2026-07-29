package k6;

import android.os.Handler;

/* JADX INFO: loaded from: classes7.dex */
public class h extends k6.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f37031p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f37032q = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f37033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f37034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f37035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f37036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f37037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f37038o;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f37037n) {
                h.this.G();
            }
        }
    }

    public interface b {
        boolean a(byte[] bArr);

        void b();

        void d(int i10);
    }

    public h(b bVar, int i10) {
        super(i10);
        this.f37033j = new Handler();
        this.f37034k = "ProximityGaiaManager";
        this.f37036m = new a();
        this.f37037n = false;
        this.f37038o = false;
        this.f37035l = bVar;
    }

    public final void G() {
        if (this.f37038o) {
            return;
        }
        this.f37038o = true;
        l(C(gg.b.f29459l1));
    }

    public void H(boolean z10) {
        if (z10 && !this.f37037n) {
            this.f37037n = true;
            G();
        } else {
            if (z10 || !this.f37037n) {
                return;
            }
            this.f37037n = false;
            this.f37038o = false;
            this.f37033j.removeCallbacks(this.f37036m);
        }
    }

    public final void I(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37035l.d(bArrH[1]);
            if (this.f37037n && this.f37038o) {
                this.f37038o = false;
                this.f37033j.postDelayed(this.f37036m, 1000L);
            }
        }
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
        if (aVar.e() == 769) {
            I(aVar);
        }
    }

    @Override // gg.c
    public void u(hg.a aVar) {
        if (aVar.e() == 769) {
            this.f37035l.b();
            this.f37037n = false;
        }
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37035l.a(bArr);
    }
}
