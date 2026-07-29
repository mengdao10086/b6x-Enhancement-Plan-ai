package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class f1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f2462h = "TooltipPopup";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f2464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f2465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f2466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f2467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f2468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f2469g;

    public f1(@g.n0 Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f2466d = layoutParams;
        this.f2467e = new Rect();
        this.f2468f = new int[2];
        this.f2469g = new int[2];
        this.f2463a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f2464b = viewInflate;
        this.f2465c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public final void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int height;
        int i12;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2463a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f2463a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f2463a.getResources().getDimensionPixelOffset(z10 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f2467e);
        Rect rect = this.f2467e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f2463a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", l4.f.f39447b);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f2467e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f2469g);
        view.getLocationOnScreen(this.f2468f);
        int[] iArr = this.f2468f;
        int i13 = iArr[0];
        int[] iArr2 = this.f2469g;
        iArr[0] = i13 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i10) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f2464b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f2464b.getMeasuredHeight();
        int[] iArr3 = this.f2468f;
        int i14 = ((iArr3[1] + i12) - dimensionPixelOffset3) - measuredHeight;
        int i15 = iArr3[1] + height + dimensionPixelOffset3;
        if (z10) {
            if (i14 >= 0) {
                layoutParams.y = i14;
                return;
            } else {
                layoutParams.y = i15;
                return;
            }
        }
        if (measuredHeight + i15 <= this.f2467e.height()) {
            layoutParams.y = i15;
        } else {
            layoutParams.y = i14;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f2463a.getSystemService("window")).removeView(this.f2464b);
        }
    }

    public boolean d() {
        return this.f2464b.getParent() != null;
    }

    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f2465c.setText(charSequence);
        a(view, i10, i11, z10, this.f2466d);
        ((WindowManager) this.f2463a.getSystemService("window")).addView(this.f2464b, this.f2466d);
    }
}
