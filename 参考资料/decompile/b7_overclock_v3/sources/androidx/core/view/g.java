package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f4880a;

    @g.v0(28)
    public static class a {
        @g.u
        public static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        @g.u
        public static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        @g.u
        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        @g.u
        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        @g.u
        public static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        @g.u
        public static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    @g.v0(29)
    public static class b {
        @g.u
        public static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4);
        }
    }

    @g.v0(30)
    public static class c {
        @g.u
        public static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
        }

        @g.u
        public static Insets b(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    public g(@g.p0 Rect rect, @g.p0 List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? a.a(rect, list) : null);
    }

    public static DisplayCutout a(@g.n0 m0.i iVar, @g.p0 Rect rect, @g.p0 Rect rect2, @g.p0 Rect rect3, @g.p0 Rect rect4, @g.n0 m0.i iVar2) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            return c.a(iVar.h(), rect, rect2, rect3, rect4, iVar2.h());
        }
        if (i10 >= 29) {
            return b.a(iVar.h(), rect, rect2, rect3, rect4);
        }
        if (i10 < 28) {
            return null;
        }
        Rect rect5 = new Rect(iVar.f40559a, iVar.f40560b, iVar.f40561c, iVar.f40562d);
        ArrayList arrayList = new ArrayList();
        if (rect != null) {
            arrayList.add(rect);
        }
        if (rect2 != null) {
            arrayList.add(rect2);
        }
        if (rect3 != null) {
            arrayList.add(rect3);
        }
        if (rect4 != null) {
            arrayList.add(rect4);
        }
        return a.a(rect5, arrayList);
    }

    public static g i(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new g(displayCutout);
    }

    @g.n0
    public List<Rect> b() {
        return Build.VERSION.SDK_INT >= 28 ? a.b(this.f4880a) : Collections.emptyList();
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(this.f4880a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.d(this.f4880a);
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e(this.f4880a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return androidx.core.util.j.a(this.f4880a, ((g) obj).f4880a);
    }

    public int f() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f(this.f4880a);
        }
        return 0;
    }

    @g.n0
    public m0.i g() {
        return Build.VERSION.SDK_INT >= 30 ? m0.i.g(c.b(this.f4880a)) : m0.i.f40558e;
    }

    @g.v0(28)
    public DisplayCutout h() {
        return this.f4880a;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f4880a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    @g.n0
    public String toString() {
        return "DisplayCutoutCompat{" + this.f4880a + zc.a.f58317e;
    }

    public g(@g.n0 m0.i iVar, @g.p0 Rect rect, @g.p0 Rect rect2, @g.p0 Rect rect3, @g.p0 Rect rect4, @g.n0 m0.i iVar2) {
        this(a(iVar, rect, rect2, rect3, rect4, iVar2));
    }

    public g(DisplayCutout displayCutout) {
        this.f4880a = displayCutout;
    }
}
