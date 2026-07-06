package com.google.android.material.bottomappbar;

import a.bv;
import a.eh;
import a.gy;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public final int m;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8286a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final View.OnLayoutChangeListener f4568a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<BottomAppBar> f4569a;
        public int d;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f4569a.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.g(Behavior.this.f8286a);
                int iHeight = Behavior.this.f8286a.height();
                bottomAppBar.Z(iHeight);
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.d == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(bv.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (gy.d(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.m;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.m;
                    }
                }
            }
        }

        public Behavior() {
            this.f4568a = new a();
            this.f8286a = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4568a = new a();
            this.f8286a = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.f4569a = new WeakReference<>(bottomAppBar);
            View viewX = bottomAppBar.X();
            if (viewX != null && !eh.Q(viewX)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewX.getLayoutParams();
                fVar.b = 49;
                this.d = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (viewX instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewX;
                    floatingActionButton.addOnLayoutChangeListener(this.f4568a);
                    bottomAppBar.W(floatingActionButton);
                }
                bottomAppBar.Y();
            }
            coordinatorLayout.I(bottomAppBar, i);
            return super.l(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }
    }

    public final void W(FloatingActionButton floatingActionButton) {
        throw null;
    }

    public final View X() {
        throw null;
    }

    public final void Y() {
        throw null;
    }

    public abstract boolean Z(int i);

    public final int getBottomInset() {
        throw null;
    }

    public abstract boolean getHideOnScroll();

    public final int getLeftInset() {
        throw null;
    }

    public final int getRightInset() {
        throw null;
    }
}
