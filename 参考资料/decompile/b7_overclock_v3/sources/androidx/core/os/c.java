package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f4650a = new c();

    @g.u
    @hk.m
    public static final void a(@yt.k Bundle bundle, @yt.k String key, @yt.l Size size) {
        f0.p(bundle, "bundle");
        f0.p(key, "key");
        bundle.putSize(key, size);
    }

    @g.u
    @hk.m
    public static final void b(@yt.k Bundle bundle, @yt.k String key, @yt.l SizeF sizeF) {
        f0.p(bundle, "bundle");
        f0.p(key, "key");
        bundle.putSizeF(key, sizeF);
    }
}
