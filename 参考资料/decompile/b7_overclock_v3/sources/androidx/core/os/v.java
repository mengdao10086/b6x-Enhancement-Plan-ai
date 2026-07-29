package androidx.core.os;

import android.os.PersistableBundle;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(22)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final v f4675a = new v();

    @g.u
    @hk.m
    public static final void a(@yt.k PersistableBundle persistableBundle, @yt.l String str, boolean z10) {
        f0.p(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(str, z10);
    }

    @g.u
    @hk.m
    public static final void b(@yt.k PersistableBundle persistableBundle, @yt.l String str, @yt.k boolean[] value) {
        f0.p(persistableBundle, "persistableBundle");
        f0.p(value, "value");
        persistableBundle.putBooleanArray(str, value);
    }
}
