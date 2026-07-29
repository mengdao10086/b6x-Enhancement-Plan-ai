package ka;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import java.lang.ref.WeakReference;
import xa.g;

/* JADX INFO: loaded from: classes3.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f37116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f37117b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<ja.e> f37120e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f37118c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f37119d = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xa.c f37121f = new xa.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f37122g = new Rect();

    public e(Context context, int i10) {
        this.f37116a = context;
        this.f37117b = context.getResources().getDrawable(i10, null);
    }

    @Override // ka.d
    public void a(Canvas canvas, float f10, float f11) {
        if (this.f37117b == null) {
            return;
        }
        g gVarB = b(f10, f11);
        xa.c cVar = this.f37121f;
        float intrinsicWidth = cVar.f54979c;
        float intrinsicHeight = cVar.f54980d;
        if (intrinsicWidth == 0.0f) {
            intrinsicWidth = this.f37117b.getIntrinsicWidth();
        }
        if (intrinsicHeight == 0.0f) {
            intrinsicHeight = this.f37117b.getIntrinsicHeight();
        }
        this.f37117b.copyBounds(this.f37122g);
        Drawable drawable = this.f37117b;
        Rect rect = this.f37122g;
        int i10 = rect.left;
        int i11 = rect.top;
        drawable.setBounds(i10, i11, ((int) intrinsicWidth) + i10, ((int) intrinsicHeight) + i11);
        int iSave = canvas.save();
        canvas.translate(f10 + gVarB.f54987c, f11 + gVarB.f54988d);
        this.f37117b.draw(canvas);
        canvas.restoreToCount(iSave);
        this.f37117b.setBounds(this.f37122g);
    }

    @Override // ka.d
    public g b(float f10, float f11) {
        Drawable drawable;
        Drawable drawable2;
        g offset = getOffset();
        g gVar = this.f37119d;
        gVar.f54987c = offset.f54987c;
        gVar.f54988d = offset.f54988d;
        ja.e eVarD = d();
        xa.c cVar = this.f37121f;
        float intrinsicWidth = cVar.f54979c;
        float intrinsicHeight = cVar.f54980d;
        if (intrinsicWidth == 0.0f && (drawable2 = this.f37117b) != null) {
            intrinsicWidth = drawable2.getIntrinsicWidth();
        }
        if (intrinsicHeight == 0.0f && (drawable = this.f37117b) != null) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        g gVar2 = this.f37119d;
        float f12 = gVar2.f54987c;
        if (f10 + f12 < 0.0f) {
            gVar2.f54987c = -f10;
        } else if (eVarD != null && f10 + intrinsicWidth + f12 > eVarD.getWidth()) {
            this.f37119d.f54987c = (eVarD.getWidth() - f10) - intrinsicWidth;
        }
        g gVar3 = this.f37119d;
        float f13 = gVar3.f54988d;
        if (f11 + f13 < 0.0f) {
            gVar3.f54988d = -f11;
        } else if (eVarD != null && f11 + intrinsicHeight + f13 > eVarD.getHeight()) {
            this.f37119d.f54988d = (eVarD.getHeight() - f11) - intrinsicHeight;
        }
        return this.f37119d;
    }

    @Override // ka.d
    public void c(Entry entry, oa.d dVar) {
    }

    public ja.e d() {
        WeakReference<ja.e> weakReference = this.f37120e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public xa.c e() {
        return this.f37121f;
    }

    public void f(ja.e eVar) {
        this.f37120e = new WeakReference<>(eVar);
    }

    public void g(float f10, float f11) {
        g gVar = this.f37118c;
        gVar.f54987c = f10;
        gVar.f54988d = f11;
    }

    @Override // ka.d
    public g getOffset() {
        return this.f37118c;
    }

    public void h(g gVar) {
        this.f37118c = gVar;
        if (gVar == null) {
            this.f37118c = new g();
        }
    }

    public void i(xa.c cVar) {
        this.f37121f = cVar;
        if (cVar == null) {
            this.f37121f = new xa.c();
        }
    }
}
