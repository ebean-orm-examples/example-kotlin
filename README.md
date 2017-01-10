# example-kotlin
Kotlin example with Kotlin native query beans and finders


## to generate query beans

```
mvn -Dpackage=org.example.domain -Dlang=kt ebean:generate-querybeans
``` 

## to generate finders (and link to entity beans)

```
mvn -Dpackage=org.example.domain -Dlang=kt ebean:generate-finders
```