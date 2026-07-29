package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class n1 {
    public static void a(View view) {
        view.setFocusable(false);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setFocusable(false);
            if (childAt instanceof ViewGroup) {
                a(childAt);
            }
        }
    }

    public static boolean b() {
        return TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? j1.a().getResources().getConfiguration().getLocales().get(0) : j1.a().getResources().getConfiguration().locale) == 1;
    }

    public static View c(@g.i0 int i10) {
        return ((LayoutInflater) j1.a().getSystemService("layout_inflater")).inflate(i10, (ViewGroup) null);
    }

    public static void d(Runnable runnable) {
        l1.U0(runnable);
    }

    public static void e(Runnable runnable, long j10) {
        l1.V0(runnable, j10);
    }

    public static void f(View view, boolean z10) {
        g(view, z10, null);
    }

    public static void g(View view, boolean z10, View... viewArr) {
        if (view == null) {
            return;
        }
        if (viewArr != null) {
            for (View view2 : viewArr) {
                if (view == view2) {
                    return;
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                g(viewGroup.getChildAt(i10), z10, viewArr);
            }
        }
        view.setEnabled(z10);
    }
}
