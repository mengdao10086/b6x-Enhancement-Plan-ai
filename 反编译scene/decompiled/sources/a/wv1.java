package a;

import com.omarea.Scene;
import com.omarea.model.ActivatedStateModel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wv1 implements ol1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f7827a;

    public wv1(bx1 bx1Var) {
        this.f7827a = bx1Var;
    }

    @Override // a.ol1
    public void a() {
        this.f7827a.f307a.g();
        cl clVarJ = this.f7827a.j();
        if (clVarJ != null) {
            clVarJ.finish();
        }
    }

    @Override // a.ol1
    public void b(String str, String str2) {
        f92.d(str, "code");
        f92.d(str2, "type");
        this.f7827a.f307a.g();
        ActivatedStateModel activatedStateModel = this.f7827a.f309a;
        if (activatedStateModel != null && activatedStateModel.getActivated()) {
            this.f7827a.Z1();
            return;
        }
        Scene.c cVar = Scene.f4798a;
        String strJ = this.f7827a.J(u61.user_activation_complete);
        f92.c(strJ, "getString(R.string.user_activation_complete)");
        Scene.c.p(cVar, strJ, 0, 2, null);
        cl clVarJ = this.f7827a.j();
        if (clVarJ != null) {
            clVarJ.finish();
        }
    }
}
