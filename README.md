# hal-spring-example
## Example with HAL (Hypertext Application Language) based on Spring MVC and Spring Boot

### How to run? 
```sh
mvn spring-boot:run
```
### Test
<http://localhost:8080/users/1>
```sh
{  
   "id":1,
   "name":"Kowalski",
   "_links":{  
      "self":{  
         "href":"http://localhost:8080/users/1"
      },
      "update":{  
         "href":"http://localhost:8080/users/1/update?newName=newName"
      }
   },
   "_embedded":{  
      "role":{  
         "privilege":"READ_WRITE_PRIVILEGE",
         "_links":{  
            "description":{  
               "href":"http://localhost:8080/role/READ_WRITE_PRIVILEGE"
            }
         }
      }
   }
}
```
### Interesting links
* https://en.wikipedia.org/wiki/Hypertext_Application_Language
* https://en.wikipedia.org/wiki/HATEOAS
* http://docs.spring.io/spring-hateoas/docs/0.19.0.RELEASE/reference/html/#fundamentals
* https://opencredo.com/hal-hypermedia-api-spring-hateoas/


