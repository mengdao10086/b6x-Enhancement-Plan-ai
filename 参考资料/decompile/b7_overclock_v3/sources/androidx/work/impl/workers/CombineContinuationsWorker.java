package androidx.work.impl.workers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CombineContinuationsWorker extends Worker {
    public CombineContinuationsWorker(@n0 Context context, @n0 WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override // androidx.work.Worker
    @n0
    public ListenableWorker.a y() {
        return ListenableWorker.a.f(g());
    }
}
