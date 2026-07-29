package z7;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public class k0 extends y7.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f57859r;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f57860p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f57861q;

    public interface a {
        void a();
    }

    public k0(Context context, a aVar) {
        super(context);
        this.f57860p = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        a aVar = this.f57860p;
        if (aVar != null) {
            aVar.a();
        }
        h();
    }

    @Override // y7.b
    public void h() {
        super.h();
        f57859r = false;
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_float_game_stratefy_ball;
    }

    @Override // y7.b
    public void n() {
        f57859r = true;
        ImageView imageView = (ImageView) this.f56479b.findViewById(R.id.iv_ball);
        this.f57861q = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: z7.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57857a.C(view);
            }
        });
        try {
            this.f56480c.x = Math.max(com.blankj.utilcode.util.x0.g(), com.blankj.utilcode.util.x0.e()) / 10;
            WindowManager.LayoutParams layoutParams = this.f56480c;
            layoutParams.y = 0;
            this.f56481d.updateViewLayout(this.f56479b, layoutParams);
        } catch (Exception unused) {
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(3);
        layoutParamsH.gravity = 8388661;
        return layoutParamsH;
    }
}
