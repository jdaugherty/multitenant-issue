## Grails 6.0.0 - Multitenant Discriminator Issue

https://github.com/grails/gorm-hibernate5/issues/781

## To Reproduce

`gradle integrationTest` 

## Expected Behavior

`AuthorService.testNotHonored` should only return 1 author since the service is annotated with `@CurrentTenant` 

