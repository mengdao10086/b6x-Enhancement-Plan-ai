package uh;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.umeng.analytics.pro.ar;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import th.c;

/* JADX INFO: loaded from: classes5.dex */
public class b extends r1.b {
    public static final String C = "(media_type=? OR media_type=?) AND _size>0";
    public static final String E = "media_type=? AND _size>0";
    public static final String F = "(media_type=? OR media_type=?) AND  bucket_id=? AND _size>0";
    public static final String G = "media_type=? AND  bucket_id=? AND _size>0";
    public static final String H = "media_type=? AND mime_type=? AND _size>0";
    public static final String I = "media_type=? AND  bucket_id=? AND mime_type=? AND _size>0";
    public static final String J = "datetaken DESC";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f52130z;
    public static final Uri A = MediaStore.Files.getContentUri("external");
    public static final String[] B = {ar.f23316d, "_display_name", com.google.android.exoplayer2.offline.b.f17433i, "_size", "duration"};
    public static final String[] D = {String.valueOf(1), String.valueOf(3)};

    public b(Context context, String str, String[] strArr, boolean z10) {
        super(context, A, B, str, strArr, "datetaken DESC");
        this.f52130z = z10;
    }

    public static String[] a0(String str) {
        return new String[]{String.valueOf(1), String.valueOf(3), str};
    }

    public static String[] b0(int i10, String str) {
        return new String[]{String.valueOf(i10), str, "image/gif"};
    }

    public static String[] c0(int i10, String str) {
        return new String[]{String.valueOf(i10), str};
    }

    public static String[] d0(int i10) {
        return new String[]{String.valueOf(i10), "image/gif"};
    }

    public static String[] e0(int i10) {
        return new String[]{String.valueOf(i10)};
    }

    public static r1.b f0(Context context, Album album, boolean z10) {
        String str;
        String[] strArrA0;
        String str2;
        if (album.s()) {
            str = "media_type=? AND _size>0";
            if (c.b().d()) {
                strArrA0 = d0(1);
                str = H;
            } else if (c.b().e()) {
                strArrA0 = e0(1);
            } else if (c.b().f()) {
                strArrA0 = e0(3);
            } else {
                strArrA0 = D;
                str = "(media_type=? OR media_type=?) AND _size>0";
            }
        } else {
            boolean zD = c.b().d();
            str = G;
            if (zD) {
                strArrA0 = b0(1, album.j());
                str2 = I;
            } else {
                if (c.b().e()) {
                    strArrA0 = c0(1, album.j());
                } else if (c.b().f()) {
                    strArrA0 = c0(3, album.j());
                } else {
                    strArrA0 = a0(album.j());
                    str2 = F;
                }
                z10 = false;
            }
            str = str2;
            z10 = false;
        }
        return new b(context, str, strArrA0, z10);
    }

    @Override // r1.b, r1.a
    /* JADX INFO: renamed from: T */
    public Cursor I() {
        Cursor cursorI = super.I();
        if (!this.f52130z || !zh.b.e(i())) {
            return cursorI;
        }
        MatrixCursor matrixCursor = new MatrixCursor(B);
        matrixCursor.addRow(new Object[]{-1L, Item.f25096g, "", 0, 0});
        return new MergeCursor(new Cursor[]{matrixCursor, cursorI});
    }

    @Override // r1.c
    public void p() {
    }
}
