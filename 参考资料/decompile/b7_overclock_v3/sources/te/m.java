package te;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.v0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public class m extends SharedElementCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public static WeakReference<View> f51189f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public Rect f51193d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51190a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51191b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51192c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public d f51194e = new e();

    public class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f51195a;

        public a(Window window) {
            this.f51195a = window;
        }

        @Override // te.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            m.j(this.f51195a);
        }

        @Override // te.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.i(this.f51195a);
        }
    }

    public class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f51197a;

        public b(Activity activity) {
            this.f51197a = activity;
        }

        @Override // te.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            View view;
            if (m.f51189f != null && (view = (View) m.f51189f.get()) != null) {
                view.setAlpha(1.0f);
                WeakReference unused = m.f51189f = null;
            }
            this.f51197a.finish();
            this.f51197a.overridePendingTransition(0, 0);
        }
    }

    public class c extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f51199a;

        public c(Window window) {
            this.f51199a = window;
        }

        @Override // te.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.i(this.f51199a);
        }
    }

    public interface d {
        @p0
        le.o a(@n0 View view);
    }

    public static class e implements d {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // te.m.d
        @p0
        public le.o a(@n0 View view) {
            if (view instanceof le.s) {
                return ((le.s) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    @p0
    public static Drawable f(Window window) {
        return window.getDecorView().getBackground();
    }

    public static void i(Window window) {
        Drawable drawableF = f(window);
        if (drawableF == null) {
            return;
        }
        drawableF.mutate().setColorFilter(m0.c.a(0, BlendModeCompat.CLEAR));
    }

    public static void j(Window window) {
        Drawable drawableF = f(window);
        if (drawableF == null) {
            return;
        }
        drawableF.mutate().clearColorFilter();
    }

    public static void p(Window window, l lVar) {
        if (lVar.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(lVar.getDuration());
        }
    }

    @p0
    public d e() {
        return this.f51194e;
    }

    public boolean g() {
        return this.f51192c;
    }

    public boolean h() {
        return this.f51191b;
    }

    public void k(@p0 d dVar) {
        this.f51194e = dVar;
    }

    public void l(boolean z10) {
        this.f51192c = z10;
    }

    public void m(boolean z10) {
        this.f51191b = z10;
    }

    public final void n(Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof l) {
            l lVar = (l) sharedElementEnterTransition;
            if (!this.f51192c) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.f51191b) {
                p(window, lVar);
                lVar.addListener(new a(window));
            }
        }
    }

    public final void o(Activity activity, Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof l) {
            l lVar = (l) sharedElementReturnTransition;
            lVar.d0(true);
            lVar.addListener(new b(activity));
            if (this.f51191b) {
                p(window, lVar);
                lVar.addListener(new c(window));
            }
        }
    }

    @Override // android.app.SharedElementCallback
    @p0
    public Parcelable onCaptureSharedElementSnapshot(@n0 View view, @n0 Matrix matrix, @n0 RectF rectF) {
        f51189f = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    @p0
    public View onCreateSnapshotView(@n0 Context context, @p0 Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        le.o oVarA;
        View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (viewOnCreateSnapshotView != null && (weakReference = f51189f) != null && this.f51194e != null && (view = weakReference.get()) != null && (oVarA = this.f51194e.a(view)) != null) {
            viewOnCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, oVarA);
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@n0 List<String> list, @n0 Map<String, View> map) {
        View view;
        Activity activityA;
        if (list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activityA = com.google.android.material.internal.c.a(view.getContext())) == null) {
            return;
        }
        Window window = activityA.getWindow();
        if (this.f51190a) {
            n(window);
        } else {
            o(activityA, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@n0 List<String> list, @n0 List<View> list2, @n0 List<View> list3) {
        if (!list2.isEmpty()) {
            View view = list2.get(0);
            int i10 = R.id.mtrl_motion_snapshot_view;
            if (view.getTag(i10) instanceof View) {
                list2.get(0).setTag(i10, null);
            }
        }
        if (!this.f51190a && !list2.isEmpty()) {
            this.f51193d = v.i(list2.get(0));
        }
        this.f51190a = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@n0 List<String> list, @n0 List<View> list2, @n0 List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.f51190a || list2.isEmpty() || this.f51193d == null) {
            return;
        }
        View view = list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f51193d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f51193d.height(), 1073741824));
        Rect rect = this.f51193d;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
