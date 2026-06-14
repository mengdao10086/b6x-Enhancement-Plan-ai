package a;

import a.i4;
import a.k3;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n3 extends k3 implements i4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i4 f6868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k3.a f1993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionBarContextView f1995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<View> f1996a;
    public boolean c;

    public n3(Context context, ActionBarContextView actionBarContextView, k3.a aVar, boolean z) {
        this.f1994a = context;
        this.f1995a = actionBarContextView;
        this.f1993a = aVar;
        i4 i4Var = new i4(actionBarContextView.getContext());
        i4Var.S(1);
        this.f6868a = i4Var;
        i4Var.R(this);
    }

    @Override // a.i4.a
    public void a(i4 i4Var) {
        k();
        this.f1995a.l();
    }

    @Override // a.i4.a
    public boolean b(i4 i4Var, MenuItem menuItem) {
        return this.f1993a.a(this, menuItem);
    }

    @Override // a.k3
    public void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f1995a.sendAccessibilityEvent(32);
        this.f1993a.c(this);
    }

    @Override // a.k3
    public View d() {
        WeakReference<View> weakReference = this.f1996a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.k3
    public Menu e() {
        return this.f6868a;
    }

    @Override // a.k3
    public MenuInflater f() {
        return new s3(this.f1995a.getContext());
    }

    @Override // a.k3
    public CharSequence g() {
        return this.f1995a.getSubtitle();
    }

    @Override // a.k3
    public CharSequence i() {
        return this.f1995a.getTitle();
    }

    @Override // a.k3
    public void k() {
        this.f1993a.d(this, this.f6868a);
    }

    @Override // a.k3
    public boolean l() {
        return this.f1995a.j();
    }

    @Override // a.k3
    public void m(View view) {
        this.f1995a.setCustomView(view);
        this.f1996a = view != null ? new WeakReference<>(view) : null;
    }

    @Override // a.k3
    public void n(int i) {
        o(this.f1994a.getString(i));
    }

    @Override // a.k3
    public void o(CharSequence charSequence) {
        this.f1995a.setSubtitle(charSequence);
    }

    @Override // a.k3
    public void q(int i) {
        r(this.f1994a.getString(i));
    }

    @Override // a.k3
    public void r(CharSequence charSequence) {
        this.f1995a.setTitle(charSequence);
    }

    @Override // a.k3
    public void s(boolean z) {
        super.s(z);
        this.f1995a.setTitleOptional(z);
    }
}
