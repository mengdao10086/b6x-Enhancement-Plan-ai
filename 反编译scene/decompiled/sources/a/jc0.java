package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.omarea.krscript.model.ClickableNode;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jc0 {
    public final Drawable a(Bitmap bitmap) {
        f92.d(bitmap, "bitmap");
        return new BitmapDrawable(bitmap);
    }

    public final Drawable b(Context context, ClickableNode clickableNode) {
        f92.d(context, "context");
        f92.d(clickableNode, "clickableNode");
        if (clickableNode.getIconPath().length() == 0) {
            return null;
        }
        String pageConfigDir = clickableNode.getPageConfigDir();
        f92.c(pageConfigDir, "clickableNode.pageConfigDir");
        InputStream inputStreamE = new qc0(context, pageConfigDir).e(clickableNode.getIconPath());
        if (inputStreamE == null) {
            return null;
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamE);
        f92.c(bitmapDecodeStream, "BitmapFactory.decodeStream(this)");
        return a(bitmapDecodeStream);
    }

    public final Drawable c(Context context, ClickableNode clickableNode) {
        f92.d(context, "context");
        f92.d(clickableNode, "clickableNode");
        Drawable drawableD = d(context, clickableNode, true);
        f92.b(drawableD);
        return drawableD;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable d(android.content.Context r7, com.omarea.krscript.model.ClickableNode r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            a.f92.d(r7, r0)
            java.lang.String r0 = "clickableNode"
            a.f92.d(r8, r0)
            java.lang.String r0 = r8.getLogoPath()
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L18
            r0 = r1
            goto L19
        L18:
            r0 = r2
        L19:
            java.lang.String r3 = "BitmapFactory.decodeStream(this)"
            java.lang.String r4 = "clickableNode.pageConfigDir"
            if (r0 != 0) goto L41
            a.qc0 r0 = new a.qc0
            java.lang.String r5 = r8.getPageConfigDir()
            a.f92.c(r5, r4)
            r0.<init>(r7, r5)
            java.lang.String r5 = r8.getLogoPath()
            java.io.InputStream r0 = r0.e(r5)
            if (r0 == 0) goto L41
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r0)
        L39:
            a.f92.c(r7, r3)
            android.graphics.drawable.Drawable r7 = r6.a(r7)
            return r7
        L41:
            java.lang.String r0 = r8.getIconPath()
            int r0 = r0.length()
            if (r0 != 0) goto L4c
            goto L4d
        L4c:
            r1 = r2
        L4d:
            if (r1 != 0) goto L6a
            a.qc0 r0 = new a.qc0
            java.lang.String r1 = r8.getPageConfigDir()
            a.f92.c(r1, r4)
            r0.<init>(r7, r1)
            java.lang.String r8 = r8.getIconPath()
            java.io.InputStream r8 = r0.e(r8)
            if (r8 == 0) goto L6a
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r8)
            goto L39
        L6a:
            if (r9 == 0) goto L76
            int r8 = a.lb0.kr_shortcut_logo
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r8)
            a.f92.b(r7)
            goto L77
        L76:
            r7 = 0
        L77:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.jc0.d(android.content.Context, com.omarea.krscript.model.ClickableNode, boolean):android.graphics.drawable.Drawable");
    }
}
