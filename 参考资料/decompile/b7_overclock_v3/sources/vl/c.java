package vl;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"", "Ljava/util/Date;", "a", "b", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f53195a = 253402300799999L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f53196b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final String[] f53197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final DateFormat[] f53198d;

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"vl/c$a", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(rl.f.f48801f);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f53197c = strArr;
        f53198d = new DateFormat[strArr.length];
    }

    @l
    public static final Date a(@yt.k String str) {
        f0.p(str, "<this>");
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = f53196b.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = f53197c;
        synchronized (strArr) {
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                DateFormat[] dateFormatArr = f53198d;
                DateFormat dateFormat = dateFormatArr[i10];
                DateFormat dateFormat2 = dateFormat;
                if (dateFormat == null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f53197c[i10], Locale.US);
                    simpleDateFormat.setTimeZone(rl.f.f48801f);
                    dateFormatArr[i10] = simpleDateFormat;
                    dateFormat2 = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = dateFormat2.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
                i10 = i11;
            }
            z1 z1Var = z1.f38230a;
            return null;
        }
    }

    @yt.k
    public static final String b(@yt.k Date date) {
        f0.p(date, "<this>");
        String str = f53196b.get().format(date);
        f0.o(str, "STANDARD_DATE_FORMAT.get().format(this)");
        return str;
    }
}
