package a;

import android.graphics.Canvas;
import android.graphics.Matrix;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class yz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Matrix f8020a = new Matrix();

    public abstract void a(Matrix matrix, xy xyVar, int i, Canvas canvas);

    public final void b(xy xyVar, int i, Canvas canvas) {
        a(f8020a, xyVar, i, canvas);
    }
}
