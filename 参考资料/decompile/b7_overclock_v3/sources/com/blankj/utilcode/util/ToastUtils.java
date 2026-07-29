package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.util.j1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f11655l = "TAG_TOAST";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f11656m = -16777217;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f11657n = "toast null";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f11658o = "toast nothing";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ToastUtils f11659p = p();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static d f11660q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11662b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11663c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11664d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11665e = -16777217;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11666f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11667g = -16777217;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11668h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11669i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable[] f11670j = new Drawable[4];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11671k = false;

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f11672a = l1.w(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(l1.K() - f11672a, Integer.MIN_VALUE), i11);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f11674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CharSequence f11675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11676d;

        public a(View view, CharSequence charSequence, int i10) {
            this.f11674b = view;
            this.f11675c = charSequence;
            this.f11676d = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastUtils.l();
            d unused = ToastUtils.f11660q = ToastUtils.q(ToastUtils.this);
            if (this.f11674b != null) {
                ToastUtils.f11660q.c(this.f11674b);
            } else {
                ToastUtils.f11660q.b(this.f11675c);
            }
            ToastUtils.f11660q.a(this.f11676d);
        }
    }

    public static abstract class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Toast f11677a = new Toast(j1.a());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ToastUtils f11678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f11679c;

        public b(ToastUtils toastUtils) {
            this.f11678b = toastUtils;
            if (toastUtils.f11662b == -1 && this.f11678b.f11663c == -1 && this.f11678b.f11664d == -1) {
                return;
            }
            this.f11677a.setGravity(this.f11678b.f11662b, this.f11678b.f11663c, this.f11678b.f11664d);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.d
        public void b(CharSequence charSequence) {
            View viewX = this.f11678b.X(charSequence);
            if (viewX != null) {
                c(viewX);
                return;
            }
            View view = this.f11677a.getView();
            this.f11679c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                c(l1.G0(com.blankj.utilcode.R.layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f11679c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.f11678b.f11667g != -16777217) {
                textView.setTextColor(this.f11678b.f11667g);
            }
            if (this.f11678b.f11668h != -1) {
                textView.setTextSize(this.f11678b.f11668h);
            }
            d(textView);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.d
        public void c(View view) {
            this.f11679c = view;
            this.f11677a.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.d
        @g.i
        public void cancel() {
            Toast toast = this.f11677a;
            if (toast != null) {
                toast.cancel();
            }
            this.f11677a = null;
            this.f11679c = null;
        }

        public void d(TextView textView) {
            if (this.f11678b.f11666f != -1) {
                this.f11679c.setBackgroundResource(this.f11678b.f11666f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.f11678b.f11665e != -16777217) {
                Drawable background = this.f11679c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f11678b.f11665e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f11678b.f11665e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f11678b.f11665e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f11679c.setBackgroundColor(this.f11678b.f11665e);
                }
            }
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f11680e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j1.a f11681d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.cancel();
            }
        }

        public class b extends j1.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f11683a;

            public b(int i10) {
                this.f11683a = i10;
            }

            @Override // com.blankj.utilcode.util.j1.a
            public void a(@g.n0 Activity activity) {
                Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                if (c.this.h()) {
                    c.this.k(activity, this.f11683a, false);
                }
            }
        }

        public c(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.d
        public void a(int i10) {
            if (this.f11677a == null) {
                return;
            }
            if (!l1.r0()) {
                j(i10);
                return;
            }
            boolean z10 = false;
            for (Activity activity : l1.J()) {
                if (l1.p0(activity)) {
                    k(activity, f11680e, true);
                    z10 = true;
                }
            }
            if (!z10) {
                j(i10);
                return;
            }
            i();
            l1.V0(new a(), i10 == 0 ? 2000L : 3500L);
            f11680e++;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b, com.blankj.utilcode.util.ToastUtils.d
        public void cancel() {
            Window window;
            if (h()) {
                l();
                for (Activity activity : l1.J()) {
                    if (l1.p0(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ToastUtils.f11655l);
                        sb2.append(f11680e - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb2.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            super.cancel();
        }

        public final View g(int i10) {
            Bitmap bitmapF1 = l1.f1(this.f11679c);
            ImageView imageView = new ImageView(j1.a());
            imageView.setTag(ToastUtils.f11655l + i10);
            imageView.setImageBitmap(bitmapF1);
            return imageView;
        }

        public final boolean h() {
            return this.f11681d != null;
        }

        public final void i() {
            b bVar = new b(f11680e);
            this.f11681d = bVar;
            l1.b(bVar);
        }

        public final void j(int i10) {
            f fVar = new f(this.f11678b);
            fVar.f11677a = this.f11677a;
            fVar.a(i10);
        }

        public final void k(Activity activity, int i10, boolean z10) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f11677a.getGravity();
                layoutParams.bottomMargin = this.f11677a.getYOffset() + l1.a0();
                layoutParams.leftMargin = this.f11677a.getXOffset();
                View viewG = g(i10);
                if (z10) {
                    viewG.setAlpha(0.0f);
                    viewG.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewG, layoutParams);
            }
        }

        public final void l() {
            l1.S0(this.f11681d);
            this.f11681d = null;
        }
    }

    public interface d {
        void a(int i10);

        void b(CharSequence charSequence);

        void c(View view);

        void cancel();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
        public static final String G = "light";
        public static final String H = "dark";
    }

    public static final class f extends b {

        public static class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f11685a;

            public a(Handler handler) {
                this.f11685a = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(@g.n0 Message message) {
                Objects.requireNonNull(message, "Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                try {
                    this.f11685a.dispatchMessage(message);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@g.n0 Message message) {
                Objects.requireNonNull(message, "Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                this.f11685a.handleMessage(message);
            }
        }

        public f(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.f11677a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.d
        public void a(int i10) {
            Toast toast = this.f11677a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i10);
            this.f11677a.show();
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WindowManager f11686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public WindowManager.LayoutParams f11687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public j1.a f11688f;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.cancel();
            }
        }

        public g(ToastUtils toastUtils, int i10) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f11687e = layoutParams;
            layoutParams.type = i10;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.d
        public void a(int i10) {
            if (this.f11677a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f11687e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.f11687e;
            layoutParams2.flags = rc.c.f48464l0;
            layoutParams2.packageName = j1.a().getPackageName();
            this.f11687e.gravity = this.f11677a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.f11687e;
            int i11 = layoutParams3.gravity;
            if ((i11 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i11 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.f11677a.getXOffset();
            this.f11687e.y = this.f11677a.getYOffset();
            this.f11687e.horizontalMargin = this.f11677a.getHorizontalMargin();
            this.f11687e.verticalMargin = this.f11677a.getVerticalMargin();
            WindowManager windowManager = (WindowManager) j1.a().getSystemService("window");
            this.f11686d = windowManager;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.f11679c, this.f11687e);
                } catch (Exception unused) {
                }
            }
            l1.V0(new a(), i10 == 0 ? 2000L : 3500L);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b, com.blankj.utilcode.util.ToastUtils.d
        public void cancel() {
            try {
                WindowManager windowManager = this.f11686d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.f11679c);
                    this.f11686d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }
    }

    public static void K(View view, int i10, ToastUtils toastUtils) {
        L(view, null, i10, toastUtils);
    }

    public static void L(@g.p0 View view, CharSequence charSequence, int i10, ToastUtils toastUtils) {
        l1.U0(toastUtils.new a(view, charSequence, i10));
    }

    public static void N(CharSequence charSequence, int i10, ToastUtils toastUtils) {
        L(null, o(charSequence), i10, toastUtils);
    }

    public static void P(@g.c1 int i10) {
        N(l1.f0(i10), 1, f11659p);
    }

    public static void Q(@g.c1 int i10, Object... objArr) {
        N(l1.f0(i10), 1, f11659p);
    }

    public static void R(CharSequence charSequence) {
        N(charSequence, 1, f11659p);
    }

    public static void S(String str, Object... objArr) {
        N(l1.F(str, objArr), 1, f11659p);
    }

    public static void T(@g.c1 int i10) {
        N(l1.f0(i10), 0, f11659p);
    }

    public static void U(@g.c1 int i10, Object... objArr) {
        N(l1.g0(i10, objArr), 0, f11659p);
    }

    public static void V(CharSequence charSequence) {
        N(charSequence, 0, f11659p);
    }

    public static void W(String str, Object... objArr) {
        N(l1.F(str, objArr), 0, f11659p);
    }

    public static void l() {
        d dVar = f11660q;
        if (dVar != null) {
            dVar.cancel();
            f11660q = null;
        }
    }

    public static ToastUtils m() {
        return f11659p;
    }

    public static CharSequence o(CharSequence charSequence) {
        return charSequence == null ? f11657n : charSequence.length() == 0 ? f11658o : charSequence;
    }

    public static ToastUtils p() {
        return new ToastUtils();
    }

    public static d q(ToastUtils toastUtils) {
        if (!toastUtils.f11671k && f0.a0.p(j1.a()).a()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new f(toastUtils);
            }
            if (!l1.w0()) {
                return new f(toastUtils);
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 25) {
            return new g(toastUtils, 2005);
        }
        if (l1.w0()) {
            if (i10 >= 26) {
                new g(toastUtils, 2038);
            } else {
                new g(toastUtils, 2002);
            }
        }
        return new c(toastUtils);
    }

    public final ToastUtils A() {
        this.f11671k = true;
        return this;
    }

    public final ToastUtils B(@g.v int i10) {
        return C(h0.d.i(j1.a(), i10));
    }

    public final ToastUtils C(Drawable drawable) {
        this.f11670j[2] = drawable;
        return this;
    }

    public final ToastUtils D(@g.l int i10) {
        this.f11667g = i10;
        return this;
    }

    public final ToastUtils E(int i10) {
        this.f11668h = i10;
        return this;
    }

    public final ToastUtils F(@g.v int i10) {
        return G(h0.d.i(j1.a(), i10));
    }

    public final ToastUtils G(Drawable drawable) {
        this.f11670j[1] = drawable;
        return this;
    }

    public final void H(@g.c1 int i10) {
        N(l1.f0(i10), n(), this);
    }

    public final void I(@g.c1 int i10, Object... objArr) {
        N(l1.g0(i10, objArr), n(), this);
    }

    public final void J(View view) {
        K(view, n(), this);
    }

    public final void M(CharSequence charSequence) {
        N(charSequence, n(), this);
    }

    public final void O(String str, Object... objArr) {
        N(l1.F(str, objArr), n(), this);
    }

    public final View X(CharSequence charSequence) {
        if (!e.H.equals(this.f11661a) && !e.G.equals(this.f11661a)) {
            Drawable[] drawableArr = this.f11670j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewG0 = l1.G0(com.blankj.utilcode.R.layout.utils_toast_view);
        TextView textView = (TextView) viewG0.findViewById(R.id.message);
        if (e.H.equals(this.f11661a)) {
            ((GradientDrawable) viewG0.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f11670j[0] != null) {
            View viewFindViewById = viewG0.findViewById(com.blankj.utilcode.R.id.utvLeftIconView);
            androidx.core.view.u0.I1(viewFindViewById, this.f11670j[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.f11670j[1] != null) {
            View viewFindViewById2 = viewG0.findViewById(com.blankj.utilcode.R.id.utvTopIconView);
            androidx.core.view.u0.I1(viewFindViewById2, this.f11670j[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.f11670j[2] != null) {
            View viewFindViewById3 = viewG0.findViewById(com.blankj.utilcode.R.id.utvRightIconView);
            androidx.core.view.u0.I1(viewFindViewById3, this.f11670j[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.f11670j[3] != null) {
            View viewFindViewById4 = viewG0.findViewById(com.blankj.utilcode.R.id.utvBottomIconView);
            androidx.core.view.u0.I1(viewFindViewById4, this.f11670j[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewG0;
    }

    public final int n() {
        return this.f11669i ? 1 : 0;
    }

    public final ToastUtils r(@g.l int i10) {
        this.f11665e = i10;
        return this;
    }

    public final ToastUtils s(@g.v int i10) {
        this.f11666f = i10;
        return this;
    }

    public final ToastUtils t(int i10) {
        return u(h0.d.i(j1.a(), i10));
    }

    public final ToastUtils u(Drawable drawable) {
        this.f11670j[3] = drawable;
        return this;
    }

    public final ToastUtils v(boolean z10) {
        this.f11669i = z10;
        return this;
    }

    public final ToastUtils w(int i10, int i11, int i12) {
        this.f11662b = i10;
        this.f11663c = i11;
        this.f11664d = i12;
        return this;
    }

    public final ToastUtils x(@g.v int i10) {
        return y(h0.d.i(j1.a(), i10));
    }

    public final ToastUtils y(Drawable drawable) {
        this.f11670j[0] = drawable;
        return this;
    }

    public final ToastUtils z(String str) {
        this.f11661a = str;
        return this;
    }
}
