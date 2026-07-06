package a;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WindowManager.LayoutParams f1094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager f1095a;

    public h12(Context context) {
        f92.d(context, "mContext");
        this.f1092a = context;
        View viewInflate = LayoutInflater.from(context).inflate(2131558567, (ViewGroup) null);
        f92.c(viewInflate, "LayoutInflater.from(mCon…t.fw_quickly_grant, null)");
        this.f1093a = viewInflate;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.screenOrientation = -1;
        int i = 2003;
        layoutParams.type = 2003;
        if ((this.f1092a instanceof AccessibilityService) && Build.VERSION.SDK_INT >= 22) {
            i = 2032;
        } else if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        }
        layoutParams.type = i;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.flags = 1064;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        m42 m42Var = m42.f6769a;
        this.f1094a = layoutParams;
        Object systemService = this.f1092a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.f1095a = (WindowManager) systemService;
    }

    public final void c() {
        if (f6264a) {
            this.f1095a.removeView(this.f1093a);
            f6264a = false;
        }
    }

    public final void d(String str, String str2) {
        f92.d(str, "app");
        f92.d(str2, "permission");
        if (f6264a) {
            return;
        }
        this.f1095a.addView(this.f1093a, this.f1094a);
        f6264a = true;
        qc2.d(xd2.a(qe2.b()), null, null, new c12(this, new ih0(this.f1092a, 0, 0, 6, null).i(str), str2, null), 3, null);
        this.f1093a.setOnKeyListener(new d12(this));
        this.f1093a.setOnTouchListener(new e12(this));
        this.f1093a.findViewById(2131362070).setOnClickListener(new f12(this, str, str2));
        this.f1093a.findViewById(2131362069).setOnClickListener(new g12(this));
    }
}
