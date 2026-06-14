package a;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.omarea.ui.fps.FrameTimeView2;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cx1 f5946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WindowManager.LayoutParams f621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager f622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameTimeView2 f623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f624a;

    public dx1(Context context) {
        f92.d(context, "mContext");
        View viewInflate = LayoutInflater.from(context).inflate(2131558560, (ViewGroup) null);
        f92.c(viewInflate, "LayoutInflater.from(mCon…yout.fw_frame_time, null)");
        this.f620a = viewInflate;
        View viewFindViewById = viewInflate.findViewById(t61.ft_view);
        f92.c(viewFindViewById, "view.findViewById(R.id.ft_view)");
        this.f623a = (FrameTimeView2) viewFindViewById;
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
        this.f621a = layoutParams;
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.f622a = (WindowManager) systemService;
        this.f5946a = new cx1(this);
    }

    public final void b() {
        if (this.f624a) {
            this.f622a.removeView(this.f620a);
            this.f624a = false;
            z90.f8048a.d(this.f5946a);
        }
    }

    public final void c() {
        if (this.f624a) {
            return;
        }
        this.f622a.addView(this.f620a, this.f621a);
        this.f624a = true;
        z90.f8048a.c(this.f5946a);
    }
}
