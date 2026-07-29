package cc;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import cc.p;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.scheduler.Requirements;
import g.c1;
import g.p0;
import hd.u0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t extends Service {
    public static final String A = "DownloadService";
    public static final HashMap<Class<? extends t>, b> B = new HashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10812k = "com.google.android.exoplayer.downloadService.action.INIT";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10813l = "com.google.android.exoplayer.downloadService.action.RESTART";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10814m = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10815n = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10816o = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10817p = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f10818q = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f10819r = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10820s = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f10821t = "download_request";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f10822u = "content_id";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f10823v = "stop_reason";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f10824w = "requirements";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f10825x = "foreground";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f10826y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f10827z = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final c f10828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f10829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c1
    public final int f10830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c1
    public final int f10831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f10832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10835h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10836i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10837j;

    public static final class b implements p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f10838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f10839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f10840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final dc.e f10841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class<? extends t> f10842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public t f10843f;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(t tVar) {
            tVar.A(this.f10839b.g());
        }

        @Override // cc.p.d
        public final void a(p pVar) {
            t tVar = this.f10843f;
            if (tVar != null) {
                tVar.O();
            }
        }

        @Override // cc.p.d
        public /* synthetic */ void b(p pVar, boolean z10) {
            r.c(this, pVar, z10);
        }

        @Override // cc.p.d
        public void c(p pVar) {
            t tVar = this.f10843f;
            if (tVar != null) {
                tVar.A(pVar.g());
            }
        }

        @Override // cc.p.d
        public void d(p pVar, boolean z10) {
            if (!z10 && !pVar.i() && n()) {
                List<cc.c> listG = pVar.g();
                int i10 = 0;
                while (true) {
                    if (i10 >= listG.size()) {
                        break;
                    }
                    if (listG.get(i10).f10712b == 0) {
                        m();
                        break;
                    }
                    i10++;
                }
            }
            o();
        }

        @Override // cc.p.d
        public /* synthetic */ void e(p pVar, Requirements requirements, int i10) {
            r.f(this, pVar, requirements, i10);
        }

        @Override // cc.p.d
        public void f(p pVar, cc.c cVar) {
            t tVar = this.f10843f;
            if (tVar != null) {
                tVar.z(cVar);
            }
        }

        @Override // cc.p.d
        public void g(p pVar, cc.c cVar, @p0 Exception exc) {
            t tVar = this.f10843f;
            if (tVar != null) {
                tVar.y(cVar);
            }
            if (n() && t.x(cVar.f10712b)) {
                hd.t.n(t.A, "DownloadService wasn't running. Restarting.");
                m();
            }
        }

        public void j(final t tVar) {
            hd.a.i(this.f10843f == null);
            this.f10843f = tVar;
            if (this.f10839b.p()) {
                u0.B().postAtFrontOfQueue(new Runnable() { // from class: cc.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10850a.l(tVar);
                    }
                });
            }
        }

        public void k(t tVar) {
            hd.a.i(this.f10843f == tVar);
            this.f10843f = null;
            if (this.f10841d == null || this.f10839b.q()) {
                return;
            }
            this.f10841d.cancel();
        }

        public final void m() {
            if (this.f10840c) {
                u0.q1(this.f10838a, t.s(this.f10838a, this.f10842e, t.f10813l));
            } else {
                try {
                    this.f10838a.startService(t.s(this.f10838a, this.f10842e, t.f10812k));
                } catch (IllegalStateException unused) {
                    hd.t.n(t.A, "Failed to restart DownloadService (process is idle).");
                }
            }
        }

        public final boolean n() {
            t tVar = this.f10843f;
            return tVar == null || tVar.w();
        }

        public final void o() {
            if (this.f10841d == null) {
                return;
            }
            if (!this.f10839b.q()) {
                this.f10841d.cancel();
                return;
            }
            String packageName = this.f10838a.getPackageName();
            if (this.f10841d.a(this.f10839b.m(), packageName, t.f10813l)) {
                return;
            }
            hd.t.d(t.A, "Scheduling downloads failed.");
        }

        public b(Context context, p pVar, boolean z10, @p0 dc.e eVar, Class<? extends t> cls) {
            this.f10838a = context;
            this.f10839b = pVar;
            this.f10840c = z10;
            this.f10841d = eVar;
            this.f10842e = cls;
            pVar.e(this);
            o();
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f10846c = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10848e;

        public c(int i10, long j10) {
            this.f10844a = i10;
            this.f10845b = j10;
        }

        public void b() {
            if (this.f10848e) {
                f();
            }
        }

        public void c() {
            if (this.f10848e) {
                return;
            }
            f();
        }

        public void d() {
            this.f10847d = true;
            f();
        }

        public void e() {
            this.f10847d = false;
            this.f10846c.removeCallbacksAndMessages(null);
        }

        public final void f() {
            List<cc.c> listG = ((p) hd.a.g(t.this.f10832e)).g();
            t tVar = t.this;
            tVar.startForeground(this.f10844a, tVar.r(listG));
            this.f10848e = true;
            if (this.f10847d) {
                this.f10846c.removeCallbacksAndMessages(null);
                this.f10846c.postDelayed(new Runnable() { // from class: cc.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10852a.f();
                    }
                }, this.f10845b);
            }
        }
    }

    public t(int i10) {
        this(i10, 1000L);
    }

    public static void D(Context context, Class<? extends t> cls, DownloadRequest downloadRequest, int i10, boolean z10) {
        N(context, i(context, cls, downloadRequest, i10, z10), z10);
    }

    public static void E(Context context, Class<? extends t> cls, DownloadRequest downloadRequest, boolean z10) {
        N(context, j(context, cls, downloadRequest, z10), z10);
    }

    public static void F(Context context, Class<? extends t> cls, boolean z10) {
        N(context, k(context, cls, z10), z10);
    }

    public static void G(Context context, Class<? extends t> cls, boolean z10) {
        N(context, l(context, cls, z10), z10);
    }

    public static void H(Context context, Class<? extends t> cls, String str, boolean z10) {
        N(context, m(context, cls, str, z10), z10);
    }

    public static void I(Context context, Class<? extends t> cls, boolean z10) {
        N(context, n(context, cls, z10), z10);
    }

    public static void J(Context context, Class<? extends t> cls, Requirements requirements, boolean z10) {
        N(context, o(context, cls, requirements, z10), z10);
    }

    public static void K(Context context, Class<? extends t> cls, @p0 String str, int i10, boolean z10) {
        N(context, p(context, cls, str, i10, z10), z10);
    }

    public static void L(Context context, Class<? extends t> cls) {
        context.startService(s(context, cls, f10812k));
    }

    public static void M(Context context, Class<? extends t> cls) {
        u0.q1(context, t(context, cls, f10812k, true));
    }

    public static void N(Context context, Intent intent, boolean z10) {
        if (z10) {
            u0.q1(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Intent i(Context context, Class<? extends t> cls, DownloadRequest downloadRequest, int i10, boolean z10) {
        return t(context, cls, f10814m, z10).putExtra(f10821t, downloadRequest).putExtra("stop_reason", i10);
    }

    public static Intent j(Context context, Class<? extends t> cls, DownloadRequest downloadRequest, boolean z10) {
        return i(context, cls, downloadRequest, 0, z10);
    }

    public static Intent k(Context context, Class<? extends t> cls, boolean z10) {
        return t(context, cls, f10818q, z10);
    }

    public static Intent l(Context context, Class<? extends t> cls, boolean z10) {
        return t(context, cls, f10816o, z10);
    }

    public static Intent m(Context context, Class<? extends t> cls, String str, boolean z10) {
        return t(context, cls, f10815n, z10).putExtra(f10822u, str);
    }

    public static Intent n(Context context, Class<? extends t> cls, boolean z10) {
        return t(context, cls, f10817p, z10);
    }

    public static Intent o(Context context, Class<? extends t> cls, Requirements requirements, boolean z10) {
        return t(context, cls, f10820s, z10).putExtra("requirements", requirements);
    }

    public static Intent p(Context context, Class<? extends t> cls, @p0 String str, int i10, boolean z10) {
        return t(context, cls, f10819r, z10).putExtra(f10822u, str).putExtra("stop_reason", i10);
    }

    public static Intent s(Context context, Class<? extends t> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    public static Intent t(Context context, Class<? extends t> cls, String str, boolean z10) {
        return s(context, cls, str).putExtra(f10825x, z10);
    }

    public static boolean x(int i10) {
        return i10 == 2 || i10 == 5 || i10 == 7;
    }

    public final void A(List<cc.c> list) {
        if (this.f10828a != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (x(list.get(i10).f10712b)) {
                    this.f10828a.d();
                    return;
                }
            }
        }
    }

    @Deprecated
    public void B(cc.c cVar) {
    }

    @Deprecated
    public void C(cc.c cVar) {
    }

    public final void O() {
        c cVar = this.f10828a;
        if (cVar != null) {
            cVar.e();
        }
        if (u0.f31154a >= 28 || !this.f10835h) {
            this.f10836i |= stopSelfResult(this.f10833f);
        } else {
            stopSelf();
            this.f10836i = true;
        }
    }

    @Override // android.app.Service
    @p0
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f10829b;
        if (str != null) {
            hd.a0.b(this, str, this.f10830c, this.f10831d, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends t>, b> map = B;
        b bVar = map.get(cls);
        if (bVar == null) {
            boolean z10 = this.f10828a != null;
            dc.e eVarU = z10 ? u() : null;
            p pVarQ = q();
            this.f10832e = pVarQ;
            pVarQ.C();
            bVar = new b(getApplicationContext(), this.f10832e, z10, eVarU, cls);
            map.put((Class<? extends t>) cls, bVar);
        } else {
            this.f10832e = bVar.f10839b;
        }
        bVar.j(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f10837j = true;
        ((b) hd.a.g(B.get(getClass()))).k(this);
        c cVar = this.f10828a;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@p0 Intent intent, int i10, int i11) {
        String action;
        String stringExtra;
        p pVar;
        c cVar;
        this.f10833f = i11;
        this.f10835h = false;
        action = null;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra(f10822u);
            this.f10834g |= intent.getBooleanExtra(f10825x, false) || f10813l.equals(action);
        } else {
            stringExtra = null;
        }
        if (action == null) {
            action = f10812k;
        }
        pVar = (p) hd.a.g(this.f10832e);
        switch (action) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) hd.a.g(intent)).getParcelableExtra(f10821t);
                if (downloadRequest != null) {
                    pVar.d(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    hd.t.d(A, "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                pVar.C();
                break;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                pVar.z();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                Requirements requirements = (Requirements) ((Intent) hd.a.g(intent)).getParcelableExtra("requirements");
                if (requirements != null) {
                    dc.e eVarU = u();
                    if (eVarU != null) {
                        Requirements requirementsB = eVarU.b(requirements);
                        if (!requirementsB.equals(requirements)) {
                            hd.t.n(A, "Ignoring requirements not supported by the Scheduler: " + (requirements.j() ^ requirementsB.j()));
                            requirements = requirementsB;
                        }
                    }
                    pVar.G(requirements);
                    break;
                } else {
                    hd.t.d(A, "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                pVar.x();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) hd.a.g(intent)).hasExtra("stop_reason")) {
                    hd.t.d(A, "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    pVar.H(stringExtra, intent.getIntExtra("stop_reason", 0));
                    break;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    pVar.A(stringExtra);
                    break;
                } else {
                    hd.t.d(A, "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
                break;
            default:
                hd.t.d(A, "Ignored unrecognized action: " + action);
                break;
        }
        if (u0.f31154a >= 26 && this.f10834g && (cVar = this.f10828a) != null) {
            cVar.c();
        }
        this.f10836i = false;
        if (pVar.o()) {
            O();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f10835h = true;
    }

    public abstract p q();

    public abstract Notification r(List<cc.c> list);

    @p0
    public abstract dc.e u();

    public final void v() {
        c cVar = this.f10828a;
        if (cVar == null || this.f10837j) {
            return;
        }
        cVar.b();
    }

    public final boolean w() {
        return this.f10836i;
    }

    public final void y(cc.c cVar) {
        B(cVar);
        if (this.f10828a != null) {
            if (x(cVar.f10712b)) {
                this.f10828a.d();
            } else {
                this.f10828a.b();
            }
        }
    }

    public final void z(cc.c cVar) {
        C(cVar);
        c cVar2 = this.f10828a;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public t(int i10, long j10) {
        this(i10, j10, null, 0, 0);
    }

    @Deprecated
    public t(int i10, long j10, @p0 String str, @c1 int i11) {
        this(i10, j10, str, i11, 0);
    }

    public t(int i10, long j10, @p0 String str, @c1 int i11, @c1 int i12) {
        if (i10 == 0) {
            this.f10828a = null;
            this.f10829b = null;
            this.f10830c = 0;
            this.f10831d = 0;
            return;
        }
        this.f10828a = new c(i10, j10);
        this.f10829b = str;
        this.f10830c = i11;
        this.f10831d = i12;
    }
}
