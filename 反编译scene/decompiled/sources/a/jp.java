package a;

import a.np;
import android.graphics.Canvas;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f6532a = new hp();
    public static final Interpolator b = new ip();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1575a = -1;

    public static int e(int i, int i2) {
        int i3;
        int i4 = i & 789516;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 << 2;
        } else {
            int i6 = i4 << 1;
            i5 |= (-789517) & i6;
            i3 = (i6 & 789516) << 2;
        }
        return i5 | i3;
    }

    public static int s(int i, int i2) {
        return i2 << (i * 8);
    }

    public static int t(int i, int i2) {
        return s(2, i) | s(1, i2) | s(0, i2 | i);
    }

    public void A(RecyclerView.d0 d0Var, int i) {
        if (d0Var != null) {
            pp.f7136a.c(d0Var.f4387a);
        }
    }

    public abstract void B(RecyclerView.d0 d0Var, int i);

    public boolean a(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        return true;
    }

    public RecyclerView.d0 b(RecyclerView.d0 d0Var, List<RecyclerView.d0> list, int i, int i2) {
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int right;
        int iAbs4;
        int width = i + d0Var.f4387a.getWidth();
        int height = i2 + d0Var.f4387a.getHeight();
        int left2 = i - d0Var.f4387a.getLeft();
        int top2 = i2 - d0Var.f4387a.getTop();
        int size = list.size();
        RecyclerView.d0 d0Var2 = null;
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.d0 d0Var3 = list.get(i4);
            if (left2 > 0 && (right = d0Var3.f4387a.getRight() - width) < 0 && d0Var3.f4387a.getRight() > d0Var.f4387a.getRight() && (iAbs4 = Math.abs(right)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs4;
            }
            if (left2 < 0 && (left = d0Var3.f4387a.getLeft() - i) > 0 && d0Var3.f4387a.getLeft() < d0Var.f4387a.getLeft() && (iAbs3 = Math.abs(left)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs3;
            }
            if (top2 < 0 && (top = d0Var3.f4387a.getTop() - i2) > 0 && d0Var3.f4387a.getTop() < d0Var.f4387a.getTop() && (iAbs2 = Math.abs(top)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs2;
            }
            if (top2 > 0 && (bottom = d0Var3.f4387a.getBottom() - height) < 0 && d0Var3.f4387a.getBottom() > d0Var.f4387a.getBottom() && (iAbs = Math.abs(bottom)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs;
            }
        }
        return d0Var2;
    }

    public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        pp.f7136a.b(d0Var.f4387a);
    }

    public int d(int i, int i2) {
        int i3;
        int i4 = i & 3158064;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 >> 2;
        } else {
            int i6 = i4 >> 1;
            i5 |= (-3158065) & i6;
            i3 = (i6 & 3158064) >> 2;
        }
        return i5 | i3;
    }

    public final int f(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return d(k(recyclerView, d0Var), eh.y(recyclerView));
    }

    public long g(RecyclerView recyclerView, int i, float f, float f2) {
        RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
        return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.n() : itemAnimator.o();
    }

    public int h() {
        return 0;
    }

    public final int i(RecyclerView recyclerView) {
        if (this.f1575a == -1) {
            this.f1575a = recyclerView.getResources().getDimensionPixelSize(Cdo.item_touch_helper_max_drag_scroll_per_frame);
        }
        return this.f1575a;
    }

    public float j(RecyclerView.d0 d0Var) {
        return 0.5f;
    }

    public abstract int k(RecyclerView recyclerView, RecyclerView.d0 d0Var);

    public float l(float f) {
        return f;
    }

    public float m(RecyclerView.d0 d0Var) {
        return 0.5f;
    }

    public float n(float f) {
        return f;
    }

    public boolean o(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return (f(recyclerView, d0Var) & 16711680) != 0;
    }

    public int p(RecyclerView recyclerView, int i, int i2, int i3, long j) {
        int iSignum = (int) (((int) (((int) Math.signum(i2)) * i(recyclerView) * b.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * f6532a.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f));
        return iSignum == 0 ? i2 > 0 ? 1 : -1 : iSignum;
    }

    public abstract boolean q();

    public abstract boolean r();

    public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        pp.f7136a.a(canvas, recyclerView, d0Var.f4387a, f, f2, i, z);
    }

    public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        pp.f7136a.d(canvas, recyclerView, d0Var.f4387a, f, f2, i, z);
    }

    public void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<mp> list, int i, float f, float f2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            mp mpVar = list.get(i2);
            mpVar.e();
            int iSave = canvas.save();
            u(canvas, recyclerView, mpVar.f1973a, mpVar.e, mpVar.f, mpVar.f1971a, false);
            canvas.restoreToCount(iSave);
        }
        if (d0Var != null) {
            int iSave2 = canvas.save();
            u(canvas, recyclerView, d0Var, f, f2, i, true);
            canvas.restoreToCount(iSave2);
        }
    }

    public void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<mp> list, int i, float f, float f2) {
        int size = list.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            mp mpVar = list.get(i2);
            int iSave = canvas.save();
            v(canvas, recyclerView, mpVar.f1973a, mpVar.e, mpVar.f, mpVar.f1971a, false);
            canvas.restoreToCount(iSave);
        }
        if (d0Var != null) {
            int iSave2 = canvas.save();
            v(canvas, recyclerView, d0Var, f, f2, i, true);
            canvas.restoreToCount(iSave2);
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            mp mpVar2 = list.get(i3);
            if (mpVar2.f1976c && !mpVar2.f1974a) {
                list.remove(i3);
            } else if (!mpVar2.f1976c) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    public abstract boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2);

    /* JADX WARN: Multi-variable type inference failed */
    public void z(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i, RecyclerView.d0 d0Var2, int i2, int i3, int i4) {
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof np.a) {
            ((np.a) layoutManager).g(d0Var.f4387a, d0Var2.f4387a, i3, i4);
            return;
        }
        if (layoutManager.u()) {
            if (layoutManager.a0(d0Var2.f4387a) <= recyclerView.getPaddingLeft()) {
                recyclerView.h1(i2);
            }
            if (layoutManager.d0(d0Var2.f4387a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                recyclerView.h1(i2);
            }
        }
        if (layoutManager.v()) {
            if (layoutManager.e0(d0Var2.f4387a) <= recyclerView.getPaddingTop()) {
                recyclerView.h1(i2);
            }
            if (layoutManager.Y(d0Var2.f4387a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                recyclerView.h1(i2);
            }
        }
    }
}
