# Homework for Java Lecture #2: Spring : Spring Intro & Core (Part 1)

1. Підготувати POJO класи з анотацією `@Component`, які розміщені в пекеджі `com.epam.spring.homework1.beans` (
   біни: `BeanA`, `BeanB`, `BeanC`)
    - Кожен бін повинен мати конструктор без аргументів в якому буде виводитись на екран назва класу,
      напр: `System.out.println(this.getClass().getSimpleName());`

2. Підготувати POJO класи з анотацією @Component, які розміщенні в пекеджі:
   `com.epam.spring.homework1.other` (біни: `OtherBeanA`, `OtherBeanB`, `OtherBeanC`)
    - Кожен Other... бін повинен inject-ати біни з пекеджа beans за допомогою `@Autowired` в:
        - Конструктор (`OtherBeanA` -> `BeanA`)
          В конструкторі вивести на екран назву класу + назву залежності яка була injected, напр
           ``` java
          System.out.println(this.getClass().getSimpleName() + ". " + beanA.getClass().getSimpleName() + " was injected through the constructor");
          ```
        - Сеттер (`OtherBeanB` -> `BeanB`) В сеттері вивести на екран назву класу + назву залежності яка була injected
        - Поле (`OtherBeanC` -> `BeanC`) `OtherBeanC` повинен мати конструктор без аргументів в якому буде виведено на
          екран:
          `System.out.println(beanC)` - поміркуйте, чому значення цього об’єкту буде null.

3. Створити два файли конфігурації `@Configuration` в пекеджі `com.epam.spring.homework1.config`
4. Перший `BeansConfig` проводить скан компонентів в пекіджі beans і також імпортує `OtherConfig`.
5. Другий `OtherConfig` сканує усі компоненти з пекеджа `other`.
6. Створити декілька бінів (`Dog`, `Cat`, `Cheetah`, `Spider`) в пекеджі `pet`, які реалізовують `Animal` інтерфейс.
   Створити бін `Pet`, що буде inject-ати колекцію для створених тварин, які є впорядковані з
   використанням `@Order` (`Dog` – повинен виводитись завжди першим).
7. Створити конфігурацію `PetConfig` для бінів з п.6 (сканує усі біни окрім `Spider`). Iмпортнути
   конфігурацію `PetConfig`  у `OtherConfig`.
8. У конфігураційному класі `PetConfig` створить ще 2 біни `Cheetah` (`@Bean`), один з них повинен буде маркований
   як `@Primary`, а інший за допомогою `@Qualifier`
9. Створіть `ApplicationContext` на основі `BeansConfig` конфігурації та дістаньте з контексту бін  `Pet` на якому
   викличте метод `printPets()`.
10. *** Поексперментуйте з `PetConfig`, а саме з `@Primary` і `@Qualifier` анотаціями. Дістаньте з контексу
    бін `Cheetah` за типом, за іменем біна і проаналізуйте результат