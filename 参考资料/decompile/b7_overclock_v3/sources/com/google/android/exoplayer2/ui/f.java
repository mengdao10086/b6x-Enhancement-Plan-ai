package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import f0.a0;
import f0.v;
import g.c1;
import g.p0;
import g.v;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u1.a;
import ya.h1;
import ya.i1;
import ya.j1;
import ya.k1;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static final String M = "com.google.android.exoplayer.play";
    public static final String N = "com.google.android.exoplayer.pause";
    public static final String O = "com.google.android.exoplayer.prev";
    public static final String P = "com.google.android.exoplayer.next";
    public static final String Q = "com.google.android.exoplayer.ffwd";
    public static final String R = "com.google.android.exoplayer.rewind";
    public static final String S = "com.google.android.exoplayer.stop";
    public static final String T = "INSTANCE_ID";
    public static final String U = "com.google.android.exoplayer.dismiss";
    public static final int V = 0;
    public static final int W = 1;
    public static int X;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;
    public int H;

    @v
    public int I;
    public int J;
    public int K;
    public boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f18765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final c f18766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f18767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a0 f18768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IntentFilter f18769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j1.f f18770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f18771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, v.b> f18772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, v.b> f18773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PendingIntent f18774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f18775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final x1.c f18776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public v.n f18777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public List<v.b> f18778q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public j1 f18779r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public i1 f18780s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ya.h f18781t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f18782u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18783v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public InterfaceC0195f f18784w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public MediaSessionCompat.Token f18785x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f18786y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f18787z;

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18788a;

        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                f.this.y(bitmap, this.f18788a);
            }
        }

        public b(int i10) {
            this.f18788a = i10;
        }
    }

    public interface c {
        Map<String, v.b> a(Context context, int i10);

        void b(j1 j1Var, String str, Intent intent);

        List<String> c(j1 j1Var);
    }

    public interface d {
        CharSequence a(j1 j1Var);

        @p0
        CharSequence b(j1 j1Var);

        @p0
        CharSequence c(j1 j1Var);

        @p0
        Bitmap d(j1 j1Var, b bVar);

        @p0
        PendingIntent e(j1 j1Var);
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j1 j1Var = f.this.f18779r;
            if (j1Var != null && f.this.f18782u && intent.getIntExtra(f.T, f.this.f18775n) == f.this.f18775n) {
                String action = intent.getAction();
                if (f.M.equals(action)) {
                    if (j1Var.d() == 1) {
                        if (f.this.f18780s != null) {
                            f.this.f18780s.a();
                        } else {
                            f.this.f18781t.g(j1Var);
                        }
                    } else if (j1Var.d() == 4) {
                        f.this.f18781t.b(j1Var, j1Var.r0(), ya.g.f56663b);
                    }
                    f.this.f18781t.h(j1Var, true);
                    return;
                }
                if (f.N.equals(action)) {
                    f.this.f18781t.h(j1Var, false);
                    return;
                }
                if (f.O.equals(action)) {
                    f.this.f18781t.l(j1Var);
                    return;
                }
                if (f.R.equals(action)) {
                    f.this.f18781t.k(j1Var);
                    return;
                }
                if (f.Q.equals(action)) {
                    f.this.f18781t.a(j1Var);
                    return;
                }
                if (f.P.equals(action)) {
                    f.this.f18781t.f(j1Var);
                    return;
                }
                if (f.S.equals(action)) {
                    f.this.f18781t.c(j1Var, true);
                    return;
                }
                if (f.U.equals(action)) {
                    f.this.Z(true);
                } else {
                    if (action == null || f.this.f18766e == null || !f.this.f18773l.containsKey(action)) {
                        return;
                    }
                    f.this.f18766e.b(j1Var, action, intent);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.f$f, reason: collision with other inner class name */
    public interface InterfaceC0195f {
        void a(int i10, Notification notification, boolean z10);

        @Deprecated
        void b(int i10, Notification notification);

        @Deprecated
        void c(int i10);

        void d(int i10, boolean z10);
    }

    public class g implements j1.f {
        public g() {
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

        @Override // ya.j1.f
        public /* synthetic */ void b(h1 h1Var) {
            k1.i(this, h1Var);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b0(boolean z10) {
            k1.e(this, z10);
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

        @Override // ya.j1.f
        public void p(j1 j1Var, j1.g gVar) {
            if (gVar.d(5, 6, 8, 0, 13, 12, 9, 10)) {
                f.this.x();
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

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    public f(Context context, String str, int i10, d dVar) {
        this(context, str, i10, dVar, null, null);
    }

    public static void F(v.n nVar, @p0 Bitmap bitmap) {
        nVar.c0(bitmap);
    }

    public static PendingIntent l(String str, Context context, int i10) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra(T, i10);
        return PendingIntent.getBroadcast(context, i10, intent, 134217728);
    }

    public static Map<String, v.b> n(Context context, int i10) {
        HashMap map = new HashMap();
        map.put(M, new v.b(R.drawable.exo_notification_play, context.getString(R.string.exo_controls_play_description), l(M, context, i10)));
        map.put(N, new v.b(R.drawable.exo_notification_pause, context.getString(R.string.exo_controls_pause_description), l(N, context, i10)));
        map.put(S, new v.b(R.drawable.exo_notification_stop, context.getString(R.string.exo_controls_stop_description), l(S, context, i10)));
        map.put(R, new v.b(R.drawable.exo_notification_rewind, context.getString(R.string.exo_controls_rewind_description), l(R, context, i10)));
        map.put(Q, new v.b(R.drawable.exo_notification_fastforward, context.getString(R.string.exo_controls_fastforward_description), l(Q, context, i10)));
        map.put(O, new v.b(R.drawable.exo_notification_previous, context.getString(R.string.exo_controls_previous_description), l(O, context, i10)));
        map.put(P, new v.b(R.drawable.exo_notification_next, context.getString(R.string.exo_controls_next_description), l(P, context, i10)));
        return map;
    }

    public static f o(Context context, String str, @c1 int i10, @c1 int i11, int i12, d dVar) {
        hd.a0.b(context, str, i10, i11, 2);
        return new f(context, str, i12, dVar);
    }

    public static f p(Context context, String str, @c1 int i10, @c1 int i11, int i12, d dVar, @p0 InterfaceC0195f interfaceC0195f) {
        hd.a0.b(context, str, i10, i11, 2);
        return new f(context, str, i12, dVar, interfaceC0195f);
    }

    @Deprecated
    public static f q(Context context, String str, @c1 int i10, int i11, d dVar) {
        return o(context, str, i10, 0, i11, dVar);
    }

    @Deprecated
    public static f r(Context context, String str, @c1 int i10, int i11, d dVar, @p0 InterfaceC0195f interfaceC0195f) {
        return p(context, str, i10, 0, i11, dVar, interfaceC0195f);
    }

    public final void A(int i10) {
        if (this.H != i10) {
            this.H = i10;
            w();
        }
    }

    public final void B(boolean z10) {
        if (this.F != z10) {
            this.F = z10;
            w();
        }
    }

    public final void C(ya.h hVar) {
        if (this.f18781t != hVar) {
            this.f18781t = hVar;
            w();
        }
    }

    public final void D(int i10) {
        if (this.G != i10) {
            this.G = i10;
            w();
        }
    }

    @Deprecated
    public final void E(long j10) {
        ya.h hVar = this.f18781t;
        if (hVar instanceof ya.i) {
            ((ya.i) hVar).q(j10);
            w();
        }
    }

    public final void G(MediaSessionCompat.Token token) {
        if (u0.c(this.f18785x, token)) {
            return;
        }
        this.f18785x = token;
        w();
    }

    @Deprecated
    public final void H(InterfaceC0195f interfaceC0195f) {
        this.f18784w = interfaceC0195f;
    }

    @Deprecated
    public void I(@p0 i1 i1Var) {
        this.f18780s = i1Var;
    }

    public final void J(@p0 j1 j1Var) {
        boolean z10 = true;
        hd.a.i(Looper.myLooper() == Looper.getMainLooper());
        if (j1Var != null && j1Var.p1() != Looper.getMainLooper()) {
            z10 = false;
        }
        hd.a.a(z10);
        j1 j1Var2 = this.f18779r;
        if (j1Var2 == j1Var) {
            return;
        }
        if (j1Var2 != null) {
            j1Var2.K0(this.f18770i);
            if (j1Var == null) {
                Z(false);
            }
        }
        this.f18779r = j1Var;
        if (j1Var != null) {
            j1Var.y(this.f18770i);
            x();
        }
    }

    public final void K(int i10) {
        if (this.K == i10) {
            return;
        }
        if (i10 != -2 && i10 != -1 && i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException();
        }
        this.K = i10;
        w();
    }

    @Deprecated
    public final void L(long j10) {
        ya.h hVar = this.f18781t;
        if (hVar instanceof ya.i) {
            ((ya.i) hVar).r(j10);
            w();
        }
    }

    public final void M(@g.v int i10) {
        if (this.I != i10) {
            this.I = i10;
            w();
        }
    }

    public final void N(boolean z10) {
        if (this.L != z10) {
            this.L = z10;
            w();
        }
    }

    @Deprecated
    public final void O(boolean z10) {
        Q(z10);
        T(z10);
    }

    @Deprecated
    public final void P(boolean z10) {
        R(z10);
        U(z10);
    }

    public void Q(boolean z10) {
        if (this.f18787z != z10) {
            this.f18787z = z10;
            w();
        }
    }

    public void R(boolean z10) {
        if (this.B != z10) {
            this.B = z10;
            w();
        }
    }

    public final void S(boolean z10) {
        if (this.C != z10) {
            this.C = z10;
            w();
        }
    }

    public void T(boolean z10) {
        if (this.f18786y != z10) {
            this.f18786y = z10;
            w();
        }
    }

    public void U(boolean z10) {
        if (this.A != z10) {
            this.A = z10;
            w();
        }
    }

    public final void V(boolean z10) {
        if (this.D == z10) {
            return;
        }
        this.D = z10;
        w();
    }

    public final void W(int i10) {
        if (this.J == i10) {
            return;
        }
        if (i10 != -1 && i10 != 0 && i10 != 1) {
            throw new IllegalStateException();
        }
        this.J = i10;
        w();
    }

    public final boolean X(j1 j1Var) {
        return (j1Var.d() == 4 || j1Var.d() == 1 || !j1Var.D()) ? false : true;
    }

    public final void Y(j1 j1Var, @p0 Bitmap bitmap) {
        boolean zU = u(j1Var);
        v.n nVarM = m(j1Var, this.f18777p, zU, bitmap);
        this.f18777p = nVarM;
        if (nVarM == null) {
            Z(false);
            return;
        }
        Notification notificationH = nVarM.h();
        this.f18768g.C(this.f18764c, notificationH);
        if (!this.f18782u) {
            this.f18762a.registerReceiver(this.f18771j, this.f18769h);
            InterfaceC0195f interfaceC0195f = this.f18784w;
            if (interfaceC0195f != null) {
                interfaceC0195f.b(this.f18764c, notificationH);
            }
        }
        InterfaceC0195f interfaceC0195f2 = this.f18784w;
        if (interfaceC0195f2 != null) {
            interfaceC0195f2.a(this.f18764c, notificationH, zU || !this.f18782u);
        }
        this.f18782u = true;
    }

    public final void Z(boolean z10) {
        if (this.f18782u) {
            this.f18782u = false;
            this.f18767f.removeMessages(0);
            this.f18768g.b(this.f18764c);
            this.f18762a.unregisterReceiver(this.f18771j);
            InterfaceC0195f interfaceC0195f = this.f18784w;
            if (interfaceC0195f != null) {
                interfaceC0195f.d(this.f18764c, z10);
                this.f18784w.c(this.f18764c);
            }
        }
    }

    @p0
    public v.n m(j1 j1Var, @p0 v.n nVar, boolean z10, @p0 Bitmap bitmap) {
        if (j1Var.d() == 1 && j1Var.n1().r()) {
            this.f18778q = null;
            return null;
        }
        List<String> listT = t(j1Var);
        ArrayList arrayList = new ArrayList(listT.size());
        for (int i10 = 0; i10 < listT.size(); i10++) {
            String str = listT.get(i10);
            v.b bVar = this.f18772k.containsKey(str) ? this.f18772k.get(str) : this.f18773l.get(str);
            if (bVar != null) {
                arrayList.add(bVar);
            }
        }
        if (nVar == null || !arrayList.equals(this.f18778q)) {
            nVar = new v.n(this.f18762a, this.f18763b);
            this.f18778q = arrayList;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                nVar.b((v.b) arrayList.get(i11));
            }
        }
        a.b bVar2 = new a.b();
        MediaSessionCompat.Token token = this.f18785x;
        if (token != null) {
            bVar2.I(token);
        }
        bVar2.J(s(listT, j1Var));
        bVar2.K(!z10);
        bVar2.H(this.f18774m);
        nVar.z0(bVar2);
        nVar.U(this.f18774m);
        nVar.E(this.E).i0(z10).J(this.H).K(this.F).t0(this.I).G0(this.J).k0(this.K).T(this.G);
        if (u0.f31154a < 21 || !this.L || !j1Var.N0() || j1Var.r() || j1Var.j0() || j1Var.e().f56785a != 1.0f) {
            nVar.r0(false).E0(false);
        } else {
            nVar.H0(System.currentTimeMillis() - j1Var.C0()).r0(true).E0(true);
        }
        nVar.P(this.f18765d.a(j1Var));
        nVar.O(this.f18765d.c(j1Var));
        nVar.A0(this.f18765d.b(j1Var));
        if (bitmap == null) {
            d dVar = this.f18765d;
            int i12 = this.f18783v + 1;
            this.f18783v = i12;
            bitmap = dVar.d(j1Var, new b(i12));
        }
        F(nVar, bitmap);
        nVar.N(this.f18765d.e(j1Var));
        return nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] s(java.util.List<java.lang.String> r7, ya.j1 r8) {
        /*
            r6 = this;
            java.lang.String r0 = "com.google.android.exoplayer.pause"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "com.google.android.exoplayer.play"
            int r1 = r7.indexOf(r1)
            boolean r2 = r6.A
            r3 = -1
            if (r2 == 0) goto L18
            java.lang.String r2 = "com.google.android.exoplayer.prev"
            int r2 = r7.indexOf(r2)
            goto L19
        L18:
            r2 = -1
        L19:
            boolean r4 = r6.B
            if (r4 == 0) goto L24
            java.lang.String r4 = "com.google.android.exoplayer.next"
            int r7 = r7.indexOf(r4)
            goto L25
        L24:
            r7 = -1
        L25:
            r4 = 3
            int[] r4 = new int[r4]
            r5 = 0
            if (r2 == r3) goto L2e
            r4[r5] = r2
            r5 = 1
        L2e:
            boolean r8 = r6.X(r8)
            if (r0 == r3) goto L3c
            if (r8 == 0) goto L3c
            int r8 = r5 + 1
            r4[r5] = r0
        L3a:
            r5 = r8
            goto L45
        L3c:
            if (r1 == r3) goto L45
            if (r8 != 0) goto L45
            int r8 = r5 + 1
            r4[r5] = r1
            goto L3a
        L45:
            if (r7 == r3) goto L4c
            int r8 = r5 + 1
            r4[r5] = r7
            r5 = r8
        L4c:
            int[] r7 = java.util.Arrays.copyOf(r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.f.s(java.util.List, ya.j1):int[]");
    }

    public List<String> t(j1 j1Var) {
        boolean z10;
        boolean z11;
        boolean z12;
        x1 x1VarN1 = j1Var.n1();
        if (x1VarN1.r() || j1Var.r()) {
            z10 = false;
            z11 = false;
            z12 = false;
        } else {
            x1VarN1.n(j1Var.r0(), this.f18776o);
            x1.c cVar = this.f18776o;
            boolean z13 = cVar.f57247h;
            boolean z14 = z13 || !cVar.h() || j1Var.hasPrevious();
            z12 = z13 && this.f18781t.e();
            z11 = z13 && this.f18781t.m();
            z = z14;
            z10 = (this.f18776o.h() && this.f18776o.f57248i) || j1Var.hasNext();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f18786y && z) {
            arrayList.add(O);
        }
        if (z12) {
            arrayList.add(R);
        }
        if (this.C) {
            if (X(j1Var)) {
                arrayList.add(N);
            } else {
                arrayList.add(M);
            }
        }
        if (z11) {
            arrayList.add(Q);
        }
        if (this.f18787z && z10) {
            arrayList.add(P);
        }
        c cVar2 = this.f18766e;
        if (cVar2 != null) {
            arrayList.addAll(cVar2.c(j1Var));
        }
        if (this.D) {
            arrayList.add(S);
        }
        return arrayList;
    }

    public boolean u(j1 j1Var) {
        int iD = j1Var.d();
        return (iD == 2 || iD == 3) && j1Var.D();
    }

    public final boolean v(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            j1 j1Var = this.f18779r;
            if (j1Var != null) {
                Y(j1Var, null);
            }
        } else {
            if (i10 != 1) {
                return false;
            }
            j1 j1Var2 = this.f18779r;
            if (j1Var2 != null && this.f18782u && this.f18783v == message.arg1) {
                Y(j1Var2, (Bitmap) message.obj);
            }
        }
        return true;
    }

    public void w() {
        if (this.f18782u) {
            x();
        }
    }

    public final void x() {
        if (this.f18767f.hasMessages(0)) {
            return;
        }
        this.f18767f.sendEmptyMessage(0);
    }

    public final void y(Bitmap bitmap, int i10) {
        this.f18767f.obtainMessage(1, i10, -1, bitmap).sendToTarget();
    }

    public final void z(int i10) {
        if (this.E == i10) {
            return;
        }
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException();
        }
        this.E = i10;
        w();
    }

    public f(Context context, String str, int i10, d dVar, @p0 InterfaceC0195f interfaceC0195f) {
        this(context, str, i10, dVar, interfaceC0195f, null);
    }

    public f(Context context, String str, int i10, d dVar, @p0 c cVar) {
        this(context, str, i10, dVar, null, cVar);
    }

    public f(Context context, String str, int i10, d dVar, @p0 InterfaceC0195f interfaceC0195f, @p0 c cVar) {
        Map<String, v.b> mapEmptyMap;
        Context applicationContext = context.getApplicationContext();
        this.f18762a = applicationContext;
        this.f18763b = str;
        this.f18764c = i10;
        this.f18765d = dVar;
        this.f18784w = interfaceC0195f;
        this.f18766e = cVar;
        this.f18781t = new ya.i();
        this.f18776o = new x1.c();
        int i11 = X;
        X = i11 + 1;
        this.f18775n = i11;
        this.f18767f = u0.y(Looper.getMainLooper(), new Handler.Callback() { // from class: cd.i
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f10876a.v(message);
            }
        });
        this.f18768g = a0.p(applicationContext);
        this.f18770i = new g();
        this.f18771j = new e();
        this.f18769h = new IntentFilter();
        this.f18786y = true;
        this.f18787z = true;
        this.C = true;
        this.F = true;
        this.L = true;
        this.H = 0;
        this.I = R.drawable.exo_notification_small_icon;
        this.G = 0;
        this.K = -1;
        this.E = 1;
        this.J = 1;
        Map<String, v.b> mapN = n(applicationContext, i11);
        this.f18772k = mapN;
        Iterator<String> it2 = mapN.keySet().iterator();
        while (it2.hasNext()) {
            this.f18769h.addAction(it2.next());
        }
        if (cVar != null) {
            mapEmptyMap = cVar.a(applicationContext, this.f18775n);
        } else {
            mapEmptyMap = Collections.emptyMap();
        }
        this.f18773l = mapEmptyMap;
        Iterator<String> it3 = mapEmptyMap.keySet().iterator();
        while (it3.hasNext()) {
            this.f18769h.addAction(it3.next());
        }
        this.f18774m = l(U, applicationContext, this.f18775n);
        this.f18769h.addAction(U);
    }
}
