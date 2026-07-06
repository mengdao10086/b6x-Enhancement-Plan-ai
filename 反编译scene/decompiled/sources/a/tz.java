package a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tz extends yz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vz f7547a;

    public tz(vz vzVar) {
        this.f7547a = vzVar;
    }

    @Override // a.yz
    public void a(Matrix matrix, xy xyVar, int i, Canvas canvas) {
        xyVar.a(canvas, matrix, new RectF(this.f7547a.k(), this.f7547a.o(), this.f7547a.l(), this.f7547a.j()), i, this.f7547a.m(), this.f7547a.n());
    }
}
