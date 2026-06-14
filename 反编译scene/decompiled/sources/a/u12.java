package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.ProcessInfo;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f7556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final k12 f3107a = new k12(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static View f3108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f3109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f3110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nb2 f3111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rm0 f3112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f3114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3115a;

    public u12(Context context) {
        f92.d(context, "context");
        this.f3113a = context;
        this.f3115a = new Handler(Looper.getMainLooper());
        this.f3112a = new rm0(Scene.f4798a.c());
        new nb2("u[0-9]+_.*");
        this.f3111a = new nb2(".*\\..*");
        this.f3114a = this.f3113a.getPackageManager();
    }

    public static /* synthetic */ void n(u12 u12Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        u12Var.m(z);
    }

    public final boolean l() {
        return this.f3112a.h();
    }

    public final void m(boolean z) {
        s();
        View view = f3108a;
        if (view != null) {
            Object systemService = view.getContext().getSystemService("window");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
            ((WindowManager) systemService).removeViewImmediate(f3108a);
            f3108a = null;
        }
        if (z) {
            Scene.f4798a.k(hz0.f1282a.k0(), false);
        }
    }

    public final boolean o(ProcessInfo processInfo) {
        String strSubstring;
        String str = processInfo.command;
        f92.c(str, "processInfo.command");
        if (ec2.C(str, "app_process", false, 2, null)) {
            String str2 = processInfo.name;
            f92.c(str2, "processInfo.name");
            if (this.f3111a.f(str2)) {
                return true;
            }
        }
        try {
            String str3 = processInfo.name;
            f92.c(str3, "processInfo.name");
            if (ec2.C(str3, ":", false, 2, null)) {
                String str4 = processInfo.name;
                f92.c(str4, "processInfo.name");
                String str5 = processInfo.name;
                f92.c(str5, "processInfo.name");
                int iN = ec2.N(str5, ":", 0, false, 6, null);
                if (str4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                strSubstring = str4.substring(0, iN);
                f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                strSubstring = processInfo.name;
            }
            return this.f3114a.getPackageInfo(strSubstring, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void p() {
        f3110a = false;
        View viewInflate = LayoutInflater.from(this.f3113a).inflate(2131558564, (ViewGroup) null);
        f3108a = viewInflate;
        ListView listView = viewInflate != null ? (ListView) viewInflate.findViewById(2131362792) : null;
        f92.b(listView);
        Context context = listView.getContext();
        f92.c(context, "this.context");
        listView.setAdapter((ListAdapter) new f21(context, null, null, 0, 0, 30, null));
        View view = f3108a;
        ImageButton imageButton = view != null ? (ImageButton) view.findViewById(t61.fw_float_minimize) : null;
        f92.b(imageButton);
        View view2 = f3108a;
        TextView textView = view2 != null ? (TextView) view2.findViewById(2131362791) : null;
        f92.b(textView);
        View view3 = f3108a;
        View viewFindViewById = view3 != null ? view3.findViewById(t61.fw_float_pin) : null;
        f92.b(viewFindViewById);
        l92 l92Var = new l92();
        l92Var.f6687a = 32;
        textView.setOnClickListener(new l12(this, l92Var, listView, textView));
        n92 n92Var = new n92();
        n92Var.f6891a = null;
        listView.setOnItemClickListener(new m12(this, listView, n92Var));
        viewFindViewById.setOnClickListener(new n12(this));
        View view4 = f3108a;
        ImageButton imageButton2 = view4 != null ? (ImageButton) view4.findViewById(t61.fw_float_close) : null;
        f92.b(imageButton2);
        imageButton2.setOnClickListener(new o12(this));
        imageButton.setOnClickListener(new p12(this, listView, textView, imageButton2, imageButton));
    }

    public final void q() {
        if (f3108a != null) {
            return;
        }
        Scene.f4798a.k(hz0.f1282a.k0(), true);
        p();
        SharedPreferences sharedPreferences = this.f3113a.getSharedPreferences("monitor", 0);
        Object systemService = this.f3113a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        WindowManager windowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2003;
        layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 8388659;
        layoutParams.x = sharedPreferences.getInt("process_x", 0);
        layoutParams.y = sharedPreferences.getInt("process_y", 0);
        layoutParams.flags = 1064;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        windowManager.addView(f3108a, layoutParams);
        View view = f3108a;
        f92.b(view);
        view.setOnTouchListener(new q12(layoutParams, windowManager, sharedPreferences));
        View view2 = f3108a;
        View viewFindViewById = view2 != null ? view2.findViewById(t61.fw_float_pin) : null;
        f92.b(viewFindViewById);
        viewFindViewById.setOnLongClickListener(new r12(layoutParams, windowManager));
        r();
    }

    public final void r() {
        s();
        if (f3109a == null) {
            Timer timer = new Timer("FloatTaskManager");
            f3109a = timer;
            f92.b(timer);
            timer.schedule(new s12(this), 0L, 3000L);
        }
    }

    public final void s() {
        Timer timer = f3109a;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            f3109a = null;
        }
    }

    public final void t() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f7556a < 2000) {
            return;
        }
        ArrayList<ProcessInfo> arrayListA = this.f3112a.a();
        if (jCurrentTimeMillis - f7556a < 3000) {
            return;
        }
        this.f3115a.post(new t12(arrayListA));
    }
}
