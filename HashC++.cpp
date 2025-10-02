map["key"] = value;
map.insert({"key", value});

int value = map["key"];

if (map.count("key") > 0) { /* ключ существует */ }

map.erase("key");

size_t size = map.size();
