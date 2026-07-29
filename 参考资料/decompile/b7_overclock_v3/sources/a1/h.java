package a1;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import g.n0;
import g.p0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f146b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f147c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f148d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f149e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f150f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f151g = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f152a;

    @v0(21)
    public static class a {
        @u
        public static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        @u
        public static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i10) {
            return accessibilityWindowInfo.getChild(i10);
        }

        @u
        public static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        @u
        public static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        @u
        public static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        @u
        public static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        @u
        public static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        @u
        public static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        @u
        public static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        @u
        public static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        @u
        public static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        @u
        public static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        @u
        public static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }
    }

    @v0(24)
    public static class b {
        @u
        public static AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        @u
        public static CharSequence b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    @v0(33)
    public static class c {
        @u
        public static int a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        @u
        public static void b(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        @u
        public static boolean c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    public h(Object obj) {
        this.f152a = obj;
    }

    @p0
    public static h q() {
        return v(a.l());
    }

    @p0
    public static h r(@p0 h hVar) {
        if (hVar == null) {
            return null;
        }
        return v(a.m((AccessibilityWindowInfo) hVar.f152a));
    }

    public static String t(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    public static h v(Object obj) {
        if (obj != null) {
            return new h(obj);
        }
        return null;
    }

    @p0
    public d a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return d.h2(b.a((AccessibilityWindowInfo) this.f152a));
        }
        return null;
    }

    public void b(@n0 Rect rect) {
        a.a((AccessibilityWindowInfo) this.f152a, rect);
    }

    @p0
    public h c(int i10) {
        return v(a.b((AccessibilityWindowInfo) this.f152a, i10));
    }

    public int d() {
        return a.c((AccessibilityWindowInfo) this.f152a);
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.a((AccessibilityWindowInfo) this.f152a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        Object obj2 = this.f152a;
        return obj2 == null ? hVar.f152a == null : obj2.equals(hVar.f152a);
    }

    public int f() {
        return a.d((AccessibilityWindowInfo) this.f152a);
    }

    public int g() {
        return a.e((AccessibilityWindowInfo) this.f152a);
    }

    @p0
    public h h() {
        return v(a.f((AccessibilityWindowInfo) this.f152a));
    }

    public int hashCode() {
        Object obj = this.f152a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public void i(@n0 Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b((AccessibilityWindowInfo) this.f152a, region);
            return;
        }
        Rect rect = new Rect();
        a.a((AccessibilityWindowInfo) this.f152a, rect);
        region.set(rect);
    }

    @p0
    public d j() {
        return d.h2(a.g((AccessibilityWindowInfo) this.f152a));
    }

    @p0
    public CharSequence k() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.b((AccessibilityWindowInfo) this.f152a);
        }
        return null;
    }

    public int l() {
        return a.h((AccessibilityWindowInfo) this.f152a);
    }

    public boolean m() {
        return a.i((AccessibilityWindowInfo) this.f152a);
    }

    public boolean n() {
        return a.j((AccessibilityWindowInfo) this.f152a);
    }

    public boolean o() {
        return a.k((AccessibilityWindowInfo) this.f152a);
    }

    public boolean p() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.c((AccessibilityWindowInfo) this.f152a);
        }
        return false;
    }

    @Deprecated
    public void s() {
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Rect rect = new Rect();
        b(rect);
        sb2.append("AccessibilityWindowInfo[");
        sb2.append("id=");
        sb2.append(f());
        sb2.append(", type=");
        sb2.append(t(l()));
        sb2.append(", layer=");
        sb2.append(g());
        sb2.append(", bounds=");
        sb2.append(rect);
        sb2.append(", focused=");
        sb2.append(o());
        sb2.append(", active=");
        sb2.append(n());
        sb2.append(", hasParent=");
        sb2.append(h() != null);
        sb2.append(", hasChildren=");
        sb2.append(d() > 0);
        sb2.append(']');
        return sb2.toString();
    }

    @p0
    public AccessibilityWindowInfo u() {
        return (AccessibilityWindowInfo) this.f152a;
    }
}
