package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a1 implements ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f5556a;

    public a1(w1 w1Var) {
        this.f5556a = w1Var;
    }

    @Override // a.ng
    public sh a(View view, sh shVar) {
        int i = shVar.i();
        int iQ0 = this.f5556a.Q0(shVar, null);
        if (i != iQ0) {
            shVar = shVar.m(shVar.g(), iQ0, shVar.h(), shVar.f());
        }
        return eh.X(view, shVar);
    }
}
