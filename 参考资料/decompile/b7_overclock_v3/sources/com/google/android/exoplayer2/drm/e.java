package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import g.p0;
import gb.s;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements DrmSession {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DrmSession.DrmSessionException f17059f;

    public e(DrmSession.DrmSessionException drmSessionException) {
        this.f17059f = (DrmSession.DrmSessionException) hd.a.g(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public DrmSession.DrmSessionException d() {
        return this.f17059f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void e(@p0 b.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void f(@p0 b.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID g() {
        return ya.g.H1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean h() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public Map<String, String> i() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public s j() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @p0
    public byte[] k() {
        return null;
    }
}
