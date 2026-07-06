package a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f3540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView f3542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager.LayoutParams f3541a = new WindowManager.LayoutParams();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f3539a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3543a = new int[2];
    public final int[] b = new int[2];

    public x8(Context context) {
        this.f7860a = context;
        View viewInflate = LayoutInflater.from(context).inflate(z.abc_tooltip, (ViewGroup) null);
        this.f3540a = viewInflate;
        this.f3542a = (TextView) viewInflate.findViewById(y.message);
        this.f3541a.setTitle(x8.class.getSimpleName());
        this.f3541a.packageName = this.f7860a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f3541a;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = b0.Animation_AppCompat_Tooltip;
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

    public final void a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f7860a.getResources().getDimensionPixelOffset(w.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f7860a.getResources().getDimensionPixelOffset(w.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f7860a.getResources().getDimensionPixelOffset(z ? w.tooltip_y_offset_touch : w.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f3539a);
        Rect rect = this.f3539a;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f7860a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f3539a.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.b);
        view.getLocationOnScreen(this.f3543a);
        int[] iArr = this.f3543a;
        int i4 = iArr[0];
        int[] iArr2 = this.b;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f3540a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f3540a.getMeasuredHeight();
        int[] iArr3 = this.f3543a;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (!z ? measuredHeight + i6 <= this.f3539a.height() : i5 < 0) {
            layoutParams.y = i5;
        } else {
            layoutParams.y = i6;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f7860a.getSystemService("window")).removeView(this.f3540a);
        }
    }

    public boolean d() {
        return this.f3540a.getParent() != null;
    }

    public void e(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f3542a.setText(charSequence);
        a(view, i, i2, z, this.f3541a);
        ((WindowManager) this.f7860a.getSystemService("window")).addView(this.f3540a, this.f3541a);
    }
}
