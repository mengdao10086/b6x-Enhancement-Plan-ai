package a;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.omarea.Scene;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vi0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7699a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static vi0 f3288a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public final void a(Context context) {
            f92.d(context, "context");
            if (vi0.f3288a == null) {
                vi0.f3288a = new vi0();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
                context.registerReceiver(vi0.f3288a, intentFilter);
            }
        }
    }

    public final boolean a(String str, String str2) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(str2)));
            new qj0().a(new File(str), "", zipOutputStream);
            zipOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean d(Context context, String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                return false;
            }
            ZipFile zipFile = new ZipFile(file);
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            String strSubstring = "";
            File cacheDir = context.getCacheDir();
            f92.b(cacheDir);
            String absolutePath = new File(cacheDir.getAbsolutePath()).getAbsolutePath();
            boolean z = true;
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                String name = nextEntry.getName();
                f92.c(name, "zipEntry.getName()");
                String canonicalPath = new File("/data", name).getCanonicalPath();
                f92.c(canonicalPath, "vFile.canonicalPath");
                if (bc2.x(canonicalPath, "/data", false, 2, null)) {
                    if (z) {
                        int length = name.length() - 1;
                        if (name == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        strSubstring = name.substring(0, length);
                        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        z = false;
                    }
                    File file2 = new File(absolutePath + File.separator + name);
                    if (nextEntry.isDirectory()) {
                        new File(absolutePath + File.separator + name).mkdirs();
                    } else {
                        File parentFile = file2.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        byte[] bArr = new byte[1024];
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        InputStream inputStream = zipFile.getInputStream(nextEntry);
                        f92.c(inputStream, "zipFile.getInputStream(zipEntry)");
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        fileOutputStream.close();
                        inputStream.close();
                    }
                } else {
                    Log.e("Scene", "Module(Zip) SecurityException EntryName: " + name);
                }
            }
            zipInputStream.close();
            return a(absolutePath + '/' + strSubstring, str);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f92.d(context, "context");
        f92.d(intent, "intent");
        if (f92.a("android.intent.action.DOWNLOAD_COMPLETE", intent.getAction())) {
            try {
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                Object systemService = context.getSystemService("download");
                try {
                    if (systemService == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
                    }
                    DownloadManager downloadManager = (DownloadManager) systemService;
                    TextUtils.isEmpty(downloadManager.getMimeTypeForDownloadedFile(longExtra));
                    Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(longExtra);
                    mk mkVarE = mk.e(context, uriForDownloadedFile);
                    f92.b(mkVarE);
                    String strG = mkVarE.g();
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uriForDownloadedFile);
                    byte[] bArrC = inputStreamOpenInputStream != null ? j72.c(inputStreamOpenInputStream) : null;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MagiskReCompress", 0);
                    if (!sharedPreferences.contains("" + longExtra)) {
                        Scene.f4798a.o(mkVarE.g() + ", OK!", 1);
                        return;
                    }
                    String string = sharedPreferences.getString("" + longExtra, strG);
                    if (string == null) {
                        string = "Scene_Download_" + longExtra;
                    } else if (bc2.o(string, ".zip", false, 2, null)) {
                        string = string.substring(0, ec2.S(string, ".", 0, false, 6, null));
                        f92.c(string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    StringBuilder sb = new StringBuilder();
                    File cacheDir = context.getCacheDir();
                    f92.b(cacheDir);
                    sb.append(cacheDir.getAbsolutePath());
                    sb.append("/cache_");
                    sb.append(longExtra);
                    sb.append(".zip");
                    File file = new File(sb.toString());
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArrC);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), '/' + string + ".zip");
                    String absolutePath = file2.getAbsolutePath();
                    f92.c(absolutePath, "sdcardFile.absolutePath");
                    String absolutePath2 = file.getAbsolutePath();
                    f92.c(absolutePath2, "fileOut.absolutePath");
                    if (d(context, absolutePath, absolutePath2)) {
                        Scene.f4798a.o(file2.getAbsolutePath() + ", OK!", 1);
                    } else {
                        Scene.c.p(Scene.f4798a, string + ", Unable to save!", 0, 2, null);
                    }
                    downloadManager.remove(longExtra);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        }
    }
}
