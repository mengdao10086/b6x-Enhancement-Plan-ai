package z7;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class b0 extends y7.b {
    public static final int C = 0;
    public static final int D = 1;
    public static final int K0 = 3;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f57787k0 = 2;
    public int A;
    public int B;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f57788p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f57789q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f57790r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f57791s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f57792t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f57793u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f57794v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f57795w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ObjectAnimator f57796x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f57797y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final View.OnTouchListener f57798z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: z7.b0$a$a, reason: collision with other inner class name */
        public class C0684a implements Animator.AnimatorListener {
            public C0684a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                b0.this.s0();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b0.this.l0()) {
                    animator.cancel();
                    b0.this.s0();
                } else if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
                    b0.this.f57788p.setAlpha(0.0f);
                } else {
                    b0.this.f57788p.setAlpha(0.6f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (b0.this.l0()) {
                    animator.cancel();
                    b0.this.s0();
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fB = com.blankj.utilcode.util.x0.b();
            float fA = com.blankj.utilcode.util.x0.a();
            int width = (b0.this.f57788p.getWidth() / 4) * 3;
            if (b0.this.f56480c.x <= b0.this.f57788p.getWidth()) {
                b0 b0Var = b0.this;
                b0Var.f57796x = ObjectAnimator.ofFloat(b0Var.f57788p, "translationX", b0.this.f57788p.getTranslationX(), -width);
            } else if (b0.this.f56480c.x >= fB - b0.this.f57788p.getWidth()) {
                b0 b0Var2 = b0.this;
                b0Var2.f57796x = ObjectAnimator.ofFloat(b0Var2.f57788p, "translationX", b0.this.f57788p.getTranslationX(), width);
            } else if (b0.this.f56480c.y <= b0.this.f57788p.getHeight()) {
                b0 b0Var3 = b0.this;
                b0Var3.f57796x = ObjectAnimator.ofFloat(b0Var3.f57788p, "translationY", b0.this.f57788p.getTranslationY(), -width);
            } else if (b0.this.f56480c.y >= fA - b0.this.f57788p.getHeight()) {
                b0 b0Var4 = b0.this;
                b0Var4.f57796x = ObjectAnimator.ofFloat(b0Var4.f57788p, "translationY", b0.this.f57788p.getTranslationY(), width);
            }
            if (b0.this.f57796x != null) {
                b0.this.f57796x.setDuration(50L);
                b0.this.f57796x.start();
                b0.this.f57796x.addListener(new C0684a());
            }
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(float f10, float f11) {
            b0.this.f57789q = true;
            b0.this.u0(-40, f10, f11, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(float f10, float f11) {
            b0.this.f57789q = true;
            b0.this.u0(40, f10, f11, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(float f10, float f11) {
            b0.this.f57789q = true;
            b0.this.u0(-40, f10, f11, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(float f10, float f11) {
            b0.this.f57789q = true;
            b0.this.u0(40, f10, f11, 3);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                b0.this.f57795w = false;
                b0.this.f57789q = false;
                b0.this.f57793u = motionEvent.getRawX();
                b0.this.f57794v = motionEvent.getRawY();
                b0.this.f57792t = System.currentTimeMillis();
            } else if (action == 1) {
                b0.this.f57795w = false;
                b0.this.f57789q = false;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Math.abs(motionEvent.getRawX() - b0.this.f57793u) >= 10.0f || Math.abs(motionEvent.getRawY() - b0.this.f57794v) >= 10.0f || jCurrentTimeMillis - b0.this.f57792t >= 500) {
                    final float fB = com.blankj.utilcode.util.x0.b();
                    final float fA = com.blankj.utilcode.util.x0.a();
                    float f10 = fA / 2.0f;
                    if (motionEvent.getRawX() > f10 || ((motionEvent.getRawY() > f10 || motionEvent.getRawX() > motionEvent.getRawY()) && (motionEvent.getRawY() <= f10 || motionEvent.getRawY() + motionEvent.getRawX() >= fA))) {
                        float f11 = fB - f10;
                        if (motionEvent.getRawX() > f11 && ((motionEvent.getRawY() <= f10 && (motionEvent.getRawX() - f11) + motionEvent.getRawY() > f10) || (motionEvent.getRawY() > f10 && motionEvent.getRawX() - f11 > motionEvent.getRawY() - f10))) {
                            b0.this.f56483f.postDelayed(new Runnable() { // from class: z7.f0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f57824a.f(fB, fA);
                                }
                            }, 25L);
                        } else if (motionEvent.getRawY() <= f10) {
                            b0.this.f56483f.postDelayed(new Runnable() { // from class: z7.c0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f57805a.g(fB, fA);
                                }
                            }, 25L);
                        } else if (motionEvent.getRawY() > f10) {
                            b0.this.f56483f.postDelayed(new Runnable() { // from class: z7.d0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f57812a.h(fB, fA);
                                }
                            }, 25L);
                        }
                    } else {
                        b0.this.f56483f.postDelayed(new Runnable() { // from class: z7.e0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f57820a.e(fB, fA);
                            }
                        }, 25L);
                    }
                } else if (b0.this.f57788p.getX() != 0.0f || b0.this.f57788p.getY() != 0.0f) {
                    b0.this.s0();
                    b0.this.m0();
                } else if (!k0.f57859r) {
                    HashMap map = new HashMap();
                    map.put("action", "呼出菜单-触屏");
                    u9.g.a().e(b0.this.f56478a, "Float_View_Select_Menu_Function_Click", map);
                    b0.this.t0();
                }
            } else if (action == 2) {
                b0.this.f57795w = true;
                if ((Math.abs(motionEvent.getRawX() - b0.this.f57793u) > 10.0f || Math.abs(motionEvent.getRawY() - b0.this.f57794v) > 10.0f || System.currentTimeMillis() - b0.this.f57792t > 500) && (b0.this.f57788p.getAlpha() < 1.0f || b0.this.f57788p.getX() != 0.0f || b0.this.f57788p.getY() != 0.0f)) {
                    b0.this.s0();
                }
                b0.this.f57789q = false;
                b0.this.f56480c.x = (int) (motionEvent.getRawX() - (view.getWidth() / 2));
                b0.this.f56480c.y = (int) (motionEvent.getRawY() - (view.getHeight() / 2));
                try {
                    b0.this.f56481d.updateViewLayout(b0.this.f56479b, b0.this.f56480c);
                } catch (Exception unused) {
                }
            }
            return true;
        }
    }

    public b0(Context context, Handler handler, String str) {
        super(context, (y7.n) null, handler);
        this.f57790r = 40;
        this.f57792t = 0L;
        this.f57793u = 0.0f;
        this.f57794v = 0.0f;
        this.f57796x = null;
        this.f57797y = new a();
        this.f57798z = new b();
        this.A = -10000;
        this.B = -10000;
        this.f57791s = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        ObjectAnimator objectAnimator = this.f57796x;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        int i10;
        int i11 = this.A;
        if (i11 == -10000 || (i10 = this.B) == -10000) {
            String strR = o5.m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_BALL_POSITION_PREFIX + this.f57791s, "");
            if (com.blankj.utilcode.util.n0.m(strR)) {
                int iB = (int) ((com.blankj.utilcode.util.x0.b() / 3.0f) * 2.0f);
                this.A = iB;
                this.B = 0;
                WindowManager.LayoutParams layoutParams = this.f56480c;
                layoutParams.x = iB;
                layoutParams.y = 0;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(strR);
                    this.A = jSONObject.getInt("x");
                    int i12 = jSONObject.getInt("y");
                    this.B = i12;
                    WindowManager.LayoutParams layoutParams2 = this.f56480c;
                    layoutParams2.x = this.A;
                    layoutParams2.y = i12;
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        } else {
            WindowManager.LayoutParams layoutParams3 = this.f56480c;
            layoutParams3.x = i11;
            layoutParams3.y = i10;
        }
        try {
            this.f56481d.updateViewLayout(this.f56479b, this.f56480c);
        } catch (Exception unused) {
        }
        if (!o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
            this.f57788p.setVisibility(0);
        }
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0() {
        ObjectAnimator objectAnimator = this.f57796x;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0() {
        try {
            this.f56481d.updateViewLayout(this.f56479b, this.f56480c);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(int i10, int i11, float f10, float f11) {
        boolean z10;
        while (this.f57789q) {
            if (i10 == 0) {
                WindowManager.LayoutParams layoutParams = this.f56480c;
                int i12 = layoutParams.x;
                z10 = i12 > 0;
                layoutParams.x = i12 + i11;
            } else if (i10 == 1) {
                WindowManager.LayoutParams layoutParams2 = this.f56480c;
                int i13 = layoutParams2.x;
                z10 = ((float) i13) < f10;
                layoutParams2.x = i13 + i11;
            } else if (i10 == 2) {
                WindowManager.LayoutParams layoutParams3 = this.f56480c;
                int i14 = layoutParams3.y;
                z10 = i14 > 0;
                layoutParams3.y = i14 + i11;
            } else if (i10 != 3) {
                z10 = false;
            } else {
                WindowManager.LayoutParams layoutParams4 = this.f56480c;
                int i15 = layoutParams4.y;
                z10 = ((float) i15) < f11;
                layoutParams4.y = i15 + i11;
            }
            if (z10) {
                try {
                    Thread.sleep(20L);
                    this.f56483f.post(new Runnable() { // from class: z7.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f57913a.q0();
                        }
                    });
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } else {
                this.f57789q = false;
                WindowManager.LayoutParams layoutParams5 = this.f56480c;
                this.A = layoutParams5.x;
                this.B = layoutParams5.y;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", this.A);
                    jSONObject.put("y", this.B);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
                o5.m.l(DataConstant.SP_FLOAT, 2).C(DataConstant.SP_FLOAT_BALL_POSITION_PREFIX + this.f57791s, jSONObject.toString(), true);
                m0();
            }
        }
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_float_ball;
    }

    public final boolean l0() {
        return this.f57795w || (this.f56480c.x > this.f57788p.getWidth() && ((float) this.f56480c.x) < ((float) com.blankj.utilcode.util.x0.b()) - ((float) this.f57788p.getWidth()) && this.f56480c.y < this.f57788p.getHeight() && ((float) this.f56480c.y) > ((float) com.blankj.utilcode.util.x0.a()) - ((float) this.f57788p.getHeight()));
    }

    public final void m0() {
        this.f56483f.post(new Runnable() { // from class: z7.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f57918a.n0();
            }
        });
        this.f56483f.removeCallbacks(this.f57797y);
        this.f56483f.postDelayed(this.f57797y, 2000L);
    }

    @Override // y7.b
    public void n() {
        ImageView imageView = (ImageView) this.f56479b.findViewById(R.id.iv_float_ball);
        this.f57788p = imageView;
        imageView.setVisibility(4);
        this.f57788p.setOnTouchListener(this.f57798z);
        com.blankj.utilcode.util.o.z(this.f57788p, 100);
        if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false)) {
            return;
        }
        y();
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(3);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }

    public final void s0() {
        this.f57788p.setX(0.0f);
        this.f57788p.setY(0.0f);
        this.f57788p.setAlpha(1.0f);
    }

    public final void t0() {
        this.f57788p.setVisibility(4);
        s0();
        this.f56483f.post(new Runnable() { // from class: z7.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f57915a.p0();
            }
        });
        this.f56483f.removeCallbacks(this.f57797y);
        q(21);
    }

    public final void u0(final int i10, final float f10, final float f11, final int i11) {
        new Thread(new Runnable() { // from class: z7.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f57776a.r0(i11, i10, f10, f11);
            }
        }).start();
    }

    @Override // y7.b
    public void y() {
        super.y();
        u9.b.x(this.f56478a);
        u9.b.u(this.f56478a);
        ImageView imageView = this.f57788p;
        if (imageView == null) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            this.f56483f.postDelayed(new Runnable() { // from class: z7.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f57916a.o0();
                }
            }, 10L);
        } else {
            s0();
            m0();
        }
    }
}
