package z7;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.flydigi.data.event.FlyMouseEvent;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public class e extends y7.b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f57815t = 100;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f57816p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f57817q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f57818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f57819s;

    public interface a {
        void a(boolean z10);
    }

    public e(Context context, y7.n nVar, a aVar) {
        super(context, nVar);
        this.f57817q = 0L;
        this.f57819s = new Runnable() { // from class: z7.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f57804a.D();
            }
        };
        this.f57818r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        View view = this.f56479b;
        if (view != null) {
            view.setVisibility(4);
            this.f57818r.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(FlyMouseEvent flyMouseEvent) {
        View view = this.f56479b;
        if (view != null && view.getVisibility() != 0) {
            this.f56479b.setVisibility(0);
        }
        ImageView imageView = this.f57816p;
        if (imageView != null) {
            imageView.setX(flyMouseEvent.f14355x);
            this.f57816p.setY(flyMouseEvent.f14356y);
            this.f57818r.a(true);
        }
    }

    public void F(final FlyMouseEvent flyMouseEvent) {
        if (!flyMouseEvent.show) {
            this.f56483f.post(this.f57819s);
            return;
        }
        if (this.f57817q == 0 || System.currentTimeMillis() - this.f57817q > 17) {
            this.f57817q = System.currentTimeMillis();
            if (flyMouseEvent.show) {
                this.f56483f.post(new Runnable() { // from class: z7.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f57810a.E(flyMouseEvent);
                    }
                });
            }
        }
        this.f56483f.removeCallbacks(this.f57819s);
        this.f56483f.postDelayed(this.f57819s, 100L);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_cursor;
    }

    @Override // y7.b
    public void n() {
        this.f57816p = (ImageView) this.f56479b.findViewById(R.id.iv_cursor);
        this.f56483f.postDelayed(this.f57819s, 100L);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(2);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
