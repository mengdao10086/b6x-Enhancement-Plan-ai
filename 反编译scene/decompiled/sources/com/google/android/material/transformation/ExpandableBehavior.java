package com.google.android.material.transformation;

import a.eh;
import a.tw;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8338a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8339a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ tw f4785a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ View f4786a;

        public a(View view, int i, tw twVar) {
            this.f4786a = view;
            this.f8339a = i;
            this.f4785a = twVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f4786a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f8338a == this.f8339a) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                tw twVar = this.f4785a;
                expandableBehavior.H((View) twVar, this.f4786a, twVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f8338a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8338a = 0;
    }

    public final boolean F(boolean z) {
        if (!z) {
            return this.f8338a == 1;
        }
        int i = this.f8338a;
        return i == 0 || i == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public tw G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listR = coordinatorLayout.r(view);
        int size = listR.size();
        for (int i = 0; i < size; i++) {
            View view2 = listR.get(i);
            if (e(coordinatorLayout, view, view2)) {
                return (tw) view2;
            }
        }
        return null;
    }

    public abstract boolean H(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        tw twVar = (tw) view2;
        if (!F(twVar.a())) {
            return false;
        }
        this.f8338a = twVar.a() ? 1 : 2;
        return H((View) twVar, view, twVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        tw twVarG;
        if (eh.Q(view) || (twVarG = G(coordinatorLayout, view)) == null || !F(twVarG.a())) {
            return false;
        }
        int i2 = twVarG.a() ? 1 : 2;
        this.f8338a = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i2, twVarG));
        return false;
    }
}
