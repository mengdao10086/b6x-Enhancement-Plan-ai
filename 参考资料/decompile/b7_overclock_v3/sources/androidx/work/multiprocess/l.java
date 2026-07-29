package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.p;
import androidx.work.u;
import androidx.work.w;
import androidx.work.x;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public l() {
    }

    @n0
    public static l o(@n0 Context context) {
        l lVarK = l2.i.H(context).K();
        if (lVarK != null) {
            return lVarK;
        }
        throw new IllegalStateException("Unable to initialize RemoteWorkManager");
    }

    @n0
    public final j a(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 androidx.work.m work) {
        return b(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    @n0
    public abstract j b(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<androidx.work.m> work);

    @n0
    public final j c(@n0 androidx.work.m work) {
        return d(Collections.singletonList(work));
    }

    @n0
    public abstract j d(@n0 List<androidx.work.m> work);

    @n0
    public abstract ListenableFuture<Void> e();

    @n0
    public abstract ListenableFuture<Void> f(@n0 String tag);

    @n0
    public abstract ListenableFuture<Void> g(@n0 String uniqueWorkName);

    @n0
    public abstract ListenableFuture<Void> h(@n0 UUID id2);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public abstract ListenableFuture<Void> i(@n0 u continuation);

    @n0
    public abstract ListenableFuture<Void> j(@n0 x request);

    @n0
    public abstract ListenableFuture<Void> k(@n0 List<x> requests);

    @n0
    public abstract ListenableFuture<Void> l(@n0 String uniqueWorkName, @n0 ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @n0 p periodicWork);

    @n0
    public final ListenableFuture<Void> m(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 androidx.work.m work) {
        return n(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    @n0
    public abstract ListenableFuture<Void> n(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<androidx.work.m> work);

    @n0
    public abstract ListenableFuture<List<WorkInfo>> p(@n0 w workQuery);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public abstract ListenableFuture<Void> q(@n0 UUID id2, @n0 androidx.work.d data);
}
