package androidx.lifecycle;

import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    @kotlin.jvm.internal.t0({"SMAP\nLiveData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveData.kt\nandroidx/lifecycle/LiveDataKt$observe$wrappedObserver$1\n*L\n1#1,55:1\n*E\n"})
    public static final class a<T> implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, z1> f6194a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.l<? super T, z1> lVar) {
            this.f6194a = lVar;
        }

        @Override // androidx.lifecycle.k0
        public final void b(T t10) {
            this.f6194a.i(t10);
        }
    }

    @g.k0
    @kotlin.k(message = "This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    @yt.k
    public static final <T> k0<T> a(@yt.k LiveData<T> liveData, @yt.k y owner, @yt.k ik.l<? super T, z1> onChanged) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        kotlin.jvm.internal.f0.p(owner, "owner");
        kotlin.jvm.internal.f0.p(onChanged, "onChanged");
        a aVar = new a(onChanged);
        liveData.k(owner, aVar);
        return aVar;
    }
}
