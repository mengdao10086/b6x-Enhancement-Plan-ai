package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiDexExtractor implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6367g = "MultiDex";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f6368h = "classes";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f6369i = ".dex";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f6370j = ".classes";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f6371k = ".zip";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6372l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f6373m = "multidex.version";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f6374n = "timestamp";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f6375o = "crc";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f6376p = "dex.number";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f6377q = "dex.crc.";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f6378r = "dex.time.";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6379s = 16384;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f6380t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f6381u = "MultiDex.lock";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f6382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f6384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f6385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FileChannel f6386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FileLock f6387f;

    public static class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals(MultiDexExtractor.f6381u);
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MultiDexExtractor(");
        sb2.append(file.getPath());
        sb2.append(", ");
        sb2.append(file2.getPath());
        sb2.append(ee.a.f26979d);
        this.f6382a = file;
        this.f6384c = file2;
        this.f6383b = i(file);
        File file3 = new File(file2, f6381u);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f6385d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f6386e = channel;
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Blocking on lock ");
                sb3.append(file3.getPath());
                this.f6387f = channel.lock();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(file3.getPath());
                sb4.append(" locked");
            } catch (IOException e10) {
                e = e10;
                c(this.f6386e);
                throw e;
            } catch (Error e11) {
                e = e11;
                c(this.f6386e);
                throw e;
            } catch (RuntimeException e12) {
                e = e12;
                c(this.f6386e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e13) {
            c(this.f6385d);
            throw e13;
        }
    }

    public static void c(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void d(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i10 = inputStream.read(bArr); i10 != -1; i10 = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i10);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th2) {
                zipOutputStream.close();
                throw th2;
            }
        } finally {
            c(inputStream);
            fileCreateTempFile.delete();
        }
    }

    public static SharedPreferences f(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    public static long h(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    public static long i(File file) throws IOException {
        long jC = d.c(file);
        return jC == -1 ? jC - 1 : jC;
    }

    public static boolean k(Context context, File file, long j10, String str) {
        SharedPreferences sharedPreferencesF = f(context);
        if (sharedPreferencesF.getLong(str + "timestamp", -1L) == h(file)) {
            if (sharedPreferencesF.getLong(str + f6375o, -1L) == j10) {
                return false;
            }
        }
        return true;
    }

    public static void u(Context context, String str, long j10, long j11, List<ExtractedDex> list) {
        SharedPreferences.Editor editorEdit = f(context).edit();
        editorEdit.putLong(str + "timestamp", j10);
        editorEdit.putLong(str + f6375o, j11);
        editorEdit.putInt(str + "dex.number", list.size() + 1);
        int i10 = 2;
        for (ExtractedDex extractedDex : list) {
            editorEdit.putLong(str + f6377q + i10, extractedDex.crc);
            editorEdit.putLong(str + f6378r + i10, extractedDex.lastModified());
            i10++;
        }
        editorEdit.commit();
    }

    public final void a() {
        File[] fileArrListFiles = this.f6384c.listFiles(new a());
        if (fileArrListFiles == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to list secondary dex dir content (");
            sb2.append(this.f6384c.getPath());
            sb2.append(").");
            return;
        }
        for (File file : fileArrListFiles) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Trying to delete old file ");
            sb3.append(file.getPath());
            sb3.append(" of size ");
            sb3.append(file.length());
            if (file.delete()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Failed to delete old file ");
                sb5.append(file.getPath());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6387f.release();
        this.f6386e.close();
        this.f6385d.close();
    }

    public List<? extends File> l(Context context, String str, boolean z10) throws IOException {
        List<ExtractedDex> listN;
        List<ExtractedDex> listM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MultiDexExtractor.load(");
        sb2.append(this.f6382a.getPath());
        sb2.append(", ");
        sb2.append(z10);
        sb2.append(", ");
        sb2.append(str);
        sb2.append(ee.a.f26979d);
        if (!this.f6387f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z10 && !k(context, this.f6382a, this.f6383b, str)) {
            try {
                listM = m(context, str);
            } catch (IOException unused) {
                listN = n();
                u(context, str, h(this.f6382a), this.f6383b, listN);
                listM = listN;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("load found ");
            sb3.append(listM.size());
            sb3.append(" secondary dex files");
            return listM;
        }
        listN = n();
        u(context, str, h(this.f6382a), this.f6383b, listN);
        listM = listN;
        StringBuilder sb32 = new StringBuilder();
        sb32.append("load found ");
        sb32.append(listM.size());
        sb32.append(" secondary dex files");
        return listM;
    }

    public final List<ExtractedDex> m(Context context, String str) throws IOException {
        String str2 = this.f6382a.getName() + ".classes";
        SharedPreferences sharedPreferencesF = f(context);
        int i10 = sharedPreferencesF.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i10 + (-1));
        int i11 = 2;
        while (i11 <= i10) {
            ExtractedDex extractedDex = new ExtractedDex(this.f6384c, str2 + i11 + ".zip");
            if (!extractedDex.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            extractedDex.crc = i(extractedDex);
            long j10 = sharedPreferencesF.getLong(str + f6377q + i11, -1L);
            long j11 = sharedPreferencesF.getLong(str + f6378r + i11, -1L);
            long jLastModified = extractedDex.lastModified();
            if (j11 == jLastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = sharedPreferencesF;
                if (j10 == extractedDex.crc) {
                    arrayList.add(extractedDex);
                    i11++;
                    sharedPreferencesF = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j11 + ", modification time: " + jLastModified + ", expected crc: " + j10 + ", file crc: " + extractedDex.crc);
        }
        return arrayList;
    }

    public final List<ExtractedDex> n() throws IOException {
        String str = this.f6382a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f6382a);
        int i10 = 2;
        try {
            ZipEntry entry = zipFile.getEntry(f6368h + 2 + f6369i);
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.f6384c, str + i10 + ".zip");
                arrayList.add(extractedDex);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Extraction is needed for file ");
                sb2.append(extractedDex);
                int i11 = 0;
                boolean z10 = false;
                while (i11 < 3 && !z10) {
                    i11++;
                    d(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.crc = i(extractedDex);
                        z10 = true;
                    } catch (IOException unused) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to read crc from ");
                        sb3.append(extractedDex.getAbsolutePath());
                        z10 = false;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Extraction ");
                    sb4.append(z10 ? "succeeded" : "failed");
                    sb4.append(" '");
                    sb4.append(extractedDex.getAbsolutePath());
                    sb4.append("': length ");
                    sb4.append(extractedDex.length());
                    sb4.append(" - crc: ");
                    sb4.append(extractedDex.crc);
                    if (!z10) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Failed to delete corrupted secondary dex '");
                            sb5.append(extractedDex.getPath());
                            sb5.append("'");
                        }
                    }
                }
                if (!z10) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i10 + ee.a.f26979d);
                }
                i10++;
                entry = zipFile.getEntry(f6368h + i10 + f6369i);
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
    }
}
