package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class th1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ uh1 f3030a;

    public th1(uh1 uh1Var, p80.b bVar) {
        this.f3030a = uh1Var;
        this.f7502a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7502a.c();
        this.f3030a.f7598a.n();
    }
}
