package com.google.android.exoplayer2.source;

import android.os.Handler;
import ed.z;
import g.p0;
import java.io.IOException;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public interface l {

    public static final class a extends ec.n {
        public a(Object obj) {
            super(obj);
        }

        @Override // ec.n
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            return new a(super.a(obj));
        }

        public a(Object obj, long j10) {
            super(obj, j10);
        }

        public a(Object obj, long j10, int i10) {
            super(obj, j10, i10);
        }

        public a(Object obj, int i10, int i11, long j10) {
            super(obj, i10, i11, j10);
        }

        public a(ec.n nVar) {
            super(nVar);
        }
    }

    public interface b {
        void b(l lVar, x1 x1Var);
    }

    k a(a aVar, ed.b bVar, long j10);

    void b(b bVar);

    void d(Handler handler, m mVar);

    void e(m mVar);

    void f(b bVar);

    @p0
    @Deprecated
    Object h();

    v0 j();

    void k(Handler handler, com.google.android.exoplayer2.drm.b bVar);

    void m(com.google.android.exoplayer2.drm.b bVar);

    void n() throws IOException;

    boolean o();

    void p(k kVar);

    @p0
    x1 q();

    void r(b bVar);

    void s(b bVar, @p0 z zVar);
}
