package a;

import a.ni;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class rf {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f7293a;
    public final View.AccessibilityDelegate b;

    public rf() {
        this(c);
    }

    public rf(View.AccessibilityDelegate accessibilityDelegate) {
        this.f7293a = accessibilityDelegate;
        this.b = new qf(this);
    }

    public static List<ni.a> c(View view) {
        List<ni.a> list = (List) view.getTag(ra.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f7293a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public ri b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f7293a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new ri(accessibilityNodeProvider);
    }

    public View.AccessibilityDelegate d() {
        return this.b;
    }

    public final boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrQ = ni.q(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpanArrQ != null && i < clickableSpanArrQ.length; i++) {
                if (clickableSpan.equals(clickableSpanArrQ[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f7293a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, ni niVar) {
        this.f7293a.onInitializeAccessibilityNodeInfo(view, niVar.C0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f7293a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f7293a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i, Bundle bundle) {
        List<ni.a> listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= listC.size()) {
                break;
            }
            ni.a aVar = listC.get(i2);
            if (aVar.b() == i) {
                zPerformAccessibilityAction = aVar.d(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction && Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.f7293a.performAccessibilityAction(view, i, bundle);
        }
        return (zPerformAccessibilityAction || i != ra.accessibility_action_clickable_span) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public final boolean k(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(ra.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public void l(View view, int i) {
        this.f7293a.sendAccessibilityEvent(view, i);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f7293a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
