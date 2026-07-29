package yp;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;
import org.bouncycastle.i18n.MissingEntryException;

/* JADX INFO: loaded from: classes5.dex */
public class d extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f57472j = "title";

    public d(String str, String str2) throws NullPointerException {
        super(str, str2);
    }

    public d(String str, String str2, String str3) throws UnsupportedEncodingException, NullPointerException {
        super(str, str2, str3);
    }

    public d(String str, String str2, String str3, Object[] objArr) throws UnsupportedEncodingException, NullPointerException {
        super(str, str2, str3, objArr);
    }

    public d(String str, String str2, Object[] objArr) throws NullPointerException {
        super(str, str2, objArr);
    }

    public String p(Locale locale) throws MissingEntryException {
        return e("title", locale, TimeZone.getDefault());
    }

    public String q(Locale locale, TimeZone timeZone) throws MissingEntryException {
        return e("title", locale, timeZone);
    }
}
