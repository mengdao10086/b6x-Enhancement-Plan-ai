package a;

import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ed1<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        cy0 cy0Var = (cy0) t;
        int downloads = cy0Var.getDownloads();
        String source = cy0Var.getSource();
        if (source != null) {
            int iHashCode = source.hashCode();
            if (iHashCode != -765289749) {
                if (iHashCode == 109400031 && source.equals("share")) {
                    downloads += 50;
                }
            } else if (source.equals("official")) {
                downloads += 100;
            }
        }
        Integer numValueOf = Integer.valueOf(-downloads);
        cy0 cy0Var2 = (cy0) t2;
        int downloads2 = cy0Var2.getDownloads();
        String source2 = cy0Var2.getSource();
        if (source2 != null) {
            int iHashCode2 = source2.hashCode();
            if (iHashCode2 != -765289749) {
                if (iHashCode2 == 109400031 && source2.equals("share")) {
                    downloads2 += 50;
                }
            } else if (source2.equals("official")) {
                downloads2 += 100;
            }
        }
        return w52.a(numValueOf, Integer.valueOf(-downloads2));
    }
}
