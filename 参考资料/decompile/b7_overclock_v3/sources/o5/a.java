package o5;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.u0;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.g0;
import com.blankj.utilcode.util.i0;
import com.flydigi.base.R;
import g.d0;
import g.n0;
import g.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42717a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42718b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42719c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42720d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42721e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42722f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42723g = 64;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f42724h = "args_id";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f42725i = "args_is_hide";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f42726j = "args_is_add_stack";

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f42727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f42728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f42729c;

        public b(int i10, boolean z10, boolean z11) {
            this.f42727a = i10;
            this.f42728b = z10;
            this.f42729c = z11;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Fragment f42730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<c> f42731b;

        public c(Fragment fragment, List<c> list) {
            this.f42730a = fragment;
            this.f42731b = list;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f42730a.getClass().getSimpleName());
            sb2.append("->");
            List<c> list = this.f42731b;
            sb2.append((list == null || list.isEmpty()) ? "no child" : this.f42731b.toString());
            return sb2.toString();
        }
    }

    public interface d {
        boolean a();
    }

    public a() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(Fragment fragment) {
        return fragment == null ? i0.f11859x : fragment.getClass().getSimpleName();
    }

    public static Fragment B(@n0 FragmentManager fragmentManager) {
        return D(fragmentManager, false);
    }

    public static Fragment C(@n0 FragmentManager fragmentManager) {
        return D(fragmentManager, true);
    }

    public static Fragment D(@n0 FragmentManager fragmentManager, boolean z10) {
        List<Fragment> listY = y(fragmentManager);
        for (int size = listY.size() - 1; size >= 0; size--) {
            Fragment fragment = listY.get(size);
            if (fragment != null && (!z10 || fragment.T1().getBoolean("args_is_add_stack"))) {
                return fragment;
            }
        }
        return null;
    }

    public static Fragment E(@n0 FragmentManager fragmentManager) {
        return G(fragmentManager, false);
    }

    public static Fragment F(@n0 FragmentManager fragmentManager) {
        return G(fragmentManager, true);
    }

    public static Fragment G(@n0 FragmentManager fragmentManager, boolean z10) {
        List<Fragment> listY = y(fragmentManager);
        for (int size = listY.size() - 1; size >= 0; size--) {
            Fragment fragment = listY.get(size);
            if (fragment != null && fragment.A3() && fragment.C3() && fragment.j3() && (!z10 || fragment.T1().getBoolean("args_is_add_stack"))) {
                return fragment;
            }
        }
        return null;
    }

    public static void H(@n0 Fragment fragment) {
        S(fragment, true);
        K(fragment.t2(), 4, null, fragment);
    }

    public static void I(@n0 FragmentManager fragmentManager) {
        List<Fragment> listY = y(fragmentManager);
        Iterator<Fragment> it2 = listY.iterator();
        while (it2.hasNext()) {
            S(it2.next(), true);
        }
        K(fragmentManager, 4, null, (Fragment[]) listY.toArray(new Fragment[listY.size()]));
    }

    public static void J(int i10, FragmentManager fragmentManager, g0 g0Var, Fragment fragment, Fragment... fragmentArr) {
        if (fragment != null && fragment.z3()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fragment.getClass().getName());
            sb2.append(" is isRemoving");
            return;
        }
        int i11 = 0;
        if (i10 == 1) {
            int length = fragmentArr.length;
            while (i11 < length) {
                Fragment fragment2 = fragmentArr[i11];
                String name = fragment2.getClass().getName();
                Bundle bundleT1 = fragment2.T1();
                Fragment fragmentS0 = fragmentManager.s0(name);
                if (fragmentS0 != null && fragmentS0.s3()) {
                    g0Var.B(fragmentS0);
                }
                g0Var.g(bundleT1.getInt("args_id"), fragment2, name);
                if (bundleT1.getBoolean("args_is_hide")) {
                    g0Var.y(fragment2);
                }
                if (bundleT1.getBoolean("args_is_add_stack")) {
                    g0Var.o(name);
                }
                i11++;
            }
        } else if (i10 == 2) {
            int length2 = fragmentArr.length;
            while (i11 < length2) {
                g0Var.T(fragmentArr[i11]);
                i11++;
            }
        } else if (i10 == 4) {
            int length3 = fragmentArr.length;
            while (i11 < length3) {
                g0Var.y(fragmentArr[i11]);
                i11++;
            }
        } else if (i10 == 8) {
            g0Var.T(fragment);
            int length4 = fragmentArr.length;
            while (i11 < length4) {
                Fragment fragment3 = fragmentArr[i11];
                if (fragment3 != fragment) {
                    g0Var.y(fragment3);
                }
                i11++;
            }
        } else if (i10 == 16) {
            String name2 = fragmentArr[0].getClass().getName();
            Bundle bundleT12 = fragmentArr[0].T1();
            g0Var.D(bundleT12.getInt("args_id"), fragmentArr[0], name2);
            if (bundleT12.getBoolean("args_is_add_stack")) {
                g0Var.o(name2);
            }
        } else if (i10 == 32) {
            int length5 = fragmentArr.length;
            while (i11 < length5) {
                Fragment fragment4 = fragmentArr[i11];
                if (fragment4 != fragment) {
                    g0Var.B(fragment4);
                }
                i11++;
            }
        } else if (i10 == 64) {
            int length6 = fragmentArr.length - 1;
            while (true) {
                if (length6 < 0) {
                    break;
                }
                Fragment fragment5 = fragmentArr[length6];
                if (fragment5 != fragmentArr[0]) {
                    g0Var.B(fragment5);
                    length6--;
                } else if (fragment != null) {
                    g0Var.B(fragment5);
                }
            }
        }
        g0Var.r();
    }

    public static void K(FragmentManager fragmentManager, int i10, Fragment fragment, Fragment... fragmentArr) {
        J(i10, fragmentManager, fragmentManager.u(), fragment, fragmentArr);
    }

    public static void L(@n0 FragmentManager fragmentManager) {
        M(fragmentManager, true);
    }

    public static void M(@n0 FragmentManager fragmentManager, boolean z10) {
        if (z10) {
            fragmentManager.v1();
        } else {
            fragmentManager.r1();
        }
    }

    public static void N(@n0 FragmentManager fragmentManager) {
        O(fragmentManager, true);
    }

    public static void O(@n0 FragmentManager fragmentManager, boolean z10) {
        while (fragmentManager.B0() > 0) {
            if (z10) {
                fragmentManager.v1();
            } else {
                fragmentManager.r1();
            }
        }
    }

    public static void P(@n0 FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z10) {
        Q(fragmentManager, cls, z10, true);
    }

    public static void Q(@n0 FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z10, boolean z11) {
        if (z11) {
            fragmentManager.x1(cls.getName(), z10 ? 1 : 0);
        } else {
            fragmentManager.u1(cls.getName(), z10 ? 1 : 0);
        }
    }

    public static void R(Fragment fragment, b bVar) {
        Bundle bundleT1 = fragment.T1();
        if (bundleT1 == null) {
            bundleT1 = new Bundle();
            fragment.c5(bundleT1);
        }
        bundleT1.putInt("args_id", bVar.f42727a);
        bundleT1.putBoolean("args_is_hide", bVar.f42728b);
        bundleT1.putBoolean("args_is_add_stack", bVar.f42729c);
    }

    public static void S(Fragment fragment, boolean z10) {
        Bundle bundleT1 = fragment.T1();
        if (bundleT1 == null) {
            bundleT1 = new Bundle();
            fragment.c5(bundleT1);
        }
        bundleT1.putBoolean("args_is_hide", z10);
    }

    public static void T(@n0 Fragment fragment) {
        K(fragment.t2(), 32, null, fragment);
    }

    public static void U(@n0 FragmentManager fragmentManager) {
        List<Fragment> listY = y(fragmentManager);
        K(fragmentManager, 32, null, (Fragment[]) listY.toArray(new Fragment[listY.size()]));
    }

    public static void V(@n0 Fragment fragment, boolean z10) {
        K(fragment.t2(), 64, z10 ? fragment : null, fragment);
    }

    public static void W(@n0 Fragment fragment, @n0 Fragment fragment2) {
        Z(fragment, fragment2, false);
    }

    public static void X(@n0 Fragment fragment, @n0 Fragment fragment2, @g.a int i10, @g.a int i11) {
        b0(fragment, fragment2, false, i10, i11, 0, 0);
    }

    public static void Y(@n0 Fragment fragment, @n0 Fragment fragment2, @g.a int i10, @g.a int i11, @g.a int i12, @g.a int i13) {
        b0(fragment, fragment2, false, i10, i11, i12, i13);
    }

    public static void Z(@n0 Fragment fragment, @n0 Fragment fragment2, boolean z10) {
        h0(fragment.t2(), fragment2, x(fragment).f42727a, z10);
    }

    public static void a(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10) {
        g(fragmentManager, fragment, i10, false, false);
    }

    public static void a0(@n0 Fragment fragment, @n0 Fragment fragment2, boolean z10, @g.a int i10, @g.a int i11) {
        b0(fragment, fragment2, z10, i10, i11, 0, 0);
    }

    public static void b(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, @g.a int i11, @g.a int i12) {
        f(fragmentManager, fragment, i10, false, i11, i12, 0, 0);
    }

    public static void b0(@n0 Fragment fragment, @n0 Fragment fragment2, boolean z10, @g.a int i10, @g.a int i11, @g.a int i12, @g.a int i13) {
        j0(fragment.t2(), fragment2, x(fragment).f42727a, z10, i10, i11, i12, i13);
    }

    public static void c(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, @g.a int i11, @g.a int i12, @g.a int i13, @g.a int i14) {
        f(fragmentManager, fragment, i10, false, i11, i12, i13, i14);
    }

    public static void c0(@n0 Fragment fragment, @n0 Fragment fragment2, boolean z10, View... viewArr) {
        k0(fragment.t2(), fragment2, x(fragment).f42727a, z10, viewArr);
    }

    public static void d(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10) {
        g(fragmentManager, fragment, i10, z10, false);
    }

    public static void d0(@n0 Fragment fragment, @n0 Fragment fragment2, View... viewArr) {
        c0(fragment, fragment2, false, viewArr);
    }

    public static void e(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, @g.a int i11, @g.a int i12) {
        f(fragmentManager, fragment, i10, z10, i11, i12, 0, 0);
    }

    public static void e0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10) {
        h0(fragmentManager, fragment, i10, false);
    }

    public static void f(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, @g.a int i11, @g.a int i12, @g.a int i13, @g.a int i14) {
        g0 g0VarU = fragmentManager.u();
        R(fragment, new b(i10, false, z10));
        l(g0VarU, i11, i12, i13, i14);
        J(1, fragmentManager, g0VarU, null, fragment);
    }

    public static void f0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, @g.a int i11, @g.a int i12) {
        j0(fragmentManager, fragment, i10, false, i11, i12, 0, 0);
    }

    public static void g(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, boolean z11) {
        R(fragment, new b(i10, z10, z11));
        K(fragmentManager, 1, null, fragment);
    }

    public static void g0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, @g.a int i11, @g.a int i12, @g.a int i13, @g.a int i14) {
        j0(fragmentManager, fragment, i10, false, i11, i12, i13, i14);
    }

    public static void h(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, @n0 View... viewArr) {
        g0 g0VarU = fragmentManager.u();
        R(fragment, new b(i10, false, z10));
        n(g0VarU, viewArr);
        J(1, fragmentManager, g0VarU, null, fragment);
    }

    public static void h0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10) {
        g0 g0VarU = fragmentManager.u();
        R(fragment, new b(i10, false, z10));
        J(16, fragmentManager, g0VarU, null, fragment);
    }

    public static void i(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, @n0 View... viewArr) {
        h(fragmentManager, fragment, i10, false, viewArr);
    }

    public static void i0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, @g.a int i11, @g.a int i12) {
        j0(fragmentManager, fragment, i10, z10, i11, i12, 0, 0);
    }

    public static void j(@n0 FragmentManager fragmentManager, @n0 List<Fragment> list, @d0 int i10, int i11) {
        k(fragmentManager, (Fragment[]) list.toArray(new Fragment[list.size()]), i10, i11);
    }

    public static void j0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, @g.a int i11, @g.a int i12, @g.a int i13, @g.a int i14) {
        g0 g0VarU = fragmentManager.u();
        R(fragment, new b(i10, false, z10));
        l(g0VarU, i11, i12, i13, i14);
        J(16, fragmentManager, g0VarU, null, fragment);
    }

    public static void k(@n0 FragmentManager fragmentManager, @n0 Fragment[] fragmentArr, @d0 int i10, int i11) {
        int length = fragmentArr.length;
        boolean z10 = false;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i12 >= length) {
                K(fragmentManager, 1, null, fragmentArr);
                return;
            }
            Fragment fragment = fragmentArr[i12];
            if (i11 == i12) {
                z11 = false;
            }
            R(fragment, new b(i10, z11, z10));
            i12++;
        }
    }

    public static void k0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, boolean z10, View... viewArr) {
        g0 g0VarU = fragmentManager.u();
        R(fragment, new b(i10, false, z10));
        n(g0VarU, viewArr);
        J(16, fragmentManager, g0VarU, null, fragment);
    }

    public static void l(g0 g0Var, int i10, int i11, int i12, int i13) {
        g0Var.N(i10, i11, i12, i13);
    }

    public static void l0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @d0 int i10, View... viewArr) {
        k0(fragmentManager, fragment, i10, false, viewArr);
    }

    public static void m(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, String str, int i10) {
        fragmentManager.u().g(i10, fragment, str).r();
    }

    public static void m0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, String str, int i10, boolean z10) {
        g0 g0VarU = fragmentManager.u();
        if (z10) {
            g0VarU.N(R.anim.slide_in_bottom, R.anim.abc_fade_out, R.anim.abc_fade_in, R.anim.slide_out_bottom).D(i10, fragment, str).o(str).r();
        } else {
            g0VarU.N(R.anim.open_enter, R.anim.open_exit, R.anim.close_enter, R.anim.close_exit).D(i10, fragment, str).r();
        }
    }

    public static void n(g0 g0Var, View... viewArr) {
        for (View view : viewArr) {
            g0Var.n(view, view.getTransitionName());
        }
    }

    public static void n0(@n0 Fragment fragment, Drawable drawable) {
        u0.I1(fragment.k3(), drawable);
    }

    public static void o(FragmentManager fragmentManager, DialogFragment dialogFragment) {
        if (dialogFragment == null || !dialogFragment.s3() || fragmentManager.V0() || dialogFragment.B3() || fragmentManager.d1()) {
            return;
        }
        dialogFragment.I5();
    }

    public static void o0(@n0 Fragment fragment, @g.l int i10) {
        View viewK3 = fragment.k3();
        if (viewK3 != null) {
            viewK3.setBackgroundColor(i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean p(@n0 Fragment fragment) {
        return fragment.A3() && fragment.C3() && fragment.j3() && (fragment instanceof d) && ((d) fragment).a();
    }

    public static void p0(@n0 Fragment fragment, @v int i10) {
        View viewK3 = fragment.k3();
        if (viewK3 != null) {
            viewK3.setBackgroundResource(i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean q(@n0 FragmentManager fragmentManager) {
        List<Fragment> listY = y(fragmentManager);
        if (listY != null && !listY.isEmpty()) {
            for (int size = listY.size() - 1; size >= 0; size--) {
                Fragment fragment = listY.get(size);
                if (fragment != 0 && fragment.A3() && fragment.C3() && fragment.j3() && (fragment instanceof d) && ((d) fragment).a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void q0(@n0 Fragment fragment) {
        S(fragment, false);
        K(fragment.t2(), 2, null, fragment);
    }

    public static Fragment r(@n0 FragmentManager fragmentManager, int i10) {
        return fragmentManager.r0(i10);
    }

    public static void r0(@n0 FragmentManager fragmentManager) {
        List<Fragment> listY = y(fragmentManager);
        Iterator<Fragment> it2 = listY.iterator();
        while (it2.hasNext()) {
            S(it2.next(), false);
        }
        K(fragmentManager, 2, null, (Fragment[]) listY.toArray(new Fragment[listY.size()]));
    }

    public static Fragment s(@n0 FragmentManager fragmentManager, Class<? extends Fragment> cls) {
        return fragmentManager.s0(cls.getName());
    }

    public static void s0(@n0 FragmentManager fragmentManager, @n0 Fragment fragment) {
        S(fragment, false);
        K(fragmentManager, 2, null, fragment);
    }

    public static List<c> t(@n0 FragmentManager fragmentManager) {
        return u(fragmentManager, new ArrayList());
    }

    public static void t0(@n0 FragmentManager fragmentManager, @n0 DialogFragment dialogFragment) {
        if (fragmentManager.V0() || dialogFragment.B3() || fragmentManager.d1()) {
            return;
        }
        Fragment fragmentS0 = fragmentManager.s0(dialogFragment.getClass().getName());
        if (fragmentS0 != null) {
            com.blankj.utilcode.util.d0.c0(fragmentS0);
        }
        if (dialogFragment.s3()) {
            return;
        }
        dialogFragment.Z5(fragmentManager, dialogFragment.getClass().getName());
    }

    public static List<c> u(@n0 FragmentManager fragmentManager, List<c> list) {
        List<Fragment> listY = y(fragmentManager);
        for (int size = listY.size() - 1; size >= 0; size--) {
            Fragment fragment = listY.get(size);
            if (fragment != null) {
                list.add(new c(fragment, u(fragment.U1(), new ArrayList())));
            }
        }
        return list;
    }

    public static void u0(int i10, @n0 List<Fragment> list) {
        x0(list.get(i10), list);
    }

    public static List<c> v(@n0 FragmentManager fragmentManager) {
        return w(fragmentManager, new ArrayList());
    }

    public static void v0(int i10, @n0 Fragment... fragmentArr) {
        y0(fragmentArr[i10], fragmentArr);
    }

    public static List<c> w(@n0 FragmentManager fragmentManager, List<c> list) {
        List<Fragment> listY = y(fragmentManager);
        for (int size = listY.size() - 1; size >= 0; size--) {
            Fragment fragment = listY.get(size);
            if (fragment != null && fragment.T1().getBoolean("args_is_add_stack")) {
                list.add(new c(fragment, w(fragment.U1(), new ArrayList())));
            }
        }
        return list;
    }

    public static void w0(@n0 Fragment fragment, @n0 Fragment fragment2) {
        S(fragment, false);
        S(fragment2, true);
        K(fragment.t2(), 8, fragment, fragment2);
    }

    public static b x(Fragment fragment) {
        Bundle bundleT1 = fragment.T1();
        return new b(bundleT1.getInt("args_id", fragment.v2()), bundleT1.getBoolean("args_is_hide"), bundleT1.getBoolean("args_is_add_stack"));
    }

    public static void x0(@n0 Fragment fragment, @n0 List<Fragment> list) {
        Iterator<Fragment> it2 = list.iterator();
        while (it2.hasNext()) {
            Fragment next = it2.next();
            S(next, next != fragment);
        }
        K(fragment.t2(), 8, fragment, (Fragment[]) list.toArray(new Fragment[list.size()]));
    }

    public static List<Fragment> y(@n0 FragmentManager fragmentManager) {
        List<Fragment> listI0 = fragmentManager.I0();
        return (listI0 == null || listI0.isEmpty()) ? Collections.emptyList() : listI0;
    }

    public static void y0(@n0 Fragment fragment, @n0 Fragment... fragmentArr) {
        int length = fragmentArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Fragment fragment2 = fragmentArr[i10];
            S(fragment2, fragment2 != fragment);
        }
        K(fragment.t2(), 8, fragment, fragmentArr);
    }

    public static List<Fragment> z(@n0 FragmentManager fragmentManager) {
        List<Fragment> listY = y(fragmentManager);
        ArrayList arrayList = new ArrayList();
        for (Fragment fragment : listY) {
            if (fragment != null && fragment.T1().getBoolean("args_is_add_stack")) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }
}
