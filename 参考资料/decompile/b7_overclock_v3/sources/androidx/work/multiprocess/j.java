package androidx.work.multiprocess;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public j() {
    }

    @n0
    public static j a(@n0 List<j> continuations) {
        return continuations.get(0).b(continuations);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public abstract j b(@n0 List<j> continuations);

    @n0
    public abstract ListenableFuture<Void> c();

    @n0
    public final j d(@n0 androidx.work.m work) {
        return e(Collections.singletonList(work));
    }

    @n0
    public abstract j e(@n0 List<androidx.work.m> work);
}
