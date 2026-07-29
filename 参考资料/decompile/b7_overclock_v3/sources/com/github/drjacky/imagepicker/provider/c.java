package com.github.drjacky.imagepicker.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import androidx.activity.result.ActivityResult;
import com.flydigi.sdk.bluetooth.l;
import com.github.drjacky.imagepicker.ImagePickerActivity;
import com.github.drjacky.imagepicker.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.yalantis.ucrop.a;
import fa.g;
import fa.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001:B#\u0012\u0006\u00104\u001a\u000203\u0012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u000405¢\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0004H\u0014J\u0006\u0010\u0016\u001a\u00020\u0004J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020 H\u0002R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00101¨\u0006;"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/c;", "Lcom/github/drjacky/imagepicker/provider/a;", "Landroid/os/Bundle;", "outState", "Lkotlin/z1;", "d", "savedInstanceState", "c", "", "p", "o", "n", "Landroid/net/Uri;", "uri", "cropOval", "cropFreeStyle", "isCamera", "q", "Landroidx/activity/result/ActivityResult;", CommonNetImpl.RESULT, k.f40564b, "b", "k", j.f55230b, "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "imageUri", "Landroid/graphics/Bitmap;", l.f16298a, "Ljava/io/File;", "destinationFile", "bitmap", "", "extension", "i", "", "I", "maxWidth", "maxHeight", "e", "Z", "f", "g", "crop", "", "h", "F", "cropAspectX", "cropAspectY", "Landroid/net/Uri;", "cropImageUri", "Lcom/github/drjacky/imagepicker/ImagePickerActivity;", androidx.appcompat.widget.c.f2369r, "Lkotlin/Function1;", "Landroid/content/Intent;", "launcher", "<init>", "(Lcom/github/drjacky/imagepicker/ImagePickerActivity;Lik/l;)V", "a", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class c extends com.github.drjacky.imagepicker.provider.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final a f16569k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f16570l = c.class.getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public static final String f16571m = "state.crop_uri";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<Intent, z1> f16572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f16577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f16578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f16579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public Uri f16580j;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/c$a;", "", "", "STATE_CROP_URI", "Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@yt.k ImagePickerActivity activity, @yt.k ik.l<? super Intent, z1> launcher) {
        super(activity);
        f0.p(activity, "activity");
        f0.p(launcher, "launcher");
        this.f16572b = launcher;
        Bundle extras = activity.getIntent().getExtras();
        extras = extras == null ? new Bundle() : extras;
        this.f16573c = extras.getInt(com.github.drjacky.imagepicker.b.f16534i, 0);
        this.f16574d = extras.getInt(com.github.drjacky.imagepicker.b.f16535j, 0);
        this.f16577g = extras.getBoolean(com.github.drjacky.imagepicker.b.f16529d, false);
        this.f16575e = extras.getBoolean(com.github.drjacky.imagepicker.b.f16532g, false);
        this.f16576f = extras.getBoolean(com.github.drjacky.imagepicker.b.f16533h, false);
        this.f16578h = extras.getFloat(com.github.drjacky.imagepicker.b.f16530e, 0.0f);
        this.f16579i = extras.getFloat(com.github.drjacky.imagepicker.b.f16531f, 0.0f);
    }

    @Override // com.github.drjacky.imagepicker.provider.a
    public void b() {
        k();
    }

    @Override // com.github.drjacky.imagepicker.provider.a
    public void c(@yt.l Bundle bundle) {
        this.f16580j = bundle == null ? null : (Uri) bundle.getParcelable(f16571m);
    }

    @Override // com.github.drjacky.imagepicker.provider.a
    public void d(@yt.k Bundle outState) {
        f0.p(outState, "outState");
        outState.putParcelable(f16571m, this.f16580j);
    }

    public final void i(File file, Bitmap bitmap, String str) throws IOException {
        file.createNewFile();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(h.f28010a.b(str), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArray);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public final void j(Uri uri, boolean z10, boolean z11, boolean z12) throws IOException {
        int i10;
        String str = z12 ? Environment.DIRECTORY_DCIM : Environment.DIRECTORY_PICTURES;
        String strC = g.f28009a.c(uri);
        this.f16580j = uri;
        Bitmap bitmapL = l(this, uri);
        f0.m(bitmapL);
        File file = new File(getExternalFilesDir(str), System.currentTimeMillis() + "_selectedImg" + strC);
        i(file, bitmapL, strC);
        File file2 = new File(getExternalFilesDir(str), System.currentTimeMillis() + "_croppedImg" + strC);
        a.C0278a c0278a = new a.C0278a();
        c0278a.f(h.f28010a.b(strC));
        c0278a.e(z10);
        c0278a.o(z11);
        com.yalantis.ucrop.a aVarQ = com.yalantis.ucrop.a.i(Uri.fromFile(file), Uri.fromFile(file2)).q(c0278a);
        float f10 = this.f16578h;
        if (f10 > 0.0f) {
            float f11 = this.f16579i;
            if (f11 > 0.0f) {
                aVarQ.o(f10, f11);
            }
        }
        int i11 = this.f16573c;
        if (i11 > 0 && (i10 = this.f16574d) > 0) {
            aVarQ.p(i11, i10);
        }
        ik.l<Intent, z1> lVar = this.f16572b;
        Intent intentD = aVarQ.d(a());
        f0.o(intentD, "uCrop.getIntent(activity)");
        lVar.i(intentD);
    }

    public final void k() {
        String path;
        Uri uri = this.f16580j;
        if (uri != null && (path = uri.getPath()) != null) {
            new File(path).delete();
        }
        this.f16580j = null;
    }

    public final Bitmap l(Context context, Uri uri) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(context.getContentResolver(), uri));
        }
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
            kotlin.io.b.a(inputStreamOpenInputStream, null);
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                kotlin.io.b.a(inputStreamOpenInputStream, th2);
                throw th3;
            }
        }
    }

    public final void m(@yt.k ActivityResult result) {
        f0.p(result, "result");
        if (result.b() != -1) {
            g();
            return;
        }
        Intent intentA = result.a();
        f0.m(intentA);
        Uri uriE = com.yalantis.ucrop.a.e(intentA);
        if (uriE != null) {
            a().m4(uriE);
        } else {
            e(R.string.error_failed_to_crop_image);
        }
    }

    public final boolean n() {
        return this.f16577g;
    }

    public final boolean o() {
        return this.f16576f;
    }

    public final boolean p() {
        return this.f16575e;
    }

    public final void q(@yt.k Uri uri, boolean z10, boolean z11, boolean z12) throws IOException {
        f0.p(uri, "uri");
        j(uri, z10, z11, z12);
    }
}
