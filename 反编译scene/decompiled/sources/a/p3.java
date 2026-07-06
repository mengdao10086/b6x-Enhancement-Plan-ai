package a;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p3 extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k3 f7078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2381a;

    public p3(Context context, k3 k3Var) {
        this.f2381a = context;
        this.f7078a = k3Var;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f7078a.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f7078a.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new x4(this.f2381a, (qd) this.f7078a.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f7078a.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f7078a.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f7078a.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f7078a.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f7078a.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f7078a.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f7078a.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f7078a.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f7078a.n(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f7078a.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f7078a.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f7078a.q(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f7078a.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f7078a.s(z);
    }
}
