package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s9 implements w9 {
    @Override // a.w9
    public void a(v9 v9Var, float f) {
        o(v9Var).h(f);
    }

    @Override // a.w9
    public void b(v9 v9Var, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        v9Var.f(new x9(colorStateList, f));
        View viewG = v9Var.g();
        viewG.setClipToOutline(true);
        viewG.setElevation(f2);
        g(v9Var, f3);
    }

    @Override // a.w9
    public void c() {
    }

    @Override // a.w9
    public float d(v9 v9Var) {
        return o(v9Var).d();
    }

    @Override // a.w9
    public void e(v9 v9Var) {
        g(v9Var, m(v9Var));
    }

    @Override // a.w9
    public void f(v9 v9Var, ColorStateList colorStateList) {
        o(v9Var).f(colorStateList);
    }

    @Override // a.w9
    public void g(v9 v9Var, float f) {
        o(v9Var).g(f, v9Var.d(), v9Var.c());
        p(v9Var);
    }

    @Override // a.w9
    public float h(v9 v9Var) {
        return d(v9Var) * 2.0f;
    }

    @Override // a.w9
    public float i(v9 v9Var) {
        return v9Var.g().getElevation();
    }

    @Override // a.w9
    public ColorStateList j(v9 v9Var) {
        return o(v9Var).b();
    }

    @Override // a.w9
    public void k(v9 v9Var) {
        g(v9Var, m(v9Var));
    }

    @Override // a.w9
    public float l(v9 v9Var) {
        return d(v9Var) * 2.0f;
    }

    @Override // a.w9
    public float m(v9 v9Var) {
        return o(v9Var).c();
    }

    @Override // a.w9
    public void n(v9 v9Var, float f) {
        v9Var.g().setElevation(f);
    }

    public final x9 o(v9 v9Var) {
        return (x9) v9Var.b();
    }

    public void p(v9 v9Var) {
        if (!v9Var.d()) {
            v9Var.a(0, 0, 0, 0);
            return;
        }
        float fM = m(v9Var);
        float fD = d(v9Var);
        int iCeil = (int) Math.ceil(z9.c(fM, fD, v9Var.c()));
        int iCeil2 = (int) Math.ceil(z9.d(fM, fD, v9Var.c()));
        v9Var.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
