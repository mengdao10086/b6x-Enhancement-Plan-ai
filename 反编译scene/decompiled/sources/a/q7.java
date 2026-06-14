package a;

import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q7 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t7 f7183a;

    public q7(t7 t7Var) {
        this.f7183a = t7Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 1 || this.f7183a.A() || this.f7183a.f2987a.getContentView() == null) {
            return;
        }
        t7 t7Var = this.f7183a;
        t7Var.f2982a.removeCallbacks(t7Var.f2977a);
        this.f7183a.f2977a.run();
    }
}
