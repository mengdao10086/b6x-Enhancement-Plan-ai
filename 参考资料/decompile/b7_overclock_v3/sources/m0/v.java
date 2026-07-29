package m0;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final void a(@yt.k Shader shader, @yt.k ik.l<? super Matrix, z1> block) {
        kotlin.jvm.internal.f0.p(shader, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        block.i(matrix);
        shader.setLocalMatrix(matrix);
    }
}
