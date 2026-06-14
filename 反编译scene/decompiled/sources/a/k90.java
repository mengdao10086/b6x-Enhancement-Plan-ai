package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class k90 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l90 f6585a;

    public k90(l90 l90Var) {
        this.f6585a = l90Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        View view;
        if (this.f6585a.f1778a) {
            View view2 = this.f6585a.b;
            i = 0;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            view = this.f6585a.c;
            if (view == null) {
                return;
            }
        } else {
            View view3 = this.f6585a.b;
            i = 8;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            view = this.f6585a.c;
            if (view == null) {
                return;
            }
        }
        view.setVisibility(i);
    }
}
