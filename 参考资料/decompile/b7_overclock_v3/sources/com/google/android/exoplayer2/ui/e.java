package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.l;
import g.p0;
import hd.e0;
import hd.u0;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import ya.h1;
import ya.i1;
import ya.j1;
import ya.k1;
import ya.r0;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class e extends FrameLayout {
    public static final int T7 = 5000;
    public static final int U7 = 0;
    public static final int V7 = 200;
    public static final int W7 = 100;
    public static final int X7 = 1000;
    public final Drawable A;
    public final Drawable B;
    public final float C;

    @p0
    public c C1;
    public boolean C2;
    public final float D;
    public boolean E7;
    public int F7;
    public int G7;
    public int H7;
    public boolean I7;
    public boolean J7;
    public final String K0;

    @p0
    public i1 K1;
    public boolean K2;
    public boolean K7;
    public boolean L7;
    public boolean M7;
    public long N7;
    public long[] O7;
    public boolean[] P7;
    public long[] Q7;
    public boolean[] R7;
    public long S7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f18732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final View f18733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final View f18734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final View f18735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final View f18736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final View f18737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final View f18738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final ImageView f18739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final ImageView f18740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final View f18741k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final String f18742k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @p0
    public j1 f18743k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final TextView f18744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public final TextView f18745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public final l f18746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final StringBuilder f18747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Formatter f18748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final x1.b f18749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final x1.c f18750r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f18751s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f18752t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Drawable f18753u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f18754v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public ya.h f18755v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f18756v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Drawable f18757w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f18758x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f18759y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f18760z;

    public final class b implements j1.f, l.a, View.OnClickListener {
        public b() {
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
        public /* synthetic */ void R(boolean z10, int i10) {
            k1.h(this, z10, i10);
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

        @Override // com.google.android.exoplayer2.ui.l.a
        public void a(l lVar, long j10) {
            if (e.this.f18745m != null) {
                e.this.f18745m.setText(u0.p0(e.this.f18747o, e.this.f18748p, j10));
            }
        }

        @Override // ya.j1.f
        public /* synthetic */ void b(h1 h1Var) {
            k1.i(this, h1Var);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b0(boolean z10) {
            k1.e(this, z10);
        }

        @Override // com.google.android.exoplayer2.ui.l.a
        public void c(l lVar, long j10, boolean z10) {
            e.this.E7 = false;
            if (z10 || e.this.f18743k1 == null) {
                return;
            }
            e eVar = e.this;
            eVar.N(eVar.f18743k1, j10);
        }

        @Override // com.google.android.exoplayer2.ui.l.a
        public void d(l lVar, long j10) {
            e.this.E7 = true;
            if (e.this.f18745m != null) {
                e.this.f18745m.setText(u0.p0(e.this.f18747o, e.this.f18748p, j10));
            }
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
        public /* synthetic */ void i(int i10) {
            k1.n(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void k(List list) {
            k1.r(this, list);
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j1 j1Var = e.this.f18743k1;
            if (j1Var == null) {
                return;
            }
            if (e.this.f18734d == view) {
                e.this.f18755v1.f(j1Var);
                return;
            }
            if (e.this.f18733c == view) {
                e.this.f18755v1.l(j1Var);
                return;
            }
            if (e.this.f18737g == view) {
                if (j1Var.d() != 4) {
                    e.this.f18755v1.a(j1Var);
                    return;
                }
                return;
            }
            if (e.this.f18738h == view) {
                e.this.f18755v1.k(j1Var);
                return;
            }
            if (e.this.f18735e == view) {
                e.this.D(j1Var);
                return;
            }
            if (e.this.f18736f == view) {
                e.this.C(j1Var);
            } else if (e.this.f18739i == view) {
                e.this.f18755v1.d(j1Var, e0.a(j1Var.k(), e.this.H7));
            } else if (e.this.f18740j == view) {
                e.this.f18755v1.j(j1Var, !j1Var.u1());
            }
        }

        @Override // ya.j1.f
        public void p(j1 j1Var, j1.g gVar) {
            if (gVar.d(5, 6)) {
                e.this.U();
            }
            if (gVar.d(5, 6, 8)) {
                e.this.V();
            }
            if (gVar.c(9)) {
                e.this.W();
            }
            if (gVar.c(10)) {
                e.this.X();
            }
            if (gVar.d(9, 10, 12, 0)) {
                e.this.T();
            }
            if (gVar.d(12, 0)) {
                e.this.Y();
            }
        }

        @Override // ya.j1.f
        public /* synthetic */ void r(int i10) {
            k1.j(this, i10);
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

    public interface c {
        void a(long j10, long j11);
    }

    public interface d {
        void a(int i10);
    }

    static {
        r0.a("goog.exo.ui");
    }

    public e(Context context) {
        this(context, null);
    }

    public static boolean A(x1 x1Var, x1.c cVar) {
        if (x1Var.q() > 100) {
            return false;
        }
        int iQ = x1Var.q();
        for (int i10 = 0; i10 < iQ; i10++) {
            if (x1Var.n(i10, cVar).f57255p == ya.g.f56663b) {
                return false;
            }
        }
        return true;
    }

    public static int F(TypedArray typedArray, int i10) {
        return typedArray.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, i10);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean I(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    public boolean B(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        j1 j1Var = this.f18743k1;
        if (j1Var == null || !I(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (j1Var.d() == 4) {
                return true;
            }
            this.f18755v1.a(j1Var);
            return true;
        }
        if (keyCode == 89) {
            this.f18755v1.k(j1Var);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            E(j1Var);
            return true;
        }
        if (keyCode == 87) {
            this.f18755v1.f(j1Var);
            return true;
        }
        if (keyCode == 88) {
            this.f18755v1.l(j1Var);
            return true;
        }
        if (keyCode == 126) {
            D(j1Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        C(j1Var);
        return true;
    }

    public final void C(j1 j1Var) {
        this.f18755v1.h(j1Var, false);
    }

    public final void D(j1 j1Var) {
        int iD = j1Var.d();
        if (iD == 1) {
            i1 i1Var = this.K1;
            if (i1Var != null) {
                i1Var.a();
            } else {
                this.f18755v1.g(j1Var);
            }
        } else if (iD == 4) {
            M(j1Var, j1Var.r0(), ya.g.f56663b);
        }
        this.f18755v1.h(j1Var, true);
    }

    public final void E(j1 j1Var) {
        int iD = j1Var.d();
        if (iD == 1 || iD == 4 || !j1Var.D()) {
            D(j1Var);
        } else {
            C(j1Var);
        }
    }

    public void G() {
        if (J()) {
            setVisibility(8);
            Iterator<d> it2 = this.f18732b.iterator();
            while (it2.hasNext()) {
                it2.next().a(getVisibility());
            }
            removeCallbacks(this.f18751s);
            removeCallbacks(this.f18752t);
            this.N7 = ya.g.f56663b;
        }
    }

    public final void H() {
        removeCallbacks(this.f18752t);
        if (this.F7 <= 0) {
            this.N7 = ya.g.f56663b;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i10 = this.F7;
        this.N7 = jUptimeMillis + ((long) i10);
        if (this.f18756v2) {
            postDelayed(this.f18752t, i10);
        }
    }

    public boolean J() {
        return getVisibility() == 0;
    }

    public void K(d dVar) {
        this.f18732b.remove(dVar);
    }

    public final void L() {
        View view;
        View view2;
        boolean zP = P();
        if (!zP && (view2 = this.f18735e) != null) {
            view2.requestFocus();
        } else {
            if (!zP || (view = this.f18736f) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final boolean M(j1 j1Var, int i10, long j10) {
        return this.f18755v1.b(j1Var, i10, j10);
    }

    public final void N(j1 j1Var, long j10) {
        int iR0;
        x1 x1VarN1 = j1Var.n1();
        if (this.K2 && !x1VarN1.r()) {
            int iQ = x1VarN1.q();
            iR0 = 0;
            while (true) {
                long jD = x1VarN1.n(iR0, this.f18750r).d();
                if (j10 < jD) {
                    break;
                }
                if (iR0 == iQ - 1) {
                    j10 = jD;
                    break;
                } else {
                    j10 -= jD;
                    iR0++;
                }
            }
        } else {
            iR0 = j1Var.r0();
        }
        if (M(j1Var, iR0, j10)) {
            return;
        }
        V();
    }

    public void O(@p0 long[] jArr, @p0 boolean[] zArr) {
        if (jArr == null) {
            this.Q7 = new long[0];
            this.R7 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) hd.a.g(zArr);
            hd.a.a(jArr.length == zArr2.length);
            this.Q7 = jArr;
            this.R7 = zArr2;
        }
        Y();
    }

    public final boolean P() {
        j1 j1Var = this.f18743k1;
        return (j1Var == null || j1Var.d() == 4 || this.f18743k1.d() == 1 || !this.f18743k1.D()) ? false : true;
    }

    public void Q() {
        if (!J()) {
            setVisibility(0);
            Iterator<d> it2 = this.f18732b.iterator();
            while (it2.hasNext()) {
                it2.next().a(getVisibility());
            }
            R();
            L();
        }
        H();
    }

    public final void R() {
        U();
        T();
        W();
        X();
        Y();
    }

    public final void S(boolean z10, boolean z11, @p0 View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.C : this.D);
        view.setVisibility(z10 ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() {
        /*
            r8 = this;
            boolean r0 = r8.J()
            if (r0 == 0) goto L9a
            boolean r0 = r8.f18756v2
            if (r0 != 0) goto Lc
            goto L9a
        Lc:
            ya.j1 r0 = r8.f18743k1
            r1 = 0
            if (r0 == 0) goto L73
            ya.x1 r2 = r0.n1()
            boolean r3 = r2.r()
            if (r3 != 0) goto L73
            boolean r3 = r0.r()
            if (r3 != 0) goto L73
            int r3 = r0.r0()
            ya.x1$c r4 = r8.f18750r
            r2.n(r3, r4)
            ya.x1$c r2 = r8.f18750r
            boolean r3 = r2.f57247h
            r4 = 1
            if (r3 != 0) goto L40
            boolean r2 = r2.h()
            if (r2 == 0) goto L40
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L3e
            goto L40
        L3e:
            r2 = 0
            goto L41
        L40:
            r2 = 1
        L41:
            if (r3 == 0) goto L4d
            ya.h r5 = r8.f18755v1
            boolean r5 = r5.e()
            if (r5 == 0) goto L4d
            r5 = 1
            goto L4e
        L4d:
            r5 = 0
        L4e:
            if (r3 == 0) goto L5a
            ya.h r6 = r8.f18755v1
            boolean r6 = r6.m()
            if (r6 == 0) goto L5a
            r6 = 1
            goto L5b
        L5a:
            r6 = 0
        L5b:
            ya.x1$c r7 = r8.f18750r
            boolean r7 = r7.h()
            if (r7 == 0) goto L69
            ya.x1$c r7 = r8.f18750r
            boolean r7 = r7.f57248i
            if (r7 != 0) goto L6f
        L69:
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L70
        L6f:
            r1 = 1
        L70:
            r0 = r1
            r1 = r2
            goto L77
        L73:
            r0 = 0
            r3 = 0
            r5 = 0
            r6 = 0
        L77:
            boolean r2 = r8.K7
            android.view.View r4 = r8.f18733c
            r8.S(r2, r1, r4)
            boolean r1 = r8.I7
            android.view.View r2 = r8.f18738h
            r8.S(r1, r5, r2)
            boolean r1 = r8.J7
            android.view.View r2 = r8.f18737g
            r8.S(r1, r6, r2)
            boolean r1 = r8.L7
            android.view.View r2 = r8.f18734d
            r8.S(r1, r0, r2)
            com.google.android.exoplayer2.ui.l r0 = r8.f18746n
            if (r0 == 0) goto L9a
            r0.setEnabled(r3)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.e.T():void");
    }

    public final void U() {
        boolean z10;
        if (J() && this.f18756v2) {
            boolean zP = P();
            View view = this.f18735e;
            if (view != null) {
                z10 = (zP && view.isFocused()) | false;
                this.f18735e.setVisibility(zP ? 8 : 0);
            } else {
                z10 = false;
            }
            View view2 = this.f18736f;
            if (view2 != null) {
                z10 |= !zP && view2.isFocused();
                this.f18736f.setVisibility(zP ? 0 : 8);
            }
            if (z10) {
                L();
            }
        }
    }

    public final void V() {
        long jV1;
        if (J() && this.f18756v2) {
            j1 j1Var = this.f18743k1;
            long jC0 = 0;
            if (j1Var != null) {
                jC0 = this.S7 + j1Var.C0();
                jV1 = this.S7 + j1Var.v1();
            } else {
                jV1 = 0;
            }
            TextView textView = this.f18745m;
            if (textView != null && !this.E7) {
                textView.setText(u0.p0(this.f18747o, this.f18748p, jC0));
            }
            l lVar = this.f18746n;
            if (lVar != null) {
                lVar.setPosition(jC0);
                this.f18746n.setBufferedPosition(jV1);
            }
            c cVar = this.C1;
            if (cVar != null) {
                cVar.a(jC0, jV1);
            }
            removeCallbacks(this.f18751s);
            int iD = j1Var == null ? 1 : j1Var.d();
            if (j1Var == null || !j1Var.N0()) {
                if (iD == 4 || iD == 1) {
                    return;
                }
                postDelayed(this.f18751s, 1000L);
                return;
            }
            l lVar2 = this.f18746n;
            long jMin = Math.min(lVar2 != null ? lVar2.getPreferredUpdateDelay() : 1000L, 1000 - (jC0 % 1000));
            float f10 = j1Var.e().f56785a;
            postDelayed(this.f18751s, u0.u(f10 > 0.0f ? (long) (jMin / f10) : 1000L, this.G7, 1000L));
        }
    }

    public final void W() {
        ImageView imageView;
        if (J() && this.f18756v2 && (imageView = this.f18739i) != null) {
            if (this.H7 == 0) {
                S(false, false, imageView);
                return;
            }
            j1 j1Var = this.f18743k1;
            if (j1Var == null) {
                S(true, false, imageView);
                this.f18739i.setImageDrawable(this.f18753u);
                this.f18739i.setContentDescription(this.f18758x);
                return;
            }
            S(true, true, imageView);
            int iK = j1Var.k();
            if (iK == 0) {
                this.f18739i.setImageDrawable(this.f18753u);
                this.f18739i.setContentDescription(this.f18758x);
            } else if (iK == 1) {
                this.f18739i.setImageDrawable(this.f18754v);
                this.f18739i.setContentDescription(this.f18759y);
            } else if (iK == 2) {
                this.f18739i.setImageDrawable(this.f18757w);
                this.f18739i.setContentDescription(this.f18760z);
            }
            this.f18739i.setVisibility(0);
        }
    }

    public final void X() {
        ImageView imageView;
        if (J() && this.f18756v2 && (imageView = this.f18740j) != null) {
            j1 j1Var = this.f18743k1;
            if (!this.M7) {
                S(false, false, imageView);
                return;
            }
            if (j1Var == null) {
                S(true, false, imageView);
                this.f18740j.setImageDrawable(this.B);
                this.f18740j.setContentDescription(this.K0);
            } else {
                S(true, true, imageView);
                this.f18740j.setImageDrawable(j1Var.u1() ? this.A : this.B);
                this.f18740j.setContentDescription(j1Var.u1() ? this.f18742k0 : this.K0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.e.Y():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return B(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f18752t);
        } else if (motionEvent.getAction() == 1) {
            H();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @p0
    public j1 getPlayer() {
        return this.f18743k1;
    }

    public int getRepeatToggleModes() {
        return this.H7;
    }

    public boolean getShowShuffleButton() {
        return this.M7;
    }

    public int getShowTimeoutMs() {
        return this.F7;
    }

    public boolean getShowVrButton() {
        View view = this.f18741k;
        return view != null && view.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f18756v2 = true;
        long j10 = this.N7;
        if (j10 != ya.g.f56663b) {
            long jUptimeMillis = j10 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                G();
            } else {
                postDelayed(this.f18752t, jUptimeMillis);
            }
        } else if (J()) {
            H();
        }
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f18756v2 = false;
        removeCallbacks(this.f18751s);
        removeCallbacks(this.f18752t);
    }

    public void setControlDispatcher(ya.h hVar) {
        if (this.f18755v1 != hVar) {
            this.f18755v1 = hVar;
            T();
        }
    }

    @Deprecated
    public void setFastForwardIncrementMs(int i10) {
        ya.h hVar = this.f18755v1;
        if (hVar instanceof ya.i) {
            ((ya.i) hVar).q(i10);
            T();
        }
    }

    @Deprecated
    public void setPlaybackPreparer(@p0 i1 i1Var) {
        this.K1 = i1Var;
    }

    public void setPlayer(@p0 j1 j1Var) {
        boolean z10 = true;
        hd.a.i(Looper.myLooper() == Looper.getMainLooper());
        if (j1Var != null && j1Var.p1() != Looper.getMainLooper()) {
            z10 = false;
        }
        hd.a.a(z10);
        j1 j1Var2 = this.f18743k1;
        if (j1Var2 == j1Var) {
            return;
        }
        if (j1Var2 != null) {
            j1Var2.K0(this.f18731a);
        }
        this.f18743k1 = j1Var;
        if (j1Var != null) {
            j1Var.y(this.f18731a);
        }
        R();
    }

    public void setProgressUpdateListener(@p0 c cVar) {
        this.C1 = cVar;
    }

    public void setRepeatToggleModes(int i10) {
        this.H7 = i10;
        j1 j1Var = this.f18743k1;
        if (j1Var != null) {
            int iK = j1Var.k();
            if (i10 == 0 && iK != 0) {
                this.f18755v1.d(this.f18743k1, 0);
            } else if (i10 == 1 && iK == 2) {
                this.f18755v1.d(this.f18743k1, 1);
            } else if (i10 == 2 && iK == 1) {
                this.f18755v1.d(this.f18743k1, 2);
            }
        }
        W();
    }

    @Deprecated
    public void setRewindIncrementMs(int i10) {
        ya.h hVar = this.f18755v1;
        if (hVar instanceof ya.i) {
            ((ya.i) hVar).r(i10);
            T();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        this.J7 = z10;
        T();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.C2 = z10;
        Y();
    }

    public void setShowNextButton(boolean z10) {
        this.L7 = z10;
        T();
    }

    public void setShowPreviousButton(boolean z10) {
        this.K7 = z10;
        T();
    }

    public void setShowRewindButton(boolean z10) {
        this.I7 = z10;
        T();
    }

    public void setShowShuffleButton(boolean z10) {
        this.M7 = z10;
        X();
    }

    public void setShowTimeoutMs(int i10) {
        this.F7 = i10;
        if (J()) {
            H();
        }
    }

    public void setShowVrButton(boolean z10) {
        View view = this.f18741k;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.G7 = u0.t(i10, 16, 1000);
    }

    public void setVrButtonListener(@p0 View.OnClickListener onClickListener) {
        View view = this.f18741k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            S(getShowVrButton(), onClickListener != null, this.f18741k);
        }
    }

    public void z(d dVar) {
        hd.a.g(dVar);
        this.f18732b.add(dVar);
    }

    public e(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, @p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    public e(Context context, @p0 AttributeSet attributeSet, int i10, @p0 AttributeSet attributeSet2) {
        super(context, attributeSet, i10);
        int resourceId = R.layout.exo_player_control_view;
        int i11 = 5000;
        this.F7 = 5000;
        this.H7 = 0;
        this.G7 = 200;
        this.N7 = ya.g.f56663b;
        this.I7 = true;
        this.J7 = true;
        this.K7 = true;
        this.L7 = true;
        this.M7 = false;
        int i12 = 15000;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerControlView, 0, 0);
            try {
                i11 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_rewind_increment, 5000);
                i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_fastforward_increment, 15000);
                this.F7 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_show_timeout, this.F7);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_controller_layout_id, resourceId);
                this.H7 = F(typedArrayObtainStyledAttributes, this.H7);
                this.I7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_rewind_button, this.I7);
                this.J7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_fastforward_button, this.J7);
                this.K7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_previous_button, this.K7);
                this.L7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_next_button, this.L7);
                this.M7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, this.M7);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerControlView_time_bar_min_update_interval, this.G7));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f18732b = new CopyOnWriteArrayList<>();
        this.f18749q = new x1.b();
        this.f18750r = new x1.c();
        StringBuilder sb2 = new StringBuilder();
        this.f18747o = sb2;
        this.f18748p = new Formatter(sb2, Locale.getDefault());
        this.O7 = new long[0];
        this.P7 = new boolean[0];
        this.Q7 = new long[0];
        this.R7 = new boolean[0];
        b bVar = new b();
        this.f18731a = bVar;
        this.f18755v1 = new ya.i(i12, i11);
        this.f18751s = new Runnable() { // from class: cd.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f10874a.V();
            }
        };
        this.f18752t = new Runnable() { // from class: cd.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f10872a.G();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i13 = R.id.exo_progress;
        l lVar = (l) findViewById(i13);
        View viewFindViewById = findViewById(R.id.exo_progress_placeholder);
        if (lVar != null) {
            this.f18746n = lVar;
        } else if (viewFindViewById != null) {
            com.google.android.exoplayer2.ui.b bVar2 = new com.google.android.exoplayer2.ui.b(context, null, 0, attributeSet2);
            bVar2.setId(i13);
            bVar2.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(bVar2, iIndexOfChild);
            this.f18746n = bVar2;
        } else {
            this.f18746n = null;
        }
        this.f18744l = (TextView) findViewById(R.id.exo_duration);
        this.f18745m = (TextView) findViewById(R.id.exo_position);
        l lVar2 = this.f18746n;
        if (lVar2 != null) {
            lVar2.c(bVar);
        }
        View viewFindViewById2 = findViewById(R.id.exo_play);
        this.f18735e = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(bVar);
        }
        View viewFindViewById3 = findViewById(R.id.exo_pause);
        this.f18736f = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(bVar);
        }
        View viewFindViewById4 = findViewById(R.id.exo_prev);
        this.f18733c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(bVar);
        }
        View viewFindViewById5 = findViewById(R.id.exo_next);
        this.f18734d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(bVar);
        }
        View viewFindViewById6 = findViewById(R.id.exo_rew);
        this.f18738h = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(bVar);
        }
        View viewFindViewById7 = findViewById(R.id.exo_ffwd);
        this.f18737g = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(bVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f18739i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(bVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f18740j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(bVar);
        }
        View viewFindViewById8 = findViewById(R.id.exo_vr);
        this.f18741k = viewFindViewById8;
        setShowVrButton(false);
        S(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.C = resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f18753u = resources.getDrawable(R.drawable.exo_controls_repeat_off);
        this.f18754v = resources.getDrawable(R.drawable.exo_controls_repeat_one);
        this.f18757w = resources.getDrawable(R.drawable.exo_controls_repeat_all);
        this.A = resources.getDrawable(R.drawable.exo_controls_shuffle_on);
        this.B = resources.getDrawable(R.drawable.exo_controls_shuffle_off);
        this.f18758x = resources.getString(R.string.exo_controls_repeat_off_description);
        this.f18759y = resources.getString(R.string.exo_controls_repeat_one_description);
        this.f18760z = resources.getString(R.string.exo_controls_repeat_all_description);
        this.f18742k0 = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.K0 = resources.getString(R.string.exo_controls_shuffle_off_description);
    }
}
