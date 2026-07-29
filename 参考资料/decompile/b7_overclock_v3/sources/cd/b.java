package cd;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.List;
import java.util.Locale;
import ya.h1;
import ya.j1;
import ya.k1;
import ya.u1;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class b implements j1.f, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10861d = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f10862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f10863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10864c;

    public b(u1 u1Var, TextView textView) {
        hd.a.a(u1Var.p1() == Looper.getMainLooper());
        this.f10862a = u1Var;
        this.f10863b = textView;
    }

    public static String d(eb.d dVar) {
        if (dVar == null) {
            return "";
        }
        dVar.c();
        return " sib:" + dVar.f26761d + " sb:" + dVar.f26763f + " rb:" + dVar.f26762e + " db:" + dVar.f26764g + " mcdb:" + dVar.f26765h + " dk:" + dVar.f26766i;
    }

    public static String j(float f10) {
        if (f10 == -1.0f || f10 == 1.0f) {
            return "";
        }
        return " par:" + String.format(Locale.US, "%.02f", Float.valueOf(f10));
    }

    public static String q(long j10, int i10) {
        return i10 == 0 ? "N/A" : String.valueOf((long) (j10 / ((double) i10)));
    }

    @Override // ya.j1.f
    public /* synthetic */ void B(boolean z10) {
        k1.c(this, z10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void D(boolean z10, int i10) {
        k1.m(this, z10, i10);
    }

    @Override // ya.j1.f
    public final void R(boolean z10, int i10) {
        u();
    }

    @Override // ya.j1.f
    public /* synthetic */ void S(x1 x1Var, int i10) {
        k1.s(this, x1Var, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void V(boolean z10) {
        k1.b(this, z10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void Z(v0 v0Var, int i10) {
        k1.g(this, v0Var, i10);
    }

    public String a() {
        Format formatR2 = this.f10862a.r2();
        eb.d dVarQ2 = this.f10862a.q2();
        if (formatR2 == null || dVarQ2 == null) {
            return "";
        }
        return "\n" + formatR2.f16699l + "(id:" + formatR2.f16687a + " hz:" + formatR2.f16713z + " ch:" + formatR2.f16712y + d(dVarQ2) + ee.a.f26979d;
    }

    @Override // ya.j1.f
    public /* synthetic */ void b(h1 h1Var) {
        k1.i(this, h1Var);
    }

    @Override // ya.j1.f
    public /* synthetic */ void b0(boolean z10) {
        k1.e(this, z10);
    }

    public String c() {
        return l() + s() + a();
    }

    @Override // ya.j1.f
    public /* synthetic */ void e(int i10) {
        k1.k(this, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void f(x1 x1Var, Object obj, int i10) {
        k1.t(this, x1Var, obj, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void g(boolean z10) {
        k1.f(this, z10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void h(TrackGroupArray trackGroupArray, ad.i iVar) {
        k1.u(this, trackGroupArray, iVar);
    }

    @Override // ya.j1.f
    public final void i(int i10) {
        u();
    }

    @Override // ya.j1.f
    public /* synthetic */ void k(List list) {
        k1.r(this, list);
    }

    public String l() {
        int iD = this.f10862a.d();
        return String.format("playWhenReady:%s playbackState:%s window:%s", Boolean.valueOf(this.f10862a.D()), iD != 1 ? iD != 2 ? iD != 3 ? iD != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", Integer.valueOf(this.f10862a.r0()));
    }

    @Override // ya.j1.f
    public /* synthetic */ void m(ExoPlaybackException exoPlaybackException) {
        k1.l(this, exoPlaybackException);
    }

    @Override // ya.j1.f
    public /* synthetic */ void n(boolean z10) {
        k1.d(this, z10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void o() {
        k1.p(this);
    }

    @Override // ya.j1.f
    public /* synthetic */ void p(j1 j1Var, j1.g gVar) {
        k1.a(this, j1Var, gVar);
    }

    @Override // ya.j1.f
    public final void r(int i10) {
        u();
    }

    @Override // java.lang.Runnable
    public final void run() {
        u();
    }

    public String s() {
        Format formatU2 = this.f10862a.u2();
        eb.d dVarT2 = this.f10862a.t2();
        if (formatU2 == null || dVarT2 == null) {
            return "";
        }
        return "\n" + formatU2.f16699l + "(id:" + formatU2.f16687a + " r:" + formatU2.f16704q + "x" + formatU2.f16705r + j(formatU2.f16708u) + d(dVarT2) + " vfpo: " + q(dVarT2.f26767j, dVarT2.f26768k) + ee.a.f26979d;
    }

    public final void stop() {
        if (this.f10864c) {
            this.f10864c = false;
            this.f10862a.K0(this);
            this.f10863b.removeCallbacks(this);
        }
    }

    public final void t() {
        if (this.f10864c) {
            return;
        }
        this.f10864c = true;
        this.f10862a.y(this);
        u();
    }

    @SuppressLint({"SetTextI18n"})
    public final void u() {
        this.f10863b.setText(c());
        this.f10863b.removeCallbacks(this);
        this.f10863b.postDelayed(this, 1000L);
    }

    @Override // ya.j1.f
    public /* synthetic */ void v(int i10) {
        k1.o(this, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void y(boolean z10) {
        k1.q(this, z10);
    }
}
