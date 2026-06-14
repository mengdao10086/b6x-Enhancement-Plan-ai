package a;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class i60 {
    public static final Bitmap a(Context context, Uri uri) {
        f92.d(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        f92.c(contentResolver, "context.contentResolver");
        try {
            f92.b(uri);
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
            inputStreamOpenInputStream.close();
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
