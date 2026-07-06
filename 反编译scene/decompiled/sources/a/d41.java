package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.LruCache;
import android.view.View;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f5859a = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Paint f481a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Bitmap f484b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final boolean f485b = true;
    public static boolean c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer[] f490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final b41 f480a = new b41(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final LruCache<Integer, Bitmap> f482a = new LruCache<>(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final LinkedHashMap<Integer, Integer> f483a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f479a = Color.parseColor("#20ffffff");
    public static final int b = Color.parseColor("#40ffffff");

    static {
        Paint paint = new Paint();
        paint.setColor(b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        f481a = paint;
        f5859a = 30.0f;
    }

    public d41(View view) {
        f92.d(view, "view");
        this.f487a = view;
        m42 m42Var = m42.f6769a;
        this.f489a = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        this.f490a = new Integer[]{0, 0};
    }

    public static final /* synthetic */ void j(boolean z) {
    }

    public final void l() {
        this.f487a.setOutlineProvider(new e41(f5859a));
        this.f487a.setClipToOutline(true);
        this.f487a.getViewTreeObserver().addOnPreDrawListener(new c41(this));
    }

    public final void m() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3 = f484b;
        if (bitmap3 != null && !c && bitmap3 != null && this.f487a.getWidth() > 0 && this.f487a.getHeight() > 0 && this.f487a.isAttachedToWindow()) {
            Context context = this.f487a.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
            v0 v0Var = (v0) context;
            if (!(Build.VERSION.SDK_INT > 23 && (v0Var.isInPictureInPictureMode() || v0Var.isInMultiWindowMode()))) {
                int[] iArr = new int[2];
                this.f487a.getLocationInWindow(iArr);
                int[] iArr2 = this.f489a;
                if (iArr2[0] == iArr[0] && iArr2[1] == iArr[1] && this.f490a[0].intValue() == this.f487a.getWidth() && this.f490a[1].intValue() == this.f487a.getHeight()) {
                    return;
                }
                this.f489a = iArr;
                this.f490a = new Integer[]{Integer.valueOf(this.f487a.getWidth()), Integer.valueOf(this.f487a.getHeight())};
                try {
                    f92.c(this.f487a.getRootView(), "view.rootView");
                    float width = r2.getWidth() / 192;
                    int width2 = (int) (this.f487a.getWidth() / width);
                    int height = (int) (this.f487a.getHeight() / width);
                    int i = (int) (iArr[0] / width);
                    int i2 = (int) (iArr[1] / width);
                    int width3 = bitmap3.getWidth() - i;
                    int height2 = bitmap3.getHeight() - i2;
                    if (height <= height2) {
                        height2 = height;
                    }
                    if (width2 <= width3) {
                        width3 = width2;
                    }
                    if (this.f486a == null || (bitmap = this.f486a) == null || bitmap.getWidth() != width2 || (bitmap2 = this.f486a) == null || bitmap2.getHeight() != height) {
                        Bitmap bitmap4 = this.f486a;
                        if (bitmap4 != null) {
                            bitmap4.recycle();
                        }
                        this.f486a = Bitmap.createBitmap(width2, height, Bitmap.Config.ARGB_8888);
                    }
                    Bitmap bitmap5 = this.f486a;
                    f92.b(bitmap5);
                    Canvas canvas = new Canvas(bitmap5);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    Rect rect = new Rect(ga2.b(i, 0), ga2.b(i2, 0), ga2.d(width3 + i, bitmap3.getWidth()), ga2.d(height2 + i2, bitmap3.getHeight()));
                    canvas.drawBitmap(bitmap3, rect, new Rect(i < 0 ? -i : 0, i2 < 0 ? -i2 : 0, (i < 0 ? -i : 0) + rect.width(), (i2 < 0 ? -i2 : 0) + rect.height()), (Paint) null);
                    this.f487a.setBackground(new BitmapDrawable(this.f487a.getResources(), this.f486a));
                    this.f488a = true;
                    return;
                } catch (Exception unused) {
                }
            }
        }
        if (this.f488a) {
            View view = this.f487a;
            view.setBackground(yb.d(view.getContext(), lb0.krscript_item_ripple_inactive));
            this.f488a = false;
        }
    }
}
