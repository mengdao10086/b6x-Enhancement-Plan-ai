package com.umeng.socialize.c.b;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import hd.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f24600b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24601a;

    private b() {
        this.f24601a = "";
        try {
            this.f24601a = ContextUtil.getContext().getCacheDir().getCanonicalPath();
        } catch (IOException e10) {
            SLog.error(e10);
        }
    }

    public static b a() {
        b bVar = f24600b;
        return bVar == null ? new b() : bVar;
    }

    public File b() throws IOException {
        File file = new File(c(), d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    public File c() throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 29) {
            string = ContextUtil.getContext().getExternalFilesDir(null).getPath();
        } else if (Environment.getExternalStorageDirectory() != null && !TextUtils.isEmpty(Environment.getExternalStorageDirectory().getCanonicalPath())) {
            string = Environment.getExternalStorageDirectory().getCanonicalPath();
        } else if (TextUtils.isEmpty(this.f24601a)) {
            string = DefaultClass.getString();
            SLog.E(UmengText.CACHE.SD_NOT_FOUNT);
        } else {
            string = this.f24601a;
            SLog.E(UmengText.CACHE.SD_NOT_FOUNT);
        }
        File file = new File(string + c.f24607f);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public String d() {
        return SocializeUtils.hexdigest(String.valueOf(System.currentTimeMillis())) + k.S;
    }

    public byte[] a(File file) {
        FileInputStream fileInputStream;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e10) {
                        SLog.error(UmengText.IMAGE.CLOSE, e10);
                    }
                    return byteArray;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        SLog.error(UmengText.IMAGE.READ_IMAGE_ERROR, th2);
                        if (fileInputStream != null) {
                            try {
                            } catch (IOException e11) {
                                return DefaultClass.getBytes();
                            }
                        }
                        return DefaultClass.getBytes();
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e112) {
                                SLog.error(UmengText.IMAGE.CLOSE, e112);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            fileInputStream = null;
            th2 = th5;
            byteArrayOutputStream = null;
        }
    }
}
