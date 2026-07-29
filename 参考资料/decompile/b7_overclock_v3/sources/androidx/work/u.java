package androidx.work;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {
    @n0
    public static u a(@n0 List<u> continuations) {
        return continuations.get(0).b(continuations);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public abstract u b(@n0 List<u> continuations);

    @n0
    public abstract o c();

    @n0
    public abstract ListenableFuture<List<WorkInfo>> d();

    @n0
    public abstract LiveData<List<WorkInfo>> e();

    @n0
    public final u f(@n0 m work) {
        return g(Collections.singletonList(work));
    }

    @n0
    public abstract u g(@n0 List<m> work);
}
