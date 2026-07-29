package p1;

import androidx.lifecycle.x0;
import ik.l;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class g<T extends x0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Class<T> f46305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final l<a, T> f46306b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@k Class<T> clazz, @k l<? super a, ? extends T> initializer) {
        f0.p(clazz, "clazz");
        f0.p(initializer, "initializer");
        this.f46305a = clazz;
        this.f46306b = initializer;
    }

    @k
    public final Class<T> a() {
        return this.f46305a;
    }

    @k
    public final l<a, T> b() {
        return this.f46306b;
    }
}
