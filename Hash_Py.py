def simple_hash_table():
    hash_table = {}
    
    hash_table["apple"] = 50
    hash_table["banana"] = 30
    hash_table["orange"] = 25
    
    print("Простая хеш-таблица:")
    for key, value in hash_table.items():
        print(f"{key}: {value}")
    
    print(f"\nЦена apple: {hash_table['apple']}")
    
    if "banana" in hash_table:
        print("Банан есть в таблице!")
    
    del hash_table["orange"]
    print(f"\nПосле удаления orange: {hash_table}")

simple_hash_table()
