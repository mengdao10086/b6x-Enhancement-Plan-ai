package v2;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class r implements androidx.work.s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52634c = androidx.work.l.f("WorkProgressUpdater");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f52635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w2.a f52636b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UUID f52637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.work.d f52638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f52639c;

        public a(final UUID val$id, final androidx.work.d val$data, final androidx.work.impl.utils.futures.a val$future) {
            this.f52637a = val$id;
            this.f52638b = val$data;
            this.f52639c = val$future;
        }

        @Override // java.lang.Runnable
        public void run() {
            u2.r rVarU;
            String string = this.f52637a.toString();
            androidx.work.l lVarC = androidx.work.l.c();
            String str = r.f52634c;
            lVarC.a(str, String.format("Updating progress for %s (%s)", this.f52637a, this.f52638b), new Throwable[0]);
            r.this.f52635a.e();
            try {
                rVarU = r.this.f52635a.W().u(string);
            } finally {
                try {
                } finally {
                }
            }
            if (rVarU == null) {
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            }
            if (rVarU.f51842b == WorkInfo.State.RUNNING) {
                r.this.f52635a.V().c(new u2.o(string, this.f52638b));
            } else {
                androidx.work.l.c().h(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", string), new Throwable[0]);
            }
            this.f52639c.p(null);
            r.this.f52635a.K();
        }
    }

    public r(@n0 WorkDatabase workDatabase, @n0 w2.a taskExecutor) {
        this.f52635a = workDatabase;
        this.f52636b = taskExecutor;
    }

    @Override // androidx.work.s
    @n0
    public ListenableFuture<Void> a(@n0 final Context context, @n0 final UUID id2, @n0 final androidx.work.d data) {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        this.f52636b.c(new a(id2, data, aVarU));
        return aVarU;
    }
}
