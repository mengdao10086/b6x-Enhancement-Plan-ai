package a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class np extends RecyclerView.n implements RecyclerView.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ag f2132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jp f2133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kp f2134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f2135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f2136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView f2141a;
    public float b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f2147c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<RecyclerView.d0> f2148c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f2149d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public List<Integer> f2150d;
    public float e;
    public float f;
    public float g;
    public float h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<View> f2143a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f2144a = new float[2];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.d0 f2138a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2130a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2145b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<mp> f2146b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f2142a = new cp(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.j f2139a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2137a = null;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f2151e = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RecyclerView.s f2140a = new dp(this);

    public interface a {
        void g(View view, View view2, int i, int i2);
    }

    public np(jp jpVar) {
        this.f2133a = jpVar;
    }

    public static boolean x(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    public void A(mp mpVar, int i) {
        this.f2141a.post(new fp(this, mpVar, i));
    }

    public final void B() {
        VelocityTracker velocityTracker = this.f2136a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2136a = null;
        }
    }

    public void C(View view) {
        if (view == this.f2137a) {
            this.f2137a = null;
            if (this.f2139a != null) {
                this.f2141a.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean D() {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.np.D():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E(androidx.recyclerview.widget.RecyclerView.d0 r24, int r25) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.np.E(androidx.recyclerview.widget.RecyclerView$d0, int):void");
    }

    public final void F() {
        this.f2149d = ViewConfiguration.get(this.f2141a.getContext()).getScaledTouchSlop();
        this.f2141a.h(this);
        this.f2141a.k(this.f2140a);
        this.f2141a.j(this);
        G();
    }

    public final void G() {
        this.f2134a = new kp(this);
        this.f2132a = new ag(this.f2141a.getContext(), this.f2134a);
    }

    public final void H() {
        kp kpVar = this.f2134a;
        if (kpVar != null) {
            kpVar.a();
            this.f2134a = null;
        }
        if (this.f2132a != null) {
            this.f2132a = null;
        }
    }

    public final int I(RecyclerView.d0 d0Var) {
        if (this.f2145b == 2) {
            return 0;
        }
        int iK = this.f2133a.k(this.f2141a, d0Var);
        int iD = (this.f2133a.d(iK, eh.y(this.f2141a)) & 65280) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i = (iK & 65280) >> 8;
        if (Math.abs(this.e) > Math.abs(this.f)) {
            int iM = m(d0Var, iD);
            if (iM > 0) {
                return (i & iM) == 0 ? jp.e(iM, eh.y(this.f2141a)) : iM;
            }
            int iO = o(d0Var, iD);
            if (iO > 0) {
                return iO;
            }
        } else {
            int iO2 = o(d0Var, iD);
            if (iO2 > 0) {
                return iO2;
            }
            int iM2 = m(d0Var, iD);
            if (iM2 > 0) {
                return (i & iM2) == 0 ? jp.e(iM2, eh.y(this.f2141a)) : iM2;
            }
        }
        return 0;
    }

    public void J(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f6939a;
        this.e = f;
        this.f = y - this.b;
        if ((i & 4) == 0) {
            this.e = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.e = Math.min(0.0f, this.e);
        }
        if ((i & 1) == 0) {
            this.f = Math.max(0.0f, this.f);
        }
        if ((i & 2) == 0) {
            this.f = Math.min(0.0f, this.f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
        C(view);
        RecyclerView.d0 d0VarF0 = this.f2141a.f0(view);
        if (d0VarF0 == null) {
            return;
        }
        RecyclerView.d0 d0Var = this.f2138a;
        if (d0Var != null && d0VarF0 == d0Var) {
            E(null, 0);
            return;
        }
        q(d0VarF0, false);
        if (this.f2143a.remove(d0VarF0.f4387a)) {
            this.f2133a.c(this.f2141a, d0VarF0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void e(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f;
        float f2;
        this.f2151e = -1;
        if (this.f2138a != null) {
            v(this.f2144a);
            float[] fArr = this.f2144a;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f2133a.w(canvas, recyclerView, this.f2138a, this.f2146b, this.f2145b, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void j(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f;
        float f2;
        if (this.f2138a != null) {
            v(this.f2144a);
            float[] fArr = this.f2144a;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f2133a.x(canvas, recyclerView, this.f2138a, this.f2146b, this.f2145b, f, f2);
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.f2139a == null) {
            this.f2139a = new gp(this);
        }
        this.f2141a.setChildDrawingOrderCallback(this.f2139a);
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2141a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            p();
        }
        this.f2141a = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.c = resources.getDimension(Cdo.item_touch_helper_swipe_escape_velocity);
            this.d = resources.getDimension(Cdo.item_touch_helper_swipe_escape_max_velocity);
            F();
        }
    }

    public final int m(RecyclerView.d0 d0Var, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.e > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f2136a;
        if (velocityTracker != null && this.f2130a > -1) {
            jp jpVar = this.f2133a;
            float f = this.d;
            jpVar.n(f);
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.f2136a.getXVelocity(this.f2130a);
            float yVelocity = this.f2136a.getYVelocity(this.f2130a);
            int i3 = xVelocity <= 0.0f ? 4 : 8;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3) {
                jp jpVar2 = this.f2133a;
                float f2 = this.c;
                jpVar2.l(f2);
                if (fAbs >= f2 && fAbs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
        }
        float width = this.f2141a.getWidth() * this.f2133a.m(d0Var);
        if ((i & i2) == 0 || Math.abs(this.e) <= width) {
            return 0;
        }
        return i2;
    }

    public void n(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.d0 d0VarU;
        int iF;
        if (this.f2138a != null || i != 2 || this.f2145b == 2 || !this.f2133a.q() || this.f2141a.getScrollState() == 1 || (d0VarU = u(motionEvent)) == null || (iF = (this.f2133a.f(this.f2141a, d0VarU) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.f6939a;
        float f2 = y - this.b;
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        int i3 = this.f2149d;
        if (fAbs >= i3 || fAbs2 >= i3) {
            if (fAbs > fAbs2) {
                if (f < 0.0f && (iF & 4) == 0) {
                    return;
                }
                if (f > 0.0f && (iF & 8) == 0) {
                    return;
                }
            } else {
                if (f2 < 0.0f && (iF & 1) == 0) {
                    return;
                }
                if (f2 > 0.0f && (iF & 2) == 0) {
                    return;
                }
            }
            this.f = 0.0f;
            this.e = 0.0f;
            this.f2130a = motionEvent.getPointerId(0);
            E(d0VarU, 1);
        }
    }

    public final int o(RecyclerView.d0 d0Var, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.f > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f2136a;
        if (velocityTracker != null && this.f2130a > -1) {
            jp jpVar = this.f2133a;
            float f = this.d;
            jpVar.n(f);
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.f2136a.getXVelocity(this.f2130a);
            float yVelocity = this.f2136a.getYVelocity(this.f2130a);
            int i3 = yVelocity <= 0.0f ? 1 : 2;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2) {
                jp jpVar2 = this.f2133a;
                float f2 = this.c;
                jpVar2.l(f2);
                if (fAbs >= f2 && fAbs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
        }
        float height = this.f2141a.getHeight() * this.f2133a.m(d0Var);
        if ((i & i2) == 0 || Math.abs(this.f) <= height) {
            return 0;
        }
        return i2;
    }

    public final void p() {
        this.f2141a.V0(this);
        this.f2141a.X0(this.f2140a);
        this.f2141a.W0(this);
        for (int size = this.f2146b.size() - 1; size >= 0; size--) {
            this.f2133a.c(this.f2141a, this.f2146b.get(0).f1973a);
        }
        this.f2146b.clear();
        this.f2137a = null;
        this.f2151e = -1;
        B();
        H();
    }

    public void q(RecyclerView.d0 d0Var, boolean z) {
        for (int size = this.f2146b.size() - 1; size >= 0; size--) {
            mp mpVar = this.f2146b.get(size);
            if (mpVar.f1973a == d0Var) {
                mpVar.f1975b |= z;
                if (!mpVar.f1976c) {
                    mpVar.a();
                }
                this.f2146b.remove(size);
                return;
            }
        }
    }

    public mp r(MotionEvent motionEvent) {
        if (this.f2146b.isEmpty()) {
            return null;
        }
        View viewS = s(motionEvent);
        for (int size = this.f2146b.size() - 1; size >= 0; size--) {
            mp mpVar = this.f2146b.get(size);
            if (mpVar.f1973a.f4387a == viewS) {
                return mpVar;
            }
        }
        return null;
    }

    public View s(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.d0 d0Var = this.f2138a;
        if (d0Var != null) {
            View view = d0Var.f4387a;
            if (x(view, x, y, this.g + this.e, this.h + this.f)) {
                return view;
            }
        }
        for (int size = this.f2146b.size() - 1; size >= 0; size--) {
            mp mpVar = this.f2146b.get(size);
            View view2 = mpVar.f1973a.f4387a;
            if (x(view2, x, y, mpVar.e, mpVar.f)) {
                return view2;
            }
        }
        return this.f2141a.S(x, y);
    }

    public final List<RecyclerView.d0> t(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List<RecyclerView.d0> list = this.f2148c;
        if (list == null) {
            this.f2148c = new ArrayList();
            this.f2150d = new ArrayList();
        } else {
            list.clear();
            this.f2150d.clear();
        }
        int iH = this.f2133a.h();
        int iRound = Math.round(this.g + this.e) - iH;
        int iRound2 = Math.round(this.h + this.f) - iH;
        int i = iH * 2;
        int width = d0Var2.f4387a.getWidth() + iRound + i;
        int height = d0Var2.f4387a.getHeight() + iRound2 + i;
        int i2 = (iRound + width) / 2;
        int i3 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.f2141a.getLayoutManager();
        int iT = layoutManager.T();
        int i4 = 0;
        while (i4 < iT) {
            View viewS = layoutManager.S(i4);
            if (viewS != d0Var2.f4387a && viewS.getBottom() >= iRound2 && viewS.getTop() <= height && viewS.getRight() >= iRound && viewS.getLeft() <= width) {
                RecyclerView.d0 d0VarF0 = this.f2141a.f0(viewS);
                if (this.f2133a.a(this.f2141a, this.f2138a, d0VarF0)) {
                    int iAbs = Math.abs(i2 - ((viewS.getLeft() + viewS.getRight()) / 2));
                    int iAbs2 = Math.abs(i3 - ((viewS.getTop() + viewS.getBottom()) / 2));
                    int i5 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f2148c.size();
                    int i6 = 0;
                    for (int i7 = 0; i7 < size && i5 > this.f2150d.get(i7).intValue(); i7++) {
                        i6++;
                    }
                    this.f2148c.add(i6, d0VarF0);
                    this.f2150d.add(i6, Integer.valueOf(i5));
                }
            }
            i4++;
            d0Var2 = d0Var;
        }
        return this.f2148c;
    }

    public final RecyclerView.d0 u(MotionEvent motionEvent) {
        View viewS;
        RecyclerView.o layoutManager = this.f2141a.getLayoutManager();
        int i = this.f2130a;
        if (i == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(iFindPointerIndex) - this.f6939a;
        float y = motionEvent.getY(iFindPointerIndex) - this.b;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        int i2 = this.f2149d;
        if (fAbs < i2 && fAbs2 < i2) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.u()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.v()) && (viewS = s(motionEvent)) != null) {
            return this.f2141a.f0(viewS);
        }
        return null;
    }

    public final void v(float[] fArr) {
        if ((this.f2147c & 12) != 0) {
            fArr[0] = (this.g + this.e) - this.f2138a.f4387a.getLeft();
        } else {
            fArr[0] = this.f2138a.f4387a.getTranslationX();
        }
        if ((this.f2147c & 3) != 0) {
            fArr[1] = (this.h + this.f) - this.f2138a.f4387a.getTop();
        } else {
            fArr[1] = this.f2138a.f4387a.getTranslationY();
        }
    }

    public boolean w() {
        int size = this.f2146b.size();
        for (int i = 0; i < size; i++) {
            if (!this.f2146b.get(i).f1976c) {
                return true;
            }
        }
        return false;
    }

    public void y(RecyclerView.d0 d0Var) {
        if (!this.f2141a.isLayoutRequested() && this.f2145b == 2) {
            float fJ = this.f2133a.j(d0Var);
            int i = (int) (this.g + this.e);
            int i2 = (int) (this.h + this.f);
            if (Math.abs(i2 - d0Var.f4387a.getTop()) >= d0Var.f4387a.getHeight() * fJ || Math.abs(i - d0Var.f4387a.getLeft()) >= d0Var.f4387a.getWidth() * fJ) {
                List<RecyclerView.d0> listT = t(d0Var);
                if (listT.size() == 0) {
                    return;
                }
                RecyclerView.d0 d0VarB = this.f2133a.b(d0Var, listT, i, i2);
                if (d0VarB == null) {
                    this.f2148c.clear();
                    this.f2150d.clear();
                    return;
                }
                int iJ = d0VarB.j();
                int iJ2 = d0Var.j();
                if (this.f2133a.y(this.f2141a, d0Var, d0VarB)) {
                    this.f2133a.z(this.f2141a, d0Var, iJ2, d0VarB, iJ, i, i2);
                }
            }
        }
    }

    public void z() {
        VelocityTracker velocityTracker = this.f2136a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f2136a = VelocityTracker.obtain();
    }
}
