package x9;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.getkeepsafe.relinker.MissingLibraryException;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import x9.c;

/* JADX INFO: loaded from: classes3.dex */
public class a implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f54949a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f54950b = 4096;

    /* JADX INFO: renamed from: x9.a$a, reason: collision with other inner class name */
    public static class C0647a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f54951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f54952b;

        public C0647a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f54951a = zipFile;
            this.f54952b = zipEntry;
        }
    }

    @Override // x9.c.a
    @SuppressLint({"SetWorldReadable"})
    public void a(Context context, String[] strArr, String str, File file, d dVar) throws Throwable {
        C0647a c0647aD;
        String[] strArrE;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long jC;
        C0647a c0647a = null;
        Closeable closeable = null;
        try {
            c0647aD = d(context, strArr, str, dVar);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (c0647aD == null) {
                try {
                    strArrE = e(context, str);
                } catch (Exception e10) {
                    strArrE = new String[]{e10.toString()};
                }
                throw new MissingLibraryException(str, strArr, strArrE);
            }
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i10 >= 5) {
                    dVar.l("FATAL! Couldn't extract the library from the APK!");
                    try {
                        ZipFile zipFile = c0647aD.f54951a;
                        if (zipFile != null) {
                            zipFile.close();
                            return;
                        }
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                dVar.m("Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = c0647aD.f54951a.getInputStream(c0647aD.f54952b);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    jC = c(inputStream, fileOutputStream);
                                    fileOutputStream.getFD().sync();
                                } catch (FileNotFoundException unused2) {
                                    b(inputStream);
                                } catch (IOException unused3) {
                                    b(inputStream);
                                } catch (Throwable th3) {
                                    th = th3;
                                    closeable = inputStream;
                                    b(closeable);
                                    b(fileOutputStream);
                                    throw th;
                                }
                            } catch (FileNotFoundException unused4) {
                                fileOutputStream = null;
                            } catch (IOException unused5) {
                                fileOutputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                        } catch (FileNotFoundException unused6) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (IOException unused7) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                        }
                        if (jC == file.length()) {
                            b(inputStream);
                            b(fileOutputStream);
                            file.setReadable(true, false);
                            file.setExecutable(true, false);
                            file.setWritable(true);
                            try {
                                ZipFile zipFile2 = c0647aD.f54951a;
                                if (zipFile2 != null) {
                                    zipFile2.close();
                                    return;
                                }
                                return;
                            } catch (IOException unused8) {
                                return;
                            }
                        }
                        b(inputStream);
                        b(fileOutputStream);
                    }
                } catch (IOException unused9) {
                }
                i10 = i11;
            }
        } catch (Throwable th6) {
            th = th6;
            c0647a = c0647aD;
            if (c0647a != null) {
                try {
                    ZipFile zipFile3 = c0647a.f54951a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }

    public final void b(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final long c(InputStream in2, OutputStream out) throws IOException {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int i10 = in2.read(bArr);
            if (i10 == -1) {
                out.flush();
                return j10;
            }
            out.write(bArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public final C0647a d(final Context context, final String[] abis, final String mappedLibraryName, final d instance) {
        String[] strArrF = f(context);
        int length = strArrF.length;
        char c10 = 0;
        int i10 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i10 >= length) {
                return null;
            }
            String str = strArrF[i10];
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str), 1);
                    break;
                } catch (IOException unused) {
                    i11 = i12;
                }
            }
            if (zipFile != null) {
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    if (i13 < 5) {
                        int length2 = abis.length;
                        int i15 = 0;
                        while (i15 < length2) {
                            String str2 = d.f54956g + File.separatorChar + abis[i15] + File.separatorChar + mappedLibraryName;
                            Object[] objArr = new Object[2];
                            objArr[c10] = str2;
                            objArr[1] = str;
                            instance.m("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str2);
                            if (entry != null) {
                                return new C0647a(zipFile, entry);
                            }
                            i15++;
                            c10 = 0;
                        }
                        i13 = i14;
                        c10 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i10++;
            c10 = 0;
        }
    }

    public final String[] e(Context context, String mappedLibraryName) {
        Pattern patternCompile = Pattern.compile(d.f54956g + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + mappedLibraryName);
        HashSet hashSet = new HashSet();
        for (String str : f(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final String[] f(final Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
