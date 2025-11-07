def reverse_string(s):
    # Базовый случай
    if len(s) <= 1:
        return s
    # Рекурсивный случай
    return s[-1] + reverse_string(s[:-1])

# Тестирование
input_str = "Пример"
result = reverse_string(input_str)
print(f"Исходная строка: {input_str}")
print(f"Перевернутая строка: {result}")
