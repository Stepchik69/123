#include <iostream>
#include <string>

std::string reverse_string(const std::string& s) {
    // Базовый случай
    if (s.length() <= 1) {
        return s;
    }
    // Рекурсивный случай
    return s[s.length() - 1] + reverse_string(s.substr(0, s.length() - 1));
}

int main() {
    std::string input = "Пример";
    std::string result = reverse_string(input);
    std::cout << "Исходная строка: " << input << std::endl;
    std::cout << "Перевернутая строка: " << result << std::endl;
    return 0;
}
