package a;

import a.w01;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w01.a f7840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w01 f3505a;

    public x01(w01 w01Var, w01.a aVar) {
        this.f3505a = w01Var;
        this.f7840a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v01 v01Var = this.f3505a.f7739a;
        if (v01Var != null) {
            f92.c(view, "it");
            v01Var.a(view, this.f7840a.j());
        }
    }
}
