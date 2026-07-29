package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"okio/g0", "okio/h0"}, d2 = {}, k = 4, mv = {1, 5, 1})
public final class f0 {
    @yt.k
    public static final r0 a(@yt.k File file) throws FileNotFoundException {
        return g0.b(file);
    }

    @yt.k
    public static final s b(@yt.k ClassLoader classLoader) {
        return g0.c(classLoader);
    }

    @hk.h(name = "blackhole")
    @yt.k
    public static final r0 c() {
        return h0.a();
    }

    @yt.k
    public static final k d(@yt.k r0 r0Var) {
        return h0.b(r0Var);
    }

    @yt.k
    public static final l e(@yt.k t0 t0Var) {
        return h0.c(t0Var);
    }

    @yt.k
    public static final m f(@yt.k r0 r0Var, @yt.k Cipher cipher) {
        return g0.d(r0Var, cipher);
    }

    @yt.k
    public static final n g(@yt.k t0 t0Var, @yt.k Cipher cipher) {
        return g0.e(t0Var, cipher);
    }

    @yt.k
    public static final y h(@yt.k r0 r0Var, @yt.k MessageDigest messageDigest) {
        return g0.f(r0Var, messageDigest);
    }

    @yt.k
    public static final y i(@yt.k r0 r0Var, @yt.k Mac mac) {
        return g0.g(r0Var, mac);
    }

    @yt.k
    public static final z j(@yt.k t0 t0Var, @yt.k MessageDigest messageDigest) {
        return g0.h(t0Var, messageDigest);
    }

    @yt.k
    public static final z k(@yt.k t0 t0Var, @yt.k Mac mac) {
        return g0.i(t0Var, mac);
    }

    public static final boolean l(@yt.k AssertionError assertionError) {
        return g0.j(assertionError);
    }

    @yt.k
    public static final s m(@yt.k s sVar, @yt.k k0 k0Var) throws IOException {
        return g0.k(sVar, k0Var);
    }

    @hk.i
    @yt.k
    public static final r0 n(@yt.k File file) throws FileNotFoundException {
        return g0.l(file);
    }

    @hk.i
    @yt.k
    public static final r0 o(@yt.k File file, boolean z10) throws FileNotFoundException {
        return g0.m(file, z10);
    }

    @yt.k
    public static final r0 p(@yt.k OutputStream outputStream) {
        return g0.n(outputStream);
    }

    @yt.k
    public static final r0 q(@yt.k Socket socket) throws IOException {
        return g0.o(socket);
    }

    @yt.k
    @IgnoreJRERequirement
    public static final r0 r(@yt.k Path path, @yt.k OpenOption... openOptionArr) throws IOException {
        return g0.p(path, openOptionArr);
    }

    @yt.k
    public static final t0 t(@yt.k File file) throws FileNotFoundException {
        return g0.r(file);
    }

    @yt.k
    public static final t0 u(@yt.k InputStream inputStream) {
        return g0.s(inputStream);
    }

    @yt.k
    public static final t0 v(@yt.k Socket socket) throws IOException {
        return g0.t(socket);
    }

    @yt.k
    @IgnoreJRERequirement
    public static final t0 w(@yt.k Path path, @yt.k OpenOption... openOptionArr) throws IOException {
        return g0.u(path, openOptionArr);
    }

    public static final <T extends Closeable, R> R x(T t10, @yt.k ik.l<? super T, ? extends R> lVar) {
        return (R) h0.d(t10, lVar);
    }
}
