package a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uq extends Property<Drawable, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f7621a;

    public uq(Class cls, String str) {
        super(cls, str);
        this.f7621a = new Rect();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f7621a);
        Rect rect = this.f7621a;
        return new PointF(rect.left, rect.top);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f7621a);
        this.f7621a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f7621a);
    }
}
