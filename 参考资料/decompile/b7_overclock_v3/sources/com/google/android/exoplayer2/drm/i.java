package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.f;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f17094a;

    public i(byte[] bArr) {
        this.f17094a = (byte[]) hd.a.g(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] a(UUID uuid, f.b bVar) {
        return this.f17094a;
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] b(UUID uuid, f.h hVar) {
        throw new UnsupportedOperationException();
    }
}
