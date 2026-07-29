package ed;

import android.net.Uri;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import g.p0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f26965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityTaskManager f26966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26967d;

    public v(com.google.android.exoplayer2.upstream.a aVar, PriorityTaskManager priorityTaskManager, int i10) {
        this.f26965b = (com.google.android.exoplayer2.upstream.a) hd.a.g(aVar);
        this.f26966c = (PriorityTaskManager) hd.a.g(priorityTaskManager);
        this.f26967d = i10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        this.f26966c.d(this.f26967d);
        return this.f26965b.a(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return this.f26965b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f26965b.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f26965b.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        this.f26966c.d(this.f26967d);
        return this.f26965b.read(bArr, i10, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f26965b.s();
    }
}
