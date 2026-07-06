package a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qj0 {
    public void a(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        if (file.isHidden()) {
            return;
        }
        if (file.isDirectory()) {
            if (!str.isEmpty()) {
                zipOutputStream.putNextEntry(str.endsWith("/") ? new ZipEntry(str) : new ZipEntry(str + "/"));
                zipOutputStream.closeEntry();
            }
            for (File file2 : file.listFiles()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.isEmpty() ? "" : str + "/");
                sb.append(file2.getName());
                a(file2, sb.toString(), zipOutputStream);
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        zipOutputStream.putNextEntry(new ZipEntry(str));
        byte[] bArr = new byte[1024];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i < 0) {
                fileInputStream.close();
                return;
            }
            zipOutputStream.write(bArr, 0, i);
        }
    }
}
