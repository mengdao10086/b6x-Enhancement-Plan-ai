package l9;

import hk.m;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f39473a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final String f39474b = "FlyBle";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f39475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f39476d;

    @m
    public static final void c(@k String message) {
        f0.p(message, "message");
    }

    @m
    public static final void d(@k Throwable throwable) {
        f0.p(throwable, "throwable");
        if (f39475c) {
            throwable.getMessage();
        }
    }

    @m
    public static final void e(@k String message) {
        f0.p(message, "message");
    }

    @m
    public static final void f(@k String message) {
        f0.p(message, "message");
    }

    public final boolean a() {
        return f39475c;
    }

    public final boolean b() {
        return f39476d;
    }

    public final void g(boolean z10) {
        f39475c = z10;
    }

    public final void h(boolean z10) {
        f39476d = z10;
    }
}
