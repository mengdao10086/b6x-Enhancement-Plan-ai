package a;

import a.w01;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w01.a f7937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w01 f3643a;

    public y01(w01 w01Var, w01.a aVar) {
        this.f3643a = w01Var;
        this.f7937a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v01 v01Var = this.f3643a.b;
        if (v01Var != null) {
            f92.c(view, "it");
            v01Var.a(view, this.f7937a.j());
        }
    }
}
