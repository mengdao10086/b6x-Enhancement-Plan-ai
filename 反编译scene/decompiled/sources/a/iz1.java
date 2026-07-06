package a;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class iz1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bz1 f6457a = new bz1(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f1472a;
    public static View b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mn0 f1474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rm0 f1475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public t21 f1476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f1478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f1479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WindowManager.LayoutParams f1481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager f1482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1484a;

    public iz1(Context context) {
        f92.d(context, "mContext");
        this.f1477a = context;
        this.f1478a = context.getSharedPreferences("monitor", 0);
        View viewInflate = LayoutInflater.from(this.f1477a).inflate(2131558569, (ViewGroup) null);
        f92.c(viewInflate, "LayoutInflater.from(mCon….layout.fw_threads, null)");
        this.f1480a = viewInflate;
        View viewFindViewById = viewInflate.findViewById(t61.fw_title);
        f92.c(viewFindViewById, "view.findViewById(R.id.fw_title)");
        this.f1483a = (TextView) viewFindViewById;
        this.f1475a = new rm0(Scene.f4798a.c());
        this.f1479a = new Handler(Looper.getMainLooper());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.screenOrientation = -1;
        layoutParams.gravity = 8388659;
        layoutParams.flags = 1064;
        layoutParams.type = this.f1477a instanceof AccessibilityService ? 2032 : Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        layoutParams.format = -3;
        if (Build.VERSION.SDK_INT >= 30) {
            layoutParams.x = this.f1478a.getInt("thread_x", 0);
            layoutParams.y = this.f1478a.getInt("thread_y", 0);
        } else {
            layoutParams.x = 0;
            layoutParams.y = 0;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        this.f1476a = new t21(this.f1477a, new ArrayList());
        RecyclerView recyclerView = (RecyclerView) this.f1480a.findViewById(t61.fw_threads);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f1477a));
        recyclerView.setAdapter(this.f1476a);
        m42 m42Var = m42.f6769a;
        this.f1481a = layoutParams;
        Object systemService = this.f1477a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.f1482a = (WindowManager) systemService;
        this.f1484a = "";
        this.f1474a = new mn0();
    }

    public final boolean h() {
        return this.f1475a.h();
    }

    public final void i() {
        m();
        View view = b;
        if (view != null) {
            Object systemService = view.getContext().getSystemService("window");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
            ((WindowManager) systemService).removeViewImmediate(b);
            b = null;
        }
    }

    public final void j() {
        if (f6457a.b()) {
            return;
        }
        this.f1482a.addView(this.f1480a, this.f1481a);
        this.f1480a.setOnTouchListener(new dz1(this));
        this.f1480a.findViewById(t61.close).setOnClickListener(new cz1(this));
        b = this.f1480a;
        l();
    }

    public final void k(int i, String str) {
        f92.d(str, "pName");
        i();
        if (i > 0) {
            this.f1473a = i;
            this.f1484a = str;
            j();
        }
    }

    public final void l() {
        m();
        if (f1472a == null) {
            Timer timer = new Timer("FloatMonitorThreads");
            f1472a = timer;
            f92.b(timer);
            timer.schedule(new fz1(this), 0L, 1000L);
        }
    }

    public final void m() {
        Timer timer = f1472a;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            f1472a = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object n(a.b62<? super a.m42> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof a.gz1
            if (r0 == 0) goto L13
            r0 = r6
            a.gz1 r0 = (a.gz1) r0
            int r1 = r0.f6256a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6256a = r1
            goto L18
        L13:
            a.gz1 r0 = new a.gz1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f1078a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6256a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            java.lang.Object r0 = r0.b
            a.iz1 r0 = (a.iz1) r0
            a.h42.b(r6)
            goto L69
        L39:
            a.h42.b(r6)
            int r6 = r5.f1473a
            r2 = 15
            if (r6 <= 0) goto L52
            a.mn0 r3 = r5.f1474a
            r3.f(r6)
            r0.b = r5
            r0.f6256a = r4
            java.lang.Object r6 = r3.a(r2, r0)
            if (r6 != r1) goto L68
            return r1
        L52:
            a.mn0 r6 = r5.f1474a
            a.fa0 r4 = a.fa0.f867a
            java.lang.String r4 = r4.j()
            r6.e(r4)
            r0.b = r5
            r0.f6256a = r3
            java.lang.Object r6 = r6.a(r2, r0)
            if (r6 != r1) goto L68
            return r1
        L68:
            r0 = r5
        L69:
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r1 = r0.f1473a
            if (r1 <= 0) goto L8b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "#Fixed "
            r1.append(r2)
            java.lang.String r2 = r0.f1484a
            r1.append(r2)
            java.lang.String r2 = "\n["
            r1.append(r2)
            int r2 = r0.f1473a
            r1.append(r2)
            java.lang.String r2 = "] CPU% Top15"
            goto L9b
        L8b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            a.fa0 r2 = a.fa0.f867a
            java.lang.String r2 = r2.j()
            r1.append(r2)
            java.lang.String r2 = "\nCPU% Top15"
        L9b:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.os.Handler r2 = r0.f1479a
            a.hz1 r3 = new a.hz1
            r3.<init>(r0, r6, r1)
            r2.post(r3)
            a.m42 r6 = a.m42.f6769a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.iz1.n(a.b62):java.lang.Object");
    }
}
