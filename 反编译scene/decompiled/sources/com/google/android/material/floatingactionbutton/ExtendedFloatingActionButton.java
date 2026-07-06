package com.google.android.material.floatingactionbutton;

import a.jv;
import a.nx;
import a.rx;
import a.yw;
import a.zw;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nx f8305a;
    public final nx b;
    public final nx c;
    public final nx d;

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f8306a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public a f4631a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4632a;
        public a b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4633b;

        public ExtendedFloatingActionButtonBehavior() {
            this.f4632a = false;
            this.f4633b = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.ExtendedFloatingActionButton_Behavior_Layout);
            this.f4632a = typedArrayObtainStyledAttributes.getBoolean(jv.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f4633b = typedArrayObtainStyledAttributes.getBoolean(jv.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.l(this.f4633b ? extendedFloatingActionButton.b : extendedFloatingActionButton.c, this.f4633b ? this.b : this.f4631a);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> listR = coordinatorLayout.r(extendedFloatingActionButton);
            int size = listR.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = listR.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i);
            return true;
        }

        public final boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f4632a || this.f4633b) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        public void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.l(this.f4633b ? extendedFloatingActionButton.f8305a : extendedFloatingActionButton.d, this.f4633b ? this.b : this.f4631a);
        }

        public final boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f8306a == null) {
                this.f8306a = new Rect();
            }
            Rect rect = this.f8306a;
            rx.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        public final boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f == 0) {
                fVar.f = 80;
            }
        }
    }

    public static abstract class a {
    }

    static {
        new yw(Float.class, "width");
        new zw(Float.class, "height");
    }

    public final void l(nx nxVar, a aVar) {
        throw null;
    }
}
