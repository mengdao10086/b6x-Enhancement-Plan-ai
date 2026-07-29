package x9;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    public interface a {
        void a(Context context, String[] abis, String mappedLibraryName, File destination, x9.d logger);
    }

    public interface b {
        String a(String libraryName);

        String b(String mappedLibraryName);

        String[] c();

        void d(String libraryPath);

        void loadLibrary(String libraryName);
    }

    /* JADX INFO: renamed from: x9.c$c, reason: collision with other inner class name */
    public interface InterfaceC0648c {
        void a();

        void b(Throwable t10);
    }

    public interface d {
        void a(String message);
    }

    public static x9.d a() {
        return new x9.d().c();
    }

    public static void b(final Context context, final String library) {
        d(context, library, null, null);
    }

    public static void c(final Context context, final String library, final String version) {
        d(context, library, version, null);
    }

    public static void d(final Context context, final String library, final String version, final InterfaceC0648c listener) {
        new x9.d().h(context, library, version, listener);
    }

    public static void e(final Context context, final String library, final InterfaceC0648c listener) {
        d(context, library, null, listener);
    }

    public static x9.d f(final d logger) {
        return new x9.d().k(logger);
    }

    public static x9.d g() {
        return new x9.d().n();
    }
}
