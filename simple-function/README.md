# Spring Cloud Functions

## Java based functions

* When you need to pipe functions of the same type then, Java Util Functions should suffice.

```java
public class Functions {
    Function<String, String> uppercase() {
        return message -> {
            LOGGER.info("CONVERTING STRING");
            return message.toUpperCase();
        };
    }


    Function<String, String> reverse() {
        return message -> new StringBuilder(message).reverse().toString();
    }
}

@Test
class Test{
    void testUpperCaseAndReverse() {
        final String result = functions.uppercase()
                .andThen(functions.reverse())
                .apply("takudzwa");
        assertThat(result).isEqualTo("AWZDUKAT");
    }
}
```