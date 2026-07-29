package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
public class FileSystemException extends IOException {

    @yt.k
    private final File file;

    @yt.l
    private final File other;

    @yt.l
    private final String reason;

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i10, u uVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    @yt.k
    public final File a() {
        return this.file;
    }

    @yt.l
    public final File b() {
        return this.other;
    }

    @yt.l
    public final String c() {
        return this.reason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(@yt.k File file, @yt.l File file2, @yt.l String str) {
        super(e.b(file, file2, str));
        f0.p(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
