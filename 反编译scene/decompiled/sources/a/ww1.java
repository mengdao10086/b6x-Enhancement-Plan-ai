package a;

import android.view.View;
import android.widget.CompoundButton;
import com.omarea.Scene;
import com.omarea.model.LoginResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ww1 implements qn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xw1 f7830a;

    public ww1(xw1 xw1Var) {
        this.f7830a = xw1Var;
    }

    @Override // a.qn1
    public void a(String str) {
        f92.d(str, "password");
        View viewFindViewById = this.f7830a.f3625a.findViewById(t61.force);
        f92.c(viewFindViewById, "view.findViewById<CompoundButton>(R.id.force)");
        LoginResponse loginResponseO = mp0.O(new mp0(Scene.f4798a.c()), this.f7830a.f3626a, str, ((CompoundButton) viewFindViewById).isChecked(), null, 8, null);
        if (loginResponseO != null) {
            if (loginResponseO.getPass()) {
                this.f7830a.f7925a.f8016a.Y1();
                Scene.c.p(Scene.f4798a, "OK ^_^", 0, 2, null);
                qc2.d(xd2.a(qe2.b()), null, null, new vw1(this, null), 3, null);
            } else {
                Scene.c.p(Scene.f4798a, "@_@: " + loginResponseO.getError(), 0, 2, null);
            }
        }
    }
}
