package androidx.lifecycle;

import androidx.lifecycle.z0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a1 {
    static {
        z0.b.a aVar = z0.b.f6281a;
    }

    @yt.k
    public static x0 a(z0.b bVar, @yt.k Class modelClass) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @yt.k
    public static x0 b(z0.b bVar, @yt.k Class modelClass, @yt.k p1.a extras) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        kotlin.jvm.internal.f0.p(extras, "extras");
        return bVar.a(modelClass);
    }

    @hk.m
    @yt.k
    public static z0.b c(@yt.k p1.g<?>... gVarArr) {
        return z0.b.f6281a.a(gVarArr);
    }
}
