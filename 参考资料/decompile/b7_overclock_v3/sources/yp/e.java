package yp;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;
import org.bouncycastle.i18n.MissingEntryException;

/* JADX INFO: loaded from: classes5.dex */
public class e extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f57473i = "text";

    public e(String str, String str2) throws NullPointerException {
        super(str, str2);
    }

    public e(String str, String str2, String str3) throws UnsupportedEncodingException, NullPointerException {
        super(str, str2, str3);
    }

    public e(String str, String str2, String str3, Object[] objArr) throws UnsupportedEncodingException, NullPointerException {
        super(str, str2, str3, objArr);
    }

    public e(String str, String str2, Object[] objArr) throws NullPointerException {
        super(str, str2, objArr);
    }

    public String n(Locale locale) throws MissingEntryException {
        return e("text", locale, TimeZone.getDefault());
    }

    public String o(Locale locale, TimeZone timeZone) throws MissingEntryException {
        return e("text", locale, timeZone);
    }
}
