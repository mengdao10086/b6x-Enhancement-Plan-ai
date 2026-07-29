package androidx.core.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    @g.v0(17)
    public static class a {
        @g.u
        public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        @g.u
        public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        @g.u
        public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        @g.u
        public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        @g.u
        public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.resolveLayoutDirection(i10);
        }

        @g.u
        public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.setLayoutDirection(i10);
        }

        @g.u
        public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.setMarginEnd(i10);
        }

        @g.u
        public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
            marginLayoutParams.setMarginStart(i10);
        }
    }

    public static int a(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        int iA = a.a(marginLayoutParams);
        if (iA == 0 || iA == 1) {
            return iA;
        }
        return 0;
    }

    public static int b(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }

    public static int c(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.c(marginLayoutParams);
    }

    public static boolean d(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.d(marginLayoutParams);
    }

    public static void e(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        a.e(marginLayoutParams, i10);
    }

    public static void f(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        a.f(marginLayoutParams, i10);
    }

    public static void g(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        a.g(marginLayoutParams, i10);
    }

    public static void h(@g.n0 ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        a.h(marginLayoutParams, i10);
    }
}
