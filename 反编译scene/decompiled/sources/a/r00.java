package a;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r00 implements SwipeDismissBehavior.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f7257a;

    public r00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f7257a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
    public void a(int i) {
        if (i == 0) {
            b10.c().k(this.f7257a.f4656a);
        } else if (i == 1 || i == 2) {
            b10.c().j(this.f7257a.f4656a);
        }
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
    public void b(View view) {
        view.setVisibility(8);
        this.f7257a.t(0);
    }
}
