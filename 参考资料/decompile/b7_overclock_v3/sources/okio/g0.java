package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.text.StringsKt__StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0006\u001a\u0016\u0010\f\u001a\u00020\u0001*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\t\u001a'\u0010\u0013\u001a\u00020\u0001*\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u0004*\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0012\u0010\u001a\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u0012\u0010\u001c\u001a\u00020\u001b*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u0012\u0010 \u001a\u00020\u001f*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001d\u001a\u0012\u0010\"\u001a\u00020!*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d\u001a\u0012\u0010%\u001a\u00020\u001f*\u00020\u00012\u0006\u0010$\u001a\u00020#\u001a\u0012\u0010&\u001a\u00020!*\u00020\u00042\u0006\u0010$\u001a\u00020#\u001a\u0012\u0010*\u001a\u00020'*\u00020'2\u0006\u0010)\u001a\u00020(\u001a\n\u0010,\u001a\u00020'*\u00020+\"\u001c\u00101\u001a\n .*\u0004\u0018\u00010-0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\"\u001c\u00106\u001a\u00020\n*\u000602j\u0002`38@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Ljava/io/OutputStream;", "Lokio/r0;", "n", "Ljava/io/InputStream;", "Lokio/t0;", an.aB, "Ljava/net/Socket;", "o", "t", "Ljava/io/File;", "", "append", m0.k.f40564b, "b", SsManifestParser.e.J, "Ljava/nio/file/Path;", "", "Ljava/nio/file/OpenOption;", "options", "p", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/r0;", "u", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/t0;", "Ljavax/crypto/Cipher;", "cipher", "Lokio/m;", "d", "Lokio/n;", "e", "Ljavax/crypto/Mac;", SocializeProtocolConstants.PROTOCOL_KEY_MAC, "Lokio/y;", "g", "Lokio/z;", "i", "Ljava/security/MessageDigest;", so.d.f50128b, "f", "h", "Lokio/s;", "Lokio/k0;", "zipPath", "k", "Ljava/lang/ClassLoader;", "c", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "a", "Ljava/util/logging/Logger;", "logger", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", xf.j.f55230b, "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "okio"}, k = 5, mv = {1, 5, 1}, xs = "okio/Okio")
public final /* synthetic */ class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f44057a = Logger.getLogger("okio.Okio");

    @yt.k
    public static final r0 b(@yt.k File file) throws FileNotFoundException {
        kotlin.jvm.internal.f0.p(file, "<this>");
        return f0.p(new FileOutputStream(file, true));
    }

    @yt.k
    public static final s c(@yt.k ClassLoader classLoader) {
        kotlin.jvm.internal.f0.p(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true);
    }

    @yt.k
    public static final m d(@yt.k r0 r0Var, @yt.k Cipher cipher) {
        kotlin.jvm.internal.f0.p(r0Var, "<this>");
        kotlin.jvm.internal.f0.p(cipher, "cipher");
        return new m(f0.d(r0Var), cipher);
    }

    @yt.k
    public static final n e(@yt.k t0 t0Var, @yt.k Cipher cipher) {
        kotlin.jvm.internal.f0.p(t0Var, "<this>");
        kotlin.jvm.internal.f0.p(cipher, "cipher");
        return new n(f0.e(t0Var), cipher);
    }

    @yt.k
    public static final y f(@yt.k r0 r0Var, @yt.k MessageDigest digest) {
        kotlin.jvm.internal.f0.p(r0Var, "<this>");
        kotlin.jvm.internal.f0.p(digest, "digest");
        return new y(r0Var, digest);
    }

    @yt.k
    public static final y g(@yt.k r0 r0Var, @yt.k Mac mac) {
        kotlin.jvm.internal.f0.p(r0Var, "<this>");
        kotlin.jvm.internal.f0.p(mac, "mac");
        return new y(r0Var, mac);
    }

    @yt.k
    public static final z h(@yt.k t0 t0Var, @yt.k MessageDigest digest) {
        kotlin.jvm.internal.f0.p(t0Var, "<this>");
        kotlin.jvm.internal.f0.p(digest, "digest");
        return new z(t0Var, digest);
    }

    @yt.k
    public static final z i(@yt.k t0 t0Var, @yt.k Mac mac) {
        kotlin.jvm.internal.f0.p(t0Var, "<this>");
        kotlin.jvm.internal.f0.p(mac, "mac");
        return new z(t0Var, mac);
    }

    public static final boolean j(@yt.k AssertionError assertionError) {
        kotlin.jvm.internal.f0.p(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message == null ? false : StringsKt__StringsKt.W2(message, "getsockname failed", false, 2, null);
    }

    @yt.k
    public static final s k(@yt.k s sVar, @yt.k k0 zipPath) throws IOException {
        kotlin.jvm.internal.f0.p(sVar, "<this>");
        kotlin.jvm.internal.f0.p(zipPath, "zipPath");
        return ZipKt.e(zipPath, sVar, null, 4, null);
    }

    @hk.i
    @yt.k
    public static final r0 l(@yt.k File file) throws FileNotFoundException {
        kotlin.jvm.internal.f0.p(file, "<this>");
        return q(file, false, 1, null);
    }

    @hk.i
    @yt.k
    public static final r0 m(@yt.k File file, boolean z10) throws FileNotFoundException {
        kotlin.jvm.internal.f0.p(file, "<this>");
        return f0.p(new FileOutputStream(file, z10));
    }

    @yt.k
    public static final r0 n(@yt.k OutputStream outputStream) {
        kotlin.jvm.internal.f0.p(outputStream, "<this>");
        return new j0(outputStream, new v0());
    }

    @yt.k
    public static final r0 o(@yt.k Socket socket) throws IOException {
        kotlin.jvm.internal.f0.p(socket, "<this>");
        s0 s0Var = new s0(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.f0.o(outputStream, "getOutputStream()");
        return s0Var.A(new j0(outputStream, s0Var));
    }

    @yt.k
    @IgnoreJRERequirement
    public static final r0 p(@yt.k Path path, @yt.k OpenOption... options) throws IOException {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.f0.o(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        return f0.p(outputStreamNewOutputStream);
    }

    public static /* synthetic */ r0 q(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return f0.o(file, z10);
    }

    @yt.k
    public static final t0 r(@yt.k File file) throws FileNotFoundException {
        kotlin.jvm.internal.f0.p(file, "<this>");
        return new b0(new FileInputStream(file), v0.f44220e);
    }

    @yt.k
    public static final t0 s(@yt.k InputStream inputStream) {
        kotlin.jvm.internal.f0.p(inputStream, "<this>");
        return new b0(inputStream, new v0());
    }

    @yt.k
    public static final t0 t(@yt.k Socket socket) throws IOException {
        kotlin.jvm.internal.f0.p(socket, "<this>");
        s0 s0Var = new s0(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.f0.o(inputStream, "getInputStream()");
        return s0Var.B(new b0(inputStream, s0Var));
    }

    @yt.k
    @IgnoreJRERequirement
    public static final t0 u(@yt.k Path path, @yt.k OpenOption... options) throws IOException {
        kotlin.jvm.internal.f0.p(path, "<this>");
        kotlin.jvm.internal.f0.p(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.f0.o(inputStreamNewInputStream, "newInputStream(this, *options)");
        return f0.u(inputStreamNewInputStream);
    }
}
