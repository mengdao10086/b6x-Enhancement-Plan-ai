package a;

import a.p80;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.ExportViewToImage$exportImage$1", f = "ExportViewToImage.kt", l = {}, m = "invokeSuspend")
public final class oh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ph0 f2244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f2247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2248a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh0(ph0 ph0Var, View view, String str, Runnable runnable, p80.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f2244a = ph0Var;
        this.f2246a = view;
        this.f2248a = str;
        this.f2247a = runnable;
        this.f7021a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        oh0 oh0Var = new oh0(this.f2244a, this.f2246a, this.f2248a, this.f2247a, this.f7021a, b62Var);
        oh0Var.f2245a = (wd2) obj;
        return oh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((oh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f2246a.getWidth(), this.f2246a.getHeight(), Bitmap.Config.ARGB_8888);
        this.f2246a.draw(new Canvas(bitmapCreateBitmap));
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", this.f2248a);
        contentValues.put("mime_type", "image/jpg");
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = this.f2244a.f2429a.getContentResolver();
        Uri uriInsert = contentResolver.insert(uri, contentValues);
        f92.b(uriInsert);
        f92.c(uriInsert, "resolver.insert(uri, values)!!");
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 65, contentResolver.openOutputStream(uriInsert));
        try {
            e42 e42Var = g42.f6169a;
            MediaScannerConnection.scanFile(this.f2244a.f2429a, new String[]{new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), this.f2248a).getAbsolutePath()}, new String[]{"image/jpg"}, null);
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
        d41.f480a.i(false);
        this.f2246a.post(new nh0(this));
        return m42.f6769a;
    }
}
