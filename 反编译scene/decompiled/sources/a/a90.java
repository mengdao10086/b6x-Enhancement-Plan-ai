package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a90 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b90 f5582a;

    public a90(b90 b90Var) {
        this.f5582a = b90Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        View viewM = this.f5582a.M();
        f92.b(viewM);
        View viewFindViewById = viewM.findViewById(x20.btn_cancel);
        View viewM2 = this.f5582a.M();
        f92.b(viewM2);
        View viewFindViewById2 = viewM2.findViewById(x20.btn_confirm);
        if (this.f5582a.z) {
            i = 0;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            if (viewFindViewById2 == null) {
                return;
            }
        } else {
            i = 8;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            if (viewFindViewById2 == null) {
                return;
            }
        }
        viewFindViewById2.setVisibility(i);
    }
}
