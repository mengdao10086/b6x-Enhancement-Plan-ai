package zh;

import android.media.ExifInterface;
import android.text.TextUtils;
import com.google.android.material.datepicker.r;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f58582a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f58583b = -1;

    public static Date a(String str) {
        try {
            String attribute = d(str).getAttribute(i1.a.U);
            if (TextUtils.isEmpty(attribute)) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(r.f20160a));
            return simpleDateFormat.parse(attribute);
        } catch (IOException | ParseException unused) {
            return null;
        }
    }

    public static long b(String str) {
        Date dateA = a(str);
        if (dateA == null) {
            return -1L;
        }
        return dateA.getTime();
    }

    public static int c(String str) {
        try {
            int attributeInt = d(str).getAttributeInt(i1.a.C, -1);
            if (attributeInt == -1) {
                return 0;
            }
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException unused) {
            return -1;
        }
    }

    public static ExifInterface d(String str) throws IOException {
        Objects.requireNonNull(str, "filename should not be null");
        return new ExifInterface(str);
    }
}
