package androidx.concurrent.futures;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class a<V> extends AbstractResolvableFuture<V> {
    public static <V> a<V> u() {
        return new a<>();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean p(@p0 V v10) {
        return super.p(v10);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean q(Throwable th2) {
        return super.q(th2);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean r(ListenableFuture<? extends V> listenableFuture) {
        return super.r(listenableFuture);
    }
}
