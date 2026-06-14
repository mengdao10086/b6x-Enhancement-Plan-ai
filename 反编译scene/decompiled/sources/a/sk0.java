package a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Xml;
import com.omarea.Scene;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pk0 f7408a = new pk0(null);
    public static final z32 b = a42.a(ok0.f7032a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f2897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f2898a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, String[]> f2899b;

    public sk0() throws XmlPullParserException, IOException {
        this.f2897a = a42.a(rk0.f7309a);
        HashMap map = new HashMap();
        m42 m42Var = m42.f6769a;
        this.f2898a = map;
        this.f2899b = new HashMap();
        i();
    }

    public /* synthetic */ sk0(b92 b92Var) {
        this();
    }

    public final boolean b(Resources resources, String str) {
        qk0 qk0Var;
        int length;
        int i;
        StringWriter stringWriter;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        int i3;
        String name;
        String str7 = "item";
        String str8 = "resources";
        f92.d(resources, "res");
        f92.d(str, "exportPath");
        Field[] declaredFields = u61.class.getDeclaredFields();
        Field[] declaredFields2 = s61.class.getDeclaredFields();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        f92.c(xmlSerializerNewSerializer, "Xml.newSerializer()");
        StringWriter stringWriter2 = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter2);
            xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
            xmlSerializerNewSerializer.startTag("", "resources");
            xmlSerializerNewSerializer.text("\n");
            qk0Var = new qk0(new nb2("[A-Z_]+"));
            length = declaredFields.length;
            i = 0;
        } catch (IOException e) {
            e = e;
        }
        while (true) {
            stringWriter = stringWriter2;
            str2 = str8;
            str3 = "field";
            str4 = str7;
            if (i >= length) {
                break;
            }
            Field field = declaredFields[i];
            try {
                int i4 = field.getInt(null);
                f92.c(field, "field");
                String name2 = field.getName();
                f92.c(name2, "resourceName");
                if (!qk0Var.f(name2).booleanValue()) {
                    String string = resources.getString(i4);
                    f92.c(string, "res.getString(resourceId)");
                    xmlSerializerNewSerializer.startTag("", "string");
                    xmlSerializerNewSerializer.attribute("", "name", name2);
                    xmlSerializerNewSerializer.text(string);
                    xmlSerializerNewSerializer.endTag("", "string");
                    xmlSerializerNewSerializer.text("\n");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i++;
            stringWriter2 = stringWriter;
            str8 = str2;
            str7 = str4;
            e = e;
            e.printStackTrace();
            return false;
        }
        int length2 = declaredFields2.length;
        int i5 = 0;
        while (i5 < length2) {
            Field field2 = declaredFields2[i5];
            try {
                i3 = field2.getInt(null);
                f92.c(field2, str3);
                name = field2.getName();
                f92.c(name, "resourceName");
            } catch (Exception e3) {
                e = e3;
                i2 = length2;
                str5 = str3;
            }
            if (qk0Var.f(name).booleanValue()) {
                i2 = length2;
                str5 = str3;
            } else {
                i2 = length2;
                str5 = str3;
                try {
                } catch (Exception e4) {
                    e = e4;
                    str6 = str4;
                    e.printStackTrace();
                    i5++;
                    str4 = str6;
                    length2 = i2;
                    str3 = str5;
                }
                if (!bc2.x(name, "config_", false, 2, null)) {
                    String[] stringArray = resources.getStringArray(i3);
                    f92.c(stringArray, "res.getStringArray(resourceId)");
                    if (!(stringArray.length == 0) && u42.n(stringArray) != null) {
                        xmlSerializerNewSerializer.startTag("", "string-array");
                        xmlSerializerNewSerializer.attribute("", "name", name);
                        xmlSerializerNewSerializer.text("\n");
                        int length3 = stringArray.length;
                        int i6 = 0;
                        while (i6 < length3) {
                            String str9 = stringArray[i6];
                            xmlSerializerNewSerializer.text("  ");
                            str6 = str4;
                            try {
                                xmlSerializerNewSerializer.startTag("", str6);
                                xmlSerializerNewSerializer.text(str9);
                                xmlSerializerNewSerializer.endTag("", str6);
                                xmlSerializerNewSerializer.text("\n");
                                i6++;
                                str4 = str6;
                            } catch (Exception e5) {
                                e = e5;
                                e.printStackTrace();
                                i5++;
                                str4 = str6;
                                length2 = i2;
                                str3 = str5;
                            }
                        }
                        str6 = str4;
                        xmlSerializerNewSerializer.endTag("", "string-array");
                        xmlSerializerNewSerializer.text("\n");
                    }
                    i5++;
                    str4 = str6;
                    length2 = i2;
                    str3 = str5;
                }
            }
            str6 = str4;
            i5++;
            str4 = str6;
            length2 = i2;
            str3 = str5;
        }
        xmlSerializerNewSerializer.endTag("", str2);
        xmlSerializerNewSerializer.endDocument();
        String string2 = stringWriter.toString();
        f92.c(string2, "writer.toString()");
        try {
            l(string2, str);
            return true;
        } catch (IOException e6) {
            e = e6;
        }
    }

    public final boolean c() {
        return (this.f2899b.isEmpty() ^ true) || (this.f2898a.isEmpty() ^ true);
    }

    public final String d() {
        return (String) this.f2897a.getValue();
    }

    public final Resources e(Context context, Locale locale) {
        f92.d(context, "context");
        f92.d(locale, "locale");
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        f92.c(contextCreateConfigurationContext, "context.createConfigurationContext(config)");
        Resources resources2 = contextCreateConfigurationContext.getResources();
        f92.c(resources2, "context.createConfigurat…Context(config).resources");
        return resources2;
    }

    public final String f(String str) {
        f92.d(str, "key");
        return this.f2898a.get(str);
    }

    public final String[] g(String str) {
        f92.d(str, "key");
        return this.f2899b.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f8 A[Catch: all -> 0x014b, TryCatch #4 {all -> 0x014b, blocks: (B:10:0x0098, B:22:0x00f8, B:23:0x0145, B:13:0x00bf, B:14:0x00c4, B:16:0x00ca, B:19:0x00ee), top: B:87:0x0098 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(java.io.File r27) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.sk0.h(java.io.File):java.lang.String");
    }

    public final void i() throws XmlPullParserException, IOException {
        File file = new File(d());
        if (file.exists()) {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(new FileInputStream(file), "utf-8");
            f92.c(xmlPullParserNewPullParser, "parser");
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2) {
                    if (f92.a(xmlPullParserNewPullParser.getName(), "string")) {
                        String strJ = j(xmlPullParserNewPullParser);
                        String strNextText = xmlPullParserNewPullParser.nextText();
                        f92.c(strNextText, "parser.nextText()");
                        map.put(strJ, bc2.t(bc2.t(bc2.t(strNextText, "\\n", "\n", false, 4, null), "\\'", "'", false, 4, null), "\\\\", "\\", false, 4, null));
                    } else if (f92.a(xmlPullParserNewPullParser.getName(), "string-array")) {
                        map2.put(j(xmlPullParserNewPullParser), k(xmlPullParserNewPullParser));
                    }
                }
            }
            this.f2898a = map;
            this.f2899b = map2;
        }
    }

    public final String j(XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        String attributeValue = "";
        for (int i = 0; i < attributeCount; i++) {
            if (f92.a(xmlPullParser.getAttributeName(i), "name")) {
                attributeValue = xmlPullParser.getAttributeValue(i);
                f92.c(attributeValue, "parser.getAttributeValue(i)");
            }
        }
        return attributeValue;
    }

    public final String[] k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (next != 2) {
                if (next == 3 && (!f92.a(xmlPullParser.getName(), "item"))) {
                    break;
                }
            } else if (f92.a(xmlPullParser.getName(), "item")) {
                String strNextText = xmlPullParser.nextText();
                f92.c(strNextText, "parser.nextText()");
                arrayList.add(bc2.t(bc2.t(bc2.t(strNextText, "\\n", "\n", false, 4, null), "\\'", "'", false, 4, null), "\\\\", "\\", false, 4, null));
            }
            next = xmlPullParser.next();
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void l(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
        try {
            Charset charset = bb2.f5692a;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str.getBytes(charset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            m42 m42Var = m42.f6769a;
            k72.a(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                k72.a(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public final void m() {
        File file = new File(d());
        if (file.exists()) {
            file.delete();
        }
        Activity activityD = Scene.f4798a.d();
        if (activityD != null) {
            activityD.finishAffinity();
        }
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
