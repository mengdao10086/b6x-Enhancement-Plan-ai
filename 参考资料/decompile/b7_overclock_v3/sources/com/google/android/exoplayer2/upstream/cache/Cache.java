package com.google.android.exoplayer2.upstream.cache;

import fd.g;
import fd.l;
import fd.m;
import g.j1;
import g.p0;
import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f19132a = -1;

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th2) {
            super(th2);
        }

        public CacheException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public interface a {
        void b(Cache cache, g gVar);

        void c(Cache cache, g gVar);

        void f(Cache cache, g gVar, g gVar2);
    }

    long a();

    @j1
    File b(String str, long j10, long j11) throws CacheException;

    @j1
    void c(g gVar);

    l d(String str);

    long e(String str, long j10, long j11);

    @p0
    @j1
    g f(String str, long j10, long j11) throws CacheException;

    long g(String str, long j10, long j11);

    @j1
    g h(String str, long j10, long j11) throws InterruptedException, CacheException;

    Set<String> i();

    @j1
    void j(File file, long j10) throws CacheException;

    @j1
    void k(String str);

    @j1
    void l(String str, m mVar) throws CacheException;

    long m();

    void n(g gVar);

    boolean o(String str, long j10, long j11);

    NavigableSet<g> p(String str, a aVar);

    NavigableSet<g> q(String str);

    void r(String str, a aVar);

    @j1
    void release();
}
