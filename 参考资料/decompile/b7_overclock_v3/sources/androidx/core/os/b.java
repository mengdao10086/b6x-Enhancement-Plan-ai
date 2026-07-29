package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(18)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f4649a = new b();

    @g.u
    @hk.m
    public static final void a(@yt.k Bundle bundle, @yt.k String key, @yt.l IBinder iBinder) {
        f0.p(bundle, "bundle");
        f0.p(key, "key");
        bundle.putBinder(key, iBinder);
    }
}
