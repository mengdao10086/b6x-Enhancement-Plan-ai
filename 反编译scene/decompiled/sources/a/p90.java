package a;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p90 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r90 f7097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f2408a;

    public p90(r90 r90Var, AbsListView absListView) {
        this.f7097a = r90Var;
        this.f2408a = absListView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        r90 r90Var = this.f7097a;
        AbsListView absListView = this.f2408a;
        f92.c(absListView, "absListView");
        r90Var.E1(absListView);
    }
}
