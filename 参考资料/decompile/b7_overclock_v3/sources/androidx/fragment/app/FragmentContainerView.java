package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.j1;
import androidx.core.view.u0;
import androidx.fragment.R;
import com.arialyy.aria.core.inf.IOptionConstant;
import g.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;B%\b\u0017\u0012\u0006\u00109\u001a\u000208\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u001b¢\u0006\u0004\b:\u0010?B!\b\u0010\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b:\u0010BJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0001J\"\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\u0019\u0010*\u001a\u00028\u0000\"\n\b\u0000\u0010)*\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0010H\u0002R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006C"}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/animation/LayoutTransition;", androidx.appcompat.graphics.drawable.a.f1755z, "Lkotlin/z1;", "setLayoutTransition", "Landroid/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "dispatchApplyWindowInsets", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "Landroid/view/View;", "child", "", "drawingTime", "", "drawChild", "view", "startViewTransition", "endViewTransition", "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "", "index", "Landroid/view/ViewGroup$LayoutParams;", IOptionConstant.params, "addView", "removeViewAt", "removeViewInLayout", "removeView", xc.d.f55084n0, uh.a.C, "removeViews", "removeViewsInLayout", "removeAllViewsInLayout", "Landroidx/fragment/app/Fragment;", "F", "getFragment", "()Landroidx/fragment/app/Fragment;", "v", "a", "", "Ljava/util/List;", "disappearingFragmentChildren", "b", "transitioningFragmentViews", "c", "Landroid/view/View$OnApplyWindowInsetsListener;", "applyWindowInsetsListener", "d", "Z", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/FragmentManager;", "fm", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final List<View> f5712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<View> f5713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public View.OnApplyWindowInsetsListener f5714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5715d;

    @v0(20)
    @kotlin.d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/FragmentContainerView$a;", "", "Landroid/view/View$OnApplyWindowInsetsListener;", "onApplyWindowInsetsListener", "Landroid/view/View;", "v", "Landroid/view/WindowInsets;", "insets", "a", "<init>", "()V", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f5716a = new a();

        @yt.k
        public final WindowInsets a(@yt.k View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, @yt.k View v10, @yt.k WindowInsets insets) {
            kotlin.jvm.internal.f0.p(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            kotlin.jvm.internal.f0.p(v10, "v");
            kotlin.jvm.internal.f0.p(insets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v10, insets);
            kotlin.jvm.internal.f0.o(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@yt.k Context context) {
        super(context);
        kotlin.jvm.internal.f0.p(context, "context");
        this.f5712a = new ArrayList();
        this.f5713b = new ArrayList();
        this.f5715d = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public FragmentContainerView(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.f0.p(context, "context");
    }

    public final void a(View view) {
        if (this.f5713b.contains(view)) {
            this.f5712a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@yt.k View child, int i10, @yt.l ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.f0.p(child, "child");
        if (FragmentManager.Q0(child) != null) {
            super.addView(child, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    @yt.k
    @v0(20)
    public WindowInsets dispatchApplyWindowInsets(@yt.k WindowInsets insets) {
        j1 j1VarG1;
        kotlin.jvm.internal.f0.p(insets, "insets");
        j1 j1VarK = j1.K(insets);
        kotlin.jvm.internal.f0.o(j1VarK, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f5714c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f5716a;
            kotlin.jvm.internal.f0.m(onApplyWindowInsetsListener);
            j1VarG1 = j1.K(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            j1VarG1 = u0.g1(this, j1VarK);
        }
        kotlin.jvm.internal.f0.o(j1VarG1, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!j1VarG1.A()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                u0.p(getChildAt(i10), j1VarG1);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@yt.k Canvas canvas) {
        kotlin.jvm.internal.f0.p(canvas, "canvas");
        if (this.f5715d) {
            Iterator<T> it2 = this.f5712a.iterator();
            while (it2.hasNext()) {
                super.drawChild(canvas, (View) it2.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@yt.k Canvas canvas, @yt.k View child, long j10) {
        kotlin.jvm.internal.f0.p(canvas, "canvas");
        kotlin.jvm.internal.f0.p(child, "child");
        if (this.f5715d && (!this.f5712a.isEmpty()) && this.f5712a.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "view");
        this.f5713b.remove(view);
        if (this.f5712a.remove(view)) {
            this.f5715d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.u0(this).r0(getId());
    }

    @Override // android.view.View
    @yt.k
    @v0(20)
    public WindowInsets onApplyWindowInsets(@yt.k WindowInsets insets) {
        kotlin.jvm.internal.f0.p(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.f0.o(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View view = getChildAt(i10);
        kotlin.jvm.internal.f0.o(view, "view");
        a(view);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.f0.o(view, "view");
            a(view);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View view = getChildAt(i13);
            kotlin.jvm.internal.f0.o(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i10, i11);
    }

    @hk.h(name = "setDrawDisappearingViewsLast")
    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f5715d = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@yt.l LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@yt.k View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.f0.p(listener, "listener");
        this.f5714c = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "view");
        if (view.getParent() == this) {
            this.f5713b.add(view);
        }
        super.startViewTransition(view);
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.u uVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public FragmentContainerView(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        String str;
        super(context, attributeSet, i10);
        kotlin.jvm.internal.f0.p(context, "context");
        this.f5712a = new ArrayList();
        this.f5713b = new ArrayList();
        this.f5715d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] FragmentContainerView = R.styleable.FragmentContainerView;
            kotlin.jvm.internal.f0.o(FragmentContainerView, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + kotlin.text.y.f38188b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@yt.k Context context, @yt.k AttributeSet attrs, @yt.k FragmentManager fm2) {
        String str;
        super(context, attrs);
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(attrs, "attrs");
        kotlin.jvm.internal.f0.p(fm2, "fm");
        this.f5712a = new ArrayList();
        this.f5713b = new ArrayList();
        this.f5715d = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = R.styleable.FragmentContainerView;
        kotlin.jvm.internal.f0.o(FragmentContainerView, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment fragmentR0 = fm2.r0(id2);
        if (classAttribute != null && fragmentR0 == null) {
            if (id2 == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = fm2.G0().a(context.getClassLoader(), classAttribute);
            kotlin.jvm.internal.f0.o(fragmentA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentA.W3(context, attrs, null);
            fm2.u().Q(true).j(this, fragmentA, string).t();
        }
        fm2.o1(this);
    }
}
