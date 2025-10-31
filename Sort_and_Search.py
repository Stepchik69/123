1. Сортировка выбором (Selection Sort)
python
class SelectionSort:
    @staticmethod
    def selection_sort(arr):
        """
        Сортировка выбором - на каждом шаге находим минимальный элемент
        и меняем его с текущим элементом неотсортированной части
        Сложность: O(n²) во всех случаях
        """
        n = len(arr)
        print("Начальный массив:", arr)
        print()
        
        for i in range(n):
            print(f"Шаг {i + 1}:")
            print(f"  Текущий элемент arr[{i}] = {arr[i]}")
            
            # Ищем минимальный элемент в неотсортированной части
            min_index = i
            for j in range(i + 1, n):
                if arr[j] < arr[min_index]:
                    min_index = j
                    print(f"  Найден новый минимум: arr[{j}] = {arr[j]}")
            
            if min_index != i:
                # Меняем местами
                print(f"  Меняем местами arr[{i}] = {arr[i]} и arr[{min_index}] = {arr[min_index]}")
                arr[i], arr[min_index] = arr[min_index], arr[i]
            else:
                print(f"  Элемент arr[{i}] = {arr[i]} уже на правильной позиции")
            
            print(f"  Массив после шага {i + 1}: {arr}")
            print()
        
        return arr
    
    @staticmethod
    def main():
        test_array = [23, 56, 21, 41, 12]
        print("=" * 50)
        print("СОРТИРОВКА ВЫБОРОМ (SELECTION SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = SelectionSort.selection_sort(test_array.copy())
        
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [23, 56, 21, 41, 12]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    SelectionSort.main()
2. Сортировка пузырьком (Bubble Sort)
python
class BubbleSort:
    @staticmethod
    def bubble_sort(arr):
        """
        Сортировка пузырьком - многократно проходим по массиву,
        сравнивая и меняя соседние элементы
        Сложность: O(n²) в худшем случае, O(n) в лучшем случае
        """
        n = len(arr)
        print("Начальный массив:", arr)
        print()
        
        for i in range(n - 1):
            swapped = False
            print(f"Проход {i + 1}:")
            
            for j in range(n - i - 1):
                print(f"  Сравниваем arr[{j}] = {arr[j]} и arr[{j + 1}] = {arr[j + 1]}")
                
                if arr[j] > arr[j + 1]:
                    # Меняем местами
                    print(f"  Меняем местами: {arr[j]} > {arr[j + 1]}")
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
                    swapped = True
                else:
                    print(f"  Не меняем: {arr[j]} <= {arr[j + 1]}")
            
            print(f"  Массив после прохода {i + 1}: {arr}")
            
            if not swapped:
                print("  Массив уже отсортирован, завершаем досрочно")
                break
            print()
        
        return arr
    
    @staticmethod
    def main():
        test_array = [64, 34, 25, 12, 22, 11, 90]
        print("=" * 50)
        print("СОРТИРОВКА ПУЗЫРЬКОМ (BUBBLE SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = BubbleSort.bubble_sort(test_array.copy())
        
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [64, 34, 25, 12, 22, 11, 90]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    BubbleSort.main()
3. Сортировка вставками (Insertion Sort)
python
class InsertionSort:
    @staticmethod
    def insertion_sort(arr):
        """
        Сортировка вставками - каждый новый элемент вставляется
        в правильную позицию отсортированной части
        Сложность: O(n²) в худшем случае, O(n) в лучшем случае
        """
        print("Начальный массив:", arr)
        print()
        
        for i in range(1, len(arr)):
            key = arr[i]
            print(f"Шаг {i}: Вставляем элемент arr[{i}] = {key}")
            print(f"  Отсортированная часть: {arr[:i]}")
            print(f"  Неотсортированная часть: {arr[i:]}")
            
            j = i - 1
            shifts = 0
            
            # Сдвигаем элементы, большие чем key
            while j >= 0 and arr[j] > key:
                arr[j + 1] = arr[j]
                j -= 1
                shifts += 1
                print(f"  Сдвигаем элемент arr[{j + 1}] = {arr[j + 1]}")
            
            # Вставляем key на правильную позицию
            arr[j + 1] = key
            print(f"  Вставляем {key} на позицию {j + 1}")
            print(f"  Массив после шага {i}: {arr}")
            print()
        
        return arr
    
    @staticmethod
    def main():
        test_array = [15, 8, 42, 4, 23, 16]
        print("=" * 50)
        print("СОРТИРОВКА ВСТАВКАМИ (INSERTION SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = InsertionSort.insertion_sort(test_array.copy())
        
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [15, 8, 42, 4, 23, 16]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    InsertionSort.main()
4. Сортировка слиянием (Merge Sort)
python
class MergeSort:
    @staticmethod
    def merge_sort(arr, level=0):
        """
        Сортировка слиянием - алгоритм "разделяй и властвуй"
        Сложность: O(n log n) во всех случаях
        """
        prefix = "  " * level
        print(f"{prefix}Вызов merge_sort({arr})")
        
        if len(arr) <= 1:
            print(f"{prefix}Базовый случай: возвращаем {arr}")
            return arr
        
        # Делим массив пополам
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]
        
        print(f"{prefix}Делим на: left={left}, right={right}")
        
        # Рекурсивно сортируем обе половины
        left_sorted = MergeSort.merge_sort(left, level + 1)
        right_sorted = MergeSort.merge_sort(right, level + 1)
        
        # Объединяем отсортированные половины
        result = MergeSort.merge(left_sorted, right_sorted, level)
        print(f"{prefix}Объединяем {left_sorted} и {right_sorted} -> {result}")
        
        return result
    
    @staticmethod
    def merge(left, right, level=0):
        """Объединение двух отсортированных массивов"""
        prefix = "  " * level
        print(f"{prefix}Слияние: left={left}, right={right}")
        
        result = []
        i = j = 0
        
        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                result.append(left[i])
                print(f"{prefix}  Добавляем из left: {left[i]}")
                i += 1
            else:
                result.append(right[j])
                print(f"{prefix}  Добавляем из right: {right[j]}")
                j += 1
        
        # Добавляем оставшиеся элементы
        while i < len(left):
            result.append(left[i])
            print(f"{prefix}  Добавляем оставшийся из left: {left[i]}")
            i += 1
        
        while j < len(right):
            result.append(right[j])
            print(f"{prefix}  Добавляем оставшийся из right: {right[j]}")
            j += 1
        
        print(f"{prefix}Результат слияния: {result}")
        return result
    
    @staticmethod
    def main():
        test_array = [38, 27, 43, 3, 9, 82, 10]
        print("=" * 50)
        print("СОРТИРОВКА СЛИЯНИЕМ (MERGE SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = MergeSort.merge_sort(test_array.copy())
        
        print()
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [38, 27, 43, 3, 9, 82, 10]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    MergeSort.main()
5. Сортировка Шелла (Shell Sort)
python
class ShellSort:
    @staticmethod
    def shell_sort(arr):
        """
        Сортировка Шелла - улучшенная версия сортировки вставками
        Сложность: O(n log n) в среднем случае, O(n²) в худшем случае
        """
        n = len(arr)
        print("Начальный массив:", arr)
        print()
        
        # Начинаем с большого шага, затем уменьшаем
        gap = n // 2
        gap_num = 1
        
        while gap > 0:
            print(f"Шаг {gap_num}: gap = {gap}")
            
            for i in range(gap, n):
                temp = arr[i]
                j = i
                print(f"  Обрабатываем элемент arr[{i}] = {temp}")
                
                # Сдвигаем элементы, которые больше temp
                while j >= gap and arr[j - gap] > temp:
                    print(f"    Сдвигаем arr[{j - gap}] = {arr[j - gap]} -> arr[{j}]")
                    arr[j] = arr[j - gap]
                    j -= gap
                
                if j != i:
                    print(f"    Вставляем {temp} на позицию {j}")
                    arr[j] = temp
                else:
                    print(f"    Элемент {temp} уже на правильной позиции")
                
                print(f"    Текущее состояние массива: {arr}")
            
            gap //= 2
            gap_num += 1
            print()
        
        return arr
    
    @staticmethod
    def main():
        test_array = [23, 12, 1, 8, 34, 54, 2, 3]
        print("=" * 50)
        print("СОРТИРОВКА ШЕЛЛА (SHELL SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = ShellSort.shell_sort(test_array.copy())
        
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [23, 12, 1, 8, 34, 54, 2, 3]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    ShellSort.main()
6. Быстрая сортировка (Quick Sort)
python
class QuickSort:
    @staticmethod
    def quick_sort(arr, low=0, high=None, level=0):
        """
        Быстрая сортировка - алгоритм "разделяй и властвуй"
        Сложность: O(n log n) в среднем случае, O(n²) в худшем случае
        """
        if high is None:
            high = len(arr) - 1
        
        prefix = "  " * level
        
        if low < high:
            print(f"{prefix}Быстрая сортировка: arr[{low}:{high + 1}] = {arr[low:high + 1]}")
            
            # Разделяем массив и получаем индекс опорного элемента
            pi = QuickSort.partition(arr, low, high, level)
            print(f"{prefix}Опорный элемент arr[{pi}] = {arr[pi]} на позиции {pi}")
            print(f"{prefix}После разделения: {arr[low:high + 1]}")
            print()
            
            # Рекурсивно сортируем элементы до и после опорного
            QuickSort.quick_sort(arr, low, pi - 1, level + 1)
            QuickSort.quick_sort(arr, pi + 1, high, level + 1)
        
        return arr
    
    @staticmethod
    def partition(arr, low, high, level=0):
        """Разделение массива относительно опорного элемента"""
        prefix = "  " * level
        pivot = arr[high]  # выбираем последний элемент как опорный
        print(f"{prefix}Разделение: pivot = {pivot}")
        
        i = low - 1  # индекс меньшего элемента
        
        for j in range(low, high):
            if arr[j] <= pivot:
                i += 1
                print(f"{prefix}  arr[{j}] = {arr[j]} <= {pivot}, меняем с arr[{i}]")
                arr[i], arr[j] = arr[j], arr[i]
            else:
                print(f"{prefix}  arr[{j}] = {arr[j]} > {pivot}, пропускаем")
        
        # Помещаем опорный элемент на правильную позицию
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        print(f"{prefix}  Помещаем pivot на позицию {i + 1}")
        
        return i + 1
    
    @staticmethod
    def main():
        test_array = [24, 15, 38, 2, 19, 41, 8]
        print("=" * 50)
        print("БЫСТРАЯ СОРТИРОВКА (QUICK SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = QuickSort.quick_sort(test_array.copy())
        
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [24, 15, 38, 2, 19, 41, 8]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    QuickSort.main()
7. Пирамидальная сортировка (Heap Sort)
python
class HeapSort:
    @staticmethod
    def heap_sort(arr):
        """
        Пирамидальная сортировка - использует структуру данных "куча"
        Сложность: O(n log n) во всех случаях
        """
        n = len(arr)
        print("Начальный массив:", arr)
        print()
        
        # Построение max-кучи
        print("Фаза 1: Построение max-кучи")
        for i in range(n // 2 - 1, -1, -1):
            print(f"  Восстанавливаем кучу для узла arr[{i}] = {arr[i]}")
            HeapSort.heapify(arr, n, i)
            print(f"  Массив после heapify: {arr}")
        print()
        
        # Извлечение элементов из кучи один за другим
        print("Фаза 2: Извлечение элементов из кучи")
        for i in range(n - 1, 0, -1):
            print(f"  Меняем корень arr[0] = {arr[0]} с arr[{i}] = {arr[i]}")
            arr[i], arr[0] = arr[0], arr[i]
            print(f"  Массив после обмена: {arr}")
            
            print(f"  Восстанавливаем кучу для корня arr[0] = {arr[0]}")
            HeapSort.heapify(arr, i, 0)
            print(f"  Массив после heapify: {arr}")
            print()
        
        return arr
    
    @staticmethod
    def heapify(arr, n, i):
        """Восстановление свойства кучи для поддерева с корнем i"""
        largest = i  # Инициализируем наибольший элемент как корень
        left = 2 * i + 1
        right = 2 * i + 2
        
        # Если левый дочерний элемент больше корня
        if left < n and arr[left] > arr[largest]:
            largest = left
        
        # Если правый дочерний элемент больше текущего наибольшего
        if right < n and arr[right] > arr[largest]:
            largest = right
        
        # Если наибольший элемент не корень
        if largest != i:
            print(f"    Меняем arr[{i}] = {arr[i]} с arr[{largest}] = {arr[largest]}")
            arr[i], arr[largest] = arr[largest], arr[i]
            # Рекурсивно восстанавливаем кучу для затронутого поддерева
            HeapSort.heapify(arr, n, largest)
    
    @staticmethod
    def main():
        test_array = [4, 10, 3, 5, 1]
        print("=" * 50)
        print("ПИРАМИДАЛЬНАЯ СОРТИРОВКА (HEAP SORT)")
        print("=" * 50)
        print("Исходный массив:", test_array)
        print()
        
        sorted_array = HeapSort.heap_sort(test_array.copy())
        
        print("=" * 50)
        print("РЕЗУЛЬТАТ:")
        print("Исходный массив: [4, 10, 3, 5, 1]")
        print("Отсортированный массив:", sorted_array)
        print("=" * 50)

if __name__ == "__main__":
    HeapSort.main()
Тестирование всех алгоритмов сортировки
python
class SortingAlgorithmsTester:
    @staticmethod
    def test_all_algorithms():
        print("=" * 60)
        print("ТЕСТИРОВАНИЕ ВСЕХ АЛГОРИТМОВ СОРТИРОВКИ")
        print("=" * 60)
        
        test_cases = [
            ([23, 56, 21, 41, 12], "Selection Sort"),
            ([64, 34, 25, 12, 22, 11, 90], "Bubble Sort"),
            ([15, 8, 42, 4, 23, 16], "Insertion Sort"),
            ([38, 27, 43, 3, 9, 82, 10], "Merge Sort"),
            ([23, 12, 1, 8, 34, 54, 2, 3], "Shell Sort"),
            ([24, 15, 38, 2, 19, 41, 8], "Quick Sort"),
            ([4, 10, 3, 5, 1], "Heap Sort")
        ]
        
        algorithms = {
            "Selection Sort": SelectionSort.selection_sort,
            "Bubble Sort": BubbleSort.bubble_sort,
            "Insertion Sort": InsertionSort.insertion_sort,
            "Merge Sort": MergeSort.merge_sort,
            "Shell Sort": ShellSort.shell_sort,
            "Quick Sort": QuickSort.quick_sort,
            "Heap Sort": HeapSort.heap_sort
        }
        
        for test_array, algorithm_name in test_cases:
            print(f"\n{'='*40}")
            print(f"ТЕСТ: {algorithm_name}")
            print(f"{'='*40}")
            
            try:
                original = test_array.copy()
                sorted_arr = algorithms[algorithm_name](test_array.copy())
                
                print(f"\nРезультат:")
                print(f"Исходный: {original}")
                print(f"Отсортированный: {sorted_arr}")
                print(f"Корректность: {sorted_arr == sorted(original)}")
                
            except Exception as e:
                print(f"Ошибка при выполнении {algorithm_name}: {e}")
