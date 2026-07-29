package uh;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.umeng.analytics.pro.ar;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.Album;
import java.util.HashMap;
import java.util.HashSet;
import th.c;

/* JADX INFO: loaded from: classes5.dex */
public class a extends r1.b {
    public static final String B = "uri";
    public static final String H = "(media_type=? OR media_type=?) AND _size>0) GROUP BY (bucket_id";
    public static final String I = "(media_type=? OR media_type=?) AND _size>0";
    public static final String K = "media_type=? AND _size>0) GROUP BY (bucket_id";
    public static final String L = "media_type=? AND _size>0";
    public static final String M = "media_type=? AND _size>0 AND mime_type=?) GROUP BY (bucket_id";
    public static final String N = "media_type=? AND _size>0 AND mime_type=?";
    public static final String O = "datetaken DESC";
    public static final Uri D = MediaStore.Files.getContentUri("external");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f52129z = "bucket_id";
    public static final String A = "bucket_display_name";
    public static final String C = "count";
    public static final String[] E = {ar.f23316d, f52129z, A, com.google.android.exoplayer2.offline.b.f17433i, "uri", C};
    public static final String[] F = {ar.f23316d, f52129z, A, com.google.android.exoplayer2.offline.b.f17433i, "COUNT(*) AS count"};
    public static final String[] G = {ar.f23316d, f52129z, A, com.google.android.exoplayer2.offline.b.f17433i};
    public static final String[] J = {String.valueOf(1), String.valueOf(3)};

    public a(Context context, String str, String[] strArr) {
        super(context, D, a0() ? F : G, str, strArr, "datetaken DESC");
    }

    public static boolean a0() {
        return Build.VERSION.SDK_INT < 29;
    }

    public static String[] b0(int i10) {
        return new String[]{String.valueOf(i10), "image/gif"};
    }

    public static String[] c0(int i10) {
        return new String[]{String.valueOf(i10)};
    }

    public static Uri d0(Cursor cursor) {
        long j10 = cursor.getLong(cursor.getColumnIndex(ar.f23316d));
        String string = cursor.getString(cursor.getColumnIndex(com.google.android.exoplayer2.offline.b.f17433i));
        return ContentUris.withAppendedId(MimeType.isImage(string) ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MimeType.isVideo(string) ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Files.getContentUri("external"), j10);
    }

    public static r1.b e0(Context context) {
        String str;
        String[] strArrC0;
        if (c.b().d()) {
            str = a0() ? M : N;
            strArrC0 = b0(1);
        } else if (c.b().e()) {
            str = a0() ? K : "media_type=? AND _size>0";
            strArrC0 = c0(1);
        } else if (c.b().f()) {
            str = a0() ? K : "media_type=? AND _size>0";
            strArrC0 = c0(3);
        } else {
            str = a0() ? H : "(media_type=? OR media_type=?) AND _size>0";
            strArrC0 = J;
        }
        return new a(context, str, strArrC0);
    }

    @Override // r1.b, r1.a
    /* JADX INFO: renamed from: T */
    public Cursor I() {
        Uri uri;
        int i10;
        Uri uriD0;
        int i11;
        String string;
        char c10;
        Cursor cursorI = super.I();
        String[] strArr = E;
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        if (a0()) {
            MatrixCursor matrixCursor2 = new MatrixCursor(strArr);
            if (cursorI != null) {
                i11 = 0;
                while (cursorI.moveToNext()) {
                    long j10 = cursorI.getLong(cursorI.getColumnIndex(ar.f23316d));
                    long j11 = cursorI.getLong(cursorI.getColumnIndex(f52129z));
                    String string2 = cursorI.getString(cursorI.getColumnIndex(A));
                    String string3 = cursorI.getString(cursorI.getColumnIndex(com.google.android.exoplayer2.offline.b.f17433i));
                    Uri uriD02 = d0(cursorI);
                    int i12 = cursorI.getInt(cursorI.getColumnIndex(C));
                    matrixCursor2.addRow(new String[]{Long.toString(j10), Long.toString(j11), string2, string3, uriD02.toString(), String.valueOf(i12)});
                    i11 += i12;
                }
                uriD0 = cursorI.moveToFirst() ? d0(cursorI) : null;
            } else {
                uriD0 = null;
                i11 = 0;
            }
            String[] strArr2 = new String[6];
            String str = Album.f25089e;
            strArr2[0] = str;
            strArr2[1] = str;
            strArr2[2] = Album.f25090f;
            strArr2[3] = null;
            if (uriD0 == null) {
                c10 = 4;
                string = null;
            } else {
                string = uriD0.toString();
                c10 = 4;
            }
            strArr2[c10] = string;
            strArr2[5] = String.valueOf(i11);
            matrixCursor.addRow(strArr2);
            return new MergeCursor(new Cursor[]{matrixCursor, matrixCursor2});
        }
        HashMap map = new HashMap();
        if (cursorI != null) {
            while (cursorI.moveToNext()) {
                long j12 = cursorI.getLong(cursorI.getColumnIndex(f52129z));
                Long l10 = (Long) map.get(Long.valueOf(j12));
                map.put(Long.valueOf(j12), l10 == null ? 1L : Long.valueOf(l10.longValue() + 1));
            }
        }
        MatrixCursor matrixCursor3 = new MatrixCursor(E);
        if (cursorI == null || !cursorI.moveToFirst()) {
            uri = null;
            i10 = 0;
        } else {
            Uri uriD03 = d0(cursorI);
            HashSet hashSet = new HashSet();
            i10 = 0;
            do {
                long j13 = cursorI.getLong(cursorI.getColumnIndex(f52129z));
                if (!hashSet.contains(Long.valueOf(j13))) {
                    long j14 = cursorI.getLong(cursorI.getColumnIndex(ar.f23316d));
                    String string4 = cursorI.getString(cursorI.getColumnIndex(A));
                    String string5 = cursorI.getString(cursorI.getColumnIndex(com.google.android.exoplayer2.offline.b.f17433i));
                    Uri uriD04 = d0(cursorI);
                    long jLongValue = ((Long) map.get(Long.valueOf(j13))).longValue();
                    matrixCursor3.addRow(new String[]{Long.toString(j14), Long.toString(j13), string4, string5, uriD04.toString(), String.valueOf(jLongValue)});
                    hashSet.add(Long.valueOf(j13));
                    i10 = (int) (((long) i10) + jLongValue);
                }
            } while (cursorI.moveToNext());
            uri = uriD03;
        }
        String[] strArr3 = new String[6];
        String str2 = Album.f25089e;
        strArr3[0] = str2;
        strArr3[1] = str2;
        strArr3[2] = Album.f25090f;
        strArr3[3] = null;
        strArr3[4] = uri == null ? null : uri.toString();
        strArr3[5] = String.valueOf(i10);
        matrixCursor.addRow(strArr3);
        return new MergeCursor(new Cursor[]{matrixCursor, matrixCursor3});
    }

    @Override // r1.c
    public void p() {
    }
}
