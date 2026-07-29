package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.a;
import ed.z;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class i implements a.InterfaceC0197a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileDataSource.a f19263a;

    public i() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileDataSource a() {
        return this.f19263a.a();
    }

    public i(@p0 z zVar) {
        this.f19263a = new FileDataSource.a().e(zVar);
    }
}
