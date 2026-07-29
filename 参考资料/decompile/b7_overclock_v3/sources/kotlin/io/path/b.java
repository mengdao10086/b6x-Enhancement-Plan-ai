package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@e
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f37832a = new b();

    @Override // kotlin.io.path.a
    @yt.k
    public CopyActionResult a(@yt.k Path path, @yt.k Path target, boolean z10) {
        f0.p(path, "<this>");
        f0.p(target, "target");
        LinkOption[] linkOptionArrA = i.f37849a.a(z10);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !Files.isDirectory(target, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
            f0.o(Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(this, target, *options)");
        }
        return CopyActionResult.CONTINUE;
    }
}
