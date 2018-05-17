# gradle-java-multimodule
a multi module gradle java example with plugins

## build
>./gradlew clean build

## test
>./gradlew test

## Plugins
Dummy plugin to test custom plugin inclusion into main project modules

>./gradlew greeting

```
[geichhorn@com gradle-java-multimodule]$ ./gradlew greeting

> Task :server:api:greeting
Greeting from plugin

> Task :server:core:greeting
Greeting from plugin
[geichhorn@com gradle-java-multimodule]$ ./gradlew greeting

> Task :server:api:greeting
Greeting from plugin

> Task :server:core:greeting
Greeting from plugin

BUILD SUCCESSFUL in 0s
2 actionable tasks: 2 executed
[geichhorn@com gradle-java-multimodule]$ test

BUILD SUCCESSFUL in 0s
2 actionable tasks: 2 executed
[geichhorn@com gradle-java-multimodule]$ test

 ```