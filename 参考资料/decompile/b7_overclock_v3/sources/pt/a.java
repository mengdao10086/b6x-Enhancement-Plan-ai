package pt;

import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ThreadLocal<Calendar> f47055a = new C0537a();

    /* JADX INFO: renamed from: pt.a$a, reason: collision with other inner class name */
    public static final class C0537a extends ThreadLocal<Calendar> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar initialValue() {
            return Calendar.getInstance();
        }
    }

    public static long a(long j10, int i10) {
        Calendar calendar = f47055a.get();
        calendar.setTimeInMillis(j10);
        calendar.add(6, i10);
        return calendar.getTimeInMillis();
    }

    public static void b(Calendar calendar, int i10) {
        calendar.add(6, i10);
    }

    public static int c(long j10) {
        Calendar calendar = f47055a.get();
        calendar.setTimeInMillis(j10);
        return d(calendar);
    }

    public static int d(Calendar calendar) {
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static int e(long j10, long j11) {
        return (int) (((((j11 - j10) / 1000) / 60) / 60) / 24);
    }

    public static int f(int i10, int i11) {
        return Math.round(((((i(i11) - i(i10)) / 1000) / 60) / 60) / 24.0f);
    }

    public static long g(int i10, int i11, int i12) {
        return h(f47055a.get(), i10, i11, i12);
    }

    public static long h(Calendar calendar, int i10, int i11, int i12) {
        calendar.clear();
        calendar.set(i10, i11 - 1, i12);
        return calendar.getTimeInMillis();
    }

    public static long i(int i10) {
        return j(f47055a.get(), i10, 0);
    }

    public static long j(Calendar calendar, int i10, int i11) {
        calendar.clear();
        calendar.set(11, i11);
        calendar.set(5, i10 % 100);
        calendar.set(2, ((i10 / 100) % 100) - 1);
        calendar.set(1, i10 / 10000);
        return calendar.getTimeInMillis();
    }

    public static void k(Calendar calendar, int i10, int i11, int i12, int i13) {
        calendar.set(11, i10);
        calendar.set(12, i11);
        calendar.set(13, i12);
        calendar.set(14, i13);
    }
}
