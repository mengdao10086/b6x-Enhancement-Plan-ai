package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5146a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5147b = 1;

    @g.v0(18)
    public static class a {
        @g.u
        public static int a(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        @g.u
        public static void b(ViewGroup viewGroup, int i10) {
            viewGroup.setLayoutMode(i10);
        }
    }

    @g.v0(21)
    public static class b {
        @g.u
        public static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @g.u
        public static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @g.u
        public static void c(ViewGroup viewGroup, boolean z10) {
            viewGroup.setTransitionGroup(z10);
        }
    }

    public static int a(@g.n0 ViewGroup viewGroup) {
        return a.a(viewGroup);
    }

    public static int b(@g.n0 ViewGroup viewGroup) {
        return b.a(viewGroup);
    }

    public static boolean c(@g.n0 ViewGroup viewGroup) {
        return b.b(viewGroup);
    }

    @Deprecated
    public static boolean d(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void e(@g.n0 ViewGroup viewGroup, int i10) {
        a.b(viewGroup, i10);
    }

    @Deprecated
    public static void f(ViewGroup viewGroup, boolean z10) {
        viewGroup.setMotionEventSplittingEnabled(z10);
    }

    public static void g(@g.n0 ViewGroup viewGroup, boolean z10) {
        b.c(viewGroup, z10);
    }
}
