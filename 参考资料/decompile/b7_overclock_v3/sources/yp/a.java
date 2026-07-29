package yp;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;
import org.bouncycastle.i18n.MissingEntryException;

/* JADX INFO: loaded from: classes5.dex */
public class a extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f57452k = "summary";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f57453l = "details";

    public a(String str, String str2) throws NullPointerException {
        super(str, str2);
    }

    public a(String str, String str2, String str3) throws UnsupportedEncodingException, NullPointerException {
        super(str, str2, str3);
    }

    public a(String str, String str2, String str3, Object[] objArr) throws UnsupportedEncodingException, NullPointerException {
        super(str, str2, str3, objArr);
    }

    public a(String str, String str2, Object[] objArr) throws NullPointerException {
        super(str, str2, objArr);
    }

    public String r(Locale locale) throws MissingEntryException {
        return e(f57453l, locale, TimeZone.getDefault());
    }

    public String s(Locale locale, TimeZone timeZone) throws MissingEntryException {
        return e(f57453l, locale, timeZone);
    }

    public String t(Locale locale) throws MissingEntryException {
        return e("summary", locale, TimeZone.getDefault());
    }

    public String u(Locale locale, TimeZone timeZone) throws MissingEntryException {
        return e("summary", locale, timeZone);
    }
}
