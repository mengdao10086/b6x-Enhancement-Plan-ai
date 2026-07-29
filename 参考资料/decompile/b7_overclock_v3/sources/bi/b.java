package bi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.u0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import eu.davidea.flexibleadapter.R;
import g.d0;
import g.f0;
import g.i0;
import g.l;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class b extends FrameLayout {
    public static final boolean A = true;
    public static final int B = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f9448v = 5;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f9449w = 300;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f9450x = 300;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f9451y = 1000;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f9452z = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f9453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f9454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f9455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f9459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView.o f9460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f9461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<h> f9462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f9464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public bi.a f9471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public bi.c f9472t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RecyclerView.t f9473u;

    public class a extends RecyclerView.t {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (b.this.isEnabled()) {
                b bVar = b.this;
                if (bVar.f9453a == null || bVar.f9454b.isSelected()) {
                    return;
                }
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int iComputeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
                b bVar2 = b.this;
                bVar2.setBubbleAndHandlePosition(bVar2.f9456d * (iComputeVerticalScrollOffset / (iComputeVerticalScrollRange - r1)));
                if (b.this.f9458f != 0 && i11 != 0) {
                    int iAbs = Math.abs(i11);
                    b bVar3 = b.this;
                    if (iAbs <= bVar3.f9458f && !bVar3.f9472t.d()) {
                        return;
                    }
                }
                b.this.p();
                b.this.d();
            }
        }
    }

    /* JADX INFO: renamed from: bi.b$b, reason: collision with other inner class name */
    public class ViewOnLayoutChangeListenerC0098b implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0098b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            b bVar = b.this;
            bVar.f9460h = bVar.f9459g.getLayoutManager();
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.f9459g.getViewTreeObserver().removeOnPreDrawListener(this);
            b bVar = b.this;
            if (bVar.f9453a != null && !bVar.f9454b.isSelected()) {
                int iComputeVerticalScrollOffset = b.this.f9459g.computeVerticalScrollOffset();
                int iComputeVerticalScrollRange = b.this.computeVerticalScrollRange();
                b bVar2 = b.this;
                bVar2.setBubbleAndHandlePosition(bVar2.f9456d * (iComputeVerticalScrollOffset / (iComputeVerticalScrollRange - r4)));
            }
            return true;
        }
    }

    public interface d {
        void h(@n0 b bVar);
    }

    public interface e {
        String k(int i10);
    }

    public static class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f9477c = "b$f";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f9478d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView f9479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f9480b;

        @p0
        public b a() {
            return this.f9480b;
        }

        public boolean b() {
            b bVar = this.f9480b;
            return bVar != null && bVar.isEnabled();
        }

        public void c(RecyclerView recyclerView) {
            this.f9479a = recyclerView;
        }

        public void d(RecyclerView recyclerView) {
            this.f9480b = null;
            this.f9479a = null;
        }

        public void e(@p0 b bVar) {
            RecyclerView recyclerView = this.f9479a;
            if (recyclerView == null) {
                throw new IllegalStateException("RecyclerView cannot be null. Setup FastScroller after the Adapter has been added to the RecyclerView.");
            }
            if (bVar != null) {
                this.f9480b = bVar;
                bVar.setRecyclerView(recyclerView);
                this.f9480b.setEnabled(true);
                this.f9480b.n(R.layout.library_fast_scroller_layout, R.id.fast_scroller_bubble, R.id.fast_scroller_handle);
                return;
            }
            b bVar2 = this.f9480b;
            if (bVar2 != null) {
                bVar2.setEnabled(false);
                this.f9480b = null;
            }
        }

        public void f() {
            b bVar = this.f9480b;
            if (bVar != null) {
                bVar.q();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface g {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f9481x = 0;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f9482y = 1;
    }

    public interface h {
        void i(boolean z10);
    }

    public b(Context context) {
        super(context);
        this.f9462j = new ArrayList();
        this.f9463k = 0;
        i();
    }

    public static int f(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i12), i11);
    }

    public void c(h hVar) {
        if (hVar == null || this.f9462j.contains(hVar)) {
            return;
        }
        this.f9462j.add(hVar);
    }

    public final void d() {
        if (this.f9466n) {
            h();
        }
    }

    public int e(float f10) {
        int itemCount = this.f9459g.getAdapter().getItemCount();
        float f11 = 0.0f;
        if (this.f9454b.getY() != 0.0f) {
            float y10 = this.f9454b.getY() + this.f9454b.getHeight();
            int i10 = this.f9456d;
            f11 = y10 >= ((float) (i10 + (-5))) ? 1.0f : f10 / i10;
        }
        return f(0, itemCount - 1, (int) (f11 * itemCount));
    }

    public void g() {
        this.f9471s.d();
    }

    public long getAutoHideDelayInMillis() {
        return this.f9464l;
    }

    public void h() {
        bi.c cVar = this.f9472t;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void i() {
        if (this.f9465m) {
            return;
        }
        this.f9465m = true;
        setClipChildren(false);
        this.f9473u = new a();
    }

    public boolean j() {
        return this.f9466n;
    }

    public boolean k() {
        View view = this.f9455c;
        return view == null || this.f9454b == null || view.getVisibility() == 4 || this.f9454b.getVisibility() == 4;
    }

    public void l(boolean z10) {
        Iterator<h> it2 = this.f9462j.iterator();
        while (it2.hasNext()) {
            it2.next().i(z10);
        }
    }

    public void m(h hVar) {
        this.f9462j.remove(hVar);
    }

    public void n(@i0 int i10, @d0 int i11, @d0 int i12) {
        if (this.f9453a != null) {
            return;
        }
        LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(i11);
        this.f9453a = textView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        this.f9454b = (ImageView) findViewById(i12);
        this.f9455c = findViewById(R.id.fast_scroller_bar);
        this.f9471s = new bi.a(this.f9453a, 300L);
        this.f9472t = new bi.c(this.f9455c, this.f9454b, this.f9469q, this.f9464l, 300L);
        int i13 = this.f9463k;
        if (i13 != 0) {
            setBubbleAndHandleColor(i13);
        }
    }

    public void o() {
        if (this.f9467o) {
            this.f9471s.g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView recyclerView = this.f9459g;
        if (recyclerView != null) {
            recyclerView.r(this.f9473u);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView recyclerView = this.f9459g;
        if (recyclerView != null) {
            recyclerView.u1(this.f9473u);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f9456d = i11;
        this.f9457e = i10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@n0 MotionEvent motionEvent) {
        if (this.f9459g.computeVerticalScrollRange() <= this.f9459g.computeVerticalScrollExtent()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            this.f9454b.setSelected(false);
            l(false);
            g();
            d();
            return true;
        }
        if (motionEvent.getX() < this.f9454b.getX() - u0.k0(this.f9454b)) {
            return false;
        }
        if (this.f9468p && (motionEvent.getY() < this.f9454b.getY() || motionEvent.getY() > this.f9454b.getY() + this.f9454b.getHeight())) {
            return false;
        }
        this.f9454b.setSelected(true);
        l(true);
        o();
        p();
        float y10 = motionEvent.getY();
        setBubbleAndHandlePosition(y10);
        setRecyclerViewPosition(y10);
        return true;
    }

    public void p() {
        bi.c cVar = this.f9472t;
        if (cVar != null) {
            cVar.h();
        }
    }

    public void q() {
        setEnabled(!isEnabled());
    }

    public void r(int i10) {
        if (this.f9453a == null || !this.f9467o) {
            return;
        }
        String strK = this.f9461i.k(i10);
        if (strK == null) {
            this.f9453a.setVisibility(8);
        } else {
            this.f9453a.setVisibility(0);
            this.f9453a.setText(strK);
        }
    }

    public void setAutoHideDelayInMillis(@f0(from = 0) long j10) {
        this.f9464l = j10;
        bi.c cVar = this.f9472t;
        if (cVar != null) {
            cVar.g(j10);
        }
    }

    public void setAutoHideEnabled(boolean z10) {
        this.f9466n = z10;
    }

    public void setBubbleAndHandleColor(@l int i10) {
        this.f9463k = i10;
        if (this.f9453a != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.fast_scroller_bubble, null);
            gradientDrawable.setColor(i10);
            this.f9453a.setBackground(gradientDrawable);
        }
        if (this.f9454b != null) {
            try {
                StateListDrawable stateListDrawable = (StateListDrawable) getResources().getDrawable(R.drawable.fast_scroller_handle, null);
                ((GradientDrawable) StateListDrawable.class.getMethod("getStateDrawable", Integer.TYPE).invoke(stateListDrawable, 0)).setColor(i10);
                this.f9454b.setImageDrawable(stateListDrawable);
            } catch (Exception e10) {
                fi.b.u(e10, "Exception while setting Bubble and Handle Color", new Object[0]);
            }
        }
    }

    public void setBubbleAndHandlePosition(float f10) {
        if (this.f9456d == 0) {
            return;
        }
        int height = this.f9454b.getHeight();
        float f11 = f10 - ((height * f10) / this.f9456d);
        this.f9454b.setY(f(0, r2 - height, (int) f11));
        TextView textView = this.f9453a;
        if (textView != null) {
            int height2 = textView.getHeight();
            if (this.f9470r == 0) {
                this.f9453a.setY(f(0, (this.f9456d - height2) - (height / 2), (int) (f11 - (height2 / 1.5f))));
                return;
            }
            this.f9453a.setY(Math.max(0, (this.f9456d - r6.getHeight()) / 2));
            this.f9453a.setX(Math.max(0, (this.f9457e - r6.getWidth()) / 2));
        }
    }

    public void setBubbleTextCreator(e eVar) {
        this.f9461i = eVar;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!z10) {
            h();
        } else {
            p();
            d();
        }
    }

    public void setHandleAlwaysVisible(boolean z10) {
        this.f9468p = z10;
    }

    public void setIgnoreTouchesOutsideHandle(boolean z10) {
        this.f9468p = z10;
    }

    public void setMinimumScrollThreshold(@f0(from = 0) int i10) {
        this.f9458f = i10;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.f9459g = recyclerView;
        RecyclerView.t tVar = this.f9473u;
        if (tVar != null) {
            recyclerView.u1(tVar);
        }
        this.f9459g.r(this.f9473u);
        this.f9459g.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0098b());
        if (recyclerView.getAdapter() instanceof e) {
            setBubbleTextCreator((e) recyclerView.getAdapter());
        }
        if (recyclerView.getAdapter() instanceof h) {
            c((h) recyclerView.getAdapter());
        }
        this.f9459g.getViewTreeObserver().addOnPreDrawListener(new c());
    }

    public void setRecyclerViewPosition(float f10) {
        if (this.f9459g != null) {
            int iE = e(f10);
            RecyclerView.o oVar = this.f9460h;
            if (oVar instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) oVar).m3(iE, 0);
            } else {
                ((LinearLayoutManager) oVar).h3(iE, 0);
            }
            r(iE);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9462j = new ArrayList();
        this.f9463k = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FastScroller, 0, 0);
        try {
            this.f9466n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerAutoHideEnabled, true);
            this.f9464l = typedArrayObtainStyledAttributes.getInteger(R.styleable.FastScroller_fastScrollerAutoHideDelayInMillis, 1000);
            this.f9467o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerBubbleEnabled, true);
            this.f9470r = typedArrayObtainStyledAttributes.getInteger(R.styleable.FastScroller_fastScrollerBubblePosition, 0);
            this.f9468p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerIgnoreTouchesOutsideHandle, false);
            this.f9469q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerHandleAlwaysVisible, false);
            typedArrayObtainStyledAttributes.recycle();
            i();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
