package a;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d80 f5579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f48a;

    public a80(d80 d80Var, AbsListView absListView) {
        this.f5579a = d80Var;
        this.f48a = absListView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        d80 d80Var = this.f5579a;
        AbsListView absListView = this.f48a;
        f92.c(absListView, "absListView");
        d80Var.F1(absListView);
    }
}
