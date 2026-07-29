package mh;

import android.view.MotionEvent;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f41240j = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f41242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f41243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f41244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41245e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f41246f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f41247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f41248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f41249i;

    public interface a {
        boolean a(h hVar);
    }

    public static class b implements a {
        @Override // mh.h.a
        public boolean a(h hVar) {
            return false;
        }
    }

    public h(a aVar) {
        this.f41249i = aVar;
    }

    public final float a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return b((float) Math.toDegrees((float) Math.atan2(f11 - f13, f10 - f12)), (float) Math.toDegrees((float) Math.atan2(f15 - f17, f14 - f16)));
    }

    public final float b(float f10, float f11) {
        float f12 = (f11 % 360.0f) - (f10 % 360.0f);
        this.f41247g = f12;
        if (f12 < -180.0f) {
            this.f41247g = f12 + 360.0f;
        } else if (f12 > 180.0f) {
            this.f41247g = f12 - 360.0f;
        }
        return this.f41247g;
    }

    public float c() {
        return this.f41247g;
    }

    public boolean d(@n0 MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f41243c = motionEvent.getX();
            this.f41244d = motionEvent.getY();
            this.f41245e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.f41247g = 0.0f;
            this.f41248h = true;
        } else if (actionMasked == 1) {
            this.f41245e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f41241a = motionEvent.getX();
                this.f41242b = motionEvent.getY();
                this.f41246f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.f41247g = 0.0f;
                this.f41248h = true;
            } else if (actionMasked == 6) {
                this.f41246f = -1;
            }
        } else if (this.f41245e != -1 && this.f41246f != -1 && motionEvent.getPointerCount() > this.f41246f) {
            float x10 = motionEvent.getX(this.f41245e);
            float y10 = motionEvent.getY(this.f41245e);
            float x11 = motionEvent.getX(this.f41246f);
            float y11 = motionEvent.getY(this.f41246f);
            if (this.f41248h) {
                this.f41247g = 0.0f;
                this.f41248h = false;
            } else {
                a(this.f41241a, this.f41242b, this.f41243c, this.f41244d, x11, y11, x10, y10);
            }
            a aVar = this.f41249i;
            if (aVar != null) {
                aVar.a(this);
            }
            this.f41241a = x11;
            this.f41242b = y11;
            this.f41243c = x10;
            this.f41244d = y10;
        }
        return true;
    }
}
