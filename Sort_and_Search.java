Алгоритмы сортировки
1. Сортировка выбором (Selection Sort)
java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // Проходим по всем элементам массива
        for (int i = 0; i < arr.length; i++) {
            // Предполагаем, что первый элемент - минимальный
            int minIndex = i;
            // Ищем минимальный элемент в оставшейся части массива
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Меняем найденный минимальный элемент с первым элементом в неотсортированной части
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    // Пример использования
    public static void main(String[] args) {
        int[] testArray = {23, 56, 21, 41, 12};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        selectionSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }
    
    // Вспомогательный метод для вывода массива
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
2. Сортировка пузырьком (Bubble Sort)
java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Меняем элементы местами
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        bubbleSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
3. Сортировка вставками (Insertion Sort)
java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Сдвигаем элементы, которые больше key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] testArray = {15, 8, 42, 4, 23, 16};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        insertionSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
4. Сортировка слиянием (Merge Sort)
java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] testArray = {38, 27, 43, 3, 9, 82, 10};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        mergeSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
5. Сортировка Шелла (Shell Sort)
java
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = {23, 12, 1, 8, 34, 54, 2, 3};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        shellSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
6. Быстрая сортировка (Quick Sort)
java
public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] testArray = {24, 15, 38, 2, 19, 41, 8};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        quickSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
7. Пирамидальная сортировка (Heap Sort)
java
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {4, 10, 3, 5, 1};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        heapSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
Алгоритмы поиска
1. Последовательный поиск (Linear Search)
java
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {2, 5, 8, 12, 16, 23, 38, 45};
        int target = 16;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = linearSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
2. Бинарный поиск (Binary Search)
java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] testArray = {3, 7, 14, 21, 29, 33, 42, 55, 67, 78};
        int[] targets = {29, 7, 100, 42};
        
        System.out.print("Массив: ");
        printArray(testArray);
        System.out.println();
        
        for (int target : targets) {
            int result = binarySearch(testArray, target);
            if (result != -1) {
                System.out.println("Элемент " + target + " найден на позиции: " + result);
            } else {
                System.out.println("Элемент " + target + " не найден");
            }
        }
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
3. Интерполяционный поиск (Interpolation Search)
java
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }

            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == target) return pos;
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 60;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = interpolationSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
4. Поиск Фибоначчи (Fibonacci Search)
java
public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int fibMMm2 = 0; // (m-2)-е число Фибоначчи
        int fibMMm1 = 1; // (m-1)-е число Фибоначчи
        int fibM = fibMMm2 + fibMMm1; // m-е число Фибоначчи

        while (fibM < arr.length) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMMm2, arr.length - 1);

            if (arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                return i;
            }
        }

        if (fibMMm1 == 1 && arr[offset + 1] == target)
            return offset + 1;

        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int target = 85;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = fibonacciSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
Тестирование всех алгоритмов
java
public class AlgorithmTester {
    public static void main(String[] args) {
        System.out.println("ТЕСТИРОВАНИЕ АЛГОРИТМОВ СОРТИРОВКИ И ПОИСКА");
        System.out.println("============================================");
        
        // Тестирование сортировки выбором
        int[] arr1 = {23, 56, 21, 41, 12};
        System.out.print("Сортировка выбором - Исходный: ");
        printArray(arr1);
        SelectionSort.selectionSort(arr1);
        System.out.print("Сортировка выбором - Результат: ");
        printArray(arr1);
        
        // Тестирование бинарного поиска
        int[] arr2 = {3, 7, 14, 21, 29, 33, 42, 55, 67, 78};
        int target = 29;
        System.out.print("\nБинарный поиск - Массив: ");
        printArray(arr2);
        int result = BinarySearch.binarySearch(arr2, target);
        System.out.println("Бинарный поиск - Элемент " + target + " найден на позиции: " + result);
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
