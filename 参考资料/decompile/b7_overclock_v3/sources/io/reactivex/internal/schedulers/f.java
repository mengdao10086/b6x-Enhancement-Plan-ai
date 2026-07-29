package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class f extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f35203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f35200d = "RxNewThreadScheduler";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f35202f = "rx2.newthread-priority";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f35201e = new RxThreadFactory(f35200d, Math.max(1, Math.min(10, Integer.getInteger(f35202f, 5).intValue())));

    public f() {
        this(f35201e);
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return new g(this.f35203c);
    }

    public f(ThreadFactory threadFactory) {
        this.f35203c = threadFactory;
    }
}
