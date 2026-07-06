package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ik1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1379a;
    public final /* synthetic */ View b;

    public ik1(i92 i92Var, View view, View view2) {
        this.f6423a = i92Var;
        this.f1379a = view;
        this.b = view2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6423a.b = true;
        View view2 = this.f1379a;
        f92.c(view2, "delete");
        view2.setVisibility(8);
        View view3 = this.b;
        f92.c(view3, "deleteConfirm");
        view3.setVisibility(0);
    }
}
