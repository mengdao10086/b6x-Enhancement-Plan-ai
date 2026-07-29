package gm;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f29688a = c(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f29689b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Locale f29690c = b();

    public static Date a(Date date) throws ParseException {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = f29689b;
        synchronized (map) {
            Long lC = (Long) map.get(locale);
            if (lC == null) {
                long time = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();
                lC = time == 0 ? f29688a : c(time);
                map.put(locale, lC);
            }
            if (lC != f29688a) {
                return new Date(date.getTime() - lC.longValue());
            }
            return date;
        }
    }

    public static Locale b() {
        if (SocializeProtocolConstants.PROTOCOL_KEY_EN.equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i10 = 0; i10 != availableLocales.length; i10++) {
            if (SocializeProtocolConstants.PROTOCOL_KEY_EN.equalsIgnoreCase(availableLocales[i10].getLanguage())) {
                return availableLocales[i10];
            }
        }
        return Locale.getDefault();
    }

    public static Long c(long j10) {
        return Long.valueOf(j10);
    }
}
