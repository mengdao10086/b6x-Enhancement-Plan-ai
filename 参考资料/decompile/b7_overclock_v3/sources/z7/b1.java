package z7;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public class b1 extends y7.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f57802q = 1000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f57803p;

    public b1(Context context, Handler handler, String str) {
        super(context, (y7.n) null, handler);
        this.f57803p = str;
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_toast;
    }

    @Override // y7.b
    public void n() {
        ((TextView) this.f56479b.findViewById(R.id.tv_content)).setText(this.f57803p);
        this.f56483f.postDelayed(new Runnable() { // from class: z7.a1
            @Override // java.lang.Runnable
            public final void run() {
                this.f57781a.h();
            }
        }, 1000L);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(4);
        layoutParamsH.gravity = 81;
        layoutParamsH.y = 300;
        return layoutParamsH;
    }
}
