package androidx.work;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AddedAbstractMethod"})
public abstract class v {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public v() {
    }

    public static void A(@n0 Context context, @n0 a configuration) {
        l2.i.A(context, configuration);
    }

    @n0
    @Deprecated
    public static v o() {
        l2.i iVarG = l2.i.G();
        if (iVarG != null) {
            return iVarG;
        }
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    @n0
    public static v p(@n0 Context context) {
        return l2.i.H(context);
    }

    @n0
    public abstract o B();

    @n0
    public final u a(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 m work) {
        return b(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    @n0
    public abstract u b(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<m> work);

    @n0
    public final u c(@n0 m work) {
        return d(Collections.singletonList(work));
    }

    @n0
    public abstract u d(@n0 List<m> work);

    @n0
    public abstract o e();

    @n0
    public abstract o f(@n0 String tag);

    @n0
    public abstract o g(@n0 String uniqueWorkName);

    @n0
    public abstract o h(@n0 UUID id2);

    @n0
    public abstract PendingIntent i(@n0 UUID id2);

    @n0
    public final o j(@n0 x workRequest) {
        return k(Collections.singletonList(workRequest));
    }

    @n0
    public abstract o k(@n0 List<? extends x> requests);

    @n0
    public abstract o l(@n0 String uniqueWorkName, @n0 ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @n0 p periodicWork);

    @n0
    public o m(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 m work) {
        return n(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    @n0
    public abstract o n(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<m> work);

    @n0
    public abstract ListenableFuture<Long> q();

    @n0
    public abstract LiveData<Long> r();

    @n0
    public abstract ListenableFuture<WorkInfo> s(@n0 UUID id2);

    @n0
    public abstract LiveData<WorkInfo> t(@n0 UUID id2);

    @n0
    public abstract ListenableFuture<List<WorkInfo>> u(@n0 w workQuery);

    @n0
    public abstract ListenableFuture<List<WorkInfo>> v(@n0 String tag);

    @n0
    public abstract LiveData<List<WorkInfo>> w(@n0 String tag);

    @n0
    public abstract ListenableFuture<List<WorkInfo>> x(@n0 String uniqueWorkName);

    @n0
    public abstract LiveData<List<WorkInfo>> y(@n0 String uniqueWorkName);

    @n0
    public abstract LiveData<List<WorkInfo>> z(@n0 w workQuery);
}
