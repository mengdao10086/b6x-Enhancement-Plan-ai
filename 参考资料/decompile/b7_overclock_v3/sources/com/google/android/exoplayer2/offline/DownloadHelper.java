package com.google.android.exoplayer2.offline;

import ab.i;
import ad.j;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.b;
import com.google.android.exoplayer2.trackselection.c;
import com.google.android.exoplayer2.upstream.a;
import ed.d;
import g.p0;
import gc.m;
import gc.n;
import hb.q;
import hd.u0;
import hd.w;
import id.p;
import id.z;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.o1;
import ya.q1;
import ya.s1;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadHelper {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DefaultTrackSelector.Parameters f17374o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final DefaultTrackSelector.Parameters f17375p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    public static final DefaultTrackSelector.Parameters f17376q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0.g f17377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final l f17378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultTrackSelector f17379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1[] f17380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseIntArray f17381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f17382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x1.c f17383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f17385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f17386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TrackGroupArray[] f17387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c.a[] f17388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<com.google.android.exoplayer2.trackselection.b>[][] f17389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<com.google.android.exoplayer2.trackselection.b>[][] f17390n;

    public static class LiveContentUnsupportedException extends IOException {
    }

    public class a implements z {
        @Override // id.z
        public /* synthetic */ void F(eb.d dVar) {
            p.f(this, dVar);
        }

        @Override // id.z
        public /* synthetic */ void G(Format format, eb.e eVar) {
            p.i(this, format, eVar);
        }

        @Override // id.z
        public /* synthetic */ void K(Format format) {
            p.h(this, format);
        }

        @Override // id.z
        public /* synthetic */ void O(eb.d dVar) {
            p.e(this, dVar);
        }

        @Override // id.z
        public /* synthetic */ void X(long j10, int i10) {
            p.g(this, j10, i10);
        }

        @Override // id.z
        public /* synthetic */ void c(int i10, int i11, int i12, float f10) {
            p.j(this, i10, i11, i12, f10);
        }

        @Override // id.z
        public /* synthetic */ void j(String str) {
            p.d(this, str);
        }

        @Override // id.z
        public /* synthetic */ void l(String str, long j10, long j11) {
            p.c(this, str, j10, j11);
        }

        @Override // id.z
        public /* synthetic */ void s(Surface surface) {
            p.b(this, surface);
        }

        @Override // id.z
        public /* synthetic */ void z(int i10, long j10) {
            p.a(this, i10, j10);
        }
    }

    public class b implements com.google.android.exoplayer2.audio.a {
        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void A(eb.d dVar) {
            i.d(this, dVar);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void L(long j10) {
            i.g(this, j10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void P(Format format) {
            i.e(this, format);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void Q(Format format, eb.e eVar) {
            i.f(this, format, eVar);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void W(int i10, long j10, long j11) {
            i.i(this, i10, j10, j11);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void Y(eb.d dVar) {
            i.c(this, dVar);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void a(boolean z10) {
            i.j(this, z10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void d(Exception exc) {
            i.h(this, exc);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void w(String str) {
            i.b(this, str);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void x(String str, long j10, long j11) {
            i.a(this, str, j10, j11);
        }
    }

    public interface c {
        void a(DownloadHelper downloadHelper);

        void b(DownloadHelper downloadHelper, IOException iOException);
    }

    public static final class d extends ad.b {

        public static final class a implements b.InterfaceC0194b {
            public a() {
            }

            @Override // com.google.android.exoplayer2.trackselection.b.InterfaceC0194b
            public com.google.android.exoplayer2.trackselection.b[] a(b.a[] aVarArr, ed.d dVar, l.a aVar, x1 x1Var) {
                com.google.android.exoplayer2.trackselection.b[] bVarArr = new com.google.android.exoplayer2.trackselection.b[aVarArr.length];
                for (int i10 = 0; i10 < aVarArr.length; i10++) {
                    bVarArr[i10] = aVarArr[i10] == null ? null : new d(aVarArr[i10].f18623a, aVarArr[i10].f18624b);
                }
                return bVarArr;
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public d(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        public int i() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        public void m(long j10, long j11, long j12, List<? extends m> list, n[] nVarArr) {
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        public int q() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        @p0
        public Object s() {
            return null;
        }
    }

    public static final class e implements ed.d {
        public e() {
        }

        @Override // ed.d
        public void c(Handler handler, d.a aVar) {
        }

        @Override // ed.d
        @p0
        public ed.z d() {
            return null;
        }

        @Override // ed.d
        public long e() {
            return 0L;
        }

        @Override // ed.d
        public void f(d.a aVar) {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static final class f implements l.b, k.a, Handler.Callback {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f17391k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f17392l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f17393m = 2;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f17394n = 3;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f17395o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f17396p = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f17397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DownloadHelper f17398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ed.b f17399c = new ed.m(true, 65536);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<k> f17400d = new ArrayList<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Handler f17401e = u0.C(new Handler.Callback() { // from class: cc.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f10754a.d(message);
            }
        });

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final HandlerThread f17402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Handler f17403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public x1 f17404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public k[] f17405i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f17406j;

        public f(l lVar, DownloadHelper downloadHelper) {
            this.f17397a = lVar;
            this.f17398b = downloadHelper;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
            this.f17402f = handlerThread;
            handlerThread.start();
            Handler handlerY = u0.y(handlerThread.getLooper(), this);
            this.f17403g = handlerY;
            handlerY.sendEmptyMessage(0);
        }

        @Override // com.google.android.exoplayer2.source.l.b
        public void b(l lVar, x1 x1Var) {
            k[] kVarArr;
            if (this.f17404h != null) {
                return;
            }
            if (x1Var.n(0, new x1.c()).h()) {
                this.f17401e.obtainMessage(1, new LiveContentUnsupportedException()).sendToTarget();
                return;
            }
            this.f17404h = x1Var;
            this.f17405i = new k[x1Var.i()];
            int i10 = 0;
            while (true) {
                kVarArr = this.f17405i;
                if (i10 >= kVarArr.length) {
                    break;
                }
                k kVarA = this.f17397a.a(new l.a(x1Var.m(i10)), this.f17399c, 0L);
                this.f17405i[i10] = kVarA;
                this.f17400d.add(kVarA);
                i10++;
            }
            for (k kVar : kVarArr) {
                kVar.q(this, 0L);
            }
        }

        public final boolean d(Message message) {
            if (this.f17406j) {
                return false;
            }
            int i10 = message.what;
            if (i10 == 0) {
                this.f17398b.V();
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            f();
            this.f17398b.U((IOException) u0.k(message.obj));
            return true;
        }

        @Override // com.google.android.exoplayer2.source.s.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void i(k kVar) {
            if (this.f17400d.contains(kVar)) {
                this.f17403g.obtainMessage(2, kVar).sendToTarget();
            }
        }

        public void f() {
            if (this.f17406j) {
                return;
            }
            this.f17406j = true;
            this.f17403g.sendEmptyMessage(3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                this.f17397a.s(this, null);
                this.f17403g.sendEmptyMessage(1);
                return true;
            }
            int i11 = 0;
            if (i10 == 1) {
                try {
                    if (this.f17405i == null) {
                        this.f17397a.n();
                    } else {
                        while (i11 < this.f17400d.size()) {
                            this.f17400d.get(i11).m();
                            i11++;
                        }
                    }
                    this.f17403g.sendEmptyMessageDelayed(1, 100L);
                } catch (IOException e10) {
                    this.f17401e.obtainMessage(1, e10).sendToTarget();
                }
                return true;
            }
            if (i10 == 2) {
                k kVar = (k) message.obj;
                if (this.f17400d.contains(kVar)) {
                    kVar.e(0L);
                }
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            k[] kVarArr = this.f17405i;
            if (kVarArr != null) {
                int length = kVarArr.length;
                while (i11 < length) {
                    this.f17397a.p(kVarArr[i11]);
                    i11++;
                }
            }
            this.f17397a.b(this);
            this.f17403g.removeCallbacksAndMessages(null);
            this.f17402f.quit();
            return true;
        }

        @Override // com.google.android.exoplayer2.source.k.a
        public void l(k kVar) {
            this.f17400d.remove(kVar);
            if (this.f17400d.isEmpty()) {
                this.f17403g.removeMessages(1);
                this.f17401e.sendEmptyMessage(0);
            }
        }
    }

    static {
        DefaultTrackSelector.Parameters parametersA = DefaultTrackSelector.Parameters.C2.a().C(true).a();
        f17374o = parametersA;
        f17375p = parametersA;
        f17376q = parametersA;
    }

    public DownloadHelper(v0 v0Var, @p0 l lVar, DefaultTrackSelector.Parameters parameters, q1[] q1VarArr) {
        this.f17377a = (v0.g) hd.a.g(v0Var.f57132b);
        this.f17378b = lVar;
        a aVar = null;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(parameters, new d.a(aVar));
        this.f17379c = defaultTrackSelector;
        this.f17380d = q1VarArr;
        this.f17381e = new SparseIntArray();
        defaultTrackSelector.b(new j.a() { // from class: cc.f
            @Override // ad.j.a
            public final void d() {
                DownloadHelper.Q();
            }
        }, new e(aVar));
        this.f17382f = u0.B();
        this.f17383g = new x1.c();
    }

    @Deprecated
    public static DownloadHelper A(Context context, Uri uri, @p0 String str) {
        return v(context, new v0.c().F(uri).j(str).a());
    }

    @Deprecated
    public static DownloadHelper B(Context context, Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var) {
        return D(uri, interfaceC0197a, s1Var, null, E(context));
    }

    @Deprecated
    public static DownloadHelper C(Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var) {
        return D(uri, interfaceC0197a, s1Var, null, f17374o);
    }

    @Deprecated
    public static DownloadHelper D(Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var, @p0 com.google.android.exoplayer2.drm.c cVar, DefaultTrackSelector.Parameters parameters) {
        return y(new v0.c().F(uri).B(w.f31191j0).a(), parameters, s1Var, interfaceC0197a, cVar);
    }

    public static DefaultTrackSelector.Parameters E(Context context) {
        return DefaultTrackSelector.Parameters.F(context).a().C(true).a();
    }

    public static q1[] K(s1 s1Var) {
        o1[] o1VarArrA = s1Var.a(u0.B(), new a(), new b(), new qc.k() { // from class: cc.j
            @Override // qc.k
            public final void I(List list) {
                DownloadHelper.O(list);
            }
        }, new ub.e() { // from class: cc.k
            @Override // ub.e
            public final void t(Metadata metadata) {
                DownloadHelper.P(metadata);
            }
        });
        q1[] q1VarArr = new q1[o1VarArrA.length];
        for (int i10 = 0; i10 < o1VarArrA.length; i10++) {
            q1VarArr[i10] = o1VarArrA[i10].m();
        }
        return q1VarArr;
    }

    public static boolean N(v0.g gVar) {
        return u0.B0(gVar.f57183a, gVar.f57184b) == 3;
    }

    public static /* synthetic */ void O(List list) {
    }

    public static /* synthetic */ void P(Metadata metadata) {
    }

    public static /* synthetic */ void Q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(IOException iOException) {
        ((c) hd.a.g(this.f17385i)).b(this, iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        ((c) hd.a.g(this.f17385i)).a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(c cVar) {
        cVar.a(this);
    }

    public static l o(DownloadRequest downloadRequest, a.InterfaceC0197a interfaceC0197a) {
        return p(downloadRequest, interfaceC0197a, null);
    }

    public static l p(DownloadRequest downloadRequest, a.InterfaceC0197a interfaceC0197a, @p0 com.google.android.exoplayer2.drm.c cVar) {
        return q(downloadRequest.g(), interfaceC0197a, cVar);
    }

    public static l q(v0 v0Var, a.InterfaceC0197a interfaceC0197a, @p0 com.google.android.exoplayer2.drm.c cVar) {
        return new com.google.android.exoplayer2.source.e(interfaceC0197a, q.f30894a).g(cVar).c(v0Var);
    }

    @Deprecated
    public static DownloadHelper r(Context context, Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var) {
        return s(uri, interfaceC0197a, s1Var, null, E(context));
    }

    @Deprecated
    public static DownloadHelper s(Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var, @p0 com.google.android.exoplayer2.drm.c cVar, DefaultTrackSelector.Parameters parameters) {
        return y(new v0.c().F(uri).B(w.f31187h0).a(), parameters, s1Var, interfaceC0197a, cVar);
    }

    @Deprecated
    public static DownloadHelper t(Context context, Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var) {
        return u(uri, interfaceC0197a, s1Var, null, E(context));
    }

    @Deprecated
    public static DownloadHelper u(Uri uri, a.InterfaceC0197a interfaceC0197a, s1 s1Var, @p0 com.google.android.exoplayer2.drm.c cVar, DefaultTrackSelector.Parameters parameters) {
        return y(new v0.c().F(uri).B(w.f31189i0).a(), parameters, s1Var, interfaceC0197a, cVar);
    }

    public static DownloadHelper v(Context context, v0 v0Var) {
        hd.a.a(N((v0.g) hd.a.g(v0Var.f57132b)));
        return y(v0Var, E(context), null, null, null);
    }

    public static DownloadHelper w(Context context, v0 v0Var, @p0 s1 s1Var, @p0 a.InterfaceC0197a interfaceC0197a) {
        return y(v0Var, E(context), s1Var, interfaceC0197a, null);
    }

    public static DownloadHelper x(v0 v0Var, DefaultTrackSelector.Parameters parameters, @p0 s1 s1Var, @p0 a.InterfaceC0197a interfaceC0197a) {
        return y(v0Var, parameters, s1Var, interfaceC0197a, null);
    }

    public static DownloadHelper y(v0 v0Var, DefaultTrackSelector.Parameters parameters, @p0 s1 s1Var, @p0 a.InterfaceC0197a interfaceC0197a, @p0 com.google.android.exoplayer2.drm.c cVar) {
        boolean zN = N((v0.g) hd.a.g(v0Var.f57132b));
        hd.a.a(zN || interfaceC0197a != null);
        return new DownloadHelper(v0Var, zN ? null : q(v0Var, (a.InterfaceC0197a) u0.k(interfaceC0197a), cVar), parameters, s1Var != null ? K(s1Var) : new q1[0]);
    }

    @Deprecated
    public static DownloadHelper z(Context context, Uri uri) {
        return v(context, new v0.c().F(uri).a());
    }

    public DownloadRequest F(String str, @p0 byte[] bArr) {
        DownloadRequest.b bVarE = new DownloadRequest.b(str, this.f17377a.f57183a).e(this.f17377a.f57184b);
        v0.e eVar = this.f17377a.f57185c;
        DownloadRequest.b bVarC = bVarE.d(eVar != null ? eVar.a() : null).b(this.f17377a.f57188f).c(bArr);
        if (this.f17378b == null) {
            return bVarC.a();
        }
        m();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f17389m.length;
        for (int i10 = 0; i10 < length; i10++) {
            arrayList2.clear();
            int length2 = this.f17389m[i10].length;
            for (int i11 = 0; i11 < length2; i11++) {
                arrayList2.addAll(this.f17389m[i10][i11]);
            }
            arrayList.addAll(this.f17386j.f17405i[i10].j(arrayList2));
        }
        return bVarC.f(arrayList).a();
    }

    public DownloadRequest G(@p0 byte[] bArr) {
        return F(this.f17377a.f57183a.toString(), bArr);
    }

    @p0
    public Object H() {
        if (this.f17378b == null) {
            return null;
        }
        m();
        if (this.f17386j.f17404h.q() > 0) {
            return this.f17386j.f17404h.n(0, this.f17383g).f57243d;
        }
        return null;
    }

    public c.a I(int i10) {
        m();
        return this.f17388l[i10];
    }

    public int J() {
        if (this.f17378b == null) {
            return 0;
        }
        m();
        return this.f17387k.length;
    }

    public TrackGroupArray L(int i10) {
        m();
        return this.f17387k[i10];
    }

    public List<com.google.android.exoplayer2.trackselection.b> M(int i10, int i11) {
        m();
        return this.f17390n[i10][i11];
    }

    public final void U(final IOException iOException) {
        ((Handler) hd.a.g(this.f17382f)).post(new Runnable() { // from class: cc.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f10750a.R(iOException);
            }
        });
    }

    public final void V() {
        hd.a.g(this.f17386j);
        hd.a.g(this.f17386j.f17405i);
        hd.a.g(this.f17386j.f17404h);
        int length = this.f17386j.f17405i.length;
        int length2 = this.f17380d.length;
        this.f17389m = (List[][]) Array.newInstance((Class<?>) List.class, length, length2);
        this.f17390n = (List[][]) Array.newInstance((Class<?>) List.class, length, length2);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length2; i11++) {
                this.f17389m[i10][i11] = new ArrayList();
                this.f17390n[i10][i11] = Collections.unmodifiableList(this.f17389m[i10][i11]);
            }
        }
        this.f17387k = new TrackGroupArray[length];
        this.f17388l = new c.a[length];
        for (int i12 = 0; i12 < length; i12++) {
            this.f17387k[i12] = this.f17386j.f17405i[i12].r();
            this.f17379c.d(Z(i12).f574d);
            this.f17388l[i12] = (c.a) hd.a.g(this.f17379c.g());
        }
        a0();
        ((Handler) hd.a.g(this.f17382f)).post(new Runnable() { // from class: cc.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f10747a.S();
            }
        });
    }

    public void W(final c cVar) {
        hd.a.i(this.f17385i == null);
        this.f17385i = cVar;
        l lVar = this.f17378b;
        if (lVar != null) {
            this.f17386j = new f(lVar, this);
        } else {
            this.f17382f.post(new Runnable() { // from class: cc.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10748a.T(cVar);
                }
            });
        }
    }

    public void X() {
        f fVar = this.f17386j;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void Y(int i10, DefaultTrackSelector.Parameters parameters) {
        n(i10);
        k(i10, parameters);
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    public final ad.k Z(int i10) {
        boolean z10;
        try {
            ad.k kVarE = this.f17379c.e(this.f17380d, this.f17387k[i10], new l.a(this.f17386j.f17404h.m(i10)), this.f17386j.f17404h);
            for (int i11 = 0; i11 < kVarE.f571a; i11++) {
                com.google.android.exoplayer2.trackselection.b bVar = kVarE.f573c[i11];
                if (bVar != null) {
                    List<com.google.android.exoplayer2.trackselection.b> list = this.f17389m[i10][i11];
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            z10 = false;
                            break;
                        }
                        com.google.android.exoplayer2.trackselection.b bVar2 = list.get(i12);
                        if (bVar2.a() == bVar.a()) {
                            this.f17381e.clear();
                            for (int i13 = 0; i13 < bVar2.length(); i13++) {
                                this.f17381e.put(bVar2.c(i13), 0);
                            }
                            for (int i14 = 0; i14 < bVar.length(); i14++) {
                                this.f17381e.put(bVar.c(i14), 0);
                            }
                            int[] iArr = new int[this.f17381e.size()];
                            for (int i15 = 0; i15 < this.f17381e.size(); i15++) {
                                iArr[i15] = this.f17381e.keyAt(i15);
                            }
                            list.set(i12, new d(bVar2.a(), iArr));
                            z10 = true;
                        } else {
                            i12++;
                        }
                    }
                    if (!z10) {
                        list.add(bVar);
                    }
                }
            }
            return kVarE;
        } catch (ExoPlaybackException e10) {
            throw new UnsupportedOperationException(e10);
        }
    }

    @RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    public final void a0() {
        this.f17384h = true;
    }

    public void i(String... strArr) {
        m();
        for (int i10 = 0; i10 < this.f17388l.length; i10++) {
            DefaultTrackSelector.d dVarA = f17374o.a();
            c.a aVar = this.f17388l[i10];
            int iC = aVar.c();
            for (int i11 = 0; i11 < iC; i11++) {
                if (aVar.f(i11) != 1) {
                    dVarA.Z(i11, true);
                }
            }
            for (String str : strArr) {
                dVarA.c(str);
                k(i10, dVarA.a());
            }
        }
    }

    public void j(boolean z10, String... strArr) {
        m();
        for (int i10 = 0; i10 < this.f17388l.length; i10++) {
            DefaultTrackSelector.d dVarA = f17374o.a();
            c.a aVar = this.f17388l[i10];
            int iC = aVar.c();
            for (int i11 = 0; i11 < iC; i11++) {
                if (aVar.f(i11) != 3) {
                    dVarA.Z(i11, true);
                }
            }
            dVarA.k(z10);
            for (String str : strArr) {
                dVarA.f(str);
                k(i10, dVarA.a());
            }
        }
    }

    public void k(int i10, DefaultTrackSelector.Parameters parameters) {
        m();
        this.f17379c.M(parameters);
        Z(i10);
    }

    public void l(int i10, int i11, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        m();
        DefaultTrackSelector.d dVarA = parameters.a();
        int i12 = 0;
        while (i12 < this.f17388l[i10].c()) {
            dVarA.Z(i12, i12 != i11);
            i12++;
        }
        if (list.isEmpty()) {
            k(i10, dVarA.a());
            return;
        }
        TrackGroupArray trackGroupArrayG = this.f17388l[i10].g(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            dVarA.b0(i11, trackGroupArrayG, list.get(i13));
            k(i10, dVarA.a());
        }
    }

    @EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    public final void m() {
        hd.a.i(this.f17384h);
    }

    public void n(int i10) {
        m();
        for (int i11 = 0; i11 < this.f17380d.length; i11++) {
            this.f17389m[i10][i11].clear();
        }
    }
}
