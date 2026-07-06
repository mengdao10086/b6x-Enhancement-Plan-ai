package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f3361a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f3362b;

    public w21(Context context) {
        f92.d(context, "context");
        this.f3360a = context;
        int iD = d(1.0f);
        this.f3359a = iD;
        this.f7748a = iD * 24.0f;
        this.b = iD * 8.5f;
        this.f3361a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f3362b = Color.parseColor("#50888888");
    }

    public final void a(int i, boolean z, Paint paint) {
        f92.d(paint, "paint");
        if (i == 0) {
            e(paint);
        } else if (z) {
            j(paint);
        } else {
            i(paint);
        }
    }

    public final void b(Paint paint) {
        f92.d(paint, "paint");
        paint.reset();
        paint.setColor(Color.parseColor("#1474e4"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setPathEffect(null);
    }

    public final void c(Paint paint) {
        f92.d(paint, "paint");
        paint.reset();
        paint.setColor(Color.parseColor("#501474e4"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setPathEffect(null);
    }

    public final int d(float f) {
        Resources resources = this.f3360a.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void e(Paint paint) {
        f92.d(paint, "paint");
        paint.setPathEffect(null);
        paint.setStrokeWidth(2.0f);
        paint.setColor(this.f3362b);
    }

    public final int f() {
        return this.f3359a;
    }

    public final float g() {
        return this.b;
    }

    public final float h() {
        return this.f7748a;
    }

    public final void i(Paint paint) {
        f92.d(paint, "paint");
        paint.setPathEffect(this.f3361a);
        paint.setStrokeWidth(1.0f);
        paint.setColor(this.f3362b);
    }

    public final void j(Paint paint) {
        f92.d(paint, "paint");
        paint.setPathEffect(null);
        paint.setStrokeWidth(1.0f);
        paint.setColor(this.f3362b);
    }

    public final void k(Paint paint) {
        f92.d(paint, "paint");
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.parseColor("#888888"));
        paint.setTextSize(this.b);
    }

    public final void l(Paint paint) {
        f92.d(paint, "paint");
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setColor(Color.parseColor("#888888"));
        paint.setTextSize(this.b);
    }
}
