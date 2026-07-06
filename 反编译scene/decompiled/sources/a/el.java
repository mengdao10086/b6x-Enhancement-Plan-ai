package a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gl<?> f6017a;

    public el(gl<?> glVar) {
        this.f6017a = glVar;
    }

    public static el b(gl<?> glVar) {
        pf.c(glVar, "callbacks == null");
        return new el(glVar);
    }

    public void a(Fragment fragment) {
        gl<?> glVar = this.f6017a;
        glVar.f6217a.q(glVar, glVar, fragment);
    }

    public void c() {
        this.f6017a.f6217a.z();
    }

    public void d(Configuration configuration) {
        this.f6017a.f6217a.A(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f6017a.f6217a.B(menuItem);
    }

    public void f() {
        this.f6017a.f6217a.C();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f6017a.f6217a.D(menu, menuInflater);
    }

    public void h() {
        this.f6017a.f6217a.E();
    }

    public void i() {
        this.f6017a.f6217a.G();
    }

    public void j(boolean z) {
        this.f6017a.f6217a.H(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.f6017a.f6217a.W(menuItem);
    }

    public void l(Menu menu) {
        this.f6017a.f6217a.X(menu);
    }

    public void m() {
        this.f6017a.f6217a.Z();
    }

    public void n(boolean z) {
        this.f6017a.f6217a.a0(z);
    }

    public boolean o(Menu menu) {
        return this.f6017a.f6217a.b0(menu);
    }

    public void p() {
        this.f6017a.f6217a.d0();
    }

    public void q() {
        this.f6017a.f6217a.e0();
    }

    public void r() {
        this.f6017a.f6217a.g0();
    }

    public boolean s() {
        return this.f6017a.f6217a.m0();
    }

    public Fragment t(String str) {
        return this.f6017a.f6217a.s0(str);
    }

    public jl u() {
        return this.f6017a.f6217a;
    }

    public void v() {
        this.f6017a.f6217a.T0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f6017a.f6217a.onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        gl<?> glVar = this.f6017a;
        if (!(glVar instanceof yn)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        glVar.f6217a.d1(parcelable);
    }

    public Parcelable y() {
        return this.f6017a.f6217a.f1();
    }
}
