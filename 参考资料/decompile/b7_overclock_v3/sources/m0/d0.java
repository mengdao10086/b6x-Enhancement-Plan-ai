package m0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.n0;
import g.p0;
import g.v0;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40523a = "TypefaceCompatUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40524b = ".font";

    @v0(19)
    public static class a {
        @g.u
        public static ParcelFileDescriptor a(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
        }
    }

    public static void a(@p0 Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @p0
    @v0(19)
    public static ByteBuffer b(@n0 Context context, @n0 Resources resources, int i10) {
        File fileE = e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (c(fileE, resources, i10)) {
                return g(fileE);
            }
            return null;
        } finally {
            fileE.delete();
        }
    }

    public static boolean c(@n0 File file, @n0 Resources resources, int i10) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i10);
            try {
                boolean zD = d(file, inputStreamOpenRawResource);
                a(inputStreamOpenRawResource);
                return zD;
            } catch (Throwable th2) {
                th = th2;
                a(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean d(@n0 File file, @n0 InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e11) {
            e = e11;
            fileOutputStream2 = fileOutputStream;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error copying resource contents to temp file: ");
            sb2.append(e.getMessage());
            a(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    @p0
    public static File e(@n0 Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = f40524b + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i10 = 0; i10 < 100; i10++) {
            File file = new File(cacheDir, str + i10);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    @p0
    @v0(19)
    public static ByteBuffer f(@n0 Context context, @p0 CancellationSignal cancellationSignal, @n0 Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorA = a.a(context.getContentResolver(), uri, SsManifestParser.e.J, cancellationSignal);
            if (parcelFileDescriptorA == null) {
                if (parcelFileDescriptorA != null) {
                    parcelFileDescriptorA.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorA.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorA.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @p0
    @v0(19)
    public static ByteBuffer g(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    @v0(19)
    public static Map<Uri, ByteBuffer> h(@n0 Context context, @n0 h.c[] cVarArr, @p0 CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (h.c cVar : cVarArr) {
            if (cVar.b() == 0) {
                Uri uriD = cVar.d();
                if (!map.containsKey(uriD)) {
                    map.put(uriD, f(context, cancellationSignal, uriD));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
