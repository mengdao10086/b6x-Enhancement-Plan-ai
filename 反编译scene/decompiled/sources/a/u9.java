package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u9 implements w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f7576a = new RectF();

    @Override // a.w9
    public void a(v9 v9Var, float f) {
        p(v9Var).p(f);
        q(v9Var);
    }

    @Override // a.w9
    public void b(v9 v9Var, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        z9 z9VarO = o(context, colorStateList, f, f2, f3);
        z9VarO.m(v9Var.c());
        v9Var.f(z9VarO);
        q(v9Var);
    }

    @Override // a.w9
    public void c() {
        z9.f3804a = new t9(this);
    }

    @Override // a.w9
    public float d(v9 v9Var) {
        return p(v9Var).g();
    }

    @Override // a.w9
    public void e(v9 v9Var) {
    }

    @Override // a.w9
    public void f(v9 v9Var, ColorStateList colorStateList) {
        p(v9Var).o(colorStateList);
    }

    @Override // a.w9
    public void g(v9 v9Var, float f) {
        p(v9Var).q(f);
        q(v9Var);
    }

    @Override // a.w9
    public float h(v9 v9Var) {
        return p(v9Var).k();
    }

    @Override // a.w9
    public float i(v9 v9Var) {
        return p(v9Var).l();
    }

    @Override // a.w9
    public ColorStateList j(v9 v9Var) {
        return p(v9Var).f();
    }

    @Override // a.w9
    public void k(v9 v9Var) {
        p(v9Var).m(v9Var.c());
        q(v9Var);
    }

    @Override // a.w9
    public float l(v9 v9Var) {
        return p(v9Var).j();
    }

    @Override // a.w9
    public float m(v9 v9Var) {
        return p(v9Var).i();
    }

    @Override // a.w9
    public void n(v9 v9Var, float f) {
        p(v9Var).r(f);
    }

    public final z9 o(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new z9(context.getResources(), colorStateList, f, f2, f3);
    }

    public final z9 p(v9 v9Var) {
        return (z9) v9Var.b();
    }

    public void q(v9 v9Var) {
        Rect rect = new Rect();
        p(v9Var).h(rect);
        v9Var.e((int) Math.ceil(h(v9Var)), (int) Math.ceil(l(v9Var)));
        v9Var.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
