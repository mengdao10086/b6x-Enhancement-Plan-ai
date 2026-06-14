package a;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f6147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WindowManager.LayoutParams f946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager f947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f949a;

    public fx1(Context context) {
        f92.d(context, "mContext");
        View viewInflate = LayoutInflater.from(context).inflate(2131558561, (ViewGroup) null);
        f92.c(viewInflate, "LayoutInflater.from(mCon….layout.fw_logview, null)");
        this.f6147a = viewInflate;
        View viewFindViewById = viewInflate.findViewById(t61.fw_logs);
        f92.c(viewFindViewById, "view.findViewById(R.id.fw_logs)");
        this.f948a = (TextView) viewFindViewById;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.screenOrientation = -1;
        int i = 2003;
        layoutParams.type = 2003;
        if ((context instanceof AccessibilityService) && Build.VERSION.SDK_INT >= 22) {
            i = 2032;
        } else if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        }
        layoutParams.type = i;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.flags = 56;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        m42 m42Var = m42.f6769a;
        this.f946a = layoutParams;
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.f947a = (WindowManager) systemService;
    }

    public final void b() {
        if (this.f949a) {
            this.f947a.removeView(this.f6147a);
            this.f949a = false;
        }
    }

    public final void c(String str) {
        f92.d(str, "logs");
        if (!this.f949a) {
            this.f947a.addView(this.f6147a, this.f946a);
            this.f949a = true;
        }
        this.f948a.post(new ex1(this, str));
    }
}
