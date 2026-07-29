package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.a;
import ed.z;
import g.p0;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f19261b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.InterfaceC0197a f19262c = new a.InterfaceC0197a() { // from class: ed.p
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        public final com.google.android.exoplayer2.upstream.a a() {
            return com.google.android.exoplayer2.upstream.h.u();
        }
    };

    public static /* synthetic */ h u() {
        return new h();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        throw new IOException("DummyDataSource cannot be opened");
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map c() {
        return ed.k.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return null;
    }
}
