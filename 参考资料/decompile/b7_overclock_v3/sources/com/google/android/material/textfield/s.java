package com.google.android.material.textfield;

import a1.c;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import g.c1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f20995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f20996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f20997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f20998d;

    public s(@n0 r rVar) {
        this.f20995a = rVar.f20967a;
        this.f20996b = rVar;
        this.f20997c = rVar.getContext();
        this.f20998d = rVar.r();
    }

    public void a(Editable editable) {
    }

    public void b(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @c1
    public int c() {
        return 0;
    }

    @g.v
    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public c.e h() {
        return null;
    }

    public boolean i(int i10) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public void n(@p0 EditText editText) {
    }

    public void o(View view, @n0 a1.d dVar) {
    }

    public void p(View view, @n0 AccessibilityEvent accessibilityEvent) {
    }

    public void q(boolean z10) {
    }

    public final void r() {
        this.f20996b.M(false);
    }

    public void s() {
    }

    public boolean t() {
        return false;
    }

    public void u() {
    }
}
