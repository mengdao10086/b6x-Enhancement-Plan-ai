package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j5 extends l7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k5 f6474a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j5(k5 k5Var, View view, n5 n5Var) {
        super(view);
        this.f6474a = k5Var;
    }

    @Override // a.l7
    public y4 b() {
        l5 l5Var = this.f6474a.f6574a.f2010a;
        if (l5Var == null) {
            return null;
        }
        return l5Var.c();
    }

    @Override // a.l7
    public boolean c() {
        this.f6474a.f6574a.K();
        return true;
    }

    @Override // a.l7
    public boolean d() {
        n5 n5Var = this.f6474a.f6574a;
        if (n5Var.f2008a != null) {
            return false;
        }
        n5Var.B();
        return true;
    }
}
