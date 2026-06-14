package a;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yj0 {
    public boolean a(long j) {
        return b(new Date(j));
    }

    public boolean b(Date date) {
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }
}
