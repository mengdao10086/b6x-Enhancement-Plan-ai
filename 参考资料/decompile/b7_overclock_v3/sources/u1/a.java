package u1;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.media.R;
import f0.s;
import f0.v;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    public static class C0595a extends b {
        @Override // u1.a.b
        public int E(int i10) {
            return i10 <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        @Override // u1.a.b
        public int F() {
            return this.f27844a.s() != null ? R.layout.notification_template_media_custom : super.F();
        }

        public final void L(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", this.f27844a.r() != 0 ? this.f27844a.r() : this.f27844a.f27749a.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @Override // u1.a.b, f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void b(s sVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                sVar.a().setStyle(A(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.b(sVar);
            }
        }

        @Override // u1.a.b, f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews v(s sVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsP = this.f27844a.p() != null ? this.f27844a.p() : this.f27844a.s();
            if (remoteViewsP == null) {
                return null;
            }
            RemoteViews remoteViewsB = B();
            e(remoteViewsB, remoteViewsP);
            L(remoteViewsB);
            return remoteViewsB;
        }

        @Override // u1.a.b, f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews w(s sVar) {
            RemoteViews remoteViewsC = null;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z10 = true;
            boolean z11 = this.f27844a.s() != null;
            if (!z11 && this.f27844a.p() == null) {
                z10 = false;
            }
            if (z10) {
                remoteViewsC = C();
                if (z11) {
                    e(remoteViewsC, this.f27844a.s());
                }
                L(remoteViewsC);
            }
            return remoteViewsC;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews x(s sVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViewsW = this.f27844a.w() != null ? this.f27844a.w() : this.f27844a.s();
            if (remoteViewsW == null) {
                return null;
            }
            RemoteViews remoteViewsB = B();
            e(remoteViewsB, remoteViewsW);
            L(remoteViewsB);
            return remoteViewsB;
        }
    }

    public static class b extends v.y {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f51796i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f51797j = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f51798e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public MediaSessionCompat.Token f51799f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f51800g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f51801h;

        public b() {
        }

        public static MediaSessionCompat.Token G(Notification notification) {
            Parcelable parcelable;
            Bundle bundleN = v.n(notification);
            if (bundleN == null || (parcelable = bundleN.getParcelable(v.f27627d0)) == null) {
                return null;
            }
            return MediaSessionCompat.Token.b(parcelable);
        }

        @v0(21)
        public Notification.MediaStyle A(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.f51798e;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f51799f;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.s());
            }
            return mediaStyle;
        }

        public RemoteViews B() {
            int iMin = Math.min(this.f27844a.f27750b.size(), 5);
            RemoteViews remoteViewsC = c(false, E(iMin), false);
            remoteViewsC.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i10 = 0; i10 < iMin; i10++) {
                    remoteViewsC.addView(R.id.media_actions, D(this.f27844a.f27750b.get(i10)));
                }
            }
            if (this.f51800g) {
                int i11 = R.id.cancel_action;
                remoteViewsC.setViewVisibility(i11, 0);
                remoteViewsC.setInt(i11, "setAlpha", this.f27844a.f27749a.getResources().getInteger(R.integer.cancel_button_image_alpha));
                remoteViewsC.setOnClickPendingIntent(i11, this.f51801h);
            } else {
                remoteViewsC.setViewVisibility(R.id.cancel_action, 8);
            }
            return remoteViewsC;
        }

        public RemoteViews C() {
            RemoteViews remoteViewsC = c(false, F(), true);
            int size = this.f27844a.f27750b.size();
            int[] iArr = this.f51798e;
            int iMin = iArr == null ? 0 : Math.min(iArr.length, 3);
            remoteViewsC.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i10 = 0; i10 < iMin; i10++) {
                    if (i10 >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i10), Integer.valueOf(size - 1)));
                    }
                    remoteViewsC.addView(R.id.media_actions, D(this.f27844a.f27750b.get(this.f51798e[i10])));
                }
            }
            if (this.f51800g) {
                remoteViewsC.setViewVisibility(R.id.end_padder, 8);
                int i11 = R.id.cancel_action;
                remoteViewsC.setViewVisibility(i11, 0);
                remoteViewsC.setOnClickPendingIntent(i11, this.f51801h);
                remoteViewsC.setInt(i11, "setAlpha", this.f27844a.f27749a.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                remoteViewsC.setViewVisibility(R.id.end_padder, 0);
                remoteViewsC.setViewVisibility(R.id.cancel_action, 8);
            }
            return remoteViewsC;
        }

        public final RemoteViews D(v.b bVar) {
            boolean z10 = bVar.a() == null;
            RemoteViews remoteViews = new RemoteViews(this.f27844a.f27749a.getPackageName(), R.layout.notification_media_action);
            int i10 = R.id.action0;
            remoteViews.setImageViewResource(i10, bVar.e());
            if (!z10) {
                remoteViews.setOnClickPendingIntent(i10, bVar.a());
            }
            remoteViews.setContentDescription(i10, bVar.j());
            return remoteViews;
        }

        public int E(int i10) {
            return i10 <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        public int F() {
            return R.layout.notification_template_media;
        }

        public b H(PendingIntent pendingIntent) {
            this.f51801h = pendingIntent;
            return this;
        }

        public b I(MediaSessionCompat.Token token) {
            this.f51799f = token;
            return this;
        }

        public b J(int... iArr) {
            this.f51798e = iArr;
            return this;
        }

        public b K(boolean z10) {
            return this;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void b(s sVar) {
            sVar.a().setStyle(A(new Notification.MediaStyle()));
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews v(s sVar) {
            return null;
        }

        @Override // f0.v.y
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews w(s sVar) {
            return null;
        }

        public b(v.n nVar) {
            z(nVar);
        }
    }
}
