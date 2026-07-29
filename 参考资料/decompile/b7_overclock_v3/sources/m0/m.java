package m0;

import android.annotation.SuppressLint;
import android.graphics.Path;
import g.v0;
import java.util.Collection;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n1#1,85:1\n44#1,3:86\n*S KotlinDebug\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n63#1:86,3\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
public final class m {
    @yt.k
    @v0(19)
    public static final Path a(@yt.k Path path, @yt.k Path p10) {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Path path2 = new Path();
        path2.op(path, p10, Path.Op.INTERSECT);
        return path2;
    }

    @yt.k
    @v0(26)
    public static final Iterable<o> b(@yt.k Path path, float f10) {
        kotlin.jvm.internal.f0.p(path, "<this>");
        Collection<o> collectionB = p.b(path, f10);
        kotlin.jvm.internal.f0.o(collectionB, "flatten(this, error)");
        return collectionB;
    }

    public static /* synthetic */ Iterable c(Path path, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.5f;
        }
        return b(path, f10);
    }

    @yt.k
    @v0(19)
    public static final Path d(@yt.k Path path, @yt.k Path p10) {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.DIFFERENCE);
        return path2;
    }

    @yt.k
    @v0(19)
    public static final Path e(@yt.k Path path, @yt.k Path p10) {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.UNION);
        return path2;
    }

    @yt.k
    @v0(19)
    public static final Path f(@yt.k Path path, @yt.k Path p10) {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.UNION);
        return path2;
    }

    @yt.k
    @v0(19)
    public static final Path g(@yt.k Path path, @yt.k Path p10) {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        Path path2 = new Path(path);
        path2.op(p10, Path.Op.XOR);
        return path2;
    }
}
