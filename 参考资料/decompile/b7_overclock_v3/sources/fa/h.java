package fa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import androidx.core.content.FileProvider;
import com.flydigi.sdk.bluetooth.l;
import com.github.drjacky.imagepicker.R;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Pair;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J(\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tJ\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u001f"}, d2 = {"Lfa/h;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Ljava/io/File;", "dir", "", "extension", "e", "Landroid/net/Uri;", xf.j.f55230b, m7.a.f40702b, "", "d", "uri", "Lkotlin/Pair;", "", "g", "h", "i", l.f16298a, "Lf1/a;", "c", "Landroid/graphics/Bitmap$CompressFormat;", "b", "a", m0.k.f40564b, "", "n", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final h f28010a = new h();

    public static /* synthetic */ File f(h hVar, Context context, File file, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            file = null;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        return hVar.e(context, file, str);
    }

    public static /* synthetic */ Uri k(h hVar, Context context, File file, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            file = null;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        return hVar.j(context, file, str);
    }

    public final File a(Context context) {
        return new File(context.getExternalFilesDir(Environment.DIRECTORY_DCIM), xf.e.f55219d);
    }

    @yt.k
    public final Bitmap.CompressFormat b(@yt.k String extension) {
        f0.p(extension, "extension");
        return StringsKt__StringsKt.T2(extension, "png", true) ? Bitmap.CompressFormat.PNG : StringsKt__StringsKt.T2(extension, "webp", true) ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
    }

    @yt.l
    public final f1.a c(@yt.k Context context, @yt.k Uri uri) {
        f0.p(context, "context");
        f0.p(uri, "uri");
        if (!n(uri)) {
            return f1.a.i(context, uri);
        }
        String strH = g.f28009a.h(context, uri);
        if (strH != null) {
            return f1.a.h(new File(strH));
        }
        return null;
    }

    public final long d(@yt.k File file) {
        f0.p(file, "file");
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    @yt.l
    public final File e(@yt.k Context context, @yt.l File file, @yt.l String str) {
        f0.p(context, "context");
        if (str == null) {
            str = hd.k.S;
        }
        try {
            String str2 = "IMG_" + m() + str;
            if (file == null) {
                file = a(context);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            file2.createNewFile();
            return file2;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @yt.k
    public final Pair<Integer, Integer> g(@yt.k Context context, @yt.k Uri uri) {
        f0.p(context, "context");
        f0.p(uri, "uri");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options);
        return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
    }

    @yt.k
    public final Pair<Integer, Integer> h(@yt.k File file) {
        f0.p(file, "file");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
    }

    public final long i(@yt.k Context context, @yt.k Uri uri) {
        f0.p(context, "context");
        f0.p(uri, "uri");
        f1.a aVarC = c(context, uri);
        if (aVarC == null) {
            return 0L;
        }
        return aVarC.t();
    }

    @yt.l
    public final Uri j(@yt.k Context context, @yt.l File file, @yt.l String str) {
        f0.p(context, "context");
        if (str == null) {
            str = hd.k.S;
        }
        try {
            String str2 = "IMG_" + m() + str;
            if (file == null) {
                file = a(context);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            file2.createNewFile();
            return FileProvider.f(context, f0.C(context.getPackageName(), context.getString(R.string.image_picker_provider_authority_suffix)), file2);
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @yt.l
    public final File l(@yt.k Context context, @yt.k Uri uri) {
        f0.p(context, "context");
        f0.p(uri, "uri");
        try {
            File file = new File(context.getCacheDir(), "image_picker.png");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, SsManifestParser.e.J);
            FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor == null ? null : parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
            if (fileDescriptor == null) {
                return null;
            }
            FileChannel channel = new FileInputStream(fileDescriptor).getChannel();
            FileChannel channel2 = new FileOutputStream(file).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
            return file;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final String m() {
        String str = new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault()).format(new Date());
        f0.o(str, "SimpleDateFormat(timeFormat, Locale.getDefault()).format(Date())");
        return str;
    }

    public final boolean n(Uri uri) {
        return u.L1(m7.a.f40702b, uri.getScheme(), true);
    }
}
