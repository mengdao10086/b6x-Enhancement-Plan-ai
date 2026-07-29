package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.f;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    byte[] a(UUID uuid, f.b bVar) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, f.h hVar) throws MediaDrmCallbackException;
}
