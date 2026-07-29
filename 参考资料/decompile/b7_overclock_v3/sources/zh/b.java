package zh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.core.os.h;
import androidx.fragment.app.Fragment;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f58584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Fragment> f58585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public th.a f58586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f58587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f58588e;

    public b(Activity activity) {
        this.f58584a = new WeakReference<>(activity);
        this.f58585b = null;
    }

    public static boolean e(Context context) {
        return context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public final File a() throws IOException {
        File externalFilesDir;
        String str = String.format("JPEG_%s.jpg", new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()));
        if (this.f58586c.f51283a) {
            externalFilesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
        } else {
            externalFilesDir = this.f58584a.get().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        }
        if (this.f58586c.f51285c != null) {
            File file = new File(externalFilesDir, this.f58586c.f51285c);
            if (!file.exists()) {
                file.mkdirs();
            }
            externalFilesDir = file;
        }
        File file2 = new File(externalFilesDir, str);
        if ("mounted".equals(h.a(file2))) {
            return file2;
        }
        return null;
    }

    public void b(Context context, int i10) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            File fileA = null;
            try {
                fileA = a();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            if (fileA != null) {
                this.f58588e = fileA.getAbsolutePath();
                Uri uriF = FileProvider.f(this.f58584a.get(), this.f58586c.f51284b, fileA);
                this.f58587d = uriF;
                intent.putExtra("output", uriF);
                intent.addFlags(2);
                WeakReference<Fragment> weakReference = this.f58585b;
                if (weakReference != null) {
                    weakReference.get().z5(intent, i10);
                } else {
                    this.f58584a.get().startActivityForResult(intent, i10);
                }
            }
        }
    }

    public String c() {
        return this.f58588e;
    }

    public Uri d() {
        return this.f58587d;
    }

    public void f(th.a aVar) {
        this.f58586c = aVar;
    }

    public b(Activity activity, Fragment fragment) {
        this.f58584a = new WeakReference<>(activity);
        this.f58585b = new WeakReference<>(fragment);
    }
}
