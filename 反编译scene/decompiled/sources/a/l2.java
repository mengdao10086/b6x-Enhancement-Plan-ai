package a;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l2 extends nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f6666a;

    public l2(p2 p2Var) {
        this.f6666a = p2Var;
    }

    @Override // a.mh
    public void a(View view) {
        View view2;
        p2 p2Var = this.f6666a;
        if (p2Var.d && (view2 = p2Var.f2366a) != null) {
            view2.setTranslationY(0.0f);
            this.f6666a.f2367a.setTranslationY(0.0f);
        }
        this.f6666a.f2367a.setVisibility(8);
        this.f6666a.f2367a.setTransitioning(false);
        p2 p2Var2 = this.f6666a;
        p2Var2.f2364a = null;
        p2Var2.z();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6666a.f2369a;
        if (actionBarOverlayLayout != null) {
            eh.h0(actionBarOverlayLayout);
        }
    }
}
