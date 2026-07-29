package f0;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import g.c1;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27490a = "androidx.core.app.EXTRA_CALLING_PACKAGE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27491b = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27492c = "androidx.core.app.EXTRA_CALLING_ACTIVITY";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f27493d = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27494e = ".sharecompat_";

    @v0(16)
    public static class a {
        @g.u
        public static String a(CharSequence charSequence) {
            return Html.escapeHtml(charSequence);
        }

        @g.u
        public static void b(@n0 Intent intent, @n0 ArrayList<Uri> arrayList) {
            ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra(h0.f.f30113b), null, arrayList.get(0)));
            int size = arrayList.size();
            for (int i10 = 1; i10 < size; i10++) {
                clipData.addItem(new ClipData.Item(arrayList.get(i10)));
            }
            intent.setClipData(clipData);
            intent.addFlags(1);
        }

        @g.u
        public static void c(@n0 Intent intent) {
            intent.setClipData(null);
            intent.setFlags(intent.getFlags() & (-2));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final Context f27495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final Intent f27496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public CharSequence f27497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public ArrayList<String> f27498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public ArrayList<String> f27499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public ArrayList<String> f27500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public ArrayList<Uri> f27501g;

        public b(@n0 Context context) {
            Activity activity;
            this.f27495a = (Context) androidx.core.util.o.l(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f27496b = action;
            action.putExtra(j0.f27490a, context.getPackageName());
            action.putExtra(j0.f27491b, context.getPackageName());
            action.addFlags(524288);
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                ComponentName componentName = activity.getComponentName();
                this.f27496b.putExtra(j0.f27492c, componentName);
                this.f27496b.putExtra(j0.f27493d, componentName);
            }
        }

        @n0
        @Deprecated
        public static b k(@n0 Activity activity) {
            return new b(activity);
        }

        @n0
        public b a(@n0 String str) {
            if (this.f27500f == null) {
                this.f27500f = new ArrayList<>();
            }
            this.f27500f.add(str);
            return this;
        }

        @n0
        public b b(@n0 String[] strArr) {
            i("android.intent.extra.BCC", strArr);
            return this;
        }

        @n0
        public b c(@n0 String str) {
            if (this.f27499e == null) {
                this.f27499e = new ArrayList<>();
            }
            this.f27499e.add(str);
            return this;
        }

        @n0
        public b d(@n0 String[] strArr) {
            i("android.intent.extra.CC", strArr);
            return this;
        }

        @n0
        public b e(@n0 String str) {
            if (this.f27498d == null) {
                this.f27498d = new ArrayList<>();
            }
            this.f27498d.add(str);
            return this;
        }

        @n0
        public b f(@n0 String[] strArr) {
            i("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @n0
        public b g(@n0 Uri uri) {
            if (this.f27501g == null) {
                this.f27501g = new ArrayList<>();
            }
            this.f27501g.add(uri);
            return this;
        }

        public final void h(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f27496b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f27496b.putExtra(str, strArr);
        }

        public final void i(@p0 String str, @n0 String[] strArr) {
            Intent intentM = m();
            String[] stringArrayExtra = intentM.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[strArr.length + length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intentM.putExtra(str, strArr2);
        }

        @n0
        public Intent j() {
            return Intent.createChooser(m(), this.f27497c);
        }

        @n0
        public Context l() {
            return this.f27495a;
        }

        @n0
        public Intent m() {
            ArrayList<String> arrayList = this.f27498d;
            if (arrayList != null) {
                h("android.intent.extra.EMAIL", arrayList);
                this.f27498d = null;
            }
            ArrayList<String> arrayList2 = this.f27499e;
            if (arrayList2 != null) {
                h("android.intent.extra.CC", arrayList2);
                this.f27499e = null;
            }
            ArrayList<String> arrayList3 = this.f27500f;
            if (arrayList3 != null) {
                h("android.intent.extra.BCC", arrayList3);
                this.f27500f = null;
            }
            ArrayList<Uri> arrayList4 = this.f27501g;
            if (arrayList4 != null && arrayList4.size() > 1) {
                this.f27496b.setAction("android.intent.action.SEND_MULTIPLE");
                this.f27496b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f27501g);
                a.b(this.f27496b, this.f27501g);
            } else {
                this.f27496b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.f27501g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.f27496b.removeExtra("android.intent.extra.STREAM");
                    a.c(this.f27496b);
                } else {
                    this.f27496b.putExtra("android.intent.extra.STREAM", this.f27501g.get(0));
                    a.b(this.f27496b, this.f27501g);
                }
            }
            return this.f27496b;
        }

        @n0
        public b n(@c1 int i10) {
            return o(this.f27495a.getText(i10));
        }

        @n0
        public b o(@p0 CharSequence charSequence) {
            this.f27497c = charSequence;
            return this;
        }

        @n0
        public b p(@p0 String[] strArr) {
            this.f27496b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @n0
        public b q(@p0 String[] strArr) {
            this.f27496b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @n0
        public b r(@p0 String[] strArr) {
            if (this.f27498d != null) {
                this.f27498d = null;
            }
            this.f27496b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @n0
        public b s(@p0 String str) {
            this.f27496b.putExtra(h0.f.f30113b, str);
            if (!this.f27496b.hasExtra("android.intent.extra.TEXT")) {
                v(Html.fromHtml(str));
            }
            return this;
        }

        @n0
        public b t(@p0 Uri uri) {
            this.f27501g = null;
            if (uri != null) {
                g(uri);
            }
            return this;
        }

        @n0
        public b u(@p0 String str) {
            this.f27496b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @n0
        public b v(@p0 CharSequence charSequence) {
            this.f27496b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @n0
        public b w(@p0 String str) {
            this.f27496b.setType(str);
            return this;
        }

        public void x() {
            this.f27495a.startActivity(j());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f27502f = "IntentReader";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final Context f27503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final Intent f27504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final String f27505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final ComponentName f27506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public ArrayList<Uri> f27507e;

        public c(@n0 Activity activity) {
            this((Context) androidx.core.util.o.l(activity), activity.getIntent());
        }

        @n0
        @Deprecated
        public static c a(@n0 Activity activity) {
            return new c(activity);
        }

        public static void t(StringBuilder sb2, CharSequence charSequence, int i10, int i11) {
            while (i10 < i11) {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt == '<') {
                    sb2.append("&lt;");
                } else if (cCharAt == '>') {
                    sb2.append("&gt;");
                } else if (cCharAt == '&') {
                    sb2.append("&amp;");
                } else if (cCharAt > '~' || cCharAt < ' ') {
                    sb2.append("&#");
                    sb2.append((int) cCharAt);
                    sb2.append(";");
                } else if (cCharAt == ' ') {
                    while (true) {
                        int i12 = i10 + 1;
                        if (i12 >= i11 || charSequence.charAt(i12) != ' ') {
                            break;
                        }
                        sb2.append("&nbsp;");
                        i10 = i12;
                    }
                    sb2.append(zc.f.f58383m);
                } else {
                    sb2.append(cCharAt);
                }
                i10++;
            }
        }

        @p0
        public ComponentName b() {
            return this.f27506d;
        }

        @p0
        public Drawable c() {
            if (this.f27506d == null) {
                return null;
            }
            try {
                return this.f27503a.getPackageManager().getActivityIcon(this.f27506d);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @p0
        public Drawable d() {
            if (this.f27505c == null) {
                return null;
            }
            try {
                return this.f27503a.getPackageManager().getApplicationIcon(this.f27505c);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @p0
        public CharSequence e() {
            if (this.f27505c == null) {
                return null;
            }
            PackageManager packageManager = this.f27503a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f27505c, 0));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @p0
        public String f() {
            return this.f27505c;
        }

        @p0
        public String[] g() {
            return this.f27504b.getStringArrayExtra("android.intent.extra.BCC");
        }

        @p0
        public String[] h() {
            return this.f27504b.getStringArrayExtra("android.intent.extra.CC");
        }

        @p0
        public String[] i() {
            return this.f27504b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @p0
        public String j() {
            String stringExtra = this.f27504b.getStringExtra(h0.f.f30113b);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence charSequenceO = o();
            return charSequenceO instanceof Spanned ? Html.toHtml((Spanned) charSequenceO) : charSequenceO != null ? a.a(charSequenceO) : stringExtra;
        }

        @p0
        public Uri k() {
            return (Uri) this.f27504b.getParcelableExtra("android.intent.extra.STREAM");
        }

        @p0
        public Uri l(int i10) {
            if (this.f27507e == null && q()) {
                this.f27507e = this.f27504b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f27507e;
            if (arrayList != null) {
                return arrayList.get(i10);
            }
            if (i10 == 0) {
                return (Uri) this.f27504b.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + m() + " index requested: " + i10);
        }

        public int m() {
            if (this.f27507e == null && q()) {
                this.f27507e = this.f27504b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f27507e;
            return arrayList != null ? arrayList.size() : this.f27504b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @p0
        public String n() {
            return this.f27504b.getStringExtra("android.intent.extra.SUBJECT");
        }

        @p0
        public CharSequence o() {
            return this.f27504b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @p0
        public String p() {
            return this.f27504b.getType();
        }

        public boolean q() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f27504b.getAction());
        }

        public boolean r() {
            String action = this.f27504b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean s() {
            return "android.intent.action.SEND".equals(this.f27504b.getAction());
        }

        public c(@n0 Context context, @n0 Intent intent) {
            this.f27503a = (Context) androidx.core.util.o.l(context);
            this.f27504b = (Intent) androidx.core.util.o.l(intent);
            this.f27505c = j0.f(intent);
            this.f27506d = j0.d(intent);
        }
    }

    @Deprecated
    public static void a(@n0 Menu menu, @g.d0 int i10, @n0 b bVar) {
        MenuItem menuItemFindItem = menu.findItem(i10);
        if (menuItemFindItem != null) {
            b(menuItemFindItem, bVar);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i10 + " in the supplied menu");
    }

    @Deprecated
    public static void b(@n0 MenuItem menuItem, @n0 b bVar) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(bVar.l()) : (ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(f27494e + bVar.l().getClass().getName());
        shareActionProvider.setShareIntent(bVar.m());
        menuItem.setActionProvider(shareActionProvider);
    }

    @p0
    public static ComponentName c(@n0 Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? d(intent) : callingActivity;
    }

    @p0
    public static ComponentName d(@n0 Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(f27492c);
        return componentName == null ? (ComponentName) intent.getParcelableExtra(f27493d) : componentName;
    }

    @p0
    public static String e(@n0 Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : f(intent);
    }

    @p0
    public static String f(@n0 Intent intent) {
        String stringExtra = intent.getStringExtra(f27490a);
        return stringExtra == null ? intent.getStringExtra(f27491b) : stringExtra;
    }
}
