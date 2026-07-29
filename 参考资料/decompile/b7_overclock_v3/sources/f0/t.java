package f0;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f27589s = "miscellaneous";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f27590t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f27591u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final String f27592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f27593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f27594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f27595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f27596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f27597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Uri f27598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioAttributes f27599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f27600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f27601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f27602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long[] f27603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f27604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f27605n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f27606o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f27607p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f27608q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f27609r;

    @v0(26)
    public static class a {
        @g.u
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        @g.u
        public static boolean b(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        @g.u
        public static NotificationChannel c(String str, CharSequence charSequence, int i10) {
            return new NotificationChannel(str, charSequence, i10);
        }

        @g.u
        public static void d(NotificationChannel notificationChannel, boolean z10) {
            notificationChannel.enableLights(z10);
        }

        @g.u
        public static void e(NotificationChannel notificationChannel, boolean z10) {
            notificationChannel.enableVibration(z10);
        }

        @g.u
        public static AudioAttributes f(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        @g.u
        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        @g.u
        public static String h(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @g.u
        public static String i(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @g.u
        public static int j(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        @g.u
        public static int k(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        @g.u
        public static int l(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        @g.u
        public static CharSequence m(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        @g.u
        public static Uri n(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        @g.u
        public static long[] o(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        @g.u
        public static void p(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        @g.u
        public static void q(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        @g.u
        public static void r(NotificationChannel notificationChannel, int i10) {
            notificationChannel.setLightColor(i10);
        }

        @g.u
        public static void s(NotificationChannel notificationChannel, boolean z10) {
            notificationChannel.setShowBadge(z10);
        }

        @g.u
        public static void t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        @g.u
        public static void u(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        @g.u
        public static boolean v(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        @g.u
        public static boolean w(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    @v0(29)
    public static class b {
        @g.u
        public static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    @v0(30)
    public static class c {
        @g.u
        public static String a(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        @g.u
        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        @g.u
        public static boolean c(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        @g.u
        public static void d(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f27610a;

        public d(@n0 String str, int i10) {
            this.f27610a = new t(str, i10);
        }

        @n0
        public t a() {
            return this.f27610a;
        }

        @n0
        public d b(@n0 String str, @n0 String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                t tVar = this.f27610a;
                tVar.f27604m = str;
                tVar.f27605n = str2;
            }
            return this;
        }

        @n0
        public d c(@p0 String str) {
            this.f27610a.f27595d = str;
            return this;
        }

        @n0
        public d d(@p0 String str) {
            this.f27610a.f27596e = str;
            return this;
        }

        @n0
        public d e(int i10) {
            this.f27610a.f27594c = i10;
            return this;
        }

        @n0
        public d f(int i10) {
            this.f27610a.f27601j = i10;
            return this;
        }

        @n0
        public d g(boolean z10) {
            this.f27610a.f27600i = z10;
            return this;
        }

        @n0
        public d h(@p0 CharSequence charSequence) {
            this.f27610a.f27593b = charSequence;
            return this;
        }

        @n0
        public d i(boolean z10) {
            this.f27610a.f27597f = z10;
            return this;
        }

        @n0
        public d j(@p0 Uri uri, @p0 AudioAttributes audioAttributes) {
            t tVar = this.f27610a;
            tVar.f27598g = uri;
            tVar.f27599h = audioAttributes;
            return this;
        }

        @n0
        public d k(boolean z10) {
            this.f27610a.f27602k = z10;
            return this;
        }

        @n0
        public d l(@p0 long[] jArr) {
            t tVar = this.f27610a;
            tVar.f27602k = jArr != null && jArr.length > 0;
            tVar.f27603l = jArr;
            return this;
        }
    }

    public t(@n0 String str, int i10) {
        this.f27597f = true;
        this.f27598g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.f27601j = 0;
        this.f27592a = (String) androidx.core.util.o.l(str);
        this.f27594c = i10;
        this.f27599h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean a() {
        return this.f27608q;
    }

    public boolean b() {
        return this.f27606o;
    }

    public boolean c() {
        return this.f27597f;
    }

    @p0
    public AudioAttributes d() {
        return this.f27599h;
    }

    @p0
    public String e() {
        return this.f27605n;
    }

    @p0
    public String f() {
        return this.f27595d;
    }

    @p0
    public String g() {
        return this.f27596e;
    }

    @n0
    public String h() {
        return this.f27592a;
    }

    public int i() {
        return this.f27594c;
    }

    public int j() {
        return this.f27601j;
    }

    public int k() {
        return this.f27607p;
    }

    @p0
    public CharSequence l() {
        return this.f27593b;
    }

    public NotificationChannel m() {
        String str;
        String str2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        NotificationChannel notificationChannelC = a.c(this.f27592a, this.f27593b, this.f27594c);
        a.p(notificationChannelC, this.f27595d);
        a.q(notificationChannelC, this.f27596e);
        a.s(notificationChannelC, this.f27597f);
        a.t(notificationChannelC, this.f27598g, this.f27599h);
        a.d(notificationChannelC, this.f27600i);
        a.r(notificationChannelC, this.f27601j);
        a.u(notificationChannelC, this.f27603l);
        a.e(notificationChannelC, this.f27602k);
        if (i10 >= 30 && (str = this.f27604m) != null && (str2 = this.f27605n) != null) {
            c.d(notificationChannelC, str, str2);
        }
        return notificationChannelC;
    }

    @p0
    public String n() {
        return this.f27604m;
    }

    @p0
    public Uri o() {
        return this.f27598g;
    }

    @p0
    public long[] p() {
        return this.f27603l;
    }

    public boolean q() {
        return this.f27609r;
    }

    public boolean r() {
        return this.f27600i;
    }

    public boolean s() {
        return this.f27602k;
    }

    @n0
    public d t() {
        return new d(this.f27592a, this.f27594c).h(this.f27593b).c(this.f27595d).d(this.f27596e).i(this.f27597f).j(this.f27598g, this.f27599h).g(this.f27600i).f(this.f27601j).k(this.f27602k).l(this.f27603l).b(this.f27604m, this.f27605n);
    }

    @v0(26)
    public t(@n0 NotificationChannel notificationChannel) {
        this(a.i(notificationChannel), a.j(notificationChannel));
        this.f27593b = a.m(notificationChannel);
        this.f27595d = a.g(notificationChannel);
        this.f27596e = a.h(notificationChannel);
        this.f27597f = a.b(notificationChannel);
        this.f27598g = a.n(notificationChannel);
        this.f27599h = a.f(notificationChannel);
        this.f27600i = a.v(notificationChannel);
        this.f27601j = a.k(notificationChannel);
        this.f27602k = a.w(notificationChannel);
        this.f27603l = a.o(notificationChannel);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f27604m = c.b(notificationChannel);
            this.f27605n = c.a(notificationChannel);
        }
        this.f27606o = a.a(notificationChannel);
        this.f27607p = a.l(notificationChannel);
        if (i10 >= 29) {
            this.f27608q = b.a(notificationChannel);
        }
        if (i10 >= 30) {
            this.f27609r = c.c(notificationChannel);
        }
    }
}
