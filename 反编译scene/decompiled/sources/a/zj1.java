package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zj1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ck1 f8076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3852a;

    public zj1(ck1 ck1Var, p80.b bVar) {
        this.f8076a = ck1Var;
        this.f3852a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3852a.c();
        this.f8076a.b(wu0.f3480a.c());
    }
}
