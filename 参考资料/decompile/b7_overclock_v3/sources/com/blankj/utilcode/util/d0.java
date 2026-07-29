package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11735a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11736b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11737c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11738d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11739e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11740f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11741g = 64;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f11742h = "args_id";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f11743i = "args_is_hide";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f11744j = "args_is_add_stack";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f11745k = "args_tag";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f11747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f11748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f11749d;

        public a(int i10, boolean z10, boolean z11) {
            this(i10, null, z10, z11);
        }

        public a(int i10, String str, boolean z10, boolean z11) {
            this.f11746a = i10;
            this.f11749d = str;
            this.f11747b = z10;
            this.f11748c = z11;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f11750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f11751b;

        public b(Fragment fragment, List<b> list) {
            this.f11750a = fragment;
            this.f11751b = list;
        }

        public Fragment a() {
            return this.f11750a;
        }

        public List<b> b() {
            return this.f11751b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f11750a.getClass().getSimpleName());
            sb2.append("->");
            List<b> list = this.f11751b;
            sb2.append((list == null || list.isEmpty()) ? "no child" : this.f11751b.toString());
            return sb2.toString();
        }
    }

    public interface c {
        boolean a();
    }

    public d0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Fragment A(@g.n0 FragmentManager fragmentManager, Class<? extends Fragment> cls) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return fragmentManager.s0(cls.getName());
    }

    public static void A0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, str, false, i11, i12, i13, i14);
    }

    public static Fragment B(@g.n0 FragmentManager fragmentManager, @g.n0 String str) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'tag' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return fragmentManager.s0(str);
    }

    public static void B0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        androidx.fragment.app.g0 g0VarU = fragmentManager.u();
        a0(fragment, new a(i10, str, false, z10));
        S(16, fragmentManager, g0VarU, null, fragment);
    }

    public static List<b> C(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return D(fragmentManager, new ArrayList());
    }

    public static void C0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, str, z10, i11, i12, 0, 0);
    }

    public static List<b> D(@g.n0 FragmentManager fragmentManager, List<b> list) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment = listH.get(size);
            if (fragment != null) {
                list.add(new b(fragment, D(fragment.U1(), new ArrayList())));
            }
        }
        return list;
    }

    public static void D0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        androidx.fragment.app.g0 g0VarU = fragmentManager.u();
        a0(fragment, new a(i10, str, false, z10));
        w(g0VarU, i11, i12, i13, i14);
        S(16, fragmentManager, g0VarU, null, fragment);
    }

    public static List<b> E(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return F(fragmentManager, new ArrayList());
    }

    public static void E0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        androidx.fragment.app.g0 g0VarU = fragmentManager.u();
        a0(fragment, new a(i10, str, false, z10));
        x(g0VarU, viewArr);
        S(16, fragmentManager, g0VarU, null, fragment);
    }

    public static List<b> F(@g.n0 FragmentManager fragmentManager, List<b> list) {
        Bundle bundleT1;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment = listH.get(size);
            if (fragment != null && (bundleT1 = fragment.T1()) != null && bundleT1.getBoolean("args_is_add_stack")) {
                list.add(new b(fragment, F(fragment.U1(), new ArrayList())));
            }
        }
        return list;
    }

    public static void F0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        E0(fragmentManager, fragment, i10, str, false, viewArr);
    }

    public static a G(Fragment fragment) {
        Bundle bundleT1 = fragment.T1();
        if (bundleT1 == null) {
            bundleT1 = Bundle.EMPTY;
        }
        return new a(bundleT1.getInt("args_id", fragment.v2()), bundleT1.getBoolean("args_is_hide"), bundleT1.getBoolean("args_is_add_stack"));
    }

    public static void G0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B0(fragmentManager, fragment, i10, null, z10);
    }

    public static List<Fragment> H(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listI0 = fragmentManager.I0();
        return (listI0 == null || listI0.isEmpty()) ? Collections.emptyList() : listI0;
    }

    public static void H0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, null, z10, i11, i12, 0, 0);
    }

    public static List<Fragment> I(@g.n0 FragmentManager fragmentManager) {
        Bundle bundleT1;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        ArrayList arrayList = new ArrayList();
        for (Fragment fragment : listH) {
            if (fragment != null && (bundleT1 = fragment.T1()) != null && bundleT1.getBoolean("args_is_add_stack")) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }

    public static void I0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, null, z10, i11, i12, i13, i14);
    }

    public static String J(Fragment fragment) {
        return fragment == null ? i0.f11859x : fragment.getClass().getSimpleName();
    }

    public static void J0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        E0(fragmentManager, fragment, i10, null, z10, viewArr);
    }

    public static Fragment K(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return M(fragmentManager, null, false);
    }

    public static void K0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        E0(fragmentManager, fragment, i10, null, false, viewArr);
    }

    public static Fragment L(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return M(fragmentManager, null, true);
    }

    public static void L0(@g.n0 Fragment fragment, Drawable drawable) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View viewK3 = fragment.k3();
        if (viewK3 == null) {
            return;
        }
        viewK3.setBackground(drawable);
    }

    public static Fragment M(@g.n0 FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment2 = listH.get(size);
            if (fragment2 != null) {
                if (!z10) {
                    return M(fragment2.U1(), fragment2, false);
                }
                Bundle bundleT1 = fragment2.T1();
                if (bundleT1 != null && bundleT1.getBoolean("args_is_add_stack")) {
                    return M(fragment2.U1(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static void M0(@g.n0 Fragment fragment, @g.l int i10) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View viewK3 = fragment.k3();
        if (viewK3 != null) {
            viewK3.setBackgroundColor(i10);
        }
    }

    public static Fragment N(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return P(fragmentManager, null, false);
    }

    public static void N0(@g.n0 Fragment fragment, @g.v int i10) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View viewK3 = fragment.k3();
        if (viewK3 != null) {
            viewK3.setBackgroundResource(i10);
        }
    }

    public static Fragment O(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return P(fragmentManager, null, true);
    }

    public static void O0(@g.n0 Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        b0(fragment, false);
        T(2, fragment.t2(), null, fragment);
    }

    public static Fragment P(@g.n0 FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment2 = listH.get(size);
            if (fragment2 != null && fragment2.A3() && fragment2.C3() && fragment2.j3()) {
                if (!z10) {
                    return P(fragment2.U1(), fragment2, false);
                }
                Bundle bundleT1 = fragment2.T1();
                if (bundleT1 != null && bundleT1.getBoolean("args_is_add_stack")) {
                    return P(fragment2.U1(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static void P0(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        Iterator<Fragment> it2 = listH.iterator();
        while (it2.hasNext()) {
            b0(it2.next(), false);
        }
        T(2, fragmentManager, null, (Fragment[]) listH.toArray(new Fragment[0]));
    }

    public static void Q(@g.n0 Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'hide' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        b0(fragment, true);
        T(4, fragment.t2(), null, fragment);
    }

    public static void Q0(int i10, @g.n0 List<Fragment> list) {
        Objects.requireNonNull(list, "Argument 'fragments' of type List<Fragment> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        V0(list.get(i10), list);
    }

    public static void R(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        Iterator<Fragment> it2 = listH.iterator();
        while (it2.hasNext()) {
            b0(it2.next(), true);
        }
        T(4, fragmentManager, null, (Fragment[]) listH.toArray(new Fragment[0]));
    }

    public static void R0(int i10, @g.n0 List<Fragment> list, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(list, "Argument 'fragments' of type List<Fragment> (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        W0(list.get(i10), list, i11, i12, i13, i14);
    }

    public static void S(int i10, @g.n0 FragmentManager fragmentManager, androidx.fragment.app.g0 g0Var, Fragment fragment, Fragment... fragmentArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
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
                Bundle bundleT1 = fragment2.T1();
                if (bundleT1 == null) {
                    return;
                }
                String string = bundleT1.getString(f11745k, fragment2.getClass().getName());
                Fragment fragmentS0 = fragmentManager.s0(string);
                if (fragmentS0 != null && fragmentS0.s3()) {
                    g0Var.B(fragmentS0);
                }
                g0Var.g(bundleT1.getInt("args_id"), fragment2, string);
                if (bundleT1.getBoolean("args_is_hide")) {
                    g0Var.y(fragment2);
                }
                if (bundleT1.getBoolean("args_is_add_stack")) {
                    g0Var.o(string);
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
            Bundle bundleT12 = fragmentArr[0].T1();
            if (bundleT12 == null) {
                return;
            }
            String string2 = bundleT12.getString(f11745k, fragmentArr[0].getClass().getName());
            g0Var.D(bundleT12.getInt("args_id"), fragmentArr[0], string2);
            if (bundleT12.getBoolean("args_is_add_stack")) {
                g0Var.o(string2);
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

    public static void S0(int i10, @g.n0 Fragment... fragmentArr) {
        Objects.requireNonNull(fragmentArr, "Argument 'fragments' of type Fragment[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        X0(fragmentArr[i10], fragmentArr);
    }

    public static void T(int i10, @g.p0 FragmentManager fragmentManager, Fragment fragment, Fragment... fragmentArr) {
        if (fragmentManager == null) {
            return;
        }
        S(i10, fragmentManager, fragmentManager.u(), fragment, fragmentArr);
    }

    public static void T0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'hide' of type Fragment (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        V0(fragment, Collections.singletonList(fragment2));
    }

    public static void U(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        V(fragmentManager, true);
    }

    public static void U0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, @g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'hide' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        W0(fragment, Collections.singletonList(fragment2), i10, i11, i12, i13);
    }

    public static void V(@g.n0 FragmentManager fragmentManager, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            fragmentManager.v1();
        } else {
            fragmentManager.r1();
        }
    }

    public static void V0(@g.n0 Fragment fragment, @g.n0 List<Fragment> list) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'hide' of type List<Fragment> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Iterator<Fragment> it2 = list.iterator();
        while (true) {
            boolean z10 = false;
            if (!it2.hasNext()) {
                T(8, fragment.t2(), fragment, (Fragment[]) list.toArray(new Fragment[0]));
                return;
            }
            Fragment next = it2.next();
            if (next != fragment) {
                z10 = true;
            }
            b0(next, z10);
        }
    }

    public static void W(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        X(fragmentManager, true);
    }

    public static void W0(@g.n0 Fragment fragment, @g.n0 List<Fragment> list, @g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'hide' of type List<Fragment> (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Iterator<Fragment> it2 = list.iterator();
        while (true) {
            boolean z10 = false;
            if (!it2.hasNext()) {
                break;
            }
            Fragment next = it2.next();
            if (next != fragment) {
                z10 = true;
            }
            b0(next, z10);
        }
        FragmentManager fragmentManagerT2 = fragment.t2();
        if (fragmentManagerT2 != null) {
            androidx.fragment.app.g0 g0VarU = fragmentManagerT2.u();
            w(g0VarU, i10, i11, i12, i13);
            S(8, fragmentManagerT2, g0VarU, fragment, (Fragment[]) list.toArray(new Fragment[0]));
        }
    }

    public static void X(@g.n0 FragmentManager fragmentManager, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (fragmentManager.B0() > 0) {
            FragmentManager.j jVarA0 = fragmentManager.A0(0);
            if (z10) {
                fragmentManager.w1(jVarA0.getId(), 1);
            } else {
                fragmentManager.s1(jVarA0.getId(), 1);
            }
        }
    }

    public static void X0(@g.n0 Fragment fragment, @g.n0 Fragment... fragmentArr) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragmentArr, "Argument 'hide' of type Fragment[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        V0(fragment, Arrays.asList(fragmentArr));
    }

    public static void Y(@g.n0 FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Z(fragmentManager, cls, z10, true);
    }

    public static void Z(@g.n0 FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z10, boolean z11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z11) {
            fragmentManager.x1(cls.getName(), z10 ? 1 : 0);
        } else {
            fragmentManager.u1(cls.getName(), z10 ? 1 : 0);
        }
    }

    public static void a(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j(fragmentManager, fragment, i10, null, false, false);
    }

    public static void a0(Fragment fragment, a aVar) {
        Bundle bundleT1 = fragment.T1();
        if (bundleT1 == null) {
            bundleT1 = new Bundle();
            fragment.c5(bundleT1);
        }
        bundleT1.putInt("args_id", aVar.f11746a);
        bundleT1.putBoolean("args_is_hide", aVar.f11747b);
        bundleT1.putBoolean("args_is_add_stack", aVar.f11748c);
        bundleT1.putString(f11745k, aVar.f11749d);
    }

    public static void b(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, null, false, i11, i12, 0, 0);
    }

    public static void b0(Fragment fragment, boolean z10) {
        Bundle bundleT1 = fragment.T1();
        if (bundleT1 == null) {
            bundleT1 = new Bundle();
            fragment.c5(bundleT1);
        }
        bundleT1.putBoolean("args_is_hide", z10);
    }

    public static void c(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, null, false, i11, i12, i13, i14);
    }

    public static void c0(@g.n0 Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'remove' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T(32, fragment.t2(), null, fragment);
    }

    public static void d(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j(fragmentManager, fragment, i10, str, false, false);
    }

    public static void d0(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T(32, fragmentManager, null, (Fragment[]) H(fragmentManager).toArray(new Fragment[0]));
    }

    public static void e(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, str, false, i11, i12, 0, 0);
    }

    public static void e0(@g.n0 Fragment fragment, boolean z10) {
        Objects.requireNonNull(fragment, "Argument 'removeTo' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T(64, fragment.t2(), z10 ? fragment : null, fragment);
    }

    public static void f(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, str, false, i11, i12, i13, i14);
    }

    public static void f0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l0(fragment, fragment2, null, false);
    }

    public static void g(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j(fragmentManager, fragment, i10, str, z10, false);
    }

    public static void g0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, @g.a @g.b int i10, @g.a @g.b int i11) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, null, false, i10, i11, 0, 0);
    }

    public static void h(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, str, z10, i11, i12, 0, 0);
    }

    public static void h0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, @g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, null, false, i10, i11, i12, i13);
    }

    public static void i(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        androidx.fragment.app.g0 g0VarU = fragmentManager.u();
        a0(fragment, new a(i10, str, false, z10));
        w(g0VarU, i11, i12, i13, i14);
        S(1, fragmentManager, g0VarU, null, fragment);
    }

    public static void i0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l0(fragment, fragment2, str, false);
    }

    public static void j(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, boolean z11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a0(fragment, new a(i10, str, z10, z11));
        T(1, fragmentManager, null, fragment);
    }

    public static void j0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, @g.a @g.b int i10, @g.a @g.b int i11) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, str, false, i10, i11, 0, 0);
    }

    public static void k(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, boolean z10, @g.n0 View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#5 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        androidx.fragment.app.g0 g0VarU = fragmentManager.u();
        a0(fragment, new a(i10, str, false, z10));
        x(g0VarU, viewArr);
        S(1, fragmentManager, g0VarU, null, fragment);
    }

    public static void k0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, @g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, str, false, i10, i11, i12, i13);
    }

    public static void l(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, @g.n0 View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#4 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        k(fragmentManager, fragment, i10, str, false, viewArr);
    }

    public static void l0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, boolean z10) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        FragmentManager fragmentManagerT2 = fragment.t2();
        if (fragmentManagerT2 == null) {
            return;
        }
        B0(fragmentManagerT2, fragment2, G(fragment).f11746a, str, z10);
    }

    public static void m(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j(fragmentManager, fragment, i10, null, z10, false);
    }

    public static void m0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, boolean z10, @g.a @g.b int i10, @g.a @g.b int i11) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, str, z10, i10, i11, 0, 0);
    }

    public static void n(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, null, z10, i11, i12, 0, 0);
    }

    public static void n0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, boolean z10, @g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        FragmentManager fragmentManagerT2 = fragment.t2();
        if (fragmentManagerT2 == null) {
            return;
        }
        D0(fragmentManagerT2, fragment2, G(fragment).f11746a, str, z10, i10, i11, i12, i13);
    }

    public static void o(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(fragmentManager, fragment, i10, null, z10, i11, i12, i13, i14);
    }

    public static void o0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, boolean z10, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        FragmentManager fragmentManagerT2 = fragment.t2();
        if (fragmentManagerT2 == null) {
            return;
        }
        E0(fragmentManagerT2, fragment2, G(fragment).f11746a, str, z10, viewArr);
    }

    public static void p(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, boolean z11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j(fragmentManager, fragment, i10, null, z10, z11);
    }

    public static void p0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, String str, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        o0(fragment, fragment2, str, false, viewArr);
    }

    public static void q(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, boolean z10, @g.n0 View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#4 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        k(fragmentManager, fragment, i10, null, z10, viewArr);
    }

    public static void q0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, boolean z10) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l0(fragment, fragment2, null, z10);
    }

    public static void r(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, @g.n0 View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        k(fragmentManager, fragment, i10, null, false, viewArr);
    }

    public static void r0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, boolean z10, @g.a @g.b int i10, @g.a @g.b int i11) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, null, z10, i10, i11, 0, 0);
    }

    public static void s(@g.n0 FragmentManager fragmentManager, @g.n0 List<Fragment> list, @g.d0 int i10, int i11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'adds' of type List<Fragment> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        v(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i10, null, i11);
    }

    public static void s0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, boolean z10, @g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n0(fragment, fragment2, null, z10, i10, i11, i12, i13);
    }

    public static void t(@g.n0 FragmentManager fragmentManager, @g.n0 List<Fragment> list, @g.d0 int i10, String[] strArr, int i11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'adds' of type List<Fragment> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        v(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i10, strArr, i11);
    }

    public static void t0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, boolean z10, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        o0(fragment, fragment2, null, z10, viewArr);
    }

    public static void u(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment[] fragmentArr, @g.d0 int i10, int i11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragmentArr, "Argument 'adds' of type Fragment[] (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        v(fragmentManager, fragmentArr, i10, null, i11);
    }

    public static void u0(@g.n0 Fragment fragment, @g.n0 Fragment fragment2, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        o0(fragment, fragment2, null, false, viewArr);
    }

    public static void v(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment[] fragmentArr, @g.d0 int i10, String[] strArr, int i11) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragmentArr, "Argument 'adds' of type Fragment[] (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (strArr == null) {
            int length = fragmentArr.length;
            int i12 = 0;
            while (i12 < length) {
                a0(fragmentArr[i12], new a(i10, null, i11 != i12, false));
                i12++;
            }
        } else {
            int length2 = fragmentArr.length;
            int i13 = 0;
            while (i13 < length2) {
                a0(fragmentArr[i13], new a(i10, strArr[i13], i11 != i13, false));
                i13++;
            }
        }
        T(1, fragmentManager, null, fragmentArr);
    }

    public static void v0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B0(fragmentManager, fragment, i10, null, false);
    }

    public static void w(androidx.fragment.app.g0 g0Var, int i10, int i11, int i12, int i13) {
        g0Var.N(i10, i11, i12, i13);
    }

    public static void w0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, null, false, i11, i12, 0, 0);
    }

    public static void x(androidx.fragment.app.g0 g0Var, View... viewArr) {
        for (View view : viewArr) {
            g0Var.n(view, view.getTransitionName());
        }
    }

    public static void x0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13, @g.a @g.b int i14) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, null, false, i11, i12, i13, i14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean y(@g.n0 Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return fragment.A3() && fragment.C3() && fragment.j3() && (fragment instanceof c) && ((c) fragment).a();
    }

    public static void y0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B0(fragmentManager, fragment, i10, str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean z(@g.n0 FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> listH = H(fragmentManager);
        if (listH != null && !listH.isEmpty()) {
            for (int size = listH.size() - 1; size >= 0; size--) {
                Fragment fragment = listH.get(size);
                if (fragment != 0 && fragment.A3() && fragment.C3() && fragment.j3() && (fragment instanceof c) && ((c) fragment).a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void z0(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.d0 int i10, String str, @g.a @g.b int i11, @g.a @g.b int i12) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D0(fragmentManager, fragment, i10, str, false, i11, i12, 0, 0);
    }
}
