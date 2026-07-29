package a1;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import g.n0;
import g.u;
import g.v0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    @Deprecated
    public interface a {
        @Deprecated
        void onAccessibilityStateChanged(boolean z10);
    }

    @Deprecated
    public static abstract class b implements a {
    }

    /* JADX INFO: renamed from: a1.c$c, reason: collision with other inner class name */
    public static class AccessibilityManagerAccessibilityStateChangeListenerC0005c implements AccessibilityManager.AccessibilityStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f62a;

        public AccessibilityManagerAccessibilityStateChangeListenerC0005c(@n0 a aVar) {
            this.f62a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessibilityManagerAccessibilityStateChangeListenerC0005c) {
                return this.f62a.equals(((AccessibilityManagerAccessibilityStateChangeListenerC0005c) obj).f62a);
            }
            return false;
        }

        public int hashCode() {
            return this.f62a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z10) {
            this.f62a.onAccessibilityStateChanged(z10);
        }
    }

    @v0(19)
    public static class d {
        @u
        public static boolean a(AccessibilityManager accessibilityManager, e eVar) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new f(eVar));
        }

        @u
        public static boolean b(AccessibilityManager accessibilityManager, e eVar) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new f(eVar));
        }
    }

    public interface e {
        void onTouchExplorationStateChanged(boolean z10);
    }

    @v0(19)
    public static final class f implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f63a;

        public f(@n0 e eVar) {
            this.f63a = eVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                return this.f63a.equals(((f) obj).f63a);
            }
            return false;
        }

        public int hashCode() {
            return this.f63a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z10) {
            this.f63a.onTouchExplorationStateChanged(z10);
        }
    }

    @Deprecated
    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (aVar == null) {
            return false;
        }
        return accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityManagerAccessibilityStateChangeListenerC0005c(aVar));
    }

    public static boolean b(@n0 AccessibilityManager accessibilityManager, @n0 e eVar) {
        return d.a(accessibilityManager, eVar);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> c(AccessibilityManager accessibilityManager, int i10) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i10);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> d(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean e(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean f(AccessibilityManager accessibilityManager, a aVar) {
        if (aVar == null) {
            return false;
        }
        return accessibilityManager.removeAccessibilityStateChangeListener(new AccessibilityManagerAccessibilityStateChangeListenerC0005c(aVar));
    }

    public static boolean g(@n0 AccessibilityManager accessibilityManager, @n0 e eVar) {
        return d.b(accessibilityManager, eVar);
    }
}
