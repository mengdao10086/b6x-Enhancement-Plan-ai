package f0;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import com.bumptech.glide.load.engine.GlideException;
import f0.f0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public static final int A = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int A0 = 3;

    @SuppressLint({"ActionValue"})
    public static final String B = "android.title";
    public static final int B0 = 1;

    @SuppressLint({"ActionValue"})
    public static final String C = "android.title.big";
    public static final int C0 = 0;

    @SuppressLint({"ActionValue"})
    public static final String D = "android.text";
    public static final int D0 = -1;

    @SuppressLint({"ActionValue"})
    public static final String E = "android.subText";
    public static final String E0 = "call";

    @SuppressLint({"ActionValue"})
    public static final String F = "android.remoteInputHistory";
    public static final String F0 = "navigation";

    @SuppressLint({"ActionValue"})
    public static final String G = "android.infoText";
    public static final String G0 = "msg";

    @SuppressLint({"ActionValue"})
    public static final String H = "android.summaryText";
    public static final String H0 = "email";

    @SuppressLint({"ActionValue"})
    public static final String I = "android.bigText";
    public static final String I0 = "event";

    @SuppressLint({"ActionValue"})
    public static final String J = "android.icon";
    public static final String J0 = "promo";

    @SuppressLint({"ActionValue"})
    public static final String K = "android.largeIcon";
    public static final String K0 = "alarm";

    @SuppressLint({"ActionValue"})
    public static final String L = "android.largeIcon.big";
    public static final String L0 = "progress";

    @SuppressLint({"ActionValue"})
    public static final String M = "android.progress";
    public static final String M0 = "social";

    @SuppressLint({"ActionValue"})
    public static final String N = "android.progressMax";
    public static final String N0 = "err";

    @SuppressLint({"ActionValue"})
    public static final String O = "android.progressIndeterminate";
    public static final String O0 = "transport";

    @SuppressLint({"ActionValue"})
    public static final String P = "android.showChronometer";
    public static final String P0 = "sys";

    @SuppressLint({"ActionValue"})
    public static final String Q = "android.chronometerCountDown";
    public static final String Q0 = "service";

    @SuppressLint({"ActionValue"})
    public static final String R = "android.colorized";
    public static final String R0 = "reminder";

    @SuppressLint({"ActionValue"})
    public static final String S = "android.showWhen";
    public static final String S0 = "recommendation";

    @SuppressLint({"ActionValue"})
    public static final String T = "android.picture";
    public static final String T0 = "status";

    @SuppressLint({"ActionValue"})
    public static final String U = "android.pictureIcon";
    public static final String U0 = "workout";

    @SuppressLint({"ActionValue"})
    public static final String V = "android.pictureContentDescription";
    public static final String V0 = "location_sharing";

    @SuppressLint({"ActionValue"})
    public static final String W = "android.showBigPictureWhenCollapsed";
    public static final String W0 = "stopwatch";

    @SuppressLint({"ActionValue"})
    public static final String X = "android.textLines";
    public static final String X0 = "missed_call";

    @SuppressLint({"ActionValue"})
    public static final String Y = "android.template";
    public static final int Y0 = 0;
    public static final String Z = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final int Z0 = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27617a = "NotifCompat";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String f27618a0 = "android.people";

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f27619a1 = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27620b = "android.intent.category.NOTIFICATION_PREFERENCES";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27621b0 = "android.people.list";

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f27622b1 = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27623c = "android.intent.extra.CHANNEL_ID";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27624c0 = "android.backgroundImageUri";

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f27625c1 = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27626d = "android.intent.extra.CHANNEL_GROUP_ID";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27627d0 = "android.mediaSession";

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f27628d1 = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27629e = "android.intent.extra.NOTIFICATION_TAG";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27630e0 = "android.compactActions";

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final String f27631e1 = "silent";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27632f = "android.intent.extra.NOTIFICATION_ID";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27633f0 = "android.selfDisplayName";

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final int f27634f1 = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f27635g = -1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27636g0 = "android.messagingStyleUser";

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final int f27637g1 = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f27638h = 1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27639h0 = "android.conversationTitle";

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final int f27640h1 = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f27641i = 2;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27642i0 = "android.messages";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f27643j = 4;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27644j0 = "android.messages.historic";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f27645k = -1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27646k0 = "android.isGroupConversation";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f27647l = 1;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27648l0 = "android.callType";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f27649m = 2;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27650m0 = "android.callIsVideo";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f27651n = 4;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27652n0 = "android.callPerson";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f27653o = 8;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27654o0 = "android.callPersonCompat";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f27655p = 16;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27656p0 = "android.verificationIcon";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f27657q = 32;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27658q0 = "android.verificationIconCompat";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f27659r = 64;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27660r0 = "android.verificationText";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    public static final int f27661s = 128;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27662s0 = "android.answerIntent";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f27663t = 256;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27664t0 = "android.declineIntent";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f27665u = 512;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27666u0 = "android.hangUpIntent";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f27667v = 4096;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27668v0 = "android.answerColor";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f27669w = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27670w0 = "android.declineColor";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f27671x = -1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27672x0 = "android.hiddenConversationTitle";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f27673y = -2;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f27674y0 = "android.audioContents";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f27675z = 1;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @g.l
    public static final int f27676z0 = 0;

    public static class b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f27677m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f27678n = 1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f27679o = 2;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f27680p = 3;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f27681q = 4;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f27682r = 5;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f27683s = 6;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f27684t = 7;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f27685u = 8;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f27686v = 9;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f27687w = 10;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f27688x = "android.support.action.showsUserInterface";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f27689y = "android.support.action.semanticAction";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f27690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public IconCompat f27691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h0[] f27692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0[] f27693d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f27694e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f27695f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f27696g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f27697h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f27698i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f27699j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        public PendingIntent f27700k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f27701l;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f27702a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f27703b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f27704c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f27705d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f27706e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList<h0> f27707f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f27708g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f27709h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f27710i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f27711j;

            /* JADX INFO: renamed from: f0.v$b$a$a, reason: collision with other inner class name */
            @v0(20)
            public static class C0321a {
                private C0321a() {
                }

                @g.u
                public static RemoteInput[] a(Notification.Action action) {
                    return action.getRemoteInputs();
                }
            }

            /* JADX INFO: renamed from: f0.v$b$a$b, reason: collision with other inner class name */
            @v0(23)
            public static class C0322b {
                private C0322b() {
                }

                @g.u
                public static Icon a(Notification.Action action) {
                    return action.getIcon();
                }
            }

            @v0(24)
            public static class c {
                private c() {
                }

                @g.u
                public static boolean a(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            @v0(28)
            public static class d {
                private d() {
                }

                @g.u
                public static int a(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            @v0(29)
            public static class e {
                private e() {
                }

                @g.u
                public static boolean a(Notification.Action action) {
                    return action.isContextual();
                }
            }

            @v0(31)
            public static class f {
                private f() {
                }

                @g.u
                public static boolean a(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }

            public a(@p0 IconCompat iconCompat, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            @n0
            @v0(19)
            public static a f(@n0 Notification.Action action) {
                a aVar = (Build.VERSION.SDK_INT < 23 || C0322b.a(action) == null) ? new a(action.icon, action.title, action.actionIntent) : new a(IconCompat.o(C0322b.a(action)), action.title, action.actionIntent);
                RemoteInput[] remoteInputArrA = C0321a.a(action);
                if (remoteInputArrA != null && remoteInputArrA.length != 0) {
                    for (RemoteInput remoteInput : remoteInputArrA) {
                        aVar.b(h0.e(remoteInput));
                    }
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 24) {
                    aVar.f27705d = c.a(action);
                }
                if (i10 >= 28) {
                    aVar.k(d.a(action));
                }
                if (i10 >= 29) {
                    aVar.j(e.a(action));
                }
                if (i10 >= 31) {
                    aVar.i(f.a(action));
                }
                return aVar;
            }

            @n0
            public a a(@p0 Bundle bundle) {
                if (bundle != null) {
                    this.f27706e.putAll(bundle);
                }
                return this;
            }

            @n0
            public a b(@p0 h0 h0Var) {
                if (this.f27707f == null) {
                    this.f27707f = new ArrayList<>();
                }
                if (h0Var != null) {
                    this.f27707f.add(h0Var);
                }
                return this;
            }

            @n0
            public b c() {
                d();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<h0> arrayList3 = this.f27707f;
                if (arrayList3 != null) {
                    for (h0 h0Var : arrayList3) {
                        if (h0Var.r()) {
                            arrayList.add(h0Var);
                        } else {
                            arrayList2.add(h0Var);
                        }
                    }
                }
                h0[] h0VarArr = arrayList.isEmpty() ? null : (h0[]) arrayList.toArray(new h0[arrayList.size()]);
                return new b(this.f27702a, this.f27703b, this.f27704c, this.f27706e, arrayList2.isEmpty() ? null : (h0[]) arrayList2.toArray(new h0[arrayList2.size()]), h0VarArr, this.f27705d, this.f27708g, this.f27709h, this.f27710i, this.f27711j);
            }

            public final void d() {
                if (this.f27710i) {
                    Objects.requireNonNull(this.f27704c, "Contextual Actions must contain a valid PendingIntent");
                }
            }

            @n0
            public a e(@n0 InterfaceC0323b interfaceC0323b) {
                interfaceC0323b.a(this);
                return this;
            }

            @n0
            public Bundle g() {
                return this.f27706e;
            }

            @n0
            public a h(boolean z10) {
                this.f27705d = z10;
                return this;
            }

            @n0
            public a i(boolean z10) {
                this.f27711j = z10;
                return this;
            }

            @n0
            public a j(boolean z10) {
                this.f27710i = z10;
                return this;
            }

            @n0
            public a k(int i10) {
                this.f27708g = i10;
                return this;
            }

            @n0
            public a l(boolean z10) {
                this.f27709h = z10;
                return this;
            }

            public a(int i10, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.y(null, "", i10) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a(@n0 b bVar) {
                this(bVar.f(), bVar.f27699j, bVar.f27700k, new Bundle(bVar.f27690a), bVar.g(), bVar.b(), bVar.h(), bVar.f27695f, bVar.l(), bVar.k());
            }

            public a(@p0 IconCompat iconCompat, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent, @n0 Bundle bundle, @p0 h0[] h0VarArr, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
                this.f27705d = true;
                this.f27709h = true;
                this.f27702a = iconCompat;
                this.f27703b = n.A(charSequence);
                this.f27704c = pendingIntent;
                this.f27706e = bundle;
                this.f27707f = h0VarArr == null ? null : new ArrayList<>(Arrays.asList(h0VarArr));
                this.f27705d = z10;
                this.f27708g = i10;
                this.f27709h = z11;
                this.f27710i = z12;
                this.f27711j = z13;
            }
        }

        /* JADX INFO: renamed from: f0.v$b$b, reason: collision with other inner class name */
        public interface InterfaceC0323b {
            @n0
            a a(@n0 a aVar);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface c {
        }

        public b(int i10, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.y(null, "", i10) : null, charSequence, pendingIntent);
        }

        @p0
        public PendingIntent a() {
            return this.f27700k;
        }

        public boolean b() {
            return this.f27694e;
        }

        @p0
        public h0[] c() {
            return this.f27693d;
        }

        @n0
        public Bundle d() {
            return this.f27690a;
        }

        @Deprecated
        public int e() {
            return this.f27698i;
        }

        @p0
        public IconCompat f() {
            int i10;
            if (this.f27691b == null && (i10 = this.f27698i) != 0) {
                this.f27691b = IconCompat.y(null, "", i10);
            }
            return this.f27691b;
        }

        @p0
        public h0[] g() {
            return this.f27692c;
        }

        public int h() {
            return this.f27696g;
        }

        public boolean i() {
            return this.f27695f;
        }

        @p0
        public CharSequence j() {
            return this.f27699j;
        }

        public boolean k() {
            return this.f27701l;
        }

        public boolean l() {
            return this.f27697h;
        }

        public static final class d implements InterfaceC0323b {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final String f27712e = "android.wearable.EXTENSIONS";

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final String f27713f = "flags";

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final String f27714g = "inProgressLabel";

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final String f27715h = "confirmLabel";

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final String f27716i = "cancelLabel";

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f27717j = 1;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final int f27718k = 2;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final int f27719l = 4;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final int f27720m = 1;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f27721a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public CharSequence f27722b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public CharSequence f27723c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public CharSequence f27724d;

            public d() {
                this.f27721a = 1;
            }

            @Override // f0.v.b.InterfaceC0323b
            @n0
            public a a(@n0 a aVar) {
                Bundle bundle = new Bundle();
                int i10 = this.f27721a;
                if (i10 != 1) {
                    bundle.putInt("flags", i10);
                }
                CharSequence charSequence = this.f27722b;
                if (charSequence != null) {
                    bundle.putCharSequence(f27714g, charSequence);
                }
                CharSequence charSequence2 = this.f27723c;
                if (charSequence2 != null) {
                    bundle.putCharSequence(f27715h, charSequence2);
                }
                CharSequence charSequence3 = this.f27724d;
                if (charSequence3 != null) {
                    bundle.putCharSequence(f27716i, charSequence3);
                }
                aVar.g().putBundle("android.wearable.EXTENSIONS", bundle);
                return aVar;
            }

            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d clone() {
                d dVar = new d();
                dVar.f27721a = this.f27721a;
                dVar.f27722b = this.f27722b;
                dVar.f27723c = this.f27723c;
                dVar.f27724d = this.f27724d;
                return dVar;
            }

            @p0
            @Deprecated
            public CharSequence c() {
                return this.f27724d;
            }

            @p0
            @Deprecated
            public CharSequence d() {
                return this.f27723c;
            }

            public boolean e() {
                return (this.f27721a & 4) != 0;
            }

            public boolean f() {
                return (this.f27721a & 2) != 0;
            }

            @p0
            @Deprecated
            public CharSequence g() {
                return this.f27722b;
            }

            public boolean h() {
                return (this.f27721a & 1) != 0;
            }

            @n0
            public d i(boolean z10) {
                l(1, z10);
                return this;
            }

            @n0
            @Deprecated
            public d j(@p0 CharSequence charSequence) {
                this.f27724d = charSequence;
                return this;
            }

            @n0
            @Deprecated
            public d k(@p0 CharSequence charSequence) {
                this.f27723c = charSequence;
                return this;
            }

            public final void l(int i10, boolean z10) {
                if (z10) {
                    this.f27721a = i10 | this.f27721a;
                } else {
                    this.f27721a = (~i10) & this.f27721a;
                }
            }

            @n0
            public d m(boolean z10) {
                l(4, z10);
                return this;
            }

            @n0
            public d n(boolean z10) {
                l(2, z10);
                return this;
            }

            @n0
            @Deprecated
            public d o(@p0 CharSequence charSequence) {
                this.f27722b = charSequence;
                return this;
            }

            public d(@n0 b bVar) {
                this.f27721a = 1;
                Bundle bundle = bVar.d().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f27721a = bundle.getInt("flags", 1);
                    this.f27722b = bundle.getCharSequence(f27714g);
                    this.f27723c = bundle.getCharSequence(f27715h);
                    this.f27724d = bundle.getCharSequence(f27716i);
                }
            }
        }

        public b(@p0 IconCompat iconCompat, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (h0[]) null, (h0[]) null, true, 0, true, false, false);
        }

        public b(int i10, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent, @p0 Bundle bundle, @p0 h0[] h0VarArr, @p0 h0[] h0VarArr2, boolean z10, int i11, boolean z11, boolean z12, boolean z13) {
            this(i10 != 0 ? IconCompat.y(null, "", i10) : null, charSequence, pendingIntent, bundle, h0VarArr, h0VarArr2, z10, i11, z11, z12, z13);
        }

        public b(@p0 IconCompat iconCompat, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent, @p0 Bundle bundle, @p0 h0[] h0VarArr, @p0 h0[] h0VarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f27695f = true;
            this.f27691b = iconCompat;
            if (iconCompat != null && iconCompat.D() == 2) {
                this.f27698i = iconCompat.A();
            }
            this.f27699j = n.A(charSequence);
            this.f27700k = pendingIntent;
            this.f27690a = bundle == null ? new Bundle() : bundle;
            this.f27692c = h0VarArr;
            this.f27693d = h0VarArr2;
            this.f27694e = z10;
            this.f27696g = i10;
            this.f27695f = z11;
            this.f27697h = z12;
            this.f27701l = z13;
        }
    }

    @v0(20)
    public static class c {
        @g.u
        public static boolean a(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        @g.u
        public static CharSequence[] b(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        @g.u
        public static Bundle c(Notification.Action action) {
            return action.getExtras();
        }

        @g.u
        public static Bundle d(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        @g.u
        public static String e(Notification notification) {
            return notification.getGroup();
        }

        @g.u
        public static CharSequence f(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        @g.u
        public static RemoteInput[] g(Notification.Action action) {
            return action.getRemoteInputs();
        }

        @g.u
        public static String h(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        @g.u
        public static String i(Notification notification) {
            return notification.getSortKey();
        }
    }

    @v0(23)
    public static class d {
        @g.u
        public static Icon a(Notification.Action action) {
            return action.getIcon();
        }
    }

    @v0(24)
    public static class e {
        @g.u
        public static boolean a(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    @v0(26)
    public static class f {
        @g.u
        public static int a(Notification notification) {
            return notification.getBadgeIconType();
        }

        @g.u
        public static String b(Notification notification) {
            return notification.getChannelId();
        }

        @g.u
        public static int c(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        @g.u
        public static CharSequence d(Notification notification) {
            return notification.getSettingsText();
        }

        @g.u
        public static String e(Notification notification) {
            return notification.getShortcutId();
        }

        @g.u
        public static long f(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    @v0(28)
    public static class g {
        @g.u
        public static int a(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    @v0(29)
    public static class h {
        @g.u
        public static boolean a(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        @g.u
        public static Notification.BubbleMetadata b(Notification notification) {
            return notification.getBubbleMetadata();
        }

        @g.u
        public static int c(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        @g.u
        public static LocusId d(Notification notification) {
            return notification.getLocusId();
        }

        @g.u
        public static boolean e(Notification.Action action) {
            return action.isContextual();
        }
    }

    @v0(31)
    public static class i {
        @g.u
        public static boolean a(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface j {
    }

    public static class k extends y {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f27725j = "androidx.core.app.NotificationCompat$BigPictureStyle";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f27726e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f27727f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f27728g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f27729h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f27730i;

        @v0(16)
        public static class a {
            private a() {
            }

            @g.u
            public static Notification.BigPictureStyle a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                return bigPictureStyle.bigPicture(bitmap);
            }

            @g.u
            public static Notification.BigPictureStyle b(Notification.Builder builder) {
                return new Notification.BigPictureStyle(builder);
            }

            @g.u
            public static Notification.BigPictureStyle c(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                return bigPictureStyle.setBigContentTitle(charSequence);
            }

            @v0(16)
            public static void d(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            @v0(16)
            public static void e(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        @v0(23)
        public static class b {
            private b() {
            }

            @v0(23)
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @v0(31)
        public static class c {
            private c() {
            }

            @v0(31)
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @v0(31)
            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @v0(31)
            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                bigPictureStyle.showBigPictureWhenCollapsed(z10);
            }
        }

        public k() {
        }

        @p0
        public static IconCompat A(@p0 Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23 && (parcelable instanceof Icon)) {
                return IconCompat.n((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.t((Bitmap) parcelable);
            }
            return null;
        }

        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat F(@p0 Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable(v.T);
            return parcelable != null ? A(parcelable) : A(bundle.getParcelable(v.U));
        }

        @n0
        public k B(@p0 Bitmap bitmap) {
            this.f27727f = bitmap == null ? null : IconCompat.t(bitmap);
            this.f27728g = true;
            return this;
        }

        @n0
        @v0(23)
        public k C(@p0 Icon icon) {
            this.f27727f = icon == null ? null : IconCompat.n(icon);
            this.f27728g = true;
            return this;
        }

        @n0
        public k D(@p0 Bitmap bitmap) {
            this.f27726e = bitmap == null ? null : IconCompat.t(bitmap);
            return this;
        }

        @n0
        @v0(31)
        public k E(@p0 Icon icon) {
            this.f27726e = IconCompat.n(icon);
            return this;
        }

        @n0
        public k G(@p0 CharSequence charSequence) {
            this.f27845b = n.A(charSequence);
            return this;
        }

        @n0
        @v0(31)
        public k H(@p0 CharSequence charSequence) {
            this.f27729h = charSequence;
            return this;
        }

        @n0
        public k I(@p0 CharSequence charSequence) {
            this.f27846c = n.A(charSequence);
            this.f27847d = true;
            return this;
        }

        @n0
        @v0(31)
        public k J(boolean z10) {
            this.f27730i = z10;
            return this;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
            int i10 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPictureStyleC = a.c(a.b(sVar.a()), this.f27845b);
            IconCompat iconCompat = this.f27726e;
            if (iconCompat != null) {
                if (i10 >= 31) {
                    c.a(bigPictureStyleC, this.f27726e.N(sVar instanceof f0.w ? ((f0.w) sVar).f() : null));
                } else if (iconCompat.D() == 1) {
                    bigPictureStyleC = a.a(bigPictureStyleC, this.f27726e.z());
                }
            }
            if (this.f27728g) {
                IconCompat iconCompat2 = this.f27727f;
                if (iconCompat2 == null) {
                    a.d(bigPictureStyleC, null);
                } else if (i10 >= 23) {
                    b.a(bigPictureStyleC, this.f27727f.N(sVar instanceof f0.w ? ((f0.w) sVar).f() : null));
                } else if (iconCompat2.D() == 1) {
                    a.d(bigPictureStyleC, this.f27727f.z());
                } else {
                    a.d(bigPictureStyleC, null);
                }
            }
            if (this.f27847d) {
                a.e(bigPictureStyleC, this.f27846c);
            }
            if (i10 >= 31) {
                c.c(bigPictureStyleC, this.f27730i);
                c.b(bigPictureStyleC, this.f27729h);
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@n0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(v.L);
            bundle.remove(v.T);
            bundle.remove(v.U);
            bundle.remove(v.W);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public String t() {
            return f27725j;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@n0 Bundle bundle) {
            super.y(bundle);
            if (bundle.containsKey(v.L)) {
                this.f27727f = A(bundle.getParcelable(v.L));
                this.f27728g = true;
            }
            this.f27726e = F(bundle);
            this.f27730i = bundle.getBoolean(v.W);
        }

        public k(@p0 n nVar) {
            z(nVar);
        }
    }

    public static class l extends y {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f27731f = "androidx.core.app.NotificationCompat$BigTextStyle";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f27732e;

        @v0(16)
        public static class a {
            private a() {
            }

            @g.u
            public static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            @g.u
            public static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            @g.u
            public static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            @g.u
            public static Notification.BigTextStyle d(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }
        }

        public l() {
        }

        @n0
        public l A(@p0 CharSequence charSequence) {
            this.f27732e = n.A(charSequence);
            return this;
        }

        @n0
        public l B(@p0 CharSequence charSequence) {
            this.f27845b = n.A(charSequence);
            return this;
        }

        @n0
        public l C(@p0 CharSequence charSequence) {
            this.f27846c = n.A(charSequence);
            this.f27847d = true;
            return this;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@n0 Bundle bundle) {
            super.a(bundle);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
            Notification.BigTextStyle bigTextStyleA = a.a(a.c(a.b(sVar.a()), this.f27845b), this.f27732e);
            if (this.f27847d) {
                a.d(bigTextStyleA, this.f27846c);
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@n0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(v.I);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public String t() {
            return f27731f;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@n0 Bundle bundle) {
            super.y(bundle);
            this.f27732e = bundle.getCharSequence(v.I);
        }

        public l(@p0 n nVar) {
            z(nVar);
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f27733h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f27734i = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PendingIntent f27735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PendingIntent f27736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IconCompat f27737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f27738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.q
        public int f27739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f27740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f27741g;

        @v0(29)
        public static class a {
            private a() {
            }

            @p0
            @v0(29)
            public static m a(@p0 Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                c cVarI = new c(bubbleMetadata.getIntent(), IconCompat.n(bubbleMetadata.getIcon())).b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).i(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVarI.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVarI.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVarI.a();
            }

            @p0
            @v0(29)
            public static Notification.BubbleMetadata b(@p0 m mVar) {
                if (mVar == null || mVar.g() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(mVar.f().M()).setIntent(mVar.g()).setDeleteIntent(mVar.c()).setAutoExpandBubble(mVar.b()).setSuppressNotification(mVar.i());
                if (mVar.d() != 0) {
                    suppressNotification.setDesiredHeight(mVar.d());
                }
                if (mVar.e() != 0) {
                    suppressNotification.setDesiredHeightResId(mVar.e());
                }
                return suppressNotification.build();
            }
        }

        @v0(30)
        public static class b {
            private b() {
            }

            @p0
            @v0(30)
            public static m a(@p0 Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                c cVar = bubbleMetadata.getShortcutId() != null ? new c(bubbleMetadata.getShortcutId()) : new c(bubbleMetadata.getIntent(), IconCompat.n(bubbleMetadata.getIcon()));
                cVar.b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).i(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVar.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVar.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVar.a();
            }

            @p0
            @v0(30)
            public static Notification.BubbleMetadata b(@p0 m mVar) {
                if (mVar == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = mVar.h() != null ? new Notification.BubbleMetadata.Builder(mVar.h()) : new Notification.BubbleMetadata.Builder(mVar.g(), mVar.f().M());
                builder.setDeleteIntent(mVar.c()).setAutoExpandBubble(mVar.b()).setSuppressNotification(mVar.i());
                if (mVar.d() != 0) {
                    builder.setDesiredHeight(mVar.d());
                }
                if (mVar.e() != 0) {
                    builder.setDesiredHeightResId(mVar.e());
                }
                return builder.build();
            }
        }

        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public PendingIntent f27742a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public IconCompat f27743b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f27744c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @g.q
            public int f27745d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f27746e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public PendingIntent f27747f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f27748g;

            @Deprecated
            public c() {
            }

            @SuppressLint({"SyntheticAccessor"})
            @n0
            public m a() {
                String str = this.f27748g;
                if (str == null) {
                    Objects.requireNonNull(this.f27742a, "Must supply pending intent or shortcut to bubble");
                }
                if (str == null) {
                    Objects.requireNonNull(this.f27743b, "Must supply an icon or shortcut for the bubble");
                }
                m mVar = new m(this.f27742a, this.f27747f, this.f27743b, this.f27744c, this.f27745d, this.f27746e, str);
                mVar.j(this.f27746e);
                return mVar;
            }

            @n0
            public c b(boolean z10) {
                f(1, z10);
                return this;
            }

            @n0
            public c c(@p0 PendingIntent pendingIntent) {
                this.f27747f = pendingIntent;
                return this;
            }

            @n0
            public c d(@g.r(unit = 0) int i10) {
                this.f27744c = Math.max(i10, 0);
                this.f27745d = 0;
                return this;
            }

            @n0
            public c e(@g.q int i10) {
                this.f27745d = i10;
                this.f27744c = 0;
                return this;
            }

            @n0
            public final c f(int i10, boolean z10) {
                if (z10) {
                    this.f27746e = i10 | this.f27746e;
                } else {
                    this.f27746e = (~i10) & this.f27746e;
                }
                return this;
            }

            @n0
            public c g(@n0 IconCompat iconCompat) {
                if (this.f27748g != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                Objects.requireNonNull(iconCompat, "Bubbles require non-null icon");
                this.f27743b = iconCompat;
                return this;
            }

            @n0
            public c h(@n0 PendingIntent pendingIntent) {
                if (this.f27748g != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                Objects.requireNonNull(pendingIntent, "Bubble requires non-null pending intent");
                this.f27742a = pendingIntent;
                return this;
            }

            @n0
            public c i(boolean z10) {
                f(2, z10);
                return this;
            }

            @v0(30)
            public c(@n0 String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.f27748g = str;
            }

            public c(@n0 PendingIntent pendingIntent, @n0 IconCompat iconCompat) {
                Objects.requireNonNull(pendingIntent, "Bubble requires non-null pending intent");
                Objects.requireNonNull(iconCompat, "Bubbles require non-null icon");
                this.f27742a = pendingIntent;
                this.f27743b = iconCompat;
            }
        }

        @p0
        public static m a(@p0 Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                return b.a(bubbleMetadata);
            }
            if (i10 == 29) {
                return a.a(bubbleMetadata);
            }
            return null;
        }

        @p0
        public static Notification.BubbleMetadata k(@p0 m mVar) {
            if (mVar == null) {
                return null;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                return b.b(mVar);
            }
            if (i10 == 29) {
                return a.b(mVar);
            }
            return null;
        }

        public boolean b() {
            return (this.f27740f & 1) != 0;
        }

        @p0
        public PendingIntent c() {
            return this.f27736b;
        }

        @g.r(unit = 0)
        public int d() {
            return this.f27738d;
        }

        @g.q
        public int e() {
            return this.f27739e;
        }

        @p0
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat f() {
            return this.f27737c;
        }

        @p0
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent g() {
            return this.f27735a;
        }

        @p0
        public String h() {
            return this.f27741g;
        }

        public boolean i() {
            return (this.f27740f & 2) != 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void j(int i10) {
            this.f27740f = i10;
        }

        public m(@p0 PendingIntent pendingIntent, @p0 PendingIntent pendingIntent2, @p0 IconCompat iconCompat, int i10, @g.q int i11, int i12, @p0 String str) {
            this.f27735a = pendingIntent;
            this.f27737c = iconCompat;
            this.f27738d = i10;
            this.f27739e = i11;
            this.f27736b = pendingIntent2;
            this.f27740f = i12;
            this.f27741g = str;
        }
    }

    public static class o extends y {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f27775o = "androidx.core.app.NotificationCompat$CallStyle";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f27776p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f27777q = 1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f27778r = 2;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f27779s = 3;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f27780t = "key_action_priority";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f27781e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f0 f27782f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f27783g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f27784h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f27785i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f27786j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f27787k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f27788l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f27789m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f27790n;

        @v0(16)
        public static class a {
            private a() {
            }

            @g.u
            public static void a(Notification.CallStyle callStyle, Notification.Builder builder) {
                callStyle.setBuilder(builder);
            }
        }

        @v0(20)
        public static class b {
            private b() {
            }

            @g.u
            public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
                return builder.addAction(action);
            }

            @g.u
            public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @g.u
            public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            @g.u
            public static Notification.Action d(Notification.Action.Builder builder) {
                return builder.build();
            }

            @g.u
            public static Notification.Action.Builder e(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i10, charSequence, pendingIntent);
            }
        }

        @v0(21)
        public static class c {
            private c() {
            }

            @g.u
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            @g.u
            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        @v0(23)
        public static class d {
            private d() {
            }

            @g.u
            public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            @g.u
            public static void b(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        @v0(24)
        public static class e {
            private e() {
            }

            @g.u
            public static Notification.Builder a(Notification.Builder builder) {
                return builder.setActions(new Notification.Action[0]);
            }

            @g.u
            public static Notification.Action.Builder b(Notification.Action.Builder builder, boolean z10) {
                return builder.setAllowGeneratedReplies(z10);
            }
        }

        @v0(28)
        public static class f {
            private f() {
            }

            @g.u
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }
        }

        @v0(31)
        public static class g {
            private g() {
            }

            @g.u
            public static Notification.CallStyle a(@n0 Person person, @n0 PendingIntent pendingIntent, @n0 PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            @g.u
            public static Notification.CallStyle b(@n0 Person person, @n0 PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            @g.u
            public static Notification.CallStyle c(@n0 Person person, @n0 PendingIntent pendingIntent, @n0 PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            @g.u
            public static Notification.CallStyle d(Notification.CallStyle callStyle, @g.l int i10) {
                return callStyle.setAnswerButtonColorHint(i10);
            }

            @g.u
            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z10) {
                return builder.setAuthenticationRequired(z10);
            }

            @g.u
            public static Notification.CallStyle f(Notification.CallStyle callStyle, @g.l int i10) {
                return callStyle.setDeclineButtonColorHint(i10);
            }

            @g.u
            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z10) {
                return callStyle.setIsVideo(z10);
            }

            @g.u
            public static Notification.CallStyle h(Notification.CallStyle callStyle, @p0 Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            @g.u
            public static Notification.CallStyle i(Notification.CallStyle callStyle, @p0 CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface h {
        }

        public o() {
        }

        @n0
        public static o A(@n0 f0 f0Var, @n0 PendingIntent pendingIntent, @n0 PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "declineIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new o(1, f0Var, null, pendingIntent, pendingIntent2);
        }

        @n0
        public static o B(@n0 f0 f0Var, @n0 PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            return new o(2, f0Var, pendingIntent, null, null);
        }

        @n0
        public static o C(@n0 f0 f0Var, @n0 PendingIntent pendingIntent, @n0 PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new o(3, f0Var, pendingIntent, null, pendingIntent2);
        }

        @v0(20)
        public static Notification.Action D(b bVar) {
            Notification.Action.Builder builderE;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                IconCompat iconCompatF = bVar.f();
                builderE = d.a(iconCompatF == null ? null : iconCompatF.M(), bVar.j(), bVar.a());
            } else {
                IconCompat iconCompatF2 = bVar.f();
                builderE = b.e((iconCompatF2 == null || iconCompatF2.D() != 2) ? 0 : iconCompatF2.A(), bVar.j(), bVar.a());
            }
            Bundle bundle = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
            bundle.putBoolean(f0.y.f27891c, bVar.b());
            if (i10 >= 24) {
                e.b(builderE, bVar.b());
            }
            if (i10 >= 31) {
                g.e(builderE, bVar.k());
            }
            b.b(builderE, bundle);
            h0[] h0VarArrG = bVar.g();
            if (h0VarArrG != null) {
                for (RemoteInput remoteInput : h0.d(h0VarArrG)) {
                    b.c(builderE, remoteInput);
                }
            }
            return b.d(builderE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        @v0(20)
        public ArrayList<b> E() {
            b bVarJ = J();
            b bVarI = I();
            ArrayList<b> arrayList = new ArrayList<>(3);
            arrayList.add(bVarJ);
            int i10 = 2;
            ArrayList<b> arrayList2 = this.f27844a.f27750b;
            if (arrayList2 != null) {
                for (b bVar : arrayList2) {
                    if (bVar.l()) {
                        arrayList.add(bVar);
                    } else if (!G(bVar) && i10 > 1) {
                        arrayList.add(bVar);
                        i10--;
                    }
                    if (bVarI != null && i10 == 1) {
                        arrayList.add(bVarI);
                        i10--;
                    }
                }
            }
            if (bVarI != null && i10 >= 1) {
                arrayList.add(bVarI);
            }
            return arrayList;
        }

        @p0
        public final String F() {
            int i10 = this.f27781e;
            if (i10 == 1) {
                return this.f27844a.f27749a.getResources().getString(R.string.call_notification_incoming_text);
            }
            if (i10 == 2) {
                return this.f27844a.f27749a.getResources().getString(R.string.call_notification_ongoing_text);
            }
            if (i10 != 3) {
                return null;
            }
            return this.f27844a.f27749a.getResources().getString(R.string.call_notification_screening_text);
        }

        public final boolean G(b bVar) {
            return bVar != null && bVar.d().getBoolean(f27780t);
        }

        @n0
        @v0(20)
        public final b H(int i10, int i11, Integer num, int i12, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(h0.d.f(this.f27844a.f27749a, i12));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f27844a.f27749a.getResources().getString(i11));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            b bVarC = new b.a(IconCompat.x(this.f27844a.f27749a, i10), spannableStringBuilder, pendingIntent).c();
            bVarC.d().putBoolean(f27780t, true);
            return bVarC;
        }

        @p0
        @v0(20)
        public final b I() {
            int i10 = R.drawable.ic_call_answer_video;
            int i11 = R.drawable.ic_call_answer;
            PendingIntent pendingIntent = this.f27783g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z10 = this.f27786j;
            return H(z10 ? i10 : i11, z10 ? R.string.call_notification_answer_video_action : R.string.call_notification_answer_action, this.f27787k, R.color.call_notification_answer_color, pendingIntent);
        }

        @n0
        @v0(20)
        public final b J() {
            int i10 = R.drawable.ic_call_decline;
            PendingIntent pendingIntent = this.f27784h;
            return pendingIntent == null ? H(i10, R.string.call_notification_hang_up_action, this.f27788l, R.color.call_notification_decline_color, this.f27785i) : H(i10, R.string.call_notification_decline_action, this.f27788l, R.color.call_notification_decline_color, pendingIntent);
        }

        @n0
        public o K(@g.l int i10) {
            this.f27787k = Integer.valueOf(i10);
            return this;
        }

        @n0
        public o L(@g.l int i10) {
            this.f27788l = Integer.valueOf(i10);
            return this;
        }

        @n0
        public o M(boolean z10) {
            this.f27786j = z10;
            return this;
        }

        @n0
        public o N(@p0 Bitmap bitmap) {
            this.f27789m = IconCompat.t(bitmap);
            return this;
        }

        @n0
        @v0(23)
        public o O(@p0 Icon icon) {
            this.f27789m = icon == null ? null : IconCompat.n(icon);
            return this;
        }

        @n0
        public o P(@p0 CharSequence charSequence) {
            this.f27790n = charSequence;
            return this;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@n0 Bundle bundle) {
            super.a(bundle);
            bundle.putInt(v.f27648l0, this.f27781e);
            bundle.putBoolean(v.f27650m0, this.f27786j);
            f0 f0Var = this.f27782f;
            if (f0Var != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable(v.f27652n0, f0Var.k());
                } else {
                    bundle.putParcelable(v.f27654o0, f0Var.m());
                }
            }
            IconCompat iconCompat = this.f27789m;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    bundle.putParcelable(v.f27656p0, iconCompat.N(this.f27844a.f27749a));
                } else {
                    bundle.putParcelable(v.f27658q0, iconCompat.L());
                }
            }
            bundle.putCharSequence(v.f27660r0, this.f27790n);
            bundle.putParcelable(v.f27662s0, this.f27783g);
            bundle.putParcelable(v.f27664t0, this.f27784h);
            bundle.putParcelable(v.f27666u0, this.f27785i);
            Integer num = this.f27787k;
            if (num != null) {
                bundle.putInt(v.f27668v0, num.intValue());
            }
            Integer num2 = this.f27788l;
            if (num2 != null) {
                bundle.putInt(v.f27670w0, num2.intValue());
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
            int i10 = Build.VERSION.SDK_INT;
            CharSequence charSequenceF = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceF = null;
            if (i10 < 31) {
                Notification.Builder builderA = sVar.a();
                f0 f0Var = this.f27782f;
                builderA.setContentTitle(f0Var != null ? f0Var.f() : null);
                Bundle bundle = this.f27844a.E;
                if (bundle != null && bundle.containsKey(v.D)) {
                    charSequenceF = this.f27844a.E.getCharSequence(v.D);
                }
                if (charSequenceF == null) {
                    charSequenceF = F();
                }
                builderA.setContentText(charSequenceF);
                f0 f0Var2 = this.f27782f;
                if (f0Var2 != null) {
                    if (i10 >= 23 && f0Var2.d() != null) {
                        d.b(builderA, this.f27782f.d().N(this.f27844a.f27749a));
                    }
                    if (i10 >= 28) {
                        f.a(builderA, this.f27782f.k());
                    } else {
                        c.a(builderA, this.f27782f.g());
                    }
                }
                ArrayList<b> arrayListE = E();
                if (i10 >= 24) {
                    e.a(builderA);
                }
                Iterator<b> it2 = arrayListE.iterator();
                while (it2.hasNext()) {
                    b.a(builderA, D(it2.next()));
                }
                c.b(builderA, v.E0);
                return;
            }
            int i11 = this.f27781e;
            if (i11 == 1) {
                callStyleA = g.a(this.f27782f.k(), this.f27784h, this.f27783g);
            } else if (i11 == 2) {
                callStyleA = g.b(this.f27782f.k(), this.f27785i);
            } else if (i11 == 3) {
                callStyleA = g.c(this.f27782f.k(), this.f27785i, this.f27783g);
            } else if (Log.isLoggable(v.f27617a, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unrecognized call type in CallStyle: ");
                sb2.append(String.valueOf(this.f27781e));
            }
            if (callStyleA != null) {
                e.a(sVar.a());
                a.a(callStyleA, sVar.a());
                Integer num = this.f27787k;
                if (num != null) {
                    g.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f27788l;
                if (num2 != null) {
                    g.f(callStyleA, num2.intValue());
                }
                g.i(callStyleA, this.f27790n);
                IconCompat iconCompat = this.f27789m;
                if (iconCompat != null) {
                    g.h(callStyleA, iconCompat.N(this.f27844a.f27749a));
                }
                g.g(callStyleA, this.f27786j);
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return true;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public String t() {
            return f27775o;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@n0 Bundle bundle) {
            super.y(bundle);
            this.f27781e = bundle.getInt(v.f27648l0);
            this.f27786j = bundle.getBoolean(v.f27650m0);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28 && bundle.containsKey(v.f27652n0)) {
                this.f27782f = f0.a((Person) bundle.getParcelable(v.f27652n0));
            } else if (bundle.containsKey(v.f27654o0)) {
                this.f27782f = f0.b(bundle.getBundle(v.f27654o0));
            }
            if (i10 >= 23 && bundle.containsKey(v.f27656p0)) {
                this.f27789m = IconCompat.n((Icon) bundle.getParcelable(v.f27656p0));
            } else if (bundle.containsKey(v.f27658q0)) {
                this.f27789m = IconCompat.l(bundle.getBundle(v.f27658q0));
            }
            this.f27790n = bundle.getCharSequence(v.f27660r0);
            this.f27783g = (PendingIntent) bundle.getParcelable(v.f27662s0);
            this.f27784h = (PendingIntent) bundle.getParcelable(v.f27664t0);
            this.f27785i = (PendingIntent) bundle.getParcelable(v.f27666u0);
            this.f27787k = bundle.containsKey(v.f27668v0) ? Integer.valueOf(bundle.getInt(v.f27668v0)) : null;
            this.f27788l = bundle.containsKey(v.f27670w0) ? Integer.valueOf(bundle.getInt(v.f27670w0)) : null;
        }

        public o(@p0 n nVar) {
            z(nVar);
        }

        public o(int i10, @n0 f0 f0Var, @p0 PendingIntent pendingIntent, @p0 PendingIntent pendingIntent2, @p0 PendingIntent pendingIntent3) {
            if (f0Var != null && !TextUtils.isEmpty(f0Var.f())) {
                this.f27781e = i10;
                this.f27782f = f0Var;
                this.f27783g = pendingIntent3;
                this.f27784h = pendingIntent2;
                this.f27785i = pendingIntent;
                return;
            }
            throw new IllegalArgumentException("person must have a non-empty a name");
        }
    }

    public static class q extends y {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f27819e = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f27820f = 3;

        @v0(15)
        public static class a {
            private a() {
            }

            @g.u
            public static void a(RemoteViews remoteViews, int i10, CharSequence charSequence) {
                remoteViews.setContentDescription(i10, charSequence);
            }
        }

        @v0(16)
        public static class b {
            private b() {
            }

            @g.u
            public static Notification.Builder a(Notification.Builder builder, Object obj) {
                return builder.setStyle((Notification.Style) obj);
            }
        }

        @v0(24)
        public static class c {
            private c() {
            }

            @g.u
            public static Notification.DecoratedCustomViewStyle a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public static List<b> C(List<b> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                if (!bVar.l()) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        public final RemoteViews A(RemoteViews remoteViews, boolean z10) {
            int iMin;
            boolean z11 = true;
            RemoteViews remoteViewsC = c(true, R.layout.notification_template_custom_big, false);
            remoteViewsC.removeAllViews(R.id.actions);
            List<b> listC = C(this.f27844a.f27750b);
            if (!z10 || listC == null || (iMin = Math.min(listC.size(), 3)) <= 0) {
                z11 = false;
            } else {
                for (int i10 = 0; i10 < iMin; i10++) {
                    remoteViewsC.addView(R.id.actions, B(listC.get(i10)));
                }
            }
            int i11 = z11 ? 0 : 8;
            remoteViewsC.setViewVisibility(R.id.actions, i11);
            remoteViewsC.setViewVisibility(R.id.action_divider, i11);
            e(remoteViewsC, remoteViews);
            return remoteViewsC;
        }

        public final RemoteViews B(b bVar) {
            boolean z10 = bVar.f27700k == null;
            RemoteViews remoteViews = new RemoteViews(this.f27844a.f27749a.getPackageName(), z10 ? R.layout.notification_action_tombstone : R.layout.notification_action);
            IconCompat iconCompatF = bVar.f();
            if (iconCompatF != null) {
                remoteViews.setImageViewBitmap(R.id.action_image, o(iconCompatF, R.color.notification_action_color_filter));
            }
            remoteViews.setTextViewText(R.id.action_text, bVar.f27699j);
            if (!z10) {
                remoteViews.setOnClickPendingIntent(R.id.action_container, bVar.f27700k);
            }
            a.a(remoteViews, R.id.action_container, bVar.f27699j);
            return remoteViews;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                b.a(sVar.a(), c.a());
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return true;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public String t() {
            return f27819e;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews v(f0.s sVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsP = this.f27844a.p();
            if (remoteViewsP == null) {
                remoteViewsP = this.f27844a.s();
            }
            if (remoteViewsP == null) {
                return null;
            }
            return A(remoteViewsP, true);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews w(f0.s sVar) {
            if (Build.VERSION.SDK_INT < 24 && this.f27844a.s() != null) {
                return A(this.f27844a.s(), false);
            }
            return null;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews x(f0.s sVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsW = this.f27844a.w();
            RemoteViews remoteViewsS = remoteViewsW != null ? remoteViewsW : this.f27844a.s();
            if (remoteViewsW == null) {
                return null;
            }
            return A(remoteViewsS, true);
        }
    }

    public interface r {
        @n0
        n a(@n0 n nVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface s {
    }

    /* JADX INFO: renamed from: f0.v$v, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface InterfaceC0324v {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface w {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface x {
    }

    public static abstract class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public n f27844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f27845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f27846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f27847d = false;

        @v0(16)
        public static class a {
            private a() {
            }

            @g.u
            public static void a(RemoteViews remoteViews, int i10, int i11, float f10) {
                remoteViews.setTextViewTextSize(i10, i11, f10);
            }

            @g.u
            public static void b(RemoteViews remoteViews, int i10, int i11, int i12, int i13, int i14) {
                remoteViews.setViewPadding(i10, i11, i12, i13, i14);
            }
        }

        @v0(24)
        public static class b {
            private b() {
            }

            @g.u
            public static void a(RemoteViews remoteViews, int i10, boolean z10) {
                remoteViews.setChronometerCountDown(i10, z10);
            }
        }

        public static float h(float f10, float f11, float f12) {
            return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
        }

        @p0
        public static y i(@p0 String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new q();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new k();
                case "androidx.core.app.NotificationCompat$CallStyle":
                    return new o();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new t();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new l();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new u();
                default:
                    return null;
            }
        }

        @p0
        public static y j(@p0 String str) {
            if (str == null) {
                return null;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new k();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new l();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new t();
            }
            if (i10 >= 24) {
                if (str.equals(Notification.MessagingStyle.class.getName())) {
                    return new u();
                }
                if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                    return new q();
                }
            }
            return null;
        }

        @p0
        public static y k(@n0 Bundle bundle) {
            y yVarI = i(bundle.getString(v.Z));
            return yVarI != null ? yVarI : (bundle.containsKey(v.f27633f0) || bundle.containsKey(v.f27636g0)) ? new u() : (bundle.containsKey(v.T) || bundle.containsKey(v.U)) ? new k() : bundle.containsKey(v.I) ? new l() : bundle.containsKey(v.X) ? new t() : bundle.containsKey(v.f27648l0) ? new o() : j(bundle.getString(v.Y));
        }

        @p0
        public static y l(@n0 Bundle bundle) {
            y yVarK = k(bundle);
            if (yVarK == null) {
                return null;
            }
            try {
                yVarK.y(bundle);
                return yVarK;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static y s(@n0 Notification notification) {
            Bundle bundleN = v.n(notification);
            if (bundleN == null) {
                return null;
            }
            return l(bundleN);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@n0 Bundle bundle) {
            if (this.f27847d) {
                bundle.putCharSequence(v.H, this.f27846c);
            }
            CharSequence charSequence = this.f27845b;
            if (charSequence != null) {
                bundle.putCharSequence(v.C, charSequence);
            }
            String strT = t();
            if (strT != null) {
                bundle.putString(v.Z, strT);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0194  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @g.n0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.widget.RemoteViews c(boolean r13, int r14, boolean r15) {
            /*
                Method dump skipped, instruction units count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: f0.v.y.c(boolean, int, boolean):android.widget.RemoteViews");
        }

        @p0
        public Notification d() {
            n nVar = this.f27844a;
            if (nVar != null) {
                return nVar.h();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void e(RemoteViews remoteViews, RemoteViews remoteViews2) {
            u(remoteViews);
            int i10 = R.id.notification_main_column;
            remoteViews.removeAllViews(i10);
            remoteViews.addView(i10, remoteViews2.clone());
            remoteViews.setViewVisibility(i10, 0);
            a.b(remoteViews, R.id.notification_main_column_container, 0, f(), 0, 0);
        }

        public final int f() {
            Resources resources = this.f27844a.f27749a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float fH = (h(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - fH) * dimensionPixelSize) + (fH * dimensionPixelSize2));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@n0 Bundle bundle) {
            bundle.remove(v.H);
            bundle.remove(v.C);
            bundle.remove(v.Z);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap m(int i10, int i11) {
            return n(i10, i11, 0);
        }

        public final Bitmap n(int i10, int i11, int i12) {
            return p(IconCompat.x(this.f27844a.f27749a, i10), i11, i12);
        }

        public Bitmap o(@n0 IconCompat iconCompat, int i10) {
            return p(iconCompat, i10, 0);
        }

        public final Bitmap p(@n0 IconCompat iconCompat, int i10, int i11) {
            Drawable drawableG = iconCompat.G(this.f27844a.f27749a);
            int intrinsicWidth = i11 == 0 ? drawableG.getIntrinsicWidth() : i11;
            if (i11 == 0) {
                i11 = drawableG.getIntrinsicHeight();
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i11, Bitmap.Config.ARGB_8888);
            drawableG.setBounds(0, 0, intrinsicWidth, i11);
            if (i10 != 0) {
                drawableG.mutate().setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
            }
            drawableG.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }

        public final Bitmap q(int i10, int i11, int i12, int i13) {
            int i14 = R.drawable.notification_icon_background;
            if (i13 == 0) {
                i13 = 0;
            }
            Bitmap bitmapN = n(i14, i13, i11);
            Canvas canvas = new Canvas(bitmapN);
            Drawable drawableMutate = this.f27844a.f27749a.getResources().getDrawable(i10).mutate();
            drawableMutate.setFilterBitmap(true);
            int i15 = (i11 - i12) / 2;
            int i16 = i12 + i15;
            drawableMutate.setBounds(i15, i15, i16, i16);
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            drawableMutate.draw(canvas);
            return bitmapN;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean r() {
            return false;
        }

        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String t() {
            return null;
        }

        public final void u(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews v(f0.s sVar) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews w(f0.s sVar) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews x(f0.s sVar) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@n0 Bundle bundle) {
            if (bundle.containsKey(v.H)) {
                this.f27846c = bundle.getCharSequence(v.H);
                this.f27847d = true;
            }
            this.f27845b = bundle.getCharSequence(v.C);
        }

        public void z(@p0 n nVar) {
            if (this.f27844a != nVar) {
                this.f27844a = nVar;
                if (nVar != null) {
                    nVar.z0(this);
                }
            }
        }
    }

    @Deprecated
    public v() {
    }

    @p0
    public static String A(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.e(notification);
        }
        return null;
    }

    @v0(19)
    public static boolean B(@n0 Notification notification) {
        return notification.extras.getBoolean(S);
    }

    @p0
    public static String C(@n0 Notification notification) {
        return c.i(notification);
    }

    @p0
    @v0(19)
    public static CharSequence D(@n0 Notification notification) {
        return notification.extras.getCharSequence(E);
    }

    public static long E(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.f(notification);
        }
        return 0L;
    }

    @v0(19)
    public static boolean F(@n0 Notification notification) {
        return notification.extras.getBoolean(P);
    }

    public static int G(@n0 Notification notification) {
        return notification.visibility;
    }

    public static boolean H(@n0 Notification notification) {
        return (notification.flags & 512) != 0;
    }

    @p0
    public static b a(@n0 Notification notification, int i10) {
        return b(notification.actions[i10]);
    }

    @n0
    @v0(20)
    public static b b(@n0 Notification.Action action) {
        h0[] h0VarArr;
        int i10;
        RemoteInput[] remoteInputArrG = c.g(action);
        if (remoteInputArrG == null) {
            h0VarArr = null;
        } else {
            h0[] h0VarArr2 = new h0[remoteInputArrG.length];
            for (int i11 = 0; i11 < remoteInputArrG.length; i11++) {
                RemoteInput remoteInput = remoteInputArrG[i11];
                h0VarArr2[i11] = new h0(c.h(remoteInput), c.f(remoteInput), c.b(remoteInput), c.a(remoteInput), Build.VERSION.SDK_INT >= 29 ? h.c(remoteInput) : 0, c.d(remoteInput), null);
            }
            h0VarArr = h0VarArr2;
        }
        int i12 = Build.VERSION.SDK_INT;
        boolean z10 = i12 >= 24 ? c.c(action).getBoolean(f0.y.f27891c) || e.a(action) : c.c(action).getBoolean(f0.y.f27891c);
        boolean z11 = c.c(action).getBoolean(b.f27688x, true);
        int iA = i12 >= 28 ? g.a(action) : c.c(action).getInt(b.f27689y, 0);
        boolean zE = i12 >= 29 ? h.e(action) : false;
        boolean zA = i12 >= 31 ? i.a(action) : false;
        if (i12 < 23) {
            return new b(action.icon, action.title, action.actionIntent, c.c(action), h0VarArr, (h0[]) null, z10, iA, z11, zE, zA);
        }
        if (d.a(action) != null || (i10 = action.icon) == 0) {
            return new b(d.a(action) != null ? IconCompat.o(d.a(action)) : null, action.title, action.actionIntent, c.c(action), h0VarArr, (h0[]) null, z10, iA, z11, zE, zA);
        }
        return new b(i10, action.title, action.actionIntent, c.c(action), h0VarArr, (h0[]) null, z10, iA, z11, zE, zA);
    }

    public static int c(@n0 Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean d(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return h.a(notification);
        }
        return false;
    }

    public static boolean e(@n0 Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int f(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.a(notification);
        }
        return 0;
    }

    @p0
    public static m g(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return m.a(h.b(notification));
        }
        return null;
    }

    @p0
    public static String h(@n0 Notification notification) {
        return notification.category;
    }

    @p0
    public static String i(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.b(notification);
        }
        return null;
    }

    public static int j(@n0 Notification notification) {
        return notification.color;
    }

    @p0
    @v0(19)
    public static CharSequence k(@n0 Notification notification) {
        return notification.extras.getCharSequence(G);
    }

    @p0
    @v0(19)
    public static CharSequence l(@n0 Notification notification) {
        return notification.extras.getCharSequence(D);
    }

    @p0
    @v0(19)
    public static CharSequence m(@n0 Notification notification) {
        return notification.extras.getCharSequence(B);
    }

    @p0
    public static Bundle n(@n0 Notification notification) {
        return notification.extras;
    }

    @p0
    public static String o(@n0 Notification notification) {
        return c.e(notification);
    }

    public static int p(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.c(notification);
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static boolean q(@n0 Notification notification) {
        return (notification.flags & 128) != 0;
    }

    @n0
    @v0(21)
    public static List<b> r(@n0 Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle(p.f27791d);
        if (bundle2 != null && (bundle = bundle2.getBundle(p.f27795h)) != null) {
            for (int i10 = 0; i10 < bundle.size(); i10++) {
                arrayList.add(f0.y.g(bundle.getBundle(Integer.toString(i10))));
            }
        }
        return arrayList;
    }

    public static boolean s(@n0 Notification notification) {
        return (notification.flags & 256) != 0;
    }

    @p0
    public static h0.c0 t(@n0 Notification notification) {
        LocusId locusIdD;
        if (Build.VERSION.SDK_INT < 29 || (locusIdD = h.d(notification)) == null) {
            return null;
        }
        return h0.c0.d(locusIdD);
    }

    @n0
    public static Notification[] u(@n0 Bundle bundle, @n0 String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i10 = 0; i10 < parcelableArray.length; i10++) {
            notificationArr[i10] = (Notification) parcelableArray[i10];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean v(@n0 Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean w(@n0 Notification notification) {
        return (notification.flags & 8) != 0;
    }

    @n0
    public static List<f0> x(@n0 Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(f27621b0);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(f0.a((Person) it2.next()));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(f27618a0);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    arrayList.add(new f0.c().g(str).a());
                }
            }
        }
        return arrayList;
    }

    @p0
    public static Notification y(@n0 Notification notification) {
        return notification.publicVersion;
    }

    @p0
    public static CharSequence z(@n0 Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.d(notification);
        }
        return null;
    }

    public static final class p implements r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final String f27791d = "android.car.EXTENSIONS";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f27792e = "large_icon";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f27793f = "car_conversation";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f27794g = "app_color";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final String f27795h = "invisible_actions";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f27796i = "author";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f27797j = "text";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f27798k = "messages";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f27799l = "remote_input";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f27800m = "on_reply";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f27801n = "on_read";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f27802o = "participants";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f27803p = "timestamp";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f27804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f27805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f27806c;

        @v0(20)
        public static class a {
            private a() {
            }

            @g.u
            public static RemoteInput.Builder a(RemoteInput.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @g.u
            public static RemoteInput b(RemoteInput.Builder builder) {
                return builder.build();
            }

            @g.u
            public static RemoteInput.Builder c(String str) {
                return new RemoteInput.Builder(str);
            }

            @g.u
            public static boolean d(RemoteInput remoteInput) {
                return remoteInput.getAllowFreeFormInput();
            }

            @g.u
            public static CharSequence[] e(RemoteInput remoteInput) {
                return remoteInput.getChoices();
            }

            @g.u
            public static Bundle f(RemoteInput remoteInput) {
                return remoteInput.getExtras();
            }

            @g.u
            public static CharSequence g(RemoteInput remoteInput) {
                return remoteInput.getLabel();
            }

            @g.u
            public static String h(RemoteInput remoteInput) {
                return remoteInput.getResultKey();
            }

            @g.u
            public static RemoteInput.Builder i(RemoteInput.Builder builder, boolean z10) {
                return builder.setAllowFreeFormInput(z10);
            }

            @g.u
            public static RemoteInput.Builder j(RemoteInput.Builder builder, CharSequence[] charSequenceArr) {
                return builder.setChoices(charSequenceArr);
            }

            @g.u
            public static RemoteInput.Builder k(RemoteInput.Builder builder, CharSequence charSequence) {
                return builder.setLabel(charSequence);
            }
        }

        @v0(29)
        public static class b {
            private b() {
            }

            @g.u
            public static int a(RemoteInput remoteInput) {
                return remoteInput.getEditChoicesBeforeSending();
            }
        }

        @Deprecated
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String[] f27807a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final h0 f27808b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f27809c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final PendingIntent f27810d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final String[] f27811e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final long f27812f;

            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final List<String> f27813a = new ArrayList();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final String f27814b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public h0 f27815c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public PendingIntent f27816d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public PendingIntent f27817e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public long f27818f;

                public a(@n0 String str) {
                    this.f27814b = str;
                }

                @n0
                public a a(@p0 String str) {
                    if (str != null) {
                        this.f27813a.add(str);
                    }
                    return this;
                }

                @n0
                public c b() {
                    List<String> list = this.f27813a;
                    return new c((String[]) list.toArray(new String[list.size()]), this.f27815c, this.f27817e, this.f27816d, new String[]{this.f27814b}, this.f27818f);
                }

                @n0
                public a c(long j10) {
                    this.f27818f = j10;
                    return this;
                }

                @n0
                public a d(@p0 PendingIntent pendingIntent) {
                    this.f27816d = pendingIntent;
                    return this;
                }

                @n0
                public a e(@p0 PendingIntent pendingIntent, @p0 h0 h0Var) {
                    this.f27815c = h0Var;
                    this.f27817e = pendingIntent;
                    return this;
                }
            }

            public c(@p0 String[] strArr, @p0 h0 h0Var, @p0 PendingIntent pendingIntent, @p0 PendingIntent pendingIntent2, @p0 String[] strArr2, long j10) {
                this.f27807a = strArr;
                this.f27808b = h0Var;
                this.f27810d = pendingIntent2;
                this.f27809c = pendingIntent;
                this.f27811e = strArr2;
                this.f27812f = j10;
            }

            public long a() {
                return this.f27812f;
            }

            @p0
            public String[] b() {
                return this.f27807a;
            }

            @p0
            public String c() {
                String[] strArr = this.f27811e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @p0
            public String[] d() {
                return this.f27811e;
            }

            @p0
            public PendingIntent e() {
                return this.f27810d;
            }

            @p0
            public h0 f() {
                return this.f27808b;
            }

            @p0
            public PendingIntent g() {
                return this.f27809c;
            }
        }

        public p() {
            this.f27806c = 0;
        }

        @v0(21)
        public static Bundle b(@n0 c cVar) {
            Bundle bundle = new Bundle();
            String str = (cVar.d() == null || cVar.d().length <= 1) ? null : cVar.d()[0];
            int length = cVar.b().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i10 = 0; i10 < length; i10++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", cVar.b()[i10]);
                bundle2.putString("author", str);
                parcelableArr[i10] = bundle2;
            }
            bundle.putParcelableArray(f27798k, parcelableArr);
            h0 h0VarF = cVar.f();
            if (h0VarF != null) {
                RemoteInput.Builder builderC = a.c(h0VarF.o());
                a.k(builderC, h0VarF.n());
                a.j(builderC, h0VarF.h());
                a.i(builderC, h0VarF.f());
                a.a(builderC, h0VarF.m());
                bundle.putParcelable(f27799l, a.b(builderC));
            }
            bundle.putParcelable(f27800m, cVar.g());
            bundle.putParcelable(f27801n, cVar.e());
            bundle.putStringArray(f27802o, cVar.d());
            bundle.putLong("timestamp", cVar.a());
            return bundle;
        }

        @v0(21)
        public static c f(@p0 Bundle bundle) {
            String[] strArr;
            boolean z10;
            if (bundle == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(f27798k);
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                String[] strArr2 = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    if (parcelableArray[i10] instanceof Bundle) {
                        strArr2[i10] = ((Bundle) parcelableArray[i10]).getString("text");
                        if (strArr2[i10] != null) {
                        }
                    }
                    z10 = false;
                    break;
                }
                z10 = true;
                if (!z10) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(f27801n);
            PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable(f27800m);
            RemoteInput remoteInput = (RemoteInput) bundle.getParcelable(f27799l);
            String[] stringArray = bundle.getStringArray(f27802o);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            return new c(strArr, remoteInput != null ? new h0(a.h(remoteInput), a.g(remoteInput), a.e(remoteInput), a.d(remoteInput), Build.VERSION.SDK_INT >= 29 ? b.a(remoteInput) : 0, a.f(remoteInput), null) : null, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
        }

        @Override // f0.v.r
        @n0
        public n a(@n0 n nVar) {
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f27804a;
            if (bitmap != null) {
                bundle.putParcelable(f27792e, bitmap);
            }
            int i10 = this.f27806c;
            if (i10 != 0) {
                bundle.putInt(f27794g, i10);
            }
            c cVar = this.f27805b;
            if (cVar != null) {
                bundle.putBundle(f27793f, b(cVar));
            }
            nVar.t().putBundle(f27791d, bundle);
            return nVar;
        }

        @g.l
        public int c() {
            return this.f27806c;
        }

        @p0
        public Bitmap d() {
            return this.f27804a;
        }

        @p0
        @Deprecated
        public c e() {
            return this.f27805b;
        }

        @n0
        public p g(@g.l int i10) {
            this.f27806c = i10;
            return this;
        }

        @n0
        public p h(@p0 Bitmap bitmap) {
            this.f27804a = bitmap;
            return this;
        }

        @n0
        @Deprecated
        public p i(@p0 c cVar) {
            this.f27805b = cVar;
            return this;
        }

        public p(@n0 Notification notification) {
            this.f27806c = 0;
            Bundle bundle = v.n(notification) == null ? null : v.n(notification).getBundle(f27791d);
            if (bundle != null) {
                this.f27804a = (Bitmap) bundle.getParcelable(f27792e);
                this.f27806c = bundle.getInt(f27794g, 0);
                this.f27805b = f(bundle.getBundle(f27793f));
            }
        }
    }

    public static class t extends y {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f27821f = "androidx.core.app.NotificationCompat$InboxStyle";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList<CharSequence> f27822e = new ArrayList<>();

        @v0(16)
        public static class a {
            private a() {
            }

            @g.u
            public static Notification.InboxStyle a(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.addLine(charSequence);
            }

            @g.u
            public static Notification.InboxStyle b(Notification.Builder builder) {
                return new Notification.InboxStyle(builder);
            }

            @g.u
            public static Notification.InboxStyle c(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.setBigContentTitle(charSequence);
            }

            @g.u
            public static Notification.InboxStyle d(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.setSummaryText(charSequence);
            }
        }

        public t() {
        }

        @n0
        public t A(@p0 CharSequence charSequence) {
            if (charSequence != null) {
                this.f27822e.add(n.A(charSequence));
            }
            return this;
        }

        @n0
        public t B(@p0 CharSequence charSequence) {
            this.f27845b = n.A(charSequence);
            return this;
        }

        @n0
        public t C(@p0 CharSequence charSequence) {
            this.f27846c = n.A(charSequence);
            this.f27847d = true;
            return this;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
            Notification.InboxStyle inboxStyleC = a.c(a.b(sVar.a()), this.f27845b);
            if (this.f27847d) {
                a.d(inboxStyleC, this.f27846c);
            }
            Iterator<CharSequence> it2 = this.f27822e.iterator();
            while (it2.hasNext()) {
                a.a(inboxStyleC, it2.next());
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@n0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(v.X);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public String t() {
            return f27821f;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@n0 Bundle bundle) {
            super.y(bundle);
            this.f27822e.clear();
            if (bundle.containsKey(v.X)) {
                Collections.addAll(this.f27822e, bundle.getCharSequenceArray(v.X));
            }
        }

        public t(@p0 n nVar) {
            z(nVar);
        }
    }

    public static class u extends y {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f27823j = "androidx.core.app.NotificationCompat$MessagingStyle";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f27824k = 25;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<e> f27825e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<e> f27826f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public f0 f27827g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public CharSequence f27828h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public Boolean f27829i;

        @v0(16)
        public static class a {
            private a() {
            }

            @g.u
            public static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            @g.u
            public static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            @g.u
            public static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            @g.u
            public static void d(Notification.Style style, Notification.Builder builder) {
                style.setBuilder(builder);
            }
        }

        @v0(24)
        public static class b {
            private b() {
            }

            @g.u
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            @g.u
            public static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            @g.u
            public static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        @v0(26)
        public static class c {
            private c() {
            }

            @g.u
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        @v0(28)
        public static class d {
            private d() {
            }

            @g.u
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            @g.u
            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z10) {
                return messagingStyle.setGroupConversation(z10);
            }
        }

        public u() {
        }

        @p0
        public static u E(@n0 Notification notification) {
            y yVarS = y.s(notification);
            if (yVarS instanceof u) {
                return (u) yVarS;
            }
            return null;
        }

        @n0
        public u A(@p0 e eVar) {
            if (eVar != null) {
                this.f27826f.add(eVar);
                if (this.f27826f.size() > 25) {
                    this.f27826f.remove(0);
                }
            }
            return this;
        }

        @n0
        public u B(@p0 e eVar) {
            if (eVar != null) {
                this.f27825e.add(eVar);
                if (this.f27825e.size() > 25) {
                    this.f27825e.remove(0);
                }
            }
            return this;
        }

        @n0
        public u C(@p0 CharSequence charSequence, long j10, @p0 f0 f0Var) {
            B(new e(charSequence, j10, f0Var));
            return this;
        }

        @n0
        @Deprecated
        public u D(@p0 CharSequence charSequence, long j10, @p0 CharSequence charSequence2) {
            this.f27825e.add(new e(charSequence, j10, new f0.c().f(charSequence2).a()));
            if (this.f27825e.size() > 25) {
                this.f27825e.remove(0);
            }
            return this;
        }

        @p0
        public final e F() {
            for (int size = this.f27825e.size() - 1; size >= 0; size--) {
                e eVar = this.f27825e.get(size);
                if (eVar.g() != null && !TextUtils.isEmpty(eVar.g().f())) {
                    return eVar;
                }
            }
            if (this.f27825e.isEmpty()) {
                return null;
            }
            return this.f27825e.get(r0.size() - 1);
        }

        @p0
        public CharSequence G() {
            return this.f27828h;
        }

        @n0
        public List<e> H() {
            return this.f27826f;
        }

        @n0
        public List<e> I() {
            return this.f27825e;
        }

        @n0
        public f0 J() {
            return this.f27827g;
        }

        @p0
        @Deprecated
        public CharSequence K() {
            return this.f27827g.f();
        }

        public final boolean L() {
            for (int size = this.f27825e.size() - 1; size >= 0; size--) {
                e eVar = this.f27825e.get(size);
                if (eVar.g() != null && eVar.g().f() == null) {
                    return true;
                }
            }
            return false;
        }

        public boolean M() {
            n nVar = this.f27844a;
            if (nVar != null && nVar.f27749a.getApplicationInfo().targetSdkVersion < 28 && this.f27829i == null) {
                return this.f27828h != null;
            }
            Boolean bool = this.f27829i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @n0
        public final TextAppearanceSpan N(int i10) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i10), null);
        }

        public final CharSequence O(@n0 e eVar) {
            y0.a aVarC = y0.a.c();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int iR = -16777216;
            CharSequence charSequenceF = eVar.g() == null ? "" : eVar.g().f();
            if (TextUtils.isEmpty(charSequenceF)) {
                charSequenceF = this.f27827g.f();
                if (this.f27844a.r() != 0) {
                    iR = this.f27844a.r();
                }
            }
            CharSequence charSequenceM = aVarC.m(charSequenceF);
            spannableStringBuilder.append(charSequenceM);
            spannableStringBuilder.setSpan(N(iR), spannableStringBuilder.length() - charSequenceM.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) GlideException.a.f12263d).append(aVarC.m(eVar.i() != null ? eVar.i() : ""));
            return spannableStringBuilder;
        }

        @n0
        public u P(@p0 CharSequence charSequence) {
            this.f27828h = charSequence;
            return this;
        }

        @n0
        public u Q(boolean z10) {
            this.f27829i = Boolean.valueOf(z10);
            return this;
        }

        @Override // f0.v.y
        public void a(@n0 Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence(v.f27633f0, this.f27827g.f());
            bundle.putBundle(v.f27636g0, this.f27827g.m());
            bundle.putCharSequence(v.f27672x0, this.f27828h);
            if (this.f27828h != null && this.f27829i.booleanValue()) {
                bundle.putCharSequence(v.f27639h0, this.f27828h);
            }
            if (!this.f27825e.isEmpty()) {
                bundle.putParcelableArray(v.f27642i0, e.a(this.f27825e));
            }
            if (!this.f27826f.isEmpty()) {
                bundle.putParcelableArray(v.f27644j0, e.a(this.f27826f));
            }
            Boolean bool = this.f27829i;
            if (bool != null) {
                bundle.putBoolean(v.f27646k0, bool.booleanValue());
            }
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void b(f0.s sVar) {
            Q(M());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                Notification.MessagingStyle messagingStyleA = i10 >= 28 ? d.a(this.f27827g.k()) : b.b(this.f27827g.f());
                Iterator<e> it2 = this.f27825e.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, it2.next().l());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    Iterator<e> it3 = this.f27826f.iterator();
                    while (it3.hasNext()) {
                        c.a(messagingStyleA, it3.next().l());
                    }
                }
                if (this.f27829i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    b.c(messagingStyleA, this.f27828h);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    d.b(messagingStyleA, this.f27829i.booleanValue());
                }
                a.d(messagingStyleA, sVar.a());
                return;
            }
            e eVarF = F();
            if (this.f27828h != null && this.f27829i.booleanValue()) {
                sVar.a().setContentTitle(this.f27828h);
            } else if (eVarF != null) {
                sVar.a().setContentTitle("");
                if (eVarF.g() != null) {
                    sVar.a().setContentTitle(eVarF.g().f());
                }
            }
            if (eVarF != null) {
                sVar.a().setContentText(this.f27828h != null ? O(eVarF) : eVarF.i());
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z10 = this.f27828h != null || L();
            for (int size = this.f27825e.size() - 1; size >= 0; size--) {
                e eVar = this.f27825e.get(size);
                CharSequence charSequenceO = z10 ? O(eVar) : eVar.i();
                if (size != this.f27825e.size() - 1) {
                    spannableStringBuilder.insert(0, (CharSequence) "\n");
                }
                spannableStringBuilder.insert(0, charSequenceO);
            }
            a.a(a.c(a.b(sVar.a()), null), spannableStringBuilder);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void g(@n0 Bundle bundle) {
            super.g(bundle);
            bundle.remove(v.f27636g0);
            bundle.remove(v.f27633f0);
            bundle.remove(v.f27639h0);
            bundle.remove(v.f27672x0);
            bundle.remove(v.f27642i0);
            bundle.remove(v.f27644j0);
            bundle.remove(v.f27646k0);
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public String t() {
            return f27823j;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void y(@n0 Bundle bundle) {
            super.y(bundle);
            this.f27825e.clear();
            if (bundle.containsKey(v.f27636g0)) {
                this.f27827g = f0.b(bundle.getBundle(v.f27636g0));
            } else {
                this.f27827g = new f0.c().f(bundle.getString(v.f27633f0)).a();
            }
            CharSequence charSequence = bundle.getCharSequence(v.f27639h0);
            this.f27828h = charSequence;
            if (charSequence == null) {
                this.f27828h = bundle.getCharSequence(v.f27672x0);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(v.f27642i0);
            if (parcelableArray != null) {
                this.f27825e.addAll(e.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(v.f27644j0);
            if (parcelableArray2 != null) {
                this.f27826f.addAll(e.f(parcelableArray2));
            }
            if (bundle.containsKey(v.f27646k0)) {
                this.f27829i = Boolean.valueOf(bundle.getBoolean(v.f27646k0));
            }
        }

        @Deprecated
        public u(@n0 CharSequence charSequence) {
            this.f27827g = new f0.c().f(charSequence).a();
        }

        public static final class e {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final String f27830g = "text";

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final String f27831h = "time";

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final String f27832i = "sender";

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final String f27833j = "type";

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final String f27834k = "uri";

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final String f27835l = "extras";

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final String f27836m = "person";

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final String f27837n = "sender_person";

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharSequence f27838a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f27839b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @p0
            public final f0 f27840c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f27841d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @p0
            public String f27842e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @p0
            public Uri f27843f;

            @v0(24)
            public static class a {
                private a() {
                }

                @g.u
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j10, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j10, charSequence2);
                }

                @g.u
                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            @v0(28)
            public static class b {
                private b() {
                }

                @g.u
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j10, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j10, person);
                }
            }

            public e(@p0 CharSequence charSequence, long j10, @p0 f0 f0Var) {
                this.f27841d = new Bundle();
                this.f27838a = charSequence;
                this.f27839b = j10;
                this.f27840c = f0Var;
            }

            @n0
            public static Bundle[] a(@n0 List<e> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    bundleArr[i10] = list.get(i10).m();
                }
                return bundleArr;
            }

            @p0
            public static e e(@n0 Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        e eVar = new e(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.containsKey(f27836m) ? f0.b(bundle.getBundle(f27836m)) : (!bundle.containsKey(f27837n) || Build.VERSION.SDK_INT < 28) ? bundle.containsKey(f27832i) ? new f0.c().f(bundle.getCharSequence(f27832i)).a() : null : f0.a((Person) bundle.getParcelable(f27837n)));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            eVar.k(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey("extras")) {
                            eVar.d().putAll(bundle.getBundle("extras"));
                        }
                        return eVar;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @n0
            public static List<e> f(@n0 Parcelable[] parcelableArr) {
                e eVarE;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (int i10 = 0; i10 < parcelableArr.length; i10++) {
                    if ((parcelableArr[i10] instanceof Bundle) && (eVarE = e((Bundle) parcelableArr[i10])) != null) {
                        arrayList.add(eVarE);
                    }
                }
                return arrayList;
            }

            @p0
            public String b() {
                return this.f27842e;
            }

            @p0
            public Uri c() {
                return this.f27843f;
            }

            @n0
            public Bundle d() {
                return this.f27841d;
            }

            @p0
            public f0 g() {
                return this.f27840c;
            }

            @p0
            @Deprecated
            public CharSequence h() {
                f0 f0Var = this.f27840c;
                if (f0Var == null) {
                    return null;
                }
                return f0Var.f();
            }

            @p0
            public CharSequence i() {
                return this.f27838a;
            }

            public long j() {
                return this.f27839b;
            }

            @n0
            public e k(@p0 String str, @p0 Uri uri) {
                this.f27842e = str;
                this.f27843f = uri;
                return this;
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            @n0
            @v0(24)
            public Notification.MessagingStyle.Message l() {
                Notification.MessagingStyle.Message messageA;
                f0 f0VarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.a(i(), j(), f0VarG != null ? f0VarG.k() : null);
                } else {
                    messageA = a.a(i(), j(), f0VarG != null ? f0VarG.f() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            @n0
            public final Bundle m() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f27838a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f27839b);
                f0 f0Var = this.f27840c;
                if (f0Var != null) {
                    bundle.putCharSequence(f27832i, f0Var.f());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(f27837n, this.f27840c.k());
                    } else {
                        bundle.putBundle(f27836m, this.f27840c.m());
                    }
                }
                String str = this.f27842e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f27843f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f27841d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            @Deprecated
            public e(@p0 CharSequence charSequence, long j10, @p0 CharSequence charSequence2) {
                this(charSequence, j10, new f0.c().f(charSequence2).a());
            }
        }

        public u(@n0 f0 f0Var) {
            if (!TextUtils.isEmpty(f0Var.f())) {
                this.f27827g = f0Var;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }

    public static final class z implements r {
        public static final String A = "displayIntent";
        public static final String B = "pages";
        public static final String C = "background";
        public static final String D = "contentIcon";
        public static final String E = "contentIconGravity";
        public static final String F = "contentActionIndex";
        public static final String G = "customSizePreset";
        public static final String H = "customContentHeight";
        public static final String I = "gravity";
        public static final String J = "hintScreenTimeout";
        public static final String K = "dismissalId";
        public static final String L = "bridgeTag";
        public static final int M = 1;
        public static final int N = 2;
        public static final int O = 4;
        public static final int P = 8;
        public static final int Q = 16;
        public static final int R = 32;
        public static final int S = 64;
        public static final int T = 1;
        public static final int U = 8388613;
        public static final int V = 80;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f27848o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Deprecated
        public static final int f27849p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @Deprecated
        public static final int f27850q = 1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Deprecated
        public static final int f27851r = 2;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Deprecated
        public static final int f27852s = 3;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Deprecated
        public static final int f27853t = 4;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Deprecated
        public static final int f27854u = 5;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Deprecated
        public static final int f27855v = 0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Deprecated
        public static final int f27856w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f27857x = "android.wearable.EXTENSIONS";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f27858y = "actions";

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String f27859z = "flags";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<b> f27860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f27861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PendingIntent f27862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<Notification> f27863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f27864e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f27865f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f27866g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f27867h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f27868i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f27869j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f27870k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f27871l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f27872m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f27873n;

        @v0(20)
        public static class a {
            private a() {
            }

            @g.u
            public static Notification.Action.Builder a(Notification.Action.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @g.u
            public static Notification.Action.Builder b(Notification.Action.Builder builder, RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            @g.u
            public static Notification.Action c(Notification.Action.Builder builder) {
                return builder.build();
            }

            @g.u
            public static Notification.Action.Builder d(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i10, charSequence, pendingIntent);
            }

            @g.u
            public static b e(ArrayList<Parcelable> arrayList, int i10) {
                return v.b((Notification.Action) arrayList.get(i10));
            }
        }

        @v0(23)
        public static class b {
            private b() {
            }

            @g.u
            public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }
        }

        @v0(24)
        public static class c {
            private c() {
            }

            @g.u
            public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
                return builder.setAllowGeneratedReplies(z10);
            }
        }

        @v0(31)
        public static class d {
            private d() {
            }

            @g.u
            public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
                return builder.setAuthenticationRequired(z10);
            }
        }

        public z() {
            this.f27860a = new ArrayList<>();
            this.f27861b = 1;
            this.f27863d = new ArrayList<>();
            this.f27866g = 8388613;
            this.f27867h = -1;
            this.f27868i = 0;
            this.f27870k = 80;
        }

        @v0(20)
        public static Notification.Action i(b bVar) {
            Notification.Action.Builder builderD;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                IconCompat iconCompatF = bVar.f();
                builderD = b.a(iconCompatF == null ? null : iconCompatF.M(), bVar.j(), bVar.a());
            } else {
                IconCompat iconCompatF2 = bVar.f();
                builderD = a.d((iconCompatF2 == null || iconCompatF2.D() != 2) ? 0 : iconCompatF2.A(), bVar.j(), bVar.a());
            }
            Bundle bundle = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
            bundle.putBoolean(f0.y.f27891c, bVar.b());
            if (i10 >= 24) {
                c.a(builderD, bVar.b());
            }
            if (i10 >= 31) {
                d.a(builderD, bVar.k());
            }
            a.a(builderD, bundle);
            h0[] h0VarArrG = bVar.g();
            if (h0VarArrG != null) {
                for (RemoteInput remoteInput : h0.d(h0VarArrG)) {
                    a.b(builderD, remoteInput);
                }
            }
            return a.c(builderD);
        }

        @Deprecated
        public boolean A() {
            return (this.f27861b & 4) != 0;
        }

        @n0
        @Deprecated
        public List<Notification> B() {
            return this.f27863d;
        }

        public boolean C() {
            return (this.f27861b & 8) != 0;
        }

        @n0
        @Deprecated
        public z D(@p0 Bitmap bitmap) {
            this.f27864e = bitmap;
            return this;
        }

        @n0
        public z E(@p0 String str) {
            this.f27873n = str;
            return this;
        }

        @n0
        public z F(int i10) {
            this.f27867h = i10;
            return this;
        }

        @n0
        @Deprecated
        public z G(int i10) {
            this.f27865f = i10;
            return this;
        }

        @n0
        @Deprecated
        public z H(int i10) {
            this.f27866g = i10;
            return this;
        }

        @n0
        public z I(boolean z10) {
            N(1, z10);
            return this;
        }

        @n0
        @Deprecated
        public z J(int i10) {
            this.f27869j = i10;
            return this;
        }

        @n0
        @Deprecated
        public z K(int i10) {
            this.f27868i = i10;
            return this;
        }

        @n0
        public z L(@p0 String str) {
            this.f27872m = str;
            return this;
        }

        @n0
        @Deprecated
        public z M(@p0 PendingIntent pendingIntent) {
            this.f27862c = pendingIntent;
            return this;
        }

        public final void N(int i10, boolean z10) {
            if (z10) {
                this.f27861b = i10 | this.f27861b;
            } else {
                this.f27861b = (~i10) & this.f27861b;
            }
        }

        @n0
        @Deprecated
        public z O(int i10) {
            this.f27870k = i10;
            return this;
        }

        @n0
        @Deprecated
        public z P(boolean z10) {
            N(32, z10);
            return this;
        }

        @n0
        @Deprecated
        public z Q(boolean z10) {
            N(16, z10);
            return this;
        }

        @n0
        public z R(boolean z10) {
            N(64, z10);
            return this;
        }

        @n0
        @Deprecated
        public z S(boolean z10) {
            N(2, z10);
            return this;
        }

        @n0
        @Deprecated
        public z T(int i10) {
            this.f27871l = i10;
            return this;
        }

        @n0
        @Deprecated
        public z U(boolean z10) {
            N(4, z10);
            return this;
        }

        @n0
        public z V(boolean z10) {
            N(8, z10);
            return this;
        }

        @Override // f0.v.r
        @n0
        public n a(@n0 n nVar) {
            Bundle bundle = new Bundle();
            if (!this.f27860a.isEmpty()) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f27860a.size());
                Iterator<b> it2 = this.f27860a.iterator();
                while (it2.hasNext()) {
                    arrayList.add(i(it2.next()));
                }
                bundle.putParcelableArrayList(f27858y, arrayList);
            }
            int i10 = this.f27861b;
            if (i10 != 1) {
                bundle.putInt("flags", i10);
            }
            PendingIntent pendingIntent = this.f27862c;
            if (pendingIntent != null) {
                bundle.putParcelable(A, pendingIntent);
            }
            if (!this.f27863d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.f27863d;
                bundle.putParcelableArray("pages", (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.f27864e;
            if (bitmap != null) {
                bundle.putParcelable(C, bitmap);
            }
            int i11 = this.f27865f;
            if (i11 != 0) {
                bundle.putInt(D, i11);
            }
            int i12 = this.f27866g;
            if (i12 != 8388613) {
                bundle.putInt(E, i12);
            }
            int i13 = this.f27867h;
            if (i13 != -1) {
                bundle.putInt(F, i13);
            }
            int i14 = this.f27868i;
            if (i14 != 0) {
                bundle.putInt(G, i14);
            }
            int i15 = this.f27869j;
            if (i15 != 0) {
                bundle.putInt(H, i15);
            }
            int i16 = this.f27870k;
            if (i16 != 80) {
                bundle.putInt(I, i16);
            }
            int i17 = this.f27871l;
            if (i17 != 0) {
                bundle.putInt(J, i17);
            }
            String str = this.f27872m;
            if (str != null) {
                bundle.putString(K, str);
            }
            String str2 = this.f27873n;
            if (str2 != null) {
                bundle.putString(L, str2);
            }
            nVar.t().putBundle("android.wearable.EXTENSIONS", bundle);
            return nVar;
        }

        @n0
        public z b(@n0 b bVar) {
            this.f27860a.add(bVar);
            return this;
        }

        @n0
        public z c(@n0 List<b> list) {
            this.f27860a.addAll(list);
            return this;
        }

        @n0
        @Deprecated
        public z d(@n0 Notification notification) {
            this.f27863d.add(notification);
            return this;
        }

        @n0
        @Deprecated
        public z e(@n0 List<Notification> list) {
            this.f27863d.addAll(list);
            return this;
        }

        @n0
        public z f() {
            this.f27860a.clear();
            return this;
        }

        @n0
        @Deprecated
        public z g() {
            this.f27863d.clear();
            return this;
        }

        @n0
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public z clone() {
            z zVar = new z();
            zVar.f27860a = new ArrayList<>(this.f27860a);
            zVar.f27861b = this.f27861b;
            zVar.f27862c = this.f27862c;
            zVar.f27863d = new ArrayList<>(this.f27863d);
            zVar.f27864e = this.f27864e;
            zVar.f27865f = this.f27865f;
            zVar.f27866g = this.f27866g;
            zVar.f27867h = this.f27867h;
            zVar.f27868i = this.f27868i;
            zVar.f27869j = this.f27869j;
            zVar.f27870k = this.f27870k;
            zVar.f27871l = this.f27871l;
            zVar.f27872m = this.f27872m;
            zVar.f27873n = this.f27873n;
            return zVar;
        }

        @n0
        public List<b> j() {
            return this.f27860a;
        }

        @p0
        @Deprecated
        public Bitmap k() {
            return this.f27864e;
        }

        @p0
        public String l() {
            return this.f27873n;
        }

        public int m() {
            return this.f27867h;
        }

        @Deprecated
        public int n() {
            return this.f27865f;
        }

        @Deprecated
        public int o() {
            return this.f27866g;
        }

        public boolean p() {
            return (this.f27861b & 1) != 0;
        }

        @Deprecated
        public int q() {
            return this.f27869j;
        }

        @Deprecated
        public int r() {
            return this.f27868i;
        }

        @p0
        public String s() {
            return this.f27872m;
        }

        @p0
        @Deprecated
        public PendingIntent t() {
            return this.f27862c;
        }

        @Deprecated
        public int u() {
            return this.f27870k;
        }

        @Deprecated
        public boolean v() {
            return (this.f27861b & 32) != 0;
        }

        @Deprecated
        public boolean w() {
            return (this.f27861b & 16) != 0;
        }

        public boolean x() {
            return (this.f27861b & 64) != 0;
        }

        @Deprecated
        public boolean y() {
            return (this.f27861b & 2) != 0;
        }

        @Deprecated
        public int z() {
            return this.f27871l;
        }

        public z(@n0 Notification notification) {
            this.f27860a = new ArrayList<>();
            this.f27861b = 1;
            this.f27863d = new ArrayList<>();
            this.f27866g = 8388613;
            this.f27867h = -1;
            this.f27868i = 0;
            this.f27870k = 80;
            Bundle bundleN = v.n(notification);
            Bundle bundle = bundleN != null ? bundleN.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(f27858y);
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    b[] bVarArr = new b[size];
                    for (int i10 = 0; i10 < size; i10++) {
                        bVarArr[i10] = a.e(parcelableArrayList, i10);
                    }
                    Collections.addAll(this.f27860a, bVarArr);
                }
                this.f27861b = bundle.getInt("flags", 1);
                this.f27862c = (PendingIntent) bundle.getParcelable(A);
                Notification[] notificationArrU = v.u(bundle, "pages");
                if (notificationArrU != null) {
                    Collections.addAll(this.f27863d, notificationArrU);
                }
                this.f27864e = (Bitmap) bundle.getParcelable(C);
                this.f27865f = bundle.getInt(D);
                this.f27866g = bundle.getInt(E, 8388613);
                this.f27867h = bundle.getInt(F, -1);
                this.f27868i = bundle.getInt(G, 0);
                this.f27869j = bundle.getInt(H);
                this.f27870k = bundle.getInt(I, 80);
                this.f27871l = bundle.getInt(J);
                this.f27872m = bundle.getString(K);
                this.f27873n = bundle.getString(L);
            }
        }
    }

    public static class n {
        public static final int Y = 5120;
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public h0.c0 O;
        public long P;
        public int Q;
        public int R;
        public boolean S;
        public m T;
        public Notification U;
        public boolean V;
        public Object W;

        @Deprecated
        public ArrayList<String> X;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context f27749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<b> f27750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public ArrayList<f0> f27751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<b> f27752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f27753e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f27754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f27755g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f27756h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f27757i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Bitmap f27758j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f27759k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f27760l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f27761m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f27762n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f27763o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f27764p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public y f27765q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f27766r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f27767s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f27768t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f27769u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f27770v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f27771w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f27772x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f27773y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f27774z;

        @v0(21)
        public static class a {
            private a() {
            }

            @g.u
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            @g.u
            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            @g.u
            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i10) {
                return builder.setContentType(i10);
            }

            @g.u
            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i10) {
                return builder.setLegacyStreamType(i10);
            }

            @g.u
            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i10) {
                return builder.setUsage(i10);
            }
        }

        @v0(23)
        public static class b {
            private b() {
            }

            @g.u
            public static Icon a(Notification notification) {
                return notification.getSmallIcon();
            }
        }

        @v0(24)
        public static class c {
            private c() {
            }

            @g.u
            public static RemoteViews a(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @g.u
            public static RemoteViews b(Notification.Builder builder) {
                return builder.createContentView();
            }

            @g.u
            public static RemoteViews c(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @g.u
            public static Notification.Builder d(Context context, Notification notification) {
                return Notification.Builder.recoverBuilder(context, notification);
            }
        }

        @v0(19)
        public n(@n0 Context context, @n0 Notification notification) {
            ArrayList parcelableArrayList;
            this(context, v.i(notification));
            Bundle bundle = notification.extras;
            y yVarS = y.s(notification);
            P(v.m(notification)).O(v.l(notification)).M(v.k(notification)).A0(v.D(notification)).o0(v.z(notification)).z0(yVarS).N(notification.contentIntent).Z(v.o(notification)).b0(v.H(notification)).f0(v.t(notification)).H0(notification.when).r0(v.B(notification)).E0(v.F(notification)).D(v.e(notification)).j0(v.w(notification)).i0(v.v(notification)).e0(v.s(notification)).c0(notification.largeIcon).E(v.f(notification)).G(v.h(notification)).F(v.g(notification)).h0(notification.number).B0(notification.tickerText).N(notification.contentIntent).U(notification.deleteIntent).Y(notification.fullScreenIntent, v.q(notification)).y0(notification.sound, notification.audioStreamType).F0(notification.vibrate).d0(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).T(notification.defaults).k0(notification.priority).J(v.j(notification)).G0(v.G(notification)).m0(v.y(notification)).w0(v.C(notification)).D0(v.E(notification)).p0(v.A(notification)).l0(bundle.getInt(v.N), bundle.getInt(v.M), bundle.getBoolean(v.O)).C(v.d(notification)).u0(notification.icon, notification.iconLevel).c(u(notification, yVarS));
            if (Build.VERSION.SDK_INT >= 23) {
                this.W = b.a(notification);
            }
            Notification.Action[] actionArr = notification.actions;
            if (actionArr != null && actionArr.length != 0) {
                for (Notification.Action action : actionArr) {
                    b(b.a.f(action).c());
                }
            }
            List<b> listR = v.r(notification);
            if (!listR.isEmpty()) {
                Iterator<b> it2 = listR.iterator();
                while (it2.hasNext()) {
                    e(it2.next());
                }
            }
            String[] stringArray = notification.extras.getStringArray(v.f27618a0);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    g(str);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(v.f27621b0)) != null && !parcelableArrayList.isEmpty()) {
                Iterator it3 = parcelableArrayList.iterator();
                while (it3.hasNext()) {
                    f(f0.a((Person) it3.next()));
                }
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24 && bundle.containsKey(v.Q)) {
                I(bundle.getBoolean(v.Q));
            }
            if (i10 < 26 || !bundle.containsKey(v.R)) {
                return;
            }
            K(bundle.getBoolean(v.R));
        }

        @p0
        public static CharSequence A(@p0 CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, Y) : charSequence;
        }

        @p0
        @v0(19)
        public static Bundle u(@n0 Notification notification, @p0 y yVar) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove(v.B);
            bundle.remove(v.D);
            bundle.remove(v.G);
            bundle.remove(v.E);
            bundle.remove(v.f27623c);
            bundle.remove(v.f27626d);
            bundle.remove(v.S);
            bundle.remove(v.M);
            bundle.remove(v.N);
            bundle.remove(v.O);
            bundle.remove(v.Q);
            bundle.remove(v.R);
            bundle.remove(v.f27621b0);
            bundle.remove(v.f27618a0);
            bundle.remove(f0.x.f27886d);
            bundle.remove(f0.x.f27884b);
            bundle.remove(f0.x.f27885c);
            bundle.remove(f0.x.f27883a);
            bundle.remove(f0.x.f27887e);
            Bundle bundle2 = bundle.getBundle(p.f27791d);
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove(p.f27795h);
                bundle.putBundle(p.f27791d, bundle3);
            }
            if (yVar != null) {
                yVar.g(bundle);
            }
            return bundle;
        }

        @n0
        public n A0(@p0 CharSequence charSequence) {
            this.f27766r = A(charSequence);
            return this;
        }

        @p0
        public final Bitmap B(@p0 Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f27749a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
        }

        @n0
        public n B0(@p0 CharSequence charSequence) {
            this.U.tickerText = A(charSequence);
            return this;
        }

        @n0
        public n C(boolean z10) {
            this.S = z10;
            return this;
        }

        @n0
        @Deprecated
        public n C0(@p0 CharSequence charSequence, @p0 RemoteViews remoteViews) {
            this.U.tickerText = A(charSequence);
            this.f27757i = remoteViews;
            return this;
        }

        @n0
        public n D(boolean z10) {
            W(16, z10);
            return this;
        }

        @n0
        public n D0(long j10) {
            this.P = j10;
            return this;
        }

        @n0
        public n E(int i10) {
            this.M = i10;
            return this;
        }

        @n0
        public n E0(boolean z10) {
            this.f27763o = z10;
            return this;
        }

        @n0
        public n F(@p0 m mVar) {
            this.T = mVar;
            return this;
        }

        @n0
        public n F0(@p0 long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        @n0
        public n G(@p0 String str) {
            this.D = str;
            return this;
        }

        @n0
        public n G0(int i10) {
            this.G = i10;
            return this;
        }

        @n0
        public n H(@n0 String str) {
            this.L = str;
            return this;
        }

        @n0
        public n H0(long j10) {
            this.U.when = j10;
            return this;
        }

        @n0
        @v0(24)
        public n I(boolean z10) {
            this.f27764p = z10;
            t().putBoolean(v.Q, z10);
            return this;
        }

        public final boolean I0() {
            y yVar = this.f27765q;
            return yVar == null || !yVar.r();
        }

        @n0
        public n J(@g.l int i10) {
            this.F = i10;
            return this;
        }

        @n0
        public n K(boolean z10) {
            this.B = z10;
            this.C = true;
            return this;
        }

        @n0
        public n L(@p0 RemoteViews remoteViews) {
            this.U.contentView = remoteViews;
            return this;
        }

        @n0
        public n M(@p0 CharSequence charSequence) {
            this.f27759k = A(charSequence);
            return this;
        }

        @n0
        public n N(@p0 PendingIntent pendingIntent) {
            this.f27755g = pendingIntent;
            return this;
        }

        @n0
        public n O(@p0 CharSequence charSequence) {
            this.f27754f = A(charSequence);
            return this;
        }

        @n0
        public n P(@p0 CharSequence charSequence) {
            this.f27753e = A(charSequence);
            return this;
        }

        @n0
        public n Q(@p0 RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        @n0
        public n R(@p0 RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        @n0
        public n S(@p0 RemoteViews remoteViews) {
            this.K = remoteViews;
            return this;
        }

        @n0
        public n T(int i10) {
            Notification notification = this.U;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @n0
        public n U(@p0 PendingIntent pendingIntent) {
            this.U.deleteIntent = pendingIntent;
            return this;
        }

        @n0
        public n V(@p0 Bundle bundle) {
            this.E = bundle;
            return this;
        }

        public final void W(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.U;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.U;
                notification2.flags = (~i10) & notification2.flags;
            }
        }

        @n0
        public n X(int i10) {
            this.R = i10;
            return this;
        }

        @n0
        public n Y(@p0 PendingIntent pendingIntent, boolean z10) {
            this.f27756h = pendingIntent;
            W(128, z10);
            return this;
        }

        @n0
        public n Z(@p0 String str) {
            this.f27772x = str;
            return this;
        }

        @n0
        public n a(int i10, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent) {
            this.f27750b.add(new b(i10, charSequence, pendingIntent));
            return this;
        }

        @n0
        public n a0(int i10) {
            this.Q = i10;
            return this;
        }

        @n0
        public n b(@p0 b bVar) {
            if (bVar != null) {
                this.f27750b.add(bVar);
            }
            return this;
        }

        @n0
        public n b0(boolean z10) {
            this.f27773y = z10;
            return this;
        }

        @n0
        public n c(@p0 Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.E;
                if (bundle2 == null) {
                    this.E = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @n0
        public n c0(@p0 Bitmap bitmap) {
            this.f27758j = B(bitmap);
            return this;
        }

        @n0
        @v0(21)
        public n d(int i10, @p0 CharSequence charSequence, @p0 PendingIntent pendingIntent) {
            this.f27752d.add(new b(i10, charSequence, pendingIntent));
            return this;
        }

        @n0
        public n d0(@g.l int i10, int i11, int i12) {
            Notification notification = this.U;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            notification.flags = ((i11 == 0 || i12 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        @n0
        @v0(21)
        public n e(@p0 b bVar) {
            if (bVar != null) {
                this.f27752d.add(bVar);
            }
            return this;
        }

        @n0
        public n e0(boolean z10) {
            this.A = z10;
            return this;
        }

        @n0
        public n f(@p0 f0 f0Var) {
            if (f0Var != null) {
                this.f27751c.add(f0Var);
            }
            return this;
        }

        @n0
        public n f0(@p0 h0.c0 c0Var) {
            this.O = c0Var;
            return this;
        }

        @n0
        @Deprecated
        public n g(@p0 String str) {
            if (str != null && !str.isEmpty()) {
                this.X.add(str);
            }
            return this;
        }

        @n0
        @Deprecated
        public n g0() {
            this.V = true;
            return this;
        }

        @n0
        public Notification h() {
            return new f0.w(this).c();
        }

        @n0
        public n h0(int i10) {
            this.f27760l = i10;
            return this;
        }

        @n0
        public n i() {
            this.f27750b.clear();
            return this;
        }

        @n0
        public n i0(boolean z10) {
            W(2, z10);
            return this;
        }

        @n0
        public n j() {
            this.f27752d.clear();
            Bundle bundle = this.E.getBundle(p.f27791d);
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove(p.f27795h);
                this.E.putBundle(p.f27791d, bundle2);
            }
            return this;
        }

        @n0
        public n j0(boolean z10) {
            W(8, z10);
            return this;
        }

        @n0
        public n k() {
            this.f27751c.clear();
            this.X.clear();
            return this;
        }

        @n0
        public n k0(int i10) {
            this.f27761m = i10;
            return this;
        }

        @p0
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews l() {
            RemoteViews remoteViewsV;
            int i10 = Build.VERSION.SDK_INT;
            if (this.J != null && I0()) {
                return this.J;
            }
            f0.w wVar = new f0.w(this);
            y yVar = this.f27765q;
            if (yVar != null && (remoteViewsV = yVar.v(wVar)) != null) {
                return remoteViewsV;
            }
            Notification notificationC = wVar.c();
            return i10 >= 24 ? c.a(c.d(this.f27749a, notificationC)) : notificationC.bigContentView;
        }

        @n0
        public n l0(int i10, int i11, boolean z10) {
            this.f27769u = i10;
            this.f27770v = i11;
            this.f27771w = z10;
            return this;
        }

        @p0
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews m() {
            RemoteViews remoteViewsW;
            if (this.I != null && I0()) {
                return this.I;
            }
            f0.w wVar = new f0.w(this);
            y yVar = this.f27765q;
            if (yVar != null && (remoteViewsW = yVar.w(wVar)) != null) {
                return remoteViewsW;
            }
            Notification notificationC = wVar.c();
            return Build.VERSION.SDK_INT >= 24 ? c.b(c.d(this.f27749a, notificationC)) : notificationC.contentView;
        }

        @n0
        public n m0(@p0 Notification notification) {
            this.H = notification;
            return this;
        }

        @p0
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews n() {
            RemoteViews remoteViewsX;
            int i10 = Build.VERSION.SDK_INT;
            if (this.K != null && I0()) {
                return this.K;
            }
            f0.w wVar = new f0.w(this);
            y yVar = this.f27765q;
            if (yVar != null && (remoteViewsX = yVar.x(wVar)) != null) {
                return remoteViewsX;
            }
            Notification notificationC = wVar.c();
            return i10 >= 24 ? c.c(c.d(this.f27749a, notificationC)) : notificationC.headsUpContentView;
        }

        @n0
        public n n0(@p0 CharSequence[] charSequenceArr) {
            this.f27768t = charSequenceArr;
            return this;
        }

        @n0
        public n o(@n0 r rVar) {
            rVar.a(this);
            return this;
        }

        @n0
        public n o0(@p0 CharSequence charSequence) {
            this.f27767s = A(charSequence);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews p() {
            return this.J;
        }

        @n0
        public n p0(@p0 String str) {
            this.N = str;
            return this;
        }

        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public m q() {
            return this.T;
        }

        @n0
        public n q0(@p0 i0.e eVar) {
            if (eVar == null) {
                return this;
            }
            this.N = eVar.k();
            if (this.O == null) {
                if (eVar.o() != null) {
                    this.O = eVar.o();
                } else if (eVar.k() != null) {
                    this.O = new h0.c0(eVar.k());
                }
            }
            if (this.f27753e == null) {
                P(eVar.w());
            }
            return this;
        }

        @g.l
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int r() {
            return this.F;
        }

        @n0
        public n r0(boolean z10) {
            this.f27762n = z10;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews s() {
            return this.I;
        }

        @n0
        public n s0(boolean z10) {
            this.V = z10;
            return this;
        }

        @n0
        public Bundle t() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        @n0
        public n t0(int i10) {
            this.U.icon = i10;
            return this;
        }

        @n0
        public n u0(int i10, int i11) {
            Notification notification = this.U;
            notification.icon = i10;
            notification.iconLevel = i11;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int v() {
            return this.R;
        }

        @n0
        @v0(23)
        public n v0(@n0 IconCompat iconCompat) {
            this.W = iconCompat.N(this.f27749a);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews w() {
            return this.K;
        }

        @n0
        public n w0(@p0 String str) {
            this.f27774z = str;
            return this;
        }

        @n0
        @Deprecated
        public Notification x() {
            return h();
        }

        @n0
        public n x0(@p0 Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.U.audioAttributes = a.a(builderE);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int y() {
            return this.f27761m;
        }

        @n0
        public n y0(@p0 Uri uri, int i10) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = i10;
            AudioAttributes.Builder builderD = a.d(a.c(a.b(), 4), i10);
            this.U.audioAttributes = a.a(builderD);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long z() {
            if (this.f27762n) {
                return this.U.when;
            }
            return 0L;
        }

        @n0
        public n z0(@p0 y yVar) {
            if (this.f27765q != yVar) {
                this.f27765q = yVar;
                if (yVar != null) {
                    yVar.z(this);
                }
            }
            return this;
        }

        public n(@n0 Context context, @n0 String str) {
            this.f27750b = new ArrayList<>();
            this.f27751c = new ArrayList<>();
            this.f27752d = new ArrayList<>();
            this.f27762n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f27749a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.f27761m = 0;
            this.X = new ArrayList<>();
            this.S = true;
        }

        @Deprecated
        public n(@n0 Context context) {
            this(context, (String) null);
        }
    }
}
