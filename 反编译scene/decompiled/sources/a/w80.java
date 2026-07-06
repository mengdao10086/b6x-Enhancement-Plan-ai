package a;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b90 f7765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f3412a;

    public w80(b90 b90Var, AbsListView absListView) {
        this.f7765a = b90Var;
        this.f3412a = absListView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b90 b90Var = this.f7765a;
        AbsListView absListView = this.f3412a;
        f92.c(absListView, "absListView");
        b90Var.H1(absListView);
    }
}
