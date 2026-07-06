package a;

import android.graphics.Matrix;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cx extends ov {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ix f5835a;

    public cx(ix ixVar) {
        this.f5835a = ixVar;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        this.f5835a.f1446e = f;
        return super.evaluate(f, matrix, matrix2);
    }
}
