#include <iostream>
#include <vector>
#include <random>
#include <algorithm>
#include <functional>

using namespace std;

// Функция для вычисления fitness (сумма единиц)
int fitness(const vector<bool>& individual) {
    return count(individual.begin(), individual.end(), true);
}

// Функция для инициализации случайной популяции
vector<vector<bool>> initializePopulation(int popSize, int chromosomeLength) {
    vector<vector<bool>> population(popSize, vector<bool>(chromosomeLength));
    random_device rd;
    mt19937 gen(rd());
    bernoulli_distribution dist(0.5); // 50% вероятность 0 или 1
    
    for (int i = 0; i < popSize; i++) {
        for (int j = 0; j < chromosomeLength; j++) {
            population[i][j] = dist(gen);
        }
    }
    return population;
}

// Турнирный отбор
vector<bool> tournamentSelection(const vector<vector<bool>>& population, 
                                const vector<int>& fitnessValues, 
                                int tournamentSize) {
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dist(0, population.size() - 1);
    
    vector<bool> bestIndividual;
    int bestFitness = -1;
    
    for (int i = 0; i < tournamentSize; i++) {
        int idx = dist(gen);
        if (fitnessValues[idx] > bestFitness) {
            bestFitness = fitnessValues[idx];
            bestIndividual = population[idx];
        }
    }
    return bestIndividual;
}

// Одноточечный кроссовер
pair<vector<bool>, vector<bool>> singlePointCrossover(const vector<bool>& parent1, 
                                                     const vector<bool>& parent2) {
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dist(1, parent1.size() - 2);
    
    int crossoverPoint = dist(gen);
    
    vector<bool> child1, child2;
    
    // Первая часть от parent1, вторая от parent2
    for (int i = 0; i < crossoverPoint; i++) {
        child1.push_back(parent1[i]);
        child2.push_back(parent2[i]);
    }
    
    // Вторая часть от parent2, первая от parent1
    for (int i = crossoverPoint; i < parent1.size(); i++) {
        child1.push_back(parent2[i]);
        child2.push_back(parent1[i]);
    }
    
    return make_pair(child1, child2);
}

// Мутация с заданной вероятностью
void mutate(vector<bool>& individual, double mutationRate) {
    random_device rd;
    mt19937 gen(rd());
    bernoulli_distribution dist(mutationRate);
    
    for (int i = 0; i < individual.size(); i++) {
        if (dist(gen)) {
            individual[i] = !individual[i]; // Инвертируем бит
        }
    }
}

// Поиск лучшей особи в популяции
vector<bool> findBestIndividual(const vector<vector<bool>>& population, 
                               const vector<int>& fitnessValues) {
    int bestIndex = 0;
    for (int i = 1; i < population.size(); i++) {
        if (fitnessValues[i] > fitnessValues[bestIndex]) {
            bestIndex = i;
        }
    }
    return population[bestIndex];
}

vector<bool> geneticOnes(int popSize, int generations) {
    const int CHROMOSOME_LENGTH = 10;
    const double CROSSOVER_RATE = 0.8;
    const double MUTATION_RATE = 0.1;
    const int TOURNAMENT_SIZE = 3;
    
    // Инициализация случайной популяции
    vector<vector<bool>> population = initializePopulation(popSize, CHROMOSOME_LENGTH);
    vector<bool> bestIndividual;
    
    for (int gen = 0; gen < generations; gen++) {
        // Оценка fitness для каждой особи
        vector<int> fitnessValues(popSize);
        for (int i = 0; i < popSize; i++) {
            fitnessValues[i] = fitness(population[i]);
        }
        
        // Поиск лучшей особи
        bestIndividual = findBestIndividual(population, fitnessValues);
        
        // Вывод информации о текущем поколении
        cout << "Поколение " << gen + 1 << ": лучший fitness = " 
             << fitness(bestIndividual) << endl;
        
        // Создание нового поколения
        vector<vector<bool>> newPopulation;
        
        // Элитизм: сохраняем лучшую особь
        newPopulation.push_back(bestIndividual);
        
        // Заполняем остальную часть популяции
        while (newPopulation.size() < popSize) {
            // Отбор родителей
            vector<bool> parent1 = tournamentSelection(population, fitnessValues, TOURNAMENT_SIZE);
            vector<bool> parent2 = tournamentSelection(population, fitnessValues, TOURNAMENT_SIZE);
            
            // Кроссовер
            pair<vector<bool>, vector<bool>> children;
            random_device rd;
            mt19937 gen(rd());
            bernoulli_distribution crossoverDist(CROSSOVER_RATE);
            
            if (crossoverDist(gen)) {
                children = singlePointCrossover(parent1, parent2);
            } else {
                children = make_pair(parent1, parent2);
            }
            
            // Мутация
            mutate(children.first, MUTATION_RATE);
            mutate(children.second, MUTATION_RATE);
            
            // Добавляем детей в новую популяцию
            newPopulation.push_back(children.first);
            if (newPopulation.size() < popSize) {
                newPopulation.push_back(children.second);
            }
        }
        
        population = newPopulation;
        
        // Проверка на сходимость (если нашли идеальное решение)
        if (fitness(bestIndividual) == CHROMOSOME_LENGTH) {
            cout << "Найдено идеальное решение на поколении " << gen + 1 << endl;
            break;
        }
    }
    
    // Возвращаем лучшую особь из последнего поколения
    vector<int> finalFitness(popSize);
    for (int i = 0; i < popSize; i++) {
        finalFitness[i] = fitness(population[i]);
    }
    return findBestIndividual(population, finalFitness);
}

int main() {
    // Параметры генетического алгоритма
    const int POPULATION_SIZE = 50;
    const int GENERATIONS = 100;
    
    cout << "Запуск генетического алгоритма для поиска битовой строки с максимальной суммой единиц" << endl;
    cout << "Размер популяции: " << POPULATION_SIZE << endl;
    cout << "Количество поколений: " << GENERATIONS << endl;
    cout << "Длина хромосомы: 10" << endl << endl;
    
    vector<bool> result = geneticOnes(POPULATION_SIZE, GENERATIONS);
    
    cout << endl << "Результат:" << endl;
    cout << "Лучшая найденная строка: ";
    for (bool bit : result) {
        cout << bit;
    }
    cout << endl;
    cout << "Сумма единиц: " << fitness(result) << endl;
    cout << "Максимально возможная сумма: 10" << endl;
    
    return 0;
}
