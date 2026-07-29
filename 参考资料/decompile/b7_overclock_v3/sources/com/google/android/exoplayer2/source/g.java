package com.google.android.exoplayer2.source;

import android.net.Uri;
import ed.z;
import g.p0;
import hd.c0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f17762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f17764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f17765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17766f;

    public interface a {
        void a(c0 c0Var);
    }

    public g(com.google.android.exoplayer2.upstream.a aVar, int i10, a aVar2) {
        hd.a.a(i10 > 0);
        this.f17762b = aVar;
        this.f17763c = i10;
        this.f17764d = aVar2;
        this.f17765e = new byte[1];
        this.f17766f = i10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return this.f17762b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f17762b.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f17766f == 0) {
            if (!u()) {
                return -1;
            }
            this.f17766f = this.f17763c;
        }
        int i12 = this.f17762b.read(bArr, i10, Math.min(this.f17766f, i11));
        if (i12 != -1) {
            this.f17766f -= i12;
        }
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f17762b.s();
    }

    public final boolean u() throws IOException {
        if (this.f17762b.read(this.f17765e, 0, 1) == -1) {
            return false;
        }
        int i10 = (this.f17765e[0] & 255) << 4;
        if (i10 == 0) {
            return true;
        }
        byte[] bArr = new byte[i10];
        int i11 = i10;
        int i12 = 0;
        while (i11 > 0) {
            int i13 = this.f17762b.read(bArr, i12, i11);
            if (i13 == -1) {
                return false;
            }
            i12 += i13;
            i11 -= i13;
        }
        while (i10 > 0 && bArr[i10 - 1] == 0) {
            i10--;
        }
        if (i10 > 0) {
            this.f17764d.a(new c0(bArr, i10));
        }
        return true;
    }
}
