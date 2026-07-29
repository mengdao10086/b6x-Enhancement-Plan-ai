package u2;

import androidx.lifecycle.LiveData;
import androidx.room.l0;
import androidx.room.m2;
import g.n0;
import java.util.List;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@l0
public interface g {
    @m2(observedEntities = {r.class})
    @n0
    List<r.c> a(@n0 c2.g query);

    @m2(observedEntities = {r.class})
    @n0
    LiveData<List<r.c>> b(@n0 c2.g query);
}
