package x9;

import android.annotation.SuppressLint;
import android.os.Build;
import x9.c;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements c.b {
    @Override // x9.c.b
    public String a(final String libraryName) {
        return (libraryName.startsWith(d.f54956g) && libraryName.endsWith(".so")) ? libraryName : System.mapLibraryName(libraryName);
    }

    @Override // x9.c.b
    public String b(String mappedLibraryName) {
        return mappedLibraryName.substring(3, mappedLibraryName.length() - 3);
    }

    @Override // x9.c.b
    public String[] c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // x9.c.b
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public void d(final String libraryPath) {
        System.load(libraryPath);
    }

    @Override // x9.c.b
    public void loadLibrary(final String libraryName) {
        System.loadLibrary(libraryName);
    }
}
