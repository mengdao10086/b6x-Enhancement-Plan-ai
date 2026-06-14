package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ij1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f1376a;

    public ij1(pj1 pj1Var, p80.b bVar) {
        this.f1376a = pj1Var;
        this.f6420a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6420a.c();
        this.f1376a.J();
    }
}
