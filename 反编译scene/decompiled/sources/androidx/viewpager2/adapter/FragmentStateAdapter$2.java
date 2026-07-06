package androidx.viewpager2.adapter;

import a.eh;
import a.hn;
import a.in;
import a.kn;
import a.mu;
import a.nu;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FragmentStateAdapter$2 implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mu f8261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nu f4498a;

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        if (this.f8261a.y()) {
            return;
        }
        knVar.getLifecycle().c(this);
        if (eh.P(this.f4498a.M())) {
            this.f8261a.x(this.f4498a);
        }
    }
}
