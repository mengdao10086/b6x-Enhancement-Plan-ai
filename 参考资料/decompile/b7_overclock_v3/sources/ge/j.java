package ge;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.x;
import ge.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j<S extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f29338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f29339b;

    public j(S s10) {
        this.f29338a = s10;
    }

    public abstract void a(@n0 Canvas canvas, @n0 Rect rect, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10);

    public abstract void b(@n0 Canvas canvas, @n0 Paint paint, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11, @g.l int i10);

    public abstract void c(@n0 Canvas canvas, @n0 Paint paint);

    public abstract int d();

    public abstract int e();

    public void f(@n0 i iVar) {
        this.f29339b = iVar;
    }

    public void g(@n0 Canvas canvas, @n0 Rect rect, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f29338a.e();
        a(canvas, rect, f10);
    }
}
