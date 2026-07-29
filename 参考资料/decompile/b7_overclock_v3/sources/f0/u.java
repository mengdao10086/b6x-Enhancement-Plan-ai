package f0;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f27611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f27612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f27613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f27614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<t> f27615e;

    @v0(26)
    public static class a {
        @g.u
        public static NotificationChannelGroup a(String str, CharSequence charSequence) {
            return new NotificationChannelGroup(str, charSequence);
        }

        @g.u
        public static List<NotificationChannel> b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        @g.u
        public static String c(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @g.u
        public static String d(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @g.u
        public static CharSequence e(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }
    }

    @v0(28)
    public static class b {
        @g.u
        public static String a(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        @g.u
        public static boolean b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        @g.u
        public static void c(NotificationChannelGroup notificationChannelGroup, String str) {
            notificationChannelGroup.setDescription(str);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f27616a;

        public c(@n0 String str) {
            this.f27616a = new u(str);
        }

        @n0
        public u a() {
            return this.f27616a;
        }

        @n0
        public c b(@p0 String str) {
            this.f27616a.f27613c = str;
            return this;
        }

        @n0
        public c c(@p0 CharSequence charSequence) {
            this.f27616a.f27612b = charSequence;
            return this;
        }
    }

    public u(@n0 String str) {
        this.f27615e = Collections.emptyList();
        this.f27611a = (String) androidx.core.util.o.l(str);
    }

    @n0
    public List<t> a() {
        return this.f27615e;
    }

    @v0(26)
    public final List<t> b(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel notificationChannel : list) {
            if (this.f27611a.equals(a.c(notificationChannel))) {
                arrayList.add(new t(notificationChannel));
            }
        }
        return arrayList;
    }

    @p0
    public String c() {
        return this.f27613c;
    }

    @n0
    public String d() {
        return this.f27611a;
    }

    @p0
    public CharSequence e() {
        return this.f27612b;
    }

    public NotificationChannelGroup f() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroupA = a.a(this.f27611a, this.f27612b);
        if (i10 >= 28) {
            b.c(notificationChannelGroupA, this.f27613c);
        }
        return notificationChannelGroupA;
    }

    public boolean g() {
        return this.f27614d;
    }

    @n0
    public c h() {
        return new c(this.f27611a).c(this.f27612b).b(this.f27613c);
    }

    @v0(28)
    public u(@n0 NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    @v0(26)
    public u(@n0 NotificationChannelGroup notificationChannelGroup, @n0 List<NotificationChannel> list) {
        this(a.d(notificationChannelGroup));
        this.f27612b = a.e(notificationChannelGroup);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.f27613c = b.a(notificationChannelGroup);
        }
        if (i10 >= 28) {
            this.f27614d = b.b(notificationChannelGroup);
            this.f27615e = b(a.b(notificationChannelGroup));
        } else {
            this.f27615e = b(list);
        }
    }
}
