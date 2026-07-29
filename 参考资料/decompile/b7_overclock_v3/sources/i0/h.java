package i0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import g.i1;
import g.j1;
import g.n0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31542a = "ShortcutXmlParser";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31543b = "android.app.shortcuts";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31544c = "shortcut";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31545d = "shortcutId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile ArrayList<String> f31546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f31547f = new Object();

    public static String a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlPullParser.getAttributeValue(null, str) : attributeValue;
    }

    @j1
    @n0
    public static List<String> b(@n0 Context context) {
        if (f31546e == null) {
            synchronized (f31547f) {
                if (f31546e == null) {
                    f31546e = new ArrayList<>();
                    f31546e.addAll(e(context));
                }
            }
        }
        return f31546e;
    }

    @n0
    public static XmlResourceParser c(Context context, ActivityInfo activityInfo) {
        XmlResourceParser xmlResourceParserLoadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), f31543b);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
    }

    @i1
    @n0
    public static List<String> d(@n0 XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strA;
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= 0)) {
                break;
            }
            int depth = xmlPullParser.getDepth();
            String name = xmlPullParser.getName();
            if (next == 2 && depth == 2 && f31544c.equals(name) && (strA = a(xmlPullParser, f31545d)) != null) {
                arrayList.add(strA);
            }
        }
        return arrayList;
    }

    @n0
    public static Set<String> e(@n0 Context context) {
        HashSet hashSet = new HashSet();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
            try {
                Iterator<ResolveInfo> it2 = listQueryIntentActivities.iterator();
                while (it2.hasNext()) {
                    ActivityInfo activityInfo = it2.next().activityInfo;
                    Bundle bundle = activityInfo.metaData;
                    if (bundle != null && bundle.containsKey(f31543b)) {
                        XmlResourceParser xmlResourceParserC = c(context, activityInfo);
                        try {
                            hashSet.addAll(d(xmlResourceParserC));
                            if (xmlResourceParserC != null) {
                                xmlResourceParserC.close();
                            }
                        } finally {
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }
}
