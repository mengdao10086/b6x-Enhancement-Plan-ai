package androidx.work.impl.utils.futures;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a<V> extends AbstractFuture<V> {
    public static <V> a<V> u() {
        return new a<>();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean p(@p0 V value) {
        return super.p(value);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean q(Throwable throwable) {
        return super.q(throwable);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean r(ListenableFuture<? extends V> future) {
        return super.r(future);
    }
}
