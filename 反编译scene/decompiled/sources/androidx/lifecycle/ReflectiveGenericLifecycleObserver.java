package androidx.lifecycle;

import a.dn;
import a.hn;
import a.in;
import a.kn;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ReflectiveGenericLifecycleObserver implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dn.a f8209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f4288a;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f4288a = obj;
        this.f8209a = dn.f5917a.c(obj.getClass());
    }

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        this.f8209a.a(knVar, aVar, this.f4288a);
    }
}
