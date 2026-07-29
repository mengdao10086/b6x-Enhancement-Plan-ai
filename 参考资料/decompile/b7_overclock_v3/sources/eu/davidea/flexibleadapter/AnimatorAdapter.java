package eu.davidea.flexibleadapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import g.f0;
import g.n0;
import gi.d;
import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AnimatorAdapter extends eu.davidea.flexibleadapter.c {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f27217z = 300;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f27219m;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Interpolator f27218l = new LinearInterpolator();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f27220n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SparseArray<Animator> f27221o = new SparseArray<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f27222p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f27223q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EnumSet<AnimatorEnum> f27224r = EnumSet.noneOf(AnimatorEnum.class);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f27225s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f27226t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f27227u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f27228v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f27229w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f27230x = 100;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f27231y = f27217z;

    public enum AnimatorEnum {
        ALPHA,
        SLIDE_IN_LEFT,
        SLIDE_IN_RIGHT,
        SLIDE_IN_BOTTOM,
        SLIDE_IN_TOP,
        SCALE
    }

    public class b extends RecyclerView.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f27232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Handler f27233b;

        public class a implements Handler.Callback {
            public a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                b.this.f27232a = false;
                return true;
            }
        }

        public b() {
            this.f27233b = new Handler(Looper.getMainLooper(), new a());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i10, int i11) {
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            j();
        }

        public void h() {
            if (this.f27232a) {
                this.f27233b.removeCallbacksAndMessages(null);
                Handler handler = this.f27233b;
                handler.sendMessageDelayed(Message.obtain(handler), 200L);
            }
        }

        public boolean i() {
            return this.f27232a;
        }

        public final void j() {
            this.f27232a = true;
        }
    }

    public class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f27236a;

        public c(int i10) {
            this.f27236a = i10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimatorAdapter.this.f27221o.remove(this.f27236a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public AnimatorAdapter(boolean z10) {
        setHasStableIds(z10);
        this.f27323a.d("Initialized with StableIds=" + z10, new Object[0]);
        b bVar = new b();
        this.f27219m = bVar;
        registerAdapterDataObserver(bVar);
    }

    public final void P(RecyclerView.e0 e0Var, int i10) {
        RecyclerView recyclerView = this.f27328f;
        if (recyclerView == null) {
            return;
        }
        if (this.f27223q < recyclerView.getChildCount()) {
            this.f27223q = this.f27328f.getChildCount();
        }
        if (this.f27227u && this.f27222p >= this.f27223q) {
            this.f27226t = false;
        }
        int iD = s().d();
        if ((this.f27226t || this.f27225s) && !this.f27330h && (e0Var instanceof d) && ((!this.f27219m.i() || V(i10)) && (V(i10) || ((this.f27226t && i10 > iD) || ((this.f27225s && i10 < iD) || (i10 == 0 && this.f27223q == 0)))))) {
            int iHashCode = e0Var.itemView.hashCode();
            R(iHashCode);
            ArrayList<Animator> arrayList = new ArrayList();
            ((d) e0Var).l(arrayList, i10, i10 >= iD);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(this.f27218l);
            long duration = this.f27231y;
            for (Animator animator : arrayList) {
                if (animator.getDuration() != f27217z) {
                    duration = animator.getDuration();
                }
            }
            animatorSet.setDuration(duration);
            animatorSet.addListener(new c(iHashCode));
            if (this.f27220n) {
                animatorSet.setStartDelay(Q(e0Var, i10));
            }
            animatorSet.start();
            this.f27221o.put(iHashCode, animatorSet);
        }
        this.f27219m.h();
        this.f27222p = i10;
    }

    public final long Q(RecyclerView.e0 e0Var, int i10) {
        int iA = s().a();
        int iF = s().f();
        if (iA < 0 && i10 >= 0) {
            iA = i10 - 1;
        }
        int i11 = i10 - 1;
        if (i11 > iF) {
            iF = i11;
        }
        int i12 = iF - iA;
        int i13 = this.f27223q;
        if (i13 != 0 && i12 >= i11 && ((iA <= 1 || iA > i13) && (i10 <= i13 || iA != -1 || this.f27328f.getChildCount() != 0))) {
            return this.f27229w + (((long) i10) * this.f27230x);
        }
        long j10 = this.f27230x;
        if (i12 <= 1) {
            j10 += this.f27229w;
        } else {
            this.f27229w = 0L;
        }
        int iE = s().e();
        return iE > 1 ? this.f27229w + (this.f27230x * ((long) (i10 % iE))) : j10;
    }

    public final void R(int i10) {
        Animator animator = this.f27221o.get(i10);
        if (animator != null) {
            animator.end();
        }
    }

    public boolean S() {
        return this.f27226t;
    }

    public boolean T() {
        return this.f27225s;
    }

    public boolean U() {
        return this.f27227u;
    }

    public abstract boolean V(int i10);

    public AnimatorAdapter W(@f0(from = 0) long j10) {
        this.f27323a.d("Set animationDelay=%s", Long.valueOf(j10));
        this.f27230x = j10;
        return this;
    }

    public AnimatorAdapter X(@f0(from = 1) long j10) {
        this.f27323a.d("Set animationDuration=%s", Long.valueOf(j10));
        this.f27231y = j10;
        return this;
    }

    public AnimatorAdapter Y(boolean z10) {
        this.f27323a.d("Set animationEntryStep=%s", Boolean.valueOf(z10));
        this.f27220n = z10;
        return this;
    }

    public AnimatorAdapter Z(long j10) {
        this.f27323a.d("Set animationInitialDelay=%s", Long.valueOf(j10));
        this.f27229w = j10;
        return this;
    }

    public AnimatorAdapter a0(@n0 Interpolator interpolator) {
        this.f27323a.d("Set animationInterpolator=%s", fi.a.e(interpolator));
        this.f27218l = interpolator;
        return this;
    }

    public AnimatorAdapter b0(boolean z10) {
        this.f27323a.d("Set animationOnForwardScrolling=%s", Boolean.valueOf(z10));
        if (z10) {
            this.f27227u = false;
        }
        this.f27226t = z10;
        return this;
    }

    public AnimatorAdapter c0(boolean z10) {
        this.f27323a.d("Set animationOnReverseScrolling=%s", Boolean.valueOf(z10));
        this.f27225s = z10;
        return this;
    }

    public AnimatorAdapter d0(boolean z10) {
        this.f27323a.d("Set onlyEntryAnimation=%s", Boolean.valueOf(z10));
        if (z10) {
            this.f27226t = true;
        }
        this.f27227u = z10;
        return this;
    }

    public void e0(boolean z10) {
        this.f27228v = z10;
    }
}
