package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(@yt.k File file) {
        super(file, null, null, 6, null);
        f0.p(file, "file");
    }
}
