# example-kotlin
Kotlin example with Kotlin native query beans and finders


## What does the querybean generator generate ?

- A Query bean for each entity bean
- META-INF/ebean-generated-info.mf manifest file (to help enhancement of query beans)
- META-INF/services/io.ebean.config.ModuleInfoLoader (to auto register entity beans)