package fa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.github.drjacky.imagepicker.R;
import hk.m;
import java.io.File;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001d\u0010\u0012\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J!\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lfa/j;", "", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", "", "mimeTypes", "Landroid/content/Intent;", "d", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "Landroid/net/Uri;", "uri", "", "tryFrontCamera", "b", "h", "g", "f", "c", "([Ljava/lang/String;)Landroid/content/Intent;", "e", "a", "(Landroid/content/Intent;[Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final j f28013a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f28014b = "android.intent.extras.CAMERA_FACING";

    @m
    @yt.k
    public static final Intent b(@yt.k Uri uri, boolean z10) {
        f0.p(uri, "uri");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (z10) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                intent.putExtra(f28014b, 0);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            } else if (i10 >= 22 && i10 < 26) {
                intent.putExtra(f28014b, 0);
            } else if (i10 < 22) {
                intent.putExtra(f28014b, 1);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            intent.putExtra("output", uri);
        } else {
            intent.putExtra("output", uri);
        }
        return intent;
    }

    @m
    @yt.k
    public static final Intent d(@yt.k Context context, @yt.k String[] mimeTypes) {
        f0.p(context, "context");
        f0.p(mimeTypes, "mimeTypes");
        j jVar = f28013a;
        Intent intentC = jVar.c(mimeTypes);
        return intentC.resolveActivity(context.getPackageManager()) != null ? intentC : jVar.e(mimeTypes);
    }

    @m
    @yt.k
    public static final Intent f(@yt.k Context context, @yt.k Uri uri) {
        f0.p(context, "context");
        f0.p(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        String strC = f0.C(context.getPackageName(), context.getString(R.string.image_picker_provider_authority_suffix));
        f1.a aVarI = f1.a.i(context, uri);
        if (!f0.g(aVarI == null ? null : Boolean.valueOf(aVarI.a()), Boolean.TRUE)) {
            String strH = g.f28009a.h(context, uri);
            f0.m(strH);
            uri = FileProvider.f(context, strC, new File(strH));
        }
        intent.setDataAndType(uri, "image/*");
        intent.addFlags(1);
        return intent;
    }

    @m
    public static final boolean g(@yt.k Context context) {
        f0.p(context, "context");
        return new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(context.getPackageManager()) != null;
    }

    @m
    public static final boolean h(@yt.k Context context) {
        f0.p(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public final Intent a(Intent intent, String[] strArr) {
        intent.setType("image/*");
        if (!(strArr.length == 0)) {
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        }
        return intent;
    }

    public final Intent c(String[] strArr) {
        Intent intentA = a(new Intent("android.intent.action.OPEN_DOCUMENT"), strArr);
        intentA.addCategory("android.intent.category.OPENABLE");
        intentA.addFlags(64);
        intentA.addFlags(1);
        intentA.addFlags(2);
        return intentA;
    }

    public final Intent e(String[] strArr) {
        return a(new Intent("android.intent.action.PICK"), strArr);
    }
}
