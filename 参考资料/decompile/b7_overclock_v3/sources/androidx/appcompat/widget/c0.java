package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface c0 {
    boolean A();

    int B();

    void C(int i10);

    androidx.core.view.b1 D(int i10, long j10);

    void E(int i10);

    void F(int i10);

    void G(j.a aVar, e.a aVar2);

    ViewGroup H();

    void I(boolean z10);

    void J(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    void K(SparseArray<Parcelable> sparseArray);

    CharSequence L();

    int M();

    int N();

    void O(int i10);

    void P(View view);

    void Q();

    int R();

    void S();

    void T(Drawable drawable);

    void U(boolean z10);

    void a(Menu menu, j.a aVar);

    Context b();

    void c(Drawable drawable);

    void collapseActionView();

    int d();

    boolean e();

    void f();

    boolean g();

    int getHeight();

    CharSequence getTitle();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    boolean l();

    void m(int i10);

    void n();

    View o();

    void p(q0 q0Var);

    void q(Drawable drawable);

    boolean r();

    boolean s();

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setLogo(int i10);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i10);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i10);

    void u(CharSequence charSequence);

    void v(CharSequence charSequence);

    void w(Drawable drawable);

    void x(SparseArray<Parcelable> sparseArray);

    void y(int i10);

    Menu z();
}
