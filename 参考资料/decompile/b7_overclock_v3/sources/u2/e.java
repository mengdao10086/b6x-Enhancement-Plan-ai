package u2;

import androidx.lifecycle.LiveData;
import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@l0
public interface e {
    @p1("SELECT long_value FROM Preference where `key`=:key")
    @n0
    LiveData<Long> a(@n0 String key);

    @e1(onConflict = 1)
    void b(@n0 d preference);

    @p1("SELECT long_value FROM Preference where `key`=:key")
    @p0
    Long c(@n0 String key);
}
