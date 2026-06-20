import struct, sys

def parse_dex(path, label):
    print(f"\n===== {label} =====")
    with open(path, 'rb') as f:
        data = f.read()

    magic = data[0:4]
    version = data[4:8]
    print(f"  DEX version: {version.decode('ascii', errors='replace')}")
    print(f"  File size: {struct.unpack('<I', data[0x20:0x24])[0]}")

    # String IDs
    string_ids_off = struct.unpack('<I', data[0x38:0x3C])[0]
    string_ids_size = struct.unpack('<I', data[0x34:0x38])[0]
    print(f"  String IDs: {string_ids_size} at offset {string_ids_off}")

    # Type IDs
    type_ids_off = struct.unpack('<I', data[0x40:0x44])[0]
    type_ids_size = struct.unpack('<I', data[0x3C:0x40])[0]

    # Class defs
    class_defs_off = struct.unpack('<I', data[0x50:0x54])[0]
    class_defs_size = struct.unpack('<I', data[0x4C:0x50])[0]
    print(f"  Class defs: {class_defs_size}")

    # Read all strings
    strings = []
    for i in range(string_ids_size):
        off = struct.unpack('<I', data[string_ids_off + i*4:string_ids_off + i*4 + 4])[0]
        end = data.index(0, off)
        strings.append(data[off:end].decode('utf-8', errors='replace'))

    # Show all strings containing "MainHook", "Xposed", "waspwing", etc.
    print(f"\n  === Relevant strings ===")
    for s in strings:
        if any(x in s for x in ['MainHook', 'Xposed', 'IXposed', 'waspwing', 'flydigi', 'WaspWing', 'setRunMode', 'handleLoadPackage', 'BroadcastReceiver', 'Register']):
            print(f"    {s}")

    # Read all types
    types = []
    for i in range(type_ids_size):
        idx = struct.unpack('<I', data[type_ids_off + i*4:type_ids_off + i*4 + 4])[0]
        types.append(strings[idx] if idx < len(strings) else f"INVALID({idx})")

    print(f"\n  === All types ({len(types)}) ===")
    for t in types:
        print(f"    {t}")

    # Read class defs
    print(f"\n  === Defined classes ===")
    for i in range(class_defs_size):
        off = class_defs_off + i * 0x20
        class_idx = struct.unpack('<I', data[off:off+4])[0]
        access_flags = struct.unpack('<I', data[off+4:off+8])[0]
        superclass_idx = struct.unpack('<I', data[off+8:off+12])[0]
        if class_idx < len(types):
            super_str = types[superclass_idx] if superclass_idx < len(types) else f"#{superclass_idx}"
            print(f"    {types[class_idx]} (flags: {access_flags:#x}, super: {super_str})")
        else:
            print(f"    INVALID class index {class_idx}")

parse_dex("D:/下载/Claude Code/WaspWingTempCtrl/修复/base.apk/classes.dex", "classes.dex (R class)")
parse_dex("D:/下载/Claude Code/WaspWingTempCtrl/修复/base.apk/classes2.dex", "classes2.dex (MainHook)")
