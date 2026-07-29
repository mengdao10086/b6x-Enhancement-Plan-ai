package androidx.activity.result;

import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @yt.k
    public static final <I, O> g<z1> c(@yt.k b bVar, @yt.k f.a<I, O> contract, I i10, @yt.k ActivityResultRegistry registry, @yt.k final l<? super O, z1> callback) {
        f0.p(bVar, "<this>");
        f0.p(contract, "contract");
        f0.p(registry, "registry");
        f0.p(callback, "callback");
        g<I> gVarG = bVar.G(contract, registry, new a() { // from class: androidx.activity.result.d
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                e.e(callback, obj);
            }
        });
        f0.o(gVarG, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(gVarG, contract, i10);
    }

    @yt.k
    public static final <I, O> g<z1> d(@yt.k b bVar, @yt.k f.a<I, O> contract, I i10, @yt.k final l<? super O, z1> callback) {
        f0.p(bVar, "<this>");
        f0.p(contract, "contract");
        f0.p(callback, "callback");
        g<I> gVarP1 = bVar.P1(contract, new a() { // from class: androidx.activity.result.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                e.f(callback, obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(gVarP1, contract, i10);
    }

    public static final void e(l callback, Object obj) {
        f0.p(callback, "$callback");
        callback.i(obj);
    }

    public static final void f(l callback, Object obj) {
        f0.p(callback, "$callback");
        callback.i(obj);
    }
}
