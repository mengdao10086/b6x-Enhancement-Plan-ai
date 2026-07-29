package cc;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cc.w;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import dc.b;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static final int A = 4;
    public static final int B = 5;
    public static final int C = 6;
    public static final int D = 7;
    public static final int E = 8;
    public static final int F = 9;
    public static final int G = 10;
    public static final int H = 11;
    public static final int I = 12;
    public static final String J = "DownloadManager";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f10757q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f10758r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Requirements f10759s = new Requirements(1);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10760t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f10761u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f10762v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f10763w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f10764x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f10765y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f10766z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f10768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f10769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f10770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b.c f10771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<d> f10772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<cc.c> f10781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public dc.b f10782p;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f10783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<cc.c> f10785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final Exception f10786d;

        public b(cc.c cVar, boolean z10, List<cc.c> list, @p0 Exception exc) {
            this.f10783a = cVar;
            this.f10784b = z10;
            this.f10785c = list;
            this.f10786d = exc;
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f10787m = 5000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f10789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d0 f10790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final x f10791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Handler f10792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList<cc.c> f10793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap<String, e> f10794g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f10795h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f10796i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f10797j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f10798k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f10799l;

        public c(HandlerThread handlerThread, d0 d0Var, x xVar, Handler handler, int i10, int i11, boolean z10) {
            super(handlerThread.getLooper());
            this.f10789b = handlerThread;
            this.f10790c = d0Var;
            this.f10791d = xVar;
            this.f10792e = handler;
            this.f10797j = i10;
            this.f10798k = i11;
            this.f10796i = z10;
            this.f10793f = new ArrayList<>();
            this.f10794g = new HashMap<>();
        }

        public static int d(cc.c cVar, cc.c cVar2) {
            return u0.r(cVar.f10713c, cVar2.f10713c);
        }

        public static cc.c e(cc.c cVar, int i10, int i11) {
            return new cc.c(cVar.f10711a, i10, cVar.f10713c, System.currentTimeMillis(), cVar.f10715e, i11, 0, cVar.f10718h);
        }

        public final void A(@p0 e eVar) {
            if (eVar != null) {
                hd.a.i(!eVar.f10803d);
                eVar.f(false);
            }
        }

        public final void B() {
            int i10 = 0;
            for (int i11 = 0; i11 < this.f10793f.size(); i11++) {
                cc.c cVar = this.f10793f.get(i11);
                e eVarY = this.f10794g.get(cVar.f10711a.f17407a);
                int i12 = cVar.f10712b;
                if (i12 == 0) {
                    eVarY = y(eVarY, cVar);
                } else if (i12 == 1) {
                    A(eVarY);
                } else if (i12 == 2) {
                    hd.a.g(eVarY);
                    x(eVarY, cVar, i10);
                } else {
                    if (i12 != 5 && i12 != 7) {
                        throw new IllegalStateException();
                    }
                    z(eVarY, cVar);
                }
                if (eVarY != null && !eVarY.f10803d) {
                    i10++;
                }
            }
        }

        public final void C() {
            for (int i10 = 0; i10 < this.f10793f.size(); i10++) {
                cc.c cVar = this.f10793f.get(i10);
                if (cVar.f10712b == 2) {
                    try {
                        this.f10790c.d(cVar);
                    } catch (IOException e10) {
                        hd.t.e(p.J, "Failed to update index.", e10);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000L);
        }

        public final void b(DownloadRequest downloadRequest, int i10) {
            cc.c cVarF = f(downloadRequest.f17407a, true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (cVarF != null) {
                m(p.r(cVarF, downloadRequest, i10, jCurrentTimeMillis));
            } else {
                m(new cc.c(downloadRequest, i10 != 0 ? 1 : 0, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i10, 0));
            }
            B();
        }

        public final boolean c() {
            return !this.f10796i && this.f10795h == 0;
        }

        @p0
        public final cc.c f(String str, boolean z10) {
            int iG = g(str);
            if (iG != -1) {
                return this.f10793f.get(iG);
            }
            if (!z10) {
                return null;
            }
            try {
                return this.f10790c.f(str);
            } catch (IOException e10) {
                hd.t.e(p.J, "Failed to load download: " + str, e10);
                return null;
            }
        }

        public final int g(String str) {
            for (int i10 = 0; i10 < this.f10793f.size(); i10++) {
                if (this.f10793f.get(i10).f10711a.f17407a.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public final void h(int i10) {
            this.f10795h = i10;
            cc.e eVarA = null;
            try {
                try {
                    this.f10790c.e();
                    eVarA = this.f10790c.a(0, 1, 2, 5, 7);
                    while (eVarA.moveToNext()) {
                        this.f10793f.add(eVarA.D1());
                    }
                } catch (IOException e10) {
                    hd.t.e(p.J, "Failed to load index.", e10);
                    this.f10793f.clear();
                }
                u0.q(eVarA);
                this.f10792e.obtainMessage(0, new ArrayList(this.f10793f)).sendToTarget();
                B();
            } catch (Throwable th2) {
                u0.q(eVarA);
                throw th2;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = 0;
            switch (message.what) {
                case 0:
                    h(message.arg1);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 1:
                    r(message.arg1 != 0);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 2:
                    u(message.arg1);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 3:
                    w((String) message.obj, message.arg1);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 4:
                    s(message.arg1);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 5:
                    t(message.arg1);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 6:
                    b((DownloadRequest) message.obj, message.arg1);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 7:
                    q((String) message.obj);
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 8:
                    p();
                    i10 = 1;
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 9:
                    l((e) message.obj);
                    this.f10792e.obtainMessage(1, i10, this.f10794g.size()).sendToTarget();
                    return;
                case 10:
                    i((e) message.obj, u0.v1(message.arg1, message.arg2));
                    return;
                case 11:
                    C();
                    return;
                case 12:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
        }

        public final void i(e eVar, long j10) {
            cc.c cVar = (cc.c) hd.a.g(f(eVar.f10800a.f17407a, false));
            if (j10 == cVar.f10715e || j10 == -1) {
                return;
            }
            m(new cc.c(cVar.f10711a, cVar.f10712b, cVar.f10713c, System.currentTimeMillis(), j10, cVar.f10716f, cVar.f10717g, cVar.f10718h));
        }

        public final void j(cc.c cVar, @p0 Exception exc) {
            cc.c cVar2 = new cc.c(cVar.f10711a, exc == null ? 3 : 4, cVar.f10713c, System.currentTimeMillis(), cVar.f10715e, cVar.f10716f, exc == null ? 0 : 1, cVar.f10718h);
            this.f10793f.remove(g(cVar2.f10711a.f17407a));
            try {
                this.f10790c.d(cVar2);
            } catch (IOException e10) {
                hd.t.e(p.J, "Failed to update index.", e10);
            }
            this.f10792e.obtainMessage(2, new b(cVar2, false, new ArrayList(this.f10793f), exc)).sendToTarget();
        }

        public final void k(cc.c cVar) {
            if (cVar.f10712b == 7) {
                int i10 = cVar.f10716f;
                n(cVar, i10 == 0 ? 0 : 1, i10);
                B();
            } else {
                this.f10793f.remove(g(cVar.f10711a.f17407a));
                try {
                    this.f10790c.g(cVar.f10711a.f17407a);
                } catch (IOException unused) {
                    hd.t.d(p.J, "Failed to remove from database");
                }
                this.f10792e.obtainMessage(2, new b(cVar, true, new ArrayList(this.f10793f), null)).sendToTarget();
            }
        }

        public final void l(e eVar) {
            String str = eVar.f10800a.f17407a;
            this.f10794g.remove(str);
            boolean z10 = eVar.f10803d;
            if (!z10) {
                int i10 = this.f10799l - 1;
                this.f10799l = i10;
                if (i10 == 0) {
                    removeMessages(11);
                }
            }
            if (eVar.f10806g) {
                B();
                return;
            }
            Exception exc = eVar.f10807h;
            if (exc != null) {
                hd.t.e(p.J, "Task failed: " + eVar.f10800a + ", " + z10, exc);
            }
            cc.c cVar = (cc.c) hd.a.g(f(str, false));
            int i11 = cVar.f10712b;
            if (i11 == 2) {
                hd.a.i(!z10);
                j(cVar, exc);
            } else {
                if (i11 != 5 && i11 != 7) {
                    throw new IllegalStateException();
                }
                hd.a.i(z10);
                k(cVar);
            }
            B();
        }

        public final cc.c m(cc.c cVar) {
            int i10 = cVar.f10712b;
            hd.a.i((i10 == 3 || i10 == 4) ? false : true);
            int iG = g(cVar.f10711a.f17407a);
            if (iG == -1) {
                this.f10793f.add(cVar);
                Collections.sort(this.f10793f, q.f10809a);
            } else {
                boolean z10 = cVar.f10713c != this.f10793f.get(iG).f10713c;
                this.f10793f.set(iG, cVar);
                if (z10) {
                    Collections.sort(this.f10793f, q.f10809a);
                }
            }
            try {
                this.f10790c.d(cVar);
            } catch (IOException e10) {
                hd.t.e(p.J, "Failed to update index.", e10);
            }
            this.f10792e.obtainMessage(2, new b(cVar, false, new ArrayList(this.f10793f), null)).sendToTarget();
            return cVar;
        }

        public final cc.c n(cc.c cVar, int i10, int i11) {
            hd.a.i((i10 == 3 || i10 == 4) ? false : true);
            return m(e(cVar, i10, i11));
        }

        public final void o() {
            Iterator<e> it2 = this.f10794g.values().iterator();
            while (it2.hasNext()) {
                it2.next().f(true);
            }
            try {
                this.f10790c.e();
            } catch (IOException e10) {
                hd.t.e(p.J, "Failed to update index.", e10);
            }
            this.f10793f.clear();
            this.f10789b.quit();
            synchronized (this) {
                this.f10788a = true;
                notifyAll();
            }
        }

        public final void p() {
            ArrayList arrayList = new ArrayList();
            try {
                cc.e eVarA = this.f10790c.a(3, 4);
                while (eVarA.moveToNext()) {
                    try {
                        arrayList.add(eVarA.D1());
                    } finally {
                    }
                }
                eVarA.close();
            } catch (IOException unused) {
                hd.t.d(p.J, "Failed to load downloads.");
            }
            for (int i10 = 0; i10 < this.f10793f.size(); i10++) {
                ArrayList<cc.c> arrayList2 = this.f10793f;
                arrayList2.set(i10, e(arrayList2.get(i10), 5, 0));
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                this.f10793f.add(e((cc.c) arrayList.get(i11), 5, 0));
            }
            Collections.sort(this.f10793f, q.f10809a);
            try {
                this.f10790c.b();
            } catch (IOException e10) {
                hd.t.e(p.J, "Failed to update index.", e10);
            }
            ArrayList arrayList3 = new ArrayList(this.f10793f);
            for (int i12 = 0; i12 < this.f10793f.size(); i12++) {
                this.f10792e.obtainMessage(2, new b(this.f10793f.get(i12), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        public final void q(String str) {
            cc.c cVarF = f(str, true);
            if (cVarF != null) {
                n(cVarF, 5, 0);
                B();
            } else {
                hd.t.d(p.J, "Failed to remove nonexistent download: " + str);
            }
        }

        public final void r(boolean z10) {
            this.f10796i = z10;
            B();
        }

        public final void s(int i10) {
            this.f10797j = i10;
            B();
        }

        public final void t(int i10) {
            this.f10798k = i10;
        }

        public final void u(int i10) {
            this.f10795h = i10;
            B();
        }

        public final void v(cc.c cVar, int i10) {
            if (i10 == 0) {
                if (cVar.f10712b == 1) {
                    n(cVar, 0, 0);
                }
            } else if (i10 != cVar.f10716f) {
                int i11 = cVar.f10712b;
                if (i11 == 0 || i11 == 2) {
                    i11 = 1;
                }
                m(new cc.c(cVar.f10711a, i11, cVar.f10713c, System.currentTimeMillis(), cVar.f10715e, i10, 0, cVar.f10718h));
            }
        }

        public final void w(@p0 String str, int i10) {
            if (str == null) {
                for (int i11 = 0; i11 < this.f10793f.size(); i11++) {
                    v(this.f10793f.get(i11), i10);
                }
                try {
                    this.f10790c.h(i10);
                } catch (IOException e10) {
                    hd.t.e(p.J, "Failed to set manual stop reason", e10);
                }
            } else {
                cc.c cVarF = f(str, false);
                if (cVarF != null) {
                    v(cVarF, i10);
                } else {
                    try {
                        this.f10790c.c(str, i10);
                    } catch (IOException e11) {
                        hd.t.e(p.J, "Failed to set manual stop reason: " + str, e11);
                    }
                }
            }
            B();
        }

        public final void x(e eVar, cc.c cVar, int i10) {
            hd.a.i(!eVar.f10803d);
            if (!c() || i10 >= this.f10797j) {
                n(cVar, 0, 0);
                eVar.f(false);
            }
        }

        @p0
        @g.j
        public final e y(@p0 e eVar, cc.c cVar) {
            if (eVar != null) {
                hd.a.i(!eVar.f10803d);
                eVar.f(false);
                return eVar;
            }
            if (!c() || this.f10799l >= this.f10797j) {
                return null;
            }
            cc.c cVarN = n(cVar, 2, 0);
            e eVar2 = new e(cVarN.f10711a, this.f10791d.a(cVarN.f10711a), cVarN.f10718h, false, this.f10798k, this);
            this.f10794g.put(cVarN.f10711a.f17407a, eVar2);
            int i10 = this.f10799l;
            this.f10799l = i10 + 1;
            if (i10 == 0) {
                sendEmptyMessageDelayed(11, 5000L);
            }
            eVar2.start();
            return eVar2;
        }

        public final void z(@p0 e eVar, cc.c cVar) {
            if (eVar != null) {
                if (eVar.f10803d) {
                    return;
                }
                eVar.f(false);
            } else {
                e eVar2 = new e(cVar.f10711a, this.f10791d.a(cVar.f10711a), cVar.f10718h, true, this.f10798k, this);
                this.f10794g.put(cVar.f10711a.f17407a, eVar2);
                eVar2.start();
            }
        }
    }

    public interface d {
        void a(p pVar);

        void b(p pVar, boolean z10);

        void c(p pVar);

        void d(p pVar, boolean z10);

        void e(p pVar, Requirements requirements, int i10);

        void f(p pVar, cc.c cVar);

        void g(p pVar, cc.c cVar, @p0 Exception exc);
    }

    public static class e extends Thread implements w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DownloadRequest f10800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f10801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s f10802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f10803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f10804e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public volatile c f10805f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f10806g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public Exception f10807h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f10808i;

        public static int g(int i10) {
            return Math.min((i10 - 1) * 1000, 5000);
        }

        @Override // cc.w.a
        public void a(long j10, long j11, float f10) {
            this.f10802c.f10810a = j11;
            this.f10802c.f10811b = f10;
            if (j10 != this.f10808i) {
                this.f10808i = j10;
                c cVar = this.f10805f;
                if (cVar != null) {
                    cVar.obtainMessage(10, (int) (j10 >> 32), (int) j10, this).sendToTarget();
                }
            }
        }

        public void f(boolean z10) {
            if (z10) {
                this.f10805f = null;
            }
            if (this.f10806g) {
                return;
            }
            this.f10806g = true;
            this.f10801b.cancel();
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.f10803d) {
                    this.f10801b.remove();
                } else {
                    long j10 = -1;
                    int i10 = 0;
                    while (!this.f10806g) {
                        try {
                            this.f10801b.a(this);
                            break;
                        } catch (IOException e10) {
                            if (!this.f10806g) {
                                long j11 = this.f10802c.f10810a;
                                if (j11 != j10) {
                                    j10 = j11;
                                    i10 = 0;
                                }
                                i10++;
                                if (i10 > this.f10804e) {
                                    throw e10;
                                }
                                Thread.sleep(g(i10));
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e11) {
                this.f10807h = e11;
            }
            c cVar = this.f10805f;
            if (cVar != null) {
                cVar.obtainMessage(9, this).sendToTarget();
            }
        }

        public e(DownloadRequest downloadRequest, w wVar, s sVar, boolean z10, int i10, c cVar) {
            this.f10800a = downloadRequest;
            this.f10801b = wVar;
            this.f10802c = sVar;
            this.f10803d = z10;
            this.f10804e = i10;
            this.f10805f = cVar;
            this.f10808i = -1L;
        }
    }

    @Deprecated
    public p(Context context, db.a aVar, Cache cache, a.InterfaceC0197a interfaceC0197a) {
        this(context, aVar, cache, interfaceC0197a, androidx.profileinstaller.f.f6454a);
    }

    public static cc.c r(cc.c cVar, DownloadRequest downloadRequest, int i10, long j10) {
        int i11 = cVar.f10712b;
        return new cc.c(cVar.f10711a.e(downloadRequest), (i11 == 5 || i11 == 7) ? 7 : i10 != 0 ? 1 : 0, (i11 == 5 || cVar.c()) ? j10 : cVar.f10713c, j10, -1L, i10, 0);
    }

    public void A(String str) {
        this.f10773g++;
        this.f10770d.obtainMessage(7, str).sendToTarget();
    }

    public void B(d dVar) {
        this.f10772f.remove(dVar);
    }

    public void C() {
        D(false);
    }

    public final void D(boolean z10) {
        if (this.f10776j == z10) {
            return;
        }
        this.f10776j = z10;
        this.f10773g++;
        this.f10770d.obtainMessage(1, z10 ? 1 : 0, 0).sendToTarget();
        boolean zI = I();
        Iterator<d> it2 = this.f10772f.iterator();
        while (it2.hasNext()) {
            it2.next().b(this, z10);
        }
        if (zI) {
            s();
        }
    }

    public void E(int i10) {
        hd.a.a(i10 > 0);
        if (this.f10777k == i10) {
            return;
        }
        this.f10777k = i10;
        this.f10773g++;
        this.f10770d.obtainMessage(4, i10, 0).sendToTarget();
    }

    public void F(int i10) {
        hd.a.a(i10 >= 0);
        if (this.f10778l == i10) {
            return;
        }
        this.f10778l = i10;
        this.f10773g++;
        this.f10770d.obtainMessage(5, i10, 0).sendToTarget();
    }

    public void G(Requirements requirements) {
        if (requirements.equals(this.f10782p.f())) {
            return;
        }
        this.f10782p.j();
        dc.b bVar = new dc.b(this.f10767a, this.f10771e, requirements);
        this.f10782p = bVar;
        w(this.f10782p, bVar.i());
    }

    public void H(@p0 String str, int i10) {
        this.f10773g++;
        this.f10770d.obtainMessage(3, i10, 0, str).sendToTarget();
    }

    public final boolean I() {
        boolean z10;
        if (this.f10776j || this.f10779m == 0) {
            z10 = false;
        } else {
            for (int i10 = 0; i10 < this.f10781o.size(); i10++) {
                if (this.f10781o.get(i10).f10712b == 0) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        boolean z11 = this.f10780n != z10;
        this.f10780n = z10;
        return z11;
    }

    public void c(DownloadRequest downloadRequest) {
        d(downloadRequest, 0);
    }

    public void d(DownloadRequest downloadRequest, int i10) {
        this.f10773g++;
        this.f10770d.obtainMessage(6, i10, 0, downloadRequest).sendToTarget();
    }

    public void e(d dVar) {
        hd.a.g(dVar);
        this.f10772f.add(dVar);
    }

    public Looper f() {
        return this.f10769c.getLooper();
    }

    public List<cc.c> g() {
        return this.f10781o;
    }

    public m h() {
        return this.f10768b;
    }

    public boolean i() {
        return this.f10776j;
    }

    public int j() {
        return this.f10777k;
    }

    public int k() {
        return this.f10778l;
    }

    public int l() {
        return this.f10779m;
    }

    public Requirements m() {
        return this.f10782p.f();
    }

    public final boolean n(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            u((List) message.obj);
        } else if (i10 == 1) {
            v(message.arg1, message.arg2);
        } else {
            if (i10 != 2) {
                throw new IllegalStateException();
            }
            t((b) message.obj);
        }
        return true;
    }

    public boolean o() {
        return this.f10774h == 0 && this.f10773g == 0;
    }

    public boolean p() {
        return this.f10775i;
    }

    public boolean q() {
        return this.f10780n;
    }

    public final void s() {
        Iterator<d> it2 = this.f10772f.iterator();
        while (it2.hasNext()) {
            it2.next().d(this, this.f10780n);
        }
    }

    public final void t(b bVar) {
        this.f10781o = Collections.unmodifiableList(bVar.f10785c);
        cc.c cVar = bVar.f10783a;
        boolean zI = I();
        if (bVar.f10784b) {
            Iterator<d> it2 = this.f10772f.iterator();
            while (it2.hasNext()) {
                it2.next().f(this, cVar);
            }
        } else {
            Iterator<d> it3 = this.f10772f.iterator();
            while (it3.hasNext()) {
                it3.next().g(this, cVar, bVar.f10786d);
            }
        }
        if (zI) {
            s();
        }
    }

    public final void u(List<cc.c> list) {
        this.f10775i = true;
        this.f10781o = Collections.unmodifiableList(list);
        boolean zI = I();
        Iterator<d> it2 = this.f10772f.iterator();
        while (it2.hasNext()) {
            it2.next().c(this);
        }
        if (zI) {
            s();
        }
    }

    public final void v(int i10, int i11) {
        this.f10773g -= i10;
        this.f10774h = i11;
        if (o()) {
            Iterator<d> it2 = this.f10772f.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
        }
    }

    public final void w(dc.b bVar, int i10) {
        Requirements requirementsF = bVar.f();
        if (this.f10779m != i10) {
            this.f10779m = i10;
            this.f10773g++;
            this.f10770d.obtainMessage(2, i10, 0).sendToTarget();
        }
        boolean zI = I();
        Iterator<d> it2 = this.f10772f.iterator();
        while (it2.hasNext()) {
            it2.next().e(this, requirementsF, i10);
        }
        if (zI) {
            s();
        }
    }

    public void x() {
        D(true);
    }

    public void y() {
        synchronized (this.f10770d) {
            c cVar = this.f10770d;
            if (cVar.f10788a) {
                return;
            }
            cVar.sendEmptyMessage(12);
            boolean z10 = false;
            while (true) {
                c cVar2 = this.f10770d;
                if (cVar2.f10788a) {
                    break;
                }
                try {
                    cVar2.wait();
                } catch (InterruptedException unused) {
                    z10 = true;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            this.f10769c.removeCallbacksAndMessages(null);
            this.f10781o = Collections.emptyList();
            this.f10773g = 0;
            this.f10774h = 0;
            this.f10775i = false;
            this.f10779m = 0;
            this.f10780n = false;
        }
    }

    public void z() {
        this.f10773g++;
        this.f10770d.obtainMessage(8).sendToTarget();
    }

    public p(Context context, db.a aVar, Cache cache, a.InterfaceC0197a interfaceC0197a, Executor executor) {
        this(context, new com.google.android.exoplayer2.offline.b(aVar), new cc.b(new a.d().k(cache).q(interfaceC0197a), executor));
    }

    public p(Context context, d0 d0Var, x xVar) {
        this.f10767a = context.getApplicationContext();
        this.f10768b = d0Var;
        this.f10777k = 3;
        this.f10778l = 5;
        this.f10776j = true;
        this.f10781o = Collections.emptyList();
        this.f10772f = new CopyOnWriteArraySet<>();
        Handler handlerC = u0.C(new Handler.Callback() { // from class: cc.n
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f10755a.n(message);
            }
        });
        this.f10769c = handlerC;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        c cVar = new c(handlerThread, d0Var, xVar, handlerC, this.f10777k, this.f10778l, this.f10776j);
        this.f10770d = cVar;
        b.c cVar2 = new b.c() { // from class: cc.o
            @Override // dc.b.c
            public final void a(dc.b bVar, int i10) {
                this.f10756a.w(bVar, i10);
            }
        };
        this.f10771e = cVar2;
        dc.b bVar = new dc.b(context, cVar2, f10759s);
        this.f10782p = bVar;
        int i10 = bVar.i();
        this.f10779m = i10;
        this.f10773g = 1;
        cVar.obtainMessage(0, i10, 0).sendToTarget();
    }
}
