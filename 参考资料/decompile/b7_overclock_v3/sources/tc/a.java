package tc;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import g.p0;
import hd.c0;
import hd.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import qc.b;
import qc.d;
import qc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f51061s = 20;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f51062t = 21;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f51063u = 22;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f51064v = 128;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte f51065w = 120;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f51066o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f51067p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C0579a f51068q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public Inflater f51069r;

    /* JADX INFO: renamed from: tc.a$a, reason: collision with other inner class name */
    public static final class C0579a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f51070a = new c0();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f51071b = new int[256];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f51072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f51074e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f51075f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f51076g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f51077h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f51078i;

        @p0
        public qc.b d() {
            int iG;
            if (this.f51073d == 0 || this.f51074e == 0 || this.f51077h == 0 || this.f51078i == 0 || this.f51070a.f() == 0 || this.f51070a.e() != this.f51070a.f() || !this.f51072c) {
                return null;
            }
            this.f51070a.S(0);
            int i10 = this.f51077h * this.f51078i;
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int iG2 = this.f51070a.G();
                if (iG2 != 0) {
                    iG = i11 + 1;
                    iArr[i11] = this.f51071b[iG2];
                } else {
                    int iG3 = this.f51070a.G();
                    if (iG3 != 0) {
                        iG = ((iG3 & 64) == 0 ? iG3 & 63 : ((iG3 & 63) << 8) | this.f51070a.G()) + i11;
                        Arrays.fill(iArr, i11, iG, (iG3 & 128) == 0 ? 0 : this.f51071b[this.f51070a.G()]);
                    }
                }
                i11 = iG;
            }
            return new b.c().r(Bitmap.createBitmap(iArr, this.f51077h, this.f51078i, Bitmap.Config.ARGB_8888)).v(this.f51075f / this.f51073d).w(0).t(this.f51076g / this.f51074e, 0).u(0).y(this.f51077h / this.f51073d).s(this.f51078i / this.f51074e).a();
        }

        public final void e(c0 c0Var, int i10) {
            int iJ;
            if (i10 < 4) {
                return;
            }
            c0Var.T(3);
            int i11 = i10 - 4;
            if ((c0Var.G() & 128) != 0) {
                if (i11 < 7 || (iJ = c0Var.J()) < 4) {
                    return;
                }
                this.f51077h = c0Var.M();
                this.f51078i = c0Var.M();
                this.f51070a.O(iJ - 4);
                i11 -= 7;
            }
            int iE = this.f51070a.e();
            int iF = this.f51070a.f();
            if (iE >= iF || i11 <= 0) {
                return;
            }
            int iMin = Math.min(i11, iF - iE);
            c0Var.k(this.f51070a.d(), iE, iMin);
            this.f51070a.S(iE + iMin);
        }

        public final void f(c0 c0Var, int i10) {
            if (i10 < 19) {
                return;
            }
            this.f51073d = c0Var.M();
            this.f51074e = c0Var.M();
            c0Var.T(11);
            this.f51075f = c0Var.M();
            this.f51076g = c0Var.M();
        }

        public final void g(c0 c0Var, int i10) {
            if (i10 % 5 != 2) {
                return;
            }
            c0Var.T(2);
            Arrays.fill(this.f51071b, 0);
            int i11 = i10 / 5;
            int i12 = 0;
            while (i12 < i11) {
                int iG = c0Var.G();
                int iG2 = c0Var.G();
                int iG3 = c0Var.G();
                int iG4 = c0Var.G();
                int iG5 = c0Var.G();
                double d10 = iG2;
                double d11 = iG3 - 128;
                int i13 = (int) ((1.402d * d11) + d10);
                int i14 = i12;
                double d12 = iG4 - 128;
                this.f51071b[iG] = u0.t((int) (d10 + (d12 * 1.772d)), 0, 255) | (u0.t((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255) << 8) | (iG5 << 24) | (u0.t(i13, 0, 255) << 16);
                i12 = i14 + 1;
            }
            this.f51072c = true;
        }

        public void h() {
            this.f51073d = 0;
            this.f51074e = 0;
            this.f51075f = 0;
            this.f51076g = 0;
            this.f51077h = 0;
            this.f51078i = 0;
            this.f51070a.O(0);
            this.f51072c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f51066o = new c0();
        this.f51067p = new c0();
        this.f51068q = new C0579a();
    }

    @p0
    public static qc.b C(c0 c0Var, C0579a c0579a) {
        int iF = c0Var.f();
        int iG = c0Var.G();
        int iM = c0Var.M();
        int iE = c0Var.e() + iM;
        qc.b bVarD = null;
        if (iE > iF) {
            c0Var.S(iF);
            return null;
        }
        if (iG != 128) {
            switch (iG) {
                case 20:
                    c0579a.g(c0Var, iM);
                    break;
                case 21:
                    c0579a.e(c0Var, iM);
                    break;
                case 22:
                    c0579a.f(c0Var, iM);
                    break;
            }
        } else {
            bVarD = c0579a.d();
            c0579a.h();
        }
        c0Var.S(iE);
        return bVarD;
    }

    @Override // qc.d
    public f A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        this.f51066o.Q(bArr, i10);
        B(this.f51066o);
        this.f51068q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f51066o.a() >= 3) {
            qc.b bVarC = C(this.f51066o, this.f51068q);
            if (bVarC != null) {
                arrayList.add(bVarC);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }

    public final void B(c0 c0Var) {
        if (c0Var.a() <= 0 || c0Var.h() != 120) {
            return;
        }
        if (this.f51069r == null) {
            this.f51069r = new Inflater();
        }
        if (u0.C0(c0Var, this.f51067p, this.f51069r)) {
            c0Var.Q(this.f51067p.d(), this.f51067p.f());
        }
    }
}
