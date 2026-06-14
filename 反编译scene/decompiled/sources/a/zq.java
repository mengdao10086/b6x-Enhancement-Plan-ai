package a;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zq extends Property<View, PointF> {
    public zq(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF get(View view) {
        return null;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(View view, PointF pointF) {
        int iRound = Math.round(pointF.x);
        int iRound2 = Math.round(pointF.y);
        ys.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
    }
}
