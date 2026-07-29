package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import g.p0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class FullSegmentEncryptionKeyCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Uri, byte[]> f17775a;

    public FullSegmentEncryptionKeyCache(final int i10) {
        this.f17775a = new LinkedHashMap<Uri, byte[]>(i10 + 1, 1.0f, false) { // from class: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i10;
            }
        };
    }

    public boolean a(Uri uri) {
        return this.f17775a.containsKey(hd.a.g(uri));
    }

    @p0
    public byte[] b(@p0 Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f17775a.get(uri);
    }

    @p0
    public byte[] c(Uri uri, byte[] bArr) {
        return this.f17775a.put((Uri) hd.a.g(uri), (byte[]) hd.a.g(bArr));
    }

    @p0
    public byte[] d(Uri uri) {
        return this.f17775a.remove(hd.a.g(uri));
    }
}
