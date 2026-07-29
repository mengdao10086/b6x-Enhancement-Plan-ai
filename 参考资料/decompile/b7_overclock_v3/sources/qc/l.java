package qc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import g.p0;
import hd.t;
import hd.u0;
import hd.w;
import java.util.Collections;
import java.util.List;
import ya.p1;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends com.google.android.exoplayer2.a implements Handler.Callback {
    public static final String B = "TextRenderer";
    public static final int C = 0;
    public static final int D = 1;
    public static final int K0 = 0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f47271k0 = 2;
    public long A;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public final Handler f47272m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f47273n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h f47274o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final s0 f47275p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f47276q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f47277r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f47278s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f47279t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public Format f47280u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public g f47281v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public i f47282w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public j f47283x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public j f47284y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f47285z;

    public l(k kVar, @p0 Looper looper) {
        this(kVar, looper, h.f47267a);
    }

    @Override // com.google.android.exoplayer2.a
    public void G() {
        this.f47280u = null;
        this.A = ya.g.f56663b;
        P();
        V();
    }

    @Override // com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) {
        P();
        this.f47276q = false;
        this.f47277r = false;
        this.A = ya.g.f56663b;
        if (this.f47279t != 0) {
            W();
        } else {
            U();
            ((g) hd.a.g(this.f47281v)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void M(Format[] formatArr, long j10, long j11) {
        this.f47280u = formatArr[0];
        if (this.f47281v != null) {
            this.f47279t = 1;
        } else {
            S();
        }
    }

    public final void P() {
        Y(Collections.emptyList());
    }

    public final long Q() {
        if (this.f47285z == -1) {
            return Long.MAX_VALUE;
        }
        hd.a.g(this.f47283x);
        if (this.f47285z >= this.f47283x.f()) {
            return Long.MAX_VALUE;
        }
        return this.f47283x.d(this.f47285z);
    }

    public final void R(SubtitleDecoderException subtitleDecoderException) {
        t.e(B, "Subtitle decoding failed. streamFormat=" + this.f47280u, subtitleDecoderException);
        P();
        W();
    }

    public final void S() {
        this.f47278s = true;
        this.f47281v = this.f47274o.b((Format) hd.a.g(this.f47280u));
    }

    public final void T(List<b> list) {
        this.f47273n.I(list);
    }

    public final void U() {
        this.f47282w = null;
        this.f47285z = -1;
        j jVar = this.f47283x;
        if (jVar != null) {
            jVar.p();
            this.f47283x = null;
        }
        j jVar2 = this.f47284y;
        if (jVar2 != null) {
            jVar2.p();
            this.f47284y = null;
        }
    }

    public final void V() {
        U();
        ((g) hd.a.g(this.f47281v)).release();
        this.f47281v = null;
        this.f47279t = 0;
    }

    public final void W() {
        V();
        S();
    }

    public void X(long j10) {
        hd.a.i(w());
        this.A = j10;
    }

    public final void Y(List<b> list) {
        Handler handler = this.f47272m;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            T(list);
        }
    }

    @Override // ya.q1
    public int a(Format format) {
        if (this.f47274o.a(format)) {
            return p1.a(format.f16698k0 == null ? 4 : 2);
        }
        return w.r(format.f16699l) ? p1.a(1) : p1.a(0);
    }

    @Override // ya.o1
    public boolean b() {
        return this.f47277r;
    }

    @Override // ya.o1
    public boolean d() {
        return true;
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return B;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        T((List) message.obj);
        return true;
    }

    @Override // ya.o1
    public void q(long j10, long j11) throws DecoderException {
        boolean z10;
        if (w()) {
            long j12 = this.A;
            if (j12 != ya.g.f56663b && j10 >= j12) {
                U();
                this.f47277r = true;
            }
        }
        if (this.f47277r) {
            return;
        }
        if (this.f47284y == null) {
            ((g) hd.a.g(this.f47281v)).a(j10);
            try {
                this.f47284y = ((g) hd.a.g(this.f47281v)).b();
            } catch (SubtitleDecoderException e10) {
                R(e10);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f47283x != null) {
            long jQ = Q();
            z10 = false;
            while (jQ <= j10) {
                this.f47285z++;
                jQ = Q();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        j jVar = this.f47284y;
        if (jVar != null) {
            if (jVar.m()) {
                if (!z10 && Q() == Long.MAX_VALUE) {
                    if (this.f47279t == 2) {
                        W();
                    } else {
                        U();
                        this.f47277r = true;
                    }
                }
            } else if (jVar.f26793b <= j10) {
                j jVar2 = this.f47283x;
                if (jVar2 != null) {
                    jVar2.p();
                }
                this.f47285z = jVar.c(j10);
                this.f47283x = jVar;
                this.f47284y = null;
                z10 = true;
            }
        }
        if (z10) {
            hd.a.g(this.f47283x);
            Y(this.f47283x.e(j10));
        }
        if (this.f47279t == 2) {
            return;
        }
        while (!this.f47276q) {
            try {
                i iVarC = this.f47282w;
                if (iVarC == null) {
                    iVarC = ((g) hd.a.g(this.f47281v)).c();
                    if (iVarC == null) {
                        return;
                    } else {
                        this.f47282w = iVarC;
                    }
                }
                if (this.f47279t == 1) {
                    iVarC.o(4);
                    ((g) hd.a.g(this.f47281v)).d(iVarC);
                    this.f47282w = null;
                    this.f47279t = 2;
                    return;
                }
                int iN = N(this.f47275p, iVarC, false);
                if (iN == -4) {
                    if (iVarC.m()) {
                        this.f47276q = true;
                        this.f47278s = false;
                    } else {
                        Format format = this.f47275p.f57068b;
                        if (format == null) {
                            return;
                        }
                        iVarC.f47268l = format.f16703p;
                        iVarC.r();
                        this.f47278s &= !iVarC.n();
                    }
                    if (!this.f47278s) {
                        ((g) hd.a.g(this.f47281v)).d(iVarC);
                        this.f47282w = null;
                    }
                } else if (iN == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e11) {
                R(e11);
                return;
            }
        }
    }

    public l(k kVar, @p0 Looper looper, h hVar) {
        super(3);
        this.f47273n = (k) hd.a.g(kVar);
        this.f47272m = looper == null ? null : u0.y(looper, this);
        this.f47274o = hVar;
        this.f47275p = new s0();
        this.A = ya.g.f56663b;
    }
}
