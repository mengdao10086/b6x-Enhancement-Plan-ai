package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import ed.z;
import g.p0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends ed.h {

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.a$a, reason: collision with other inner class name */
    public interface InterfaceC0197a {
        a a();
    }

    long a(b bVar) throws IOException;

    Map<String, List<String>> c();

    void close() throws IOException;

    void d(z zVar);

    @p0
    Uri s();
}
