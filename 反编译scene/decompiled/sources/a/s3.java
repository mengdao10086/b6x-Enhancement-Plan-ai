package a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s3 extends MenuInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?>[] f7357a;
    public static final Class<?>[] b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object[] f2833a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Object[] f2834b;

    static {
        Class<?>[] clsArr = {Context.class};
        f7357a = clsArr;
        b = clsArr;
    }

    public s3(Context context) {
        super(context);
        this.f2831a = context;
        Object[] objArr = {context};
        this.f2833a = objArr;
        this.f2834b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f2832a == null) {
            this.f2832a = a(this.f2831a);
        }
        return this.f2832a;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        r3 r3Var = new r3(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        r3Var.h();
                    } else if (name2.equals("item")) {
                        if (!r3Var.d()) {
                            uf ufVar = r3Var.f2687a;
                            if (ufVar == null || !ufVar.a()) {
                                r3Var.a();
                            } else {
                                r3Var.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    r3Var.f(attributeSet);
                } else if (name3.equals("item")) {
                    r3Var.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, r3Var.b());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof qd)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f2831a.getResources().getLayout(i);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (XmlPullParserException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
