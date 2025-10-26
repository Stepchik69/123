#Сортировка вставками (Insertion Sort) 
class Test:
    @staticmethod
    def insertion_sort(arr):
        for i in range(1, len(arr)):
            key = arr[i]
            j = i - 1
            
            while j >= 0 and arr[j] > key:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = key
    
    @staticmethod
    def main():
        test_array = [15, 8, 42, 4, 23, 16]
        print("Исходный массив:", Test.print_array(test_array))
        Test.insertion_sort(test_array)
        print("Отсортированный массив:", Test.print_array(test_array))
    
    @staticmethod
    def print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

if __name__ == "__main__":
    Test.main()
    
    
#=========================================
#Быстрая сортировка (Quick Sort) 
class Test:
    @staticmethod
    def quick_sort(arr):
        Test._quick_sort(arr, 0, len(arr) - 1)
    
    @staticmethod
    def _quick_sort(arr, low, high):
        if low < high:
            pi = Test.partition(arr, low, high)
            Test._quick_sort(arr, low, pi - 1)
            Test._quick_sort(arr, pi + 1, high)
    
    @staticmethod
    def partition(arr, low, high):
        pivot = arr[high]
        i = low - 1
        
        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                Test.swap(arr, i, j)
        
        Test.swap(arr, i + 1, high)
        return i + 1
    
    @staticmethod
    def swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]
    
    @staticmethod
    def main():
        test_array = [24, 15, 38, 2, 19, 41, 8]
        print("Исходный массив:", Test.print_array(test_array))
        Test.quick_sort(test_array)
        print("Отсортированный массив:", Test.print_array(test_array))
    
    @staticmethod
    def print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

if __name__ == "__main__":
    Test.main()
    
 #=========================================  
 #Бинарный поиск (Binary Search) 
  
class Test:
    @staticmethod
    def binary_search(arr, target):
        left = 0
        right = len(arr) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if arr[mid] == target:
                return mid
            if arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1
    
    @staticmethod
    def main():
        test_array = [3, 7, 14, 21, 29, 33, 42, 55, 67, 78]
        targets = [29, 7, 100, 42]
        
        print("Массив:", Test.print_array(test_array))
        print()
        
        for target in targets:
            result = Test.binary_search(test_array, target)
            if result != -1:
                print(f"Элемент {target} найден на позиции: {result}")
            else:
                print(f"Элемент {target} не найден в массиве")
    
    @staticmethod
    def print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

if __name__ == "__main__":
    Test.main()
