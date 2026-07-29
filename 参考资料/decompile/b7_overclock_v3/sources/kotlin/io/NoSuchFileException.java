package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
public final class NoSuchFileException extends FileSystemException {
    public /* synthetic */ NoSuchFileException(File file, File file2, String str, int i10, u uVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSuchFileException(@yt.k File file, @yt.l File file2, @yt.l String str) {
        super(file, file2, str);
        f0.p(file, "file");
    }
}
