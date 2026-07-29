package a1;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f141b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Object f142a;

    @v0(16)
    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f143a;

        public a(e eVar) {
            this.f143a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            d dVarB = this.f143a.b(i10);
            if (dVarB == null) {
                return null;
            }
            return dVarB.f2();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<d> listC = this.f143a.c(str, i10);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(listC.get(i11).f2());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f143a.f(i10, i11, bundle);
        }
    }

    @v0(19)
    public static class b extends a {
        public b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            d dVarD = this.f143a.d(i10);
            if (dVarD == null) {
                return null;
            }
            return dVarD.f2();
        }
    }

    @v0(26)
    public static class c extends b {
        public c(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f143a.a(i10, d.g2(accessibilityNodeInfo), str, bundle);
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f142a = new c(this);
        } else {
            this.f142a = new b(this);
        }
    }

    public void a(int i10, @n0 d dVar, @n0 String str, @p0 Bundle bundle) {
    }

    @p0
    public d b(int i10) {
        return null;
    }

    @p0
    public List<d> c(@n0 String str, int i10) {
        return null;
    }

    @p0
    public d d(int i10) {
        return null;
    }

    @p0
    public Object e() {
        return this.f142a;
    }

    public boolean f(int i10, int i11, @p0 Bundle bundle) {
        return false;
    }

    public e(@p0 Object obj) {
        this.f142a = obj;
    }
}
