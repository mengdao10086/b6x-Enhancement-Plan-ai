package a;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i1 extends nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f6364a;

    public i1(j1 j1Var) {
        this.f6364a = j1Var;
    }

    @Override // a.mh
    public void a(View view) {
        this.f6364a.f1489a.f3343a.setVisibility(8);
        w1 w1Var = this.f6364a.f1489a;
        PopupWindow popupWindow = w1Var.f3341a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (w1Var.f3343a.getParent() instanceof View) {
            eh.h0((View) this.f6364a.f1489a.f3343a.getParent());
        }
        this.f6364a.f1489a.f3343a.removeAllViews();
        this.f6364a.f1489a.f3330a.f(null);
        w1 w1Var2 = this.f6364a.f1489a;
        w1Var2.f3330a = null;
        eh.h0(w1Var2.f3339a);
    }
}
