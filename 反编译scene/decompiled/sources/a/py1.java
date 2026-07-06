package a;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class py1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WindowManager f2461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f2463a;

    @SuppressLint({"StaticFieldLeak"})
    public static View c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double f2464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final em0 f2467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final il0 f2468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kl0 f2469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final py0 f2470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final sx1 f2471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f2472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f2475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f2476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f2477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2478a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2479b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final z32 f2480b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f2481b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f2482b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f2483c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final px1 f7160a = new px1(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f2462a = Boolean.FALSE;

    public py1(Context context) {
        f92.d(context, "mContext");
        this.f2473a = context;
        this.f2470a = new py0(this.f2473a);
        this.f2471a = new sx1(this);
        this.f2468a = new il0();
        this.f2472a = a42.a(new ux1(this));
        this.f2480b = a42.a(new tx1(this));
        this.f2469a = new kl0();
        this.f2467a = new em0();
    }

    public static /* synthetic */ void z(py1 py1Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        py1Var.y(z);
    }

    public final void A() {
        qc2.d(xd2.a(qe2.b()), null, null, new wx1(this, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r5v12, types: [T, a.xx1] */
    @SuppressLint({"ApplySharedPref", "ClickableViewAccessibility"})
    public final View B(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(2131558559, (ViewGroup) null);
        this.f2474a = viewInflate;
        f92.b(viewInflate);
        this.f2476a = (TextView) viewInflate.findViewById(t61.fw_fps);
        View view = this.f2474a;
        f92.b(view);
        this.f2475a = (FrameLayout) view.findViewById(t61.fw_action);
        n92 n92Var = new n92();
        View view2 = this.f2474a;
        f92.b(view2);
        View viewFindViewById = view2.findViewById(t61.fw_fps_duration);
        f92.b(viewFindViewById);
        ay1 ay1Var = new ay1(viewFindViewById);
        viewFindViewById.setOnClickListener(zx1.f8106a);
        View viewFindViewById2 = viewFindViewById.findViewById(t61.duration_5m);
        f92.c(viewFindViewById2, "findViewById(R.id.duration_5m)");
        View viewFindViewById3 = viewFindViewById.findViewById(t61.duration_10m);
        f92.c(viewFindViewById3, "findViewById(R.id.duration_10m)");
        View viewFindViewById4 = viewFindViewById.findViewById(t61.duration_15m);
        f92.c(viewFindViewById4, "findViewById(R.id.duration_15m)");
        View viewFindViewById5 = viewFindViewById.findViewById(t61.duration_30m);
        f92.c(viewFindViewById5, "findViewById(R.id.duration_30m)");
        TextView[] textViewArr = {(TextView) viewFindViewById2, (TextView) viewFindViewById3, (TextView) viewFindViewById4, (TextView) viewFindViewById5};
        n92Var.f6891a = new xx1(textViewArr, this, n92Var);
        for (int i = 0; i < 4; i++) {
            TextView textView = textViewArr[i];
            textView.setOnClickListener(new yx1(textView, ay1Var, this, n92Var));
        }
        m42 m42Var = m42.f6769a;
        this.f2481b = viewFindViewById;
        View view3 = this.f2474a;
        if (view3 != null) {
            view3.setOnClickListener(new ey1(this, context, n92Var));
        }
        View view4 = this.f2474a;
        f92.b(view4);
        return view4;
    }

    public final boolean C() {
        Boolean bool = f2462a;
        f92.b(bool);
        if (bool.booleanValue()) {
            return true;
        }
        Scene.f4798a.k(hz0.f1282a.h0(), true);
        System.currentTimeMillis();
        Context context = this.f2473a;
        if (!(context instanceof AccessibilityService) && Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context)) {
            Context context2 = this.f2473a;
            Toast.makeText(context2, context2.getString(u61.permission_float), 1).show();
            return false;
        }
        f2462a = Boolean.TRUE;
        Object systemService = this.f2473a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        f2461a = (WindowManager) systemService;
        c = B(this.f2473a);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int i = 2003;
        layoutParams.type = 2003;
        if (this.f2473a instanceof AccessibilityService) {
            i = 2032;
        } else if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        }
        layoutParams.type = i;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 8388661;
        layoutParams.y = v(this.f2473a, 65.0f);
        layoutParams.x = v(this.f2473a, 10.0f);
        layoutParams.flags = 1064;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        WindowManager windowManager = f2461a;
        f92.b(windowManager);
        windowManager.addView(c, layoutParams);
        View view = this.f2474a;
        if (view != null) {
            view.setOnTouchListener(new fy1(layoutParams));
        }
        D();
        z90.f8048a.c(this.f2471a);
        return true;
    }

    public final void D() {
        F();
        Timer timer = new Timer("FloatMonitorFPS");
        f2463a = timer;
        f92.b(timer);
        timer.schedule(new hy1(this), 0L, 1000L);
        Scene.f4798a.a(new iy1(null));
    }

    public final void E() {
        long j = this.f2466a;
        if (j > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f2479b;
            if (jCurrentTimeMillis < 5000) {
                this.f2470a.d(j);
            } else if (hz0.f1282a.d() && jCurrentTimeMillis >= 60000) {
                if (jCurrentTimeMillis > 3600000) {
                    Scene.c.p(Scene.f4798a, "记录时间过长，无法上传", 0, 2, null);
                    return;
                }
                qc2.d(xd2.a(qe2.b()), null, null, new jy1(this, j, null), 3, null);
            }
        }
        this.f2466a = -1L;
        this.f2478a = null;
        this.f2483c = null;
        FrameLayout frameLayout = this.f2475a;
        if (frameLayout != null) {
            frameLayout.setBackground(yb.d(frameLayout.getContext(), 2131230913));
            frameLayout.setAlpha(1.0f);
        }
        View view = this.f2481b;
        if (view != null) {
            view.setVisibility(8);
        }
        qc2.d(xd2.a(qe2.b()), null, null, new ky1(null), 3, null);
    }

    public final void F() {
        Timer timer = f2463a;
        if (timer != null) {
            f92.b(timer);
            timer.cancel();
            f2463a = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015b A[LOOP:3: B:36:0x0159->B:37:0x015b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0332 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object G(a.b62<? super a.m42> r56) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 979
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.py1.G(a.b62):java.lang.Object");
    }

    public final int v(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final ArrayList<String[]> w() {
        return (ArrayList) this.f2480b.getValue();
    }

    public final int x() {
        return ((Number) this.f2472a.getValue()).intValue();
    }

    public final void y(boolean z) {
        F();
        Boolean bool = f2462a;
        f92.b(bool);
        if (bool.booleanValue() && c != null) {
            WindowManager windowManager = f2461a;
            f92.b(windowManager);
            windowManager.removeView(c);
            c = null;
            f2462a = Boolean.FALSE;
        }
        this.f2466a = -1L;
        z90.f8048a.d(this.f2471a);
        if (z) {
            Scene.f4798a.k(hz0.f1282a.h0(), false);
        }
        Scene.f4798a.a(new vx1(null));
    }
}
