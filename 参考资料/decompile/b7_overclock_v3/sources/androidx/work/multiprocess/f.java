package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import androidx.work.multiprocess.a;
import androidx.work.multiprocess.d;
import com.google.common.util.concurrent.ListenableFuture;
import g.i1;
import g.n0;
import g.p0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8671e = androidx.work.l.f("ListenableWorkerImplClient");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f8673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8674c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f8675d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f8677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f8678c;

        /* JADX INFO: renamed from: androidx.work.multiprocess.f$a$a, reason: collision with other inner class name */
        public class RunnableC0088a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.work.multiprocess.a f8680a;

            public RunnableC0088a(androidx.work.multiprocess.a aVar) {
                this.f8680a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a aVar = a.this;
                    aVar.f8678c.a(this.f8680a, aVar.f8677b);
                } catch (Throwable th2) {
                    androidx.work.l.c().b(f.f8671e, "Unable to execute", th2);
                    d.a.a(a.this.f8677b, th2);
                }
            }
        }

        public a(ListenableFuture listenableFuture, g gVar, i iVar) {
            this.f8676a = listenableFuture;
            this.f8677b = gVar;
            this.f8678c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.work.multiprocess.a aVar = (androidx.work.multiprocess.a) this.f8676a.get();
                this.f8677b.W0(aVar.asBinder());
                f.this.f8673b.execute(new RunnableC0088a(aVar));
            } catch (InterruptedException | ExecutionException e10) {
                androidx.work.l.c().b(f.f8671e, "Unable to bind to service", e10);
                d.a.a(this.f8677b, e10);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class b implements ServiceConnection {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8682b = androidx.work.l.f("ListenableWorkerImplSession");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.work.impl.utils.futures.a<androidx.work.multiprocess.a> f8683a = androidx.work.impl.utils.futures.a.u();

        @Override // android.content.ServiceConnection
        public void onBindingDied(@n0 ComponentName componentName) {
            androidx.work.l.c().h(f8682b, "Binding died", new Throwable[0]);
            this.f8683a.q(new RuntimeException("Binding died"));
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(@n0 ComponentName componentName) {
            androidx.work.l.c().b(f8682b, "Unable to bind to service", new Throwable[0]);
            this.f8683a.q(new RuntimeException(String.format("Cannot bind to service %s", componentName)));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@n0 ComponentName componentName, @n0 IBinder iBinder) {
            androidx.work.l.c().a(f8682b, "Service connected", new Throwable[0]);
            this.f8683a.p(a.b.Q0(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@n0 ComponentName componentName) {
            androidx.work.l.c().h(f8682b, "Service disconnected", new Throwable[0]);
            this.f8683a.q(new RuntimeException("Service disconnected"));
        }
    }

    public f(@n0 Context context, @n0 Executor executor) {
        this.f8672a = context;
        this.f8673b = executor;
    }

    public static void e(@n0 b bVar, @n0 Throwable th2) {
        androidx.work.l.c().b(f8671e, "Unable to bind to service", th2);
        bVar.f8683a.q(th2);
    }

    @n0
    public ListenableFuture<byte[]> a(@n0 ComponentName componentName, @n0 i<androidx.work.multiprocess.a> iVar) {
        return b(d(componentName), iVar, new g());
    }

    @SuppressLint({"LambdaLast"})
    @n0
    public ListenableFuture<byte[]> b(@n0 ListenableFuture<androidx.work.multiprocess.a> listenableFuture, @n0 i<androidx.work.multiprocess.a> iVar, @n0 g gVar) {
        listenableFuture.addListener(new a(listenableFuture, gVar, iVar), this.f8673b);
        return gVar.T0();
    }

    @i1
    @p0
    public b c() {
        return this.f8675d;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[Catch: all -> 0x005b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:12:0x0050, B:13:0x0055, B:14:0x0059, B:7:0x0030, B:9:0x0042), top: B:19:0x0003, inners: #1 }] */
    @g.n0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.common.util.concurrent.ListenableFuture<androidx.work.multiprocess.a> d(@g.n0 android.content.ComponentName r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f8674c
            monitor-enter(r0)
            androidx.work.multiprocess.f$b r1 = r8.f8675d     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L55
            androidx.work.l r1 = androidx.work.l.c()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = androidx.work.multiprocess.f.f8671e     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "Binding to %s, %s"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r9.getPackageName()     // Catch: java.lang.Throwable -> L5b
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r9.getClassName()     // Catch: java.lang.Throwable -> L5b
            r7 = 1
            r4[r7] = r5     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L5b
            java.lang.Throwable[] r4 = new java.lang.Throwable[r6]     // Catch: java.lang.Throwable -> L5b
            r1.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L5b
            androidx.work.multiprocess.f$b r1 = new androidx.work.multiprocess.f$b     // Catch: java.lang.Throwable -> L5b
            r1.<init>()     // Catch: java.lang.Throwable -> L5b
            r8.f8675d = r1     // Catch: java.lang.Throwable -> L5b
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            r1.setComponent(r9)     // Catch: java.lang.Throwable -> L4f
            android.content.Context r9 = r8.f8672a     // Catch: java.lang.Throwable -> L4f
            androidx.work.multiprocess.f$b r2 = r8.f8675d     // Catch: java.lang.Throwable -> L4f
            boolean r9 = r9.bindService(r1, r2, r7)     // Catch: java.lang.Throwable -> L4f
            if (r9 != 0) goto L55
            androidx.work.multiprocess.f$b r9 = r8.f8675d     // Catch: java.lang.Throwable -> L4f
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = "Unable to bind to service"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4f
            e(r9, r1)     // Catch: java.lang.Throwable -> L4f
            goto L55
        L4f:
            r9 = move-exception
            androidx.work.multiprocess.f$b r1 = r8.f8675d     // Catch: java.lang.Throwable -> L5b
            e(r1, r9)     // Catch: java.lang.Throwable -> L5b
        L55:
            androidx.work.multiprocess.f$b r9 = r8.f8675d     // Catch: java.lang.Throwable -> L5b
            androidx.work.impl.utils.futures.a<androidx.work.multiprocess.a> r9 = r9.f8683a     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
            return r9
        L5b:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.multiprocess.f.d(android.content.ComponentName):com.google.common.util.concurrent.ListenableFuture");
    }

    public void f() {
        synchronized (this.f8674c) {
            b bVar = this.f8675d;
            if (bVar != null) {
                this.f8672a.unbindService(bVar);
                this.f8675d = null;
            }
        }
    }
}
