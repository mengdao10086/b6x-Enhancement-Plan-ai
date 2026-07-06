package a;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wz extends xz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7836a;
    public float b;

    @Override // a.xz
    public void a(Matrix matrix, Path path) {
        Matrix matrix2 = super.f7932a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f7836a, this.b);
        path.transform(matrix);
    }
}
