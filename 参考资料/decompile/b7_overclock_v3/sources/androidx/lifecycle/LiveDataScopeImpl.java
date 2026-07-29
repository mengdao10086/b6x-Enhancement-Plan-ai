package androidx.lifecycle;

import android.annotation.SuppressLint;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.g1;

/* JADX INFO: loaded from: classes2.dex */
public final class LiveDataScopeImpl<T> implements g0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public CoroutineLiveData<T> f6106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f6107b;

    public LiveDataScopeImpl(@yt.k CoroutineLiveData<T> target, @yt.k CoroutineContext context) {
        kotlin.jvm.internal.f0.p(target, "target");
        kotlin.jvm.internal.f0.p(context, "context");
        this.f6106a = target;
        this.f6107b = context.L(kotlinx.coroutines.d1.e().o2());
    }

    @yt.k
    public final CoroutineLiveData<T> a() {
        return this.f6106a;
    }

    public final void b(@yt.k CoroutineLiveData<T> coroutineLiveData) {
        kotlin.jvm.internal.f0.p(coroutineLiveData, "<set-?>");
        this.f6106a = coroutineLiveData;
    }

    @Override // androidx.lifecycle.g0
    @yt.l
    @SuppressLint({"NullSafeMutableLiveData"})
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objH = kotlinx.coroutines.h.h(this.f6107b, new LiveDataScopeImpl$emit$2(this, t10, null), cVar);
        return objH == yj.b.h() ? objH : z1.f38230a;
    }

    @Override // androidx.lifecycle.g0
    @yt.l
    public Object g(@yt.k LiveData<T> liveData, @yt.k kotlin.coroutines.c<? super g1> cVar) {
        return kotlinx.coroutines.h.h(this.f6107b, new LiveDataScopeImpl$emitSource$2(this, liveData, null), cVar);
    }

    @Override // androidx.lifecycle.g0
    @yt.l
    public T h() {
        return this.f6106a.f();
    }
}
