package a;

import android.content.Context;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nb2 f6479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1508a;

    public j60(Context context) {
        f92.d(context, "context");
        this.f1508a = context;
        this.f6479a = new nb2("@(string|dimen)[:/][_a-z][_0-9a-z]+", pb2.f7102a);
    }

    public static /* synthetic */ String d(j60 j60Var, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveResources");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return j60Var.b(str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.j60.a(java.lang.String):java.lang.String");
    }

    public final String b(String str, boolean z) {
        fb2 fb2VarA;
        eb2 eb2Var;
        fb2 fb2VarA2;
        eb2 eb2Var2;
        f92.d(str, "originRow");
        gb2 gb2VarC = nb2.c(this.f6479a, str, 0, 2, null);
        String strT = str;
        String strA = (gb2VarC == null || (fb2VarA2 = gb2VarC.a()) == null || (eb2Var2 = (eb2) i52.B(fb2VarA2)) == null) ? null : eb2Var2.a();
        while (strA != null) {
            String strA2 = a(strA);
            if (z) {
                if (strA2.length() > 0) {
                    strA2 = bc2.t(strA2, "&", "&amp;", false, 4, null);
                }
            }
            strT = bc2.t(strT, strA, strA2, false, 4, null);
            gb2 gb2VarC2 = nb2.c(this.f6479a, strT, 0, 2, null);
            strA = (gb2VarC2 == null || (fb2VarA = gb2VarC2.a()) == null || (eb2Var = (eb2) i52.B(fb2VarA)) == null) ? null : eb2Var.a();
        }
        return strT;
    }

    public final String c(List<String> list) {
        f92.d(list, "rows");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : list) {
            if (i > 0) {
                sb.append("\n");
            }
            sb.append(d(this, str, false, 2, null));
            i++;
        }
        String string = sb.toString();
        f92.c(string, "builder.toString()");
        return string;
    }

    public final ByteArrayInputStream e(InputStream inputStream) throws XmlPullParserException, IOException {
        f92.d(inputStream, "fileInputStream");
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, "utf-8");
        f92.c(xmlPullParserNewPullParser, "parser");
        StringWriter stringWriter = new StringWriter();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        f92.c(xmlSerializerNewSerializer, "Xml.newSerializer()");
        xmlSerializerNewSerializer.setOutput(stringWriter);
        xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2) {
                xmlSerializerNewSerializer.startTag("", xmlPullParserNewPullParser.getName());
                int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    String attributeName = xmlPullParserNewPullParser.getAttributeName(i);
                    String attributeValue = xmlPullParserNewPullParser.getAttributeValue(i);
                    String attributeNamespace = xmlPullParserNewPullParser.getAttributeNamespace(i);
                    f92.c(attributeValue, "attrValue");
                    xmlSerializerNewSerializer.attribute(attributeNamespace, attributeName, d(this, attributeValue, false, 2, null));
                }
            } else if (eventType == 3) {
                xmlSerializerNewSerializer.endTag("", xmlPullParserNewPullParser.getName());
            } else if (eventType == 4) {
                String text = xmlPullParserNewPullParser.getText();
                f92.c(text, "text");
                xmlSerializerNewSerializer.text(d(this, text, false, 2, null));
            }
        }
        xmlSerializerNewSerializer.endDocument();
        String string = stringWriter.toString();
        f92.c(string, "writer.toString()");
        Charset charset = bb2.f5692a;
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = string.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }
}
