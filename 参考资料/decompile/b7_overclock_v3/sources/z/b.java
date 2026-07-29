package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.motion.widget.t;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.d;
import g.v0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b extends p {
    public static final String C1 = "Carousel";
    public static final int K1 = 1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final boolean f57562v1 = false;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f57563v2 = 2;
    public int A;
    public int B;
    public float C;
    public int D;
    public int K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f57564k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public Runnable f57565k1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public InterfaceC0680b f57566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<View> f57567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f57568p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f57569q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MotionLayout f57570r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f57571s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f57572t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f57573u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f57574v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f57575w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f57576x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f57577y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f57578z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: z.b$a$a, reason: collision with other inner class name */
        public class RunnableC0679a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f57580a;

            public RunnableC0679a(final float val$v) {
                this.f57580a = val$v;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f57570r.h1(5, 1.0f, this.f57580a);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f57570r.setProgress(0.0f);
            b.this.a0();
            b.this.f57566n.a(b.this.f57569q);
            float velocity = b.this.f57570r.getVelocity();
            if (b.this.B != 2 || velocity <= b.this.C || b.this.f57569q >= b.this.f57566n.count() - 1) {
                return;
            }
            float f10 = velocity * b.this.f57577y;
            if (b.this.f57569q != 0 || b.this.f57568p <= b.this.f57569q) {
                if (b.this.f57569q != b.this.f57566n.count() - 1 || b.this.f57568p >= b.this.f57569q) {
                    b.this.f57570r.post(new RunnableC0679a(f10));
                }
            }
        }
    }

    /* JADX INFO: renamed from: z.b$b, reason: collision with other inner class name */
    public interface InterfaceC0680b {
        void a(int index);

        void b(View view, int index);

        int count();
    }

    public b(Context context) {
        super(context);
        this.f57566n = null;
        this.f57567o = new ArrayList<>();
        this.f57568p = 0;
        this.f57569q = 0;
        this.f57571s = -1;
        this.f57572t = false;
        this.f57573u = -1;
        this.f57574v = -1;
        this.f57575w = -1;
        this.f57576x = -1;
        this.f57577y = 0.9f;
        this.f57578z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.f57564k0 = 200;
        this.K0 = -1;
        this.f57565k1 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.f57570r.setTransitionDuration(this.f57564k0);
        if (this.D < this.f57569q) {
            this.f57570r.n1(this.f57575w, this.f57564k0);
        } else {
            this.f57570r.n1(this.f57576x, this.f57564k0);
        }
    }

    public final void T(boolean enable) {
        Iterator<t.b> it2 = this.f57570r.getDefinedTransitions().iterator();
        while (it2.hasNext()) {
            it2.next().Q(enable);
        }
    }

    public final boolean U(int transitionID, boolean enable) {
        MotionLayout motionLayout;
        t.b bVarL0;
        if (transitionID == -1 || (motionLayout = this.f57570r) == null || (bVarL0 = motionLayout.L0(transitionID)) == null || enable == bVarL0.K()) {
            return false;
        }
        bVarL0.Q(enable);
        return true;
    }

    public final void V(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.f57571s = typedArrayObtainStyledAttributes.getResourceId(index, this.f57571s);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.f57573u = typedArrayObtainStyledAttributes.getResourceId(index, this.f57573u);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.f57574v = typedArrayObtainStyledAttributes.getResourceId(index, this.f57574v);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.A = typedArrayObtainStyledAttributes.getInt(index, this.A);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.f57575w = typedArrayObtainStyledAttributes.getResourceId(index, this.f57575w);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.f57576x = typedArrayObtainStyledAttributes.getResourceId(index, this.f57576x);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f57577y = typedArrayObtainStyledAttributes.getFloat(index, this.f57577y);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.B = typedArrayObtainStyledAttributes.getInt(index, this.B);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.C = typedArrayObtainStyledAttributes.getFloat(index, this.C);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.f57572t = typedArrayObtainStyledAttributes.getBoolean(index, this.f57572t);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void W(int index) {
        this.f57569q = Math.max(0, Math.min(getCount() - 1, index));
        Y();
    }

    public void Y() {
        int size = this.f57567o.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = this.f57567o.get(i10);
            if (this.f57566n.count() == 0) {
                c0(view, this.A);
            } else {
                c0(view, 0);
            }
        }
        this.f57570r.Z0();
        a0();
    }

    public void Z(int index, int delay) {
        this.D = Math.max(0, Math.min(getCount() - 1, index));
        int iMax = Math.max(0, delay);
        this.f57564k0 = iMax;
        this.f57570r.setTransitionDuration(iMax);
        if (index < this.f57569q) {
            this.f57570r.n1(this.f57575w, this.f57564k0);
        } else {
            this.f57570r.n1(this.f57576x, this.f57564k0);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.p, androidx.constraintlayout.motion.widget.MotionLayout.l
    public void a(MotionLayout motionLayout, int startId, int endId, float progress) {
        this.K0 = startId;
    }

    public final void a0() {
        InterfaceC0680b interfaceC0680b = this.f57566n;
        if (interfaceC0680b == null || this.f57570r == null || interfaceC0680b.count() == 0) {
            return;
        }
        int size = this.f57567o.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = this.f57567o.get(i10);
            int iCount = (this.f57569q + i10) - this.f57578z;
            if (this.f57572t) {
                if (iCount < 0) {
                    int i11 = this.A;
                    if (i11 != 4) {
                        c0(view, i11);
                    } else {
                        c0(view, 0);
                    }
                    if (iCount % this.f57566n.count() == 0) {
                        this.f57566n.b(view, 0);
                    } else {
                        InterfaceC0680b interfaceC0680b2 = this.f57566n;
                        interfaceC0680b2.b(view, interfaceC0680b2.count() + (iCount % this.f57566n.count()));
                    }
                } else if (iCount >= this.f57566n.count()) {
                    if (iCount == this.f57566n.count()) {
                        iCount = 0;
                    } else if (iCount > this.f57566n.count()) {
                        iCount %= this.f57566n.count();
                    }
                    int i12 = this.A;
                    if (i12 != 4) {
                        c0(view, i12);
                    } else {
                        c0(view, 0);
                    }
                    this.f57566n.b(view, iCount);
                } else {
                    c0(view, 0);
                    this.f57566n.b(view, iCount);
                }
            } else if (iCount < 0) {
                c0(view, this.A);
            } else if (iCount >= this.f57566n.count()) {
                c0(view, this.A);
            } else {
                c0(view, 0);
                this.f57566n.b(view, iCount);
            }
        }
        int i13 = this.D;
        if (i13 != -1 && i13 != this.f57569q) {
            this.f57570r.post(new Runnable() { // from class: z.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f57561a.X();
                }
            });
        } else if (i13 == this.f57569q) {
            this.D = -1;
        }
        if (this.f57573u == -1 || this.f57574v == -1 || this.f57572t) {
            return;
        }
        int iCount2 = this.f57566n.count();
        if (this.f57569q == 0) {
            U(this.f57573u, false);
        } else {
            U(this.f57573u, true);
            this.f57570r.setTransition(this.f57573u);
        }
        if (this.f57569q == iCount2 - 1) {
            U(this.f57574v, false);
        } else {
            U(this.f57574v, true);
            this.f57570r.setTransition(this.f57574v);
        }
    }

    public final boolean b0(int constraintSetId, View view, int visibility) {
        d.a aVarK0;
        androidx.constraintlayout.widget.d dVarH0 = this.f57570r.H0(constraintSetId);
        if (dVarH0 == null || (aVarK0 = dVarH0.k0(view.getId())) == null) {
            return false;
        }
        aVarK0.f4293c.f4421c = 1;
        view.setVisibility(visibility);
        return true;
    }

    public final boolean c0(View view, int visibility) {
        MotionLayout motionLayout = this.f57570r;
        if (motionLayout == null) {
            return false;
        }
        boolean zB0 = false;
        for (int i10 : motionLayout.getConstraintSetIds()) {
            zB0 |= b0(i10, view, visibility);
        }
        return zB0;
    }

    public int getCount() {
        InterfaceC0680b interfaceC0680b = this.f57566n;
        if (interfaceC0680b != null) {
            return interfaceC0680b.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.f57569q;
    }

    @Override // androidx.constraintlayout.motion.widget.p, androidx.constraintlayout.motion.widget.MotionLayout.l
    public void k(MotionLayout motionLayout, int currentId) {
        int i10 = this.f57569q;
        this.f57568p = i10;
        if (currentId == this.f57576x) {
            this.f57569q = i10 + 1;
        } else if (currentId == this.f57575w) {
            this.f57569q = i10 - 1;
        }
        if (this.f57572t) {
            if (this.f57569q >= this.f57566n.count()) {
                this.f57569q = 0;
            }
            if (this.f57569q < 0) {
                this.f57569q = this.f57566n.count() - 1;
            }
        } else {
            if (this.f57569q >= this.f57566n.count()) {
                this.f57569q = this.f57566n.count() - 1;
            }
            if (this.f57569q < 0) {
                this.f57569q = 0;
            }
        }
        if (this.f57568p != this.f57569q) {
            this.f57570r.post(this.f57565k1);
        }
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    @v0(api = 17)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i10 = 0; i10 < this.f4170b; i10++) {
                int i11 = this.f4169a[i10];
                View viewS = motionLayout.s(i11);
                if (this.f57571s == i11) {
                    this.f57578z = i10;
                }
                this.f57567o.add(viewS);
            }
            this.f57570r = motionLayout;
            if (this.B == 2) {
                t.b bVarL0 = motionLayout.L0(this.f57574v);
                if (bVarL0 != null) {
                    bVarL0.U(5);
                }
                t.b bVarL02 = this.f57570r.L0(this.f57573u);
                if (bVarL02 != null) {
                    bVarL02.U(5);
                }
            }
            a0();
        }
    }

    public void setAdapter(InterfaceC0680b adapter) {
        this.f57566n = adapter;
    }

    public b(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f57566n = null;
        this.f57567o = new ArrayList<>();
        this.f57568p = 0;
        this.f57569q = 0;
        this.f57571s = -1;
        this.f57572t = false;
        this.f57573u = -1;
        this.f57574v = -1;
        this.f57575w = -1;
        this.f57576x = -1;
        this.f57577y = 0.9f;
        this.f57578z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.f57564k0 = 200;
        this.K0 = -1;
        this.f57565k1 = new a();
        V(context, attrs);
    }

    public b(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f57566n = null;
        this.f57567o = new ArrayList<>();
        this.f57568p = 0;
        this.f57569q = 0;
        this.f57571s = -1;
        this.f57572t = false;
        this.f57573u = -1;
        this.f57574v = -1;
        this.f57575w = -1;
        this.f57576x = -1;
        this.f57577y = 0.9f;
        this.f57578z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.f57564k0 = 200;
        this.K0 = -1;
        this.f57565k1 = new a();
        V(context, attrs);
    }
}
