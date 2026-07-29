package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import g.p0;
import gb.q;
import gb.s;
import gb.y;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final c f17058b;

    public class a implements c {
        @Override // com.google.android.exoplayer2.drm.c
        @p0
        public DrmSession a(Looper looper, @p0 b.a aVar, Format format) {
            if (format.f16702o == null) {
                return null;
            }
            return new e(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }

        @Override // com.google.android.exoplayer2.drm.c
        @p0
        public Class<y> b(Format format) {
            if (format.f16702o != null) {
                return y.class;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void f() {
            q.a(this);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void release() {
            q.b(this);
        }
    }

    static {
        a aVar = new a();
        f17057a = aVar;
        f17058b = aVar;
    }

    @p0
    DrmSession a(Looper looper, @p0 b.a aVar, Format format);

    @p0
    Class<? extends s> b(Format format);

    void f();

    void release();
}
