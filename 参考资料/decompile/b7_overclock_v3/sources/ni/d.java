package ni;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.objectbox.BoxStore;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42197a = "objectbox-jni";

    static {
        String str;
        boolean z10;
        String str2;
        String str3;
        String str4 = f42197a + ".so";
        String property = System.getProperty("java.vendor");
        String lowerCase = System.getProperty("os.name").toLowerCase();
        boolean zContains = property.contains("Android");
        if (zContains) {
            str = f42197a;
            z10 = true;
        } else {
            if (lowerCase.contains(SocializeProtocolConstants.PROTOCOL_KEY_MAC)) {
                str2 = f42197a + "-macos";
                str3 = x9.d.f54956g + str2 + ".dylib";
                a(str3);
            } else {
                String str5 = "-" + c();
                if (lowerCase.contains("windows")) {
                    str2 = f42197a + "-windows" + str5;
                    str3 = str2 + ".dll";
                    a(str3);
                } else {
                    if (lowerCase.contains("linux")) {
                        str2 = f42197a + "-linux" + str5;
                        str3 = x9.d.f54956g + str2 + ".so";
                        a(str3);
                        z10 = true;
                        String str6 = str3;
                        str = str2;
                        str4 = str6;
                    }
                    str = f42197a;
                    z10 = true;
                }
            }
            z10 = false;
            String str62 = str3;
            str = str2;
            str4 = str62;
        }
        try {
            File file = new File(str4);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                return;
            }
            try {
                if (!zContains) {
                    System.err.println("File not available: " + file.getAbsolutePath());
                    System.loadLibrary(str);
                } else if (!f()) {
                    System.loadLibrary(str);
                }
            } catch (UnsatisfiedLinkError e10) {
                if (zContains || !z10) {
                    throw e10;
                }
                if (f()) {
                    return;
                }
                System.loadLibrary(f42197a);
            }
        } catch (UnsatisfiedLinkError e11) {
            String property2 = System.getProperty("os.arch");
            throw new LinkageError(zContains ? String.format("[ObjectBox] Android failed to load native library, check your APK/App Bundle includes a supported ABI or use ReLinker https://docs.objectbox.io/android/app-bundle-and-split-apk (vendor=%s,os=%s,os.arch=%s,SUPPORTED_ABIS=%s)", property, lowerCase, property2, e()) : String.format("[ObjectBox] Loading native library failed, please report this to us: vendor=%s,os=%s,os.arch=%s,model=%s,linux=%s,machine=%s", property, lowerCase, property2, System.getProperty("sun.arch.data.model"), Boolean.valueOf(z10), d()), e11);
        }
    }

    public static void a(String str) {
        String str2 = "/native/" + str;
        URL resource = d.class.getResource(str2);
        if (resource == null) {
            System.err.println("Not available in classpath: " + str2);
            return;
        }
        File file = new File(str);
        try {
            URLConnection uRLConnectionOpenConnection = resource.openConnection();
            int contentLength = uRLConnectionOpenConnection.getContentLength();
            long lastModified = uRLConnectionOpenConnection.getLastModified();
            if (file.exists() && file.length() == contentLength && file.lastModified() == lastModified) {
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    st.c.a(bufferedInputStream, bufferedOutputStream);
                    st.c.j(bufferedInputStream);
                    if (lastModified > 0) {
                        file.setLastModified(lastModified);
                    }
                } finally {
                    st.c.j(bufferedOutputStream);
                }
            } catch (Throwable th2) {
                st.c.j(bufferedInputStream);
                throw th2;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static void b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7 A[PHI: r0
  0x00a7: PHI (r0v2 java.lang.String) = (r0v1 java.lang.String), (r0v6 java.lang.String) binds: [B:3:0x0013, B:20:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ni.d.c():java.lang.String");
    }

    @Nullable
    public static String d() {
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("uname -m").getInputStream()));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (Exception unused) {
            return line;
        }
    }

    @Nonnull
    public static String e() {
        String[] strArr = null;
        try {
            strArr = (String[]) Class.forName("android.os.Build").getField("SUPPORTED_ABIS").get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
        }
        return strArr != null ? Arrays.toString(strArr) : "";
    }

    public static boolean f() {
        if (BoxStore.h1() == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            if (BoxStore.L1() == null) {
                x9.c.class.getMethod("loadLibrary", cls, String.class, String.class).invoke(null, BoxStore.h1(), f42197a, BoxStore.f32615z);
            } else {
                BoxStore.L1().getClass().getMethod("loadLibrary", cls, String.class, String.class).invoke(BoxStore.L1(), BoxStore.h1(), f42197a, BoxStore.f32615z);
            }
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }
}
