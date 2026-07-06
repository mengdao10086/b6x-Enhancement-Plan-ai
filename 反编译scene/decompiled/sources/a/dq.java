package a;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dq extends rf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cq f5926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RecyclerView f592a;

    public dq(RecyclerView recyclerView) {
        this.f592a = recyclerView;
        rf rfVarN = n();
        this.f5926a = (rfVarN == null || !(rfVarN instanceof cq)) ? new cq(this) : (cq) rfVarN;
    }

    @Override // a.rf
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().Q0(accessibilityEvent);
        }
    }

    @Override // a.rf
    public void g(View view, ni niVar) {
        super.g(view, niVar);
        if (o() || this.f592a.getLayoutManager() == null) {
            return;
        }
        this.f592a.getLayoutManager().S0(niVar);
    }

    @Override // a.rf
    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.f592a.getLayoutManager() == null) {
            return false;
        }
        return this.f592a.getLayoutManager().l1(i, bundle);
    }

    public rf n() {
        return this.f5926a;
    }

    public boolean o() {
        return this.f592a.m0();
    }
}
