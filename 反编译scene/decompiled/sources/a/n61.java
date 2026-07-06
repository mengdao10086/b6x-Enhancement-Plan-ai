package a;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n61 {
    public Document a(String str) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(Document document, String str) {
        if (document != null && str != null && !str.isEmpty()) {
            try {
                Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
                transformerNewTransformer.setOutputProperty("encoding", "utf-8");
                transformerNewTransformer.setOutputProperty("version", document.getXmlVersion());
                DOMSource dOMSource = new DOMSource(document);
                File file = new File(str);
                if (!file.exists()) {
                    Log.i("XmlUtils", "saveXmlWithDom,createNewFile:" + file.createNewFile());
                }
                transformerNewTransformer.transform(dOMSource, new StreamResult(new FileOutputStream(file)));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
