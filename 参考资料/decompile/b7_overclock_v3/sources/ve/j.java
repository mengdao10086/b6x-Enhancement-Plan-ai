package ve;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface j {
    k a(b bVar) throws NotFoundException, ChecksumException, FormatException;

    k d(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
