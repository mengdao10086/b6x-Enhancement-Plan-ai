package b2;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import c2.b;
import g.n0;
import g.p0;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class c {
    @p0
    public static CancellationSignal a() {
        return b.a.b();
    }

    public static void b(c2.d dVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursorL0 = dVar.L0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorL0.moveToNext()) {
            try {
                arrayList.add(cursorL0.getString(0));
            } catch (Throwable th2) {
                cursorL0.close();
                throw th2;
            }
        }
        cursorL0.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                dVar.C("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static void c(@n0 c2.d dVar, @n0 String str) {
        Cursor cursorL0 = dVar.L0("PRAGMA foreign_key_check(`" + str + "`)");
        try {
            if (cursorL0.getCount() <= 0) {
            } else {
                throw new IllegalStateException(d(cursorL0));
            }
        } finally {
            cursorL0.close();
        }
    }

    public static String d(Cursor cursor) {
        int count = cursor.getCount();
        HashMap map = new HashMap();
        String string = null;
        while (cursor.moveToNext()) {
            if (string == null) {
                string = cursor.getString(0);
            }
            String string2 = cursor.getString(3);
            if (!map.containsKey(string2)) {
                map.put(string2, cursor.getString(2));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Foreign key violation(s) detected in '");
        sb2.append(string);
        sb2.append("'.\n");
        sb2.append("Number of different violations discovered: ");
        sb2.append(map.keySet().size());
        sb2.append("\n");
        sb2.append("Number of rows in violation: ");
        sb2.append(count);
        sb2.append("\n");
        sb2.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : map.entrySet()) {
            sb2.append("\tParent Table = ");
            sb2.append((String) entry.getValue());
            sb2.append(", Foreign Key Constraint Index = ");
            sb2.append((String) entry.getKey());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    @n0
    @Deprecated
    public static Cursor e(RoomDatabase roomDatabase, c2.g gVar, boolean z10) {
        return f(roomDatabase, gVar, z10, null);
    }

    @n0
    public static Cursor f(@n0 RoomDatabase roomDatabase, @n0 c2.g gVar, boolean z10, @p0 CancellationSignal cancellationSignal) {
        Cursor cursorG = roomDatabase.G(gVar, cancellationSignal);
        if (!z10 || !(cursorG instanceof AbstractWindowedCursor)) {
            return cursorG;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorG;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : cursorG;
    }

    public static int g(@n0 File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i10 = byteBufferAllocate.getInt();
            channel.close();
            return i10;
        } catch (Throwable th2) {
            if (0 != 0) {
                fileChannel.close();
            }
            throw th2;
        }
    }
}
