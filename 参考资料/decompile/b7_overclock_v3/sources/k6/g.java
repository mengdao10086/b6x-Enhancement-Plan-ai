package k6;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.qualcomm.qti.libraries.gaia.GaiaException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public class g extends k6.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f37019o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f37020p = 5000;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte[] f37021q = {1};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f37022r = {0};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final androidx.collection.a<Integer, Boolean> f37023s = new androidx.collection.a<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f37024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f37025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f37026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f37027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Runnable f37028n;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {
        public static final int T2 = 1;
        public static final int U2 = 2;
        public static final int V2 = 3;
        public static final int W2 = 4;
        public static final int X2 = 5;
        public static final int Y2 = 6;
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface b {
        public static final int Z2 = 0;

        /* JADX INFO: renamed from: a3, reason: collision with root package name */
        public static final int f37029a3 = 1;

        /* JADX INFO: renamed from: b3, reason: collision with root package name */
        public static final int f37030b3 = 2;
    }

    public interface c {
        void K0(String str, String str2);

        void U0();

        boolean a(byte[] bArr);

        void a0(String str);

        void d(int i10);

        void f1(String str);

        void l0(int i10);

        void n(int i10);

        void r(boolean z10);

        void s(boolean z10);

        void v0(int i10);

        void w0();
    }

    public g(c cVar, int i10) {
        super(i10);
        this.f37024j = new Handler();
        this.f37025k = "MainGaiaManager";
        this.f37027m = new Runnable() { // from class: k6.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f37017a.L();
            }
        };
        this.f37028n = new Runnable() { // from class: k6.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f37018a.M();
            }
        };
        this.f37026l = cVar;
        z(5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        androidx.collection.a<Integer, Boolean> aVar = f37023s;
        synchronized (aVar) {
            if (aVar.containsKey(1)) {
                aVar.put(1, Boolean.TRUE);
                I(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        androidx.collection.a<Integer, Boolean> aVar = f37023s;
        synchronized (aVar) {
            if (aVar.containsKey(2)) {
                aVar.put(2, Boolean.TRUE);
                I(2);
            }
        }
    }

    public final void G(int i10) {
        try {
            l(hg.a.b(10, 16386, i10, null, n()));
        } catch (GaiaException e10) {
            e10.getMessage();
        }
    }

    public final void H(boolean z10) {
        androidx.collection.a<Integer, Boolean> aVar = f37023s;
        synchronized (aVar) {
            try {
                if (z10) {
                    U(9);
                    aVar.put(1, Boolean.TRUE);
                    I(1);
                } else {
                    aVar.remove(1);
                    this.f37024j.removeCallbacks(this.f37027m);
                    G(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void I(int i10) {
        switch (i10) {
            case 1:
                l(C(gg.b.f29463m1));
                break;
            case 2:
                l(C(gg.b.f29459l1));
                break;
            case 3:
                l(C(768));
                break;
            case 4:
                l(C(gg.b.f29442h0));
                break;
            case 5:
                l(C(gg.b.f29434f0));
                break;
            case 6:
                l(C(gg.b.f29471o1));
                break;
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public void J(int i10, boolean z10) {
        if (i10 == 1) {
            H(z10);
        } else {
            if (i10 != 2) {
                return;
            }
            K(z10);
        }
    }

    public final void K(boolean z10) {
        androidx.collection.a<Integer, Boolean> aVar = f37023s;
        synchronized (aVar) {
            if (z10) {
                aVar.put(2, Boolean.TRUE);
                I(2);
            } else {
                aVar.remove(2);
                this.f37024j.removeCallbacks(this.f37028n);
            }
        }
    }

    public final boolean N(hg.a aVar) {
        if (aVar.h().length < 2) {
            k(aVar, 5, null);
            return true;
        }
        k(aVar, 0, null);
        this.f37026l.r(aVar.h()[1] == 1);
        return true;
    }

    @SuppressLint({"SwitchIntDef"})
    public final boolean O(hg.a aVar) {
        if (aVar.h().length < 1) {
            k(aVar, 5, null);
            return true;
        }
        if (aVar.g() == 9) {
            return N(aVar);
        }
        return false;
    }

    public final void P(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37026l.s(bArrH[1] == 1);
        }
    }

    public final void Q(hg.a aVar) {
        if (aVar.h().length >= 3) {
            this.f37026l.v0(gg.d.b(aVar.h(), 1, 2, false));
            androidx.collection.a<Integer, Boolean> aVar2 = f37023s;
            synchronized (aVar2) {
                if (aVar2.containsKey(1) && aVar2.get(1).booleanValue()) {
                    aVar2.put(1, Boolean.FALSE);
                    this.f37024j.postDelayed(this.f37027m, 5000L);
                }
            }
        }
    }

    public final void R(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37026l.n(bArrH[1]);
        }
    }

    public final void S(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37026l.d(bArrH[1]);
            androidx.collection.a<Integer, Boolean> aVar2 = f37023s;
            synchronized (aVar2) {
                if (aVar2.containsKey(2) && aVar2.get(2).booleanValue()) {
                    aVar2.put(2, Boolean.FALSE);
                    this.f37024j.postDelayed(this.f37028n, 5000L);
                }
            }
        }
    }

    public final void T(hg.a aVar) {
        this.f37026l.l0(gg.d.b(aVar.h(), 7, 2, false));
    }

    public final void U(int i10) {
        try {
            l(hg.a.b(10, gg.b.E2, i10, null, n()));
        } catch (GaiaException e10) {
            e10.getMessage();
        }
    }

    public void V(int i10) {
        l(D(gg.b.f29430e0, i10 != 0 ? i10 != 2 ? new byte[]{1} : new byte[]{2} : new byte[]{0}));
    }

    public void W(boolean z10) {
        l(D(gg.b.f29438g0, z10 ? f37021q : f37022r));
    }

    @Override // gg.c
    public void o(hg.a aVar) {
        this.f37026l.f1(gg.d.c(aVar.e()));
    }

    @Override // gg.c
    public boolean p(hg.a aVar) {
        if (aVar.e() == 16387) {
            return O(aVar);
        }
        return false;
    }

    @Override // gg.c
    public void r(hg.a aVar) {
        this.f37026l.a0(gg.d.c(aVar.e()));
    }

    @Override // gg.c
    public void t(hg.a aVar) {
        int iE = aVar.e();
        if (iE == 518) {
            this.f37026l.U0();
            return;
        }
        if (iE == 519) {
            this.f37026l.w0();
            return;
        }
        if (iE == 646) {
            R(aVar);
            return;
        }
        if (iE == 647) {
            P(aVar);
            return;
        }
        if (iE == 769) {
            S(aVar);
            return;
        }
        if (iE == 770) {
            Q(aVar);
            return;
        }
        if (iE == 772) {
            T(aVar);
        } else if (iE == 1600) {
            l(C(gg.b.f29416a2));
        } else {
            if (iE != 1602) {
                return;
            }
            l(C(gg.b.Z1));
        }
    }

    @Override // gg.c
    public void u(hg.a aVar) {
        int iE = aVar.e();
        this.f37026l.K0(gg.d.c(aVar.e()), gg.b.c(aVar.j()));
        if (aVar.j() != 1) {
            if (iE == 1600) {
                l(C(gg.b.f29416a2));
            } else if (iE == 1602) {
                l(C(gg.b.Z1));
            }
        }
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37026l.a(bArr);
    }
}
