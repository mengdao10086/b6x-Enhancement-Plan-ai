package androidx.core.view;

import a1.d;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f4795c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f4796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f4797b;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    public static final class C0041a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f4798a;

        public C0041a(a aVar) {
            this.f4798a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f4798a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        @g.v0(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            a1.e eVarB = this.f4798a.b(view);
            if (eVarB != null) {
                return (AccessibilityNodeProvider) eVarB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4798a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            a1.d dVarG2 = a1.d.g2(accessibilityNodeInfo);
            dVarG2.L1(u0.Z0(view));
            dVarG2.p1(u0.N0(view));
            dVarG2.E1(u0.J(view));
            dVarG2.R1(u0.v0(view));
            this.f4798a.g(view, dVarG2);
            dVarG2.f(accessibilityNodeInfo.getText(), view);
            List<d.a> listC = a.c(view);
            for (int i10 = 0; i10 < listC.size(); i10++) {
                dVarG2.b(listC.get(i10));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4798a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f4798a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return this.f4798a.j(view, i10, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i10) {
            this.f4798a.l(view, i10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f4798a.m(view, accessibilityEvent);
        }
    }

    @g.v0(16)
    public static class b {
        @g.u
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        @g.u
        public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i10, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i10, bundle);
        }
    }

    public a() {
        this(f4795c);
    }

    public static List<d.a> c(View view) {
        List<d.a> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean a(@g.n0 View view, @g.n0 AccessibilityEvent accessibilityEvent) {
        return this.f4796a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @g.p0
    public a1.e b(@g.n0 View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = b.a(this.f4796a, view);
        if (accessibilityNodeProviderA != null) {
            return new a1.e(accessibilityNodeProviderA);
        }
        return null;
    }

    public View.AccessibilityDelegate d() {
        return this.f4797b;
    }

    public final boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrX = a1.d.x(view.createAccessibilityNodeInfo().getText());
            for (int i10 = 0; clickableSpanArrX != null && i10 < clickableSpanArrX.length; i10++) {
                if (clickableSpan.equals(clickableSpanArrX[i10])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void f(@g.n0 View view, @g.n0 AccessibilityEvent accessibilityEvent) {
        this.f4796a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(@g.n0 View view, @g.n0 a1.d dVar) {
        this.f4796a.onInitializeAccessibilityNodeInfo(view, dVar.f2());
    }

    public void h(@g.n0 View view, @g.n0 AccessibilityEvent accessibilityEvent) {
        this.f4796a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(@g.n0 ViewGroup viewGroup, @g.n0 View view, @g.n0 AccessibilityEvent accessibilityEvent) {
        return this.f4796a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(@g.n0 View view, int i10, @g.p0 Bundle bundle) {
        List<d.a> listC = c(view);
        boolean zB = false;
        int i11 = 0;
        while (true) {
            if (i11 >= listC.size()) {
                break;
            }
            d.a aVar = listC.get(i11);
            if (aVar.b() == i10) {
                zB = aVar.d(view, bundle);
                break;
            }
            i11++;
        }
        if (!zB) {
            zB = b.b(this.f4796a, view, i10, bundle);
        }
        return (zB || i10 != R.id.accessibility_action_clickable_span || bundle == null) ? zB : k(bundle.getInt(a1.a.f32d, -1), view);
    }

    public final boolean k(int i10, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i10)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public void l(@g.n0 View view, int i10) {
        this.f4796a.sendAccessibilityEvent(view, i10);
    }

    public void m(@g.n0 View view, @g.n0 AccessibilityEvent accessibilityEvent) {
        this.f4796a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public a(@g.n0 View.AccessibilityDelegate accessibilityDelegate) {
        this.f4796a = accessibilityDelegate;
        this.f4797b = new C0041a(this);
    }
}
