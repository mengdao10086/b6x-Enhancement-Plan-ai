package dd;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import dd.a;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class i extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, a.InterfaceC0295a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f26236h = 45.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f26239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f26240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GestureDetector f26241e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public e f26243g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f26237a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f26238b = new PointF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile float f26242f = 3.1415927f;

    public interface a {
        void b(PointF pointF);
    }

    public i(Context context, a aVar, float f10) {
        this.f26239c = aVar;
        this.f26240d = f10;
        this.f26241e = new GestureDetector(context, this);
    }

    @Override // dd.a.InterfaceC0295a
    @g.g
    public void a(float[] fArr, float f10) {
        this.f26242f = -f10;
    }

    public void b(@p0 e eVar) {
        this.f26243g = eVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f26237a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x10 = (motionEvent2.getX() - this.f26237a.x) / this.f26240d;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f26237a;
        float f12 = (y10 - pointF.y) / this.f26240d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = this.f26242f;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        PointF pointF2 = this.f26238b;
        pointF2.x -= (fCos * x10) - (fSin * f12);
        float f13 = pointF2.y + (fSin * x10) + (fCos * f12);
        pointF2.y = f13;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f13));
        this.f26239c.b(this.f26238b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        e eVar = this.f26243g;
        if (eVar != null) {
            return eVar.onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f26241e.onTouchEvent(motionEvent);
    }
}
