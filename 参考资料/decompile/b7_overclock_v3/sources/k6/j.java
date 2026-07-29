package k6;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public class j extends k6.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f37051l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f37052m = 127;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f37053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f37054k;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {

        /* JADX INFO: renamed from: k3, reason: collision with root package name */
        public static final int f37055k3 = 0;

        /* JADX INFO: renamed from: l3, reason: collision with root package name */
        public static final int f37056l3 = 1;

        /* JADX INFO: renamed from: m3, reason: collision with root package name */
        public static final int f37057m3 = 2;

        /* JADX INFO: renamed from: n3, reason: collision with root package name */
        public static final int f37058n3 = 3;
    }

    public interface b {
        boolean a(byte[] bArr);

        void b(int i10, int i11);

        void c(int i10, int i11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface c {

        /* JADX INFO: renamed from: o3, reason: collision with root package name */
        public static final int f37059o3 = 0;

        /* JADX INFO: renamed from: p3, reason: collision with root package name */
        public static final int f37060p3 = 1;
    }

    public j(b bVar, int i10) {
        super(i10);
        this.f37053j = "TWSGaiaManager";
        this.f37054k = bVar;
    }

    public void E(int i10) {
        l(D(gg.b.V0, new byte[]{(byte) i10}));
    }

    public final int F(int i10) {
        if (i10 == 0) {
            return 0;
        }
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    return -1;
                }
            }
        }
        return i11;
    }

    public final int G(int i10) {
        if (i10 != 0) {
            return i10 != 1 ? -1 : 1;
        }
        return 0;
    }

    public void H(int i10) {
        l(D(gg.b.X0, new byte[]{(byte) i10}));
    }

    public final void I(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 3) {
            this.f37054k.c(G(bArrH[1]), F(bArrH[2]));
        }
    }

    public final void J(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 3) {
            byte b10 = bArrH[1];
            byte b11 = bArrH[2];
            if (b11 > 127) {
                b11 = 127;
            } else if (b11 < 0) {
                b11 = 0;
            }
            this.f37054k.b(G(b10), b11);
        }
    }

    public void K(int i10, int i11) {
        l(D(gg.b.U0, new byte[]{(byte) i10, (byte) i11}));
    }

    public void L(int i10, int i11) {
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 > 127) {
            i11 = 127;
        }
        l(D(gg.b.W0, new byte[]{(byte) i10, (byte) i11}));
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
        int iE = aVar.e();
        if (iE == 676) {
            I(aVar);
        } else {
            if (iE != 677) {
                return;
            }
            J(aVar);
        }
    }

    @Override // gg.c
    public void u(hg.a aVar) {
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37054k.a(bArr);
    }
}
