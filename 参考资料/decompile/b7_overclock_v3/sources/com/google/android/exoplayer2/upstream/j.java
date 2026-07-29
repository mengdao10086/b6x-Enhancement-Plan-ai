package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface j {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ec.j f19264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ec.k f19265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IOException f19266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19267d;

        public a(ec.j jVar, ec.k kVar, IOException iOException, int i10) {
            this.f19264a = jVar;
            this.f19265b = kVar;
            this.f19266c = iOException;
            this.f19267d = i10;
        }
    }

    long a(a aVar);

    @Deprecated
    long b(int i10, long j10, IOException iOException, int i11);

    @Deprecated
    long c(int i10, long j10, IOException iOException, int i11);

    void d(long j10);

    long e(a aVar);

    int f(int i10);
}
