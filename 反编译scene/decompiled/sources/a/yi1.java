package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yi1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f3719a;

    public yi1(pj1 pj1Var, boolean z, p80.b bVar) {
        this.f3719a = pj1Var;
        this.f7987a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7987a.c();
        this.f3719a.F();
    }
}
