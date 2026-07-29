package v1;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import java.util.List;
import t1.d;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52550a = "MediaButtonReceiver";

    /* JADX INFO: renamed from: v1.a$a, reason: collision with other inner class name */
    public static class C0611a extends MediaBrowserCompat.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f52551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Intent f52552d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f52553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public MediaBrowserCompat f52554f;

        public C0611a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f52551c = context;
            this.f52552d = intent;
            this.f52553e = pendingResult;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void a() {
            new MediaControllerCompat(this.f52551c, this.f52554f.h()).d((KeyEvent) this.f52552d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void b() {
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void c() {
            e();
        }

        public final void e() {
            this.f52554f.b();
            this.f52553e.finish();
        }

        public void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f52554f = mediaBrowserCompat;
        }
    }

    public static PendingIntent a(Context context, long j10) {
        ComponentName componentNameC = c(context);
        if (componentNameC == null) {
            return null;
        }
        return b(context, componentNameC, j10);
    }

    public static PendingIntent b(Context context, ComponentName componentName, long j10) {
        if (componentName == null) {
            return null;
        }
        int iW = PlaybackStateCompat.W(j10);
        if (iW == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot build a media button pending intent with the given action: ");
            sb2.append(j10);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, iW));
        return PendingIntent.getBroadcast(context, iW, intent, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName c(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        listQueryBroadcastReceivers.size();
        return null;
    }

    public static ComponentName d(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + listQueryIntentServices.size());
    }

    public static KeyEvent e(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (mediaSessionCompat == null || intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaSessionCompat.f().d(keyEvent);
        return keyEvent;
    }

    public static void f(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignore unsupported intent: ");
            sb2.append(intent);
            return;
        }
        ComponentName componentNameD = d(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameD != null) {
            intent.setComponent(componentNameD);
            f(context, intent);
            return;
        }
        ComponentName componentNameD2 = d(context, d.f50699k);
        if (componentNameD2 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        C0611a c0611a = new C0611a(applicationContext, intent, pendingResultGoAsync);
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameD2, c0611a, null);
        c0611a.f(mediaBrowserCompat);
        mediaBrowserCompat.a();
    }
}
