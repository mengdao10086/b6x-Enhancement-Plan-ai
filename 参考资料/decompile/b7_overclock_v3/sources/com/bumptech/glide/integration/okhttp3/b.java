package com.bumptech.glide.integration.okhttp3;

import g.n0;
import h4.g;
import h4.n;
import h4.o;
import h4.r;
import java.io.InputStream;
import okhttp3.a0;
import okhttp3.e;

/* JADX INFO: loaded from: classes2.dex */
public class b implements n<g, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f12161a;

    public static class a implements o<g, InputStream> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile e.a f12162b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e.a f12163a;

        public a() {
            this(b());
        }

        public static e.a b() {
            if (f12162b == null) {
                synchronized (a.class) {
                    if (f12162b == null) {
                        f12162b = new a0();
                    }
                }
            }
            return f12162b;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<g, InputStream> c(r rVar) {
            return new b(this.f12163a);
        }

        public a(@n0 e.a aVar) {
            this.f12163a = aVar;
        }
    }

    public b(@n0 e.a aVar) {
        this.f12161a = aVar;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@n0 g gVar, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(gVar, new b4.a(this.f12161a, gVar));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 g gVar) {
        return true;
    }
}
