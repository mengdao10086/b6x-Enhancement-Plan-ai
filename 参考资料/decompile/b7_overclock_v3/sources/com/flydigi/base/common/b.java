package com.flydigi.base.common;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a(Fragment fragment) {
        return c(fragment.U1());
    }

    public static boolean b(androidx.fragment.app.g gVar) {
        return c(gVar.n3());
    }

    public static boolean c(FragmentManager fragmentManager) {
        List<Fragment> listI0 = fragmentManager.I0();
        for (int size = listI0.size() - 1; size >= 0; size--) {
            if (d(listI0.get(size))) {
                return true;
            }
        }
        if (fragmentManager.B0() <= 0) {
            return false;
        }
        fragmentManager.r1();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(Fragment fragment) {
        return fragment != 0 && fragment.C3() && fragment.j3() && (fragment instanceof t) && ((t) fragment).V();
    }
}
