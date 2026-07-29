package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import ed.v;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements a.InterfaceC0197a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.InterfaceC0197a f19274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityTaskManager f19275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19276c;

    public l(a.InterfaceC0197a interfaceC0197a, PriorityTaskManager priorityTaskManager, int i10) {
        this.f19274a = interfaceC0197a;
        this.f19275b = priorityTaskManager;
        this.f19276c = i10;
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public v a() {
        return new v(this.f19274a.a(), this.f19275b, this.f19276c);
    }
}
