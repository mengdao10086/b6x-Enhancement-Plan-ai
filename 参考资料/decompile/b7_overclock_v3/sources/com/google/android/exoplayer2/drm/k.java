package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.f;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import g.p0;
import g.v0;
import gb.z;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Format f17095e = new Format.b().L(new DrmInitData(new DrmInitData.SchemeData[0])).E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConditionVariable f17096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultDrmSessionManager f17097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HandlerThread f17098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f17099d;

    public class a implements b {
        public a() {
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i10, @p0 l.a aVar) {
            k.this.f17096a.open();
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void H(int i10, l.a aVar) {
            gb.j.d(this, i10, aVar);
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void M(int i10, @p0 l.a aVar) {
            k.this.f17096a.open();
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void T(int i10, l.a aVar) {
            gb.j.f(this, i10, aVar);
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void a0(int i10, @p0 l.a aVar) {
            k.this.f17096a.open();
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void q(int i10, @p0 l.a aVar, Exception exc) {
            k.this.f17096a.open();
        }
    }

    @Deprecated
    public k(UUID uuid, f.g gVar, j jVar, @p0 Map<String, String> map, b.a aVar) {
        this(new DefaultDrmSessionManager.b().h(uuid, gVar).b(map).a(jVar), aVar);
    }

    public static k e(String str, HttpDataSource.b bVar, b.a aVar) {
        return f(str, false, bVar, aVar);
    }

    public static k f(String str, boolean z10, HttpDataSource.b bVar, b.a aVar) {
        return g(str, z10, bVar, null, aVar);
    }

    public static k g(String str, boolean z10, HttpDataSource.b bVar, @p0 Map<String, String> map, b.a aVar) {
        return new k(new DefaultDrmSessionManager.b().b(map).a(new h(str, z10, bVar)), aVar);
    }

    public final byte[] b(int i10, @p0 byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        this.f17097b.f();
        DrmSession drmSessionH = h(i10, bArr, format);
        DrmSession.DrmSessionException drmSessionExceptionD = drmSessionH.d();
        byte[] bArrK = drmSessionH.k();
        drmSessionH.f(this.f17099d);
        this.f17097b.release();
        if (drmSessionExceptionD == null) {
            return (byte[]) hd.a.g(bArrK);
        }
        throw drmSessionExceptionD;
    }

    public synchronized byte[] c(Format format) throws DrmSession.DrmSessionException {
        hd.a.a(format.f16702o != null);
        return b(2, null, format);
    }

    public synchronized Pair<Long, Long> d(byte[] bArr) throws DrmSession.DrmSessionException {
        hd.a.g(bArr);
        this.f17097b.f();
        DrmSession drmSessionH = h(1, bArr, f17095e);
        DrmSession.DrmSessionException drmSessionExceptionD = drmSessionH.d();
        Pair<Long, Long> pairB = z.b(drmSessionH);
        drmSessionH.f(this.f17099d);
        this.f17097b.release();
        if (drmSessionExceptionD == null) {
            return (Pair) hd.a.g(pairB);
        }
        if (!(drmSessionExceptionD.getCause() instanceof KeysExpiredException)) {
            throw drmSessionExceptionD;
        }
        return Pair.create(0L, 0L);
    }

    public final DrmSession h(int i10, @p0 byte[] bArr, Format format) {
        hd.a.g(format.f16702o);
        this.f17097b.t(i10, bArr);
        this.f17096a.close();
        DrmSession drmSessionA = this.f17097b.a(this.f17098c.getLooper(), this.f17099d, format);
        this.f17096a.block();
        return (DrmSession) hd.a.g(drmSessionA);
    }

    public void i() {
        this.f17098c.quit();
    }

    public synchronized void j(byte[] bArr) throws DrmSession.DrmSessionException {
        hd.a.g(bArr);
        b(3, bArr, f17095e);
    }

    public synchronized byte[] k(byte[] bArr) throws DrmSession.DrmSessionException {
        hd.a.g(bArr);
        return b(2, bArr, f17095e);
    }

    public k(DefaultDrmSessionManager defaultDrmSessionManager, b.a aVar) {
        this.f17097b = defaultDrmSessionManager;
        this.f17099d = aVar;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.f17098c = handlerThread;
        handlerThread.start();
        this.f17096a = new ConditionVariable();
        aVar.g(new Handler(handlerThread.getLooper()), new a());
    }
}
