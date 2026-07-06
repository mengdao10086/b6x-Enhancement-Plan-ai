package a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class va0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BatteryManager f3262a;
    public int b;

    public va0(Context context) {
        f92.d(context, "applicationContext");
        this.f3261a = context;
        this.b = 1;
    }

    public final void a() {
        Context context = this.f3261a;
        context.registerReceiver(this, new IntentFilter("android.intent.action.BOOT_COMPLETED"));
        context.registerReceiver(this, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
        context.registerReceiver(this, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
        context.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        context.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_LOW"));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008d A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fa A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0102 A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0121 A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012a A[Catch: all -> 0x0163, Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0158 A[Catch: all -> 0x0163, Exception -> 0x0168, TRY_LEAVE, TryCatch #2 {Exception -> 0x0168, all -> 0x0163, blocks: (B:5:0x0021, B:7:0x002d, B:19:0x0045, B:21:0x0051, B:23:0x0061, B:25:0x006f, B:26:0x0075, B:29:0x007e, B:35:0x008d, B:37:0x0091, B:39:0x009d, B:40:0x00a2, B:41:0x00a9, B:42:0x00aa, B:43:0x00b4, B:50:0x00dc, B:53:0x00e5, B:55:0x00e9, B:57:0x00fa, B:58:0x0102, B:60:0x0111, B:61:0x0119, B:63:0x0121, B:64:0x0126, B:74:0x0154, B:76:0x0158, B:65:0x012a, B:67:0x0132, B:68:0x0138, B:70:0x0140, B:71:0x0146, B:73:0x014e, B:47:0x00ce, B:30:0x0080, B:22:0x005b), top: B:84:0x0021 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r18, android.content.Intent r19) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.va0.onReceive(android.content.Context, android.content.Intent):void");
    }
}
