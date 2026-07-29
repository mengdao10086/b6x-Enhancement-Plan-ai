package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.multiprocess.a;
import androidx.work.multiprocess.d;
import androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e extends a.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8656n = androidx.work.l.f("ListenableWorkerImpl");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static byte[] f8657o = new byte[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f8658p = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f8659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l2.i f8660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.work.a f8661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w2.a f8662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, ListenableFuture<ListenableWorker.a>> f8663h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f8665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f8666c;

        public a(ListenableFuture listenableFuture, c cVar, String str) {
            this.f8664a = listenableFuture;
            this.f8665b = cVar;
            this.f8666c = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                com.google.common.util.concurrent.ListenableFuture r0 = r7.f8664a     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                androidx.work.ListenableWorker$a r0 = (androidx.work.ListenableWorker.a) r0     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                androidx.work.multiprocess.parcelable.ParcelableResult r1 = new androidx.work.multiprocess.parcelable.ParcelableResult     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                r1.<init>(r0)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                byte[] r0 = x2.a.a(r1)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                androidx.work.multiprocess.c r1 = r7.f8665b     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                androidx.work.multiprocess.d.a.b(r1, r0)     // Catch: java.lang.Throwable -> L27 java.util.concurrent.CancellationException -> L29 java.lang.InterruptedException -> L59 java.util.concurrent.ExecutionException -> L5b
                java.lang.Object r0 = androidx.work.multiprocess.e.f8658p
                monitor-enter(r0)
                androidx.work.multiprocess.e r1 = androidx.work.multiprocess.e.this     // Catch: java.lang.Throwable -> L24
                java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$a>> r1 = r1.f8663h     // Catch: java.lang.Throwable -> L24
                java.lang.String r2 = r7.f8666c     // Catch: java.lang.Throwable -> L24
                r1.remove(r2)     // Catch: java.lang.Throwable -> L24
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
                goto L6e
            L24:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
                throw r1
            L27:
                r0 = move-exception
                goto L72
            L29:
                r0 = move-exception
                androidx.work.l r1 = androidx.work.l.c()     // Catch: java.lang.Throwable -> L27
                java.lang.String r2 = androidx.work.multiprocess.e.f8656n     // Catch: java.lang.Throwable -> L27
                java.lang.String r3 = "Worker (%s) was cancelled"
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L27
                java.lang.String r5 = r7.f8666c     // Catch: java.lang.Throwable -> L27
                r6 = 0
                r4[r6] = r5     // Catch: java.lang.Throwable -> L27
                java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L27
                java.lang.Throwable[] r4 = new java.lang.Throwable[r6]     // Catch: java.lang.Throwable -> L27
                r1.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L27
                androidx.work.multiprocess.c r1 = r7.f8665b     // Catch: java.lang.Throwable -> L27
                androidx.work.multiprocess.d.a.a(r1, r0)     // Catch: java.lang.Throwable -> L27
                java.lang.Object r0 = androidx.work.multiprocess.e.f8658p
                monitor-enter(r0)
                androidx.work.multiprocess.e r1 = androidx.work.multiprocess.e.this     // Catch: java.lang.Throwable -> L56
                java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$a>> r1 = r1.f8663h     // Catch: java.lang.Throwable -> L56
                java.lang.String r2 = r7.f8666c     // Catch: java.lang.Throwable -> L56
                r1.remove(r2)     // Catch: java.lang.Throwable -> L56
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
                goto L6e
            L56:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
                throw r1
            L59:
                r0 = move-exception
                goto L5c
            L5b:
                r0 = move-exception
            L5c:
                androidx.work.multiprocess.c r1 = r7.f8665b     // Catch: java.lang.Throwable -> L27
                androidx.work.multiprocess.d.a.a(r1, r0)     // Catch: java.lang.Throwable -> L27
                java.lang.Object r0 = androidx.work.multiprocess.e.f8658p
                monitor-enter(r0)
                androidx.work.multiprocess.e r1 = androidx.work.multiprocess.e.this     // Catch: java.lang.Throwable -> L6f
                java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$a>> r1 = r1.f8663h     // Catch: java.lang.Throwable -> L6f
                java.lang.String r2 = r7.f8666c     // Catch: java.lang.Throwable -> L6f
                r1.remove(r2)     // Catch: java.lang.Throwable -> L6f
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L6f
            L6e:
                return
            L6f:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L6f
                throw r1
            L72:
                java.lang.Object r1 = androidx.work.multiprocess.e.f8658p
                monitor-enter(r1)
                androidx.work.multiprocess.e r2 = androidx.work.multiprocess.e.this     // Catch: java.lang.Throwable -> L80
                java.util.Map<java.lang.String, com.google.common.util.concurrent.ListenableFuture<androidx.work.ListenableWorker$a>> r2 = r2.f8663h     // Catch: java.lang.Throwable -> L80
                java.lang.String r3 = r7.f8666c     // Catch: java.lang.Throwable -> L80
                r2.remove(r3)     // Catch: java.lang.Throwable -> L80
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L80
                throw r0
            L80:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L80
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.multiprocess.e.a.run():void");
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f8669b;

        public b(ListenableFuture listenableFuture, c cVar) {
            this.f8668a = listenableFuture;
            this.f8669b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8668a.cancel(true);
            d.a.b(this.f8669b, e.f8657o);
        }
    }

    public e(@n0 Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f8659d = applicationContext;
        l2.i iVarH = l2.i.H(applicationContext);
        this.f8660e = iVarH;
        this.f8661f = iVarH.F();
        this.f8662g = iVarH.O();
        this.f8663h = new HashMap();
    }

    @n0
    public final ListenableFuture<ListenableWorker.a> T0(@n0 String str, @n0 String str2, @n0 WorkerParameters workerParameters) {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        androidx.work.l lVarC = androidx.work.l.c();
        String str3 = f8656n;
        lVarC.a(str3, String.format("Tracking execution of %s (%s)", str, str2), new Throwable[0]);
        synchronized (f8658p) {
            this.f8663h.put(str, aVarU);
        }
        ListenableWorker listenableWorkerB = this.f8661f.m().b(this.f8659d, str2, workerParameters);
        if (listenableWorkerB == null) {
            String str4 = String.format("Unable to create an instance of %s", str2);
            androidx.work.l.c().b(str3, str4, new Throwable[0]);
            aVarU.q(new IllegalStateException(str4));
            return aVarU;
        }
        if (listenableWorkerB instanceof RemoteListenableWorker) {
            try {
                aVarU.r(((RemoteListenableWorker) listenableWorkerB).y());
            } catch (Throwable th2) {
                aVarU.q(th2);
            }
            return aVarU;
        }
        String str5 = String.format("%s does not extend %s", str2, RemoteListenableWorker.class.getName());
        androidx.work.l.c().b(str3, str5, new Throwable[0]);
        aVarU.q(new IllegalStateException(str5));
        return aVarU;
    }

    @Override // androidx.work.multiprocess.a
    public void Y(@n0 byte[] bArr, @n0 c cVar) {
        try {
            ParcelableRemoteWorkRequest parcelableRemoteWorkRequest = (ParcelableRemoteWorkRequest) x2.a.b(bArr, ParcelableRemoteWorkRequest.CREATOR);
            WorkerParameters workerParametersJ = parcelableRemoteWorkRequest.a().j(this.f8660e);
            String string = workerParametersJ.c().toString();
            String strB = parcelableRemoteWorkRequest.b();
            androidx.work.l.c().a(f8656n, String.format("Executing work request (%s, %s)", string, strB), new Throwable[0]);
            ListenableFuture<ListenableWorker.a> listenableFutureT0 = T0(string, strB, workerParametersJ);
            listenableFutureT0.addListener(new a(listenableFutureT0, cVar, string), this.f8662g.d());
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.a
    public void q0(@n0 byte[] bArr, @n0 c cVar) {
        ListenableFuture<ListenableWorker.a> listenableFutureRemove;
        try {
            String string = ((ParcelableWorkerParameters) x2.a.b(bArr, ParcelableWorkerParameters.CREATOR)).b().toString();
            androidx.work.l.c().a(f8656n, String.format("Interrupting work with id (%s)", string), new Throwable[0]);
            synchronized (f8658p) {
                listenableFutureRemove = this.f8663h.remove(string);
            }
            if (listenableFutureRemove != null) {
                this.f8660e.O().d().execute(new b(listenableFutureRemove, cVar));
            } else {
                d.a.b(cVar, f8657o);
            }
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }
}
