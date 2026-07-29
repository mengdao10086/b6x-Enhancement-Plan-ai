package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import ed.z;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements a.InterfaceC0197a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final z f19221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0197a f19222c;

    public d(Context context) {
        this(context, (String) null, (z) null);
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c a() {
        c cVar = new c(this.f19220a, this.f19222c.a());
        z zVar = this.f19221b;
        if (zVar != null) {
            cVar.d(zVar);
        }
        return cVar;
    }

    public d(Context context, @p0 String str) {
        this(context, str, (z) null);
    }

    public d(Context context, @p0 String str, @p0 z zVar) {
        this(context, zVar, new e.b().k(str));
    }

    public d(Context context, a.InterfaceC0197a interfaceC0197a) {
        this(context, (z) null, interfaceC0197a);
    }

    public d(Context context, @p0 z zVar, a.InterfaceC0197a interfaceC0197a) {
        this.f19220a = context.getApplicationContext();
        this.f19221b = zVar;
        this.f19222c = interfaceC0197a;
    }
}
