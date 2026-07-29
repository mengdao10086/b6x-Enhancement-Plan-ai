package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.a;
import ed.z;
import g.p0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f19277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f19278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19279d;

    public static final class a implements a.InterfaceC0197a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0197a f19280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f19281b;

        public a(a.InterfaceC0197a interfaceC0197a, b bVar) {
            this.f19280a = interfaceC0197a;
            this.f19281b = bVar;
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public m a() {
            return new m(this.f19280a.a(), this.f19281b);
        }
    }

    public interface b {
        com.google.android.exoplayer2.upstream.b a(com.google.android.exoplayer2.upstream.b bVar) throws IOException;

        Uri b(Uri uri);
    }

    public m(com.google.android.exoplayer2.upstream.a aVar, b bVar) {
        this.f19277b = aVar;
        this.f19278c = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        com.google.android.exoplayer2.upstream.b bVarA = this.f19278c.a(bVar);
        this.f19279d = true;
        return this.f19277b.a(bVarA);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return this.f19277b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        if (this.f19279d) {
            this.f19279d = false;
            this.f19277b.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f19277b.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f19277b.read(bArr, i10, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        Uri uriS = this.f19277b.s();
        if (uriS == null) {
            return null;
        }
        return this.f19278c.b(uriS);
    }
}
