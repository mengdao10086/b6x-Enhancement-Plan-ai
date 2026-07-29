package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.c1;
import kotlin.collections.d1;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,177:1\n26#2:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n*L\n142#1:178\n*E\n"})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final i f37849a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final LinkOption[] f37850b = {LinkOption.NOFOLLOW_LINKS};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final LinkOption[] f37851c = new LinkOption[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final Set<FileVisitOption> f37852d = d1.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final Set<FileVisitOption> f37853e = c1.f(FileVisitOption.FOLLOW_LINKS);

    @yt.k
    public final LinkOption[] a(boolean z10) {
        return z10 ? f37851c : f37850b;
    }

    @yt.k
    public final Set<FileVisitOption> b(boolean z10) {
        return z10 ? f37853e : f37852d;
    }
}
