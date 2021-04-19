# PairTheeSocks

## How to run

Run 

```shell script
./gradlew build run --args=[Your colors]
```

Example of what to input and what the output should be:
```shell script
./gradlew build run --args='red red pink pink pink pink pink pink yellow yellow yellow green blue blue blue sapphire'
```

OUTPUT:
```shell script
red: 1 pair, pink: 3 pairs, blue: 1 pair, yellow: 1 pair
```

To run test:
```shell script
./gradlew test
```