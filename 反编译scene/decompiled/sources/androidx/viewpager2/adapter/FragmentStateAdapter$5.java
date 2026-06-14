package androidx.viewpager2.adapter;

import a.hn;
import a.in;
import a.kn;
import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FragmentStateAdapter$5 implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f8262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f4499a;

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        if (aVar == hn.a.ON_DESTROY) {
            this.f8262a.removeCallbacks(this.f4499a);
            knVar.getLifecycle().c(this);
        }
    }
}
