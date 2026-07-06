package a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cq extends rf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dq f5817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<View, rf> f437a = new WeakHashMap();

    public cq(dq dqVar) {
        this.f5817a = dqVar;
    }

    @Override // a.rf
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        rf rfVar = this.f437a.get(view);
        return rfVar != null ? rfVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
    }

    @Override // a.rf
    public ri b(View view) {
        rf rfVar = this.f437a.get(view);
        return rfVar != null ? rfVar.b(view) : super.b(view);
    }

    @Override // a.rf
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        rf rfVar = this.f437a.get(view);
        if (rfVar != null) {
            rfVar.f(view, accessibilityEvent);
        } else {
            super.f(view, accessibilityEvent);
        }
    }

    @Override // a.rf
    public void g(View view, ni niVar) {
        if (!this.f5817a.o() && this.f5817a.f592a.getLayoutManager() != null) {
            this.f5817a.f592a.getLayoutManager().U0(view, niVar);
            rf rfVar = this.f437a.get(view);
            if (rfVar != null) {
                rfVar.g(view, niVar);
                return;
            }
        }
        super.g(view, niVar);
    }

    @Override // a.rf
    public void h(View view, AccessibilityEvent accessibilityEvent) {
        rf rfVar = this.f437a.get(view);
        if (rfVar != null) {
            rfVar.h(view, accessibilityEvent);
        } else {
            super.h(view, accessibilityEvent);
        }
    }

    @Override // a.rf
    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        rf rfVar = this.f437a.get(viewGroup);
        return rfVar != null ? rfVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
    }

    @Override // a.rf
    public boolean j(View view, int i, Bundle bundle) {
        if (this.f5817a.o() || this.f5817a.f592a.getLayoutManager() == null) {
            return super.j(view, i, bundle);
        }
        rf rfVar = this.f437a.get(view);
        if (rfVar != null) {
            if (rfVar.j(view, i, bundle)) {
                return true;
            }
        } else if (super.j(view, i, bundle)) {
            return true;
        }
        return this.f5817a.f592a.getLayoutManager().n1(view, i, bundle);
    }

    @Override // a.rf
    public void l(View view, int i) {
        rf rfVar = this.f437a.get(view);
        if (rfVar != null) {
            rfVar.l(view, i);
        } else {
            super.l(view, i);
        }
    }

    @Override // a.rf
    public void m(View view, AccessibilityEvent accessibilityEvent) {
        rf rfVar = this.f437a.get(view);
        if (rfVar != null) {
            rfVar.m(view, accessibilityEvent);
        } else {
            super.m(view, accessibilityEvent);
        }
    }

    public rf n(View view) {
        return this.f437a.remove(view);
    }

    public void o(View view) {
        rf rfVarJ = eh.j(view);
        if (rfVarJ == null || rfVarJ == this) {
            return;
        }
        this.f437a.put(view, rfVarJ);
    }
}
