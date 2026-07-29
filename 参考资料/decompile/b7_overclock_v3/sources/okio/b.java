package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(message = "changed in Okio 2.x")
@kotlin.d0(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J+\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J+\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\b\u0010\"\u001a\u00020\u0004H\u0007¨\u0006%"}, d2 = {"Lokio/b;", "", "Ljava/io/File;", m7.a.f40702b, "Lokio/r0;", "a", "sink", "Lokio/k;", "c", "Lokio/t0;", "source", "Lokio/l;", "d", "e", "Ljava/io/OutputStream;", "outputStream", "f", "Ljava/nio/file/Path;", "path", "", "Ljava/nio/file/OpenOption;", "options", "h", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/r0;", "Ljava/net/Socket;", "socket", "g", "i", "Ljava/io/InputStream;", "inputStream", xf.j.f55230b, com.flydigi.sdk.bluetooth.l.f16298a, "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/t0;", "k", "b", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f44042a = new b();

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    @yt.k
    public final r0 a(@yt.k File file) {
        kotlin.jvm.internal.f0.p(file, "file");
        return f0.a(file);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    @yt.k
    public final r0 b() {
        return f0.c();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "sink.buffer()", imports = {"okio.buffer"}))
    @yt.k
    public final k c(@yt.k r0 sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        return f0.d(sink);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "source.buffer()", imports = {"okio.buffer"}))
    @yt.k
    public final l d(@yt.k t0 source) {
        kotlin.jvm.internal.f0.p(source, "source");
        return f0.e(source);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "file.sink()", imports = {"okio.sink"}))
    @yt.k
    public final r0 e(@yt.k File file) {
        kotlin.jvm.internal.f0.p(file, "file");
        return g0.q(file, false, 1, null);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "outputStream.sink()", imports = {"okio.sink"}))
    @yt.k
    public final r0 f(@yt.k OutputStream outputStream) {
        kotlin.jvm.internal.f0.p(outputStream, "outputStream");
        return f0.p(outputStream);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "socket.sink()", imports = {"okio.sink"}))
    @yt.k
    public final r0 g(@yt.k Socket socket) {
        kotlin.jvm.internal.f0.p(socket, "socket");
        return f0.q(socket);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "path.sink(*options)", imports = {"okio.sink"}))
    @yt.k
    public final r0 h(@yt.k Path path, @yt.k OpenOption... options) {
        kotlin.jvm.internal.f0.p(path, "path");
        kotlin.jvm.internal.f0.p(options, "options");
        return f0.r(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "file.source()", imports = {"okio.source"}))
    @yt.k
    public final t0 i(@yt.k File file) {
        kotlin.jvm.internal.f0.p(file, "file");
        return f0.t(file);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "inputStream.source()", imports = {"okio.source"}))
    @yt.k
    public final t0 j(@yt.k InputStream inputStream) {
        kotlin.jvm.internal.f0.p(inputStream, "inputStream");
        return f0.u(inputStream);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "socket.source()", imports = {"okio.source"}))
    @yt.k
    public final t0 k(@yt.k Socket socket) {
        kotlin.jvm.internal.f0.p(socket, "socket");
        return f0.v(socket);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "path.source(*options)", imports = {"okio.source"}))
    @yt.k
    public final t0 l(@yt.k Path path, @yt.k OpenOption... options) {
        kotlin.jvm.internal.f0.p(path, "path");
        kotlin.jvm.internal.f0.p(options, "options");
        return f0.w(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }
}
