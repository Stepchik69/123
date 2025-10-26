//Сортировка выбором

public class Test {
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
        // Создаем тестовый массив
        int[] testArray = {23, 56, 21, 41, 12};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        // Сортируем массив
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


//===========================================
//Сортировка обменом (пузырьком) (Bubble Sort) 

public class Test {
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

//========================================

//Сортировка слиянием (Merge Sort) 
public class Test {
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

//=====================================
//Сортировка Шелла (Shell Sort)

public class Test {
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
//========================================
//Пирамидальная сортировка (Heap Sort)

public class Test {
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

//======================================
//Последовательный поиск (Linear Search) 
public class Test {
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
//======================================
//Интерполирующий поиск (Interpolation Search)

public class Test {
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

//======================================
//Поиск Фибоначчи (Fibonacci Search) 
public class Test {
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
