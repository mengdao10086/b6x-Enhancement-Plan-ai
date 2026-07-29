package androidx.work.multiprocess;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableResult;
import androidx.work.multiprocess.parcelable.ParcelableWorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import g.p0;
import java.util.concurrent.Executor;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteListenableWorker extends ListenableWorker {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8575l = androidx.work.l.f("RemoteListenableWorker");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8576m = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8577n = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WorkerParameters f8578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l2.i f8579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f8580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f8581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public String f8582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public ComponentName f8583k;

    public class a implements i<androidx.work.multiprocess.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8584a;

        public a(String str) {
            this.f8584a = str;
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.a aVar, @n0 androidx.work.multiprocess.c cVar) throws RemoteException {
            r rVarU = RemoteListenableWorker.this.f8579g.M().W().u(this.f8584a);
            RemoteListenableWorker.this.f8582j = rVarU.f51843c;
            aVar.Y(x2.a.a(new ParcelableRemoteWorkRequest(rVarU.f51843c, RemoteListenableWorker.this.f8578f)), cVar);
        }
    }

    public class b implements p.a<byte[], ListenableWorker.a> {
        public b() {
        }

        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableWorker.a apply(byte[] bArr) {
            ParcelableResult parcelableResult = (ParcelableResult) x2.a.b(bArr, ParcelableResult.CREATOR);
            androidx.work.l.c().a(RemoteListenableWorker.f8575l, "Cleaning up", new Throwable[0]);
            RemoteListenableWorker.this.f8581i.f();
            return parcelableResult.a();
        }
    }

    public class c implements i<androidx.work.multiprocess.a> {
        public c() {
        }

        @Override // androidx.work.multiprocess.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 androidx.work.multiprocess.a aVar, @n0 androidx.work.multiprocess.c cVar) throws RemoteException {
            aVar.q0(x2.a.a(new ParcelableWorkerParameters(RemoteListenableWorker.this.f8578f)), cVar);
        }
    }

    public RemoteListenableWorker(@n0 Context context, @n0 WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f8578f = workerParameters;
        l2.i iVarH = l2.i.H(context);
        this.f8579g = iVarH;
        v2.j jVarD = iVarH.O().d();
        this.f8580h = jVarD;
        this.f8581i = new f(a(), jVarD);
    }

    @Override // androidx.work.ListenableWorker
    public void r() {
        super.r();
        ComponentName componentName = this.f8583k;
        if (componentName != null) {
            this.f8581i.a(componentName, new c());
        }
    }

    @Override // androidx.work.ListenableWorker
    @n0
    public ListenableFuture<Void> t(@n0 androidx.work.d dVar) {
        return l.o(a()).q(e(), dVar);
    }

    @Override // androidx.work.ListenableWorker
    @n0
    public final ListenableFuture<ListenableWorker.a> w() {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        androidx.work.d dVarG = g();
        String string = this.f8578f.c().toString();
        String strA = dVarG.A(f8576m);
        String strA2 = dVarG.A(f8577n);
        if (TextUtils.isEmpty(strA)) {
            androidx.work.l.c().b(f8575l, "Need to specify a package name for the Remote Service.", new Throwable[0]);
            aVarU.q(new IllegalArgumentException("Need to specify a package name for the Remote Service."));
            return aVarU;
        }
        if (TextUtils.isEmpty(strA2)) {
            androidx.work.l.c().b(f8575l, "Need to specify a class name for the Remote Service.", new Throwable[0]);
            aVarU.q(new IllegalArgumentException("Need to specify a class name for the Remote Service."));
            return aVarU;
        }
        ComponentName componentName = new ComponentName(strA, strA2);
        this.f8583k = componentName;
        return h.a(this.f8581i.a(componentName, new a(string)), new b(), this.f8580h);
    }

    @n0
    public abstract ListenableFuture<ListenableWorker.a> y();
}
