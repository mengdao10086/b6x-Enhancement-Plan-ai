package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
final class PlatformRandom extends kotlin.random.a implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final a f38002c = new a(null);
    private static final long serialVersionUID = 0;

    @k
    private final java.util.Random impl;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public PlatformRandom(@k java.util.Random impl) {
        f0.p(impl, "impl");
        this.impl = impl;
    }

    @Override // kotlin.random.a
    @k
    public java.util.Random v() {
        return this.impl;
    }
}
