map.put("key", value);

Integer value = map.get("key");

boolean exists = map.containsKey("key");

map.remove("key");

int size = map.size();

for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
