# Java Stream API Practical Tasks

## Necessary Tools

Java Development Kit 17+

Apache Maven 3.6.0+

Git 2.24+

The following value record class defined somewhere:

    record Prop (UUID id, String name, int value){};

## Tasks

##### Stream Generation

Write a Java function `Stream<Prop> generate(int n)` that and produces stream of `n` items with randomly generated id's and incremental values, starting from 0. 

##### Flatening 

Write a Java function `Stream<UUID> toIds(List<List<Prop>>)` that returns a stream of all `id` property values of all Prop objects in the supplied structure. 

##### Counts

Write a Java function that takes `Stream<Integer>` and returns number of even numbers.

##### Shortening Operations

Write a Java function that takes an ordered `Stream<Character>` and returns `Stream<Character>` that contains the first word from the original stream.
For the purpose of this task, the word is defined as sequence of 1 or more non-whitespace characters.  

##### Indirect Mapping 

Write a Java function that takes `Stream<Prop>` and returns a `Stream<String>`.
The result stream should contains all non-null properties of the objects (e.g. `id`, `name` and `value`).

##### Sorting

Write a Java function that takes `Stream<Prop>` and returns a `List<Prop>` sorted by `value` property first then by `name`. 

##### Filter by Property

Write a Java function that takes `Stream<Prop>` and returns a `List<Prop>` where `name` is not `null` ,

##### Stateful filter

Write a Java function that takes `Stream<Prop>` and filters it, ensuring objects with duplicate id's are removed

##### Aggregation

Write a Java function that takes `Stream<Prop>` and returns the name of the object with the highest `value` property

##### Combining Collectors

Write a Java function that takes `Stream<Prop>` and returns information about name conflicts.
Name conflict is defined as having multiple items with same names but different id's.
Feel free to pick the resulting data structure as you see fit. 

##### Stateful Collectors

Write a Java function that takes `Stream<Prop>` and returns `Map<String, Integer>`. 
Keys in the returned map are taken from `name` property and values are sum of the `value` properties  

##### Collector Chaining

Write a Java function that takes `Stream<Integer>` and returns the sums of odd and even numbers.

##### Custom Aggregation

Write a Java function that takes `Stream<Prop>` and returns the names of the objects which have highest and lowest `value` property

##### Functional Transformation (Optional)

Write a java funtion that implements 'fold' operation which is defined as applying functions in sequence.  

    <T> Function<T, T> fold(Stream<Function<T, T>> functions)

For example, if 

    Function<String, String> f = fold(Stream.of(String::trim, s -> s.replace('b', 'c')));

then `f.apply("  bat") == "cat"`

##### Advanced Collectors (Optional)

Write a java function that returns a 'partitioning' Collector that splits the stream based on the provided predicate

    <T, RT, AT, RF, AF, R> Collector<T, ?, R> partitioningCollector(
            Predicate<? super T> predicate, 
            Collector<? super T, AT, RT> collTrue, 
            Collector<? super T, AF, RF> collFalse,
            BiFunction<RT, RF, R> constructor
    )

Use this collector to write a function that takes a `Stream<Integer>` and returns the sum of it's values and number of null items 
