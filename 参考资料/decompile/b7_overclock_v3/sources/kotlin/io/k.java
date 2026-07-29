package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public class k extends FilesKt__FileReadWriteKt {
    @yt.k
    public static final h J(@yt.k File file, @yt.k FileWalkDirection direction) {
        f0.p(file, "<this>");
        f0.p(direction, "direction");
        return new h(file, direction);
    }

    public static /* synthetic */ h K(File file, FileWalkDirection fileWalkDirection, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return J(file, fileWalkDirection);
    }

    @yt.k
    public static final h L(@yt.k File file) {
        f0.p(file, "<this>");
        return J(file, FileWalkDirection.BOTTOM_UP);
    }

    @yt.k
    public static final h M(@yt.k File file) {
        f0.p(file, "<this>");
        return J(file, FileWalkDirection.TOP_DOWN);
    }
}
