package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.d;
import ed.u;
import ed.z;
import g.p0;
import gc.i;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends i {

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.a$a, reason: collision with other inner class name */
    public interface InterfaceC0184a {
        a a(u uVar, ic.b bVar, int i10, int[] iArr, com.google.android.exoplayer2.trackselection.b bVar2, int i11, long j10, boolean z10, List<Format> list, @p0 d.c cVar, @p0 z zVar);
    }

    void b(com.google.android.exoplayer2.trackselection.b bVar);

    void g(ic.b bVar, int i10);
}
