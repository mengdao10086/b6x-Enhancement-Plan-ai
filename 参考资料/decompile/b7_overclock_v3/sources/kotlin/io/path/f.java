package kotlin.io.path;

import ik.p;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@e
@v0(version = "1.7")
public interface f {
    void a(@yt.k p<? super Path, ? super IOException, ? extends FileVisitResult> pVar);

    void b(@yt.k p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar);

    void c(@yt.k p<? super Path, ? super IOException, ? extends FileVisitResult> pVar);

    void d(@yt.k p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar);
}
