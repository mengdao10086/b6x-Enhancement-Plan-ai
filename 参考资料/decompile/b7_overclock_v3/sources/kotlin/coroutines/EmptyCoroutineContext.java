package kotlin.coroutines;

import ik.p;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final EmptyCoroutineContext f37755a = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f37755a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k
    public CoroutineContext L(@k CoroutineContext context) {
        f0.p(context, "context");
        return context;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @l
    public <E extends CoroutineContext.a> E c(@k CoroutineContext.b<E> key) {
        f0.p(key, "key");
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k
    public CoroutineContext f(@k CoroutineContext.b<?> key) {
        f0.p(key, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @k p<? super R, ? super CoroutineContext.a, ? extends R> operation) {
        f0.p(operation, "operation");
        return r10;
    }

    @k
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
