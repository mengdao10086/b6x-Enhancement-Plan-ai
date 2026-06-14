package a;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h90 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l90 f6288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f1140a;

    public h90(l90 l90Var, AbsListView absListView) {
        this.f6288a = l90Var;
        this.f1140a = absListView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l90 l90Var = this.f6288a;
        AbsListView absListView = this.f1140a;
        f92.c(absListView, "absListView");
        l90Var.i(absListView);
    }
}
