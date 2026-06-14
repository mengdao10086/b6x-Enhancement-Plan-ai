package a;

import a.gy;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ey implements ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gy.a f6052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ hy f816a;

    public ey(gy.a aVar, hy hyVar) {
        this.f6052a = aVar;
        this.f816a = hyVar;
    }

    @Override // a.ng
    public sh a(View view, sh shVar) {
        this.f6052a.a(view, shVar, new hy(this.f816a));
        return shVar;
    }
}
