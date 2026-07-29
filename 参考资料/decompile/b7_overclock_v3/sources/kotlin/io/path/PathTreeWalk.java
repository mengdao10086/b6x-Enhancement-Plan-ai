package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.sequences.q;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@e
public final class PathTreeWalk implements kotlin.sequences.m<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Path f37826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final PathWalkOption[] f37827b;

    public PathTreeWalk(@yt.k Path start, @yt.k PathWalkOption[] options) {
        f0.p(start, "start");
        f0.p(options, "options");
        this.f37826a = start;
        this.f37827b = options;
    }

    public final Iterator<Path> g() {
        return q.a(new PathTreeWalk$bfsIterator$1(this, null));
    }

    public final Iterator<Path> h() {
        return q.a(new PathTreeWalk$dfsIterator$1(this, null));
    }

    public final boolean i() {
        return ArraysKt___ArraysKt.T8(this.f37827b, PathWalkOption.FOLLOW_LINKS);
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<Path> iterator() {
        return l() ? g() : h();
    }

    public final boolean j() {
        return ArraysKt___ArraysKt.T8(this.f37827b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    public final LinkOption[] k() {
        return i.f37849a.a(i());
    }

    public final boolean l() {
        return ArraysKt___ArraysKt.T8(this.f37827b, PathWalkOption.BREADTH_FIRST);
    }

    public final Object m(kotlin.sequences.o<? super Path> oVar, j jVar, c cVar, ik.l<? super List<j>, z1> lVar, kotlin.coroutines.c<? super z1> cVar2) throws FileSystemLoopException {
        Path pathD = jVar.d();
        LinkOption[] linkOptionArrK = k();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrK, linkOptionArrK.length);
        if (Files.isDirectory(pathD, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (l.c(jVar)) {
                throw new FileSystemLoopException(pathD.toString());
            }
            if (j()) {
                c0.e(0);
                oVar.a(pathD, cVar2);
                c0.e(1);
            }
            LinkOption[] linkOptionArrK2 = k();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArrK2, linkOptionArrK2.length);
            if (Files.isDirectory(pathD, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                lVar.i(cVar.c(jVar));
            }
        } else if (Files.exists(pathD, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            c0.e(0);
            oVar.a(pathD, cVar2);
            c0.e(1);
            return z1.f38230a;
        }
        return z1.f38230a;
    }
}
