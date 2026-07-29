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
public class q implements androidx.work.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f52625d = androidx.work.l.f("WMFgUpdater");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.a f52626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2.a f52627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2.s f52628c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f52629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UUID f52630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.work.g f52631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f52632d;

        public a(final androidx.work.impl.utils.futures.a val$future, final UUID val$id, final androidx.work.g val$foregroundInfo, final Context val$context) {
            this.f52629a = val$future;
            this.f52630b = val$id;
            this.f52631c = val$foregroundInfo;
            this.f52632d = val$context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f52629a.isCancelled()) {
                    String string = this.f52630b.toString();
                    WorkInfo.State stateT = q.this.f52628c.t(string);
                    if (stateT == null || stateT.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    q.this.f52627b.a(string, this.f52631c);
                    this.f52632d.startService(androidx.work.impl.foreground.a.d(this.f52632d, string, this.f52631c));
                }
                this.f52629a.p(null);
            } catch (Throwable th2) {
                this.f52629a.q(th2);
            }
        }
    }

    public q(@n0 WorkDatabase workDatabase, @n0 t2.a foregroundProcessor, @n0 w2.a taskExecutor) {
        this.f52627b = foregroundProcessor;
        this.f52626a = taskExecutor;
        this.f52628c = workDatabase.W();
    }

    @Override // androidx.work.h
    @n0
    public ListenableFuture<Void> a(@n0 final Context context, @n0 final UUID id2, @n0 final androidx.work.g foregroundInfo) {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        this.f52626a.c(new a(aVarU, id2, foregroundInfo, context));
        return aVarU;
    }
}
