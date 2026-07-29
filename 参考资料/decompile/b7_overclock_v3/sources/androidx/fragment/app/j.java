package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.d1;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<?> f5982a;

    public j(l<?> lVar) {
        this.f5982a = lVar;
    }

    @g.n0
    public static j b(@g.n0 l<?> lVar) {
        return new j((l) androidx.core.util.o.m(lVar, "callbacks == null"));
    }

    @p0
    public Fragment A(@g.n0 String str) {
        return this.f5982a.f6010e.t0(str);
    }

    @g.n0
    public List<Fragment> B(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.f5982a.f6010e.z0();
    }

    public int C() {
        return this.f5982a.f6010e.y0();
    }

    @g.n0
    public FragmentManager D() {
        return this.f5982a.f6010e;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public q1.a E() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void F() {
        this.f5982a.f6010e.n1();
    }

    @p0
    public View G(@p0 View view, @g.n0 String str, @g.n0 Context context, @g.n0 AttributeSet attributeSet) {
        return this.f5982a.f6010e.K0().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void H() {
    }

    @Deprecated
    public void I(@p0 Parcelable parcelable, @p0 x xVar) {
        this.f5982a.f6010e.I1(parcelable, xVar);
    }

    @Deprecated
    public void J(@p0 Parcelable parcelable, @p0 List<Fragment> list) {
        this.f5982a.f6010e.I1(parcelable, new x(list, null, null));
    }

    @Deprecated
    public void K(@SuppressLint({"UnknownNullness"}) androidx.collection.l<String, q1.a> lVar) {
    }

    @Deprecated
    public void L(@p0 Parcelable parcelable) {
        l<?> lVar = this.f5982a;
        if (!(lVar instanceof d1)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        lVar.f6010e.L1(parcelable);
    }

    @p0
    @Deprecated
    public androidx.collection.l<String, q1.a> M() {
        return null;
    }

    @p0
    @Deprecated
    public x N() {
        return this.f5982a.f6010e.N1();
    }

    @p0
    @Deprecated
    public List<Fragment> O() {
        x xVarN1 = this.f5982a.f6010e.N1();
        if (xVarN1 == null || xVarN1.b() == null) {
            return null;
        }
        return new ArrayList(xVarN1.b());
    }

    @p0
    @Deprecated
    public Parcelable P() {
        return this.f5982a.f6010e.P1();
    }

    public void a(@p0 Fragment fragment) {
        l<?> lVar = this.f5982a;
        lVar.f6010e.s(lVar, lVar, fragment);
    }

    public void c() {
        this.f5982a.f6010e.F();
    }

    @Deprecated
    public void d(@g.n0 Configuration configuration) {
        this.f5982a.f6010e.H(configuration, true);
    }

    public boolean e(@g.n0 MenuItem menuItem) {
        return this.f5982a.f6010e.I(menuItem);
    }

    public void f() {
        this.f5982a.f6010e.J();
    }

    @Deprecated
    public boolean g(@g.n0 Menu menu, @g.n0 MenuInflater menuInflater) {
        return this.f5982a.f6010e.K(menu, menuInflater);
    }

    public void h() {
        this.f5982a.f6010e.L();
    }

    public void i() {
        this.f5982a.f6010e.M();
    }

    @Deprecated
    public void j() {
        this.f5982a.f6010e.N(true);
    }

    @Deprecated
    public void k(boolean z10) {
        this.f5982a.f6010e.O(z10, true);
    }

    @Deprecated
    public boolean l(@g.n0 MenuItem menuItem) {
        return this.f5982a.f6010e.R(menuItem);
    }

    @Deprecated
    public void m(@g.n0 Menu menu) {
        this.f5982a.f6010e.S(menu);
    }

    public void n() {
        this.f5982a.f6010e.U();
    }

    @Deprecated
    public void o(boolean z10) {
        this.f5982a.f6010e.V(z10, true);
    }

    @Deprecated
    public boolean p(@g.n0 Menu menu) {
        return this.f5982a.f6010e.W(menu);
    }

    @Deprecated
    public void q() {
    }

    public void r() {
        this.f5982a.f6010e.Y();
    }

    public void s() {
        this.f5982a.f6010e.Z();
    }

    public void t() {
        this.f5982a.f6010e.b0();
    }

    @Deprecated
    public void u() {
    }

    @Deprecated
    public void v() {
    }

    @Deprecated
    public void w() {
    }

    @Deprecated
    public void x(boolean z10) {
    }

    @Deprecated
    public void y(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
    }

    public boolean z() {
        return this.f5982a.f6010e.j0(true);
    }
}
