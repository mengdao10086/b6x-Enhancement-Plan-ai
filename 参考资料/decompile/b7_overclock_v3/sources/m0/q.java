package m0;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    @yt.k
    public static final Picture a(@yt.k Picture picture, int i10, int i11, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(picture, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i10, i11);
        kotlin.jvm.internal.f0.o(canvasBeginRecording, "beginRecording(width, height)");
        try {
            block.i(canvasBeginRecording);
            return picture;
        } finally {
            kotlin.jvm.internal.c0.d(1);
            picture.endRecording();
            kotlin.jvm.internal.c0.c(1);
        }
    }
}
