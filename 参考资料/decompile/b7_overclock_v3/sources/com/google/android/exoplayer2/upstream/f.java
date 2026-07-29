package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import ed.z;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class f extends HttpDataSource.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f19251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final z f19252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f19255f;

    public f() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e d(HttpDataSource.c cVar) {
        e eVar = new e(this.f19251b, this.f19253d, this.f19254e, this.f19255f, cVar);
        z zVar = this.f19252c;
        if (zVar != null) {
            eVar.d(zVar);
        }
        return eVar;
    }

    public f(@p0 String str) {
        this(str, null);
    }

    public f(@p0 String str, @p0 z zVar) {
        this(str, zVar, 8000, 8000, false);
    }

    public f(@p0 String str, int i10, int i11, boolean z10) {
        this(str, null, i10, i11, z10);
    }

    public f(@p0 String str, @p0 z zVar, int i10, int i11, boolean z10) {
        this.f19251b = str;
        this.f19252c = zVar;
        this.f19253d = i10;
        this.f19254e = i11;
        this.f19255f = z10;
    }
}
