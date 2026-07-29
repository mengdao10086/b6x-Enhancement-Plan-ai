package zh;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f58589a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f58590b = 1600;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f58591c = "content";

    public d() {
        throw new AssertionError("oops! the utility class is about to be instantiated...");
    }

    public static Point a(ContentResolver contentResolver, Uri uri) throws Throwable {
        BitmapFactory.Options options;
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused) {
        }
        try {
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            Point point = new Point(options.outWidth, options.outHeight);
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return point;
        } catch (FileNotFoundException unused2) {
            inputStream = inputStreamOpenInputStream;
            Point point2 = new Point(0, 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            return point2;
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStreamOpenInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Point b(Uri uri, Activity activity) throws Throwable {
        ContentResolver contentResolver = activity.getContentResolver();
        Point pointA = a(contentResolver, uri);
        int i10 = pointA.x;
        int i11 = pointA.y;
        if (h(contentResolver, uri)) {
            i10 = pointA.y;
            i11 = pointA.x;
        }
        if (i11 == 0) {
            return new Point(1600, 1600);
        }
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        float f10 = i10;
        float f11 = r4.widthPixels / f10;
        float f12 = i11;
        float f13 = r4.heightPixels / f12;
        return f11 > f13 ? new Point((int) (f10 * f11), (int) (f12 * f13)) : new Point((int) (f10 * f11), (int) (f12 * f13));
    }

    public static String c(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if (!"content".equals(uri.getScheme())) {
            return uri.getPath();
        }
        try {
            Cursor cursorQuery = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static int d(ContentResolver contentResolver, Uri uri) throws Throwable {
        Point pointA = a(contentResolver, uri);
        return pointA.x * pointA.y;
    }

    public static float e(long j10) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("0.0");
        String str = decimalFormat.format((j10 / 1024.0f) / 1024.0f);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getSizeInMB: ");
        sb2.append(str);
        return Float.valueOf(str.replaceAll(ag.c.f654g, j3.b.f36044h)).floatValue();
    }

    public static th.b f(Context context, Item item) {
        if (!g(context, item)) {
            return new th.b(context.getString(R.string.error_file_type));
        }
        if (th.c.b().f51301j == null) {
            return null;
        }
        Iterator<sh.a> it2 = th.c.b().f51301j.iterator();
        while (it2.hasNext()) {
            th.b bVarB = it2.next().b(context, item);
            if (bVarB != null) {
                return bVarB;
            }
        }
        return null;
    }

    public static boolean g(Context context, Item item) {
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Iterator<MimeType> it2 = th.c.b().f51292a.iterator();
        while (it2.hasNext()) {
            if (it2.next().checkType(contentResolver, item.a())) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(ContentResolver contentResolver, Uri uri) {
        try {
            int attributeInt = a.d(c(contentResolver, uri)).getAttributeInt(i1.a.C, -1);
            return attributeInt == 6 || attributeInt == 8;
        } catch (IOException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("could not read exif info of the image: ");
            sb2.append(uri);
            return false;
        }
    }
}
