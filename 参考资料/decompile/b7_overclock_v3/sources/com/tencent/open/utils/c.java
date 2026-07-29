package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f22798c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f22800b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f22801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f22802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference<Activity> f22803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f22804g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            boolean zA;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + k.g(c.this.f22799a) + hd.k.S;
            String str2 = c.f22798c + str;
            File file = new File(str2);
            Message messageObtainMessage = c.this.f22802e.obtainMessage();
            if (file.exists()) {
                messageObtainMessage.arg1 = 0;
                messageObtainMessage.obj = str2;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.f22801d));
            } else {
                Bitmap bitmapA = c.a(c.this.f22799a);
                if (bitmapA != null) {
                    zA = c.this.a(bitmapA, str);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    zA = false;
                }
                if (zA) {
                    messageObtainMessage.arg1 = 0;
                    messageObtainMessage.obj = str2;
                } else {
                    messageObtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.f22801d));
            }
            c.this.f22802e.sendMessage(messageObtainMessage);
        }
    };

    public c(Activity activity) {
        this.f22803f = new WeakReference<>(activity);
        this.f22802e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    c.this.f22800b.a(message.arg1, (String) message.obj);
                } else {
                    c.this.f22800b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!k.a()) {
                dVar.a(2, (String) null);
                return;
            }
            if (this.f22803f.get() != null) {
                Activity activity = this.f22803f.get();
                File fileH = k.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (fileH == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i.d(activity) ? fileH.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                    sb2.append("/tmp/");
                    f22798c = sb2.toString();
                }
            }
            this.f22801d = System.currentTimeMillis();
            this.f22799a = str;
            this.f22800b = dVar;
            new Thread(this.f22804g).start();
            return;
        }
        dVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        String str2 = f22798c;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.v("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
                return true;
            } catch (IOException e11) {
                e11.printStackTrace();
                return true;
            }
        } catch (IOException e12) {
            e = e12;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Bitmap a(String str) {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return bitmapDecodeStream;
        } catch (IOException e10) {
            e10.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
