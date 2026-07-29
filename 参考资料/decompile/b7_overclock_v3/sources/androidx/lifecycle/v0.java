package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a0 f6262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Handler f6263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public a f6264c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final a0 f6265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final Lifecycle.Event f6266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6267c;

        public a(@yt.k a0 registry, @yt.k Lifecycle.Event event) {
            kotlin.jvm.internal.f0.p(registry, "registry");
            kotlin.jvm.internal.f0.p(event, "event");
            this.f6265a = registry;
            this.f6266b = event;
        }

        @yt.k
        public final Lifecycle.Event a() {
            return this.f6266b;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6267c) {
                return;
            }
            this.f6265a.l(this.f6266b);
            this.f6267c = true;
        }
    }

    public v0(@yt.k y provider) {
        kotlin.jvm.internal.f0.p(provider, "provider");
        this.f6262a = new a0(provider);
        this.f6263b = new Handler();
    }

    @yt.k
    public Lifecycle a() {
        return this.f6262a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }

    public final void f(Lifecycle.Event event) {
        a aVar = this.f6264c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f6262a, event);
        this.f6264c = aVar2;
        Handler handler = this.f6263b;
        kotlin.jvm.internal.f0.m(aVar2);
        handler.postAtFrontOfQueue(aVar2);
    }
}
