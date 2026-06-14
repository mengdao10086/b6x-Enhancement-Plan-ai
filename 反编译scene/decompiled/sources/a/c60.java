package a;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c60 f5764a = new c60();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f356a;

    static {
        String absolutePath;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            f92.c(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
            absolutePath = externalStorageDirectory.getAbsolutePath();
            f92.c(absolutePath, "Environment.getExternalS…eDirectory().absolutePath");
        } catch (Exception unused) {
            absolutePath = "/data/media/0";
        }
        f356a = absolutePath;
    }

    public final byte[] a(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "fileName");
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            f92.c(inputStreamOpen, "assetManager.open(fileName)");
            byte[] bArr = new byte[inputStreamOpen.available()];
            int i = inputStreamOpen.read(bArr);
            if (i < 0) {
                i = 0;
            }
            String strG = new nb2("\r\t").g(new nb2("\r\n").g(new String(bArr, 0, i, bb2.f5692a), "\n"), "\t");
            Charset charset = bb2.f5692a;
            if (strG == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = strG.getBytes(charset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (Exception e) {
            Log.e("script-parse", "" + e.getMessage());
            byte[] bytes2 = "".getBytes(bb2.f5692a);
            f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
            return bytes2;
        }
    }

    public final byte[] b(byte[] bArr) {
        f92.d(bArr, "bytes");
        try {
            String strG = new nb2("\r\t").g(new nb2("\r\n").g(new String(bArr, bb2.f5692a), "\n"), "\t");
            Charset charset = bb2.f5692a;
            if (strG == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = strG.getBytes(charset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (Exception e) {
            Log.e("script-parse", "" + e.getMessage());
            byte[] bytes2 = "".getBytes(bb2.f5692a);
            f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
            return bytes2;
        }
    }

    public final String c(Context context) {
        f92.d(context, "context");
        StringBuilder sb = new StringBuilder();
        File filesDir = context.getFilesDir();
        f92.c(filesDir, "context.filesDir");
        sb.append(filesDir.getAbsolutePath());
        sb.append("/");
        return sb.toString();
    }

    public final String d(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "outName");
        StringBuilder sb = new StringBuilder();
        sb.append(c(context));
        if (bc2.x(str, "/", false, 2, null)) {
            str = str.substring(1, str.length());
            f92.c(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        sb.append(str);
        return sb.toString();
    }

    public final String e() {
        return f356a;
    }

    public final String f(Context context, String str, boolean z) {
        f92.d(context, "context");
        f92.d(str, "file");
        File externalFilesDir = context.getExternalFilesDir(null);
        File parentFile = externalFilesDir != null ? externalFilesDir.getParentFile() : null;
        if (parentFile == null) {
            parentFile = new File(f356a + "/Android/data/" + context.getPackageName());
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parentFile.getAbsolutePath());
        sb.append("/");
        if (!z) {
            str = gc2.t0(str, ec2.S(str, ".", 0, false, 6, null) > 0 ? ec2.S(str, ".", 0, false, 6, null) : str.length());
        }
        sb.append(str);
        String string = sb.toString();
        File parentFile2 = new File(string).getParentFile();
        if (!parentFile2.exists()) {
            parentFile2.mkdirs();
        }
        return string;
    }

    public final byte[] g(File file) {
        f92.d(file, "file");
        return file.exists() ? o72.b(file) : new byte[0];
    }

    public final byte[] h(Context context, String str) throws IOException {
        f92.d(context, "context");
        f92.d(str, "file");
        boolean zX = bc2.x(str, "file:///android_asset/", false, 2, null);
        AssetManager assets = context.getAssets();
        if (zX) {
            str = str.substring(22);
            f92.c(str, "(this as java.lang.String).substring(startIndex)");
        }
        InputStream inputStreamOpen = assets.open(str);
        f92.c(inputStreamOpen, "if (file.startsWith(\"fil…sets.open(file)\n        }");
        return j72.c(inputStreamOpen);
    }

    public final void i(File file, byte[] bArr) {
        f92.d(file, "file");
        f92.d(bArr, "bytes");
        file.getParentFile().mkdirs();
        o72.e(file, bArr);
    }

    public final String j(AssetManager assetManager, String str, String str2, Context context) {
        f92.d(assetManager, "assetManager");
        f92.d(str, "file");
        f92.d(str2, "outName");
        f92.d(context, "context");
        try {
            if (bc2.x(str, "file:///android_asset/", false, 2, null)) {
                str = str.substring(22);
                f92.c(str, "(this as java.lang.String).substring(startIndex)");
            }
            InputStream inputStreamOpen = assetManager.open(str);
            f92.c(inputStreamOpen, "if (file.startsWith(\"fil….open(file)\n            }");
            File file = new File(c(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String strD = d(context, str2);
            File parentFile = new File(strD).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(strD);
            byte[] bArr = new byte[20480];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    File file2 = new File(strD);
                    file2.setWritable(true, false);
                    file2.setExecutable(true, false);
                    file2.setReadable(true, false);
                    return strD;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            Log.e("writePrivateFile", "" + e.getMessage(), e.getCause());
            e.printStackTrace();
            return null;
        }
    }

    public final String k(String str, String str2, Context context) {
        f92.d(str, "file");
        f92.d(str2, "outName");
        f92.d(context, "context");
        AssetManager assets = context.getAssets();
        f92.c(assets, "context.assets");
        return j(assets, str, str2, context);
    }

    public final boolean l(byte[] bArr, String str, Context context) {
        f92.d(bArr, "bytes");
        f92.d(str, "outName");
        f92.d(context, "context");
        try {
            File file = new File(c(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            String strD = d(context, str);
            File parentFile = new File(strD).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(strD);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
            new File(strD).setExecutable(true, false);
            File file2 = new File(strD);
            file2.setWritable(true, false);
            file2.setExecutable(true, false);
            file2.setReadable(true, false);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String m(String str, String str2, Context context) {
        f92.d(str, "file");
        f92.d(str2, "outName");
        f92.d(context, "context");
        byte[] bArrA = a(context, str);
        if (bArrA.length <= 0 || !l(bArrA, str2, context)) {
            return null;
        }
        return d(context, str2);
    }

    public final String n(Context context, String str, boolean z) {
        InputStream inputStreamOpen;
        f92.d(context, "context");
        f92.d(str, "file");
        try {
            if (bc2.x(str, "file:///android_asset/", false, 2, null)) {
                AssetManager assets = context.getAssets();
                String strSubstring = str.substring(22);
                f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                inputStreamOpen = assets.open(strSubstring);
            } else {
                inputStreamOpen = context.getAssets().open(str);
            }
            f92.c(inputStreamOpen, "if (file.startsWith(\"fil….open(file)\n            }");
            String strF = f(context, str, z);
            FileOutputStream fileOutputStream = new FileOutputStream(strF);
            byte[] bArr = new byte[20480];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    File file = new File(strF);
                    file.setWritable(true, false);
                    file.setExecutable(true, false);
                    file.setReadable(true, false);
                    return strF;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String o(Context context, byte[] bArr, String str) {
        f92.d(context, "context");
        f92.d(bArr, "bytes");
        f92.d(str, "outName");
        try {
            String strF = f(context, str, true);
            FileOutputStream fileOutputStream = new FileOutputStream(strF);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
            File file = new File(strF);
            file.setWritable(true, false);
            file.setExecutable(true, false);
            file.setReadable(true, false);
            return strF;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
