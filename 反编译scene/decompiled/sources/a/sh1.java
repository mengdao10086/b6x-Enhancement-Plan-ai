package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sh1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ uh1 f2896a;

    public sh1(uh1 uh1Var, p80.b bVar) {
        this.f2896a = uh1Var;
        this.f7399a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7399a.c();
        this.f2896a.f7598a.o();
        this.f2896a.f7598a.n();
    }
}
