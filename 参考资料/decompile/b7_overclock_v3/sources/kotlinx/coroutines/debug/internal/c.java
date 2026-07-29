package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.s0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@s0
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final CoroutineContext f38446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final zj.c f38447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f38448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final List<StackTraceElement> f38449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final String f38450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final Thread f38451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final zj.c f38452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final List<StackTraceElement> f38453h;

    public c(@k DebugCoroutineInfoImpl debugCoroutineInfoImpl, @k CoroutineContext coroutineContext) {
        this.f38446a = coroutineContext;
        this.f38447b = debugCoroutineInfoImpl.d();
        this.f38448c = debugCoroutineInfoImpl.f38419b;
        this.f38449d = debugCoroutineInfoImpl.e();
        this.f38450e = debugCoroutineInfoImpl.g();
        this.f38451f = debugCoroutineInfoImpl.lastObservedThread;
        this.f38452g = debugCoroutineInfoImpl.f();
        this.f38453h = debugCoroutineInfoImpl.h();
    }

    @k
    public final CoroutineContext a() {
        return this.f38446a;
    }

    @l
    public final zj.c b() {
        return this.f38447b;
    }

    @k
    public final List<StackTraceElement> c() {
        return this.f38449d;
    }

    @l
    public final zj.c d() {
        return this.f38452g;
    }

    @l
    public final Thread e() {
        return this.f38451f;
    }

    public final long f() {
        return this.f38448c;
    }

    @k
    public final String g() {
        return this.f38450e;
    }

    @hk.h(name = "lastObservedStackTrace")
    @k
    public final List<StackTraceElement> h() {
        return this.f38453h;
    }
}
