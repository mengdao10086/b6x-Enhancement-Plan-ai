package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.multiprocess.b;
import androidx.work.multiprocess.d;
import androidx.work.multiprocess.parcelable.ParcelableUpdateRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkContinuationImpl;
import androidx.work.multiprocess.parcelable.ParcelableWorkInfos;
import androidx.work.multiprocess.parcelable.ParcelableWorkQuery;
import androidx.work.multiprocess.parcelable.ParcelableWorkRequests;
import androidx.work.p;
import androidx.work.u;
import androidx.work.w;
import androidx.work.x;
import com.google.common.util.concurrent.ListenableFuture;
import g.i1;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanKeepAnnotation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RemoteWorkManagerClient extends androidx.work.multiprocess.l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f8588j = 60000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8589k = androidx.work.l.f("RemoteWorkManagerClient");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f8590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l2.i f8592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f8593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f8594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f8595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f8597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f8598i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.work.multiprocess.g f8600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.work.multiprocess.i f8601c;

        /* JADX INFO: renamed from: androidx.work.multiprocess.RemoteWorkManagerClient$a$a, reason: collision with other inner class name */
        public class RunnableC0084a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.work.multiprocess.b f8603a;

            public RunnableC0084a(androidx.work.multiprocess.b bVar) {
                this.f8603a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a aVar = a.this;
                    aVar.f8601c.a(this.f8603a, aVar.f8600b);
                } catch (Throwable th2) {
                    androidx.work.l.c().b(RemoteWorkManagerClient.f8589k, "Unable to execute", th2);
                    d.a.a(a.this.f8600b, th2);
                }
            }
        }

        public a(ListenableFuture listenableFuture, androidx.work.multiprocess.g gVar, androidx.work.multiprocess.i iVar) {
            this.f8599a = listenableFuture;
            this.f8600b = gVar;
            this.f8601c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.work.multiprocess.b bVar = (androidx.work.multiprocess.b) this.f8599a.get();
                this.f8600b.W0(bVar.asBinder());
                RemoteWorkManagerClient.this.f8593d.execute(new RunnableC0084a(bVar));
            } catch (InterruptedException | ExecutionException unused) {
                androidx.work.l.c().b(RemoteWorkManagerClient.f8589k, "Unable to bind to service", new Throwable[0]);
                d.a.a(this.f8600b, new RuntimeException("Unable to bind to service"));
                RemoteWorkManagerClient.this.r();
            }
        }
    }

    public class b implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f8605a;

        public b(List list) {
            this.f8605a = list;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws RemoteException {
            bVar.c(x2.a.a(new ParcelableWorkRequests((List<x>) this.f8605a)), cVar);
        }
    }

    public class c implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f8607a;

        public c(u uVar) {
            this.f8607a = uVar;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.P0(x2.a.a(new ParcelableWorkContinuationImpl((l2.g) this.f8607a)), cVar);
        }
    }

    public class d implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UUID f8609a;

        public d(UUID uuid) {
            this.f8609a = uuid;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.r0(this.f8609a.toString(), cVar);
        }
    }

    public class e implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8611a;

        public e(String str) {
            this.f8611a = str;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.F0(this.f8611a, cVar);
        }
    }

    public class f implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8613a;

        public f(String str) {
            this.f8613a = str;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.b(this.f8613a, cVar);
        }
    }

    public class g implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {
        public g() {
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.L(cVar);
        }
    }

    public class h implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f8616a;

        public h(w wVar) {
            this.f8616a = wVar;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.e0(x2.a.a(new ParcelableWorkQuery(this.f8616a)), cVar);
        }
    }

    public class i implements p.a<byte[], List<WorkInfo>> {
        public i() {
        }

        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<WorkInfo> apply(byte[] bArr) {
            return ((ParcelableWorkInfos) x2.a.b(bArr, ParcelableWorkInfos.CREATOR)).a();
        }
    }

    public class j implements androidx.work.multiprocess.i<androidx.work.multiprocess.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UUID f8619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.work.d f8620b;

        public j(UUID uuid, androidx.work.d dVar) {
            this.f8619a = uuid;
            this.f8620b = dVar;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.b bVar, @n0 androidx.work.multiprocess.c cVar) throws Throwable {
            bVar.N0(x2.a.a(new ParcelableUpdateRequest(this.f8619a, this.f8620b)), cVar);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class k implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f8622c = androidx.work.l.f("RemoteWMgr.Connection");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.work.impl.utils.futures.a<androidx.work.multiprocess.b> f8623a = androidx.work.impl.utils.futures.a.u();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RemoteWorkManagerClient f8624b;

        public k(@n0 RemoteWorkManagerClient remoteWorkManagerClient) {
            this.f8624b = remoteWorkManagerClient;
        }

        public void a() {
            androidx.work.l.c().a(f8622c, "Binding died", new Throwable[0]);
            this.f8623a.q(new RuntimeException("Binding died"));
            this.f8624b.r();
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(@n0 ComponentName componentName) {
            a();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(@n0 ComponentName componentName) {
            androidx.work.l.c().b(f8622c, "Unable to bind to service", new Throwable[0]);
            this.f8623a.q(new RuntimeException(String.format("Cannot bind to service %s", componentName)));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@n0 ComponentName componentName, @n0 IBinder iBinder) {
            androidx.work.l.c().a(f8622c, "Service connected", new Throwable[0]);
            this.f8623a.p(b.AbstractBinderC0087b.Q0(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@n0 ComponentName componentName) {
            androidx.work.l.c().a(f8622c, "Service disconnected", new Throwable[0]);
            this.f8623a.q(new RuntimeException("Service disconnected"));
            this.f8624b.r();
        }
    }

    public static class l extends androidx.work.multiprocess.g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final RemoteWorkManagerClient f8625g;

        public l(@n0 RemoteWorkManagerClient remoteWorkManagerClient) {
            this.f8625g = remoteWorkManagerClient;
        }

        @Override // androidx.work.multiprocess.g
        public void V0() {
            super.V0();
            this.f8625g.z().postDelayed(this.f8625g.D(), this.f8625g.C());
        }
    }

    public static class m implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8626b = androidx.work.l.f("SessionHandler");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RemoteWorkManagerClient f8627a;

        public m(@n0 RemoteWorkManagerClient remoteWorkManagerClient) {
            this.f8627a = remoteWorkManagerClient;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jA = this.f8627a.A();
            synchronized (this.f8627a.B()) {
                long jA2 = this.f8627a.A();
                k kVarV = this.f8627a.v();
                if (kVarV != null) {
                    if (jA == jA2) {
                        androidx.work.l.c().a(f8626b, "Unbinding service", new Throwable[0]);
                        this.f8627a.u().unbindService(kVarV);
                        kVarV.a();
                    } else {
                        androidx.work.l.c().a(f8626b, "Ignoring request to unbind.", new Throwable[0]);
                    }
                }
            }
        }
    }

    public RemoteWorkManagerClient(@n0 Context context, @n0 l2.i iVar) {
        this(context, iVar, 60000L);
    }

    public static Intent E(@n0 Context context) {
        return new Intent(context, (Class<?>) RemoteWorkManagerService.class);
    }

    public long A() {
        return this.f8595f;
    }

    @n0
    public Object B() {
        return this.f8594e;
    }

    public long C() {
        return this.f8596g;
    }

    @n0
    public m D() {
        return this.f8598i;
    }

    public final void F(@n0 k kVar, @n0 Throwable th2) {
        androidx.work.l.c().b(f8589k, "Unable to bind to service", th2);
        kVar.f8623a.q(th2);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public androidx.work.multiprocess.j b(@n0 String str, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<androidx.work.m> list) {
        return new androidx.work.multiprocess.k(this, this.f8592c.b(str, existingWorkPolicy, list));
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public androidx.work.multiprocess.j d(@n0 List<androidx.work.m> list) {
        return new androidx.work.multiprocess.k(this, this.f8592c.d(list));
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> e() {
        return androidx.work.multiprocess.h.a(s(new g()), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> f(@n0 String str) {
        return androidx.work.multiprocess.h.a(s(new e(str)), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> g(@n0 String str) {
        return androidx.work.multiprocess.h.a(s(new f(str)), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> h(@n0 UUID uuid) {
        return androidx.work.multiprocess.h.a(s(new d(uuid)), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> i(@n0 u uVar) {
        return androidx.work.multiprocess.h.a(s(new c(uVar)), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> j(@n0 x xVar) {
        return k(Collections.singletonList(xVar));
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> k(@n0 List<x> list) {
        return androidx.work.multiprocess.h.a(s(new b(list)), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> l(@n0 String str, @n0 ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @n0 p pVar) {
        return i(this.f8592c.D(str, existingPeriodicWorkPolicy, pVar));
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> n(@n0 String str, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<androidx.work.m> list) {
        return b(str, existingWorkPolicy, list).c();
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<List<WorkInfo>> p(@n0 w wVar) {
        return androidx.work.multiprocess.h.a(s(new h(wVar)), new i(), this.f8593d);
    }

    @Override // androidx.work.multiprocess.l
    @n0
    public ListenableFuture<Void> q(@n0 UUID uuid, @n0 androidx.work.d dVar) {
        return androidx.work.multiprocess.h.a(s(new j(uuid, dVar)), androidx.work.multiprocess.h.f8688a, this.f8593d);
    }

    public void r() {
        synchronized (this.f8594e) {
            androidx.work.l.c().a(f8589k, "Cleaning up.", new Throwable[0]);
            this.f8590a = null;
        }
    }

    @n0
    public ListenableFuture<byte[]> s(@n0 androidx.work.multiprocess.i<androidx.work.multiprocess.b> iVar) {
        return t(x(), iVar, new l(this));
    }

    @i1
    @n0
    public ListenableFuture<byte[]> t(@n0 ListenableFuture<androidx.work.multiprocess.b> listenableFuture, @n0 androidx.work.multiprocess.i<androidx.work.multiprocess.b> iVar, @n0 androidx.work.multiprocess.g gVar) {
        listenableFuture.addListener(new a(listenableFuture, gVar, iVar), this.f8593d);
        return gVar.T0();
    }

    @n0
    public Context u() {
        return this.f8591b;
    }

    @p0
    public k v() {
        return this.f8590a;
    }

    @n0
    public Executor w() {
        return this.f8593d;
    }

    @n0
    public ListenableFuture<androidx.work.multiprocess.b> x() {
        return y(E(this.f8591b));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[Catch: all -> 0x004c, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000e, B:12:0x003a, B:13:0x003f, B:14:0x004a, B:7:0x0023, B:9:0x002c), top: B:21:0x0003, inners: #0 }] */
    @g.i1
    @g.n0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.multiprocess.b> y(@g.n0 android.content.Intent r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f8594e
            monitor-enter(r0)
            long r1 = r5.f8595f     // Catch: java.lang.Throwable -> L4c
            r3 = 1
            long r1 = r1 + r3
            r5.f8595f = r1     // Catch: java.lang.Throwable -> L4c
            androidx.work.multiprocess.RemoteWorkManagerClient$k r1 = r5.f8590a     // Catch: java.lang.Throwable -> L4c
            if (r1 != 0) goto L3f
            androidx.work.l r1 = androidx.work.l.c()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r2 = androidx.work.multiprocess.RemoteWorkManagerClient.f8589k     // Catch: java.lang.Throwable -> L4c
            java.lang.String r3 = "Creating a new session"
            r4 = 0
            java.lang.Throwable[] r4 = new java.lang.Throwable[r4]     // Catch: java.lang.Throwable -> L4c
            r1.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L4c
            androidx.work.multiprocess.RemoteWorkManagerClient$k r1 = new androidx.work.multiprocess.RemoteWorkManagerClient$k     // Catch: java.lang.Throwable -> L4c
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L4c
            r5.f8590a = r1     // Catch: java.lang.Throwable -> L4c
            android.content.Context r2 = r5.f8591b     // Catch: java.lang.Throwable -> L39
            r3 = 1
            boolean r6 = r2.bindService(r6, r1, r3)     // Catch: java.lang.Throwable -> L39
            if (r6 != 0) goto L3f
            androidx.work.multiprocess.RemoteWorkManagerClient$k r6 = r5.f8590a     // Catch: java.lang.Throwable -> L39
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "Unable to bind to service"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L39
            r5.F(r6, r1)     // Catch: java.lang.Throwable -> L39
            goto L3f
        L39:
            r6 = move-exception
            androidx.work.multiprocess.RemoteWorkManagerClient$k r1 = r5.f8590a     // Catch: java.lang.Throwable -> L4c
            r5.F(r1, r6)     // Catch: java.lang.Throwable -> L4c
        L3f:
            android.os.Handler r6 = r5.f8597h     // Catch: java.lang.Throwable -> L4c
            androidx.work.multiprocess.RemoteWorkManagerClient$m r1 = r5.f8598i     // Catch: java.lang.Throwable -> L4c
            r6.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L4c
            androidx.work.multiprocess.RemoteWorkManagerClient$k r6 = r5.f8590a     // Catch: java.lang.Throwable -> L4c
            androidx.work.impl.utils.futures.a<androidx.work.multiprocess.b> r6 = r6.f8623a     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
            return r6
        L4c:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.multiprocess.RemoteWorkManagerClient.y(android.content.Intent):com.google.common.util.concurrent.ListenableFuture");
    }

    @n0
    public Handler z() {
        return this.f8597h;
    }

    public RemoteWorkManagerClient(@n0 Context context, @n0 l2.i iVar, long j10) {
        this.f8591b = context.getApplicationContext();
        this.f8592c = iVar;
        this.f8593d = iVar.O().d();
        this.f8594e = new Object();
        this.f8590a = null;
        this.f8598i = new m(this);
        this.f8596g = j10;
        this.f8597h = androidx.core.os.j.a(Looper.getMainLooper());
    }
}
