package a;

import a.ni;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qf extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rf f7206a;

    public qf(rf rfVar) {
        this.f7206a = rfVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f7206a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        ri riVarB = this.f7206a.b(view);
        if (riVarB != null) {
            return (AccessibilityNodeProvider) riVarB.e();
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f7206a.f(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        ni niVarD0 = ni.D0(accessibilityNodeInfo);
        niVarD0.t0(eh.T(view));
        niVarD0.k0(eh.O(view));
        niVarD0.p0(eh.n(view));
        niVarD0.z0(eh.G(view));
        this.f7206a.g(view, niVarD0);
        niVarD0.f(accessibilityNodeInfo.getText(), view);
        List<ni.a> listC = rf.c(view);
        for (int i = 0; i < listC.size(); i++) {
            niVarD0.b(listC.get(i));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f7206a.h(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f7206a.i(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.f7206a.j(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        this.f7206a.l(view, i);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f7206a.m(view, accessibilityEvent);
    }
}
