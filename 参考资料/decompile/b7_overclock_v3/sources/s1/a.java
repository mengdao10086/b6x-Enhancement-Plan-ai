package s1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import g.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f49402f = "LocalBroadcastManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f49403g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f49404h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f49405i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static a f49406j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f49407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f49408b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f49409c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f49410d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f49411e;

    /* JADX INFO: renamed from: s1.a$a, reason: collision with other inner class name */
    public class HandlerC0566a extends Handler {
        public HandlerC0566a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f49413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f49414b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f49413a = intent;
            this.f49414b = arrayList;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f49415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f49416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f49418d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f49415a = intentFilter;
            this.f49416b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f49416b);
            sb2.append(" filter=");
            sb2.append(this.f49415a);
            if (this.f49418d) {
                sb2.append(" DEAD");
            }
            sb2.append(zc.a.f58317e);
            return sb2.toString();
        }
    }

    public a(Context context) {
        this.f49407a = context;
        this.f49411e = new HandlerC0566a(context.getMainLooper());
    }

    @n0
    public static a b(@n0 Context context) {
        a aVar;
        synchronized (f49405i) {
            if (f49406j == null) {
                f49406j = new a(context.getApplicationContext());
            }
            aVar = f49406j;
        }
        return aVar;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f49408b) {
                size = this.f49410d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f49410d.toArray(bVarArr);
                this.f49410d.clear();
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f49414b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f49414b.get(i11);
                    if (!cVar.f49418d) {
                        cVar.f49416b.onReceive(this.f49407a, bVar.f49413a);
                    }
                }
            }
        }
    }

    public void c(@n0 BroadcastReceiver broadcastReceiver, @n0 IntentFilter intentFilter) {
        synchronized (this.f49408b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f49408b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f49408b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<c> arrayList2 = this.f49409c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f49409c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(@n0 Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f49408b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f49407a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resolving type ");
                sb2.append(strResolveTypeIfNeeded);
                sb2.append(" scheme ");
                sb2.append(scheme);
                sb2.append(" of intent ");
                sb2.append(intent);
            }
            ArrayList<c> arrayList3 = this.f49409c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Action list: ");
                    sb3.append(arrayList3);
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    c cVar = arrayList3.get(i11);
                    if (z10) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Matching against filter ");
                        sb4.append(cVar.f49415a);
                    }
                    if (cVar.f49417c) {
                        i10 = i11;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i10 = i11;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = cVar.f49415a.match(action, strResolveTypeIfNeeded, scheme, data, categories, f49402f);
                        if (iMatch >= 0) {
                            if (z10) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("  Filter matched!  match=0x");
                                sb5.append(Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f49417c = true;
                            i11 = i10 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z10) {
                            String str3 = iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category";
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("  Filter did not match: ");
                            sb6.append(str3);
                        }
                    }
                    arrayList4 = arrayList;
                    i11 = i10 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                        ((c) arrayList5.get(i12)).f49417c = false;
                    }
                    this.f49410d.add(new b(intent, arrayList5));
                    if (!this.f49411e.hasMessages(1)) {
                        this.f49411e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(@n0 Intent intent) {
        if (d(intent)) {
            a();
        }
    }

    public void f(@n0 BroadcastReceiver broadcastReceiver) {
        synchronized (this.f49408b) {
            ArrayList<c> arrayListRemove = this.f49408b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                c cVar = arrayListRemove.get(size);
                cVar.f49418d = true;
                for (int i10 = 0; i10 < cVar.f49415a.countActions(); i10++) {
                    String action = cVar.f49415a.getAction(i10);
                    ArrayList<c> arrayList = this.f49409c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f49416b == broadcastReceiver) {
                                cVar2.f49418d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f49409c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
